package minitienda;
import minitienda.Carrito;

import java.sql.*;

public class PedidoDAO {

    private Connection con;

    public PedidoDAO(Connection connection){
        this.con = connection;
    }

    public Connection getConexion() {
        return this.con;
    }

    public void setConexion(Connection con) {
        this.con = con;
    }

    public Pedido guardarPedido(String email, double total){

        Pedido resultado = new Pedido();
        int idPedido = 0;
        PreparedStatement stmGuaPed=null;
        boolean exito = false;

        try{
            stmGuaPed = con.prepareStatement("INSERT into pedidos (usuario_email,total) values (?,?)",
            Statement.RETURN_GENERATED_KEYS);
            stmGuaPed.setString(1,email);
            stmGuaPed.setDouble(2,total);
            if(stmGuaPed.executeUpdate()>0){
                exito=true;
                ResultSet keys = stmGuaPed.getGeneratedKeys();
                if(keys.next()) idPedido = keys.getInt(1);
                keys.close();
            }else {
                exito=false;
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try {stmGuaPed.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }

        if(!exito){
            resultado = null;
            return resultado;
        }

        PreparedStatement stmPedido = null;
        ResultSet rsPedido = null;
        try{
            stmPedido = con.prepareStatement("SELECT * FROM pedidos WHERE id=? ");
            stmPedido.setInt(1,idPedido);
            rsPedido = stmPedido.executeQuery();

            if(rsPedido.next()){
                resultado.setId(rsPedido.getInt("id"));
                resultado.setEmail(rsPedido.getString("usuario_email"));
                resultado.setTotal(rsPedido.getDouble("total"));
                resultado.setFecha(rsPedido.getTimestamp("fecha"));
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{rsPedido.close();}catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
            return resultado;
        }
}
