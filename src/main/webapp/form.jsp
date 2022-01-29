<%-- Página que se encarga de mostrar un formulario para el registro o modificación de un artículo. --%>
<%@page import="Dto.Producto"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <header>
        <c:import url="menu.jsp"></c:import><!-- Esta linea incluye toda la barra de menu-->
        <h3>
            <c:if test="${not empty mensaje}"><!-- si hay mensaje de advertencia -->
                <c:out value="${msg}"></c:out> <!-- out muestra los mensajes -->
            </c:if>
    </header>
    <head>
        <meta charset="utf-8">
        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>
        <title><%=request.getAttribute("titulo")%></title>
    </head>
    <body>
    <center>
        <h2><%=request.getAttribute("desc")%> </h2>
        <%
            //Obtenemos el producto que obtuvimos de form.do (Si existe)
            Producto p = (Producto) request.getAttribute("producto");
            //Si el id del producto es mayor a 0, quiere decir que se puede editar.
            boolean editar = p.getId() > 0;
        %>
        <form name='form' action="registroProducto.do" method='post'>
            <br>
            <table>
                <input type='hidden' id='msg' name='msg' value="<%= editar ? "Modificar Producto" : "Agregar Producto"%>">
                <input type='hidden' id='idProducto' name='idProducto' value="<%= editar ? p.getId() : 0%>">
                <tr>
                    <td>Categoria:</td>
                    <td><input type='text' name='categoria' id='categoria' value="<%= editar ? p.getCategoria() : ""%>" 
                               required></td>
                </tr>
                <tr>
                    <td>Nombre: </td>
                    <td><input type='text' name='nombre' id='nombre' value="<%= editar ? p.getNombre() : ""%>" 
                               required></td>

                </tr>
                <tr>
                    <td>Precio: </td>
                    <td><input type='number' name='precio' id='precio' value="<%= editar ? p.getPrecio() : ""%>" 
                               required></td>

                </tr>
                <tr>
                    <td><a class='button' href="adminView.jsp">Volver </a></td>
                    <td><input name="registrar" type="submit"  value="<%=request.getAttribute("titulo")%>" /></td>
                </tr>
            </table>
            <br/>            
        </form>
    </center>
</body>
</html>
