/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comicszone.dao;

//import com.netcracker.entity.Comics;
import com.comicszone.entitynetbeans.AjaxComicsCharacter;
import com.comicszone.entitynetbeans.Comics;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ArsenyPC
 */
//@Stateless
@Local
//@Remote
//@PostConstruct
public interface Finder {
    public List<? extends AjaxComicsCharacter> findByNameStartsWith(String name);
    public AjaxComicsCharacter find (Object id);
}
