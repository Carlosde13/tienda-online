package tiendaonline.models;

import java.util.Date;

/**
 *
 * @author deleo
 */
public class Producto {
    private int id;
    private String descripcion;
    private int cantidad;
    private String fecha_ingreso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Producto(int id, String descripcion, int cantidad, String fecha_ingreso) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.fecha_ingreso = fecha_ingreso;
    }

    public Producto() {
    }
}
