<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	Collection<?> filteredProducts = (Collection<?>) session.getAttribute("filteredProducts");
	if(filteredProducts == null) {
		response.sendRedirect("./product");	
		return;
	}
	
	
	Boolean isAdmin = (Boolean)session.getAttribute("adminFilter");
	Boolean isUser = (Boolean) session.getAttribute("userFilter");
	boolean isLoggedUser = isUser != null && isUser.booleanValue();
	boolean isLoggedAdmin = isAdmin != null && isAdmin.booleanValue();
	
%>    


 
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.ProductBean"%>
<%@ page import="java.io.OutputStream" %>
<%@ include file="Header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Gradazione</title>
	<%if(isAdmin!=null && isAdmin!=false){ %>
	<link rel="stylesheet" type="text/css" href="./CSS/CatalogoStileAdmin.css">	
	<% } else {%>
	<link rel="stylesheet" type="text/css" href="./CSS/CatalogoStileUser.css">
	<% } %>
</head>
<body>
		
		
		<%
		if (filteredProducts != null && filteredProducts.size() != 0) {
			Iterator<?> it = filteredProducts.iterator();
			while (it.hasNext()) {
				ProductBean bean = (ProductBean) it.next();
		
		%>
		
		
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
		<%
				}
			} 
			else{
				 %>
				 
				<h1>Nessun prodotto trovato</h1> 
				
				 <%
			}
		%>
		<jsp:include page="Footer.jsp" />
</body>
</html>