package jm.util;

import org.apache.commons.collections.map.HashedMap;
import org.dom4j.io.SAXReader;
import org.dom4j.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;


public class xmlUtil {

	static Document document = null;

	public xmlUtil(URL url) {

	}
	
	public static Document xmlSource(Object input) {
		try {
			SAXReader saxReader = new SAXReader();
			if (input instanceof URL){
				document = saxReader.read((URL)input);
			}else if(input instanceof File){
				document = saxReader.read((File)input);
			}
		} catch (Exception e) {
			throw new JMException("get Source err..."+e.getMessage());
		} 
		return document;
	}

	public static Element getRootElement(Document document) {
		return document.getRootElement();
	}

	public static String getSingleElementValue(Element e,String... path) {
		String fullPath = "";
		for (String s : path) {
			fullPath = fullPath.concat("/").concat(s);
			e = e.element(s);
		}
		
		if (e == null){
			throw new JMException("Document does not contain element on path: " + fullPath);
		}
		return e.getText();
	}

	public static HashedMap getAllElementValue(Element e,String... path) {
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
	
	public static ArrayList<Element> getGroupElements(Element e,String... path) {
		for (String s : path) {
			e = e.element(s);
		}
		ArrayList es = new ArrayList<Element>();
		int num = -1;
		for(Iterator<Element> iter = e.elementIterator();iter.hasNext();){
			es.add((Element)iter.next());
			num++;
		}
		return es;
	}
	public static void main(String[] args) {
		//file
		File file = new File("/Users/yinlu/Documents/workspace/mavenSpringMybatiesVelocity/src/main/java/com/jumei/runner/loginCase.xml");
		Document doc0 = xmlUtil.xmlSource(file);
		ArrayList<Element> steps = xmlUtil.getGroupElements(xmlUtil.getRootElement(doc0),"steps");
		for(Element e: steps){
			System.out.println(e.attributeValue("type"));
			System.out.println(e.attributeValue("type"));
			System.out.println(xmlUtil.getSingleElementValue(e,"locator","xpath"));
		}
		/*
		String e =xmlUtil.getSingleElementValue(xmlUtil.getRootElement(doc0),"address","email");
		System.out.println(e);
		HashedMap alle = xmlUtil.getAllElementValue(xmlUtil.getRootElement(doc0),"property");
		System.out.println(alle.get("auto"));
		int num = -1;
		for(Iterator<Element> iter = e.elementIterator();iter.hasNext();){
			Element step = (Element)iter.next();
			Attribute name = step.attribute("name");
			String value = name.getValue();
			System.out.println(value);
			Element xpath = step.element("locator").element("xpath");
			System.out.println(xpath.getText());
			num++;
		}*/
		
		
		//System.out.println(alle.get("xpath"));

		//url
		/*
		try {
			URL url = new URL("http","localhost",8081,"/user/berylyl/api/xml");
			Document doc = xmlUtil.xmlSource(url);
			String singleElementValue = xmlUtil.getSingleElementValue(xmlUtil.getRootElement(doc),"id");
			System.out.println(singleElementValue);
		} catch (MalformedURLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			System.out.println(ex);
		} 
		*/
	
	}
}
