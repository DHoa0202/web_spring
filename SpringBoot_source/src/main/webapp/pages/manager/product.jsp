<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="overflow-auto">
     <table class="table table-hover bg-info">
         <thead class="bg-warning">
             <tr class="text-center">
                 <th>image</th>
                 <th><a href="/?sort=id&asc=${asc ? true : false}">id</a></th>
                 <th><a href="/?sort=name&asc=${asc ? true : false}">name</a></th>
                 <th><a href="/?sort=price&asc=${asc ? true : false}">price</a></th>
                 <th><a href="/?sort=createdate&asc=${asc ? true : false}">createDate</a></th>
                 <th><a href="/?sort=available&asc=${asc ? true : false}">available</a></th>
                 <th><a href="/?sort=categoryid&asc=${asc ? true : false}">categoryId</a></th>
                 <th>image</th>
                 <th class="w-25">action</th>
             </tr>
             <tr class="text-center">
                 <form action="" method="post">
                     <th><img src="${product.image}" id="image" class="img-fluid rounded-start w-100"
                             alt="none"></th>
                     <th><input type="text" name="id" value="${product.id}" class="text-end form-control"
                             placeholder="category's id"></th>
                     <th><input type="text" name="name" value="${product.name}" class="text-end form-control"
                             placeholder="category's name"></th>
                     <th><input type="text" name="price" value="${product.price}"
                             class="text-end form-control" placeholder="category's price"></th>
                     <th><input type="text" name="createdate" value="${product.createdate}"
                             class="text-end form-control" placeholder="category's createdate"></th>
                     <th><input type="text" name="available" value="${product.available}"
                             class="text-end form-control" placeholder="category's available"></th>
                     <th><input type="text" name="categoryId" value="${product.categoryid}"
                             class="text-end form-control" placeholder="category's parent id"></th>
                     <th><input value="${product.image}" type="file" accept="image/*" name="image"
                             class="form-control" onchange="upFile('#image',this)"></th>
                     <th class="text-end d-flex">
                         <button class="btn btn-outline-success m-1">Update</button>
                         <a class="btn btn-outline-danger m-1" href="/update?id=${category.id}">Delete</a>
                     </th>
                 </form>
             </tr>
         </thead>
         <tbody class="bg-gradient" style="max-height: 100vh;">
             <tr class="text-end" style="vertical-align: middle;">
                 <td class="text-center">
                     <img src="${category.image}" alt="none" width="64px">
                 </td>
                 <td class="text-start">${category.id}</td>
                 <td class="text-center">${category.name}</td>
                 <td class="text-start">${category.price}</td>
                 <td class="text-center">${category.createDate}</td>
                 <td class="text-start">${category.available}</td>
                 <td class="text-center">${category. categoryId}</td>
                 <td colspan="2">
                     <a href="/edit/${category.id}" class="btn btn-outline-secondary">${category.id}</a>
                 </td>
             </tr>
         </tbody>
     </table>
 </div>
