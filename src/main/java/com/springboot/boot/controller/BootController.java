package com.springboot.boot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.boot.PasswordCheck;
import com.springboot.boot.dao.UserTableDao;
import com.springboot.boot.entity.ParamEntity;
import com.springboot.boot.entity.UserTable;

@Controller
public class BootController {

	@Autowired
	UserTableDao userTableDao;

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView view = new ModelAndView("login");
		view.addObject("name", "Login");
		return view;
	}

	@RequestMapping("/checkUser")
	@ResponseBody
	public String checkUser(@RequestBody ParamEntity entity) throws Exception {
		Optional<UserTable> data = userTableDao.findById(entity.getUsername());
		if(data.isPresent()) {
			UserTable table = data.get();
			boolean checkResult = PasswordCheck.check(entity.getPassword(), table.getPassword());
			return checkResult ? "success" : "wrong";
		} 
		return "notvalid";
	}

	@RequestMapping("/homePage")
	public ModelAndView homePage() {
		ModelAndView view = new ModelAndView("homepage");
		view.addObject("name", "Home");
		return view;
	}

	@RequestMapping("/signUp")
	public ModelAndView signUp() {
		ModelAndView view = new ModelAndView("signup");
		view.addObject("name", "Sign Up");
		return view;
	}

	@RequestMapping("/insertUser")
	@ResponseBody
	public String insertUser(@RequestBody UserTable table) throws Exception {
		Optional<UserTable> data = userTableDao.findById(table.getUserId());
		if(data.isPresent()) {
			return "already exist"; 
		} else {
			String password = PasswordCheck.getSaltedHash(table.getPassword());
			table.setPassword(password);
			userTableDao.save(table);
			return "Success";
		}
	}

}
