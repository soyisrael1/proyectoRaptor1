package Entidades;

import Datas.DataFuncion;
import Datas.DataSala;

public class funcion {
	int idfun;
	int idsala;
	int idPeli;
	String fecha;
	String hora;
	
	DataFuncion da=new DataFuncion();
	private int Idfun;
	
	public funcion() {
	}
	
	public boolean insertarFuncion() {
		if(da.insertarFuncion(this)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean EliminarFuncion() {
		if(da.EliminarFuncion(this.getIdfun())) {
			return true;
		}else {
			return false;
		}
	}
	public boolean actualizarFuncion() {
		if(da.actualizarFuncion(this)) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getIdfun() {
		return idfun;
	}

	public void setIdfun(int idfun) {
		this.idfun = idfun;
	}

	public int getIdsala() {
		return idsala;
	}

	public void setIdsala(int idsala) {
		this.idsala = idsala;
	}

	public int getIdPeli() {
		return idPeli;
	}

	public void setIdPeli(int idPeli) {
		this.idPeli = idPeli;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	

}
