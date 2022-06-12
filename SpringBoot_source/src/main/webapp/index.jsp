<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Fontawesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css"
        integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- Style -->
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/display.css">
    <!--------------------------------------->
    <title>ASSIGNMENT</title>
</head>

<body>
    <div class="container-fluid position-relative border-start border-end border-3 border-warning bg-rrg-blue" style="min-height: 100vh;">
        <div class="mt-3 overflow-auto" style="max-height: 50vh;">
        	${sessionScope}
        </div>
        <!-- Top part -->        
		<jsp:include page="${sessionScope.topPage}"></jsp:include>
        <!-- Content part -->
       	<jsp:include page="${sessionScope.contentPage}"></jsp:include>
        <!-- Bellow part -->
        <jsp:include page="${sessionScope.bellowPage}"></jsp:include>
        
        <c:if test="${not empty account}">
        	<!-- Offcanvas -->
	        <jsp:include page="/parts/offCanvas.jsp"></jsp:include>
        </c:if>
        <!-- Toast alert message -->
        <c:if test="${!empty mesContent}">
        	<jsp:include page="/components/toast.jsp">
	        	<jsp:param value="${mesTitle}" name="title"/>
	        	<jsp:param value="${mesContent}" name="content"/>
	        </jsp:include>
        </c:if>
    </div>

    <!-- Javascript -->
    <script src="/js/myScript.js"></script>
    <script src="/js/support.js"></script>
    <script src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v10.0&appId=227935495543483&autoLogAppEvents=1"
	        async defer crossorigin="anonymous" nonce="OMOrtzqj">
    </script>
</body>

</html>