/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Imovel;

/**
 *
 * @author nikolas
 */
@ManagedBean
@SessionScoped
public class ImovelBean {
    private Imovel imovel = new Imovel();
    private List<Imovel> imovelList;

    public ImovelBean() {
        if (imovelList == null) {
            imovelList = imovel.listImovel();
        }
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public List<Imovel> getImovelList() {
        return imovelList;
    }

    public void setImovelList(List<Imovel> imovelList) {
        this.imovelList = imovelList;
    } 
    
    public void adicionar() {
        int chave = imovel.insert();
        if (chave > 0) {
            this.imovel.setId(chave);
            this.imovelList.add(imovel);
            this.imovel = new Imovel();
        }
    }
    
    public String editImovel(Imovel imovel) {
        this.imovel = imovel;
        return "editImovel";
    }
    
    public void deleteImovel(Imovel imovel){
        if (this.imovel.delete(imovel.getId())) {
            imovelList.remove(imovel);
        }
    }
    
    public String updateImovel() {
        if (imovel.update()) {
            int index = imovelList.indexOf(imovel);
            imovelList.set(index, imovel);
            return "imoveis";
        }
        return null;
    }
}
