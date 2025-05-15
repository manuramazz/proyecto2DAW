package minitienda;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Carrito implements Serializable {
    private List<CDItem> items = new ArrayList<>();

    public Carrito() {}

    public List<CDItem> getItems() {
        return items;
    }

    public void addItem(CDItem nuevo) {
        // si ya existe, sumamos cantidades
        for (CDItem item : items) {
            if (item.getTitulo().equals(nuevo.getTitulo())) {
                item.setCantidad(item.getCantidad() + nuevo.getCantidad());
                return;
            }
        }
        items.add(nuevo);
    }

    public void removeItem(String titulo) {
        items.removeIf(i -> i.getTitulo().equals(titulo));
    }

    public double getTotal() {
        double suma = items.stream().mapToDouble(CDItem::getImporte).sum();
        BigDecimal bd = BigDecimal.valueOf(suma).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public String getTotalFormateado() {
        double total = getTotal();
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-ES"));
        return nf.format(total);
    }

    public void clear() {
        items.clear();
    }
}
