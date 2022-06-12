<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!-- get all product -->
<a href="/product/get?categoryid=" onclick="buttonActive(this, '.btnClear')"
	class="m-1 btn btn-outline-success text-nowrap btnClear">
	<i class="fa-solid fa-laptop"></i> <!-- set active if doesn't reload server -->
	<span>tất cả sản phẩm</span>
</a>
<!-- get product by category id-->	
<c:forEach var="cgs" items="${categories}">
	<a href="/product/get?categoryid=${cgs.id}" onclick="buttonActive(this, '.btnClear')"
		class="m-1 btn btn-outline-success text-nowrap btnClear">
		<i class="fa-solid fa-laptop"></i>
		<span>${cgs.name}</span>
	</a>
</c:forEach>