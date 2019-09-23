/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rekon.rekonsqlite;

import java.util.Optional;
import java.util.Vector;

/**
 *
 * @author PAKIVP
 */
public interface Dao<T> {
    
    Optional<T> get(long id);
    Vector<T> getAll();
    void save(T t);
    void update(T t, String[] params);
    void delete(T t);
}