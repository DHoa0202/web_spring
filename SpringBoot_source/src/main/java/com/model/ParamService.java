package com.model;

import java.io.File;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.Date;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ParamService {
	@Autowired
	public HttpServletRequest req;
	@Autowired
	public ServletContext context;

	public ParamService() {
		super();
	}

	/**
	 * Đọc chuỗi giá trị của tham số
	 * 
	 * @param name         tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public String getString(String name, String defaultValue) {
		return (name + "").isEmpty() ? defaultValue : req.getParameter(name);
	}

	/**
	 * Đọc số nguyên giá trị của tham số
	 * 
	 * @param name         tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public int getInt(String name, int defaultValue) {
		Integer result = defaultValue;
		try {
			result = Integer.parseInt(req.getParameter(name));
		} catch (NumberFormatException e) {
			System.err.println(e);
		}
		return result;
	}

	/**
	 * Đọc số thực giá trị của tham số
	 * 
	 * @param name         tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public double getDouble(String name, double defaultValue) {
		Double result = defaultValue;
		try {
			result = Double.parseDouble(req.getParameter(name));
		} catch (NumberFormatException e) {
			System.err.println(e);
		}
		return result;
	}

	/**
	 * Đọc giá trị boolean của tham số
	 * 
	 * @param name         tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public boolean getBoolean(String name, boolean defaultValue) {
		Boolean result = defaultValue;
		try {
			result = Boolean.parseBoolean(req.getParameter(name));
		} catch (NumberFormatException e) {
			System.err.println(e);
		}
		return result;
	}

	/**
	 * Đọc giá trị thời gian của tham số
	 * 
	 * @param name    tên tham số
	 * @param pattern là định dạng thời gian
	 * @return giá trị tham số hoặc null nếu không tồn tại
	 * @throws RuntimeException lỗi sai định dạng
	 */
	@SuppressWarnings("deprecation")
	public Date getDate(String name, String pattern) {
		Date result = new Date();
		try {
			result = new Date(req.getParameter(name));
		} catch (DateTimeException e) {
			System.err.println(e);
		}
		return result;
	}

	/**
	 * Lưu file upload vào thư mục
	 * 
	 * @param file chứa file upload từ client
	 * @param path đường dẫn tính từ webroot
	 * @return đối tượng chứa file đã lưu hoặc null nếu không có file upload
	 * @throws RuntimeException lỗi lưu file
	 * @throws IOException
	 */
	public File save(MultipartFile file, String path) throws RuntimeException, IOException {
		File dir = new File(context.getRealPath(path));
		if (!dir.exists())
			dir.mkdirs();
		try {
			File newFile = new File(dir, file.getOriginalFilename());
			file.transferTo(newFile);
			return newFile;
		} catch (Error e) {
			throw new RuntimeErrorException(e);
		}
	}

}
