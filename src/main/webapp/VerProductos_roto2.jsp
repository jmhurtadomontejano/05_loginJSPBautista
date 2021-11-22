<%-- 
    Document   : VerProductos
    Created on : 07-oct-2021, 16:12:01
    Author     : DAW-A
--%>

<%@page import="java.io.File"%>
<%@page import="modelo.Producto"%>
<%@page import="java.util.List"%>
<%@page import="modelo.ProductoDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                width: 100%;
            }
            table, th, td {
                border: 1px solid black;
                margin-left: auto;
                margin-right: auto;
                text-align: left;
            }
        </style>
    </head>
    <body>
        <h1>Listado de productos!</h1>
        <%
            //ruta Servidor
            //String ruta = config.getServletContext().getRealPath("")+"/Archivos/catalogo.csv";
            //String ruta = "C:\xampp\htdocs\Bautista\JSP\04_LoginJSP_v1\src\main\webapp\Archivos\catalogo.csv"; 
            //String ruta = "C:/xampp/htdocs/Bautista/JSP/04_LoginJSP_v1/src/main/webapp/Archivos/catalogo.csv"; 
            //String ruta= config.getServletContext().getRealPath("")+"/archivos/catalogo.csv";
            String ruta = config.getServletContext().getRealPath("") + File.separator + "archivos" + File.separator + "catalogo.csv";
            //String ruta = "C:/XAMPP/htdocs/Bautista/04_LoginJSP_v1/src/main/webapp/archivos/catalogo.csv";
            ProductoDB db = new ProductoDB(ruta);
            List<String> cabecera = db.getCabecera();
            String c =  cabecera.get(2);
        %>
        <p><%= c%></p>
        <table border="1">
            <thead>
                <tr>
                    <th><%= cabecera.get(0) %></th>
                    <th><%= cabecera.get(1) %></th>
                    <th><%= cabecera.get(2) %></th>
                    <th><%= cabecera.get(3) %></th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Producto> lista = db.getCatalogo();
                    for(Producto prod : lista){
                        out.print("<tr>");
                        out.print("<td>"+prod.getId()+"</td>");
                        out.print("<td>"+prod.getCategoria()+"</td>");
                        out.print("<td>"+prod.getNombre()+"</td>");
                        out.print("<td>"+prod.getPrecio()+" €</td>");
                        out.print("</tr>");
                    }
                %>
            </tbody>
        </table>
    </body>
</html>