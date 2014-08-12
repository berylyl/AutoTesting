package jm.bean;

import java.util.ArrayList;

public class Suite {
	private Integer id;
	private ArrayList<String> cases = new ArrayList<String>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ArrayList<String> getCases() {
		return cases;
	}
	public void setCases(String cs) {
		cases.add(cs);
	}

}
