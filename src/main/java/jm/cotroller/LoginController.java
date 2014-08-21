package jm.cotroller;

import java.util.List;

import jm.bean.CaseVM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController{

    @Autowired
    //private UserService userService;

    @RequestMapping("/")
	public String welcomeRedirect() {
		return "index";
	}
    @RequestMapping("/index")
	public String indexRedirect() {
		return "index";
	}
    
    @RequestMapping("/createCase")
	public String createCase() {
		return "createCase";
	}
    
    
    @RequestMapping("/saveCase")
	public ModelAndView saveCase(CaseVM caseVM) {
    	ModelAndView mv = new ModelAndView("queryCase");
    	
    	System.out.println(caseVM.getCaseName());
    	mv.addObject("resultDesc",caseVM.getCaseName());
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