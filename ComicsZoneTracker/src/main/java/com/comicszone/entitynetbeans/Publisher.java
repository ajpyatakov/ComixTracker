/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comicszone.entitynetbeans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ArsenyPC
 */
@Entity
@Table(name = "\"PUBLISHER\"")
@NamedQueries({
    @NamedQuery(name = "Publisher.findAll", query = "SELECT p FROM Publisher p"),
    @NamedQuery(name = "Publisher.findByPublisherId", query = "SELECT p FROM Publisher p WHERE p.publisherId = :publisherId"),
    @NamedQuery(name = "Publisher.findByName", query = "SELECT p FROM Publisher p WHERE p.name = :name")})
public class Publisher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "publisher_id")
    private Integer publisherId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "publisherId", fetch = FetchType.LAZY)
    private List<Comics> comicsList;

    public Publisher() {
    }

    public Publisher(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Publisher(Integer publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Comics> getComicsList() {
        return comicsList;
    }

    public void setComicsList(List<Comics> comicsList) {
        this.comicsList = comicsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publisherId != null ? publisherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publisher)) {
            return false;
        }
        Publisher other = (Publisher) object;
        if ((this.publisherId == null && other.publisherId != null) || (this.publisherId != null && !this.publisherId.equals(other.publisherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netcracker.entitynetbeans.Publisher[ publisherId=" + publisherId + " ]";
    }
    
}
