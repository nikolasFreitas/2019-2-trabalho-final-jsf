/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Imovel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nikolas
 */
public class ImovelDAO implements GenericDAO<Imovel> {

    @Override
    public int insert(Imovel obj) {
        int chavePrimaria = -1;
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(SQLs.INSERT_IMOVEL.getSql(),
                        Statement.RETURN_GENERATED_KEYS)) {
            System.out.println("Conexão aberta!");
            stmt.setLong(1, obj.getMatricula());
            stmt.setString(2, obj.getEndereco());
            stmt.setDouble(3, obj.getValorVenda());
            
            stmt.execute();
            System.out.println("Dados Gravados!");
            ResultSet chave = stmt.getGeneratedKeys();
            if (chave.next()) {
                System.out.println("Imóvel inserido");
                chavePrimaria = chave.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("exceção com recursos");
        }
        return chavePrimaria;
    }

    @Override
    public List<Imovel> listAll() {
        List<Imovel> lista = new LinkedList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(SQLs.LISTALL_IMOVEL.getSql())) {

            System.out.println("Conexão aberta!");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                long matricula = rs.getLong("matricula");
                String endereco = rs.getString("endereco");
                double valorVenda = rs.getDouble("valorVenda");
                lista.add(new Imovel(id, matricula, endereco, valorVenda));
            }
            connection.close();
            return lista;
        } catch (SQLException e) {
            System.out.println("Exceção SQL - listAll");
        } catch (Exception e) {
            System.out.println("Exceção no código - listAll!");
        }
        return null;
    }

    @Override
    public boolean update(Imovel obj) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(SQLs.UPDATE_IMOVEL.getSql())) {
            stmt.setString(1, obj.getEndereco());
            stmt.setDouble(2, obj.getValorVenda());
            stmt.setInt(3, obj.getId());
            System.out.println("Conexão aberta!");
            System.out.println("Editando o imóvel " + obj.toString());
            int result = stmt.executeUpdate();
            System.out.println("Result of connection: " + result);
            if (result>0) {
                System.out.println("Imóvel editado!");
                return true;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exceção no código! - update");
        }
        
        System.out.println("Imóvel NÃO editado!");
        return false;
    }

    @Override
    public boolean delete(int id) {
        boolean retorno = false;
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(SQLs.DELETE_IMOVEL.getSql())) {
            stmt.setInt(1, id);
            if (stmt.executeUpdate()>0) {
                retorno = true;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exceção SQL - delete");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exceção no código! - delete");
        }
        return retorno;
    }

    @Override
    public Imovel findByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
