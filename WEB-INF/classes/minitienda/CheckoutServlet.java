package minitienda;
import minitienda.Carrito;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class CheckoutServlet extends HttpServlet {

    Connection con = null;


    private void iniciarBD() {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println ( "Encontrado el driver de MySQL" );
        }
        catch(java.lang.ClassNotFoundException e)
        {
            System.out.println("MySQL JDBC Driver no encontrado ... ");
        }
        String url = "";
        String host = "localhost";
        String database = "minitienda";
        try
        {
            url = "jdbc:mysql://" + host + "/" + database;
            con = DriverManager.getConnection(url,"root","manu2004");
            System.out.println("Conexion establecida con " + url + "...");
        }
        catch (java.sql.SQLException e)
        {
            System.out.println("Conexion NO establecida con " + url);
        }
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String adress) throws ServletException, IOException {
		//Creamos un objeto de la clase RequestDispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher(adress);
		dispatcher.forward(request, response);

	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //iniciamos la base de datos
        iniciarBD();
        HttpSession session = request.getSession(false);
        Carrito carrito = null;
        if (session != null) {
            carrito = (Carrito) session.getAttribute("carrito");
        }
        //request.setAttribute("total", carrito == null ? 0.0 : carrito.getTotalFormateado());
        // limpiamos el carrito
        if (carrito != null) carrito.clear();
        gotoPage(request,response,"/checkout.jsp");
    }
}