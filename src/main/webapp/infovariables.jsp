<%-- 
    Document   : infovariables
    Created on : 19-dic-2021, 12:12:40
    Author     : jmhur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>InfoVariables</title>
    </head>
    <body>
        <section class="cabecera">
            <div>
                <h2>Usuario identificado</h2>
                <h3>Las credenciales son correctass</h3>
                <!-- Declaro la variable nom para almacenar el parametro recibido del servlet?Login -->
                <% String usuario = (String) request.getSession().getAttribute("elUsuario");%>


                <h3> Bienvenido  <%=usuario%>   </h3>
            </div><!-- cierre caja bienvenida usuario -->
            <div>
                <h2>TIPOS DE VARIABLES</h2>

                <%-- USANDO java embebido --%>
                <h3> USANDO java embebido </h3>
                <% String id = request.getSession().getId();%>
                <p> variable de Session:-->  <%=id%> </p>
                <%  usuario = (String) request.getSession().getAttribute("elUsuario");%>
                <p> variable de Usuario:-->  <%=usuario%> </p>
                <% String producto = (String) request.getAttribute("elProducto");%>
                <p> variable de Request:-->  <%=producto%> </p>


                <%-- USANDO Expression language --%>
                <h3> USANDO Expresion Language </h3>
                <p>variable sesion (idSession):--> ${pageContext.session.id} </p>
                <p>variable Usuario (Usuario):--> ${elUsuario} </p>
                <p>variable de Request-->  ${elProducto}</p>
                <p>variable de APLICACION--> </p>
            </div>
        </section>


    </body>
</html>
