package logica;

import java.util.ArrayList;

public class Producto {

	private int id;
	private String nombre;
	private float precio;
	private boolean alcohol;
	private int stock;
	private int tiempo_elaboracion;
	private ArrayList<Ingrediente> ingredientes;
	
	public Producto(int iD, String nombre, float precio, boolean alcohol, int stock,
			ArrayList<Ingrediente> ingredientes) {
		id = iD;
		this.nombre = nombre;
		this.precio = precio;
		this.alcohol = alcohol;
		this.stock = stock;
		this.ingredientes = ingredientes;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public boolean isAlcohol() {
		return alcohol;
	}
	public void setAlcohol(boolean alcohol) {
		this.alcohol = alcohol;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getTiempo_elaboracion() {
		return tiempo_elaboracion;
	}
	public void setTiempo_elaboracion(int tiempo_elaboracion) {
		this.tiempo_elaboracion = tiempo_elaboracion;
	}
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
}
