<%-- 
    Document   : menu
    Created on : 04-nov-2021, 10:17:08
    Author     : jmhur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>
    </head>

    <!--   <h1>Menu</h1> -->
    <nav>
        <ul id="menu_usuario">
            <li><a href="index.jsp">Inicio</a></li>
                <% HttpSession idSession = request.getSession();
                    String usuario = (String) idSession.getAttribute("usuario");
                    if (usuario != null) {
                %>

            <li class="menuDesplegable">Articulos
                <div class="menuDesplegable-content">
                    <%
                        if (usuario.equals("admin")) {
                    %>
                    <a href="form.do">Insertar Articulo</a>
                    <% } %>
                    <!--   <a href="MiServlet?action=registrarArticulo">Insertar Articulo</a> -->
                    <a 
                        <% if (usuario.equals("admin")) {   %>

                        href="adminView.jsp"
                        <%} else { %>
                        href="userView.jsp"

                        <% } %>
                        >Mostrar listado de Articulos</a>
                    <!--   <a href="MiServlet?accion=registroArticulo">Mostrar listado de Articulos</a> -->
            </li>
            <%} else {
                }%>
        </ul>
    </nav>
    <c:if test="${not empty mensaje}">
        <h3 class="eliminar">
            <c:out value="${mensaje}"></c:out>
            </h3>
    </c:if>

    <%
        String msg = (String) request.getParameter("msg");
        if (msg != null) {
            out.println(msg);
        }
    %>

</html>
