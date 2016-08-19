package com.bitwise.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
	@Autowired
	UserValidator uservalidator;

	@RequestMapping(value = {"/", "/Login"}, method = RequestMethod.GET)
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView("Login");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute User user, BindingResult result,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		uservalidator.validate(user, result);
		if (result.hasErrors()) {
			mav.setViewName("Login");
		}
		if (user.getUsername().equals("ria") && user.getPassword().equals("1234")) {
			mav.addObject("msg", "welcome  " + user.getUsername());
			mav.addObject("ProductsList", new ProductsList());
			 session = request.getSession();
			mav.setView(new RedirectView("app/Success"));
		} 
		else {
			mav.addObject("error", "Invalid Details");
			mav.setViewName("Login");
		}
		return mav;
	}
	@RequestMapping(value="/app/Logout")
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		mav.setViewName("Login");
		User user = new User();
		mav.addObject("user", user);
		request.getSession().invalidate();
		return mav;

	}
	
}
