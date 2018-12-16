package com.audition;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test5 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		InputStream stream = Test5.class.getResourceAsStream("book.xml");
		Document document = builder.parse(stream);
		
		NodeList list = document.getElementsByTagName("book");
		int len = list.getLength();
		System.out.println("一共" + len + "本书");
		for (int i = 0; i < len; i++) {
			Node node = list.item(i);
			NodeList childList = node.getChildNodes();
			int v = childList.getLength();
			for (int j = 0; j < v; j++) {
				Node m = childList.item(j);
				if (m.getNodeType() == node.ELEMENT_NODE)
					System.out.println(m.getNodeName() + ":" + m.getTextContent() + "\t");
			}
		}
	}
}
