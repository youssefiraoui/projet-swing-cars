/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.View;

import com.DataBase.SingletonConnection;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YouSsef
 */
public class Voiture extends javax.swing.JFrame {
 
   Connection conn;
    PreparedStatement ps;
    ResultSet rs,rs2;
    /**
     * Creates new form Voiture
     */
    
    DefaultTableModel model=new DefaultTableModel();
    public Voiture() {
         conn=SingletonConnection.getConnection();
        initComponents();
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         this.setSize(1090, 655);
         /*
         pour center au milieu
         */
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
        size.height/2 - getHeight()/2);
        
        model.addColumn("TITRE");
        model.addColumn("KILOMETRAGE");
        model.addColumn("YEAR");
        model.addColumn("DESCRIPTION");
        model.addColumn("CREATED");
        model.addColumn("MODIFIED");
        model.addColumn("PRIX");
        model.addColumn("BOITES");
        model.addColumn("CARBURANT");
        model.addColumn("COLOR");
        model.addColumn("ETAT");
        model.addColumn("MARQUE");
        model.addColumn("MODELE");
        //model.addColumn("OPTION");
        model.addColumn("VILLE");
        model.addColumn("CLIENT");
        /*
        select voitures.titre,voitures.kilometrage,voitures.year,voitures.description,"
                    + "voitures.created,voitures.modified,voitures.prix, boites.name,options.name,"
                    + " carburants.name,colors.name ,etats.name,marques.name,villes.name,"
                    + "clients.nom,modeles.name from "
                    + "voitures ,boites ,colors ,etats ,marques ,modeles , villes , carburants ,clients ,options,voitures_options"
                    + " where voitures.carburant_id=carburants.id_carburant AND voitures.boite_id=boites.id_boite AND "
                    + "voitures.color_id=colors.id_color AND voitures.etat_id=etats.id_etat AND "
                    + "voitures.marque_id=marques.id_marque AND voitures.ville_id=villes.id_ville "
                    + "AND voitures.modele_id=modeles.id_modele and modeles.marque_id=marques.id_marque "
                    + "and voitures_options.voiture_id=voitures.id_voiture "
                    + "and voitures_options.option_id=options.id_option and voitures.client_id=clients.id_client"
        */
        
        try{
            Statement st2 = conn.createStatement();
            rs2=st2.executeQuery("select voitures.titre,voitures.kilometrage,voitures.year,voitures.description,"
                    + "voitures.created,voitures.modified,voitures.prix, boites.name,"
                    + " carburants.name,colors.name ,etats.name,marques.name,villes.name,"
                    + "clients.nom,modeles.name from "
                    + "voitures ,boites ,colors ,etats ,marques ,modeles , villes , carburants ,clients ,voitures_options"
                    + " where voitures.carburant_id=carburants.id_carburant AND voitures.boite_id=boites.id_boite AND "
                    + "voitures.color_id=colors.id_color AND voitures.etat_id=etats.id_etat AND "
                    + "voitures.marque_id=marques.id_marque AND voitures.ville_id=villes.id_ville "
                    + "AND voitures.modele_id=modeles.id_modele and modeles.marque_id=marques.id_marque "
                    + "and voitures_options.voiture_id=voitures.id_voiture "
                    + " and voitures.client_id=clients.id_client");
            while(rs2.next())
            {
                model.addRow(new Object[] {
                    rs2.getString("voitures.titre"),
                    rs2.getString("voitures.kilometrage"),
                    rs2.getString("voitures.year"),
                    rs2.getString("description"),
                    rs2.getString("created"),
                    rs2.getString("modified"),
                    rs2.getString("prix"),
                    rs2.getString("boites.name"),
                    rs2.getString("carburants.name"),
                    rs2.getString("colors.name"),
                    rs2.getString("etats.name"),
                    rs2.getString("marques.name"),
                    rs2.getString("modeles.name"),
                    //rs2.getString("options.name"),
                    rs2.getString("villes.name"),
                    rs2.getString("clients.nom")
                    
                });
            }
        }catch(Exception e)
        {
            System.err.println(e);
        }
        
        
        
