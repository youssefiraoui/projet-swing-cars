/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewDesign;

import com.DataBase.SingletonConnection;
import com.View.Client;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Youssef
 */
public class VoitureHome extends javax.swing.JInternalFrame {

    /**
     * Creates new form EmployeHome
     */
     DefaultTableModel model=new DefaultTableModel();
     ResultSet rs2;
        PreparedStatement ps,ps2;
    Connection conn=SingletonConnection.getConnection();
    
    public boolean dataStatu;
    //String requete=
    
    
    public void videchamp(){
        titrevoi.setText("");
        kilooo.setText("");
        year.setSelectedItem(1);
        prix.setText("");
        boiteitem.setSelectedItem(3);
        coloritem.setSelectedItem(3);
        carburantitm.setSelectedItem(3);
        etatitem.setSelectedItem(3);
        modelitem.setSelectedItem(3);
        villeitem.setSelectedItem(3);
        clientitem.setSelectedItem(2);
        marqueitem.setSelectedItem(3);
        desc.setText("");
    }
    public void getData(){
        try{
            model.setRowCount(0);
            Statement st2 = conn.createStatement();
           /* rs2=st2.executeQuery("select voitures.titre,voitures.kilometrage,voitures.year,voitures.description,"
                    + "voitures.created,voitures.modified,voitures.prix, boites.name,"
                    + " carburants.name,colors.name ,etats.name,marques.name,villes.name,"
                    + "clients.nom,modeles.name from "
                    + "voitures ,boites ,colors ,etats ,marques ,modeles , villes , carburants ,clients ,voitures_options"
                    + " where voitures.carburant_id=carburants.id_carburant AND voitures.boite_id=boites.id_boite AND "
                    + "voitures.color_id=colors.id_color AND voitures.etat_id=etats.id_etat AND "
                    + "voitures.marque_id=marques.id_marque AND voitures.ville_id=villes.id_ville "
                    + "AND voitures.modele_id=modeles.id_modele and modeles.marque_id=marques.id_marque "
                   // + "and voitures_options.voiture_id=voitures.id_voiture "
                    + " and voitures.client_id=clients.id_client");*/
            String sql2="select DISTINCT (voitures.titre),voitures.kilometrage,voitures.year,voitures.description, voitures.created,voitures.modified,voitures.prix, boites.name, carburants.name,colors.name ,etats.name,marques.name,villes.name, clients.nom,modeles.name from voitures ,boites ,colors ,etats ,marques ,modeles , villes , carburants ,clients ,voitures_options where voitures.carburant_id=carburants.id_carburant AND voitures.boite_id=boites.id_boite AND voitures.color_id=colors.id_color AND voitures.etat_id=etats.id_etat AND voitures.marque_id=marques.id_marque AND voitures.ville_id=villes.id_ville AND voitures.modele_id=modeles.id_modele and modeles.marque_id=marques.id_marque and voitures.client_id=clients.id_client ";
            rs2=st2.executeQuery(sql2);
            
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
         
    }
    
    
    /*
    remplier les items
    */
    public void remplirItem(){
        
        try {
            PreparedStatement ps = conn.prepareStatement("Select * from villes ");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        villeitem.addItem(rs.getString("name"));
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
         
        try {
            PreparedStatement ps = conn.prepareStatement("Select * from boites ");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        boiteitem.addItem(rs.getString("name"));
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            PreparedStatement ps = conn.prepareStatement("Select * from carburants ");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                       carburantitm.addItem(rs.getString("name"));
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        try {
            PreparedStatement ps = conn.prepareStatement("Select * from colors ");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        coloritem.addItem(rs.getString("name"));
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        try {
            PreparedStatement ps = conn.prepareStatement("Select * from clients ");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        clientitem.addItem(rs.getString("nom"));
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            PreparedStatement ps = conn.prepareStatement("Select * from etats ");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        etatitem.addItem(rs.getString("name"));
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            PreparedStatement ps = conn.prepareStatement("Select * from marques ");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        marqueitem.addItem(rs.getString("name"));
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            PreparedStatement ps = conn.prepareStatement("Select * from modeles ");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        modelitem.addItem(rs.getString("name"));
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       /* try {
            PreparedStatement ps = conn.prepareStatement("Select * from options ");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
          
            List<String> list=new ArrayList<>();
            while(rs.next()){
                   list.add(rs.getString("name"));
                            }
            
            String[] couleurs = {"rouge", "bleu", "gris", "vert", "jaune", "noir" } ;
            JList liste = new JList (couleurs) ;
            
             optionit.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings =(String[]) list.toArray(); ;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
private void deplace(int i)
    {
        try{
            
        titrevoi.setText(model.getValueAt(i,0).toString());
        kilooo.setText(model.getValueAt(i,1).toString());
        year.setSelectedItem(model.getValueAt(i,2).toString());
        prix.setText(model.getValueAt(i,6).toString());
        boiteitem.setSelectedItem(model.getValueAt(i,7).toString());
        coloritem.setSelectedItem(model.getValueAt(i,9).toString());
        carburantitm.setSelectedItem(model.getValueAt(i,8).toString());
        etatitem.setSelectedItem(model.getValueAt(i,10).toString());
        modelitem.setSelectedItem(model.getValueAt(i,12).toString());
        villeitem.setSelectedItem(model.getValueAt(i,13).toString());
        clientitem.setSelectedItem(model.getValueAt(i,14).toString());
        marqueitem.setSelectedItem(model.getValueAt(i,11).toString());
        desc.setText(model.getValueAt(i,3).toString());
           
        }catch(Exception e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "erreur de deplacement"+e.getLocalizedMessage());
        }
    }
    public VoitureHome() {
        initComponents();
        
        remplirItem();
        
        setLocation(8,32);
        
        dataStatu= true;
         SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        titrevoi.requestFocus();
       
      }
      
    });
         pack();
         
        
           
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
        conn=SingletonConnection.getConnection();

        try{
            /*
            "select voitures.titre,voitures.kilometrage,voitures.year,voitures.description,"
                    + "voitures.created,voitures.modified,voitures.prix, boites.name,"
                    + " carburants.name,colors.name ,etats.name,marques.name,villes.name,"
                    + "clients.nom,modeles.name from "
                    + "voitures ,boites ,colors ,etats ,marques ,modeles , villes , carburants ,clients ,voitures_options"
                    + " where voitures.carburant_id=carburants.id_carburant AND voitures.boite_id=boites.id_boite AND "
                    + "voitures.color_id=colors.id_color AND voitures.etat_id=etats.id_etat AND "
                    + "voitures.marque_id=marques.id_marque AND voitures.ville_id=villes.id_ville "
                    + "AND voitures.modele_id=modeles.id_modele and modeles.marque_id=marques.id_marque "
                   // + "and voitures_options.voiture_id=voitures.id_voiture "
                    + " and voitures.client_id=clients.id_client"
            */
            Statement st2 = conn.createStatement();
            String sql2="select DISTINCT (voitures.titre),voitures.kilometrage,voitures.year,voitures.description, voitures.created,voitures.modified,voitures.prix, boites.name, carburants.name,colors.name ,etats.name,marques.name,villes.name, clients.nom,modeles.name from voitures ,boites ,colors ,etats ,marques ,modeles , villes , carburants ,clients ,voitures_options where voitures.carburant_id=carburants.id_carburant AND voitures.boite_id=boites.id_boite AND voitures.color_id=colors.id_color AND voitures.etat_id=etats.id_etat AND voitures.marque_id=marques.id_marque AND voitures.ville_id=villes.id_ville AND voitures.modele_id=modeles.id_modele  and voitures.client_id=clients.id_client ";//and modeles.marque_id=marques.id_marque
            rs2=st2.executeQuery(sql2);
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
         
    }
    Statement stmt;
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLNom = new javax.swing.JLabel();
        jLPrenom = new javax.swing.JLabel();
        titrevoi = new javax.swing.JTextField();
        jLLieuNais = new javax.swing.JLabel();
        jLSexe = new javax.swing.JLabel();
        jLNIF = new javax.swing.JLabel();
        year = new javax.swing.JComboBox();
        carburantitm = new javax.swing.JComboBox();
        jLNIF1 = new javax.swing.JLabel();
        jLDateNais = new javax.swing.JLabel();
        jLNiveauEtude = new javax.swing.JLabel();
        etatitem = new javax.swing.JComboBox();
        jLNiveauEtude1 = new javax.swing.JLabel();
        boiteitem = new javax.swing.JComboBox();
        prix = new javax.swing.JTextField();
        coloritem = new javax.swing.JComboBox();
        modelitem = new javax.swing.JComboBox();
        kilooo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLPoste = new javax.swing.JLabel();
        jLDateEmb = new javax.swing.JLabel();
        jLStatut = new javax.swing.JLabel();
        jLDateEmb1 = new javax.swing.JLabel();
        villeitem = new javax.swing.JComboBox();
        clientitem = new javax.swing.JComboBox();
        marqueitem = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        jLStatut1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        optionit = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jBValider = new javax.swing.JButton();
        jBVider = new javax.swing.JButton();
        jBQuitter = new javax.swing.JButton();
        jSupprimer = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tble = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jTSearch = new javax.swing.JTextField();
        jLTel1 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DES Voitures");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Détails sur la voiture"));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations "));

        jLNom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNom.setForeground(new java.awt.Color(255, 102, 102));
        jLNom.setText("NOM");

        jLPrenom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLPrenom.setForeground(new java.awt.Color(255, 102, 102));
        jLPrenom.setText("KILOMETRAGE");

        titrevoi.setText(" ");
        titrevoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titrevoiActionPerformed(evt);
            }
        });
        titrevoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                titrevoiKeyTyped(evt);
            }
        });

        jLLieuNais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLLieuNais.setForeground(new java.awt.Color(255, 102, 102));
        jLLieuNais.setText("BOITE");

        jLSexe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLSexe.setForeground(new java.awt.Color(255, 102, 102));
        jLSexe.setText("YEAR");

        jLNIF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNIF.setForeground(new java.awt.Color(255, 102, 102));
        jLNIF.setText("COLOR");

        year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", " " }));
        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });

        jLNIF1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNIF1.setForeground(new java.awt.Color(255, 102, 102));
        jLNIF1.setText("CARBURANT");

        jLDateNais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLDateNais.setForeground(new java.awt.Color(255, 102, 102));
        jLDateNais.setText("PRIX");

        jLNiveauEtude.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNiveauEtude.setForeground(new java.awt.Color(255, 102, 102));
        jLNiveauEtude.setText("ETAT");

        jLNiveauEtude1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNiveauEtude1.setForeground(new java.awt.Color(255, 102, 102));
        jLNiveauEtude1.setText("MODELE");

        boiteitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boiteitemActionPerformed(evt);
            }
        });

        prix.setText(" ");
        prix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prixActionPerformed(evt);
            }
        });
        prix.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prixKeyTyped(evt);
            }
        });

        coloritem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coloritemActionPerformed(evt);
            }
        });

        kilooo.setText(" ");
        kilooo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kiloooActionPerformed(evt);
            }
        });
        kilooo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kiloooKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLNiveauEtude1)
                .addGap(77, 77, 77)
                .addComponent(modelitem, 0, 135, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLNom, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLSexe, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLDateNais)
                                .addComponent(jLLieuNais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLNIF)
                                .addComponent(jLPrenom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(38, 38, 38))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLNIF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(6, 6, 6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLNiveauEtude)
                        .addGap(101, 101, 101)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etatitem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titrevoi)
                    .addComponent(carburantitm, javax.swing.GroupLayout.Alignment.TRAILING, 0, 135, Short.MAX_VALUE)
                    .addComponent(year, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boiteitem, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prix, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(coloritem, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kilooo)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNom, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titrevoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kilooo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSexe, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDateNais, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLLieuNais, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boiteitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNIF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coloritem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNIF1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carburantitm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNiveauEtude, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etatitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNiveauEtude1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("more Informations"));

        jLPoste.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLPoste.setForeground(new java.awt.Color(255, 102, 102));
        jLPoste.setText("VILLE");

        jLDateEmb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLDateEmb.setForeground(new java.awt.Color(255, 102, 102));
        jLDateEmb.setText("CLIENT");

        jLStatut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLStatut.setForeground(new java.awt.Color(255, 102, 102));
        jLStatut.setText("MARQUE");

        jLDateEmb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLDateEmb1.setForeground(new java.awt.Color(255, 102, 102));
        jLDateEmb1.setText("DESCRIPTION");

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane2.setViewportView(desc);

        jLStatut1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLStatut1.setForeground(new java.awt.Color(255, 102, 102));
        jLStatut1.setText("OPTION");

        jScrollPane3.setViewportView(optionit);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLDateEmb)
                    .addComponent(jLStatut)
                    .addComponent(jLPoste, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLStatut1)
                    .addComponent(jLDateEmb1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(villeitem, 0, 136, Short.MAX_VALUE)
                    .addComponent(clientitem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(marqueitem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLPoste, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(villeitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jLDateEmb, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clientitem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLStatut, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marqueitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLStatut1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLDateEmb1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Opérations"));

        jBValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_save.png"))); // NOI18N
        jBValider.setText("Sauver");
        jBValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBValiderActionPerformed(evt);
            }
        });

        jBVider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/new_user.png"))); // NOI18N
        jBVider.setText("Nouveau");
        jBVider.setMaximumSize(new java.awt.Dimension(101, 23));
        jBVider.setMinimumSize(new java.awt.Dimension(101, 23));
        jBVider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBViderActionPerformed(evt);
            }
        });

        jBQuitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/use_exit.png"))); // NOI18N
        jBQuitter.setText("Sortir");
        jBQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitterActionPerformed(evt);
            }
        });

        jSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_delete.png"))); // NOI18N
        jSupprimer.setText("Supprimer");
        jSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSupprimerActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_print.png"))); // NOI18N
        jButton1.setText("Imprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jBVider, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBValider, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSupprimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBValider)
                    .addComponent(jBVider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBQuitter)
                    .addComponent(jSupprimer)
                    .addComponent(jButton1))
                .addGap(62, 62, 62))
        );

        tble.setBackground(new java.awt.Color(204, 255, 204));
        tble.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", ""
            }
        ));
        tble.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tble);

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Recherche d'un employé"));

        jTSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTSearchActionPerformed(evt);
            }
        });
        jTSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTSearchKeyReleased(evt);
            }
        });

        jLTel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTel1.setForeground(new java.awt.Color(0, 51, 255));
        jLTel1.setText("ENTRER LE PRENOM");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLTel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(119, 119, 119)
                .addComponent(jTSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTel1))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("jPAppli");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void titrevoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titrevoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titrevoiActionPerformed

    private void titrevoiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titrevoiKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_titrevoiKeyTyped

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearActionPerformed

    private void jBValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBValiderActionPerformed
        // TODO add your handling code here:
        //*********************************************************


       int idbt=0,idcl=0,idcar=0,idet=0,idmod=0,idvil=0,idclient=0,idmr=0;
        String titrev=titrevoi.getText().toUpperCase();
        int kilov=Integer.parseInt(kilooo.getText().trim());
        int yearv=Integer.parseInt( year.getSelectedItem().toString());
        int prixv=Integer.parseInt(prix.getText().trim());
        String boitev=boiteitem.getSelectedItem().toString();
        String colorv=coloritem.getSelectedItem().toString();
        String carburv=carburantitm.getSelectedItem().toString();
        String etatv=etatitem.getSelectedItem().toString();
        String modelv=modelitem.getSelectedItem().toString();
        String villev=villeitem.getSelectedItem().toString();
        String clientv=clientitem.getSelectedItem().toString();
        String marquev=marqueitem.getSelectedItem().toString();
        List<String> optionv=optionit.getSelectedValuesList();//
        String descv=desc.getText();
        
        if(titrevoi.getText().trim().length()>0 && kilooo.getText().trim().length()>0&&descv.trim().length()>0
                &&prix.getText().trim().length()>0){

        if(dataStatu==true){
            
            try{
                 try {
            PreparedStatement ps = conn.prepareStatement("Select * from boites where name=? ");
            ps.setString(1, boitev);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        idbt=rs.getInt("id_boite");
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
         
                 try {
            PreparedStatement ps = conn.prepareStatement("Select * from carburants where name=? ");
            ps.setString(1, carburv);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        idcar=rs.getInt("id_carburant");
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }       
                
     
                 try {
            PreparedStatement ps = conn.prepareStatement("Select * from clients where nom=? ");
            ps.setString(1, clientv);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        idclient=rs.getInt("id_client");
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }   
              
                 try {
            PreparedStatement ps = conn.prepareStatement("Select * from colors where name=? ");
            ps.setString(1, colorv);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        idcl=rs.getInt("id_color");
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }  
            
                 
                          try {
            PreparedStatement ps = conn.prepareStatement("Select * from etats where name=? ");
            ps.setString(1, etatv);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        idet=rs.getInt("id_etat");
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
                          
                     try {
            PreparedStatement ps = conn.prepareStatement("Select * from marques where name=? ");
            ps.setString(1, marquev);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        idmr=rs.getInt("id_marque");
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }              
                          
                         try {
            PreparedStatement ps = conn.prepareStatement("Select * from modeles where name=? ");
            ps.setString(1, modelv);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        idmod=rs.getInt("id_modele");
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }          
                     
                         
                                  try {
            PreparedStatement ps = conn.prepareStatement("Select * from villes where name=? ");
            ps.setString(1, villev);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        idvil=rs.getInt("id_ville");
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
                          
                          
                          
        try {
            PreparedStatement ps = conn.prepareStatement("Select * from colors where name=? ");
            ps.setString(1, colorv);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                        idcl=rs.getInt("id_color");
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } 
                          
               System.out.println(idcl+"   "+idmr);              
                          
               String sql="INSERT INTO `voitures` ( `titre`, `kilometrage`, `year`, `description`, `created`, `modified`, `prix`, `boite_id`, `carburant_id`, `color_id`, `etat_id`, `marque_id`,`ville_id`, `client_id`, `modele_id`) VALUES (?,?,?,?,CURRENT_DATE(),CURRENT_DATE(),?,?,?,?,?,?,?,?,?)";  
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, titrev);
                    ps.setInt(2, kilov);
                    ps.setInt(3, yearv);
                    ps.setString(4, descv);
                    
                    ps.setInt(5, prixv);
                    ps.setInt(6,idbt);
                    ps.setInt(7,idcar);
                    ps.setInt(8,idcl);
                    ps.setInt(9,idet);
                    ps.setInt(10,idmr);
                    ps.setInt(11,idvil);
                    ps.setInt(12,idclient);
                    ps.setInt(13,idmod);
                    ps.executeUpdate();
                    ps.close();
                    getData();
                    videchamp();
                     JOptionPane.showMessageDialog(null, "voiture bien enregistree");
                    
                     } catch (SQLException ex) {
                    Logger.getLogger(VoitureHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            }catch(HeadlessException e){
                //JOptionPane.showMessageDialog(null,e);
                JOptionPane.showMessageDialog(null, "Veuillez vérifier le NIF!");
                
            }
        }else{
            String requete="UPDATE Voitures  S";
      try{
            stmt =conn.createStatement();
            stmt .executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Modification réussie!");
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,e);
        }
            
        }
        getData();
        }else{
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs!");
        }   
       
    }//GEN-LAST:event_jBValiderActionPerformed

    private void jBViderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBViderActionPerformed
        // TODO add your handling code here:
        dataStatu=true;
       videchamp();
        SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        titrevoi.requestFocus();
       
      }
      
    });
    }//GEN-LAST:event_jBViderActionPerformed

    private void jBQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitterActionPerformed
        // TODO add your handling code here:
        dispose();
        
    }//GEN-LAST:event_jBQuitterActionPerformed

    private void tbleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbleMouseClicked
         dataStatu=false;
          try
        {
            int i=tble.getSelectedRow();
            deplace(i);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "erruer de delacement "+e.getLocalizedMessage());
        }
    }//GEN-LAST:event_tbleMouseClicked

    private void jSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSupprimerActionPerformed
       // TODO add your handling code here:
        if(titrevoi.getText().trim().length()>0 ){ 
       if(JOptionPane.showConfirmDialog(null, "voulez vous vraiment supprimer "+titrevoi.getText(),"modification",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            String requete="DELETE FROM voitures WHERE titre='"+titrevoi.getText()+"'";
        try{
            stmt=conn.createStatement();
            stmt.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Suppresion réussie!");
           getData();
        videchamp();
               
      }                                           
      catch(SQLException ex){
            System.err.println(ex);
        }}
        }else{
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une voiture!");
      
            
        }
        
        
    }//GEN-LAST:event_jSupprimerActionPerformed

    private void jTSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSearchKeyReleased
        // TODO add your handling code here:

        dataStatu=false;
       try{ 
           
           model.setRowCount(0);
            Statement st2 = conn.createStatement();
      
            String sql2="select DISTINCT (voitures.titre),voitures.kilometrage,voitures.year,voitures.description, voitures.created,voitures.modified,voitures.prix, boites.name, carburants.name,colors.name ,etats.name,marques.name,villes.name, clients.nom,modeles.name from voitures ,boites ,colors ,etats ,marques ,modeles , villes , carburants ,clients ,voitures_options where voitures.carburant_id=carburants.id_carburant AND voitures.boite_id=boites.id_boite AND voitures.color_id=colors.id_color AND voitures.etat_id=etats.id_etat AND voitures.marque_id=marques.id_marque AND voitures.ville_id=villes.id_ville AND voitures.modele_id=modeles.id_modele and modeles.marque_id=marques.id_marque and voitures.client_id=clients.id_client and voitures.titre like '" + jTSearch.getText().trim() + "%' ";
            rs2=st2.executeQuery(sql2);
            
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

        
    }//GEN-LAST:event_jTSearchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
        if(titrevoi.getText().trim().length()>0 
                ){
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable() {
 
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
         
    //Image
                /*BufferedImage image = ImageIO.read(new File(adresseImage));
                graphics.drawImage(image, 0, 0, null);*/
                
    //Image
        int marge=30;
        int x = (int)pageFormat.getImageableX();
        int y = (int)pageFormat.getImageableY();
                 
        graphics.setFont(new Font("Times new roman", Font.BOLD, 20));
        graphics.setColor(Color.BLACK);
        graphics.drawString("                            FICHE DU voiture\n", x + marge, y + marge);
 
        graphics.drawLine(100, 40, 470, 40);
    
    
        graphics.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        graphics.drawString(" *titre", 130, 80);        
        graphics.drawString(titrevoi.getText(), 350, 80);
        
        
        
        graphics.drawString(" *annee", 130, 140);
        graphics.drawString((String) year.getSelectedItem(), 350, 140);
        

        

        return PAGE_EXISTS;
            }
 
        });
