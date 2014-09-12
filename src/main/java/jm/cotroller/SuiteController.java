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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/suite")
public class SuiteController{

    @Autowired
    private SuiteServiceImpl  suiteServiceImpl;
    
    @RequestMapping(value="/query")
	public ModelAndView querySuiteByProjectName(@RequestParam("project")  String proName) {
    	ModelAndView mv = new ModelAndView("querySuite");
    	ArrayList<SuiteVM> suiteAll = suiteServiceImpl.querySuiteByProjectName(proName);
    	mv.addObject("suiteList",suiteAll);
		return mv;
	}
    
    @RequestMapping(value="/{pro}")
    //@RequestMapping(value="/{pro}")
	public ModelAndView querySuiteByProject1(ProjectVM pro) {
    	System.out.println(pro);
		return null;
	}
    
}