package logica;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	    public Connection con;
	    private  final String driver="com.mysql.jdbc.Driver";
	    private  final String user="root";
	    private  final String pass="";
	    private  final String url="jdbc:mysql://localhost:3306/centrosalud";
	    private java.sql.Statement statement;
	    //public Usuario usuario= new Usuario();
	    
	    public Conexion(){
	        connect();
	    }

	    public Connection connect() {
	        // Reseteamos a null la conexion a la bd
	        con = null;
	        try{
	            Class.forName(driver);
	            // Nos conectamos a la bd
	            con= (Connection) DriverManager.getConnection(url, user, pass);
	            System.err.println("conectado!!!!!!!!!!!!");
	        }
	        // Si la conexion NO fue exitosa mostramos un mensaje de error
	        catch (ClassNotFoundException | SQLException e){
	            System.err.println("Error en la base de datos: "+e);
	        }return con;
	    }
	
	public void cerrarConexion(Connection conection) {
		try {
			//Cierre de conexiï¿½n
			conection.close();
		} catch (SQLException e) {
			//Controlamos las excepciones que se puedan producir al cierre de la conexiï¿½n
			System.err.println("Se ha producido un error al conectar con la Base de Datos." + e);
		}
	}
	
	//Insertamos un usuario en la base de datos 
    public boolean RegistrarUsuario(String cadena){
        try{
            statement = con.createStatement();
            cadena = "INSERT INTO usuario (nombre,apellido1,apellido2,dni,contraseña,saldo) VALUES ("+cadena+")";
            statement.executeUpdate(cadena);
            return true;
        }
        catch (SQLException e){
            System.err.println("Error en la base de datos: "+e);
            return false;
        }
    }
    
  //Para iniciar sesion    
    public boolean HacerLogin(String dni, String contrasena){
      try{
           statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           String sql=("SELECT dni,contraseña FROM usuario WHERE  dni="+dni+" and contraseña=" +contrasena);
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
       }
   }
    
  //Una vez que hace el login guardar datos del usuario
    public Usuario cargarusuario(String dni){
         try{
            statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql=("SELECT * FROM usuario WHERE  dni="+dni);
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            
            Usuario usuario= new Usuario();
            
            if (rs.next()){
                usuario.setNombre(rs.getString("nombre"));
                usuario.setDNI(rs.getString("dni"));
                usuario.setApellido1(rs.getString("apellido1"));
                usuario.setApellido2(rs.getString("apellido2"));
                usuario.setDinero(rs.getInt("saldo"));
             }
            return usuario;
        }catch (SQLException e){
            System.err.println("Error en la base de datos: "+e);
            return null;
        }
    }

//Compruebo si el usuario ha sido registrado.
    public boolean ComprobarRegistrado(String prueba){
       try{
            statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql=("SELECT dni FROM usuario WHERE dni LIKE "+prueba);
            ResultSet rs = statement.executeQuery(sql);
          
            if (rs.next()){
                 return true;
             }else{
                return false;
            }
            
        }catch (SQLException e){
            System.err.println("Error en la base de datos: "+e);
            return false;
        }
    }
	
}
