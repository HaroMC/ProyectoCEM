package cem.intercambios.controlador.conexion; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private Connection conexion = null;
    
    public Conexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "cem",
                    "portafolioCaso1"
            );
        }
        catch (ClassNotFoundException | SQLException |
                InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection abrir() {
        return conexion;
    }
    
    public void cerrar() throws SQLException {
        conexion.close();
    }
}
