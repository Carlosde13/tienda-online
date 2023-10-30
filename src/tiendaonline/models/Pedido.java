package tiendaonline.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author deleo
 */
public class Pedido {
    private int id;
    private Cliente cliente;
    private Estado estado;
    private String fecha;
    private List<Producto> productos = new ArrayList<>();
    
    

//List<Planilla_trabajador> registros = new ArrayList<>();    

    public Pedido(int id, Cliente cliente, Estado estado, String fecha, List<Producto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.estado = estado;
        this.fecha = fecha;
        this.productos = productos;
    }

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    } 
    
    public void addProducto(Producto p){
        this.productos.add(p);
    }
}
