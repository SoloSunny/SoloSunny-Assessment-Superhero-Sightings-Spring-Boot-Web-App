/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightingsspringbootwebapp.dao;

import com.sg.superherosightingsspringbootwebapp.entities.Hero;
import com.sg.superherosightingsspringbootwebapp.entities.Superpower;
import java.util.List;

/**
 *
 * @author solomon
 */
public interface SuperpowerDao {
    
 
    Superpower getSuperpowerById(int superpowerId);

 
    List<Superpower> getAllSuperpowers();

 
    Superpower addSuperpower(Superpower superpower);

 
    void updateSuperpower(Superpower superpower);

 
    void deleteSuperpowerById(int superpowerId);
    
    Superpower getSuperpowerForHero(Hero hero);
    
}
