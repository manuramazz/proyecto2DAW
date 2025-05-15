package minitienda;

import minitienda.Carrito;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class EliminarItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        HttpSession session = request.getSession(false);
        if (session != null) {
            Carrito carrito = (Carrito) session.getAttribute("carrito");
            if (carrito != null) {
                carrito.removeItem(titulo);
            }
        }
        response.sendRedirect("VistaCarrito");
    }
}
