/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import dao.UsuarioDAO;
import dto.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author PC10
 */
@Named(value = "inicioMBeans")
@SessionScoped
public class InicioMBeans implements Serializable {
    private Usuario usuario=new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    /**
     * Creates a new instance of InicioMBeans
     */
    public String validar()
    {
        try{
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuario= usuarioDAO.datosUsuario(usuario); 
            if(usuario!=null)
                return "ok";
            else
                return "error";
        }catch (SQLException ex){
            return "error";
        }     
    }
    
    public InicioMBeans() {
    }
    
}
