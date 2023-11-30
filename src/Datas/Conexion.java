package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection cx1;
    String bd = "cine";
    String url = "jdbc:mysql://localhost/" + bd;
    String user = "root";
    String password = "";

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cx1 = (Connection) DriverManager.getConnection(url, user, password);
           // System.out.println("Se conecto a la BD");
        } catch (ClassNotFoundException | SQLException ex) {
            cx1=null;
        }
        return cx1;
    }

    public void desconectar() {
        try {
            cx1.close();
        } catch (SQLException ex) {
        }

    }

  
}