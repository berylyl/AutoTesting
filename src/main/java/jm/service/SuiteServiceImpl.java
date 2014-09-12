package jm.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jm.bean.ProjectVM;
import jm.bean.SuiteVM;
import jm.bean.SuiteVM;
import jm.bean.User;
import jm.config.shellConfig;
import jm.util.FileUtils;
import jm.util.GlobalParameter;
import jm.util.XmlUtils;

@Service
public class SuiteServiceImpl implements SuiteService {
	@Autowired
	private SuiteVM suiteVM;

	@Override
	public void createSuite(SuiteVM suiteVM) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSuite() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<SuiteVM> querySuiteAll() {
		ArrayList<SuiteVM> suiteList = new ArrayList<SuiteVM>();
		ArrayList<String> suites = FileUtils
				.subDirs(GlobalParameter.testDataPath);
		for (String str : suites) {
			suiteVM = new SuiteVM();
			suiteVM.setSuiteName(str);
			suiteVM.setCreatePerson(String.format(shellConfig.dirUser,
					GlobalParameter.testDataPath
							+ GlobalParameter.fileSeparator + str));
			suiteList.add(suiteVM);
		}
		return suiteList;
	}

	@Override
	public void deleteSuiteByName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<SuiteVM> querySuiteByProjectName(String projectName) {
		ArrayList<SuiteVM> suiteList = new ArrayList<SuiteVM>();
		String projectPath = GlobalParameter.testDataPath+ GlobalParameter.fileSeparator + projectName;
		ArrayList<String> suites = FileUtils.subDirs(projectPath);
		for (String str : suites) {
			suiteVM = new SuiteVM(); 
			ProjectVM projectVM = new ProjectVM();
			projectVM.setProjectName(projectName);
			suiteVM.setProjectVM(projectVM);
			suiteVM.setSuiteName(str);
			String result;
			try {
				Process process = Runtime.getRuntime().exec(String.format(shellConfig.dirUser,projectPath+GlobalParameter.fileSeparator+str));
				process.waitFor();
				InputStreamReader ir=new InputStreamReader(process.getInputStream());
				BufferedReader read = new BufferedReader (ir);
				result = read.readLine();
				String[] res = (result.split("^\\s*$"));
				for (String strs:res){
					System.out.println(strs);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			suiteList.add(suiteVM);
			}
		return suiteList;
	}

	public static void main(String[] args) {
		SuiteServiceImpl serviceImpl = new SuiteServiceImpl();
		System.out
				.println(serviceImpl.querySuiteByProjectName("projectGroupA"));

	}
}
