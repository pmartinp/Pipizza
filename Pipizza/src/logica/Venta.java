package logica;

import java.sql.Date;
import java.util.ArrayList;

public class Venta {

	private String codigo_venta;
	private float total;
	private Date fecha;
	private boolean llevar;
	private int tiempo_llegada=0;
	private ArrayList<LineaVenta> productos;
	
	public Venta(String codigo_venta, float total, Date fecha, boolean llevar, ArrayList<LineaVenta> productos) {
		this.codigo_venta = codigo_venta;
		this.total = total;
		this.fecha = fecha;
		this.llevar = llevar;
		this.productos = productos;
	}
	public Venta(String codigo_venta, float total, Date fecha, boolean llevar, int tiempo_llegada, ArrayList<LineaVenta> productos) {
		this.codigo_venta = codigo_venta;
		this.total = total;
		this.fecha = fecha;
		this.llevar = llevar;
		this.tiempo_llegada = tiempo_llegada;
		this.productos = productos;
	}

	public String getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(String codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isLlevar() {
		return llevar;
	}
	public void setLlevar(boolean llevar) {
		this.llevar = llevar;
	}
	public ArrayList<LineaVenta> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<LineaVenta> productos) {
		this.productos = productos;
	}
	public int getTiempo_llegada() {
		return tiempo_llegada;
	}
	public void setTiempo_llegada(int tiempo_llegada) {
		this.tiempo_llegada = tiempo_llegada;
	}
	public void calcularTiempo_llegada() {
		for(LineaVenta x: productos) {
			if(x.getProducto().getTiempo_elaboracion()+15>this.tiempo_llegada) {
				this.tiempo_llegada=x.getProducto().getTiempo_elaboracion()+15;
			}
		}
	}
	public void calcularTotal() {
		for(LineaVenta x: productos) {
			this.total += x.getProducto().getPrecio();
		}
		if(this.llevar) {
			this.total += 5;
		}
	}
}
