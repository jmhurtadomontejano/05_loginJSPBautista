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

    @Override
    public void init(ServletConfig config) throws ServletException {
        //  ruta = config.getServletContext().getRealPath("") + File.separator + "archivos" + File.separator + "usuarios.csv";
    }

    //@Override intento ruta
    // public void init(ServletConfig config) throws ServletException{
    // ruta= config.getServletContext().getRealPath("")+File.separator+"archivos"+File.separator+"usuarios.csv";
    // }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    /*    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean encontrado = false;

        //String ruta = "C:/xampp/htdocs/Bautista/JSP/04_LoginJSP_v1/src/main/webapp/Archivos/usuarios.csv";
        UsuarioDB bd = new UsuarioDB();
        ArrayList<Usuario> listaUsuarios = bd.getListaUsuarios();
        String usuario = request.getParameter("nombreUsuario");
        String pass = request.getParameter("claveUsuario");
        
        out.println(listaUsuarios);
        
        
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
    }*/
  protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean encontrado = false;
        UsuarioDB bd = new UsuarioDB();
        ArrayList<Usuario> listaUsuarios = bd.getListaUsuarios();
        String nombre = request.getParameter("nombreUsuario");
        String passwd = request.getParameter("claveUsuario");

        for (Usuario u : listaUsuarios) {
            if (u.getUsuario().equals(nombre) && u.getClave().equals(passwd)) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            response.sendRedirect("correcto.jsp?nombre=" + nombre);
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
