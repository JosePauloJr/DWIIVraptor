<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
    href="../bootstrap/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Produtos</title>
</head>
<body>
    <h1>Usuário Logado: ${usuarioLogado.usuario.nome}</h1>

    <c:if test="${not empty mensagem}">
   	 <div class="alert alert-success">${mensagem}</div>
    </c:if>

    <table class="table table-stripped table-hover table-bordered">
   	 <thead>
   		 <tr>
   			 <th>Nome</th>
   			 <th>Valor</th>
   			 <th>Quantidade</th>
   			 <th>Ação</th>
   			 <th>Solicitar Produtos</th>
   		 </tr>
   	 </thead>
   	 <tbody>
   		 <c:forEach items="${produtoList}" var="produto">
   			 <tr>
   				 <td>
   					 <a href="<c:url value='/produto/formularioUpdate/${produto.id}'/>">${produto.nome}</a>
   				 </td>
   				 <td>${produto.valor}</td>
   				 <td>${produto.quantidade}</td>
   				 <td>
   					 <a href="<c:url value='/produto/remove?produto.id=${produto.id}'/>">Remover</a>
   				 </td>
   				 <td>
   					 <a href="<c:url value='/produto/enviaPedidoDeNovosItens?produto.nome=${produto.nome}'/>">Pedir mais itens!</a>
   				 </td>
   			 </tr>
   		 </c:forEach>
   	 </tbody>
    </table>
    <hr />
    <a href="<c:url value='/produto/formulario'/>">Adicionar mais
   	 produtos!</a>
    <br />
    <a href="<c:url value='/produto/listaXML'/>"> Acesse essa lista em
   	 XML!</a>
    <br />
    <a href="<c:url value='/produto/listaJSON'/>">Acesse essa lista em
   	 JSON!</a>

</body>
</html>