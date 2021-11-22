<%-- 
    Document   : registro
    Created on : 7 oct. 2021, 8:53:23
    Author     : Juanmi 2º DAW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        body{
            width: 60%;
            border: 1px solid black;
            padding: 2%;
            justify-content: center;
            align-content: center;
            margin:auto;

        }

        input{
            margin: 0.5em;
            padding: 0.5em;
            margin:auto;
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuarios</title>
    </head>
    <body>
        <h1>Página de Registro de Usuarios Nuevos</h1>
        <form name='form' action="MiServlet?action=registrar" method='post'>
            <br>
            <table>
                <tr>
                    <td>Datos del Nuevo Usuario:</td>
                    <td><input type='text' name='nombreUsuario' required="" value='' placeholder="Nombre"></td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input type='password' name='claveUsuario' required="" value='' placeholder="Contraseña" /></td>
                </tr>
                <tr>
                    <td>Repite tu Contraseña:</td>
                    <td><input type='password' name='claveUsuarioRep' required="" value='' placeholder="Repite Contraseña"/></td>
                </tr>
                <tr>
                    <td colspan='2'><input name="registrar" type="submit"  value="Registrar" /></td>
                </tr>
            </table>
            <br/>

            <%
                String msg = (String) request.getParameter("msg");
                if (msg != null){
                    out.println(msg);}
            %>

            <a href="index.html">Ir a login </a>    

        </form>
    </body>
</html>
