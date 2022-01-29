package Controller;

import Dao.UsuarioDB;
import Dto.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class inicioSesion extends HttpServlet {

    /**
     * El método doPost recibe los parámetros a través del método post, es decir
     * los datos viajan encriptados.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtenemos los datos que vienen del formulario
        //Lo que ponemos como argumento en getParameter es el nombre o id del campo del formulario.
        String usuario = request.getParameter("nombreUsuario");
        String pass = request.getParameter("claveUsuario");

        //Creamos ahora un objeto UsuarioDB para buscar el usuario en la base de datos.
        UsuarioDB db = new UsuarioDB();
        Usuario u = db.getUsuario(usuario);
        //Si el usuario es distinto de null, quiere decir que existe.
        if (u != null) {
            //Verificamos que la clave del usuario sea igual a la clave ingresada.
            if (u.getClave().equals(pass)) {
                //Creamos la sesión con el objeto HttpSession
                HttpSession sesion = request.getSession();
                //Le damos un atributo a la sesión para verificar que si exista una sesión.
                sesion.setAttribute("usuario", usuario);
                //Verificamos que el usuario sea admin o distinto de admin, para hacer la redirección a la página donde deba.
                if (usuario.equals("admin")) {                    
                    response.sendRedirect("adminView.jsp");
                } else {
                    response.sendRedirect("userView.jsp");
                }
            } else {
                //Si las pass no son correctas no puede iniciar sesión, por lo tanto lo enviamos a la página de error.
                request.setAttribute("msgError", "Contraseña incorrecta, intentelo nuevamente.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
            //Si el usuario es null, quiere decir que ese usuario no existe, por lo tanto lo mandamos a la página de error.
            request.setAttribute("msgError", "Usuario no existe, intentelo nuevamente.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
