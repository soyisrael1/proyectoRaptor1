package Entidades;

import Datas.DataPelicula;
import Datas.DataSala;

public class Pelicula {
	int idPeli;
	String nombre;
	String categoria;
	String RangoEdad;
	String rutaImagen;
	
	
	DataPelicula da=new DataPelicula();
	private int IdSala;

	
	public Pelicula() {
		
	}
	public boolean insertarPelicula() {
		if(da.insertarPelicula(this)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean EliminarPelicula() {
		if(da.EliminarPelicula(this.getIdPeli())) {
			return true;
		}else {
			return false;
		}
	}
	public boolean actualizarPelicula() {
		if(da.actualizarPelicula(this)) {
			return true;
		}else {
			return false;
		}
	}

	public int getIdPeli() {
		return idPeli;
	}

	public void setIdPeli(int idPeli) {
		this.idPeli = idPeli;
	}
	
	public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getRangoEdad() {
		return RangoEdad;
	}

	public void setRangoEdad(String rangoEdad) {
		RangoEdad = rangoEdad;
	}
	

	


	
	

}
