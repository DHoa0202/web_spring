<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<nav class="p-0 navbar navbar-expand-lg bg-warning">
	<div class="container-fluid">
		<!-- The brand -->
		<jsp:include page="/components/brand.jsp"></jsp:include>

		<!-- Show button when width < 992px -->
		<c:if test="${!empty account}">
			<jsp:include page="/components/offCanvas/button.jsp">
				<jsp:param value="offCanvasRight" name="offCanvasId" />
			</jsp:include>
		</c:if>

		<button class="navbar-toggler" data-bs-toggle="collapse"
			data-bs-target="#navbar">
			<i class="fa-solid fa-bars"></i>
		</button>

		<!-- navbars's url-links -->
		<div class="collapse navbar-collapse" id="navbar">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<!-- Product -->
				<li class="nav-item"><a class="nav-link"
					href="/product/home"> <i
						class="fa-brands fa-product-hunt"></i> <span>Sản phẩm</span>
				</a></li>

				<!-- dropdown account-->
				<li class="nav-item dropdown" onmouseenter="drdActive(this)"
					onmouseleave="drdActive(this)">
					<a class="nav-link dropdown-toggle" href="#" id="acountdrd" data-bs-toggle="dropdown">
						<i class="fa-solid fa-user"></i>
						<span>Tài khoản</span>
					</a>
					<c:choose>
						<c:when test="${!empty account}">
							<!-- logged -->
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="/account/info">
									<i class="fa-solid fa-circle-info"></i>
									<span>Thông tin cá nhân</span>
								</a></li>
								<li><a class="dropdown-item" href="/account/changePass">
									<i class="fa-solid fa-key"></i>
									<span>Đổi mật khẩu</span>
								</a></li>
								<li><hr class="divide-dropdown"></li>
								<li><a class="dropdown-item m-0" href="/account/logout">
									<i class="fa-solid fa-arrow-right-from-bracket"></i>
									<span>Đăng xuất</span>
								</a></li>
							</ul>
						</c:when>
						<c:otherwise>
							<!-- Not logged in -->
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="/account/login">
										<i class="fa-solid fa-arrow-right-to-bracket"></i>
										<span>Đăng nhập</span>
								</a></li>
								<li><a class="dropdown-item" href="/account/register">
										<i class="fa-solid fa-user-plus"></i> <span>Đăng ký</span>
								</a></li>
								<li>
									<hr class="dropdown-divider">
								</li>
								<li><a class="dropdown-item" href="/account/forgotPass">
									<i class="fa-solid fa-key"></i>
									<span>Quên mật khẩu</span>
								</a></li>
							</ul>
						</c:otherwise>
					</c:choose>
				</li>
				
				<!-- dropdown manager -->
				<c:if test="${(empty account) ? false : account.admin}">
					<li class="nav-item dropdown" onmouseenter="drdActive(this)" onmouseleave="drdActive(this)">
						<a class="nav-link dropdown-toggle" href="#" id="managerdrd" data-bs-toggle="dropdown">
							<i class="fas fa-user-shield"></i>
							<span>Quản lý</span>
						</a>
						
						<!-- dropdown's list -->
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/manager/account">
								<i class="fas fa-users"></i>
								<span>Quản lý người dùng</span>
							</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>
							<li><a class="dropdown-item" href="/manager/category">
								<i class="fas fa-columns"></i>
								<span>Phân loại sản phẩm</span>
							</a></li>
							<li><a class="dropdown-item" href="/manager/product">
								<i class="fab fa-product-hunt"></i>
								<span>Quản lý sản phẩm</span>
							</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>
							<li><a class="dropdown-item" href="/manager/orders">
								<i class="fa fa-file-invoice-dollar"></i>
								<span>Quản lý hóa đơn</span>
							</a></li>
							<li><a class="dropdown-item" href="/manager/orderDetail">
								<i class="fa fa-file-invoice"></i>
								<span>Chi tiết hóa đơn</span>
							</a></li>
						</ul>
					</li>
				</c:if>
			</ul>

			<!-- Search form -->
			<form class="d-flex m-1" role="search">
				<input class="me-2 pe-0 form-control text-end" type="search"
					placeholder="Search">
				<button class="btn btn-outline-light" type="submit">Search</button>
			</form>
		</div>
	</div>
</nav>
