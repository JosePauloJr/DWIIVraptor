<%-- 
    Document   : formularioUpdate
    Created on : 07/10/2014, 21:23:37
    Author     : José Paulo Jr
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/base.css'/>">
<body>
<c:if test="${not empty errors}">
  <div class="alert alert-danger">
	<c:forEach var="error" items="${errors}">
    	${error.category} - ${error.message}<br />
	</c:forEach>
  </div>
</c:if>
<hr />
    <div class="container">

   	 <h1>Alterar Produto</h1>

   	 <form action="<c:url value='/produto/alterar'/>" method="post">
   		 <input type="hidden" name="produto.id" value="${produto.id }" />
   		 Nome:
   		 <input class="form-control" type="text" name="produto.nome" value="${produto.nome}" />
   		 <br />
   		 Valor:
   		 <input class="form-control" type="text" name="produto.valor" value="${produto.valor}" />
   		 <br />
   		 Quantidade: <input class="form-control" type="text" name="produto.quantidade" value="${produto.quantidade}" />
   		 <br />
   		 <button type="submit" class="btn btn-primary">Alterar</button>
   	 </form>

    </div>
</body>
</html>
