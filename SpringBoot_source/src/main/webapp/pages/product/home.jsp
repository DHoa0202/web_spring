<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!-- category and product're content-->
<div class="bg-gradient container-fluid">
	<div class="row p-1 border">
		<!-- Categories -->
		<div class="col-lg-12 mt-auto p-1 p-0">
			<div class="categories rounded-3 bg-warning overflow-auto d-flex flex-nowrap">
				<jsp:include page="/components/categories.jsp"></jsp:include>
			</div>
		</div>
		
		<!-- Search form -->
		<jsp:include page="/pages/product/search.jsp"/>
		
		<!-- Products -->
		<div class="col-sm-12 mt-1 p-0 border">
			<div class="cards bg-transparent mt-1 text-dark overflow-auto d-flex align-items-stretch flex-wrap" style="max-height: 80vh;">
				<c:choose>
					<c:when test="${not empty products}">
						<jsp:include page="/components/products.jsp"></jsp:include>
					</c:when>
					<c:otherwise><h3 class="w-100 fw-bold text-center text-danger"><em>Danh mục này không có sản phẩm!</em></h3></c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>