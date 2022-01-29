package Controller;

import Dao.UsuarioDB;
import Dto.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registro extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtenemos los datos del formulario.

        String usuario = request.getParameter("nombreUsuario");
        String pass = request.getParameter("claveUsuario");
        //Creamos un objeto usuario en el cuál almacenamos los datos del formulario.
        Usuario u = new Usuario(usuario,pass);
        //Creamos un objeto UsuarioDB para realizar el registro.
        UsuarioDB db = new UsuarioDB();
        db.registrar(u);
        
        request.setAttribute("msg", "Registro realizado con éxito");
        request.getRequestDispatcher("registro.jsp").forward(request, response);
        
    }
}
