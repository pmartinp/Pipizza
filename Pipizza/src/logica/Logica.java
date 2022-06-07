package logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Logica {
	
	static Conexion c = new Conexion();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
	
		ArrayList<Producto> productos = new ArrayList();
		float precio = (float)20.50;
		Producto producto = new Producto("Queso", precio, false, 10, 23, "Pizzas");
		
		producto.setId(1);
		
		productos.add(producto);
		
		for(Producto x: productos) {
			if(x.getCategoria().equals("Pizzas")) {
				System.out.println(x.getNombre());
			}
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
