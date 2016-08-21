package cn.gov.hrss.ln.stuenroll.xml;

import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

public class XMLParseService<T> extends DefaultHandler {
	private T t = null;
	@Override
	public void startDocument() throws SAXException {
		
	}
}
