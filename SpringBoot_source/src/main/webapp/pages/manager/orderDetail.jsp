<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="overflow-auto">
    <table class="table table-hover bg-info">
        <thead class="bg-warning">
            <tr class="text-center">
                <th><a href="/?sort=id&asc=${asc ? true : false}">id</a></th>
                <th><a href="/?sort=price&asc=${asc ? true : false}">price</a></th>
                <th><a href="/?sort=OrderId&asc=${asc ? true : false}">OrderId</a></th>
                <th><a href="/?sort=accountId&asc=${asc ? true : false}">accountId</a></th>
                <th><a href="/?sort=productId&asc=${asc ? true : false}">ProductId</a></th>
                <th class="w-25">action</th>
            </tr>
            <tr class="text-center">
                <form action="" method="post">
                    <th><input type="text" name="id" value="${detail.id}" class="text-end form-control"
                            placeholder="detail's id"></th>
                    <th><input type="text" name="price" value="${detail.price}"
                            class="text-end form-control" placeholder="detail's price"></th>
                    <th><input type="text" name="orderId" value="${detail.orderId}"
                            class="text-end form-control" placeholder="detail's orderId"></th>
                    <th><input type="text" name="accountId" value="${detail.accountId}"
                            class="text-end form-control" placeholder="detail's accountId"></th>
                    <th><input type="text" name="productId" value="${detail.productId}"
                            class="text-end form-control" placeholder="detail's productId"></th>
                    <th class="text-end d-flex">
                        <button class="btn btn-outline-success m-1">Update</button>
                        <a class="btn btn-outline-danger m-1" href="/update?id=${detail.id}">Delete</a>
                    </th>
                </form>
            </tr>
        </thead>
        <tbody class="bg-gradient" style="max-height: 100vh;">
            <tr class="text-end" style="vertical-align: middle;">
                <td class="text-start">${detail.id}</td>
                <td class="text-center">${detail.price}</td>
                <td class="text-start">${detail.orderId}</td>
                <td class="text-center">${detail.accountId}</td>
                <td class="text-start">${detail.productId}</td>
                <td colspan="2">
                    <a href="/edit/${detail.id}" class="btn btn-outline-secondary">${detail.id}</a>
                </td>
            </tr>
        </tbody>
    </table>
</div>
