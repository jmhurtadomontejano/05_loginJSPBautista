<%-- 
    Document   : index
    Created on : 29 sept. 2021, 11:50:49
    Author     : bauti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Administración (JSP V1)</title>
    </head>
    <body>
    <center> 
        <h2>Sistema de Administracion (JSP)</h2>
        <br>
        <img src="/images/login.jpg"><br>		
        <br>
        <form name='form' action="MiServlet" method='post'>
            <br>
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td><input type='text' name='nombreUsuario' required="" value=''></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type='password' name='claveUsuario' required="" /></td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit" value="Login" /></td>
                </tr>
            </table>
            <br>
            <a href="registro.jsp">Registra un Usuario Nuevo</a>
        </form>
    </center>
</body>
</html>