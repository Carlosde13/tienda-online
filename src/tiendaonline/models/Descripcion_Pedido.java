package tiendaonline.models;

/**
 *
 * @author deleo
 */
public class Descripcion_Pedido {
    private int id;
    private Pedido pedido;
    private Producto producto;

    public Descripcion_Pedido(int id, Pedido pedido, Producto producto) {
        this.id = id;
        this.pedido = pedido;
        this.producto = producto;
    }

    public Descripcion_Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
