package com.photo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.photo.helpers.ImageBuilder;
import com.photo.helpers.MailBuilder;
import com.photo.model.Mail;

@Controller
public class FormController {
	
	private static final Logger LOG = LoggerFactory.getLogger(FormController.class);
	
	@Autowired
	MailBuilder mailBuilder;
	
	@Autowired
	ImageBuilder imgBuilder;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloWorld(Model model) {
		LOG.info("Entering FormController");
		model.addAttribute("mail", new Mail());
		imgBuilder.getGalleryImages();
		return "index";
		
	}
	
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public String update(@ModelAttribute Mail mail) {
		LOG.info("Entering form submit");
		mailBuilder.saveMailDetails(mail);
		return "redirect:success";
	}

}
