package jm.cotroller;

import java.util.ArrayList;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


//@Controller
public class CaseController{

    @Autowired
    private CaseServiceImpl  caseServiceImpl;
    
    
    @RequestMapping("/createCase")
	public String createCase() {
		return "createCase";
	}
    
    
    
    @RequestMapping(value="/query")
    public ModelAndView querySuiteByProjectName(@RequestParam("suite")  String suiteName) {
        ModelAndView mv = new ModelAndView("queryCase");
        ArrayList<CaseVM> caseAll = caseServiceImpl.queryCaseBySuiteName(suiteName);
        mv.addObject("caseList",caseAll );
        return mv;
    }
    
    
    @RequestMapping("/saveCase")
	public ModelAndView saveCase(CaseVM caseVM) {
    	CaseService caseService = new CaseServiceImpl();
    	String caseName = caseVM.getCaseName();
    	ModelAndView mv = new ModelAndView("queryCase");
    	if(caseName!=null && caseName.length() >0){
    		caseService.createCase(caseVM);
    		mv.addObject("0",caseVM.getCaseName());
    	}else{
    		mv.addObject("1",caseVM.getCaseName());
    	}
    	return mv;
	}
    
    @RequestMapping("/queryCase")
	public ModelAndView queryCase(CaseVM caseVM) {
    	ModelAndView mv = new ModelAndView("result");
    	System.out.println(caseVM.getCaseName());
    	mv.addObject("resultDesc",caseVM.getCaseName());
    	return mv;
    }
    /*
    @RequestMapping("/queryCaseAll")
	public ModelAndView queryCaseAll() {
    	ArrayList<ProjectVM> projectAll = caseServiceImpl.queryProjectAll();
    	System.out.println(caseServiceImpl);
    	ModelAndView mv = new ModelAndView("menu");
    	mv.addObject("projectVMs", projectAll);
    	return mv;
    }*/

   
}