package jm.bean;

import java.util.ArrayList;

import jm.util.FileUtils;
import jm.util.GlobalParameter;

import org.springframework.stereotype.Component;

@Component
public class SuiteVM {
	private Integer id;
	private String suiteName;
	private String suiteNote;
	private String createTime;
	private String createPerson;
	private ProjectVM projectVM;
	private ArrayList<CaseVM> cases = new ArrayList<CaseVM>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSuiteName() {
		return suiteName;
	}
	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}
	public ArrayList<CaseVM> getCases() {
		return cases;
	}
	public void setCases(CaseVM cs) {
		cases.add(cs);
	}
	public String getSuiteNote() {
		return suiteNote;
	}
	public void setSuiteNote(String suiteNote) {
		this.suiteNote = suiteNote;
	}
	public String getCreateTime() {
		String projectName = projectVM.getProjectName();
		String suitePath=GlobalParameter.testDataPath+GlobalParameter.fileSeparator+projectName;
		String createTime = FileUtils.getCreateTime(suitePath);
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public ProjectVM getProjectVM() {
		return projectVM;
	}
	public void setProjectVM(ProjectVM projectVM) {

		this.projectVM = projectVM;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}


}
