<%-- 
    Document   : respuesta
    Created on : 29 sept. 2021, 10:09:19
    Author     : bauti
--%>
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
        <h2>Usuario correcto</h2>
        <h3>Tus credenciales son correctass</h3>
        <br/><br/>

        <%!  String nom = "";%>
        <% nom = (String) request.getParameter("nombre");%>

        <h3> Bienvenido  <%= nom%>  </h3>
        <br/><br/>
        
        <jsp:include page="VerProductos.jsp"/>
        <br>
        <a href="index.html">Volver a la pantalla de Logueo</a>

       <%--  <jsp:include  page="VerProductos.jsp"  />  --%>

    </center>
</body>
</html>
