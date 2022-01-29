package Controller;

import Dao.ProductoDB;
import Dao.UsuarioDB;
import Dao.VentaDB;
import Dto.Producto;
import Dto.Venta;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class compra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtenemos el id del producto.
        int id = Integer.parseInt(request.getParameter("id"));
        //Creamos el objeto ProductoDB para obtener el producto de la base de datos.
        ProductoDB pdb = new ProductoDB();
        //Creamos un objeto producto para guardar la información.
        Producto p = pdb.getProducto(id);
        //Creamos un objeto UsuarioDB para buscar el id del usuario.
        UsuarioDB db = new UsuarioDB();
        //Obtenemos el id del usuario según el nombre de la sesión creada.
        int idUsuario = db.getIdUsuario((String) request.getSession().getAttribute("usuario"));
        //Creamos el objeto venta.
        Venta v = new Venta(0, id, idUsuario, p.getPrecio());
        //Creamos el objeto VentaDb para registrar la venta en la BD.
        VentaDB vdb = new VentaDB();
        //Registramos la venta.
        vdb.registrarVenta(v);
        //Creamos el mensaje de venta.
        String msg = "Venta realizada con exito";
        //Redireccionamos.
        response.sendRedirect("userView.jsp?rta=" + msg);
    }

}
