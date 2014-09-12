package jm.service;

import java.util.ArrayList;


import org.springframework.stereotype.Service;

import jm.bean.ProjectVM;

@Service
public interface ProjectService {

	void createProject(ProjectVM projectVM);
	void updateProject();
	ArrayList<ProjectVM>  queryProjectAll();
	void deleteProjectByName(String name);
}
