
<%-- 
    Document   : comprobarLogin
    Created on : 29 sept. 2021, 9:56:36
    Author     : bauti
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>
<%@page import="java.io.File" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprobar login</title>
    </head>
    <body>
        <h1>Comprobando login</h1>
        <%
            boolean encontrado = false;
            
            //String ruta= config.getServletContext().getRealPath("")+"/Archivos/usuarios.csv";
            //String ruta = "C:/xampp/htdocs/Bautista/JSP/04_LoginJSP_v1/src/main/webapp/Archivos/usuarios.csv";
             String ruta= config.getServletContext().getRealPath("")+File.separator+"archivos"+File.separator+"usuarios.csv";
            UsuarioDB bd = new UsuarioDB(ruta);
            ArrayList<Usuario> listaUsuarios = bd.getListaUsuarios();
            String usuario = request.getParameter("usuario");
            String pass = request.getParameter("password");
            for (Usuario usu : listaUsuarios) {
                if (usu.getUsuario().equals(usuario) && usu.getClave().equals(pass)) {
                    encontrado = true;
                    break;
                }//if
            }//for
            if (encontrado) {
                response.sendRedirect("correcto.jsp?nombre=" + usuario);
            } else {
                response.sendRedirect("error.jsp");
                
            }

        %>
    </body>
</html>

