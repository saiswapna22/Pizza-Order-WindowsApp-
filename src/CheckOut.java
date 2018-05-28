
//import java.sql.ResultSet;
import java.sql.*;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sai Swapna
 */

public class CheckOut extends javax.swing.JFrame {

    /**
     * Creates new form CheckOut
     */
    DbConnection dbc;
    public CheckOut() throws SQLException, ClassNotFoundException {
        initComponents();
        dbc = new DbConnection();
        dbc.rs = dbc.st.executeQuery("select * from tbl_pizza");
        ResultSetMetaData rsmetadata = dbc.rs.getMetaData();
        int columns = rsmetadata.getColumnCount();
        
        DefaultTableModel dts = new DefaultTableModel();
        Vector columns_name = new Vector();
        Vector data_rows = new Vector();
        
        
        for(int i=1; i<columns; i++){
         columns_name.addElement(rsmetadata.getColumnName(i));
        }
        dts.setColumnIdentifiers(columns_name);
        
        while(dbc.rs.next()){
            data_rows = new Vector();
            for(int j=1; j<columns; j++){
                data_rows.addElement(dbc.rs.getString(j));
            }
            dts.addRow(data_rows);
        }
        jTable1.setModel(dts);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sai Swapna\\Downloads\\imageedit_3_4363427810.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1014, 221);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 51, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item No", "Size", "Crust", "Sauce", "Toppings", "Cheese"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 228, 599, 402);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Order Your Pizza");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(710, 530, 211, 37);

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete Selected Items");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(670, 410, 280, 37);

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Add More Items");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(710, 300, 203, 37);

        setSize(new java.awt.Dimension(1037, 718));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            int selectedId = jTable1.getSelectedRow();
            //String idToString = Integer.toString(selectedId);
            if(selectedId < 0 ){
                JOptionPane.showMessageDialog(null, "Please select an item to delete");
            }else{
            String value = (jTable1.getModel().getValueAt(selectedId, 0).toString());
            String query = "delete from tbl_pizza where Id=?";
            PreparedStatement pst = dbc.conn.prepareStatement(query);
            pst.setString(1, value);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Item is deleted from the List");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        updateTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        BuildPizza buildPizza;
        try {
            buildPizza = new BuildPizza();
            buildPizza.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
//        int i = jTable1.getSelectedRow();
//        TableModel model = jTable1.getModel();
//        String toppings = model.getValueAt(i, 4).toString();
//        switch(toppings){
//            case "Chicken ":
//               jCheckBox1.setSelected(true);
//               jCheckBox2.setSelected(false);
//               jCheckBox3.setSelected(false);
//               jCheckBox4.setSelected(false);
//               jCheckBox5.setSelected(false);
//               jCheckBox6.setSelected(false);
//               jCheckBox7.setSelected(false);
//               jCheckBox8.setSelected(false);
//               break;
//               case "Peporoni ":
//               jCheckBox1.setSelected(false);
//               jCheckBox2.setSelected(true);
//               jCheckBox3.setSelected(false);
//               jCheckBox4.setSelected(false);
//               jCheckBox5.setSelected(false);
//               jCheckBox6.setSelected(false);
//               jCheckBox7.setSelected(false);
//               jCheckBox8.setSelected(false);
//               break;
//               case "Bacon ":
//               jCheckBox1.setSelected(false);
//               jCheckBox2.setSelected(false);
//               jCheckBox3.setSelected(true);
//               jCheckBox4.setSelected(false);
//               jCheckBox5.setSelected(false);
//               jCheckBox6.setSelected(false);
//               jCheckBox7.setSelected(false);
//               jCheckBox8.setSelected(false);
//               break;
//               case "Italian Sauage ":
//               jCheckBox1.setSelected(false);
//               jCheckBox2.setSelected(false);
//               jCheckBox3.setSelected(false);
//               jCheckBox4.setSelected(true);
//               jCheckBox5.setSelected(false);
//               jCheckBox6.setSelected(false);
//               jCheckBox7.setSelected(false);
//               jCheckBox8.setSelected(false);
//               break;
//               case "Onions ":
//               jCheckBox1.setSelected(false);
//               jCheckBox2.setSelected(false);
//               jCheckBox3.setSelected(false);
//               jCheckBox4.setSelected(false);
//               jCheckBox5.setSelected(true);
//               jCheckBox6.setSelected(false);
//               jCheckBox7.setSelected(false);
//               jCheckBox8.setSelected(false);
//               break;
//               case "Tomatoes ":
//               jCheckBox1.setSelected(false);
//               jCheckBox2.setSelected(false);
//               jCheckBox3.setSelected(false);
//               jCheckBox4.setSelected(false);
//               jCheckBox5.setSelected(false);
//               jCheckBox6.setSelected(true);
//               jCheckBox7.setSelected(false);
//               jCheckBox8.setSelected(false);
//               break;
//               case "Peppers ":
//               jCheckBox1.setSelected(false);
//               jCheckBox2.setSelected(false);
//               jCheckBox3.setSelected(false);
//               jCheckBox4.setSelected(false);
//               jCheckBox5.setSelected(false);
//               jCheckBox6.setSelected(false);
//               jCheckBox7.setSelected(true);
//               jCheckBox8.setSelected(false);
//               break;
//               case "Mushrooms ":
//               jCheckBox1.setSelected(true);
//               jCheckBox2.setSelected(false);
//               jCheckBox3.setSelected(false);
//               jCheckBox4.setSelected(false);
//               jCheckBox5.setSelected(false);
//               jCheckBox6.setSelected(false);
//               jCheckBox7.setSelected(false);
//               jCheckBox8.setSelected(true);
//               break;
////               default:
////               jCheckBox1.setSelected(true);
////               jCheckBox2.setSelected(true);
////               jCheckBox3.setSelected(true);
////               jCheckBox4.setSelected(true);
////               jCheckBox5.setSelected(true);
////               jCheckBox6.setSelected(true);
////               jCheckBox7.setSelected(true);
////               jCheckBox8.setSelected(true);
////               break;
//               
//               
//               
//    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CheckOut().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void updateTable(){
        try{
            String sql = "select * from tbl_pizza";
            PreparedStatement pst = dbc.conn.prepareStatement(sql);
            dbc.rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(dbc.rs));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}