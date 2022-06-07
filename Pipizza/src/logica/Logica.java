package logica;

import java.util.Scanner;

public class Logica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Introduce un nombre:");
		String texto = leer.nextLine();
		
		System.out.println(Registrado.comprobarContra(texto));
	
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
