package com.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpServletResponse res;

	public Cookie get(String name) {
		for (Cookie c : req.getCookies()) {
			if (c.getName().equals(name))
				return c;
		}
		return null;
	}

	public String getValue(String name) {
		return this.get(name).getValue();
	}

	public Cookie add(String name, String value, int minutes) {
		Cookie c = new Cookie(name, value);
		c.setMaxAge(minutes * 60);
		res.addCookie(c);
		return c;
	}

	public void remove(String name) {
		this.get(name).setMaxAge(0);
	}
}
