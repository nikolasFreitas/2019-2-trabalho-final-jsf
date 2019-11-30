/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

public interface GenericDAO <T> {
    public int insert(T obj);
    public java.util.List<T> listAll();
    public boolean update(T obj);
    public boolean delete(int id);
    public T findByID(int id);
}

