package com.photo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.photo.model.Mail;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloWorld(Model model) {
		model.addAttribute("mail", new Mail());
		return "index";
		
	}
	
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public String update(@ModelAttribute Mail mail) {
		
		System.out.println(mail.getName());
		System.out.println(mail.getEmail());
		System.out.println(mail.getSubject());
		System.out.println(mail.getMessage());
	    

	    return "index";
	}

}
