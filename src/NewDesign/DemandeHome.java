/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewDesign;

import com.DataBase.SingletonConnection;
import com.View.Demande;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author MyLau
 */
public class DemandeHome extends javax.swing.JInternalFrame {

    /**
     * Creates new form EmployeHome
     */
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    static int idx=0;
    DefaultTableModel model=new DefaultTableModel();
    String path="src/icon/";
    public boolean dataStatu;
    //String requete=
    public void getData(){
        try{

	
	
       }catch(Exception e){
	
}
    }
    

    public DemandeHome() {
        initComponents();
        
        
        jTRef.setEditable(false);
        
        nomv.setEditable(true);
        nomvoi.setEditable(true);
        
        
        setLocation(8,32);
        
        
        dataStatu= true;
         
         pack();
         jTRef.setVisible(false);
         
         getData();
          
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
                
                
                
                /*ImageIcon a1=new ImageIcon(path+"ddd.png");
                Image a2=a1.getImage();
                Image a3=a2.getScaledInstance(deletebt.getWidth(), deletebt.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon a4=new ImageIcon(a3);
                deletebt.setIcon(a4);*/
    }
    Statement stmt;
    
     public void afficher(){
        
            
                
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
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLNom = new javax.swing.JLabel();
        jLPrenom = new javax.swing.JLabel();
        nomv = new javax.swing.JTextField();
        nomvoi = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jBQuitter = new javax.swing.JButton();
        jSupprimer = new javax.swing.JButton();
        jBImprimer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tble = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLTel2 = new javax.swing.JLabel();
        jTNomFiltre = new javax.swing.JTextField();
        jTRef = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLStatut1 = new javax.swing.JLabel();
        jLStatut2 = new javax.swing.JLabel();
        jLStatut3 = new javax.swing.JLabel();
        jLStatut4 = new javax.swing.JLabel();
        jLStatut5 = new javax.swing.JLabel();
        nomcl = new javax.swing.JTextField();
        tel = new javax.swing.JTextField();
        vil = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        msgaff = new javax.swing.JTextArea();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DES DEMANDES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Détails sur la demande"));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations sur l'offre"));

        jLNom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNom.setForeground(new java.awt.Color(255, 102, 102));
        jLNom.setText("Vendeur");

        jLPrenom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLPrenom.setForeground(new java.awt.Color(255, 102, 102));
        jLPrenom.setText("Voiture");

        nomv.setText(" ");
        nomv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomvActionPerformed(evt);
            }
        });
        nomv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomvKeyTyped(evt);
            }
        });

        nomvoi.setText(" ");
        nomvoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomvoiActionPerformed(evt);
            }
        });
        nomvoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomvoiKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLNom, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nomv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(nomvoi, javax.swing.GroupLayout.Alignment.LEADING)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNom, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomvoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPrenom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Opérations"));

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

        jBImprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_print.png"))); // NOI18N
        jBImprimer.setText("Imprimer");
        jBImprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jSupprimer)
                .addGap(18, 18, 18)
                .addComponent(jBQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBImprimer)
                .addContainerGap(312, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBQuitter)
                    .addComponent(jSupprimer)
                    .addComponent(jBImprimer))
                .addGap(62, 62, 62))
        );

        tble.setBackground(new java.awt.Color(204, 255, 204));
        tble.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", ""
            }
        ));
        tble.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tble);

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtre ou recherche d'un employé"));

        jLTel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTel2.setForeground(new java.awt.Color(0, 51, 255));
        jLTel2.setText("ENTRER LE PRENOM");

        jTNomFiltre.setText(" ");
        jTNomFiltre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomFiltreActionPerformed(evt);
            }
        });
        jTNomFiltre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNomFiltreKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNomFiltreKeyReleased(evt);
            }
        });

        jTRef.setText(" ");
        jTRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTRefActionPerformed(evt);
            }
        });
        jTRef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTRefKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLTel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jTNomFiltre, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTRef, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTel2)
                    .addComponent(jTNomFiltre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations sur le client"));

        jLStatut1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLStatut1.setForeground(new java.awt.Color(0, 51, 255));
        jLStatut1.setText("Nom du client");

        jLStatut2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLStatut2.setForeground(new java.awt.Color(0, 51, 255));
        jLStatut2.setText("telephone");

        jLStatut3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLStatut3.setForeground(new java.awt.Color(0, 51, 255));
        jLStatut3.setText("Ville ");

        jLStatut4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLStatut4.setForeground(new java.awt.Color(0, 51, 255));
        jLStatut4.setText("Email");

        jLStatut5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLStatut5.setForeground(new java.awt.Color(0, 51, 255));
        jLStatut5.setText("Message");

        nomcl.setText(" ");
        nomcl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomclActionPerformed(evt);
            }
        });
        nomcl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomclKeyTyped(evt);
            }
        });

        tel.setText(" ");
        tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telActionPerformed(evt);
            }
        });
        tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telKeyTyped(evt);
            }
        });

        vil.setText(" ");
        vil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vilActionPerformed(evt);
            }
        });
        vil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vilKeyTyped(evt);
            }
        });

        mail.setText(" ");
        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });
        mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mailKeyTyped(evt);
            }
        });

        msgaff.setColumns(20);
        msgaff.setRows(5);
        jScrollPane2.setViewportView(msgaff);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLStatut2)
                        .addGap(95, 95, 95)
                        .addComponent(tel, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLStatut1)
                        .addGap(72, 72, 72)
                        .addComponent(nomcl, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLStatut3)
                        .addGap(134, 134, 134)
                        .addComponent(vil, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLStatut4)
                            .addComponent(jLStatut5))
                        .addGap(104, 104, 104)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mail, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLStatut1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomcl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLStatut2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLStatut3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLStatut4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLStatut5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("jPAppli");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitterActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBQuitterActionPerformed

    private void tbleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbleMouseClicked
        // TODO add your handling code here:
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
                                         

        
    }//GEN-LAST:event_jSupprimerActionPerformed

    private void jTNomFiltreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomFiltreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomFiltreActionPerformed

    private void jTNomFiltreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNomFiltreKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_jTNomFiltreKeyTyped

    private void jTNomFiltreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNomFiltreKeyReleased
        // TODO add your handling code here:
        try{
            java.sql.Statement stmt1=conn.createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("select demandes.id_demande,demandes.nom,demandes.email,demandes.tel,villes.name,voitures.titre,clients.nom,demandes.message,demandes.created,demandes.modified " +
"FROM demandes,clients,voitures,villes " +
"WHERE demandes.client_id=clients.id_client and demandes.voiture_id=voitures.id_voiture and demandes.ville_id=villes.id_ville and demandes.nom LIKE '" + jTNomFiltre.getText().trim() + "%'");
	    tble.setModel(DbUtils.resultSetToTableModel(resultat));
	
          }catch(Exception e){
	
	
}
    }//GEN-LAST:event_jTNomFiltreKeyReleased

    private void jTRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTRefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTRefActionPerformed

    private void jTRefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTRefKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTRefKeyTyped

    private void jBImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimerActionPerformed
        // TODO add your handling code here:
        //
        int conge=0;
        String requete="select demandes.id_demande,demandes.nom,demandes.email,demandes.tel,villes.name,voitures.titre,clients.nom,demandes.message,demandes.created,demandes.modified " +
