package com.photo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.photo.model.Mail;

@Controller
public class SuccessController {
	
	private static final Logger LOG = LoggerFactory.getLogger(SuccessController.class);
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String successPage(Model model) {
		LOG.info("Entering FormController");
		model.addAttribute("mail", new Mail());
		return "success";
	}

}
