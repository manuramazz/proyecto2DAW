package minitienda;
import minitienda.Carrito;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class VistaCarritoServlet extends HttpServlet {

    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String adress) throws ServletException, IOException {
		//Creamos un objeto de la clase RequestDispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher(adress);
		dispatcher.forward(request, response);
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // el JSP usara El para mostrar el carrito de sesio
        gotoPage(request, response, "/vistaCarrito.jsp");
    }
}