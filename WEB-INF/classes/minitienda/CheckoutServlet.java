package minitienda;
import minitienda.Carrito;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class CheckoutServlet extends HttpServlet {

    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String adress) throws ServletException, IOException {
		//Creamos un objeto de la clase RequestDispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher(adress);
		dispatcher.forward(request, response);

	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Carrito carrito = null;
        if (session != null) {
            carrito = (Carrito) session.getAttribute("carrito");
        }
        request.setAttribute("total", carrito == null ? 0.0 : carrito.getTotalFormateado());
        //request.setAttribute("total","Hola Mundo");
        // limpiamos el carrito
        if (carrito != null) carrito.clear();
        gotoPage(request,response,"/checkout.jsp");
    }
}