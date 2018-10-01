/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.Entities.Voiture;
import com.Entities.Client;
import com.Entities.Demande;
import java.util.List;


/**
 *
 * @author YouSsef
 */
public interface CrudInt {
    
    //Voiture
    public void addVoiture(Voiture v);
    public void deleteVoiture(int id);
    public void updateVoiture(Voiture obj);
    public Voiture getVoitureById(int id);
    public List<Voiture> getAllVoitures();
    
    
    //Client
    public void addClient(Client v);
    public void deleteClient(int id);
    public void updateClient(Client obj);
    public Client getClientById(int id);
    public List<Voiture> getAlClients();
    
    //Demandes
    
     public void deleteDemande(int id);
      public List<Demande> getAllDemande();
      public Demande getDemandeById(int id,int id2);
}
