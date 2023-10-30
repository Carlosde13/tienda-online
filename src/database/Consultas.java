/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tiendaonline.models.Cliente;
import tiendaonline.models.Estado;
import tiendaonline.models.Pedido;
import tiendaonline.models.Producto;

/**
 *
 * @author deleo
 */
public class Consultas {
    
    public static Producto getProductosDisponibles() {
        Connection connection = Conexion.conexion();
        Producto producto = null;

        if (connection != null) {
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                String query = "SELECT * FROM PRODUCTO WHERE cantidad > 0";
                statement = connection.prepareStatement(query);
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String descripcion = resultSet.getString("descripcion");
                    int cantidad = resultSet.getInt("cantidad");
                    String  fecha_ingreso = resultSet.getString("fecha_ingreso");

                    producto = new Producto();
                    producto.setId(id);
                    producto.setDescripcion(descripcion);
                    producto.setCantidad(cantidad);
                    producto.setFecha_ingreso(fecha_ingreso);
                }
            } catch (SQLException e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
        return producto;
    }
    public static Cliente getCliente(int id) {
        Connection connection = Conexion.conexion();
        Cliente cliente = null;

        if (connection != null) {
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                String query = "SELECT * FROM CLIENTE WHERE id = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    int idCliente = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String telefono = resultSet.getString("telefono");
                    String email = resultSet.getString("email");
                    String  fecha_ingreso = resultSet.getString("fecha_ingreso");

                    cliente = new Cliente();
                    cliente.setId(idCliente);
                    cliente.setNombre(nombre);
                    cliente.setTelefono(telefono);
                    cliente.setEmail(email);
                    cliente.setFecha_ingreso(fecha_ingreso);
                }
            } catch (SQLException e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
        return cliente;
    }
    public static Estado getEstado(int id) {
        Connection connection = Conexion.conexion();
        Estado estado = null;

        if (connection != null) {
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                String query = "SELECT * FROM ESTADO WHERE id = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    int idCliente = resultSet.getInt("id");
                    String descripcion = resultSet.getString("descripcion");

                    estado = new Estado();
                    estado.setId(idCliente);
                    estado.setDescripcion(descripcion);

                }
            } catch (SQLException e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
        return estado;
    }
    public static Pedido getPedido(int idCliente) {
        Connection connection = Conexion.conexion();
        Pedido pedido = null;

        if (connection != null) {
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                String query = "SELECT * FROM PEDIDO WHERE cliente_id = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, idCliente);
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int idCli = resultSet.getInt("cliente_id");
                    int idEst = resultSet.getInt("estado_id");
                    String fecha = resultSet.getString("fecha");

                    Cliente cl = new Cliente ();
                    cl = getCliente(idCliente);
                    Estado est = new Estado ();
                    est = getEstado (idEst);
                    
                    pedido = new Pedido();
                    pedido.setId(id);
                    pedido.setCliente(cl);
                    pedido.setEstado(est);
                    pedido.setFecha(fecha);
                }
            } catch (SQLException e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
        return pedido;
    }
    public static List<Pedido> getPedidosEnviadosPendientes() {
        List<Pedido> resultados = new ArrayList<>();
        Connection connection = Conexion.conexion();

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM PEDIDO";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int cliente_id = resultSet.getInt("cliente_id");
                    int estado_id = resultSet.getInt("estado_id");
                    String fecha = resultSet.getString("fecha");
                    
                    
                    Cliente cl = new Cliente ();
                    cl = getCliente(cliente_id);
                    Estado est = new Estado ();
                    est = getEstado (estado_id);

                    Pedido p = new Pedido();
                    p.setId(id);
                    p.setCliente(cl);
                    p.setEstado(est);
                    p.setFecha(fecha);
                    
                    if(est.getDescripcion()=="PENDIENTE" || est.getDescripcion()=="ENVIADO"){
                        resultados.add(p);
                    }
                    
                }

                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }

        return resultados;
    }
}
