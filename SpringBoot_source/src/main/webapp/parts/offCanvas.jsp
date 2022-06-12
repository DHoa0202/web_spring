<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- nav hover right -->
 <jsp:include page="/components/offCanvas/navHover.jsp">
 	<jsp:param value="right" name="possition"/>
 	<jsp:param value="offCanvasRight" name="offCanvasId"/>
 </jsp:include>
 
 <!-- Contents -->
 <jsp:include page="/components/offCanvas/home.jsp">
 	<jsp:param value="offCanvasRight" name="offCanvasId"/>
 </jsp:include>