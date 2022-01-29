package Controller;

import Dao.ProductoDB;
import Dto.Producto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registroProducto extends HttpServlet {



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
        //Obtenemos el mensaje para saber si debemos modificar o crear un producto.
        String msg = request.getParameter("msg");
        //Obtenemos los datos del formulario.
        int id = Integer.parseInt(request.getParameter("idProducto"));
        String nombre = request.getParameter("nombre");
        String categoria = request.getParameter("categoria");
        System.out.println(categoria);
        System.out.println(nombre);

        double precio = Double.parseDouble(request.getParameter("precio"));
        //Creamos el objeto producto
        Producto p = new Producto(id,categoria,nombre,precio);
        //Creamos el objeto ProductoDB para realizar el proceso con la base de datos.
        ProductoDB db = new ProductoDB();
        //Si el mensaje es modificar, modificaremos el producto.
        String rta;
        if(msg.equals("Modificar Producto")){
            db.update(p);
            rta = "Producto modificado con exito";
        }else{
            db.create(p);
            rta = "Producto creado con exito";
        }
        
        response.sendRedirect("adminView.jsp?rta=" + rta);
    }
}
