package com.controller;

import java.util.Optional;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.beans.Category;
import com.model.SessionService;
import com.model.dao.CategoryDAO;
import com.utils.mes;
import com.utils.mes.*;
import com.utils.mes.Color;
import com.utils.pages;
import com.utils.parts;

@Controller
public class CategoryControl {
	@Autowired
	CategoryDAO dao;

	@Autowired
	private SessionService session;

	// get link to access categories form page
	@GetMapping("/category/{page}")
	public String getPart(Model model, @PathVariable("page") String page) {
		session.set(parts.content.value, parts.getPage("category/" + page));
		return parts.INDEX;
	}

	// sort by field
	@RequestMapping("/category/sort")
	public String sort(Model model, @RequestParam("field") Optional<String> field, @RequestParam("asc") Boolean asc) {
		model.addAttribute("field", field.orElse("id"));
		model.addAttribute("asc", asc ? false : true);
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, field.get());
		model.addAttribute(pages.category.form, parts.newCategory());
		model.addAttribute(pages.category.list, dao.findAll(sort));
		return parts.INDEX;
	}
	
	// get to edit before update category
	@GetMapping("/category/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		Category category = dao.findById(id).get();
		model.addAttribute(pages.category.form, category);
		model.addAttribute(pages.category.list, dao.findAll());
		return parts.INDEX;
	}

	@PostMapping("/category/save")
	public String save(Model model, @ModelAttribute("categoryForm") Category category) {
		category = category.getId().isEmpty() ? null : category;
		if (category == null) {
			this.setMessage(model, Color.red, "L??u lo???i s???n ph???m!", "Kh??ng l??u lo???i s???n ph???m null",
					"th??ng s??? ph???i ?????y ????? gi?? tr???");
		} else if (dao.save(category) != null) {
			model.addAttribute(pages.category.form, parts.newCategory());
			this.setMessage(model, Color.green, "L??u lo???i s???n ph???m!",
					String.format("Ph??n lo???i s???n ph???m <b>%s</b> l??u ho??n t???t!", category.getId()));
		} else {
			this.setMessage(model, Color.red, "L??u lo???i s???n ph???m!",
					String.format("L??u lo???i s???n ph???m <b>%s</b> th???t b???i!", category.getId()));
		}

		model.addAttribute(pages.category.list, dao.findAll());
		return parts.INDEX;
	}

	@SuppressWarnings("deprecation")
	@PostMapping({ "/category/delete/{id}", "/category/delete/" })
	public String deletePost(@PathVariable(value = "id", required = false) String id, Model model) {
		if (id != null) {
			Category category = dao.getById(id);
			if (category != null) {
				dao.deleteById(id);
				session.set(pages.category.form, null);
				setMessage(model, Color.green, "X??a lo???i s???n ph???m",
						String.format("???? x??a lo???i s???n ph???m <b>%s</b>", id));
			} else {
				setMessage(model, Color.red, "X??a lo???i s???n ph???m",
						String.format("Kh??ng th??? x??a lo???i s???n ph???m <b>%s</b>", id));
			}
		}

		model.addAttribute(pages.category.form, parts.newCategory());
		model.addAttribute(pages.category.list, dao.findAll());
		return parts.INDEX;
	}

	// Create message
	private void setMessage(Model model, Color color, @NotNull String title, String... messages) {
		model.addAttribute(parts.mesTitle.value, mes.newMes(Align.start, color, title));
		model.addAttribute(parts.mesContent.value, mes.newMes(Align.start, color, messages));
	}
}
