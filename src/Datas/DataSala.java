package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Sala;

public class DataSala {


	Connection cx;

	

	public DataSala() {
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

	public boolean insertarSala(Sala a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("INSERT INTO sala VALUES(null,?,?,?,?)");
			ps.setString(1, a.getNumAsientos());
			ps.setString(2, a.getPantalla());
			ps.setString(3, a.getSonido());
			ps.setString(4, a.getNombre());
		
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	public ArrayList<Sala> SelectSala() {
		ArrayList<Sala> ListaSala = new ArrayList<Sala>();
		try {
			PreparedStatement ps = conectar().prepareStatement("SELECT * FROM Sala");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Sala x = new Sala();
				x.setIdSala(rs.getInt(1));
				x.setNumAsientos(rs.getString(2));
				x.setPantalla(rs.getString(3));
				x.setSonido(rs.getString(4));
				x.setNombre(rs.getString(5));
				
				ListaSala.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return ListaSala;
	}
	public boolean EliminarSala(int IDSala) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("DELETE FROM Sala WHERE idSala=?");
			ps.setInt(1, IDSala);
			System.out.println(ps.toString());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean actualizarSala(Sala a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement(
					"UPDATE sala SET NumAsientos=?,Pantalla=?,Sonido=?,Nombre=? WHERE idSala=?");
			ps.setString(1, a.getNumAsientos());
			ps.setString(2, a.getPantalla());
			ps.setString(3, a.getSonido());
			ps.setString(4, a.getNombre());
			ps.setInt(5, a.getIdSala());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	



}

	
}
