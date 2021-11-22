<%-- 
    Document   : VerProductos
    Created on : 07-oct-2021, 16:12:01
    Author     : DAW-A
--%>

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
            ProductoDB db = new ProductoDB();
            List<String> cabecera = db.getCabecera();
            String c =  cabecera.get(2);
        %>
        <h1><%= c%></h1>
        <table>
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
