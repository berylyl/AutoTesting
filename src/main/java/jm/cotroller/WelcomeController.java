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
public class WelcomeController{

    @Autowired
    private ProjectServiceImpl  projectServiceImpl;
    @Autowired
    private SuiteServiceImpl  suiteServiceImpl;
    
    @RequestMapping("/")
	public ModelAndView  welcomeRedirect() {
    	
    	HashMap<ProjectVM, ArrayList<SuiteVM>> menuListMap = new HashMap<ProjectVM, ArrayList<SuiteVM>>();
    	ArrayList<ProjectVM> projectAll = projectServiceImpl.queryProjectAll();
    	ModelAndView mv = new ModelAndView("menu");
    	for(ProjectVM projectVM :projectAll){
    		ArrayList<SuiteVM> suiteAll = suiteServiceImpl.querySuiteByProjectName(projectVM.getProjectName());
    		menuListMap.put(projectVM, suiteAll);
    	}
    	mv.addObject("menuList",menuListMap);
		return mv;
	}
    
    
    @RequestMapping("index")
	public String indexRedirect() {
		return "index";
	}
  
    /*
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, HttpServletRequest request) {
        String userId = request.getParameter("userId").toString();
        String passwd = request.getParameter("passwd").toString();
        user.setUserId(userId);
        user.setPasswd(passwd);
        int loginStatus = userService.validLogin(userId, passwd);
		switch (loginStatus) {
		case LOGIN_SUCCESS:
			return "/index";
		case LOGIN_UNEXIST_USER:
			return "redirect:/";
		case LOGIN_WRONG_PASSWORD:
			return "redirect:/";
		default:
			return "redirect:/";
		}
		
    }*/
}