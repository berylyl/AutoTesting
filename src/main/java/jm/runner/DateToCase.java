package jm.runner;

import java.io.File;
import java.util.ArrayList;

import org.dom4j.Document;
import org.dom4j.Element;

import jm.util.StringUtils;
import jm.util.xmlUtil;

public class DateToCase {
	private String importHandler;

	private String casePath;
	private String beforeHandler;
	private ArrayList<StepBean> testHandler = new ArrayList<StepBean>();
	private String afterHandler;
	
	public DateToCase(String casePath) {
		this.casePath = casePath;
	}
	
	
	public String getImportHandler() {
		return importHandler;
	}
	public void setImportHandler(String importHandler) {
		this.importHandler = importHandler;
	}
	public String getBeforeHandler() {
		return beforeHandler;
	}
	public void setBeforeHandler(String beforeHandler) {
		StringBuffer sb = new StringBuffer("\t@BeforeClass\n\t").append("public void setUp() {\n\t").append(String.format("\tSystem.out.println(\"%s\");", beforeHandler)).append("\n\t}");
		this.beforeHandler = sb.toString();
	}

	public String getAfterhandler() {
		return afterHandler;
	}
	public void setAfterhandler(String afterHandler) {
		StringBuffer sb = new StringBuffer("\t@AfterClass\n\t").append("public void tearDown {\n\t").append(String.format("\tSystem.out.println(\"%s\");", afterHandler)).append("\n\t}");
		this.afterHandler = sb.toString();
	}

	public String getTestHandler() {
		StringBuffer result= new StringBuffer("\t@Test\n\tpublic void Test() {\n\t");
		for (StepBean step:testHandler){
			result.append(step.toString()).append("\n\t");
		}
		result.append("}");
		return result.toString();
	}
	public void setTestHandler(StepBean stepBean) {
		this.testHandler.add(stepBean);
	}


	public String toStep(String name,String type,String opt,String xpath) {
		return  "this is step";
	}

	public String loadCase(){

		File dateFile = new File(casePath);
		
		String fileName = dateFile.getName();
		String caseName = fileName.substring(0, fileName.lastIndexOf("."));
		Document doc = xmlUtil.xmlSource(dateFile);
		Element caseRoot = doc.getRootElement();
		String caseDesc = caseRoot.attribute("desc").getName();
		String caseNote = caseRoot.attribute("note").getName();

		ArrayList<Element> steps = xmlUtil.getGroupElements(caseRoot,"steps");
		int num = 0;
		String stepName,stepDesc,elementType,elementOpt,elementValue,elementXpath ="";
		for(Element e: steps){
			stepName = e.attributeValue("name");
			stepDesc = e.attributeValue("desc");
			elementType = xmlUtil.getSingleElementValue(e,"type");
			elementOpt =  xmlUtil.getSingleElementValue(e,"opt");
			elementValue = xmlUtil.getSingleElementValue(e,"value");;
			elementXpath = xmlUtil.getSingleElementValue(e,"selector","xpath");
			StepBean stepBean = new StepBean(num++,stepName,stepDesc,elementType,elementOpt,elementValue,elementXpath);
			if (stepBean != null){
				this.setTestHandler(stepBean);
			}
		}
		
		this.setImportHandler(StringUtils.join("\n","import org.openqa.selenium.*;","import org.openqa.selenium.firefox.FirefoxDriver;","import org.openqa.selenium.support.ui.*;"));
		this.setBeforeHandler(caseName +" is running");
		this.setAfterhandler(caseName +" is closed");
		String caseCont = StringUtils.join("\n",getBeforeHandler(),getTestHandler(),getAfterhandler());
		return String.format("%s\npublic class %s{\n%s}\n\t",getImportHandler(),caseName,caseCont);
	}
	
	public static void main(String[] args) {
		DateToCase dtc = new DateToCase("/Users/yinlu/Documents/workspace/mavenSpringMybatiesVelocity/src/main/java/com/jumei/runner/loginCase.xml");
		
		System.out.println(dtc.loadCase());
	}
}
