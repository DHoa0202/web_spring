package com.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.beans.Product;
import com.model.SessionService;
import com.model.dao.CategoryDAO;
import com.model.dao.ProductDAO;
import com.utils.mes;
import com.utils.pages;
import com.utils.parts;
import com.utils.mes.Align;
import com.utils.mes.Color;

@Controller
public class ProductControl {
	@Autowired
	private ProductDAO prdDAO;

	@Autowired
	private CategoryDAO cgsDAO;

	@Autowired
	SessionService session;

	@SuppressWarnings("deprecation")
	@GetMapping("/product/detail")
	public String detail(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("product", prdDAO.getById(id));
		return "index";
	}

	@RequestMapping("/product/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Product product = prdDAO.findById(id).get();
		model.addAttribute("product", product);
		model.addAttribute(pages.product.list, prdDAO.findAll());
		return "product/home";
	}

	@RequestMapping("/product/create")
	public String create(Product product) {
		prdDAO.save(product);
		return "redirect:/product/home";
	}

	@RequestMapping("/product/update")
	public String update(Product product) {
		prdDAO.save(product);
		return "redirect:/product/edit/" + product.getId();
	}

	@RequestMapping("/product/delete/{id}")
	public String create(@PathVariable("id") Integer id, Model model) {
		prdDAO.deleteById(id);
		return "redirect:/product/home";
	}

	@RequestMapping("/product/sort")
	public String sort(Model model, @RequestParam("field") Optional<String> field, @RequestParam("asc") Boolean asc) {
		model.addAttribute("field", field.orElse("id"));
		model.addAttribute("asc", asc ? false : true);
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, field.get());
		model.addAttribute(pages.product.list, prdDAO.findAll(sort));
		return "/product/home";
	}

	@RequestMapping("/product/get")
	public String sort(Model model, @RequestParam("categoryid") String categoryid) {
		List<Product> list = categoryid == null || categoryid.isEmpty() 
				? prdDAO.findAll() : prdDAO.findByCategoryId(categoryid);
		model.addAttribute(pages.category.list, cgsDAO.findAll());
		model.addAttribute(pages.product.list, list);
		session.set("categoryid", categoryid);
		return parts.INDEX;
	}

	@RequestMapping("/product/search")
	public String search(Model model, @RequestParam(value = "field", defaultValue = "name") String field,
			@RequestParam("keyworks") String keyworks) {
		List<Product> list = null;
		String categoryid = session.get("categoryid");
		try {
			switch (field) {
				case "price":
					Double price = Double.parseDouble(keyworks);
					if(categoryid.isEmpty()) list = prdDAO.findBetweenPrice(price - 1000000D, price + 1000000D);
					else list = prdDAO.findBwPriceByCateId(price - 1000000D, price + 1000000D, categoryid);
					break;
				default:
					if(categoryid.isEmpty()) {
						list = prdDAO.findLikeName("%"+keyworks+"%");
					} else {
						list = prdDAO.findLikeKByCateId("%"+keyworks+"%", categoryid);
					}
					break;
			}
		} catch (NumberFormatException e) {
			this.setMessage(model, Color.yellow, "Cảnh báo tìm kiếm", "Nhập giá không được chứa ký tự!",
					"chỉ chấp nhận tìm giá bằng số");
		}

		model.addAttribute(pages.category.list, cgsDAO.findAll());
		model.addAttribute(pages.product.list, list);
		return parts.INDEX;
	}

	// Create message
	private void setMessage(Model model, Color color, @NotNull String title, String... messages) {
		model.addAttribute(parts.mesTitle.value, mes.newMes(Align.start, color, title));
		model.addAttribute(parts.mesContent.value, mes.newMes(Align.start, color, messages));
	}
}
