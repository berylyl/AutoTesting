package jm.util;

import org.apache.commons.collections.map.HashedMap;
import org.apache.xerces.util.StAXInputSource;
import org.dom4j.io.SAXReader;
import org.dom4j.*;
import org.json.XML;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

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
		} catch (DocumentException e) {
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
			System.out.println(s);
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

	public static void main(String[] args) {
		//file
		File file = new File("/Users/yinlu/Documents/workspace/pixie.client/src/test/resources/jm.util/misterx.xml");
		Document doc0 = xmlUtil.xmlSource(file);
		String e =xmlUtil.getSingleElementValue(xmlUtil.getRootElement(doc0),"address","email");
		System.out.println(e);
		HashedMap alle = xmlUtil.getAllElementValue(xmlUtil.getRootElement(doc0),"property");
		System.out.println(alle.get("auto"));

		//url
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
		
	
	}
}
