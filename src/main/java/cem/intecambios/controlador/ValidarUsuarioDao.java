package cem.intecambios.controlador;

import cem.intecambios.entidades.Usuario;
import cem.intercambios.controlador.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidarUsuarioDao {
    
    private Connection c;
    private PreparedStatement ps;
    private ResultSet rs;

    public ValidarUsuarioDao() {
        this.c = null;
        this.ps = null;
        this.rs = null;
    }
    
    public Usuario validarUsuario(String nU, String c) {
        Usuario objUsuario = null;
        String sql = "SELECT NOMBRE, PERFIL FROM CEM.USUARIO "
                + "WHERE NOMBRE = ? AND CONTRASENA = ?";
        try {
            Conexion conexion = new Conexion();
            this.c = conexion.abrir();
            ps = this.c.prepareStatement(sql);
            ps.setString(1, nU);
            ps.setString(2, c);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                objUsuario = new Usuario(
                        rs.getString(1),
                        rs.getString(2)
                );
            }
            rs.close();
            ps.close();
            this.c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(ValidarUsuarioDao.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return objUsuario;
    }
}
