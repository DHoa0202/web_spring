<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<div class="w-50 m-auto mt-3 p-3 bg-white rounded-3 formAccount" >
    <h3 class="w-100 text-center">Đăng nhập tài khoản</h3>
	<s:form action="/account/login" modelAttribute="accountForm" method="post">
        <div class="mt-3">
            <label class="form-label fw-bold">Tên đăng nhập</label>
            <s:input path="username" class="form-control text-end" placeholder="your username"/>
            <span class="form-text">Nhập tên đăng nhập.</span>
        </div>
        <div class="mt-3">
            <label class="form-label fw-bold">Mật khẩu đăng nhập</label>
            <s:password path="password" class="form-control text-end" placeholder="your password"/>
            <span class="form-text">Nhập mật khẩu đăng nhập.</span>
        </div>
        <div class="text-end mt-3">
            <input type="checkbox" class="form-check-inline m-0" name="saveCookie">
            <em class="form-text">Lưu thông tin tài khoản?</em>
        </div>
        <div class="text-end mt-3">
            <button class="btn btn-outline-success">Đăng nhập</button>
            <a href="/account/register" class="text-info">Đăng ký</a>
            <a href="/account/forgotPass" class="text-danger">Quên mật khẩu</a>
        </div>
    </s:form>
</div>