package com.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.beans.*;

public interface AccountDAO extends JpaRepository<Account, String>{
	@Query("SELECT o FROM Account o WHERE o.username=:user and o.password=:pass")
	public Account login(String user, String pass);
}