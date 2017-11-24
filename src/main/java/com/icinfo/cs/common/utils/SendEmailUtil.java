package com.icinfo.cs.common.utils;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendEmailUtil {

	public final static String host = "smtp.yeah.net";

	public final static String from = "testsendmail@yeah.net";
	public final static String username = "testsendmail";
	public final static String password = "107105li";

	/**
	 * 发送邮件带附件
	 * 
	 * @param receive
	 * @param file
	 * @throws Exception
	 */
	public static void send(String receive, FileSystemResource file, String companyName) throws Exception {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

		// 设定mail server
		senderImpl.setHost(host);

		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");

		// 设置收件人，寄件人
		messageHelper.setTo(receive);
		messageHelper.setFrom(from);
		messageHelper.setSubject("国家企业信用信息公示系统-企业报告");
		// true 表示启动HTML格式的邮件
		String date = DateUtil.dateToString(new Date(), "yyyy年MM月dd日");
		messageHelper.setText("<html><head></head><body><h4>您好:</h4>" + "&nbsp;&nbsp;您正在国家信用公示系统中获取的" + companyName
				+ " 报告已经生成,请在附件中下载查看。查询更多企业信息,请访问 http://gsxt.zjaic.gov.cn<br>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<div style='float:right'>浙江工商总局<br> " + date + "</div></body></html>", true);
		senderImpl.setUsername(username); // 根据自己的情况,设置username
		senderImpl.setPassword(password); // 根据自己的情况, 设置password
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.timeout", "25000");
		senderImpl.setJavaMailProperties(prop);
		messageHelper.addAttachment(companyName + "报告.pdf", file);
		senderImpl.send(mailMessage);
		System.out.println("邮件发送成功..");

	}

	/**
	 * 发送邮件(邮件管理功能)
	 * 
	 * @param receive
	 * @param file
	 * @throws Exception
	 */
	public static void send(String receive, String content) throws Exception {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

		// 设定mail server
		senderImpl.setHost(host);

		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");

		// 设置收件人，寄件人
		messageHelper.setTo(receive);
		messageHelper.setFrom(from);
		messageHelper.setSubject("测试邮件管理功能");
		messageHelper.setText(content);
		senderImpl.setUsername(username); // 根据自己的情况,设置username
		senderImpl.setPassword(password); // 根据自己的情况, 设置password
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.timeout", "25000");
		senderImpl.setJavaMailProperties(prop);
		senderImpl.send(mailMessage);
		System.out.println("邮件发送成功..");

	}

	public static void main(String[] args) throws Exception {
		FileSystemResource file = new FileSystemResource(new File("D:/createSamplePDF.pdf"));
		send("361942158@qq.com", file, "dd");// 测试
	}

}
