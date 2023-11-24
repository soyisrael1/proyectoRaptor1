package Entidades;

import Datas.DataSala;

public class Sala {
	int idSala;
	String NumAsientos;
	String Pantalla;
	String Sonido;
	String Nombre;
	DataSala da=new DataSala();
	private int IdSala;
	
	public Sala() {
	}
	public boolean insertarSala() {
		if(da.insertarSala(this)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean EliminarSala() {
		if(da.EliminarSala(this.getIdSala())) {
			return true;
		}else {
			return false;
		}
	}
	public boolean actualizarSala() {
		if(da.actualizarSala(this)) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	public String getNumAsientos() {
		return NumAsientos;
	}
	public void setNumAsientos(String numAsientos) {
		NumAsientos = numAsientos;
	}
	public String getPantalla() {
		return Pantalla;
	}
	public void setPantalla(String pantalla) {
		Pantalla = pantalla;
	}
	public String getSonido() {
		return Sonido;
	}
	public void setSonido(String sonido) {
		Sonido = sonido;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	

}
