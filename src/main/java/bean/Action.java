package bean;

import java.util.ArrayList;

public class Action{ 
	private Integer id;
	private String name;
	private ArrayList<String> steps = new ArrayList<String>();
	
	public Action(int id,String name) {
		this.id = id;
		this.name = name ;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getSteps() {
		return steps;
	}

	public void setSteps(String step) {
		steps.add(step);
	}


}
