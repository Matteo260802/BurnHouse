<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.*" %>
<%	
	Boolean isAdmin = (Boolean)session.getAttribute("adminFilter");
	Boolean isUser = (Boolean) session.getAttribute("userFilter");
	boolean isLoggedUser = isUser != null && isUser.booleanValue();
	boolean isLoggedAdmin = isAdmin != null && isAdmin.booleanValue();
%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.*" %>
<%@ include file="Header.jsp" %>
<head>
<meta charset="UTF-8">
<title>Vini</title>
<%if(isAdmin!=null && isAdmin!=false){ %>
	<link rel="stylesheet" type="text/css" href="./CSS/CatalogoStileAdmin.css">	
<% } else {%>
	<link rel="stylesheet" type="text/css" href="./CSS/CatalogoStileUser.css">
<% } %>
</head>
<body>
<hr>
	<%
    ProductModelDS model = new ProductModelDS();
    Collection<ProductBean> products = model.doRetrieveByVino();
	%>
	
	
	<% for (ProductBean bean : products) { %>
	<div class="card-container">
		<div class="card">
				<div class="imgBox">
					<a href="Dettagli.jsp?id=<%=bean.getCode()%>" target="_blank" rel="noopener">
				    <img src="${pageContext.request.contextPath}/Immagini/<%=bean.getImg()%>" alt="<%=bean.getName() %>" class="product">
				    </a>
				</div>	
			<div class="contentBox">
				   <h3><%=bean.getName() %></h3>
				   <h2 class="price"><%=String.format("%.2f", bean.getPrice()) %> €</h2>
				   
				   <a href="CartController?action=addCart&id=<%=bean.getCode()%>" class="buy">Aggiungi al carrello</a>
				   
		  	</div>
		  		<div class="buttons">
				     	<%if(isAdmin!=null && isAdmin!=false){ %>
					  	<a href="product?action=delete&id=<%=bean.getCode()%>">Elimina</a><br>
					  	<a href="Modifica.jsp?id=<%=bean.getCode()%>" target="_blank" rel="noopener">Modifica</a><br>
					  	<%} %>  
				</div>
	
		</div>
	</div>
	<% } %>
	<jsp:include page="Footer.jsp" />
</body>
</html>

