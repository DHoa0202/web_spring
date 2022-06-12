package com.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beans.*;

public interface OrderDAO extends JpaRepository<Order, Long>{
	List<Order> findByAccount(Account account);
}

