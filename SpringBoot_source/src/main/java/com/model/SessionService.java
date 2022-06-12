package com.model;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
	@Autowired
	HttpSession session;

	public SessionService() {
		super();
	}

	/**
	 * Đọc giá trị của attribute trong session
	 * 
	 * @param name tên attribute
	 * @return giá trị đọc được hoặc null nếu không tồn tại
	 */
	public <T> T get(String name) {
		@SuppressWarnings("unchecked")
		T attribute = (T) session.getAttribute(name);
		return attribute;
	}

	/**
	 * Thay đổi hoặc tạo mới attribute trong session
	 * 
	 * @param name  tên attribute
	 * @param value giá trị attribute
	 */
	public void set(String name, Object value) {
		session.setAttribute(name, value);
	}

	/**
	 * Xóa attribute trong session
	 * 
	 * @param name tên attribute cần xóa
	 */
	@SuppressWarnings("deprecation")
	public void remove(String... names) {
		for (String name : names) {
			session.removeValue(name);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void removeAll() {
		for (String value: session.getValueNames()) {
			session.removeValue(value);
		}
	}

	public boolean check(String name) {
		return this.get(name) != null;
	}

}
