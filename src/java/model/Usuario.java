/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UsuarioDAO;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Aluno
 */
public class Usuario implements Serializable{

    private int idUsuario;
    private String identificador;
    private String senha;

    public Usuario() {
    }

    public Usuario(int idUsuario, String identificador, String senha) {
        this.idUsuario = idUsuario;
        this.identificador = identificador;
        this.senha = senha;
    }

    public Usuario(String identificador) {
         this(-1, identificador, null);
    }

    public Usuario( String identificador, String senha) {
        this(-1, identificador, senha);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", identificador=" + identificador + ", senha=" + senha + '}';
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idUsuario;
        hash = 37 * hash + Objects.hashCode(this.identificador);
        hash = 37 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (!Objects.equals(this.identificador, other.identificador)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }
    
    public Usuario login() {
        return UsuarioDAO.findByIdAndPassword(identificador, senha);
    }

}
