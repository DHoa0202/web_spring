<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="toast-container position-fixed bottom-0 end-0 p-3" style="z-index: 10;">
    <div class="toast" role="alert" aria-atomic="true" data-bs-delay="5000">
        <div class="toast-header">
            <strong class="me-auto">
                <i class="fa-solid fa-comment-dots"></i>
                <span>${param.title}</span>
            </strong>
            <button type="button" class="btn-close" data-bs-dismiss="toast"></button>
        </div>
        <div class="toast-body">
            <p>${param.content}</p>
        </div>
    </div>
</div>
