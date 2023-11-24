package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Ticket;

public class DataTicket {

	Connection cx;

	
	public DataTicket() {
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

	public boolean insertarTicket(Ticket p) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("INSERT INTO detalleventa VALUES(null,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, p.getCantboletosn());
			ps.setInt(2, p.getCantboletosv());
			ps.setInt(3, p.getCostoboletosn());
			ps.setInt(4, p.getCostoboletosv());
			ps.setInt(5, p.getIdcombo());
			ps.setInt(6, p.getIduser());
			ps.setInt (7, p.getCosto());
			ps.setInt(8, p.getIdfun());
			ps.setInt(9, p.getCostot());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Ticket> SelectTicket() {
		ArrayList<Ticket> ListaTickets = new ArrayList<Ticket>();
		try {
			PreparedStatement ps = conectar().prepareStatement("SELECT * FROM detalleventa");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ticket x = new Ticket();
				x.setIdDV(rs.getInt(1));
				x.setCantboletosn(rs.getInt(2));
				x.setCantboletosv(rs.getInt(3));
				x.setCostoboletosn(rs.getInt(4));
				x.setCostoboletosv(rs.getInt(5));
				x.setIdcombo(rs.getInt(6));
				x.setIduser(rs.getInt(7));
				x.setCosto(rs.getInt(8));
				x.setIdfun(rs.getInt(9));
				x.setCostot(rs.getInt(10));
				
				ListaTickets.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return ListaTickets;
	}
	public boolean EliminarTicket(int idDV) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("DELETE FROM detalleventa WHERE IdDV=?");
			ps.setInt(1, idDV);
			System.out.println(ps.toString());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	public boolean actualizarTicket(Ticket a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("UPDATE detallevetna SET idSala=?,idPeli=?,fecha=?,costo=?,tipo=?,cantidad=? WHERE idTi=?");
			ps.setInt(1, a.getCantboletosn());
			ps.setInt(2, a.getCantboletosv());
			ps.setInt(3, a.getCostoboletosn());
			ps.setInt(4, a.getCostoboletosv());
			ps.setInt(5, a.getIdcombo());
			ps.setInt(6, a.getIduser());
			ps.setInt (7, a.getCosto());
			ps.setInt(8, a.getIdfun());
			ps.setInt(9, a.getCostot());
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}