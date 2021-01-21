package com.photo.dao.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.photo.model.Mail;

@Mapper
public interface MailMapper {
	
	@Insert("INSERT INTO MAIL (name, email, subject, message) VALUES(#{name},#{email},#{subject}, #{message})")
	@Options(useGeneratedKeys = true, keyProperty= "mailId", keyColumn= "mail_id")
	int insertMail(Mail mail);

}
