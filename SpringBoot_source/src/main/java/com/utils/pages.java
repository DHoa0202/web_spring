package com.utils;

public enum pages {
	home("home/home", "home", "homeForm", "homes"),
	account("account/home", "account", "accountForm", "accounts"),
	category("category/home", "category", "categoryForm", "categories"),
	product("product/home", "product", "productForm", "products"),
	order("order/home", "order", "orderForm", "orders"),
	detail("orderDetail/home", "orderDetail", "orderDetailForm", "orderDetails");

	public String path;
	public String value;
	public String form;
	public String list;

	private pages(String path, String value, String form, String list) {
		this.path = path;
		this.value = value;
		this.form = form;
		this.list = list;
	}

}