        tble.setModel(model);
        
        
        
                
        
        
        
                /*
        les icons
        */
                ImageIcon a1=new ImageIcon("src\\icon\\addCl.png");
                Image a2=a1.getImage();
                Image a3=a2.getScaledInstance(addcl.getWidth(), addcl.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon a4=new ImageIcon(a3);
                addcl.setIcon(a4);
                
                ImageIcon b1=new ImageIcon("src\\icon\\update.png");
                Image b2=b1.getImage();
                Image b3=b2.getScaledInstance(updatebt.getWidth(), updatebt.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon b4=new ImageIcon(b3);
                updatebt.setIcon(b4);
                
                ImageIcon d1=new ImageIcon("src\\icon\\deletecl.png");
                Image d2=d1.getImage();
                Image d3=d2.getScaledInstance(deletebt.getWidth(), deletebt.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon d4=new ImageIcon(d3);
                deletebt.setIcon(d4);
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
        updatebt = new javax.swing.JButton();
        deletebt = new javax.swing.JButton();
        addcl = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tble = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtre = new javax.swing.JTextField();
        serchUser = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 233));
        jPanel1.setLayout(null);

        updatebt.setText("Update");
        updatebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtActionPerformed(evt);
            }
        });
        jPanel1.add(updatebt);
        updatebt.setBounds(180, 30, 90, 60);

        deletebt.setText("Supprimer");
        deletebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtActionPerformed(evt);
            }
        });
        jPanel1.add(deletebt);
        deletebt.setBounds(310, 30, 90, 60);

        addcl.setText("Ajouter");
        addcl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addclActionPerformed(evt);
            }
        });
        jPanel1.add(addcl);
        addcl.setBounds(60, 30, 90, 60);

        tble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16"
            }
        ));
        jScrollPane1.setViewportView(tble);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 130, 1020, 340);

        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("La Listes Des Voitures"), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 110, 1050, 370);

        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 1050, 80);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "ijkjh", " ", "dfog", "qdf", "qsdf", "qdf", "vqs", "dv", "qs", "df", "qsd", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 140, 67, 218);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-1, 0, 1080, 482);

        jLabel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rechercher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(540, 490, 520, 100);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel10.setText("Rechercher par:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(660, 520, 90, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(760, 510, 130, 30);

        txtre.setText("jTextField1");
        getContentPane().add(txtre);
        txtre.setBounds(760, 550, 210, 30);

        serchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serchUserActionPerformed(evt);
            }
        });
        getContentPane().add(serchUser);
        serchUser.setBounds(980, 540, 50, 40);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addclActionPerformed
        voitR r=new voitR();
        r.setVisible(true);
    }//GEN-LAST:event_addclActionPerformed

    private void deletebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletebtActionPerformed

    private void serchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serchUserActionPerformed
        try
        {
            model.setRowCount(0);//pour vider la listes des Clients
            PreparedStatement v=conn.prepareStatement("select * from clients c, villes v ,users u where c.ville_id=v.id_ville and c.user_id=u.id_user and c.nom like '%?%'");
            v.setString(1, txtre.getText());
            v.executeQuery();
            ResultSet rr=v.getResultSet();
            while(rr.next())
            {
                Object [] cl={rs2.getString("nom"),
                    rr.getString("email"),
                    rr.getString("password"),
                    rr.getString("tel"),
                    rr.getString("fax"),
                    rr.getString("adresse"),
                    rr.getString("name"),
                    rr.getString("pays")};
                model.addRow(cl);
            }
            
        }catch(Exception e)
        {
            System.out.println("looooooo");
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_serchUserActionPerformed

    private void updatebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updatebtActionPerformed

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
            java.util.logging.Logger.getLogger(Voiture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Voiture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Voiture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Voiture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Voiture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addcl;
    private javax.swing.JButton deletebt;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton serchUser;
    private javax.swing.JTable tble;
    private javax.swing.JTextField txtre;
    private javax.swing.JButton updatebt;
    // End of variables declaration//GEN-END:variables
}
