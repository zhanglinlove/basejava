package com.audition;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Test7 {

	private static ArrayList<Book> booksList = new ArrayList<Book>();
	public static void main(String[] args) throws JDOMException, IOException {
		SAXBuilder saxBuilder = new SAXBuilder();
        InputStream in;
        in = Test7.class.getResourceAsStream("book.xml");
        Document document = saxBuilder.build(in);
        Element element = document.getRootElement();
        List<Element> list = element.getChildren();
        int len = list.size();
        for (int i = 0; i < len; i++) {
        	Book bookEntity = new Book();
        	Element ele = list.get(i);
        	List<Attribute> attributesList = ele.getAttributes();
        	for (Attribute attr : attributesList) {
        		String attrName = attr.getName();
        		String attrValue = attr.getValue();
        		if (attrName.equals("id")) {
                    bookEntity.setId(attrValue);
                }
        	}
        	List<Element> bookChilds = ele.getChildren();
            for (Element child : bookChilds) {
                System.out.println("节点名：" + child.getName() + "----节点值："
                        + child.getValue());
                if (child.getName().equals("name")) {
                    bookEntity.setName(child.getValue());
                }
                else if (child.getName().equals("author")) {
                    bookEntity.setAuthor(child.getValue());
                }
                else if (child.getName().equals("year")) {
                    bookEntity.setYear(child.getValue());
                }
                else if (child.getName().equals("price")) {
                    bookEntity.setPrice(child.getValue());
                }
                else if (child.getName().equals("language")) {
                    bookEntity.setLanguage(child.getValue());
                }
            }
            
            booksList.add(bookEntity);
            bookEntity = null;
            System.out.println(booksList.size());
            System.out.println(booksList.get(0).getId());
            System.out.println(booksList.get(0).getName());
            
        }

	}

}
