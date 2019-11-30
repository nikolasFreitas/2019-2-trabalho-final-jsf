/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ImovelDAO;
import java.util.List;

/**
 *
 * @author nikolas
 */
public class Imovel {

    private int id;
    private long matricula;
    private String endereco;
    private double valorVenda;

    public Imovel() {
    }

    public Imovel(int id, long matricula, String endereco, double valorVenda) {
        this.id = id;
        this.matricula = matricula;
        this.endereco = endereco;
        this.valorVenda = valorVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public List<Imovel> listImovel() {
        return new ImovelDAO().listAll();
    }

    public boolean delete(int id) {
        return new ImovelDAO().delete(id);
    }

    public int insert() {
        return new ImovelDAO().insert(this);
    }

    public boolean update() {
        return new ImovelDAO().update(this);
    }

    @Override
    public String toString() {
        return "Imovel{" + "id=" + id + ", matricula= " + matricula + ", endereco= " + endereco + ", valorVenda= " + valorVenda + '}';
    }

}
