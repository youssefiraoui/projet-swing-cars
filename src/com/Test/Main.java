/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Test;

import com.Entities.Client;
import com.Entities.User;
import com.Entities.Ville;
import com.dao.CrudImpl;

/**
 *
 * @author YouSsef
 */
public class Main {
    public static void main(String[] args) {
        CrudImpl cd= new CrudImpl();
        Client cl=new Client();
        cl.setId_cl(4);
        cl.setNom("youssef");
        System.out.println("====>"+cl.getFax());
       // cd.updateClient(cl);
        System.out.println("1");
                
        
    }
}
