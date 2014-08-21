package jm.runner;


public class UIElement {
	String eElementType = "";
	String eElementOpt = "";

	public UIElement() {
	}

	public void setElementElementType(String value) {
		this.eElementType = value;
	}

	public String getElementElementType() {
		return this.eElementType;
	}
	
	
	public void setElementElementOpt(String value) {
		this.eElementType = value;
	}

	public String getElementElementOpt() {
		return this.eElementType;
	}

	public static UIElement valueof(String type,String opt) {
		UIElement p = new UIElement();
		p.setElementElementType(type);
		p.setElementElementType(opt);
		return p;
	}
	
	public static UIElement valueof(ElementType type,ElementOpt opt) {
		UIElement p = new UIElement();
		p.setElementElementType(type.toString());
		p.setElementElementType(opt.toString());
		return p;
	}

	public static enum ElementType {
		browser,text,textarea,button,link
	}
	public static enum ElementOpt {
		start,close,click,doubleClick,input,isExist,isNotExist
	}

	public static void main(String[] args) {
		UIElement UIE = UIElement.valueof(ElementType.browser, ElementOpt.click);
	}
}
