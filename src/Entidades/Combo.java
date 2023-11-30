package Entidades;

import Datas.DataCombo;
import Datas.DataFuncion;

public class Combo {
	int idcombo;
	String tamaño;
	String nombre;
	int cantPalomitas;
	int costo;
	int cantRefresco;
	DataCombo da=new DataCombo();
	
	

	public Combo() {
		
	}
	
	public boolean insertarCombo() {
		if(da.insertarCombo(this)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean EliminarCombo() {
		if(da.EliminarCombo(this.getIdcombo())) {
			return true;
		}else {
			return false;
		}
	}
	public boolean actualizarCombo() {
		if(da.actualizarCombo(this)) {
			return true;
		}else {
			return false;
		}
	}
	
	

	public int getIdcombo() {
		return idcombo;
	}

	public void setIdcombo(int idcombo) {
		this.idcombo = idcombo;
	}

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantPalomitas() {
		return cantPalomitas;
	}

	public void setCantPalomitas(int cantPalomitas) {
		this.cantPalomitas = cantPalomitas;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getCantRefresco() {
		return cantRefresco;
	}

	public void setCantRefresco(int cantRefresco) {
		this.cantRefresco = cantRefresco;
	}
	public boolean validaProveedor() {
        if (!this.tamaño.equals("") && !this.nombre.equals("") ) {
            return true;
        } else {
            return false;
        }
    }

	
	

}
