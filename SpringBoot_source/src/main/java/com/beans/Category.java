package com.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Categories")
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name;
	@OneToMany(mappedBy = "category")
	private List<Product> products;

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

}