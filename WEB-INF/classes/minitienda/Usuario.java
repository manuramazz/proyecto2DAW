package minitienda;


import java.sql.*;

public class Usuario{
    private String email;
    private String contrasena;
    private String tarjeta_tipo;
    private String tarjeta_numero;


    public Usuario(){}


    public Usuario(String email, String contrasena, String tarjeta_tipo, String tarjeta_numero) {
        this.email = email;
        this.contrasena = contrasena;
        this.tarjeta_tipo = tarjeta_tipo;
        this.tarjeta_numero = tarjeta_numero;
    }

    //getters y setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getTarjeta_tipo() {
        return tarjeta_tipo;
    }
    public void setTarjeta_tipo(String tarjeta_tipo) {
        this.tarjeta_tipo = tarjeta_tipo;
    }
    public String getTarjeta_numero() {
        return tarjeta_numero;
    }
    public void setTarjeta_numero(String tarjeta_numero) {
        this.tarjeta_numero = tarjeta_numero;
    }
}