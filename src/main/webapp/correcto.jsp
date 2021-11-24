<%@page import="java.util.ArrayList" %>
<%@page import="modelo.Producto" %>
<%@page import="java.util.List" %>
<%@page import="modelo.ProductoDB" %>
<%@page import="modelo.Usuario" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h2>Usuario identificado</h2>
        <h3>Las credenciales son correctass</h3>
<!-- Declaro la variable nom para almacenar el parametro recibido del servlet?Login -->
        <%!  String nom = "";%>
        <% nom = (String) request.getParameter("nombre");%>

        <h3> Bienvenido  <%= nom%>  </h3>
        <br/>
<!-- llamamos a VerProductos.jsp-->        
        <jsp:include page="VerProductos.jsp"/>
        <br>
        
        <a href="index.html">Volver a la pantalla de Logueo</a>

    </center>
</body>
</html>
