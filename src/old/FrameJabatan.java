package old;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Varel Yonathan Simangunsong
 * @nim 205150207111029
 */
public class FrameJabatan extends javax.swing.JFrame {
    Connection connection;
    String connectionUrl = 
                "jdbc:sqlserver://localhost;" +
                "database=Project; user=sa; password=12345;" +
                "loginTimeout=30;";
    
    /**
     * Creates new form FrameManageCustomer
     */
    public FrameJabatan() {
        initComponents();
        ConnectToSqlServer();
        populateTableAccount();
        ListSelectionModel model = tableAccount.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!model.isSelectionEmpty()) {
                    int index = model.getMinSelectionIndex();
                    String jabatan = tableAccount.getModel().getValueAt(index, 0).toString();
                    populateGajiAccount(jabatan);
                }
            }
        });
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Closing");
                try {
                    connection.close();
                } catch (SQLException ex) {
                }
            }
        });
    }
    
    private void ConnectToSqlServer() {
        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void populateTableAccount() {
        try {
            String query_sql = "select * from jabatan";
            ResultSet rs = runQuery(query_sql);
            DefaultTableModel tableModel = (DefaultTableModel)tableAccount.getModel();
            tableModel.setRowCount(0);

            while (rs.next()) {
                tableModel.addRow(new Object[]{rs.getString("nama_jabatan"), rs.getInt("gaji")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
    private void populateGajiAccount(String jabatan) {
        String qr = String.format("select * from jabatan where nama_jabatan = '%s'", jabatan);
        ResultSet rs = runQuery(qr);
        
        try {
            rs.next();
            textJabatan.setText(rs.getString("nama_jabatan"));
            textGaji.setText(rs.getString("gaji"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private boolean dataLengkap() {
        if (textNewJabatan.getText().equals("") ||
            textNewGaji.getText().equals(""))
        {
            return false;
        }
        return true;
    }
    
    private ResultSet runQuery(String query_sql) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query_sql);
            return rs;
        } catch (SQLException e) {
            System.out.println("Ada error di run Query");
        }
        return null;
    }
    
    private int runUpdateQuery(String query_sql) {
        try {
            Statement statement = connection.createStatement();
            int updateCount = statement.executeUpdate(query_sql);
            return updateCount;
        } catch (SQLException e) {
            System.out.println("Ada error di run Query");
        }
        return 0;
    }
    
    private void resetForm() {
        textNewJabatan.setText("");
        textNewGaji.setText("");
    }
//    private boolean cekJabatan(){
//        if(text)
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAccount = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        buttonSaveProfile = new javax.swing.JButton();
        buttonDeletAccount = new javax.swing.JButton();
        buttonNewAccount = new javax.swing.JButton();
        textSearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textJabatan = new javax.swing.JTextField();
        textGaji = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textNewJabatan = new javax.swing.JTextField();
        textNewGaji = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Daftar Jabatan");

        jLabel2.setText("Daftar Jabatan");

        tableAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Jabatan", "Gaji"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableAccountKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tableAccount);

        jLabel3.setText("Jabatan");

        buttonSaveProfile.setText("Save Changes");
        buttonSaveProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveProfileActionPerformed(evt);
            }
        });

        buttonDeletAccount.setText("Delete");
        buttonDeletAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletAccountActionPerformed(evt);
            }
        });

        buttonNewAccount.setText("Add");
        buttonNewAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewAccountActionPerformed(evt);
            }
        });

        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchKeyReleased(evt);
            }
        });

        jLabel10.setText("Jabatan");

        textJabatan.setEditable(false);

        jLabel11.setText("Gaji");

        exitButton.setText("Exit");
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Jabatan Baru");

        jLabel5.setText("Jabatan");

        jLabel6.setText("Gaji");

        textNewJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNewJabatanActionPerformed(evt);
            }
        });

        jLabel7.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(55, 55, 55)
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(exitButton))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textNewGaji, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                .addComponent(textNewJabatan)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(buttonDeletAccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonNewAccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(buttonSaveProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel4))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(textJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(textGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(buttonSaveProfile)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textNewJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textNewGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(buttonNewAccount)
                        .addGap(18, 18, 18)
                        .addComponent(buttonDeletAccount)
                        .addGap(82, 82, 82)
                        .addComponent(exitButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveProfileActionPerformed
        String nama_jabatan = textJabatan.getText();
        String gaji = textGaji.getText();

        String sql = String.format(
            "update jabatan " +  
            "set " +
            "gaji = %s " +
            "where nama_jabatan = '%s' ",
            gaji , nama_jabatan);
        
        System.out.println(sql);
        int numMod = runUpdateQuery(sql);
        populateTableAccount();
        System.out.printf("%s row updated\n", numMod);
    }//GEN-LAST:event_buttonSaveProfileActionPerformed

    private void buttonDeletAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletAccountActionPerformed
        String nama_jabatan = textJabatan.getText();
        String gaji = textGaji.getText();

        String sql = String.format(
            "delete from jabatan " + 
            "where nama_jabatan = '%s' ",
            nama_jabatan);
        try{
            Statement statement = connection.createStatement();
            System.out.println(sql);
            int numMod = statement.executeUpdate(sql);
            populateTableAccount();
            System.out.printf("%s row deleted\n", numMod);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Jabatan sedang digunakan di relasi lain atau terjadi kesalahan SQL");
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonDeletAccountActionPerformed

    private void buttonNewAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewAccountActionPerformed
        if(!dataLengkap()){
            JOptionPane.showMessageDialog(null, "Silahkan Lengkapi Datanya !");
        }else{
            String nama_jabatan = textNewJabatan.getText();
            String gaji = textNewGaji.getText();

            String sql = String.format(
                "insert into jabatan (nama_jabatan, gaji) " +  
                "values ('%s', %s);",
                nama_jabatan, gaji);
            System.out.println(sql);
            try{
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                System.out.println("Berhasil mendaftar jabatan");
                populateTableAccount();
                resetForm();
                JOptionPane.showMessageDialog(null, "Berhasil mendaftar jabatan");
            }catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Ada error ! Silahkan cek datanya");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_buttonNewAccountActionPerformed

    private void tableAccountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableAccountKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tableAccountKeyPressed

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        try {connection.close();
            } catch (SQLException ex) {
        }
        this.dispose();
    }//GEN-LAST:event_exitButtonMouseClicked

    private void textNewJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNewJabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNewJabatanActionPerformed

    private void textSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyReleased
        DefaultTableModel tableModel = (DefaultTableModel)tableAccount.getModel();
        String search = textSearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
        tableAccount.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_textSearchKeyReleased

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitButtonActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameJabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameJabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameJabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameJabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameJabatan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDeletAccount;
    private javax.swing.JButton buttonNewAccount;
    private javax.swing.JButton buttonSaveProfile;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableAccount;
    private javax.swing.JTextField textGaji;
    private javax.swing.JTextField textJabatan;
    private javax.swing.JTextField textNewGaji;
    private javax.swing.JTextField textNewJabatan;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}