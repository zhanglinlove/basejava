package com.mybatis.part02;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XPathTest {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		
		documentBuilderFactory.setValidating(true);
		documentBuilderFactory.setNamespaceAware(false);
		documentBuilderFactory.setIgnoringComments(true);
		documentBuilderFactory.setIgnoringElementContentWhitespace(false);
		documentBuilderFactory.setCoalescing(false);
		documentBuilderFactory.setExpandEntityReferences(true);
		
		DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
		builder.setErrorHandler(new ErrorHandler() {
			
			@Override
			public void warning(SAXParseException exception) throws SAXException {
				System.out.println("warning:" + exception.getMessage());
			}
			
			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				System.out.println("fatalError:" + exception.getMessage());
				
			}
			
			@Override
			public void error(SAXParseException exception) throws SAXException {
				System.out.println("error:" + exception.getMessage());
			}
		});
		
		Document document = builder.parse("src/com/mybatis/part02/inventory.xml");
		XPathFactory factory = XPathFactory.newInstance();
		XPath path = factory.newXPath();
		XPathExpression expr = path.compile("//book[author='Neal Stephenson']/title/text()");
		Object result = expr.evaluate(document, XPathConstants.NODESET);
		System.out.println("查询作者的标题是:");
		NodeList nodes = (NodeList) result;
		for (int i = 0; i < nodes.getLength(); i++) {
			System.out.println(nodes.item(i).getNodeValue());
		}
		
		System.out.println("查询1997年之后的标题");
		nodes = (NodeList) path.evaluate("//book[@year > 1997]/title/text()", document, XPathConstants.NODESET);
		for (int i = 0; i < nodes.getLength(); i++) {
			System.out.println(nodes.item(i).getNodeValue());
		}
		
		System.out.println("查询1997年之后图书属性和标题");
		nodes = (NodeList) path.evaluate("//book[@year > 1997]/@*|//book[@year > 1997]/title/text()", document, XPathConstants.NODESET);
		for (int i = 0; i < nodes.getLength(); i++) {
			System.out.println(nodes.item(i).getNodeValue());
		}
	}
}
