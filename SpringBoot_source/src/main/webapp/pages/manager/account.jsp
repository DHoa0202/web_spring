<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

    
<div class="mt-1 overflow-auto">
     <table class="table table-hover bg-info">
         <thead class="bg-warning">
             <tr class="text-center">
                 <th>
                 	<div class="overflow-auto mt-1" style="min-width: 100px;">
						<input value="${product.image}" type="file" accept="image/*" 
							style="max-width: 128px!important" class="input-t1" name="image" onchange="upFile('#image',this)">
					</div>
				 </th>
                 <th><a href="/account/sort?field=username&asc=${asc ? true : false}">username</a></th>
                 <th>password</th>
                 <th><a href="/account/sort?field=fullname&asc=${asc ? true : false}">fullName</a></th>
                 <th><a href="/account/sort?field=email&asc=${asc ? true : false}">email</a></th>
                 <th><a href="/account/sort?field=activated&asc=${asc ? true : false}"><i class="fa-solid fa-lock-open"></i></a></th>
                 <th><a href="/account/sort?field=admin&asc=${asc ? true : false}"><i class="fa-solid fa-user-shield"></i></a></th>	
                 <th class="w-fit">action</th>
             </tr>
             <tr class="text-center" style="vertical-align: middle;">
				<s:form action="/account/save" modelAttribute="accountForm" method="post">
					<th>
						<img src="${accountForm.photo}" id="image" style="max-width: 128px!important" class="img-fluid rounded-3 w-100" alt="none">
					</th>
					<th><s:input path="username" class="input-t1" placeholder="accountForm's username"/></th>
					<th><s:password path="password" showPassword="true" class="input-t1 w-100" placeholder="accountForm's password"/></th>
					<th><s:input path="fullname" class="input-t1" placeholder="accountForm's fullName"/></th>
					<th><s:input path="email" class="input-t1" placeholder="accountForm's email"/></th>
					<th><s:checkbox path="activated"/></th>
					<th><s:checkbox path="admin"/></th>
					<th class="text-end d-flex justify-content-end align-items-center">
						<button class="btn btn-outline-success m-1 text-nowrap">Cập nhật</button>
						<button class="btn btn-outline-danger m-1 text-nowrap" formaction="/account/delete/${accountForm.username}">Xóa</button>
					</th>
				</s:form>
			</tr>
         </thead>
         <tbody class="bg-gradient" style="max-height: 100vh;">
             <c:forEach var="user" items="${accounts}">
             	<tr class="text-end">
	                <td>
	                	<img style="width: 128px;" src="/data/account/${user.photo}" class="img-fluid rounded-start" alt="${user.photo}">
	                </td>
	                <td class="text-center">${user.username}</td>
	                <td class="text-start">...</td>
	                <td class="text-end">${user.fullname}</td>
	                <td class="text-end">${user.email}</td>
	                <td class="text-end">${user.activated ? 'open' : 'close'}</td>
	                <td class="text-end">${user.admin ? 'open' : 'close'}</td>
	                <td><a href="/account/edit/${user.username}" class="btn btn-outline-secondary text-nowrap">sửa</a></td>
	            </tr>
             </c:forEach>
         </tbody>
     </table>
 </div>
