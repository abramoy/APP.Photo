package com.photo.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.photo.controllers.FormController;
import com.photo.dao.mappers.MailMapper;
import com.photo.model.Mail;

@Service
public class MailBuilderImp implements MailBuilder {
	
	private static final Logger LOG = LoggerFactory.getLogger(FormController.class);
	
	@Autowired
	MailMapper mailMapper;
	
	@Transactional
	@Override
	public void saveMailDetails(Mail mail) {
		LOG.info("Saving mail details");
		mailMapper.insertMail(mail);
	}

}
