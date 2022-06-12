package com.utils;

import com.beans.*;

public enum parts {
	// set name part
	top("topPage"), content("contentPage"), bellow("bellowPage"), // components
	mesTitle("mesTitle"), mesContent("mesContent"); // message

	public String value;

	private parts(String value) {
		this.value = value;
	}

	// page return
	public static final String INDEX = "index";
	public static final String RIDIRECT = "redirect:/";

	public static final String RIDIRECT(String path) {
		return String.format("redirect:/pages/{%s}", path);
	};

	// set value part
	public static final String NAVBAR = "/parts/navbar.jsp";
	public static final String FOOTER = "/parts/footer.jsp";

	// create path variable
	public static Object getPage(String page) {
		return String.format("/pages/%s.jsp", page);
	}

	public static Account newAccount() {
		return new Account();
	}

	public static Category newCategory() {
		return new Category();
	}

	public static Product newProduct() {
		return new Product();
	}

	public static Order newOrder() {
		return new Order();
	}
}
