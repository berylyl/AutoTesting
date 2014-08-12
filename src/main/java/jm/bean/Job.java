package jm.bean;

import java.util.ArrayList;

public class Job {
	private Integer id;
	private String name;
	private String desc;
	
	
	private ArrayList<String> steps = new ArrayList<String>();
	
	public Job(String name,String desc) {
		this.name = name;
		this.desc = desc;
	}
	
}
