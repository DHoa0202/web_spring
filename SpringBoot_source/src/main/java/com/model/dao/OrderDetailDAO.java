package com.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beans.*;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{}