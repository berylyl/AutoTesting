package jm.bean;

import java.util.ArrayList;

public class Case {
	private Integer id;
	private String name;
	private ArrayList<String> actions = new ArrayList<String>();

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
	public ArrayList<String> getAction() {
		return actions;
	}
	public void setAction(String action) {
		actions.add(action);
	}

}
