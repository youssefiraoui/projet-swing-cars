/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Entities;

import java.util.Date;

/**
 *
 * @author YouSsef
 */
public class User {
    
    private int idUser;
    private String email;
    private String pwd;
    private String role;
    private Date created;
    private Date modified;
    public User(){
        
    }
    public User(int idUser, String email, String pwd, String role, Date created, Date modified) {
        this.idUser = idUser;
        this.email = email;
        this.pwd = pwd;
        this.role = role;
        this.created = created;
        this.modified = modified;
    }
   public User(int idUser)
   {
       this.idUser=idUser;
   }
    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

}
