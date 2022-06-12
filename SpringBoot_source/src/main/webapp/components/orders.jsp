<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div style="max-height: 100vh;'" class="overflow-auto">
	<div class="accordion" id="accordion">
		<!-- a cart has list invoice -->
		<c:forEach var="ord" items="${orders}" step="5">
			<div class="accordion-item">
				<!-- list detail's head part -->
				<h2 class="accordion-header" id="headingOne">
					<button class="accordion-button" data-bs-toggle="collapse"
						data-bs-target="#itemacd${ord.id}">
						${ord.id}&nbsp;-&nbsp;${fn:substring(ord.address, 0, 18)}... <br>
						<f:formatDate value="${ord.createDate}"
							pattern="EEEE, dd MMMM yyyy" />
					</button>
				</h2>
				<!-- list detail content part -->
				<div id="itemacd${ord.id}" class="accordion-collapse collapse" data-bs-parent="#accordion">
					<div class="accordion-body">
						<c:forEach var="detail" items="${ord.orderDetails}">
							<c:set var="prd" value="${detail.product}"/> <!-- product separation -->
							<div class="row border text-end mt-1 align-items-center">
							    <div class="col-sm-4 p-1">
							        <a href="/product/detail/${prd.id}" title="xem chi tiết">
							            <img class="w-100 rounded-3" src="/data/product/${prd.image}" alt="${prd.name}">
							        </a>
							    </div>
							    <!-- a product -->
							    <form action="/orderDetail/update/detail?qty=${detail.quantity}" method="post" class="col-sm-8 p-1">
							        <h6 class="overflow-hidden m-0">${prd.name}</h6>
							        <div class="mt-1 d-flex justify-content-between">
							            <span class="m-1 d-inline-flex">
							            	<f:formatNumber maxFractionDigits="3" minFractionDigits="1">${detail.price}</f:formatNumber>
							            	<span class="cl-red">đ</span>
							            </span>
							            <input type="hidden" value="${detail.id}" name="id">
							            <input type="number" class="rounded-1 border-1 text-end h-fit" style="width: 60px;" value="${detail.quantity}"
							            name="quantity" onchange="amount(this, ${prd.price},'#amountID${detail.id}')">
							        </div>
							        <div class="mt-1 d-inline-flex">
							            Tổng:&nbsp;
							            <span id="amountID${detail.id}">
							            <f:formatNumber maxFractionDigits="3" minFractionDigits="1">
							            	${detail.quantity * prd.price}
						            	</f:formatNumber>
							            </span>
							            <span class="cl-red">đ</span>
							        </div>
							        <div class="mt-1">
							            <button class="btn p-0 ps-1 pe-1 btn-outline-success">Update</button>
							            <a class="btn p-0 ps-1 pe-1 btn-outline-danger" href="/orderDetail/delete/${detail.id}">Delete</a>
							        </div>
							    </form>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
