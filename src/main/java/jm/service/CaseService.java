package jm.service;

import java.util.ArrayList;

import javax.xml.ws.ServiceMode;

import org.junit.runners.Suite;

import jm.bean.CaseVM;
import jm.bean.SuiteVM;

@ServiceMode
public interface CaseService {

	void createCase(CaseVM caseVM);
	void updateCase();
	void queryCaseAll();
	void queryCaseByName(String name);
	void deleteCaseByName(String name);
	void queryCaseBySuite(SuiteVM suite);
	ArrayList<CaseVM>  queryCaseBySuiteName(String name);

}
