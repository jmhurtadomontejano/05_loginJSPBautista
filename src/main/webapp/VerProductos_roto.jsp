<%-- 
    Document   : VerProductos
    Created on : 30 sept. 2021, 10:33:36
    Author     : bauti
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Producto"%>
<%@page import="modelo.ProductoDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Categoría</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                </tr>
            </thead>

            <tbody>
                
                <%
                    String ruta= config.getServletContext().getRealPath("")+"/Archivos/catalogo.csv";
                    ProductoDB db = new ProductoDB(ruta);
                    List<Producto> lista = db.getCatalogo();
                    for (Producto prod : lista) {
                        out.println("<tr>");  //filas
                        out.println("<td>" + prod.getId() + "</td>");
                        out.println("<td>" + prod.getCategoria() + "</td>");
                        out.println("<td>" + prod.getNombre() + "</td>");
                        out.println("<td>" + prod.getPrecio() + " €</td>");
                        out.println("</tr>");
                    }
                %>
            </tbody>
        </table>
</body>
</html>
