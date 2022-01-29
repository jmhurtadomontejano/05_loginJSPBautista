<%-- 
    Document   : menu
    Created on : 19-dic-2021, 10:17:08
    Author     : jmhur
--%>

<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <header>
        <c:import url="menu.jsp"></c:import><!-- Esta linea incluye toda la barra de menu-->
            <h3>
            <c:if test="${not empty mensaje}"><!-- si hay mensaje de advertencia -->
                <c:out value="${msg}"></c:out> <!-- out muestra los mensajes -->
            </c:if>
    </header>
    <head>
        <title>Inicio</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center> 
        <% String usuario = (String) request.getSession().getAttribute("usuario");%>
        <% if (usuario != null) {%>
        <h3> Has iniciado sesión con el usuario:  <%=usuario%>   </h3>
        <% }else{%>
        <h3>Todavía no se ha iniciado sesión</h3>
        <% } %>
        <h2>Sistema de Administracion (HTML V1 Juanmi) Comprobar</h2>
        <br>
        <img src='images/login.jpg'><br>
        <br>
        <!-- En el action definimos a donde queremos llevar los datos para procesar.
             En este caso iremos a Source Packages -> Controller -> inicioSesion y los procesaremos por el método doPost
        -->        
        <form action="inicioSesion.do" method="post" name="formulario">
            <br>
            <table><!-- En esta tabla introducimos los inputs necesarios para que el usuario se logué -->
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" name="nombreUsuario" id="nombreUsuario" required></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="claveUsuario" id="claveUsuario" required /></td>
                </tr>
                <tr>
                    <!-- el siguiente enlace de texto me redirige a la página para registrar nuevos usuarios -->        
                    <td><a class='button' href="registro.jsp">Registrar usuario nuevo</a></td>
                    <!-- El siguiente boton de Login ejecuta el action del form action="inicioSesion.do" por method="post"-->
                    <td><input name="login" type="submit"  value="login" /></td>
                </tr>
            </table>
            <br>

        </form>
    </center>

</body>
</html>
