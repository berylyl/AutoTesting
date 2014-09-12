package jm.util;

import org.apache.commons.collections.map.HashedMap;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class XmlUtils {
    static Document document = null;

    public XmlUtils() {
    }

    public static Document xmlSource(Object input) {
        try {
            SAXReader saxReader = new SAXReader();
            if (input instanceof URL) {
                document = saxReader.read((URL) input);
            } else if (input instanceof File) {
                document = saxReader.read((File) input);
            }else if(input instanceof String){
                System.out.println(input);
                document = saxReader.read(new File((String) input));
                
            }
        } catch (Exception e) {
            throw new JMException("get Source err..." + e.getMessage());
        }
        return document;
    }

    public static Element getRootElement(Document document) {
        return document.getRootElement();
    }

    public static String getSingleElementValue(Element e, String... path) {
        String fullPath = "";
        for (String s : path) {
            fullPath = fullPath.concat("/").concat(s);
            e = e.element(s);
        }

        if (e == null) {
            throw new JMException("Document does not contain element on path: " + fullPath);
        }
        return e.getText();
    }

    public static HashedMap getAllElementValue(Element e, String... path) {
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

    public static ArrayList<Element> getGroupElements(Element e, String... path) {
        for (String s : path) {
            e = e.element(s);
        }
        ArrayList es = new ArrayList<Element>();
        int num = -1;
        for (Iterator<Element> iter = e.elementIterator(); iter.hasNext();) {
            es.add((Element) iter.next());
            num++;
        }
        return es;
    }

    // ceate a xml document
    public static Document createDocument() {
        document = DocumentHelper.createDocument();
        document.setXMLEncoding("UTF-8");
        return document;
    }

    public static Element setRootElement(Document document, String root, HashMap<Object, Object> hm) {
        Element rootElement = document.addElement(root);
        for (Object o : hm.keySet()) {
            rootElement.addAttribute(o.toString(), hm.get(o).toString());
        }
        return rootElement;
    }

    public static Element setElementNode(Element element, String node) {
        return element.addElement(node);
    }

    public static Element setElementAttribute(Element element, HashMap<Object, Object> hm) {
        for (Object o : hm.keySet()) {
            element.addAttribute(o.toString(), hm.get(o).toString());
        }
        return element;
    }

    public static Element setElementText(Element element, String text) {
        return element.addText(text);
    }

    public static int writeDocumentToFile(Document document, String path) {

        OutputFormat format = OutputFormat.createPrettyPrint(); // 设置压缩形格式
        format.setEncoding("utf-8");// 设置编码
        format.setTrimText(false);// 设置text中是否要删除其中多余的空格

        // FileWriter writer = new FileWriter(path);
        FileWriter writer;
        try {
            writer = new FileWriter(path);
            XMLWriter output = new XMLWriter(writer, format); // 保存xml
            output.write(document);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;

    }

    // update xml value

    public static void main(String[] args) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("/Users/yinlu/Documents/workspace/smeller/smeller-web/src/main/resources/TestProject/JumeiShopping/caseDate/loginCase.xml");
        Element root = read.getRootElement();
        HashedMap allElementValue = XmlUtils.getAllElementValue(root, "steps","stepa");
        String selecorPath = "";
        for(Object o:allElementValue.keySet()){
            if(o.toString().equalsIgnoreCase("selector")){
                selecorPath=(String) allElementValue.get(o.toString());
            }
            //System.out.println(o);
            //System.out.println(allElementValue.get(o));
            //System.out.println("ddd==================");
        }
        String[] split = selecorPath.split("\\.",2);
        System.out.println(split[0]+"    "+split[1]);
       
        
        Document read2 = saxReader.read(new File("/Users/yinlu/Documents/workspace/smeller/smeller-web/src/main/resources/TestProject/JumeiShopping/caseObject/"+split[0]+".xml"));
        Element e= read2.getRootElement();

        
        
       // Document doc = xmlSource("/Users/yinlu/Documents/workspace/smeller/smeller-web/src/main/resources/TestProject/JumeiShopping/caseObject/"+split[0]+".xml");
        Iterator elementIterator = e.elementIterator("Object"); 
        while (elementIterator.hasNext()) {
            Element itemEle = (Element) elementIterator.next();
            if(itemEle.attributeValue("Text").equals(split[1]));{
                System.out.println(itemEle.attributeValue("Name"));
                
            }
        }
        /*
        Element element = document.getRootElement();
        System.out.println(element);
         * Document doc = XmlUtils.createDocument();
         * HashMap<Object, Object> hm = new HashMap<>();
         * hm.put("name", "case1");
         * XmlUtils.writeDocumentToFile(doc,
         * "/Users/yinlu/Documents/workspace/AutoTesting/src/main/resources/case.xml");
         */
    }
}
