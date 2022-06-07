package logica;

import java.sql.Date;

public class Ingrediente {

	private int id;
	private String nombre;
	private float precio;
	private Date fecha_cad;
	
	public Ingrediente(int id, String nombre, float precio, Date fecha_cad) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha_cad = fecha_cad;
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
	public Date getFecha_cad() {
		return fecha_cad;
	}
	public void setFecha_cad(Date fecha_cad) {
		this.fecha_cad = fecha_cad;
	}
}
