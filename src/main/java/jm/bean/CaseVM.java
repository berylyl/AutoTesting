package jm.bean;

import java.util.List;

public class CaseVM
{
	private String caseId;
	private String caseName;
	private String caseDesc;
	private String caseNote;
	private List<StepVM> steps;
	
	public CaseVM() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public String getCaseDesc() {
		return caseDesc;
	}
	public void setCaseDesc(String caseDesc) {
		this.caseDesc = caseDesc;
	}
	
	public String getCaseNote() {
		return caseNote;
	}
	public void setCaseNote(String caseNote) {
		this.caseNote = caseNote;
	}
	public List<StepVM> getSteps()
	{
		return steps;
	}
	public void setSteps(List<StepVM> steps)
	{
		this.steps = steps;
	}
}
