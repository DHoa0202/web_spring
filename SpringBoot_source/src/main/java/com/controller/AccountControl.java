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
import com.beans.Account;
import com.model.SessionService;
import com.model.dao.AccountDAO;
import com.utils.mes;
import com.utils.mes.*;
import com.utils.mes.Color;
import com.utils.pages;
import com.utils.parts;

@Controller
public class AccountControl {
	@Autowired
	AccountDAO dao;
	
	@Autowired
	private SessionService session;

	// get link to access accounts form page
	@GetMapping("/account/{page}")
	public String getPart(Model model, @PathVariable("page") String page) {
		session.set(parts.content.value, parts.getPage("account/" + page));
		Account account = session.get(pages.account.value);
		model.addAttribute(pages.account.form, account == null ? parts.newAccount() : account);
		return parts.INDEX;
	}

	// signUp account
	@PostMapping("/account/signUp")
	public String signUp(Model model, @ModelAttribute(value = "accountForm") Account account,
			@RequestParam(value = "saveUp", defaultValue = "false") Boolean isLogin) {
		if (dao.findById(account.getUsername()).isEmpty()) {
			dao.save(account);
			if (isLogin) return this.login(model, account);
		} else
			this.setMessage(model, Color.red, "Đăng ký tài khoản",
					String.format("Đăng ký tài khoản <b>%s</b> thất bại!", account.getUsername()),
					String.format("Tài khoản <b>%s</b> đã tồn tại!", account.getUsername()));
		return parts.INDEX;
	}
	
	// login account
	@PostMapping("/account/login")
	public String login(Model model, @ModelAttribute(value = "accountForm") Account account) {
		account = dao.login(account.getUsername(), account.getPassword());
		if (account != null) {
			session.set(pages.account.value, account);
			session.set(parts.content.value, parts.getPage("home/home"));
			return parts.RIDIRECT;
		} else {
			this.setMessage(model, Color.yellow, "Đăng nhập tài khoản",
					"<b>Tên đăng nhập</b> hoặc <b>mật khẩu</b> không đúng!");
		}
		return parts.INDEX;
	}

	// change account's pass
	@PostMapping("/account/changePass")
	public String changePass(Model model, @RequestParam("oldPass") String oldPass,
			@RequestParam("newPass") String newPass) {

		Account account = session.get(pages.account.value);
		if (oldPass.equals(account.getPassword())) {
			account.setPassword(newPass);
			dao.save(account); // update database
			session.set(pages.account.value, account); // update sessionScope

			this.setMessage(model, Color.blue, "Thay đổi mật khẩu",
					String.format("Tài khoản <b>%s</b> đổi mật khẩu thành công", account.getUsername()));
		} else
			this.setMessage(model, Color.red, "Thay đổi mật khẩu",
					String.format("Tài khoản <b>%s</b> đổi mật khẩu thất bại", account.getUsername()));

		model.addAttribute(pages.account.form, account);
		return parts.INDEX;
	}

	// logout account
	@GetMapping("/account/logout")
	public String logout() {
		session.set(pages.account.value, null);
		session.set(parts.content.value, parts.getPage("home/home"));
		return parts.RIDIRECT;
	}
	
	@PostMapping("/account/update")
	public String update(Model model, Account account) {
		if(dao.save(account) != null) {
			setMessage(model, Color.blue, "Cập nhật tài khoản", 
					String.format("Tài khoản <b>%s</b> đã cập nhật thành công.", account.getUsername())
					);
		} else {
			setMessage(model, Color.red, "Cập nhật tài khoản", 
					String.format("Tài khoản <b>%s</b> đã cập nhật thất bại!", account.getUsername())
					);
		}
		model.addAttribute(pages.account.form, account);
		return parts.INDEX;
	}

	@PostMapping("/account/save")
	public String save(Model model, @ModelAttribute("accountForm") Account account) {
		account = account.getUsername().isEmpty() ? null : account;
		if(account == null) {
			this.setMessage(model, Color.red, "Lưu tài khoản người dùng!", 
					"Không lưu tài khoản null",
					"Tài khoản phải đầy đủ giá trị"
			);
		} else if(dao.save(account) != null) {
			model.addAttribute(pages.account.form, parts.newAccount());
			this.setMessage(model, Color.green, "Lưu tài khoản người dùng!", 
				String.format("Tài khoản <b>%s</b> lưu hoàn tất!", account.getUsername())
			);
		} else {
			this.setMessage(model, Color.red, "Lưu tài khoản người dùng!", 
				String.format("Lưu tài khoản <b>%s</b> thất bại!", account.getUsername())
			);
		}
		
		model.addAttribute(pages.account.list, dao.findAll());
		return parts.INDEX;
	}
		
	// delete by id
	@SuppressWarnings("deprecation")
	@GetMapping("/account/delete/{username}")
	public String delete(@PathVariable("username") String username, Model model) {
		Account account = dao.getById(username);
		if (account != null) {
			dao.deleteById(username);
			session.set(pages.account.value, null);
			model.addAttribute(pages.account.form, parts.newAccount());
			return parts.RIDIRECT;
		} else setMessage(model, Color.red, "Xóa tài khoản", String.format("Không thể xóa tài khoản <b>%s</b>", username));
		return parts.INDEX;
	}

	@SuppressWarnings("deprecation")
	@PostMapping({"/account/delete/{username}", "/account/delete/"})
	public String deletePost(@PathVariable(value = "username", required = false) String username, Model model) {
		if(username != null) {
			Account account = dao.getById(username);
			if (account != null) {
				dao.deleteById(username);
				session.set(pages.account.form, null);
				setMessage(model, Color.green, "Xóa tài khoản", 
						String.format("Đã xóa tài khoản <b>%s</b>", username)
						);
			} else {
				setMessage(model, Color.red, "Xóa tài khoản", 
						String.format("Không thể xóa tài khoản <b>%s</b>", username)
						);
			} 
		}
		
		model.addAttribute(pages.account.form, parts.newAccount());
		model.addAttribute(pages.account.list, dao.findAll());
		return parts.INDEX;
	}
	
	// sort by field
	@RequestMapping("/account/sort")
	public String sort(Model model, @RequestParam("field") Optional<String> field, @RequestParam("asc") Boolean asc) {
		model.addAttribute("field", field.orElse("id"));
		model.addAttribute("asc", asc ? false : true);
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, field.get());
		model.addAttribute(pages.account.form, parts.newAccount());
		model.addAttribute(pages.account.list, dao.findAll(sort));
		return parts.INDEX;
	}
	
	// get to edit before update account
	@GetMapping("/account/edit/{username}")
	public String edit(Model model, @PathVariable("username") String username) {
		Account account = dao.findById(username).get();
		model.addAttribute(pages.account.form, account);
		model.addAttribute("accounts", dao.findAll());
		return parts.INDEX;
	}
	
	// Create message
 	private void setMessage(Model model, Color color, @NotNull String title, String... messages) {
		model.addAttribute(parts.mesTitle.value, mes.newMes(Align.start, color, title));
		model.addAttribute(parts.mesContent.value, mes.newMes(Align.start, color, messages));
	}
}
	
