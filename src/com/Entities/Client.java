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
public class Client extends User {
    
    private String nom;
    private int tel;
    private int fax;
    private String adress;
    private String pays;
    private Ville ville;

    public Client() {
      super();  
    }
    public Client(String nom, int tel, int fax, String adress, String pays,int idUser,Ville ville) {
        super(idUser);
        this.nom = nom;
        this.tel = tel;
        this.fax = fax;
        this.adress = adress;
        this.pays = pays;
        this.ville = ville;
        this.id_cl = id_cl;
    }
    
    private int id_cl;


    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
 

   
    public int getId_cl() {
        return id_cl;
    }

    public void setId_cl(int id_cl) {
        this.id_cl = id_cl;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }


}
