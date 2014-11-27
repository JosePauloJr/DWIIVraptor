<%-- 
    Document   : formulario
    Created on : 07/10/2014, 21:23:28
    Author     : José Paulo Jr
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../base.css">
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

   	 <h1>Adicionar Produto</h1>

   	 <form action="<c:url value='/produto/adiciona'/>" method="post">
   		 Nome: <input class="form-control" type="text" name="produto.nome"
   			 value="${produto.nome}" /> Valor: <input class="form-control"
   			 type="text" name="produto.valor" value="${produto.valor}" />
   		 Quantidade: <input class="form-control" type="text"
   			 name="produto.quantidade" value="${produto.quantidade}" />
   		 <button type="submit" class="btn btn-primary">Adicionar</button>
   	 </form>

    </div>
</body>
</html>
