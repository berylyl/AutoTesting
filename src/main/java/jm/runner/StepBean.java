package jm.runner;

public class StepBean {
	
	private Integer id;
	private String stepName;
	private String stepDesc;
	private String elementType;
	private String elementOpt;
	private String elementValue;
	private String elementSelector;
	
	public StepBean(String name,String desc) {
		// TODO Auto-generated constructor stub
	}
	public StepBean(int id,String stepName,String stepDesc,String elementType,String elementOpt,String elementValue,String elementSelector){
		
		this.id = id;
		this.stepName = stepName;
		this.stepDesc = stepDesc;
		this.elementType = elementType;
		this.elementOpt = elementOpt;
		this.elementValue = elementValue;
		this.elementSelector = elementSelector;
	}
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	public String getStepDesc() {
		return stepDesc;
	}
	public void setStepDesc(String stepDesc) {
		this.stepDesc = stepDesc;
	}
	public String getElementType() {
		return elementType;
	}
	public void setElementType(String elementType) {
		this.elementType = elementType;
	}
	public String getElementOpt() {
		return elementOpt;
	}
	public void setElementOpt(String elementOpt) {
		this.elementOpt = elementOpt;
	}
	public String getElementValue() {
		return elementValue;
	}
	public void setElementValue(String elementValue) {
		this.elementValue = elementValue;
	}
	public String getElementSelector() {
		return elementSelector;
	}
	public void setElementSelector(String elementSelector) {
		this.elementSelector = elementSelector;
	}
	@Override
	public String toString() {
		String result = "";
		result = "// Step"+String.valueOf(id)+" "+stepName;
		// TODO Auto-generated method stub
		return result==null?super.toString():result;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	public static void main(String[] args) {
		StepBean stepBean = new StepBean(0, "", "", "", "", "", "");
		System.out.println(stepBean.toString());
	}
}
