/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author nikolas
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
    private Usuario user = new Usuario();

    public UsuarioBean() {
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
    
    public String login() {
        Usuario newUser = user.login();
        if (newUser != null) {
            System.out.println("Encontrou usuário: " + newUser.getIdentificador());
            user = newUser;
            return "imoveis";
        }
        System.out.println("Usuário: "+ user.getIdentificador() + "não encontrado");
        return null;
        
    }
}
