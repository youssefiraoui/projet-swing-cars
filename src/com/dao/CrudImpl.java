/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.DataBase.SingletonConnection;
import com.Entities.Voiture;
import com.Entities.Client;
import com.Entities.Demande;
import java.sql.*;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YouSsef
 */
public class CrudImpl implements CrudInt{
    
    ResultSet rs;

    @Override
    public void addVoiture(Voiture v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteVoiture(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateVoiture(Voiture obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Voiture getVoitureById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Voiture> getAllVoitures() {
        List<Voiture> list;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addClient(Client v) {
        Connection conn;
    PreparedStatement ps;
        try {
            conn=SingletonConnection.getConnection();
            ps=conn.prepareStatement("insert INTO clients(nom,tel,ville_id,user_id,fax,adresse,pays) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, v.getNom());
            ps.setInt(2, v.getTel());
            ps.setInt(3, v.getVille().getId());
            ps.setInt(4, v.getIdUser());
            ps.setInt(5, v.getFax());
            ps.setString(6, v.getAdress());
            ps.setString(7, v.getPays());
            ps.executeUpdate();
            ps.close();
            System.out.println("Client daaz");
        } catch (SQLException ex) {
            Logger.getLogger(CrudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void deleteClient(int id) {
        try {
            Connection conn;
            PreparedStatement ps;
            conn=SingletonConnection.getConnection();
            ps=conn.prepareStatement("delete from Clients where id_client=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            System.out.println("bien supprimer");
        } catch (SQLException ex) {
            Logger.getLogger(CrudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateClient(Client cl) {
        Connection conn;
        String sql="Update clients set nom=?,tel=? fax=? pays=? where id_client=?";
        PreparedStatement ps;
        conn=SingletonConnection.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,cl.getNom());
            ps.setInt(2, cl.getTel());
            ps.setInt(3, cl.getFax());
            ps.setString(4, cl.getPays());
            ps.setInt(5, cl.getId_cl());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CrudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public Client getClientById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Voiture> getAlClients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDemande(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Demande> getAllDemande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Demande getDemandeById(int id, int id2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
