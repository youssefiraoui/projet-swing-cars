
package NewDesign;

import com.DataBase.SingletonConnection;
import com.View.Client;
import com.View.addVille;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Youssef
 */
public class ClientHome extends javax.swing.JInternalFrame {

    /**
     * Creates new form EmployeHome
   jTEmail */
    String path="src/icon/";
    Connection conn=SingletonConnection.getConnection();
    public boolean dataStatu;
    DefaultTableModel model=new DefaultTableModel();
    ResultSet rs2,rs;
Connection con;
    PreparedStatement ps,ps2;
    //String requete=
    private void deplace(int i)
    {
        try{
            jTEmail.setText(model.getValueAt(i,1).toString());
            Jpwd.setText(model.getValueAt(i,2).toString());
            jTNom.setText(model.getValueAt(i,0).toString());
            jFTTel.setText(model.getValueAt(i,3).toString());
            jTFAX.setText(model.getValueAt(i,4).toString());
            jTAdres.setText(model.getValueAt(i,5).toString());
            jville.setSelectedItem(model.getValueAt(i,6).toString());
            JTPays.setSelectedItem(model.getValueAt(i,7).toString());
           
        }catch(Exception e)
        {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "erreur de deplacement"+e.getLocalizedMessage());
        }
    }
    
    public void getData(){
        
        
        try{
            
        model.setRowCount(0);
            conn=SingletonConnection.getConnection();
            Statement st2 = conn.createStatement();
            rs2=st2.executeQuery("select * from clients c, villes v ,users u where c.ville_id=v.id_ville and c.user_id=u.id_user");
            while(rs2.next())
            {
                model.addRow(new Object[] {
                    rs2.getString("nom"),
                    rs2.getString("email"),
                    rs2.getString("password"),
                    rs2.getString("tel"),
                    rs2.getString("fax"),
                    rs2.getString("adresse"),
                    rs2.getString("name"),
                    rs2.getString("pays")
                });
            }
        }catch(Exception e)
        {
            System.err.println(e);
        }
       
        TableEmp.setModel(model);
        
        
    }
    
         public void setIcons(){
             ImageIcon ic=new ImageIcon("src/icon/add.png");
                Image ii=ic.getImage();
                Image ii2=ii.getScaledInstance(btaddville.getWidth(), btaddville.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icc=new ImageIcon(ii2);
               btaddville.setIcon(icc);
         }

    
    public ClientHome() {
        initComponents();  
        jTDateNais.setDate(new Date());
        
        
        setLocation(8,32);
        
        
      //  setIcons();
        dataStatu= true;
         SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        jTNom.requestFocus();
       
      }
      
    });
         pack();
         
         
         
         try {
            ps=conn.prepareStatement("Select * from villes ");
            ps.executeQuery();
            rs=ps.getResultSet();
            while(rs.next()){
                        jville.addItem(rs.getString("name"));
                             }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         model.addColumn("NOM");
        model.addColumn("EMAIL");
        model.addColumn("PASSWORD");
        model.addColumn("TEL");
        model.addColumn("FAX");
        model.addColumn("ADRESSE");
        model.addColumn("VILLE");
        model.addColumn("PAYS");
        try{
            
        model.setRowCount(0);
            conn=SingletonConnection.getConnection();
            Statement st2 = conn.createStatement();
            rs2=st2.executeQuery("select * from clients c, villes v ,users u where c.ville_id=v.id_ville and c.user_id=u.id_user");
            while(rs2.next())
            {
                model.addRow(new Object[] {
                    rs2.getString("nom"),
                    rs2.getString("email"),
                    rs2.getString("password"),
                    rs2.getString("tel"),
                    rs2.getString("fax"),
                    rs2.getString("adresse"),
                    rs2.getString("name"),
                    rs2.getString("pays")
                });
            }
        }catch(Exception e)
        {
            System.err.println(e);
        }
       
        TableEmp.setModel(model);
        
        
        
        
         
   
                
       
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
        jTNom = new javax.swing.JTextField();
        jTPrenom = new javax.swing.JTextField();
        jTLieuNais = new javax.swing.JTextField();
        jLLieuNais = new javax.swing.JLabel();
        jLSexe = new javax.swing.JLabel();
        jLNIF = new javax.swing.JLabel();
        jCSexe = new javax.swing.JComboBox();
        jville = new javax.swing.JComboBox();
        jLNIF1 = new javax.swing.JLabel();
        jLDateNais = new javax.swing.JLabel();
        jLNiveauEtude = new javax.swing.JLabel();
        JTPays = new javax.swing.JComboBox();
        jTDateNais = new com.toedter.calendar.JDateChooser();
        btaddville = new javax.swing.JButton();
        jTAdres = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLTel = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        jTEmail = new javax.swing.JTextField();
        jLTel3 = new javax.swing.JLabel();
        Jpwd = new javax.swing.JPasswordField();
        jLEmail1 = new javax.swing.JLabel();
        jFTTel = new javax.swing.JTextField();
        jTFAX = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jBValider = new javax.swing.JButton();
        jBVider = new javax.swing.JButton();
        jBQuitter = new javax.swing.JButton();
        jSupprimer = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableEmp = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jTSearch = new javax.swing.JTextField();
        jLTel1 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DES ClIENTS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1065, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Détails sur le client"));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations Personnelles"));

        jLNom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNom.setForeground(new java.awt.Color(255, 102, 102));
        jLNom.setText("NOM");

        jLPrenom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLPrenom.setForeground(new java.awt.Color(255, 102, 102));
        jLPrenom.setText("PRENOM");

        jTNom.setText(" ");
        jTNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomActionPerformed(evt);
            }
        });
        jTNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNomKeyTyped(evt);
            }
        });

        jTPrenom.setText(" ");
        jTPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPrenomActionPerformed(evt);
            }
        });
        jTPrenom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPrenomKeyTyped(evt);
            }
        });

        jTLieuNais.setText(" ");
        jTLieuNais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTLieuNaisActionPerformed(evt);
            }
        });
        jTLieuNais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTLieuNaisKeyTyped(evt);
            }
        });

        jLLieuNais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLLieuNais.setForeground(new java.awt.Color(255, 102, 102));
        jLLieuNais.setText("LIEU DE NAISSANCE");

        jLSexe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLSexe.setForeground(new java.awt.Color(255, 102, 102));
        jLSexe.setText("SEXE");

        jLNIF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNIF.setForeground(new java.awt.Color(255, 102, 102));
        jLNIF.setText("Adresse");

        jCSexe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculin", "Féminin" }));
        jCSexe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCSexeActionPerformed(evt);
            }
        });

        jLNIF1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNIF1.setForeground(new java.awt.Color(255, 102, 102));
        jLNIF1.setText("Ville");

        jLDateNais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLDateNais.setForeground(new java.awt.Color(255, 102, 102));
        jLDateNais.setText("DATE NAISSANCE");

        jLNiveauEtude.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNiveauEtude.setForeground(new java.awt.Color(255, 102, 102));
        jLNiveauEtude.setText("Pays");

        JTPays.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MAROC", "FRANCE", "ALGERIE", "ESPAGNE", "autre" }));

        jTDateNais.setDateFormatString("yyyy-MM-dd");

        btaddville.setText("jButton2");
        btaddville.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddvilleActionPerformed(evt);
            }
        });

        jTAdres.setText(" ");
        jTAdres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAdresActionPerformed(evt);
            }
        });
        jTAdres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTAdresKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLNom, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLSexe, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLDateNais)
                                .addComponent(jLLieuNais)
                                .addComponent(jLNIF))
                            .addGap(38, 38, 38))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLNIF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(6, 6, 6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLNiveauEtude)
                        .addGap(137, 137, 137)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTPays, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTLieuNais)
                    .addComponent(jCSexe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTNom)
                    .addComponent(jTPrenom)
                    .addComponent(jTDateNais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jville, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btaddville, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTAdres)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNom, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSexe, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLDateNais, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTDateNais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLLieuNais, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTLieuNais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNIF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNIF1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btaddville))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNiveauEtude, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Contact"));

        jLTel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTel.setForeground(new java.awt.Color(255, 102, 102));
        jLTel.setText("TELEPHONE");

        jLEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLEmail.setForeground(new java.awt.Color(255, 102, 102));
        jLEmail.setText("Fax");

        jTEmail.setText(" ");
        jTEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEmailActionPerformed(evt);
            }
        });

        jLTel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTel3.setForeground(new java.awt.Color(255, 102, 102));
        jLTel3.setText("Password");

        jLEmail1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLEmail1.setForeground(new java.awt.Color(255, 102, 102));
        jLEmail1.setText("E-MAIL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLTel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLTel, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addComponent(jLEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLEmail1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(Jpwd, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFTTel)
                    .addComponent(jTFAX)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jpwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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

        TableEmp.setBackground(new java.awt.Color(204, 255, 204));
        TableEmp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TableEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Email", "Password", "Tel", "Fax", "Adresse", "Ville", "Pays"
            }
        ));
        TableEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableEmpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableEmp);

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Recherche d'un client"));

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
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jTSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSearchKeyReleased
        // TODO add your handling code here:

        dataStatu=false;

        try{
            model.setRowCount(0);//pour  vider tableau
            java.sql.Statement stmt1=conn.createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("select * from clients c, villes v ,users u where c.ville_id=v.id_ville and c.user_id=u.id_user and c.nom= '" + jTSearch.getText().trim() + "'");
            while(resultat.next())
            {
                model.addRow(new Object[] {
                    resultat.getString("nom"),
                    resultat.getString("email"),
                    resultat.getString("password"),
                    resultat.getString("tel"),
                    resultat.getString("fax"),
                    resultat.getString("adresse"),
                    resultat.getString("name"),
                    resultat.getString("pays")
                });
            }
            TableEmp.setModel(model);

        }catch(Exception e){

        }

    }//GEN-LAST:event_jTSearchKeyReleased

    private void jTSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSearchActionPerformed

    private void TableEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableEmpMouseClicked
        // TODO add your handling code here:
        dataStatu=false;
          try
        {
            int i=TableEmp.getSelectedRow();
            deplace(i);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "erruer de delacement "+e.getLocalizedMessage());
        }
    }//GEN-LAST:event_TableEmpMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        final String dateNais=sdf.format(jTDateNais.getDate());

        if(jTNom.getText().trim().length()>0 
           &&
            jFTTel.getText().length()>0 && jTEmail.getText().trim().length()>0){
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
                    graphics.drawString("                            FICHE DU Client\n", x + marge, y + marge);

                    graphics.drawLine(100, 40, 470, 40);

                    graphics.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 18));
                    graphics.drawString(" *Nom", 130, 80);
                    graphics.drawString(jTNom.getText(), 350, 80);

                    graphics.drawString(" *Prénom", 130, 110);
                    graphics.drawString(jTPrenom.getText(), 350, 110);

                    graphics.drawString(" *Sexe", 130, 140);
                    graphics.drawString((String) jCSexe.getSelectedItem(), 350, 140);

                    graphics.drawString(" *Date Naissance", 130, 170);
                    graphics.drawString(dateNais, 350, 170);

                    graphics.drawString(" *Lieu", 130, 200);
                    graphics.drawString(jTLieuNais.getText(), 350, 200);

                   

                   

                    graphics.drawString(" *Téléphone", 130, 450);
                    graphics.drawString(jFTTel.getText(), 350, 450);

                    graphics.drawString(" *Email", 130, 480);
                    graphics.drawString(jTEmail.getText(), 350, 480);

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
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un client");
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSupprimerActionPerformed
       /*
        
        */
       String email=jTEmail.getText().trim();
       String nom=jTNom.getText();
        if(jTNom.getText().trim().length()>0 && jTEmail.getText().trim().length()>0){
        
        if(JOptionPane.showConfirmDialog(null, "voulez vous vraiment supprimer "+nom,"modification",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {int id_usr = 0;
        try {
            PreparedStatement s1=conn.prepareStatement("select * from users where email=?");
            s1.setString(1, email);
            s1.executeQuery();
            ResultSet r=s1.getResultSet();
            r.next();
             id_usr=r.getInt("id_user");
            r.close();
            s1.close();
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            PreparedStatement oo=conn.prepareStatement("delete from clients where user_id=?");
            oo.setInt(1, id_usr);
            oo.executeUpdate();
            oo.close();
            PreparedStatement o=conn.prepareStatement("delete from users where id_user=?");
            o.setInt(1, id_usr);
            o.executeUpdate();
            o.close();
            getData();
             
         jTNom.setText("");
        jTPrenom.setText("");
        jCSexe.setSelectedItem("Masculin");
        jTLieuNais.setText("");
        jville.setSelectedItem(2);
        JTPays.setSelectedItem(1);
        jTAdres.setText("");
        jFTTel.setText(null);
        jTFAX.setText(null);
        jTEmail.setText("");
        Jpwd.setText("");
       
        jTDateNais.setDate(new Date());
        
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        }else
        {
          JOptionPane.showMessageDialog(null, "Veuillez sélectionner un client!");  
        }
        
       
        
    }//GEN-LAST:event_jSupprimerActionPerformed

    private void jBQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitterActionPerformed
        // TODO add your handling code here:
        dispose();

    }//GEN-LAST:event_jBQuitterActionPerformed

    private void jBViderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBViderActionPerformed
        // TODO add your handling code here:
        dataStatu=true;
        jTNom.setText("");
        jTPrenom.setText("");
        jCSexe.setSelectedItem("Masculin");
        jTLieuNais.setText("");
        jville.setSelectedItem(2);
        JTPays.setSelectedItem(1);
        jTAdres.setText("");
        jFTTel.setText(null);
        jTFAX.setText(null);
        jTEmail.setText("");
        Jpwd.setText("");
        getData();
        jTDateNais.setDate(new Date());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jTNom.requestFocus();

            }

        });
    }//GEN-LAST:event_jBViderActionPerformed

    private void jBValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBValiderActionPerformed
        // TODO add your handling code here:
        //*********************************************************

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String daterecup=sdf.format(jTDateNais.getDate());
        String nom=jTNom.getText().toUpperCase().trim()+" "+jTPrenom.getText().trim();
        String sexerecup= jCSexe.getSelectedItem().toString();
        String lieurecup=jTLieuNais.getText().trim();
        String vill=jville.getSelectedItem().toString();
        String pays=JTPays.getSelectedItem().toString();
        int tel=Integer.parseInt(jFTTel.getText());
        int fax=Integer.parseInt(jTFAX.getText());
        
   ; 
        String adress=jTAdres.getText();
        String email=jTEmail.getText().trim();
        String pwd=Jpwd.getText().trim();

        if(    jTNom.getText().trim().length()>0
            && jTPrenom.getText().trim().length()>0
            && daterecup.length()>0
            && jTLieuNais.getText().trim().length()>0
            && jFTTel.getText().trim().length()>0
            && jTEmail.getText().trim().length()>0
            && jTFAX.getText().trim().length()>0
        ){
            
            /*
            insert into user
            */
            boolean ext=false;
             String sql="insert into users(email,password,created,modified) values (?,?,CURRENT_DATE(),CURRENT_DATE())";
        try {
            PreparedStatement s2=conn.prepareStatement("select * from users where email=?");
            s2.setString(1, email);
            s2.executeQuery();
            ResultSet r=s2.getResultSet();
            if(r.next())
            {
                ext=true;
            JOptionPane.showMessageDialog(null, " user deja exist");    
            }else
            {
            PreparedStatement pss=conn.prepareStatement(sql);
            pss.setString(1, email);
            pss.setString(2, pwd);
            pss.executeUpdate();
            System.out.println("users inscrit");  
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /*
        
        */
        int id_usr = 0;
     if(ext==false){
        try {
            PreparedStatement s1=conn.prepareStatement("select * from users where email=?");
            s1.setString(1, email);
            s1.executeQuery();
            ResultSet r=s1.getResultSet();
            r.next();
             id_usr=r.getInt("id_user");
            r.close();
            s1.close();
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        /*
        
        */
        int id_ville=1;
        try {
            PreparedStatement ww=conn.prepareStatement("select * from villes where name=?");
            ww.setString(1, vill);
            ww.executeQuery();
            ResultSet rt=ww.getResultSet();
            rt.next();
            id_ville= rt.getInt("id_ville");
           rt.close();
           ww.close();
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           /*
        
        */
           int x=159,y=159;
           // pwd emailtel fax pas vill nom 
            String sql2="insert into clients(nom,tel,ville_id,user_id,fax,adresse,pays)"
               + "values (?,?,?,?,?,?,?)";
       if(id_usr!=0){
        try {
            PreparedStatement pp=conn.prepareStatement(sql2);
            pp.setString(1, nom);
            pp.setInt(2, x);
            pp.setInt(3, id_ville);
            pp.setInt(4, id_usr);
            pp.setInt(5, y);
            pp.setString(6, adress);
            pp.setString(7, pays);
            pp.executeUpdate();
            System.out.println("client bien ajoutee");
            JOptionPane.showMessageDialog(null, " Client Bien ajouté ");
            
            jTNom.setText("");
        jTPrenom.setText("");
        jCSexe.setSelectedItem("Masculin");
        jTLieuNais.setText("");
        jville.setSelectedItem(2);
        JTPays.setSelectedItem(1);
        jTAdres.setText("");
        jFTTel.setText(null);
        jTFAX.setText(null);
        jTEmail.setText("");
        Jpwd.setText("");

        jTDateNais.setDate(new Date());
        } catch (SQLException ee) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ee);
        }
       
       }         
       getData();
        }else{
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs!");
        }}

    }//GEN-LAST:event_jBValiderActionPerformed

    private void jTEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEmailActionPerformed

    private void jTAdresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAdresKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAdresKeyTyped

    private void jTAdresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAdresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAdresActionPerformed

    private void btaddvilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddvilleActionPerformed
        // TODO add your handling code here:
        addVille a=new addVille();
        a.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btaddvilleActionPerformed

    private void jCSexeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCSexeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCSexeActionPerformed

    private void jTLieuNaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTLieuNaisKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_jTLieuNaisKeyTyped

    private void jTLieuNaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTLieuNaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTLieuNaisActionPerformed

    private void jTPrenomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPrenomKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_jTPrenomKeyTyped

    private void jTPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPrenomActionPerformed

    private void jTNomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNomKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_jTNomKeyTyped

    private void jTNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox JTPays;
    private javax.swing.JPasswordField Jpwd;
    private javax.swing.JTable TableEmp;
    private javax.swing.JButton btaddville;
    private javax.swing.JButton jBQuitter;
    private javax.swing.JButton jBValider;
    private javax.swing.JButton jBVider;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCSexe;
    private javax.swing.JTextField jFTTel;
    private javax.swing.JLabel jLDateNais;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLEmail1;
    private javax.swing.JLabel jLLieuNais;
    private javax.swing.JLabel jLNIF;
    private javax.swing.JLabel jLNIF1;
    private javax.swing.JLabel jLNiveauEtude;
    private javax.swing.JLabel jLNom;
    private javax.swing.JLabel jLPrenom;
    private javax.swing.JLabel jLSexe;
    private javax.swing.JLabel jLTel;
    private javax.swing.JLabel jLTel1;
    private javax.swing.JLabel jLTel3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSupprimer;
    private javax.swing.JTextField jTAdres;
    private com.toedter.calendar.JDateChooser jTDateNais;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTFAX;
    private javax.swing.JTextField jTLieuNais;
    private javax.swing.JTextField jTNom;
    private javax.swing.JTextField jTPrenom;
    private javax.swing.JTextField jTSearch;
    private javax.swing.JComboBox jville;
    // End of variables declaration//GEN-END:variables
}
