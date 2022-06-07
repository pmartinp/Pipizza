package logica;

import java.sql.Date;

public class Oferta {

	private String codigo;
	private int usos_restantes;
	private Date fecha_salidad;
	private int coste;
	private boolean activo;
	private int descuento;
	
	public Oferta(String codigo, int usos_restantes, Date fecha_salidad, int coste, boolean activo) {
		super();
		this.codigo = codigo;
		this.usos_restantes = usos_restantes;
		this.fecha_salidad = fecha_salidad;
		this.coste = coste;
		this.activo = activo;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getUsos_restantes() {
		return usos_restantes;
	}
	public void setUsos_restantes(int usos_restantes) {
		this.usos_restantes = usos_restantes;
	}
	public Date getFecha_salidad() {
		return fecha_salidad;
	}
	public void setFecha_salidad(Date fecha_salidad) {
		this.fecha_salidad = fecha_salidad;
	}
	public int getCoste() {
		return coste;
	}
	public void setCoste(int coste) {
		this.coste = coste;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
}
