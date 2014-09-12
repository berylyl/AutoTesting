package jm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jm.bean.ProjectVM;
import jm.bean.SuiteVM;
import jm.util.FileUtils;
import jm.util.GlobalParameter;
import jm.util.XmlUtils;



@Service
public class  ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectVM projectVM;
	

	@Override
	public void createProject(ProjectVM projectVM) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProject() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ProjectVM> queryProjectAll() {
		ArrayList<ProjectVM> proList = new ArrayList<ProjectVM>();
		ArrayList<String> projects = FileUtils.subDirs(GlobalParameter.testDataPath);
		for(String str:projects){
			ProjectVM projectVM = new ProjectVM();
			projectVM.setProjectName(str);
			proList.add(projectVM);
		}
		return proList;
	}

	@Override
	public void deleteProjectByName(String name) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		ProjectServiceImpl serviceImpl = new ProjectServiceImpl();
		System.out.println(serviceImpl.queryProjectAll());
	}

}
