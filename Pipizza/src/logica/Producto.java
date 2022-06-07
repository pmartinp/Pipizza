package logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Producto {

	private int id;
	private String nombre;
	private float precio;
	private boolean alcohol;
	private int stock;
	private int tiempo_elaboracion;
	private String categoria;
	
	public Producto(int iD, String nombre, float precio, boolean alcohol, int stock, int tiempo_elaboracion, String categoria) {
		id = iD;
		this.nombre = nombre;
		this.precio = precio;
		this.alcohol = alcohol;
		this.stock = stock;
		this.categoria = categoria;
		this.tiempo_elaboracion = tiempo_elaboracion;
	}
	
	public Producto(String nombre, float precio, boolean alcohol, int stock, int tiempo_elaboracion, String categoria) {
		this.nombre = nombre;
		this.precio = precio;
		this.alcohol = alcohol;
		this.stock = stock;
		this.categoria = categoria;
		this.tiempo_elaboracion = tiempo_elaboracion;
	}

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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public boolean isAlcohol() {
		return alcohol;
	}
	public void setAlcohol(boolean alcohol) {
		this.alcohol = alcohol;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getTiempo_elaboracion() {
		return tiempo_elaboracion;
	}
	public void setTiempo_elaboracion(int tiempo_elaboracion) {
		this.tiempo_elaboracion = tiempo_elaboracion;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public static void registrarProducto(Conexion c, Producto producto) {
		Connection conec = c.conexionBBDD();
		if (conec != null) {
			try {
				//codigo de mysql para insertar datos en la tabla producto
				String insert = "INSERT INTO producto (nombre, precio, alcohol, stock, tiempo_elaboracion, categoria) "
						+ "VALUES('"+ producto.getNombre() +"', "+ producto.getPrecio() +", "+ producto.isAlcohol()
						+", "+ producto.getStock() +", "+ producto.getTiempo_elaboracion() +",'"+ producto.getCategoria() +"');";
				
				Statement ins = conec.createStatement();
				
				ins.executeUpdate(insert);
				System.out.println("\nDatos insertados correctamente");
				ins.close();
			} catch(SQLException e) {
				System.out.println("Se ha producido un error al insertar en la Base de datos.\n"+ e);
			} finally {
				c.cerrarConexion(conec);
			}
		}
	}
	public static ArrayList<Producto> extraerProductos(Conexion c) {
		Connection conec = c.conexionBBDD();
		ArrayList<Producto> productos = new ArrayList();
		if (conec != null) {
			try {
				//codigo de mysql para consultar los datos de la tabla producto
				String consulta = "SELECT * FROM producto;";
				
				Statement cons = conec.createStatement();
				
				if(cons.execute(consulta)) {
					ResultSet res = cons.getResultSet();
					while(res.next()) {
						Producto producto = new Producto(res.getInt(1), res.getString(2), res.getFloat(3), res.getBoolean(4),
								res.getInt(5), res.getInt(6), res.getString(7));
						productos.add(producto);
					}
				}
				return productos;
			} catch(SQLException e) {
				System.err.println(e);
				return null;
			} finally {
				c.cerrarConexion(conec);
			}
		}
		return null;
	}
	public static void borrarProductos(Conexion c, Producto producto) {
		Connection conec = c.conexionBBDD();
		if (conec != null) {
			try {
				//codigo de mysql para borrar datos en la tabla producto
				String delete = "DELETE FROM producto WHERE id_producto = "+producto.getId()+";";
				
				Statement del = conec.createStatement();
				
				del.executeUpdate(delete);
				System.out.println("\nDatos borrados correctamente");
				del.close();
			} catch(SQLException e) {
				System.out.println("Se ha producido un error al borrar en la Base de datos.\n"+ e);
			} finally {
				c.cerrarConexion(conec);
			}
		}
	}
	public static void actualizarProductos(Conexion c, Producto producto) {
		Connection conec = c.conexionBBDD();
		if (conec != null) {
			try {
				//codigo de mysql para actualizar datos en la tabla producto
				String update = "UPDATE producto SET id_producto = "+producto.getId() +", nombre = '"+ producto.getNombre() +"', "
						+ "precio = "+ producto.getPrecio() +", alcohol = "+ producto.isAlcohol() +", stock = "+ producto.getStock()
						+ ", tiempo_elaboracion = "+ producto.getTiempo_elaboracion() +", categoria = '"+ producto.getCategoria() +"' WHERE id_producto = "+producto.getId()+";";
				
				Statement upd = conec.createStatement();
				
				upd.executeUpdate(update);
				System.out.println("\nDatos actualizados correctamente");
				upd.close();
			} catch(SQLException e) {
				System.out.println("Se ha producido un error al insertar en la Base de datos.\n"+ e);
			} finally {
				c.cerrarConexion(conec);
			}
		}
	}
}
