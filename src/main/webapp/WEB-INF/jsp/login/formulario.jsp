<%-- 
    Document   : formulario
    Created on : 07/10/2014, 21:23:01
    Author     : José Paulo Jr
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
    href="../bootstrap/css/bootstrap.css">
<title>Formulário de Login</title>
</head>
<body>

    <c:if test="${not empty errors}">
   	 <div class="alert alert-danger">
   		 <c:forEach var="error" items="${errors}">
            	${error.category} - ${error.message}<br />
   		 </c:forEach>
   	 </div>
    </c:if>


    <div class="container">
   	 <form class="form-signin" action="<c:url value='/login/autentica'/>"
   		 method="post">
   		 <h2 class="form-signin-heading">Faça login para acessar o
   			 VRaptor-Produtos</h2>
   		 <br /> <input type="text" class="form-control" name="usuario.nome"
   			 placeholder="Nome" /> <br /> <input type="password"
   			 class="form-control" name="usuario.senha" placeholder="Senha" /> <br />
   		 <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
   	 </form>
    </div>
</body>
</html>
