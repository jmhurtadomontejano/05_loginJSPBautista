/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import static java.io.FileDescriptor.out;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexion;
import modelo.Usuario;
import modelo.UsuarioDB;
import modelo.Producto;
import servlet.MiServlet;


/**
 *
 * @author DAW-A
 */
@WebServlet(name = "MiServlet", urlPatterns = {"/MiServlet"})
public class MiServlet extends HttpServlet {

    //String ruta = "";
    Connection con;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MiServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MiServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = "";

        String nomUsu = request.getParameter("nombreUsuario");
        String claUsu = request.getParameter("claveUsuario");
        String claUsuRep = request.getParameter("claveUsuarioRep");
        try {
            if (claUsu != "" && nomUsu != "") {
                if (claUsu.equals(claUsuRep)) {

                    con = Conexion.getConexion();

                    String sql = "INSERT INTO PRODUCTOSDB.USUARIOS"
                            + "(`id`, `nombre`, `password`) VALUES (NULL, '" + nomUsu + "', '" + claUsu + "')";

                    Statement st = con.createStatement();
                    st.executeUpdate(sql);
                    msg = "Usuario registrado correctamente.";

                } else {
                    msg = "Registro no registrado. No coinciden las contrase�as.";
                }
            } else {
                msg = "Tienes que rellenar los datos.";
            }
        } catch (SQLException ex) {
            msg = "Registro no valido";
        }

        response.sendRedirect("registro.jsp?msg=" + msg);
    }

  protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//Declaro una variable ENCONTRADO para igualarla a true en caso de que se encuentren las credenciales
        boolean encontrado = false;
//Declaramos una variable BD de tipo USUARIOBD
        UsuarioDB bd = new UsuarioDB();
//Creo un arrayList de Usuarios LISTAUSUARIOS y llamo al metodo de UsuarioDB
//BD.GETLISTAUSUARIOS();
        ArrayList<Usuario> listaUsuarios = bd.getListaUsuarios();
//Recojo los parametros enviados por Formulario POST
        String nombre = request.getParameter("nombreUsuario");
        String passwd = request.getParameter("claveUsuario");
//Creamos un bucle para comparar cada usuario guardado en LISTAUSUARIOS
        for (Usuario u : listaUsuarios) {
//En caso de que encuentre algun usuario de la lista con el mismo nombre y clave
//entrará dentro del if, iguala la variable encontrado a true y rompe el bucle
            if (u.getUsuario().equals(nombre) && u.getClave().equals(passwd)) {
                encontrado = true;
                break;
            }
        }
//si encuentra el usuario redirige a correcto.jsp con el nombre encontrado
        if (encontrado) {
            response.sendRedirect("correcto.jsp?nombre=" + nombre);
//si no encuentra el usuario redirige a error.jsp
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("action");
        UsuarioDB bd = new UsuarioDB();
        ArrayList<Usuario> listaUsuarios = bd.getListaUsuarios();
        if (accion.equals("login")) {
            login(request, response);
        } else if (accion.equals("registrar")) {
            registrarUsuario(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
