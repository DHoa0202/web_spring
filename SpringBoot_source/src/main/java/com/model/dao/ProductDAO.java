package com.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.beans.*;

public interface ProductDAO extends JpaRepository<Product, Integer>{

	/**
	 * @param categoryid mã phân loại sản phẩm
	 * @return Sản phẩm lọc theo mã
	 */
	@Query("SELECT o FROM Product o WHERE o.category.id = :categoryid")
	public List<Product> findByCategoryId(String categoryid);
	
	/**
	 * @param minPrice Giá trị nhỏ giá nhỏ nhất
	 * @param minPrice Giá trị giá cao nhất
	 * @return 
	 * <p>=> <b>Kết quả </b><em>trong khoảng giá</em>.<br>
	 * => Danh sách với tất cả sản phẩm lọc giá</p>
	 **/
	@Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
	public List<Product> findBetweenPrice(double minPrice, double maxPrice);
	
	/**
	 * @param minPrice Giá trị nhỏ giá nhỏ nhất
	 * @param minPrice Giá trị giá cao nhất
	 * => <b>Kết quả </b><em>trong khoảng giá</em>.
	 * => Danh sách với tất cả sản phẩm lọc theo mã phân loại
	 **/
	@Query("SELECT o FROM Product o WHERE o.price BETWEEN :min AND :max AND o.category.id = :categoryid")
	public List<Product> findBwPriceByCateId(double min, double max, String categoryid);

	@Query("SELECT o FROM Product o WHERE o.name like :keyworks")
	public List<Product> findLikeName(String keyworks);

	@Query("SELECT o FROM Product o WHERE o.name like :keyworks AND o.category.id = :categoryid")
	public List<Product> findLikeKByCateId(String keyworks, String categoryid);
}
