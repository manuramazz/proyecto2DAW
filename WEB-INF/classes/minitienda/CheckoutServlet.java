package minitienda;
import minitienda.Carrito;
import minitienda.Helper;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class CheckoutServlet extends HttpServlet {
    Pedido pedido = null;
    Usuario usuario = null;


    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String adress) throws ServletException, IOException {
		//Creamos un objeto de la clase RequestDispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher(adress);
		dispatcher.forward(request, response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //iniciamos la base de datos
        Helper.iniciarBD();
        HttpSession session = request.getSession(false);
        Carrito carrito = null;
        if (session != null) {
            carrito = (Carrito) session.getAttribute("carrito");
        }
        if (carrito == null) {
            request.setAttribute("error", "No hay carrito en la sesion");
            gotoPage(request, response, "/error.jsp");
            return;
        }
        //recuperar los datos del formulario
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");
        String tarjeta_tipo = request.getParameter("tarjeta_tipo");
        String tarjeta_numero = request.getParameter("tarjeta_numero");


        boolean esRegistro = Helper.esRegistro(request);

        //boolean esRegistro = tarjeta_tipo != null && !tarjeta_tipo.isBlank() && tarjeta_numero != null && !tarjeta_numero.isBlank();

        //INICIO SESION
        if(!esRegistro){
            System.out.println("Inicio de sesion");
            //validar el usuario
            usuario = Helper.validarUsuario(email, contrasena);
            if(usuario != null){
                //guardar el pedido
                double total = carrito.getTotal();
                pedido = Helper.guardarPedido(email, total);
            }else{
                request.setAttribute("error", "El usuario o contraseña no son correctos");
                gotoPage(request,response,"/error.jsp");
            }       
        }

        //REGISTRO
        else{
            System.out.println("Registro");
            //guardar el usuario
            if(Helper.registrarUsuario(email, contrasena, tarjeta_tipo, tarjeta_numero)){
                //guardar el pedido
                double total = carrito.getTotal();
                pedido = Helper.guardarPedido(email, total);
                usuario = new Usuario(email,contrasena,tarjeta_tipo,tarjeta_numero);
                
            }else{
                request.setAttribute("error", "El usuario no está disponible");
                gotoPage(request,response,"/error.jsp");
            }
        }
        request.setAttribute("pedido", pedido);
        request.setAttribute("usuario", usuario);
        Helper.cerrarBD();
        gotoPage(request,response,"/confirmacion.jsp");
    }
}