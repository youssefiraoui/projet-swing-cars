/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.View;

import com.DataBase.SingletonConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YouSsef
 */
public class Demande extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    static int idx=0;
    String path="src/icon/";
      DefaultTableModel model=new DefaultTableModel();
    /**
     * Creates new form Demande
     */
    public Demande() {
            initComponents();
            this.setSize(1090, 655);
            this.setVisible(true);
            Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
        size.height/2 - getHeight()/2);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            model.addColumn("id");
            model.addColumn("NOM DU CLIENT");
            model.addColumn("EMAIL");
            model.addColumn("TELEPHONE");
            model.addColumn("VILLE");
            model.addColumn("VOITURE");
            model.addColumn("VENDEUR");
            model.addColumn("MESSAGE");
            model.addColumn("CREATED");
            model.addColumn("MODIFIED");
           
   
            conn=SingletonConnection.getConnection();
            try {
            ps=conn.prepareStatement("select demandes.id_demande,demandes.nom,demandes.email,demandes.tel,villes.name,voitures.titre,clients.nom,demandes.message,demandes.created,demandes.modified " +
"FROM demandes,clients,voitures,villes " +
"WHERE demandes.client_id=clients.id_client and demandes.voiture_id=voitures.id_voiture and demandes.ville_id=villes.id_ville");
           rs= ps.executeQuery();
            while(rs.next())
            {
                model.addRow(new Object[] {
                    rs.getInt("demandes.id_demande"),
                    rs.getString("demandes.nom"),
                    rs.getString("demandes.email"),
                    rs.getString("demandes.tel"),
                    rs.getString("villes.name"),
                    rs.getString("voitures.titre"),
                    rs.getString("clients.nom"),
                    rs.getString("demandes.message"),
                    rs.getString("demandes.created"),
                    rs.getString("demandes.modified")
                    
                   
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(Demande.class.getName()).log(Level.SEVERE, null, ex);
        }
            
                tble.setModel(model);
                
                
                
                ImageIcon a1=new ImageIcon(path+"ddd.png");
                Image a2=a1.getImage();
                Image a3=a2.getScaledInstance(deletebt.getWidth(), deletebt.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon a4=new ImageIcon(a3);
                deletebt.setIcon(a4);
    }

    
    
    public void afficher()
    {
        
            
                
            model.setRowCount(0);
            try {
            ps=conn.prepareStatement("select demandes.id_demande,demandes.nom,demandes.email,demandes.tel,villes.name,voitures.titre,clients.nom,demandes.message,demandes.created,demandes.modified " +
"FROM demandes,clients,voitures,villes " +
"WHERE demandes.client_id=clients.id_client and demandes.voiture_id=voitures.id_voiture and demandes.ville_id=villes.id_ville");
           rs= ps.executeQuery();
            while(rs.next())
            {
                model.addRow(new Object[] {
                    rs.getInt("demandes.id_demande"),
                    rs.getString("demandes.nom"),
                    rs.getString("demandes.email"),
                    rs.getString("demandes.tel"),
                    rs.getString("villes.name"),
                    rs.getString("voitures.titre"),
                    rs.getString("clients.nom"),
                    rs.getString("demandes.message"),
                    rs.getString("demandes.created"),
                    rs.getString("demandes.modified")
                    
                   
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(Demande.class.getName()).log(Level.SEVERE, null, ex);
        }
            nomv.setText("");
               nomvoi.setText("");
               nomcl.setText("");
               tel.setText("");
               vil.setText("");
               mail.setText("");
               msgaff.setText("");
            
                tble.setModel(model);
             System.out.print("kjhjbhj");
        
    }
    
    
    private void deplace(int i)
    {
        try{
            
           
               nomv.setText(model.getValueAt(i,6).toString());
               nomvoi.setText(model.getValueAt(i,5).toString());
               nomcl.setText(model.getValueAt(i,1).toString());
               tel.setText(model.getValueAt(i,3).toString());
               vil.setText(model.getValueAt(i,4).toString());
               mail.setText(model.getValueAt(i,2).toString());
               msgaff.setText(model.getValueAt(i,7).toString());
               idx=Integer.parseInt(model.getValueAt(i,0).toString());
               
           
        }catch(Exception e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "erreur de deplacement"+e.getLocalizedMessage());
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        deletebt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tble = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        msgaff = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomvoi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nomv = new javax.swing.JTextField();
        vil = new javax.swing.JTextField();
        tel = new javax.swing.JTextField();
        nomcl = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 233));
        jPanel1.setLayout(null);

        deletebt.setText("Supprimer");
        deletebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtActionPerformed(evt);
            }
        });
        jPanel1.add(deletebt);
        deletebt.setBounds(490, 450, 100, 80);

        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(480, 440, 120, 100);

        tble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tble.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tble);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(450, 130, 610, 290);

        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("La Listes Des Voitures"), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(440, 110, 630, 320);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(720, 250, 262, 120);

        msgaff.setColumns(20);
        msgaff.setRows(5);
        jScrollPane3.setViewportView(msgaff);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(160, 450, 240, 140);

        jLabel2.setFont(new java.awt.Font("URW Bookman L", 1, 14)); // NOI18N
        jLabel2.setText("MESSAGE       :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 450, 140, 30);

        jLabel4.setFont(new java.awt.Font("URW Bookman L", 1, 14)); // NOI18N
        jLabel4.setText("Voiture           :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 200, 120, 14);
        jPanel1.add(nomvoi);
        nomvoi.setBounds(160, 190, 230, 27);

        jLabel5.setFont(new java.awt.Font("URW Bookman L", 1, 14)); // NOI18N
        jLabel5.setText("Télephone       :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 330, 140, 14);
        jPanel1.add(mail);
        mail.setBounds(160, 400, 230, 27);

        jLabel6.setFont(new java.awt.Font("URW Bookman L", 1, 14)); // NOI18N
        jLabel6.setText("Vendeur          :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 160, 140, 14);

        jLabel7.setFont(new java.awt.Font("URW Bookman L", 1, 14)); // NOI18N
        jLabel7.setText("Ville               :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 370, 140, 14);

        jLabel8.setFont(new java.awt.Font("URW Bookman L", 1, 14)); // NOI18N
        jLabel8.setText("Email             :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 410, 140, 14);

        jLabel9.setFont(new java.awt.Font("URW Bookman L", 1, 14)); // NOI18N
        jLabel9.setText("Nom du Clients:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 290, 140, 14);
        jPanel1.add(nomv);
        nomv.setBounds(160, 150, 230, 27);
        jPanel1.add(vil);
        vil.setBounds(160, 360, 230, 27);
        jPanel1.add(tel);
        tel.setBounds(160, 320, 230, 27);
        jPanel1.add(nomcl);
        nomcl.setBounds(160, 280, 230, 27);

        jLabel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMATIONS SUR L'OFFRE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 14))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 120, 390, 110);

        jLabel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMATIONS SUR LE CLIENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 14))); // NOI18N
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 260, 400, 340);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deletebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtActionPerformed
        try {
            if(idx!=0){
            if(JOptionPane.showConfirmDialog(null,"est ce que tu veut vraiment supprimer cette demande!","Suppression", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            {
                PreparedStatement pps=conn.prepareStatement("delete from demandes where id_demande=?");
                pps.setInt(1, idx);
                pps.executeUpdate();
                pps.close();
                afficher();
               
            }}else
                JOptionPane.showMessageDialog(null, "Aucun demande n'est se lectionee");
            
               
            
        } catch (SQLException ex) {
            Logger.getLogger(Demande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletebtActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void tbleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbleMouseClicked
        try
        {
            int i=tble.getSelectedRow();
            deplace(i);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "erruer de delacement "+e.getLocalizedMessage());
        }
    }//GEN-LAST:event_tbleMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Demande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Demande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Demande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Demande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Demande().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deletebt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField mail;
    private javax.swing.JTextArea msgaff;
    private javax.swing.JTextField nomcl;
    private javax.swing.JTextField nomv;
    private javax.swing.JTextField nomvoi;
    private javax.swing.JTable tble;
    private javax.swing.JTextField tel;
    private javax.swing.JTextField vil;
    // End of variables declaration//GEN-END:variables
}
