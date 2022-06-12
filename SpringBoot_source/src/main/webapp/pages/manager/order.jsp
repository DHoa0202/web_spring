<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="overflow-auto">
    <table class="table table-hover bg-info">
        <thead class="bg-warning">
            <tr class="text-center">
                <th><a href="/?sort=id&asc=${asc ? true : false}">id</a></th>
                <th><a href="/?sort=address&asc=${asc ? true : false}">address</a></th>
                <th><a href="/?sort=createDate&asc=${asc ? true : false}">createDate</a></th>
                <th><a href="/?sort=accountId&asc=${asc ? true : false}">accountId</a></th>
                <th class="w-25">action</th>
            </tr>
            <tr class="text-center">
                <form action="" method="post">
                    <th><input type="text" name="id" value="${order.id}" class="text-end form-control"
                            placeholder="order's id"></th>
                    <th><input type="text" name="name" value="${order.name}" class="text-end form-control"
                            placeholder="order's address"></th>
                    <th><input type="text" name="createDate" value="${order.createDate}"
                            class="text-end form-control" placeholder="order's createDate"></th>
                    <th><input type="text" name="accountId" value="${order.accountId}"
                            class="text-end form-control" placeholder="order's accountId"></th>
                    <th class="text-end d-flex">
                        <button class="btn btn-outline-success m-1">Update</button>
                        <a class="btn btn-outline-danger m-1" href="/update?id=${order.id}">Delete</a>
                    </th>
                </form>
            </tr>
        </thead>
        <tbody class="bg-gradient" style="max-height: 100vh;">
            <tr class="text-end" style="vertical-align: middle;">
                <td>${order.id}</td>
                <td>${order.address}</td>
                <td>${order.createDate}</td>
                <td>${order.accountId}</td>
                <td></td>
            </tr>
        </tbody>
    </table>
</div>