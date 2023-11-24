package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DataUsuario {
Connection cx;

public DataUsuario() {	
}
public Connection conectar() {
	try {
		cx=DriverManager.getConnection("jdbc:mysql://localhost:3306/cine","root","");
		System.out.println("Conexion exitosa");
	}catch(SQLException e) {
		System.out.println("Fallo conexion");
		e.printStackTrace();
	}
	return cx;
}
public boolean insertarUsuario(Usuario u) {
	PreparedStatement ps;
	try {
		ps=conectar().prepareStatement("INSERT INTO usuarios VALUES(null,?,?,?)");
		ps.setString(1,u.getCorreo());
		
		ps.setString(2,u.getPassword());
		ps.setString(3,u.getNombre());
		ps.execute();
		return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
}

public ArrayList<Usuario>selectUsuarios(){
	ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
	 try {
         PreparedStatement ps = conectar().prepareStatement("SELECT * FROM usuarios");
         ResultSet rs = ps.executeQuery();
         while (rs.next()) {
             Usuario x = new Usuario();
             x.setIdUser(rs.getInt(1));
             x.setCorreo(rs.getString(2));
             
             x.setPassword(rs.getString(3));
             x.setNombre(rs.getString(4));
             listaUsuario.add(x);
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return listaUsuario;
	
}

public boolean login(Usuario x){
	 try {
         PreparedStatement ps = conectar().prepareStatement("SELECT * FROM usuarios WHERE correo=? AND password=?");
 		ps.setString(1,x.getCorreo());
 		ps.setString(2,x.getPassword());
 		
         ResultSet rs = ps.executeQuery();
         if (rs.next()) {
             x.setIdUser(rs.getInt(1));
             x.setCorreo(rs.getString(2));
             
             x.setPassword(rs.getString(3));
             x.setNombre(rs.getString(4));
             return true;
         }else {
        	 return false;
         }
     } catch (SQLException e) {
    	 return false;
     }
	
}


public boolean eliminarUsuario(int id) {
	PreparedStatement ps;
	try {
		ps=conectar().prepareStatement("DELETE FROM usuarios WHERE iduser=?");
		ps.setInt(1,id);
		ps.execute();
		return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}

}

public boolean actualizarUsuario(Usuario u) {
	PreparedStatement ps;
	try {
		ps=conectar().prepareStatement("UPDATE usuarios SET correo=?,password=?,nombre=?WHERE iduser=?");
		ps.setString(1,u.getCorreo());
		
		ps.setString(2,u.getPassword());
		ps.setString(3,u.getNombre());
		ps.setInt(4,u.getIdUser());
		ps.execute();
		return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
	
	
}

}
