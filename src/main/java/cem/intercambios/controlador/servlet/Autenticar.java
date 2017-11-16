package cem.intercambios.controlador.servlet;

import cem.intecambios.controlador.ValidarUsuarioDao;
import cem.intecambios.entidades.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Autenticar extends HttpServlet {

    private ValidarUsuarioDao vud;
    
    @Override
    public void init() {
        vud = new ValidarUsuarioDao();
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario objUsuario = vud.validarUsuario(
                request.getParameter("nombreUsuario"),
                request.getParameter("contrasena")
        );
        
        if (objUsuario != null) {
            response.sendRedirect("../index.xhtml");
        }
        else {
            response.sendRedirect("login.jsp");
        }
    }
}
