package logica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Oferta {

	private String codigo;
	private int usos_restantes;
	private Date fecha_salidad;
	private float descuento;
	private boolean activo;
	private int coste;
	
	public Oferta(String codigo, int usos_restantes, Date fecha_salidad, float descuento, boolean activo, int coste) {
		super();
		this.codigo = codigo;
		this.usos_restantes = usos_restantes;
		this.fecha_salidad = fecha_salidad;
		this.descuento = descuento;
		this.coste = coste;
		this.activo = activo;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getUsos_restantes() {
		return usos_restantes;
	}
	public void setUsos_restantes(int usos_restantes) {
		this.usos_restantes = usos_restantes;
	}
	public Date getFecha_salidad() {
		return fecha_salidad;
	}
	public void setFecha_salidad(Date fecha_salidad) {
		this.fecha_salidad = fecha_salidad;
	}
	public int getCoste() {
		return coste;
	}
	public void setCoste(int coste) {
		this.coste = coste;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	public static void registrarOferta(Conexion c, Oferta oferta) {
		Connection conec = c.conexionBBDD();
		if (conec != null) {
			try {
				//codigo de mysql para insertar datos en la tabla ofertas
				String insert = "INSERT INTO ofertas  (codigo, usos_rest, fecha_salida, porcentaje_descuento, activo, coste_puntos) "
						+ "VALUES('"+ oferta.getCodigo()+"',"+ oferta.getUsos_restantes() +", '"+ oferta.getFecha_salidad() +"', "+ oferta.getDescuento()
						+", "+ oferta.isActivo() +", "+ oferta.getCoste() +");";
				
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
	public static ArrayList<Oferta> extraerOferta(Conexion c) {
		Connection conec = c.conexionBBDD();
		ArrayList<Oferta> ofertas = new ArrayList();
		if (conec != null) {
			try {
				//codigo de mysql para consultar los datos de la tabla ofertas
				String consulta = "SELECT * FROM ofertas;";
				
				Statement cons = conec.createStatement();
				
				if(cons.execute(consulta)) {
					ResultSet res = cons.getResultSet();
					while(res.next()) {
						Oferta oferta = new Oferta(res.getString(1), res.getInt(2), res.getDate(3), res.getFloat(4),
								res.getBoolean(5), res.getInt(6));
						ofertas.add(oferta);
					}
				}
				return ofertas;
			} catch(SQLException e) {
				System.err.println(e);
				return null;
			} finally {
				c.cerrarConexion(conec);
			}
		}
		return null;
	}
	public static void borrarProductos(Conexion c, Oferta oferta) {
		Connection conec = c.conexionBBDD();
		if (conec != null) {
			try {
				//codigo de mysql para borrar datos en la tabla ofertas
				String delete = "DELETE FROM ofertas WHERE codigo = "+oferta.getCodigo()+";";
				
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
	public static void actualizarProductos(Conexion c, Oferta oferta) {
		Connection conec = c.conexionBBDD();
		if (conec != null) {
			try {
				//codigo de mysql para actualizar datos en la tabla ofertas
				String update = "UPDATE ofertas SET codigo = '"+ oferta.getCodigo() +"', usos_rest = "+ oferta.getUsos_restantes() +", "
						+ "fecha_salida = '"+ oferta.getFecha_salidad() +"', porcentaje_descuento = "+ oferta.getDescuento() +", activo = "+ oferta.isActivo()
						+ ", coste_puntos = "+ oferta.getCoste() +" WHERE codigo = "+oferta.getCodigo()+";";
				
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
