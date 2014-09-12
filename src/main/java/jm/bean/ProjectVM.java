package jm.bean;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component 
public class ProjectVM {
	private String ProjectName;
	private ArrayList<SuiteVM> projectSuite;
	
	
	public ProjectVM() {

	}
	
	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public ArrayList<SuiteVM> getSuite() {
		return projectSuite;
	}

	public void setSuite(ArrayList<SuiteVM> projectSuite) {
		this.projectSuite = projectSuite;
	}

	public static void main(String[] args) throws IOException {
		ProjectVM projectVM = new ProjectVM();
		System.out.println(projectVM.getProjectName());
		
	}

}
