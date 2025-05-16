package minitienda;
import minitienda.Carrito;

import java.sql.*;

public class UsuarioDAO {

    private Connection con;

    public UsuarioDAO(Connection connection){
        this.con = connection;
    }

    public Connection getConexion() {
        return this.con;
    }

    public void setConexion(Connection con) {
        this.con = con;
    }

    public Usuario validarUsuario(String email, String contrasena) {
       
        
        PreparedStatement stmValUsu=null;
        ResultSet rsValUsu=null;


        try {
            stmValUsu=con.prepareStatement("SELECT * FROM usuarios WHERE email=? AND contrasena=?");
            stmValUsu.setString(1, email);
            stmValUsu.setString(2, contrasena);
            rsValUsu=stmValUsu.executeQuery();
            //si el resultado es mayor que 0, el usuario existe
            //delvolver el usuario
            if(rsValUsu.next()){
                Usuario usuario = new Usuario();
                usuario.setEmail(rsValUsu.getString("email"));
                usuario.setContrasena(rsValUsu.getString("contrasena"));
                usuario.setTarjeta_tipo(rsValUsu.getString("tarjeta_tipo"));
                usuario.setTarjeta_numero(rsValUsu.getString("tarjeta_numero"));
                return usuario;
            }
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try {
                stmValUsu.close();
                rsValUsu.close();
            } catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return null;
        
    }
        
 public boolean registrarUsuario(String email, String contrasena, String tarjeta_tipo, String tarjeta_numero ) {
        PreparedStatement stmRegUsu=null;
        
        try {
            stmRegUsu=con.prepareStatement("INSERT into usuarios (email,contrasena,tarjeta_tipo,tarjeta_numero) values (?,?,?,?)");
            stmRegUsu.setString(1, email);
            stmRegUsu.setString(2, contrasena);
            stmRegUsu.setString(3, tarjeta_tipo);
            stmRegUsu.setString(4, tarjeta_numero);
            //DEBERIAMOS DE COMPROBAR SI EL USUARIO YA EXISTE
            if(stmRegUsu.executeUpdate()>0){
                return true;
            }
            
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try {stmRegUsu.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return false;
    }
}
