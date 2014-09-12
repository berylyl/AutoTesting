package jm.cotroller;

import java.util.ArrayList;
import java.util.HashMap;

import jm.bean.CaseVM;
import jm.bean.ProjectVM;
import jm.bean.SuiteVM;
import jm.service.CaseService;
import jm.service.CaseServiceImpl;
import jm.service.ProjectServiceImpl;
import jm.service.SuiteServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProjectController{

    @Autowired
    private ProjectServiceImpl  projectServiceImpl;

   
    @RequestMapping("/queryProjectAll")
	public ModelAndView queryProjectAll() {
    	ArrayList<ProjectVM> projectAll = projectServiceImpl.queryProjectAll();
    	System.out.println(projectServiceImpl);
    	ModelAndView mv = new ModelAndView("menu");
    	mv.addObject("projectVMs", projectAll);
    	return mv;
    }
    
 
}