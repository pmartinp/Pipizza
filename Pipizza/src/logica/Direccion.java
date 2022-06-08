package logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Direccion {

	private String via;
	private String nombre;
	private int numero;
	private int piso;
	private String letra;
	private String indicaciones;
	private int cod_postal;
	private String municipio;
	private int id_user;
	
	public Direccion(String via, String nombre, int numero, int piso, String letra, String indicaciones, int cod_postal,
			String municipio) {
		this.via = via;
		this.nombre = nombre;
		this.numero = numero;
		this.piso = piso;
		this.letra = letra;
		this.indicaciones = indicaciones;
		this.cod_postal = cod_postal;
		this.municipio = municipio;
	}
	
	public Direccion(String via, String nombre, int numero, String indicaciones, int cod_postal,
			String municipio) {
		this.via = via;
		this.nombre = nombre;
		this.numero = numero;
		this.indicaciones = indicaciones;
		this.cod_postal = cod_postal;
		this.municipio = municipio;
	}

	public Direccion() {}
	
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String string) {
		this.letra = string;
	}
	public String getIndicaciones() {
		return indicaciones;
	}
	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}
	public int getCod_postal() {
		return cod_postal;
	}
	public void setCod_postal(int cod_postal) {
		this.cod_postal = cod_postal;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	public static void registrarDireccion(Conexion c, Direccion dir) {
		Connection conec = c.connect();
		if (conec != null) {
			try {
				//codigo de mysql para insertar datos en la tabla producto
				String insert = "INSERT INTO direccion (nombre, letra, cod_postal, via, numero, piso, indicaciones, municipio, id_user) "
						+ "VALUES('"+ dir.getNombre() +"', '"+ dir.getLetra() +"', "+ dir.getCod_postal()
						+", '"+ dir.getVia() +"', "+ dir.getNumero() +","+ dir.getPiso() +", '"+ dir.getIndicaciones() +"', '"
						+ dir.getMunicipio() +"', "+ dir.getId_user() +");";
				
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
	public static ArrayList<Direccion> extraerDireccion(Conexion c) {
		Connection conec = c.connect();
		ArrayList<Direccion> direcciones = new ArrayList();
		if (conec != null) {
			try {
				//codigo de mysql para consultar los datos de la tabla producto
				String consulta = "SELECT * FROM direccion;";
				
				Statement cons = conec.createStatement();
				
				if(cons.execute(consulta)) {
					ResultSet res = cons.getResultSet();
					while(res.next()) {
						Direccion dir = new Direccion();
						dir.setNombre(res.getString(1));
						dir.setLetra(res.getString(2));
						dir.setCod_postal(res.getInt(3));
						dir.setVia(res.getString(4));
						dir.setNumero(res.getInt(5));
						dir.setPiso(res.getInt(6));
						dir.setIndicaciones(res.getString(7));
						dir.setMunicipio(res.getString(8));
						dir.setId_user(res.getInt(9));
						direcciones.add(dir);
					}
				}
				return direcciones;
			} catch(SQLException e) {
				System.err.println(e);
				return null;
			} finally {
				c.cerrarConexion(conec);
			}
		}
		return null;
	}
}
