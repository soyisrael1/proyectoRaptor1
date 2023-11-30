package Datas;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Combo;
import Entidades.Pelicula;
import Entidades.Sala;

public class DataCombo {

    Connection cx;

   

    public DataCombo() {
    	
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
    
    public ArrayList<Combo> buscar(String palabra) {
        ArrayList<Combo> lista2 = new ArrayList<Combo>();
        try {
            String sql = "SELECT * FROM combos WHERE "
                    + "(tamaño LIKE ?) OR "
                    + "(nombre LIKE ?) OR"
                    + "(cantPalomitas LIKE ?) OR "
                    + "(costo LIKE ?) OR "
                    + "(cantRefresco LIKE ?); ";
            PreparedStatement ps =  conectar().prepareStatement(sql);
            ps.setString(1, "%" + palabra + "%");
            ps.setString(2, "%" + palabra + "%");
            ps.setString(3, "%" + palabra + "%");
            ps.setString(4, "%" + palabra + "%");
            ps.setString(5, "%" + palabra + "%");
            //System.out.println("CONSULTA" + ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Combo p = new Combo();
                p.setIdcombo(rs.getInt("idcombo"));
                p.setTamaño(rs.getString("tamaño"));
                p.setNombre(rs.getString("nombre"));
                p.setCantPalomitas(rs.getInt("cantPalomitas"));
                p.setCosto(rs.getInt("costo"));
                p.setCantRefresco(rs.getInt("cantRefresco"));
                lista2.add(p);
            }
            ps.close();
            ps = null;
            
        } catch (SQLException ex) {
            System.out.println("Error en BUSCAR");
        }
        return lista2;

    }

    
    public boolean insertarCombo(Combo a) {
        PreparedStatement ps;
        try {
        	
            ps = conectar().prepareStatement("INSERT INTO combos VALUES(null,?,?,?,?,?)");
            ps.setString(1, a.getTamaño());
            ps.setString(2, a.getNombre());
            ps.setInt(3, a.getCantPalomitas());
            ps.setInt(4, a.getCosto());
            ps.setInt(5, a.getCantRefresco());
            
        


            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ... (código existente)

    public boolean actualizarCombo(Combo a) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("UPDATE combos SET tamaño=?,nombre=?,cantPalomitas=?,costo=?,cantRefresco=? WHERE idcombo=?");
			ps.setString(1, a.getTamaño());
			ps.setString(2, a.getNombre());
			ps.setInt(3, a.getCantPalomitas());
			ps.setInt(4, a.getCosto());
			ps.setInt(5, a.getCantRefresco());
			ps.setInt(6, a.getIdcombo());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }



    

    public ArrayList<Combo> SelectCombo() {
        ArrayList<Combo> ListaPelicula = new ArrayList<Combo>();
        try {
            PreparedStatement ps = conectar().prepareStatement("SELECT * FROM combos");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Combo x = new Combo();
                x.setIdcombo(rs.getInt(1));
                x.setTamaño(rs.getString(2));
                x.setNombre(rs.getString(3));
                x.setCantPalomitas(rs.getInt(4));
                x.setCosto(rs.getInt(5));
                x.setCantRefresco(rs.getInt(6));
                
              

                ListaPelicula.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListaPelicula;
    }

    public boolean EliminarCombo(int IdCombo) {
        PreparedStatement ps;
        try {
            ps = conectar().prepareStatement("DELETE FROM Combos WHERE idcombo=?");
            ps.setInt(1, IdCombo);
            System.out.println(ps.toString());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    

}

