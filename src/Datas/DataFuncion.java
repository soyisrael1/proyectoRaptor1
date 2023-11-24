package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Sala;
import Entidades.funcion;

public class DataFuncion {


	Connection cx;

	public DataFuncion() {
	}

	public Connection conectar() {
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "");
			System.out.println("CONEXION EXITOSA");
		} catch (SQLException e) {
			System.out.println("FALLO CONEXION");
			e.printStackTrace();
		}
		return cx;
	}

	public boolean insertarFuncion(funcion a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("INSERT INTO funcion VALUES(null,?,?,?,?)");
			ps.setInt(1, a.getIdsala());
			ps.setInt(2, a.getIdPeli());
			ps.setString(3, a.getFecha());
			ps.setString(4, a.getHora());
		
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	public ArrayList<funcion> SelectFuncion() {
		ArrayList<funcion> ListaFuncion = new ArrayList<funcion>();
		try {
			PreparedStatement ps = conectar().prepareStatement("SELECT * FROM funcion");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				funcion x = new funcion();
				x.setIdfun(rs.getInt(1));
				x.setIdsala(rs.getInt(2));
				x.setIdPeli(rs.getInt(3));
				x.setFecha(rs.getString(4));
				x.setHora(rs.getString(5));
				
				ListaFuncion.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return ListaFuncion;
	}
	public boolean EliminarFuncion(int Idfun) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("DELETE FROM funcion WHERE idfun=?");
			ps.setInt(1, Idfun);
			System.out.println(ps.toString());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean actualizarFuncion(funcion a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement(
					"UPDATE funcion SET idsala=?,idPeli=?,fecha=?,hora=? WHERE idfun=?");
			ps.setInt(1, a.getIdsala());
			ps.setInt(2, a.getIdPeli());
			ps.setString(3, a.getFecha());
			ps.setString(4, a.getHora());
			ps.setInt(5, a.getIdfun());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	



}

	
}