<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Producto"%>
<%@page import="modelo.ProductoDB"%>
<%@page import="modelo.Usuario"%>
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
//Creo un ProductoDB nuevo para poder tener acceso a los métodos de ProductoDB
            ProductoDB db = new ProductoDB();
//Creamos una variable cabecera para almacenar los datos de cabecera de productos en la BBDD
            List<String> cabecera = db.getCabecera();
            String c =  cabecera.get(2);
        %>
        <h1><%= c%></h1>
        <table>
            <thead>
                <tr>
<!-- A continuación mostramos los campos de cabecera llamandolos por su posición en el array-->                    
                    <th><%= cabecera.get(0) %></th>
                    <th><%= cabecera.get(1) %></th>
                    <th><%= cabecera.get(2) %></th>
                    <th><%= cabecera.get(3) %></th>
                </tr>
            </thead>
            <tbody>
                <%
//En el body creamos la variable lista que coje los datos de ProductoDb.getCatalogo
                    List<Producto> lista = db.getCatalogo();
//hacemos un for para que muestre 1 a 1 todos los productos
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
