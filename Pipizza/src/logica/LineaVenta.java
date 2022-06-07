package logica;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LineaVenta {

	private Producto producto;
	private int id_pedido;
	private int cantidad;
	
	public LineaVenta(Producto producto, int id_pedido, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public static void registrarLineaVenta(Conexion c, LineaVenta linea) {
		Connection conec = c.conexionBBDD();
		if (conec != null) {
			try {
				//codigo de mysql para insertar datos en la tabla pedido
				String insert = "INSERT INTO lineaventa  (id_producto, id_pedido, cantidad) "
						+ "VALUES("+ linea.getProducto().getId()+", "+ linea.getId_pedido() +", "+ linea.getCantidad() +");";
				
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

}
