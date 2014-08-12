package jm.util;

import org.apache.commons.collections.map.HashedMap;
import org.apache.xerces.util.StAXInputSource;
import org.dom4j.io.SAXReader;
import org.dom4j.*;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class xmlUtil {

	private File inputXml;

	Document document = null;

	public xmlUtil(File inputXml) {
		this.inputXml = inputXml;
	}

	public Document getDocument() {
		SAXReader saxReader = new SAXReader();
		try {
			document = saxReader.read(inputXml);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		System.out.println(document);
		return document;
	}

	public Element getRootElement() {
		return document.getRootElement();
	}

	public String getSingleElementValue(String... path) {
		Element e = getRootElement();
		for (String s : path) {
			e = e.element(s);
		}
		return e.getText();
	}

	public HashedMap getAllElementValue(String... path) {
		Element e = getRootElement();
		for (String s : path) {
			e = e.element(s);
		}
		List<Element> elements = e.elements();

		HashedMap hme = new HashedMap();
		for (Element es : elements) {
			hme.put(es.getName(), es.getText());
		}
		return hme;
	}

	public static void main(String[] args) {
		/*
		xmlUtil xml = new xmlUtil(new File("/Users/yinlu/Documents/workspace/pixie.client/src/test/resources/jm.util/misterx.xml"));
		xml.getDocument();
		String e = xml.getSingleElementValue("address","email");
		System.out.println(e);
		
		HashedMap alle = xml.getAllElementValue("property");
		System.out.println(alle.get("auto"));
		*/
		SAXReader reader = new SAXReader();
		URL url;
		try {
			url = new URL("http","192.168.11.65:8081","/user/berylyl/api/xml");
			Document doc = reader.read(url);	
			System.out.println(doc.getRootElement().getText());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
