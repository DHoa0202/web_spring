<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 
<div class="mt-1 container-fluid overflow-auto">
	<!-- Content on -->
	<div class="row border">
	    <!-- Main content -->
	    <div class="d-f-part col-lg-9 p-0 bg-gradient bg-opacity-10">
	        <!-- Carousel -->
	        <jsp:include page="/components/carousel.jsp"></jsp:include>
	        
	        <!-- category and product're content-->
	        <div class="bg-gradient">
	            <!-- Categories -->
	            <div class="categories mt-1 bg-warning overflow-auto d-flex flex-nowrap">
					<jsp:include page="/components/categories.jsp"></jsp:include>
				</div>
				
				<!-- Search form -->
				<div class="mt-1">
					<jsp:include page="/pages/product/search.jsp"/>
				</div>
				
	            <!-- Products -->
				<div class="cards bg-rrg-blue mt-1 text-dark overflow-auto d-flex align-items-stretch">
					<c:choose>
						<c:when test="${not empty products}">
							<jsp:include page="/components/products.jsp"></jsp:include>
						</c:when>
						<c:otherwise>
							<h3 class="w-100 fw-bold text-center text-danger">
								<em>Bộ lọc không tìm thấy kết quả trùng khớp!</em>
							</h3>
						</c:otherwise>
					</c:choose>
				</div>
	        </div>
	    </div>
	    <!-- Sub content -->
	    <div class="d-f-part p-1 col-lg-3 bg-secondary bg-gradient bg-opacity-10">
	        <!-- information -->
	        <jsp:include page="/parts/myInfo.jsp"></jsp:include>
	        
	        <!-- Video informatoin -->
	        <jsp:include page="/components/video.jsp"></jsp:include>
	    </div>
	</div>
	
	<!-- Content bellow -->
	<div class="mt-1 p-1 row border bg-white">
    <!-- Main content -->
    <div class="col-lg-8 p-0">
        <h3 class="w-100 text-center">Kết nối cộng đồng</h3>
        <!-- Comment facebook -->
        <jsp:include page="/components/facebook/comment.jsp"></jsp:include>
    </div>
    
    <!-- Sub content -->
    <div class="col-lg-4 p-3 pt-0 d-f-part">
        <!-- references web -->
        <jsp:include page="/components/referenceLinks.jsp"></jsp:include>

        <!-- Like facebook -->
        <jsp:include page="/components/facebook/like.jsp"></jsp:include>
        
        <!-- Map embed -->
        <jsp:include page="/components/map.jsp"></jsp:include>
    </div>
</div>
</div>