package com.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * xml文档解析。
 * @author zhanglin
 *
 */
public class XmlTest {

	public static void main(String[] args) {
		String root = System.getProperty("user.dir");
		String path = root + File.separator + "config" 
					+ File.separator + "book.xml";
		File file = new File(path);
		parseXml(file);
	}
	
	public static void parseXml(File file) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			//NodeList children = document.getChildNodes();
			NodeList children = document.getElementsByTagName("book");
			for (int i = 0; i < children.getLength(); i++) {
				Node child = children.item(i);
				System.out.println("name=" + child.getNodeName());
				if (child instanceof Element) {
					for (Node childNode = child.getFirstChild(); childNode != null; childNode = childNode.getNextSibling()) {
						String name = childNode.getNodeName();
						if (childNode.getNodeType() == Node.ELEMENT_NODE) {
							String value = childNode.getFirstChild().getNodeValue();
							System.out.println("name=" + name + ";value=" + value);
						}
						
						
					}
					
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
