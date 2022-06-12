package com.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Accounts")
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String photo;
	private boolean activated;
	@Value("false")
	private boolean admin;
	@OneToMany(mappedBy = "account")
	private List<Order> orders;

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", fullname=" + fullname + ", email="
				+ email + ", photo=" + photo + ", activated=" + activated + ", admin=" + admin + "]";
	}

}
