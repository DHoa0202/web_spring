<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<div class="mt-1 w-100">
	<s:form action="/account/changePass" method="post" enctype="multipart/form-data"
		class="myInfor m-auto d-block w-50 p-3 rounded-3 border bg-light" modelAttribute="accountForm">
		<!-- title -->
		<h3 class="w-100 text-center">Đổi mật khẩu</h3>
		
		<!-- card body -->
		<div class="mt-3">
			<label class="form-label fw-bold">Tên đăng nhập</label>
			<s:input path="username" readonly="true" class="form-control text-end" placeholder="username" />
			<em class="form-text">Tên đăng nhập</em>
		</div>
		<div class="mt-3">
			<label class="form-label fw-bold"> Mật khẩu cũ</label>
			<i class="fa-solid fa-eye" onclick="showPass('#oldPass')"></i>
			<input type="password" name="oldPass" id="oldPass" class="form-control text-end" placeholder="password" />
			<em class="form-text">Mật khẩu cũ</em>
		</div>
		<div class="mt-3">
			<label class="form-label fw-bold"> Mật khẩu mới</label>
			<i class="fa-solid fa-eye" onclick="showPass('#newPass')"></i>
			<input type="password" name="newPass" id="newPass" class="form-control text-end" placeholder="password" />
			<em class="form-text">Mật khẩu mới</em>
		</div>
		<div class="mt-3 mb-1 w-100 text-end">
			<button class="btn btn-outline-success">Cập nhật</button>
		</div>
	</s:form>
</div>