/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.Amiibo;
import Exceptions.InvalidIdException;
import java.util.List;


/**
 *
 * @author kmlnd
 */
public interface Dao {
    
    List<Amiibo> getAmiibos();
    
    void deleteAmiiboById(int id) throws InvalidIdException;
    
    Amiibo getAmiiboById(int id) throws InvalidIdException;
    
    void addAmiibo(Amiibo amiibo);    
    
    int getIncrementedId();
}
