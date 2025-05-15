package minitienda;

import minitienda.CDItem;
import minitienda.Carrito;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.StringTokenizer;

public class AnhadirItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // parametros del formulario
        String datos = request.getParameter("cd"); 
        // formateamos: "Titulo|Artista|Pais|Precio"
        StringTokenizer t = new StringTokenizer(datos,"|");
        String titulo = t.nextToken();
        String artista = t.nextToken();
        String pais = t.nextToken();
        String precioString = t.nextToken();
        precioString = precioString.replace('$',' ').trim();
        double precio = Double.parseDouble(precioString);
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // creamos el bean item
        CDItem item = new CDItem(titulo, artista, pais, precio, cantidad);

        // recuperamos o creamos carrito en sesion
        HttpSession session = request.getSession();
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }

        // anhadimos
        carrito.addItem(item);

        // redirigimos a ver carrito
        response.sendRedirect("VistaCarrito");

    }
}
