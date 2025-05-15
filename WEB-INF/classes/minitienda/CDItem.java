package minitienda;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class CDItem implements Serializable {
    private String titulo;
    private String artista;
    private String pais;
    private double precio;
    private int cantidad;

    public CDItem() {}

    public CDItem(String titulo, String artista, String pais, double precio, int cantidad) {
        this.titulo = titulo;
        this.artista = artista;
        this.pais = pais;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // getters y setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    // importe total de este item
    public double getImporte() {
        return precio * cantidad;
    }

    // formato moneda
    public String getImporteFormateado() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-ES"));
        return nf.format(getImporte());
    }
}