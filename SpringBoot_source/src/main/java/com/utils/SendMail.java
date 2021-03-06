package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * <h1 style="color: red; width: 100%; text-align: center; font-size: 3em;">
 * Gửi email
 * </h1>
 * <hr>
 * <h2 style="margin: 0;">
 * B1: Bật xác minh 2 bước và mật khẩu ứng dụng nếu tài khoản chưa bật
 * <a href='https://myaccount.google.com/u/security'>tại đây</a>
 * </h2>
 * <hr>
 * 
 * <h2 style="margin: 0;">B2: add thư viện</h2>
 * <h3 style="margin: 0;">pom.xml</h3>
 * <code>
 * <dependency>
 * 		<groupId>org.springframework.boot</groupId>
 * 		<artifactId>spring-boot-starter-mail</artifactId>
 * </dependency>
 * </code>
 * <hr>
 * 
 * <h2 style="margin: 0;">B3: Tiến hành gửi email</h2>
 * <strong>Tham số bắt buộc: <em>username, password, toMails</em>:
 * </strong> các giá trị ban đầu cần gửi thông tin.<br>
 * <strong>username:</strong> địa chỉ gửi email.<br>
 * <strong>password:</strong> mật khẩu email cần gửi.<br>
 * <strong>toMails:</strong> các địa chỉ email nhận thư.
 * Gọi tới: <strong><em>sendingMail()</en></strong> để bắt đầu gửi email
 * <hr>
 * <strong>subject</strong> : tiêu đề.<br>
 * <strong>message</strong> : nội dung.<br>
 * <strong>files</strong> : một hoặc nhiều tệp đính kèm.
 */
public class SendMail {
	
	private MimeMessage mimeMessage = null;
	private Multipart multipart = null;

	private String subject; // title
	private String message; // text content
	private File[] files; // attachments

	private String username; // email address
	private String password; // password email
	private Address[] addresses; // send mail to addresses

	// Constructor[priority: 1]
	public SendMail(String username, String password, String toMails) {
		this.setContructor(username, password, toMails);
	}
	
	// Constructor[priority: 1]
	public SendMail(String username, String password, String...toMails) {
		String mails = Arrays.toString(toMails);
		mails = mails.replace("[", "").replace("]", "").replace(" ", "");
		this.setContructor(username, password, mails);
	}
	
	// Method sending mail [priority: 3]
	public void sendingMail(Message.RecipientType recipientType) throws MessagingException, IOException {
		mimeMessage = new MimeMessage(this.createSessions());

		mimeMessage.setFrom(new InternetAddress(username));
		mimeMessage.setRecipients(addresses.length==1 ? RecipientType.TO : recipientType, addresses);

		mimeMessage.setSubject(subject, "UTF-8");
		mimeMessage.setText(message, "UTF-8");
		mimeMessage.setSentDate(new Date());
		if (files != null) {
			this.setMultipart();
			mimeMessage.setContent(multipart, "text/html;charset=UTF-8");
		}

		Transport.send(mimeMessage, username, password);
		System.out.println(String.format("The email's \"%s\" sent successfully!", this.subject));
	}
	
	// Gets and sets [priority: 2]
	public String getSubject() {
		return subject;
	}

	public String getMessage() {
		return message;
	}

	public File[] getFiles() {
		return files;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setFiles(File... files) {
		this.files = files;
	}
	
	private void setContructor(String username, String password, String toMails) {
		this.username = username;
		this.password = password;
		try {
			addresses = InternetAddress.parse(toMails);
		} catch (AddressException e) {
			e.printStackTrace();
		}
	}
	
	private Properties getProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", 587);
		return props;
	}

	private Session createSessions() {
		Properties props = this.getProperties();
		return Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}

	private void setMultipart() throws MessagingException, IOException {
		multipart = new MimeMultipart();
		multipart.addBodyPart(new MimeBodyPart(mimeMessage.getInputStream()));
		
		for(int i = 0; i < files.length; i++) {
			BodyPart bodyPart2 = new MimeBodyPart();
			bodyPart2.setDataHandler(new DataHandler(new FileDataSource(files[i])));
			bodyPart2.setFileName(files[i].getName());
			multipart.addBodyPart(bodyPart2);
		}
	}
}
