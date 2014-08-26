/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba_conexion;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class conectar {
    Connection con = null;
    public Connection conexion() {
        try {
            // cargar nuestro driver
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:pruebaMySQL");
            System.out.println("Conexion establecida");
            JOptionPane.showMessageDialog(null, "Conexion Establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de Conexion \n"+e);
            JOptionPane.showMessageDialog(null, "Error de Conexion \n"+e);
        }
        return con;
    }
}
