<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<div class="mt-1 w-100">
	<s:form action="/account/update" method="post" enctype="multipart/form-data"
		class="myInfor m-auto d-block w-50 p-3 rounded-3 border bg-light" modelAttribute="accountForm">
		<!-- title -->
		<h3 class="w-100 text-center">Quản lý thông tin cá nhân</h3>
	
		<!-- head card -->
		<div class="mt-3">
			<div class="card mb-3">
				<div class="row g-0">
					<!-- image input -->
					<div class="col-md-5">
						<img src="/data/account/${empty account.photo ? 'default.png' : account.photo}"
						 id="photo" class="img-fluid rounded-3 w-100" alt="${account.photo}">
						<div class="w-100 overflow-auto">
							<input value="/data/account/${account.photo}" type="file" accept="image/*" name="photo"					
							 onchange="upFile('#photo',this)" class="mt-1 btn btn-outline-secondary" />
						</div>
					</div>
					<!-- introduce -->
					<div class="col-md-7">
						<div class="card-body">
							<h5 class="card-title"></h5>
							<p class="card-text mb-4">
								Chỉnh sửa thông tin tài khoản  của bạn tại đây.
							</p>
						</div>
						<div class="card-text">
							<div class="card-add">
								<a href="/order/home" class="btn btn-outline-primary p-0 ps-1 pe-1"> Giỏ hàng</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- card body -->
		<div class="mt-3">
			<label class="form-label fw-bold">Tên đăng nhập</label>
			<s:input path="username" class="form-control text-end" placeholder="username" />
			<em class="form-text">Tên đăng nhập</em>
		</div>
		<div class="mt-3">
			<label class="form-label fw-bold"> Mật khẩu đăng nhập</label>
			<i class="fa-solid fa-eye" onclick="javascipt:alert('your password: ${account.password}')"></i>
			<s:password showPassword="true" path="password" class="form-control text-end" placeholder="password" />
			<em class="form-text">Mật khẩu đăng nhập</em>
		</div>
		<div class="mt-3">
			<label class="form-label fw-bold">Họ và Tên</label>
			<s:input path="fullname" class="form-control text-end" placeholder="fullname" />
			<em class="form-text">Họ và tên tài khoản</em>
		</div>
		<div class="mt-3">
			<label class="form-label fw-bold">Email</label>
			<s:input type="email" path="email" class="form-control text-end" placeholder="your email" />
			<em class="form-text">Email đăng ký tài khoản.</em>
		</div>
		<s:hidden path="activated"/>
		<s:hidden path="admin"/>
		<div class="mt-3 mb-1 w-100 text-end">
			<button class="btn btn-outline-success">Cập nhật</button>
			<a href="/account/delete/${account.username}" class="btn btn-outline-danger">Xóa tài khoản</a>
		</div>
	</s:form>
</div>