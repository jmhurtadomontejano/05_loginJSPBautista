<%-- 
    Document   : registro
    Created on : 7 oct. 2021, 8:53:23
    Author     : Juanmi 2º DAW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>
        <title>Registrar Usuarios</title>
    </head>
    <body>
    <center>
        <form name='form' action="registro.do" method='post'>
            <br>
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td><input type='text' name='nombreUsuario' placeholder="Nombre"></td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input type='password' name='claveUsuario' required placeholder="Contraseña" /></td>
                </tr>
                <tr>
                    <td><a class='button' href="index.jsp">Ir a login </a></td>
                    <td><input name="registrar" type="submit"  value="Registrar" /></td>
                </tr>
            </table>
            <br/>

            <%
                String msg = (String) request.getAttribute("msg");
                if (msg != null) {
                    out.println(msg);
                    request.removeAttribute("msg");
                }
            %>



        </form>
    </center>
</body>
</html>
