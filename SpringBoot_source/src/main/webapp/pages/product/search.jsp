<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="col-lg-12 mt-1 p-0 border">
	<form class="m-1 d-flex justify-content-between align-items-center" action="/product/search">
		<div class="mt-1 text-bright d-inline-block">
			<div class="d-inline-block">
				<span class="ms-1">
					<label>name</label>
					<input class="form-check-inline" type="radio" name="field" value="name" checked="checked">
				</span>
				<span class="ms-1">
					<label>price</label>
					<input class="form-check-inline" type="radio" name="field" value="price">
				</span>
			</div>
		</div>
		<div class="mt-auto me-0 d-inline-block">
			<div class="mt-1 d-flex">
				<input class="me-2 pe-0 form-control text-end" name="keyworks" type="search" placeholder="Search" >
				<button class="btn btn-outline-light" type="submit">Search</button>
			</div>
		</div>
	</form>
</div>
		