package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beans.*;
import com.model.SessionService;
import com.model.dao.*;
import com.utils.pages;
import com.utils.parts;

@Controller
public class A_Control {

	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private OrderDetailDAO orderDetail;
	@Autowired
	SessionService session;

	@RequestMapping(value = { "/", "/pages/{page}" })
	public String getPart(Model model, String cgsId, @PathVariable(required = false) String page) {
		this.setAttribute(pages.home.path); // set attribute part page
		this.setModelData(model); // set attribute data
		return parts.INDEX;
	}

	@RequestMapping({ "/product/home", "/product/page" })
	public String productHome(Model model) {
		this.setAttribute(pages.product.path);
		this.setModelData(model); // set attribute data
		return parts.INDEX;
	}

	@GetMapping("/manager/{page}")
	public String manager(Model model, @PathVariable("page") String page) {
		session.set(parts.content.value, parts.getPage("manager/" + page));
		this.setAttr(model, page);
		return parts.INDEX;
	}

	// _____________________________________________________________________
	// part session's page
	private void setAttribute(String pageContent) {
		session.set(parts.top.value, parts.NAVBAR);
		session.set(parts.content.value, parts.getPage(pageContent));
		session.set(parts.bellow.value, parts.FOOTER);
	}

	// add data
	private void setModelData(Model model) {
		model.addAttribute("categories", categoryDAO.findAll());
		model.addAttribute("products", productDAO.findAll());

		if(session!=null) { // before flushing...
			Account account = (Account) session.get(pages.account.value);
			if(account!=null) model.addAttribute("orders", orderDAO.findByAccount(account));
		}
	}

	// get model attribute
	private void setAttr(Model model, String page) {
		switch (page) {
		case "account":
			model.addAttribute(pages.account.form, parts.newAccount());
			model.addAttribute(pages.account.list, accountDAO.findAll());
		case "category":
			model.addAttribute(pages.category.form, new Category());
			model.addAttribute(pages.category.list, categoryDAO.findAll());
		case "product":
			model.addAttribute(pages.product.form, new Product());
			model.addAttribute(pages.product.list, productDAO.findAll());
		case "order":
			model.addAttribute(pages.order.form, new Order());
			model.addAttribute(pages.order.list, orderDAO.findAll());
		case "orderDetail":
			model.addAttribute(pages.detail.form, new OrderDetail());
			model.addAttribute(pages.detail.list, orderDetail.findAll());
		default:
		}
	}
}
