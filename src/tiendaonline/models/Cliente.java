package tiendaonline.models;

import java.util.Date;

/**
 *
 * @author deleo
 */
public class Cliente {
    private int id ;
    private String nombre;
    private String telefono;
    private String email;
    private String fecha_ingreso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Cliente(int id, String nombre, String telefono, String email, String fecha_ingreso) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fecha_ingreso = fecha_ingreso;
    }

    public Cliente() {
    }
}
