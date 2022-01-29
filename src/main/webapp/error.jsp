
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceso incorrecto</title>
    </head>
    <body>
    <center>
        <%
            //Insertamos código java, para poder recibir el error que mandamos desde inicioSesion.java
            String msg = (String) request.getAttribute("msgError");
        %>
        <!-- Realizamos la impresión del mensaje msg que captamos arriba -->
        <h3><%=msg %></h3>
        <%
            //Elimino el atributo para evitar errores en futuras ejecuciones.
            request.removeAttribute("msgError");
        %>
        <a href="index.jsp">Vuelva a intentarlo</a>
    </center>
    </body>
</html
