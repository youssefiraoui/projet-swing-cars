
package NewDesign;

import com.DataBase.SingletonConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Iraoui
 * 
 */
public class ListeVoitures extends javax.swing.JInternalFrame {
ResultSet rs2;
Connection conn;
    PreparedStatement ps,ps2;
    /**
     * Creates new form ListeEmploye
     */
   
   
    public ListeVoitures() {
        initComponents();
        setLocation(8,32);
        DefaultTableModel model=new DefaultTableModel();
           
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
           // String sql="select voitures.titre,voitures.kilometrage,voitures.year,voitures.description, voitures.created,voitures.modified,voitures.prix, boites.name, carburants.name,colors.name ,etats.name,marques.name,villes.name, clients.nom,modeles.name from voitures ,boites ,colors ,etats ,marques ,modeles , villes , carburants ,clients ,voitures_options where voitures.carburant_id=carburants.id_carburant AND voitures.boite_id=boites.id_boite AND voitures.color_id=colors.id_color AND voitures.etat_id=etats.id_etat AND voitures.marque_id=marques.id_marque AND voitures.ville_id=villes.id_ville AND voitures.modele_id=modeles.id_modele and modeles.marque_id=marques.id_marque and voitures.client_id=clients.id_client ";
            String sql2="select DISTINCT (voitures.titre),voitures.kilometrage,voitures.year,voitures.description, voitures.created,voitures.modified,voitures.prix, boites.name, carburants.name,colors.name ,etats.name,marques.name,villes.name, clients.nom,modeles.name from voitures ,boites ,colors ,etats ,marques ,modeles , villes , carburants ,clients ,voitures_options where voitures.carburant_id=carburants.id_carburant AND voitures.boite_id=boites.id_boite AND voitures.color_id=colors.id_color AND voitures.etat_id=etats.id_etat AND voitures.marque_id=marques.id_marque AND voitures.ville_id=villes.id_ville AND voitures.modele_id=modeles.id_modele and modeles.marque_id=marques.id_marque and voitures.client_id=clients.id_client ";
        try{
            Statement st2 = conn.createStatement();
         /*   rs2=st2.executeQuery("select voitures.titre,voitures.kilometrage,voitures.year,voitures.description,"
                    + "voitures.created,voitures.modified,voitures.prix, boites.name,"
                    + " carburants.name,colors.name ,etats.name,marques.name,villes.name,"
                    + "clients.nom,modeles.name from "
                    + "voitures ,boites ,colors ,etats ,marques ,modeles , villes , carburants ,clients ,voitures_options"
                    + " where voitures.carburant_id=carburants.id_carburant AND voitures.boite_id=boites.id_boite AND "
                    + "voitures.color_id=colors.id_color AND voitures.etat_id=etats.id_etat AND "
                    + "voitures.marque_id=marques.id_marque AND voitures.ville_id=villes.id_ville "
                    + "AND voitures.modele_id=modeles.id_modele and modeles.marque_id=marques.id_marque "
                    + "and voitures_options.voiture_id=voitures.id_voiture "
                    + " and voitures.client_id=clients.id_client");*/
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tble = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste des Voitures"));

        tble.setBackground(new java.awt.Color(204, 255, 204));
        tble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tble);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Impression"));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/printer.png"))); // NOI18N
        jButton1.setText("Imprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(588, 588, 588)
                .addComponent(jButton1)
                .addContainerGap(575, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Liste des Voitures");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            tble.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Erreur d'impression ", e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tble;
    // End of variables declaration//GEN-END:variables
}
