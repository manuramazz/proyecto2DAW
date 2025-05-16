package minitienda;
import minitienda.CheckoutServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Helper {
    private static Connection con;
    private static UsuarioDAO usuarioDAO;
    private static PedidoDAO pedidoDAO;

    public static void iniciarBD() {
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
            pedidoDAO = new PedidoDAO(con);
            usuarioDAO = new UsuarioDAO(con);
            System.out.println("Conexion establecida con " + url + "...");
        }
        catch (java.sql.SQLException e)
        {
            System.out.println("Conexion NO establecida con " + url);
        }
    }

    public static Usuario validarUsuario(String email, String contrasena) {
        return usuarioDAO.validarUsuario(email, contrasena);
    }
    public static Pedido guardarPedido(String email, double total) {
        return pedidoDAO.guardarPedido(email, total);
    }
    public static boolean registrarUsuario(String email, String contrasena, String tarjeta_tipo, String tarjeta_numero) {
        return usuarioDAO.registrarUsuario(email, contrasena, tarjeta_tipo, tarjeta_numero);
    }

    
    public static boolean esRegistro(HttpServletRequest request) {
        String tarjetaTipo = request.getParameter("tarjeta_tipo");
        String tarjetaNumero = request.getParameter("tarjeta_numero");
        return tarjetaTipo != null && !tarjetaTipo.isBlank() &&
               tarjetaNumero != null && !tarjetaNumero.isBlank();
    }

    public static void cerrarBD() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion: " + e.getMessage());
        }
    }

    

}