/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.Usuario;
import org.apache.catalina.User;

/**
 *
 * @author nikolas
 */
public class UsuarioDAO {

    static public Usuario findByIdAndPassword(String pIdent, String senha) {
        Usuario obj = null;
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(SQLs.FINDID_USER.getSql())) {
            stmt.setString(1, pIdent);
            stmt.setString(2, senha);

            System.out.println("Conexão aberta!");

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String identificador = rs.getString("identificador");
                String endereco = rs.getString("senha");
                obj = new Usuario(id, identificador, endereco);
            }

        } catch (SQLException e) {
            System.out.println("Exceção SQL - findById");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exceção no código!- findById");
        }
        return obj;
    }
    
}
