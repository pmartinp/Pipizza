package logica;

import java.sql.Date;

public class Registrado extends Usuario{

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
	public Registrado() {}
	
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
			this.contrasena = CifradoPassword.sha1(contrasena);
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
}
	
