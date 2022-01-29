<%@page import="Dto.Producto"%>
<%@page import="java.util.ArrayList"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>
        <!-- Incluimos el servlet que se encarga de traer los productos de la base de datos. -->
        <jsp:include page="mostrarProductos.do"></jsp:include>
            <title>Página de Administrador</title>
        </head>
        <body>
        <center>
            <!-- Declaro la variable usuario para almacenar el parametro "usuario" recibido del servlet?Login -->
        <% String usuario = (String) request.getSession().getAttribute("usuario");%>
        <h2>Bienvenido <%=usuario%> , Aquí podrás ver los productos y editarlos</h2>
        <br>
        <a type="button" href="form.do" class="button">Agregar Producto</a>

        <!-- válidamos la sesión, si no redirigimos.
            Verificamos que el usuario sea admin y no otro.
        -->
        <%
            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("usuario") == null || !sesion.getAttribute("usuario").equals("admin")) {
                response.sendRedirect("index.jsp");
            }
            sesion.setMaxInactiveInterval(60 * 10);
        %> 
        <%
            //Mostramos mensajes si así lo permite
            String msg = (String) request.getParameter("rta");
            if (msg != null) {
        %>
        <h2><%=msg%></h2>
        <%
            }
        %>
        <table>
            <thead>
                <tr>
                    <th>
                        Categoria
                    </th>
                    <th>
                        Nombre
                    </th>
                    <th>
                        Precio Unitario
                    </th>
                    <th>
                        Editar
                    </th>
                    <th>
                        Borrar
                    </th>

                </tr>
            </thead>
            <tbody>
                <%
                    //Hacemos java embebido para recoger la variable que nos trae el servlet mostrarProducdos.do
                    //Para poder añadir los productos con un for.
                    ArrayList<Producto> productos = (ArrayList) request.getAttribute("productos");
                    //Verificamos que hayan datos en la lista.
                    if (productos.size() > 0) {
                        //Hacemos un for-each para recorrer cada elemento de la lista.
                        for (Producto p : productos) {
                %>
                <tr>
                    <!---Incluimos código java de impresión y extraemos los datos de la clase producto. -->
                    <td><%=p.getCategoria()%> </td>
                    <td><%=p.getNombre()%> </td>
                    <td><%=p.getPrecio()%> </td>
                    <td><a type="button" href="form.do?id=<%=p.getId()%>" class="button">Actualizar</a> </td>
                    <!-- El evento onclick nos devuelve un cuadro de confirmación por si deseamos realmente eliminar o no -->
                    <td><a onclick="return confirm('¿Seguro que desea eliminar el articulo <%=p.getNombre()%>?');" type="button" href="borrar.do?id=<%=p.getId()%>" class="button">Borrar</a> </td>
                </tr>
                <%
                    }
                } else {
                    //Si la lista es vacía, imprimimos este mensaje en la tabla.

                %>
                <tr>
                    <td colspan="3">No hay productos</td>
                </tr>
                <%                    }
                    //Borramos el atributo en caso de que hayan errores.
                    request.removeAttribute("productos");
                %>                
            </tbody>
        </table>
    </center>
</body>
<!-- Insersión de JS de boostrap para animaciones. -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</html>
