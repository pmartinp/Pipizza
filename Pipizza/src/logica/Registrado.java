package logica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Registrado extends Usuario{
	static Conexion c = new Conexion();
	
	public Connection conec;
	private Statement statement;
	private String email;
	private String nombre;
	private String apellidos;
	private String contrasena;
	private Direccion direccion;
	private int puntos=0;
	
	
	public Registrado(int id, Date fecha_nac, String email, String nombre, String apellidos,
			String contrasena, Direccion direccion) {
		super(id, fecha_nac);
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.direccion = direccion;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		if(comprobarContra(contrasena)) {
			this.contrasena = contrasena;
		}else {
			System.err.println("No se ha podido cambiar la contraseña");
		}
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	//falta terminarlo
	public static boolean comprobarContra(String contrasena) {
		String regx =  "^(?=.*[0-9])(?=.*[az])(?=.*[AZ])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
		if(contrasena.matches(regx)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean comprobarEmail(String email) {
		String regx = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if(email.matches(regx)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//registrar usuario
	public static void registrarUsuario(Conexion c, Registrado usuario) {
		Connection conec = c.conexionBBDD();
		if (conec != null) {
			try {
				//codigo de mysql para insertar datos en la tabla usuario
				String insert = "INSERT INTO Usuario (fecha_nacimiento, email, nombre, apellidos, contrasena,) "
						+ "VALUES('"+ usuario.getFecha_nac() +"', '"+ usuario.getEmail() +"', '"+ usuario.getNombre()
						+"', '"+ usuario.getApellidos() +"', '"+usuario.getContrasena()+"');";
				
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
