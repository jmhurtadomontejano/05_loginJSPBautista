package Controller;

import Dao.ProductoDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mostrarProductos extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Creamos un productoDB para hacer la consulta a la base de datos y obtener los registros de productos.
        ProductoDB db = new ProductoDB();
        //Creamos el atributo que llevará la lista de productos de la base de datos.
        request.setAttribute("productos", db.getProductos());
    }
}
