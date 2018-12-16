package com.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * 写xml文档。
 * @author zhanglin
 *
 */
public class XmlWrite {

	public static void main(String[] args) throws XMLStreamException, IOException {
		writeXml();
	}
	
	public static void writeXml() throws XMLStreamException, IOException {
		String root = System.getProperty("user.dir");
		root += File.separator + "config";
		Path path = Paths.get(root, "apple.xml");
		if (!Files.exists(path)) {
			Files.createFile(path);
		}
		BufferedWriter write = Files.newBufferedWriter(path, StandardOpenOption.APPEND);
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		XMLStreamWriter stream = factory.createXMLStreamWriter(write);
		//产生xml头需要调用
		stream.writeStartDocument();
		stream.writeStartElement("apple");
		stream.writeStartElement("price");
		stream.writeCharacters("10");
		stream.writeEndElement();
		stream.writeStartElement("weight");
		stream.writeCharacters("10kg");
		stream.writeEndElement();
		stream.writeStartElement("total");
		stream.writeEndElement();
		stream.writeEndElement();
		stream.writeEndDocument();
	}
}
