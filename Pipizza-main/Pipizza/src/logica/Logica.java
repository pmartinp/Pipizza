package logica;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Logica {
	
	static Conexion c = new Conexion();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
	
		System.out.println("Contra:");
		String contra = leer.nextLine();
	
		System.out.println(CifradoPassword.sha1(contra));
		
		
	}
	public static boolean soloLetras(String texto) {
		String regx = "[a-zA-Z]{1,25}+[\\s]{0,1}[a-zA-Z]{0,25}";
		if(texto.matches(regx)) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean soloNumeros(String numero) {
		String regx = "[0-9]+";
		if(numero.matches(regx)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
