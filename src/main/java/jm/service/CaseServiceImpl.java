package jm.service;

import java.util.ArrayList;

import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;

import jm.bean.CaseVM;
import jm.bean.SuiteVM;
import jm.util.FileUtils;
import jm.util.XmlUtils;

public class CaseServiceImpl implements CaseService {
	
	
	@Autowired
	private XmlUtils xmlUtils;
	private FileUtils fileUtils;

	@Override
	public void createCase(CaseVM caseVM) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryCaseAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryCaseByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCaseByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryCaseBySuite(SuiteVM suite) {
		String name = suite.getSuiteName();
		
	}

    @Override
    public ArrayList<CaseVM> queryCaseBySuiteName(String name) {
        return null;
        // TODO Auto-generated method stub
        
    }


}
