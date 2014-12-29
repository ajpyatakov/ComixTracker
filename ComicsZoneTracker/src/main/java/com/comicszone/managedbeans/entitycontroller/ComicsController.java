/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comicszone.managedbeans.entitycontroller;

import com.comicszone.dao.ComicsFacade;
import com.comicszone.entitynetbeans.Comics;
import com.comicszone.entitynetbeans.Issue;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ArsenyPC
 */
@ManagedBean(name="comicsController")
@RequestScoped
public class ComicsController {
    @EJB
    private ComicsFacade comicsFacade;
    private Comics comics;
    private Integer comicsId;
    
    public Integer getComicsId() {
        return comicsId;
    }

    public void setComicsId(Integer comicsId) {
        this.comicsId = comicsId;
    }
    public void initComics()
    {
        comics=comicsFacade.find(comicsId);
    }

    public Comics getComics() {
        return comics;
    }

    public void setComics(Comics comics) {
        this.comics = comics;
    }
    
    public String redirect(Integer issueId)
    {
        return "/resources/pages/issuePage.jsf?faces-redirect=true&id=" + issueId;
    }

}
