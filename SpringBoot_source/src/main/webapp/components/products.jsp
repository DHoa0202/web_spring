<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>

<c:forEach items="${products}" var="prd">
	<div class="card-auto b-hover">
        <div class="card text-nowrap h-100">
            <!-- card's header -->
            <div class="card-header overflow-auto">
                <span>${prd.name}</span>
            </div>
            
            <!-- card's body -->
            <div class="card-body position-relative">
                <a href="/others/pages/productdetail.html" title="xem chi tiết">
                    <img class="card-img" src="/data/product/${prd.image}" alt="none">
                </a>
               	<c:if test="${!empty account}">
               		 <a href="#" class="card-add t-hover fa-solid fa-circle-plus"
	                    title="add to card">
	                </a>
               	</c:if>
            </div>
            
            <!-- card's footer -->
            <div class="card-footer text-end overflow-auto">
                <span><f:formatNumber maxFractionDigits="3" minFractionDigits="1">${prd.price}</f:formatNumber>
                &nbsp;<strong style="color: red;">đ</strong></span>
            </div>
        </div>
    </div>
</c:forEach>

