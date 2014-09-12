package jm.service;

import java.io.File;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import jm.bean.ProjectVM;
import jm.bean.SuiteVM;

@Service
public interface SuiteService {

	void createSuite(SuiteVM projectVM);
	void updateSuite();
	ArrayList<SuiteVM>  querySuiteAll();
	void deleteSuiteByName(String name);
	ArrayList<SuiteVM> querySuiteByProjectName(String projectName);
	
}
