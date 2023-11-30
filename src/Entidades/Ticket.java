package Entidades;

import Datas.DataTicket;

public class Ticket {

	int IdDV;
	int cantboletosn;
	int cantboletosv;
	int costoboletosn;
	int costoboletosv;
	int idcombo;
	int iduser;
	int costo;
	int idfun;
	int costot;
	
	
	
	DataTicket dh=new DataTicket();
	public Ticket() {}

	public boolean insertarTicket() {
		if(dh.insertarTicket(this)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean EliminarTicket() {
		if(dh.EliminarTicket(this.getIdDV())) {
			return true;
		}else {
			return false;
		}
	}
	public boolean actualizarTicket() {
		if(dh.actualizarTicket(this)) {
			return true;
		}else {
			return false;
		}
	}

	public int getIdDV() {
		return IdDV;
	}

	public void setIdDV(int idDV) {
		IdDV = idDV;
	}

	public int getCantboletosn() {
		return cantboletosn;
	}

	public void setCantboletosn(int cantboletosn) {
		this.cantboletosn = cantboletosn;
	}

	public int getCantboletosv() {
		return cantboletosv;
	}

	public void setCantboletosv(int cantboletosv) {
		this.cantboletosv = cantboletosv;
	}

	public int getCostoboletosn() {
		return costoboletosn;
	}

	public void setCostoboletosn(int costoboletosn) {
		this.costoboletosn = costoboletosn;
	}

	public int getCostoboletosv() {
		return costoboletosv;
	}

	public void setCostoboletosv(int costoboletosv) {
		this.costoboletosv = costoboletosv;
	}

	public int getIdcombo() {
		return idcombo;
	}

	public void setIdcombo(int idcombo) {
		this.idcombo = idcombo;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getIdfun() {
		return idfun;
	}

	public void setIdfun(int idfun) {
		this.idfun = idfun;
	}

	public int getCostot() {
		return costot;
	}

	public void setCostot(int costot) {
		this.costot = costot;
	}

	public DataTicket getDh() {
		return dh;
	}

	public void setDh(DataTicket dh) {
		this.dh = dh;
	}
		
	
	


	



}
