<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<div class="w-50 m-auto mt-3 p-3 bg-white rounded-3 formAccount" >
    <h3 class="w-100 text-center">Đăng ký tài khoản</h3>
    <s:form action="/account/signUp" modelAttribute="accountForm" method="post">
        <div class="mt-3">
            <label class="form-label fw-bold">Tên đăng nhập</label>
            <s:input path="username" class="form-control text-end" placeholder="your username"/>
            <span class="form-text">Nhập tên đăng nhập.</span>
        </div>
        <div class="mt-3">
            <label class="form-label fw-bold">Mật khẩu đăng nhập</label>
            <i class="fa-solid fa-eye" onclick="showPass('#password')"></i>
            <s:password path="password" id="password" showPassword="true" class="form-control text-end" placeholder="your password"/>
            <span class="form-text">Nhập mật khẩu đăng nhập.</span>
        </div>
        <div class="mt-3">
            <label class="form-label fw-bold">Họ và tên</label>
            <s:input path="fullname" class="form-control text-end" placeholder="fullname"/>
            <span class="form-text">Nhập Họ và Tên.</span>
        </div>
        <div class="mt-3">
            <label class="form-label fw-bold">Email</label>
            <s:input path="email" class="form-control text-end" placeholder="your email"/>
            <span class="form-text">Nhập thông tin email.</span>
        </div>
        <div class="text-end mt-3">
        	<input type="checkbox" name="saveUp" checked="checked">
        	&nbsp;<em>Lưu đăng nhập?</em>
            <s:hidden path="activated" value="true"/>
        </div>
        <div class="text-end mt-3">
            <button class="btn btn-outline-success">Đăng ký</button>
            <a href="/account/login" class="text-info">Đăng nhập</a>
            <a href="/account/forgotPass" class="text-danger">Quên mật khẩu</a>
        </div>
    </s:form>
</div>