"FROM demandes,clients,voitures,villes " +
"WHERE demandes.client_id=clients.id_client and demandes.voiture_id=voitures.id_voiture and demandes.ville_id=villes.id_ville";
        try{
            stmt=conn.createStatement();
            ResultSet resultat= stmt.executeQuery(requete);

                while(resultat.next()){

                    conge=resultat.getInt("nbJour");
     
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        //
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        final String s1=Integer.toString(conge);

        
        if(nomv.getText().trim().length()>0 && nomvoi.getText().trim().length()>0
               ){
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable() {
 
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        int marge=30;
        int x = (int)pageFormat.getImageableX();
        int y = (int)pageFormat.getImageableY();
                 
        graphics.setFont(new Font("Times new roman", Font.BOLD, 20));
        graphics.setColor(Color.BLACK);
        graphics.drawString("                            FICHE DE demande\n", x + marge, y + marge);
 
        graphics.drawLine(100, 40, 470, 40);    
    
    
        
       

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
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une demande!");
        }
    }//GEN-LAST:event_jBImprimerActionPerformed

    private void nomvoiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomvoiKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_nomvoiKeyTyped

    private void nomvoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomvoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomvoiActionPerformed

    private void nomvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomvKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_nomvKeyTyped

    private void nomvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomvActionPerformed

    private void nomclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomclActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomclActionPerformed

    private void nomclKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomclKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nomclKeyTyped

    private void telActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telActionPerformed

    private void telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_telKeyTyped

    private void vilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vilActionPerformed

    private void vilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vilKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_vilKeyTyped

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailActionPerformed

    private void mailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_mailKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBImprimer;
    private javax.swing.JButton jBQuitter;
    private javax.swing.JLabel jLNom;
    private javax.swing.JLabel jLPrenom;
    private javax.swing.JLabel jLStatut1;
    private javax.swing.JLabel jLStatut2;
    private javax.swing.JLabel jLStatut3;
    private javax.swing.JLabel jLStatut4;
    private javax.swing.JLabel jLStatut5;
    private javax.swing.JLabel jLTel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jSupprimer;
    private javax.swing.JTextField jTNomFiltre;
    private javax.swing.JTextField jTRef;
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
