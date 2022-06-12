package com.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beans.*;

public interface CategoryDAO extends JpaRepository<Category, String>{}

