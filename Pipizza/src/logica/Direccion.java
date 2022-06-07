package logica;

public class Direccion {

	private String via;
	private String nombre;
	private int numero;
	private int piso;
	private int letra;
	private String indicaciones;
	private int cod_postal;
	private String municipio;
	
	public Direccion(String via, String nombre, int numero, int piso, int letra, String indicaciones, int cod_postal,
			String municipio) {
		this.via = via;
		this.nombre = nombre;
		this.numero = numero;
		this.piso = piso;
		this.letra = letra;
		this.indicaciones = indicaciones;
		this.cod_postal = cod_postal;
		this.municipio = municipio;
	}
	
	public Direccion(String via, String nombre, int numero, String indicaciones, int cod_postal,
			String municipio) {
		this.via = via;
		this.nombre = nombre;
		this.numero = numero;
		this.indicaciones = indicaciones;
		this.cod_postal = cod_postal;
		this.municipio = municipio;
	}

	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public int getLetra() {
		return letra;
	}
	public void setLetra(int letra) {
		this.letra = letra;
	}
	public String getIndicaciones() {
		return indicaciones;
	}
	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}
	public int getCod_postal() {
		return cod_postal;
	}
	public void setCod_postal(int cod_postal) {
		this.cod_postal = cod_postal;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
}
