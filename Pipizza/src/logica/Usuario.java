package logica;

import java.sql.Date;

public class Usuario {

	private int id;
	private Date fecha_nac;
	private Venta ticket;
	
	public Usuario(int id, Date fecha_nac, Venta ticket) {
		this.id = id;
		this.fecha_nac = fecha_nac;
		this.ticket = ticket;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public Venta getTicket() {
		return ticket;
	}
	public void setTicket(Venta ticket) {
		this.ticket = ticket;
	}
}
