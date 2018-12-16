package com.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
/**
 * stax解析xml.
 * a.表示文档的开始：XMLStreamConstants.START_DOCUMENT。
b.表示元素的开始：XMLStreamConstants.START_ELEMENT。
c.表示元素字符：XMLStreamConstants.CHARACTERS。
d.表示元素的结束：XMLStreamConstants.END_ELEMENT。
e. 表示文档的结束：XMLStreamConstants.END_DOCUMENT。
 * @author zhanglin
 *
 */
public class XmlParse {

	public static void main(String[] args) {
		String str = System.getProperty("user.dir");
		str += File.separator + "config" + File.separator + "book.xml";
		try {
			URL url = new URL("file",null,str);
			InputStream input = url.openStream();
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader read = factory.createXMLStreamReader(input);
			while (read.hasNext()) {
				int event = read.next();
				if (event == XMLStreamConstants.START_ELEMENT) {
					QName name = read.getName();
					System.out.println(name);
				} else if (event == XMLStreamConstants.CHARACTERS) {
					String value = read.getText();
					System.out.println(value);
				}
			}
		} catch (IOException | XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
