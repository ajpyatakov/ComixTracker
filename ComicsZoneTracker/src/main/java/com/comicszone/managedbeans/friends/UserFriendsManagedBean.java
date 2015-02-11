/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comicszone.managedbeans.friends;

import com.comicszone.dao.FriendsFacade;
import com.comicszone.dao.userdao.UserDataFacade;
import com.comicszone.entitynetbeans.Users;
import com.comicszone.managedbeans.userbeans.CurrentUserManagedBean;
import com.comicszone.managedbeans.userbeans.ProfileUserManagedBean;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Eschenko_DA
 */

@ManagedBean
@ViewScoped
public class UserFriendsManagedBean implements Serializable {
    
    @EJB
    private FriendsFacade friendsFacade;
    
    @EJB 
    private UserDataFacade userDataFacade;
    
    private List<Users> friends;

    private Users currentUser;
    
    private Users selectedUser;
    
    private Users selectedFriend;
    
    private Users selectedInfoFriend;

    
    @PostConstruct
    public void init() {
       try {
            currentUser = (Users) ((CurrentUserManagedBean) FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .getSessionMap()
                    .get("currentUserManagedBean"))
                    .getCurrentUser()
                    .clone();
            
            friends = friendsFacade.getFriends(currentUser);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ProfileUserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public List<Users> completeUser(String query) {
        
        List<Users> users = userDataFacade.getUsersWithNicknameStartsWith(query);
        List<Users> currentUserfriends = friendsFacade.getFriends(currentUser);
        
        users.removeAll(currentUserfriends);
        users.remove(currentUser);
        
        return users;
    }
    
    public void addToFriends() {
        friendsFacade.addToFriends(currentUser, selectedUser);
        setFriends(friendsFacade.getFriends(currentUser));
    }
    
    public void removeFromFrieds(Users friend) {
        friendsFacade.removeFromFriends(currentUser, friend);
        setFriends(friendsFacade.getFriends(currentUser));
    }
    
    public String getFormatedData(Users friend) {
        return new SimpleDateFormat("dd-MM-yyyy").format(friend.getBirthday());
    }
    
    public Users getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Users selectedUser) {
        this.selectedUser = selectedUser;
    }
    
    public Users getSelectedFriend() {
        return selectedFriend;
    }

    public void setSelectedFriend(Users selectedFriend) {
        this.selectedFriend = selectedFriend;
    }

    public List<Users> getFriends() {
        return friends;
    }

    public void setFriends(List<Users> friends) {
        this.friends = friends;
    }

    public Users getSelectedInfoFriend() {
        return selectedInfoFriend;
    }

    public void setSelectedInfoFriend(Users selectedInfoFriend) {
        this.selectedInfoFriend = selectedInfoFriend;
    }
    
}