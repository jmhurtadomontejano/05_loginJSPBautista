<%-- 
    Document   : registrarUsuario
    Created on : 07-oct-2021, 16:27:28
    Author     : DAW-A
--%>

<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
           String msg= "";
           
           
           //String ruta= config.getServletContext().getRealPath("")+File.separator+"Archivos"+File.separator+"usuarios.csv";
            String ruta= config.getServletContext().getRealPath("")+File.separator+"archivos"+File.separator+"usuarios.csv";
           //String ruta= "C:/xampp/htdocs/Bautista/JSP/04_LoginJSP_v1/src/main/webapp/Archivos/usuarios.csv";
           OutputStreamWriter isw = new OutputStreamWriter(new FileOutputStream(ruta, true), "UTF-8");
           BufferedWriter bw = new BufferedWriter(isw);
           
           String nomUsu = request.getParameter("usuario");
           String claUsu = request.getParameter("password");
           String claUsuRep = request.getParameter("confirmPassword");
           
           if(claUsu.equals(claUsuRep)){
               bw.write("\n");
               bw.write(nomUsu + "," + claUsu);
               bw.close();
               isw.close();
               msg = "Usuario registrado correctamente";
           }else{
               msg = "Registro no registrado. No coinciden las contraseñas";
           }
           response.sendRedirect("registro.jsp?msg=" + msg);

           %>
    </body>
</html>
