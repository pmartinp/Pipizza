package logica;

public class Registrado {

	private String email;
	private String nombre;
	private String apellidos;
	private String contrasena;
	private Direccion direccion;
	private int puntos=0;
	
	public Registrado(String email, String nombre, String apellidos, String contrasena, Direccion direccion) {
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
	public static boolean comprobarContra(String contrasena) {
		String regx = ".{8,20}";
		if(contrasena.matches(regx)) {
			return true;
		}
		else {
			return false;
		}
	}
}
