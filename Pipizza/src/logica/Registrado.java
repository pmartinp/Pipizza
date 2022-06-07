package logica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

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
		String regx = "[a-zA-Z0-9]{8,20}*";
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
	
	//si puedes iniciar sesion
	 public boolean HacerLogin(String email, String contrasena, Conexion c){
	       try{
	            statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            String sql=("SELECT email,contraseÃ±a FROM usuario WHERE  email="+email+" and contraseÃ±a=" +contrasena);
	            System.out.println(sql);
	            ResultSet rs = statement.executeQuery(sql);
	            
	            if (rs.next()){
	                 return true;
	             }else{
	                return false;
	            }
	            
	        }catch (SQLException e){
	            System.err.println("Error en la base de datos: "+e);
	            return false;
	        }finally {
				c.cerrarConexion(conec);
			}
	    }
	
	//Una vez que hace el login guardar datos del usuario
    public Usuario cargarusuario(String email){
         try{
            statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql=("SELECT * FROM Usuario WHERE  email="+email);
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            
            Usuario usuario= new Usuario();
            
            if (rs.next()){
                usuario.setNombre(rs.getString("nombre"));
                usuario.setDNI(rs.getString("dni"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setPuntos(rs.getInt("Puntos"));
             }
            return usuario;
        }catch (SQLException e){
            System.err.println("Error en la base de datos: "+e);
            return null;
		 
        }finally {
			c.cerrarConexion(conec);
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
	//Compruebo si el usuario ha sido registrado.
	    public boolean ComprobarRegistrado(Conexion c, String email){
	       try{
	            statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            String sql=("SELECT email FROM Usuario WHERE email LIKE "+email);
	            ResultSet rs = statement.executeQuery(sql);
	          
	            if (rs.next()){
	                 return true;
	             }else{
	                return false;
	            }
	            
	        }catch (SQLException e){
	            System.err.println("Error en la base de datos: "+e);
	            return false;
	        } finally {
				c.cerrarConexion(conec);
			}
	    }
	
	
}
