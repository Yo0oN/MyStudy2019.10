package com.exam.mail01;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	// fromMail에는 나의 구글이메일
	private String fromMail = "mailtest9520@gmail.com";
	// password는 나의 구글 이메일에 대한 비밀번호
	private String password = "helloMailTest*";
	// 받는이
	private String toMail;
	private String toName;
	private String searchPassword;
	private String content;
	private String searchId;

	public void setContent(String id, String password) {
		this.searchPassword = password;
		this.searchId = id;
		this.content = "id :" + searchId + "<br>password : " + searchPassword + " 입니다.";
	}

	public void sendMail(String toMail, String toName) {
		try {
			// 메일을 보낼 환경변수 설정
			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			// 인증 설정
			MyAuth auth = new MyAuth(fromMail, password);
			// Session은 하나의 접속을 의미한다.
			Session session = Session.getDefaultInstance(props, auth);

			// 메세지에 대한 설정
			MimeMessage msg = new MimeMessage(session);
			msg.setHeader("Content-type", "text/html;charset=utf-8");
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail, toName, "utf-8"));

			// 제목
			msg.setSubject("아이디+비밀번호");
			// 내용
			msg.setContent(content, "text/html;charset=utf-8");
			// 시간
			msg.setSentDate(new java.util.Date());

			// 메일보내기
			Transport.send(msg);

		} catch (UnsupportedEncodingException e) {
			System.out.println("error : " + e.getMessage());
		} catch (MessagingException e) {
			System.out.println("error : " + e.getMessage());
		}
	}
}
