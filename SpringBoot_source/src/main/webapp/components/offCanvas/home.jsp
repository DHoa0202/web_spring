<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="offcanvas offcanvas-end bg-light" onmouseleave="canvasActive('${param.offCanvasId}')" tabindex="-1"
            id="${param.offCanvasId}" aria-labelledby="${param.offCanvasId}Label">
            <!-- right bar of offcanvas is possition on the right-->
            <div class="offcanvas-header text-center">
                <div class="offcanvas-title">
                    <h3>${title}</h3>
                </div>
                <button type="button" class="t-hover btn-close" onclick="buttonClick('${param.offCanvasId}')"></button>
            </div>
            
            <div class="offcanvas-body p-1">
                <!-- account's cart -->
                <div class="text-center">
                    <h3 class="pb-1 border-bottom">Giỏ hàng của bạn</h3>
                    <div class="container-fluid p-0">
                     	<jsp:include page="/components/orders.jsp"></jsp:include>
                    </div>
                </div>
            </div>
            
            <div class="offcanvas-title text-center p-3 pb-1">
                <h5 class="m-0">${account.fullname}</h5>
                <div class="d-f-part align-items-start">
                    a
                </div>
            </div>
        </div>
	