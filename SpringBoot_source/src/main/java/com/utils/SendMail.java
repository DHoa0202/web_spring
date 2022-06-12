package com.utils;

import java.io.File;
import java.io.IOException;
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
 * <strong>subject</strong> : tiêu đề.<br>
 * <strong>message</strong> : nội dung.<br>
 * <strong>files</strong> : một hoặc nhiều tệp đính kèm.
 * <hr>
 * <strong>Tham số: <em>username, password, toMails</em>:</strong> các giá trị
 * ban đầu cần gửi thông tin.<br>
 * <strong>username:</strong> địa chỉ gửi email.<br>
 * <strong>password:</strong> mật khẩu email cần gửi.<br>
 * <strong>toMails:</strong> các địa chỉ email nhận thư.
 * <hr>
 * <p>
 * <h3>pom.xml</h3>
 * <dependency>
 * 		<groupId>com.sun.mail</groupId>
 * 		<artifactId>javax.mail</artifactId>
 * 		<version>1.6.1</version>
 * </dependency>
 * </p>
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

	// Contructer
	public SendMail(String username, String password, String toMails) {
		this.username = username;
		this.password = password;
		try {
			addresses = InternetAddress.parse(toMails);
		} catch (AddressException e) {
			e.printStackTrace();
		}
	}

	// Gets and sets
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

	// Method sending mail
	public void sendingMail() throws MessagingException, IOException {
		RecipientType type = (addresses.length < 2) ? Message.RecipientType.CC : Message.RecipientType.BCC;
		mimeMessage = new MimeMessage(this.createSessions());

		mimeMessage.setFrom(new InternetAddress(username));
		mimeMessage.setRecipients(type, addresses);

		mimeMessage.setSubject(subject, "utf-8");
		mimeMessage.setText(message,"utf-8");
		mimeMessage.setSentDate(new Date());
		if (files != null) {
			this.setMultipart();
			mimeMessage.setContent(multipart);
		}

		Transport.send(mimeMessage, username, password);
		System.out.println("Da gui email");
	}
}