boolean doPrint = job.printDialog();
if(doPrint) {
    try {
         
        job.print();
    }
    catch (PrinterException e1) {
            JOptionPane.showMessageDialog(null, e1);
    }
}}else{
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une voiture!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boiteitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boiteitemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boiteitemActionPerformed

    private void prixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prixActionPerformed

    private void prixKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prixKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_prixKeyTyped

    private void coloritemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coloritemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coloritemActionPerformed

    private void kiloooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kiloooActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kiloooActionPerformed

    private void kiloooKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kiloooKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_kiloooKeyTyped

    private void jTSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boiteitem;
    private javax.swing.JComboBox carburantitm;
    private javax.swing.JComboBox clientitem;
    private javax.swing.JComboBox coloritem;
    private javax.swing.JTextArea desc;
    private javax.swing.JComboBox etatitem;
    private javax.swing.JButton jBQuitter;
    private javax.swing.JButton jBValider;
    private javax.swing.JButton jBVider;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLDateEmb;
    private javax.swing.JLabel jLDateEmb1;
    private javax.swing.JLabel jLDateNais;
    private javax.swing.JLabel jLLieuNais;
    private javax.swing.JLabel jLNIF;
    private javax.swing.JLabel jLNIF1;
    private javax.swing.JLabel jLNiveauEtude;
    private javax.swing.JLabel jLNiveauEtude1;
    private javax.swing.JLabel jLNom;
    private javax.swing.JLabel jLPoste;
    private javax.swing.JLabel jLPrenom;
    private javax.swing.JLabel jLSexe;
    private javax.swing.JLabel jLStatut;
    private javax.swing.JLabel jLStatut1;
    private javax.swing.JLabel jLTel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jSupprimer;
    private javax.swing.JTextField jTSearch;
    private javax.swing.JTextField kilooo;
    private javax.swing.JComboBox marqueitem;
    private javax.swing.JComboBox modelitem;
    private javax.swing.JList<String> optionit;
    private javax.swing.JTextField prix;
    private javax.swing.JTable tble;
    private javax.swing.JTextField titrevoi;
    private javax.swing.JComboBox villeitem;
    private javax.swing.JComboBox year;
    // End of variables declaration//GEN-END:variables
}
