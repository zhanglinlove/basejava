package com.audition;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Test6 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parse = factory.newSAXParser();
		InputStream stream = Test6.class.getResourceAsStream("book.xml");
		SAXParserHandler handler = new SAXParserHandler();
		parse.parse(stream, handler);
		for (Book book : handler.getBookList()) {
            System.out.println(book.getId());
            System.out.println(book.getName());
            System.out.println(book.getAuthor());
            System.out.println(book.getYear());
            System.out.println(book.getPrice());
            System.out.println(book.getLanguage());
            System.out.println("----finish----");
        }
	}

}
