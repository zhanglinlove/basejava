package com.audition;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test8 {

	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		InputStream input = Test8.class.getResourceAsStream("book.xml");
		Document document = reader.read(input);
		Element bookStore = document.getRootElement();
		Iterator it = bookStore.elementIterator();
		while (it.hasNext()) {
			Element book = (Element) it.next();
			List<Attribute> bookAttrs = book.attributes();
            for (Attribute attr : bookAttrs) {
                System.out.println("属性名：" + attr.getName() + "--属性值："
                        + attr.getValue());
            }
            Iterator itt = book.elementIterator();
            while (itt.hasNext()) {
                Element bookChild = (Element) itt.next();
                System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
            }
            System.out.println("=====结束遍历某一本书=====");
		}
	}

}
