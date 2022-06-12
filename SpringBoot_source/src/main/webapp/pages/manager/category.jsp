<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<div class="overflow-auto mt-1">
   <table class="table table-hover bg-info">
       <thead class="bg-warning">
           <!-- column title -->
           <tr class="text-center">
               <th><a href="/category/sort?field=id&asc=${asc ? true : false}">id</a></th>
               <th><a href="/category/sort?field=name&asc=${asc ? true : false}">name</a></th>
               <th class="w-25">action</th>
           </tr>
           <!-- form action value -->
           <tr class="text-center">
               <s:form action="/category/save" modelAttribute="categoryForm" method="post">
               		<th><s:input path="id" class="input-t1" placeholder="category's id"/></th>
	               	<th><s:input path="name" class="input-t1" placeholder="category's name"/></th>
	               	<th class="text-end d-flex justify-content-end">
	                   <button class="btn btn-outline-success m-1 input-t1">Update</button>
	                   <button class="btn btn-outline-danger m-1 input-t1" formaction="/category/delete/${categoryForm.id}">Delete</button>
	               	</th>
               </s:form>
           </tr>
       </thead>
	   <!-- add value data -->
       <tbody class="bg-gradient" style="max-height: 100vh;">
           <c:forEach var="cgy" items="${categories}">
       		<tr class="text-end">
			    <td class="text-center">${cgy.id}</td>
			    <td class="text-center">${cgy.name}</td>
			    <td><a href="/category/edit/${cgy.id}" class="input-t1 btn btn-outline-secondary">${cgy.id}</a></td>
			</tr>
           </c:forEach>
        </tbody>
    </table>
</div>
