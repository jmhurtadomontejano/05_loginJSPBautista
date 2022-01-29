package Controller;

import Dao.ProductoDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class borrar extends HttpServlet {

    /**
     * Este servlet se encarga de realizar una operación de borrado de la base
     * de datos.
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtenemos el valor del id dato por la url a través del botón.
        int id = Integer.valueOf(request.getParameter("id"));
        //Creamos un objeto ProductoDB para realizar la eliminación en la BD.
        ProductoDB db = new ProductoDB();
        //Llamamos al método borrar y eliminamos el producto, guardamos el true o false
        boolean borrado = db.delete(id);
        String msg;
        //Si se pudo borrar guardamos un mensaje de éxito.
        if(borrado){
            msg = "Producto borrado con exito";
        }
        //De lo contrario un mensaje de error.
        else{
            msg = "No se pudo eliminar el producto por que tiene una venta";
        }
        response.sendRedirect("adminView.jsp?rta=" + msg);
    }
}
