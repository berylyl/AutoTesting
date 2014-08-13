package jm.bean;

import java.util.ArrayList;

public class Job {
	private Integer id;
	private String name;
	private String description;
	private boolean keepDependencies = false;
	private ScmConfig scm;
	private boolean canRoam = true;
	private boolean disabled = false;
	private boolean blockBuildWhenDownstreamBuilding = false;
	private boolean  blockBuildWhenUpstreamBuilding =false;
	private boolean  concurrentBuild = false;
	private Builders builder;
	
	
	
	
	public static class SCMConfig{
		
		
	}
	
	public static class Builders{
		private String shellCommand = "";
	}
	
	private ArrayList<String> steps = new ArrayList<String>();
	
	public Job(String name,String desc) {

	}
	
}
