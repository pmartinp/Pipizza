package logica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Venta {

	private int id_pedido;
	private int id_usuario;
	private float total;
	private Date fecha;
	private boolean llevar;
	private int tiempo_llegada=0;
	private ArrayList<LineaVenta> productos;
	
	public Venta(int id_pedido, int id_usuario, Date fecha, float total, boolean llevar, int tiempo_llegada) {
		this.id_pedido = id_pedido;
		this.total = total;
		this.fecha = fecha;
		this.llevar = llevar;
		this.tiempo_llegada = tiempo_llegada;
	}
	public Venta(int id_usuario, float total, Date fecha, boolean llevar, ArrayList<LineaVenta> productos) {
		this.total = total;
		this.fecha = fecha;
		this.llevar = llevar;
		this.productos = productos;
	}

	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isLlevar() {
		return llevar;
	}
	public void setLlevar(boolean llevar) {
		this.llevar = llevar;
	}
	public ArrayList<LineaVenta> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<LineaVenta> productos) {
		this.productos = productos;
	}
	public int getTiempo_llegada() {
		return tiempo_llegada;
	}
	public void setTiempo_llegada(int tiempo_llegada) {
		this.tiempo_llegada = tiempo_llegada;
	}
	public void calcularTiempo_llegada() {
		for(LineaVenta x: productos) {
			if(x.getProducto().getTiempo_elaboracion()+15>this.tiempo_llegada) {
				this.tiempo_llegada=x.getProducto().getTiempo_elaboracion()+15;
			}
		}
	}
	public void calcularTotal() {
		for(LineaVenta x: productos) {
			this.total += x.getProducto().getPrecio();
		}
		if(this.llevar) {
			this.total += 5;
		}
	}
	
	public static void registrarVenta(Conexion c, Venta venta) {
		Connection conec = c.conexionBBDD();
		if (conec != null) {
			try {
				//codigo de mysql para insertar datos en la tabla pedido
				String insert = "INSERT INTO pedido  (id_user, fecha, total, llevar, tiempo_llegada) "
						+ "VALUES("+ venta.getId_usuario()+", '"+ venta.getFecha() +"', "+ venta.getTotal() +", "+ venta.isLlevar()
						+", "+ venta.getTiempo_llegada()+");";
				
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
	public static ArrayList<Venta> extraerVenta(Conexion c) {
		Connection conec = c.conexionBBDD();
		ArrayList<Venta> ventas = new ArrayList();
		if (conec != null) {
			try {
				//codigo de mysql para consultar los datos de la tabla pedido
				String consulta = "SELECT * FROM pedido;";
				
				Statement cons = conec.createStatement();
				
				if(cons.execute(consulta)) {
					ResultSet res = cons.getResultSet();
					while(res.next()) {
						Venta venta = new Venta(res.getInt(1), res.getInt(2), res.getDate(3), res.getFloat(4),
								res.getBoolean(5), res.getInt(6));
						ventas.add(venta);
					}
				}
				return ventas;
			} catch(SQLException e) {
				System.err.println(e);
				return null;
			} finally {
				c.cerrarConexion(conec);
			}
		}
		return null;
	}
	public static void borrarVenta(Conexion c, Venta venta) {
		Connection conec = c.conexionBBDD();
		if (conec != null) {
			try {
				//codigo de mysql para borrar datos en la tabla pedido
				String delete = "DELETE FROM pedido WHERE id_pedido = "+venta.getId_pedido()+";";
				
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
}
