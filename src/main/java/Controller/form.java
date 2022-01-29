package Controller;

import Dao.ProductoDB;
import Dto.Producto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class form extends HttpServlet {    

    /**
     * Está clase se encargará de cargar los datos en los campos del formulario.
     * Solo si estos existen.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //utilizamos el operador ternario para darle un valor de 0 o del idProducto a la variable id.
        int id = (request.getParameter("id")== null) ? 0 : Integer.parseInt(request.getParameter("id"));
        //Creamos un objeto producto para ver si existe el producto
        Producto p;
        //Creamos un String titulo para darle un título a la página donde mostraremos el formulario.
        String titulo;
        //Creamos un String desc para darle una descripción a la página del formulario
        String desc;
        //Creamos un objeto ProductoDB para realizar las operaciones de busqueda en la base de datos.
        ProductoDB db = new ProductoDB();
        //Si el id es distinto de 0 quiere decir que realizaremos una modificación
        if (id != 0) {
            p = db.getProducto(id);
            titulo = "Modificar Producto";
            desc = "Modifica los datos del producto";
        } 
        //Si el id no es distinto de 0 quiere decir que agregaremos un nuevo producto.
        else {
            p = new Producto();
            titulo = "Crear Producto";
            desc = "Introduce los datos del producto";
        }
        //Añado los atributos que creamos anteriormente por SetAttribute
        request.setAttribute("producto", p);
        request.setAttribute("desc", desc);
        request.setAttribute("titulo", titulo);
        
        //Hacemos la redirección a la vista del formulario.
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }
}
