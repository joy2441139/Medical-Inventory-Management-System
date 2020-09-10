package mms;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class CustomerMenuView extends javax.swing.JFrame {

    int id;

    public CustomerMenuView(int id) {
        initComponents();
        show_medTable(0);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.id = id;
        System.out.println("Current ID:" + id);
    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }

    public void show_medTable(int s) {

        DatabaseHandler db = new DatabaseHandler();
        db.connectDatabase();
        ArrayList<Medicine> list = db.customerMedList(s);
        DefaultTableModel model = (DefaultTableModel) medTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getPrice();
            row[3] = list.get(i).getQt();
            model.addRow(row);

        }
        for (int i = 0; i < medTable.getRowCount(); i++) {
            medTable.setValueAt(false, i, 4);
            medTable.setValueAt(0, i, 5);
            medTable.setValueAt(list.get(i).getPrice(), i, 2);
            medTable.setValueAt(list.get(i).getQt(), i, 3);
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

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        medTable = new javax.swing.JTable();
        priceAscRadBtn = new javax.swing.JRadioButton();
        NameAscRadBtn = new javax.swing.JRadioButton();
        NameDesRadBtn = new javax.swing.JRadioButton();
        priceDescRadBtn = new javax.swing.JRadioButton();
        viewOrderBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        odrText = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalAmt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cnfmOrderBtn = new javax.swing.JButton();
        resetCartBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(96, 6, 19));
        jLabel6.setText("Customer Menu");

        medTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price per Unit", "Available quantity", "Select", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(medTable);
        if (medTable.getColumnModel().getColumnCount() > 0) {
            medTable.getColumnModel().getColumn(0).setResizable(false);
            medTable.getColumnModel().getColumn(1).setResizable(false);
            medTable.getColumnModel().getColumn(2).setResizable(false);
            medTable.getColumnModel().getColumn(3).setResizable(false);
            medTable.getColumnModel().getColumn(4).setResizable(false);
            medTable.getColumnModel().getColumn(5).setResizable(false);
        }

        priceAscRadBtn.setText("Price Asc");
        priceAscRadBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                priceAscRadBtnItemStateChanged(evt);
            }
        });
        priceAscRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceAscRadBtnActionPerformed(evt);
            }
        });

        NameAscRadBtn.setText("Name Asc");
        NameAscRadBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NameAscRadBtnItemStateChanged(evt);
            }
        });

        NameDesRadBtn.setText("Name Desc");
        NameDesRadBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NameDesRadBtnItemStateChanged(evt);
            }
        });
        NameDesRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameDesRadBtnActionPerformed(evt);
            }
        });

        priceDescRadBtn.setText("Price Desc");
        priceDescRadBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                priceDescRadBtnItemStateChanged(evt);
            }
        });
        priceDescRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceDescRadBtnActionPerformed(evt);
            }
        });

        viewOrderBtn.setText("CheckOut Cart");
        viewOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Sort By:");

        odrText.setColumns(20);
        odrText.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        odrText.setRows(5);
        jScrollPane2.setViewportView(odrText);

        jLabel2.setText("Name");

        jLabel3.setText("Order Quantity");

        jLabel4.setText("Price");

        jLabel5.setText("Total Amount:");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel7.setText("Current Cart");

        cnfmOrderBtn.setText("Confirm Order");
        cnfmOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnfmOrderBtnActionPerformed(evt);
            }
        });

        resetCartBtn.setText("Reset Cart");
        resetCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetCartBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 2, 24)); // NOI18N
        jLabel8.setText("Search");

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NameDesRadBtn)
                                .addGap(10, 10, 10)
                                .addComponent(NameAscRadBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(priceDescRadBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceAscRadBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(resetCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(viewOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cnfmOrderBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(totalAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)))))
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalAmt)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameDesRadBtn)
                            .addComponent(NameAscRadBtn)
                            .addComponent(priceDescRadBtn)
                            .addComponent(priceAscRadBtn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cnfmOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void priceDescRadBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_priceDescRadBtnItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            
            NameDesRadBtn.setSelected(false);
            NameAscRadBtn.setSelected(false);
            priceAscRadBtn.setSelected(false);
            show_medTable(3);
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            show_medTable(0);
        }
    }//GEN-LAST:event_priceDescRadBtnItemStateChanged

    String s = "";
    boolean canConfirm = false;
    private void viewOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderBtnActionPerformed
        float total = 0;
        odrText.setText("");
        totalAmt.setText("");
        String s1 = "";

        for (int i = 0; i < medTable.getRowCount(); i++) {
            Boolean select_checked = (boolean) medTable.getValueAt(i, 4);
            int amtval = (int) medTable.getValueAt(i, 5);
            float priceval = (float) medTable.getValueAt(i, 2);

            String col = medTable.getValueAt(i, 1).toString();
            String amt = medTable.getValueAt(i, 5).toString();

            //DISPLAY  
            if (isChecked(i, select_checked, amtval)) {
                //JOptionPane.showMessageDialog(null, col + ",Amount:" + amt);
                total = total + (priceval * amtval);
                s1 = col + "\t...     " + amt + "\t...          " + (priceval * amtval) + "\n";
                s = s.concat(s1);
                canConfirm = true;
            }


    }//GEN-LAST:event_viewOrderBtnActionPerformed

        odrText.setText(s);
        s = "";
        totalAmt.setText("Tk.         " + total);

    }

    void updateMedTable(String id, String qty) {

        DatabaseHandler db = new DatabaseHandler();
        db.connectDatabase();
        Connection connect = db.connect;
        try {
            String query = "UPDATE medicine SET avl_quantity = ?" + "WHERE med_id = ?";
            PreparedStatement pStatement = connect.prepareStatement(query);
            pStatement.setString(1, qty);
            pStatement.setString(2, id);

            pStatement.executeUpdate();

            System.out.println("Query Done");
        } catch (Exception e) {
            System.out.println("Query Failed");
            e.printStackTrace();
        }

    }


    private void cnfmOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnfmOrderBtnActionPerformed

        if (canConfirm == true) {

            float confirm_total = 0;
            Vector<Integer> medId = new Vector<>();
            Vector<Integer> qty = new Vector<>();
            for (int i = 0; i < medTable.getRowCount(); i++) {
                Boolean select_checked = (boolean) medTable.getValueAt(i, 4);
                int amtvalRem = (int) medTable.getValueAt(i, 3) - (int) medTable.getValueAt(i, 5);
                int amtval = (int) medTable.getValueAt(i, 5);

                float priceval = (float) medTable.getValueAt(i, 2);

                String id = medTable.getValueAt(i, 0).toString();
                String amt = Integer.toString(amtvalRem);

                if (isChecked(i, select_checked, amtval)) {

                    confirm_total = confirm_total + (priceval * amtval);

                    /*System.out.println("ID:" + id);
                System.out.println("QTY:" + amtvalRem);
                System.out.println("CONFIRM TOTAL:" + confirm_total);*/
                    updateMedTable(id, amt);

                    medId.add((int) medTable.getValueAt(i, 0));
                    qty.add(amtval);

                }

            }
            show_medTable(0);
            JOptionPane.showMessageDialog(null, "Order Placed");

            createNewOrder(confirm_total, medId, qty);
            canConfirm = false;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Order,checkout cart first.");
        }
    }//GEN-LAST:event_cnfmOrderBtnActionPerformed

    void createNewOrder(float total, Vector<Integer> medId, Vector<Integer> medqty) {

        DatabaseHandler db = new DatabaseHandler();
        db.connectDatabase();
        Connection connect = db.connect;
        ResultSet rs = null;

        int c_id = id;
        System.out.println("Current Customer ID:" + c_id);
        try {

            java.sql.Timestamp c_time = new java.sql.Timestamp(new java.util.Date().getTime());

            String query = "INSERT INTO order_info (c_id,order_time,order_val) values(?,?,?)";
            PreparedStatement pStatement = connect.prepareStatement(query);
            pStatement.setInt(1, c_id);
            pStatement.setTimestamp(2, c_time);
            pStatement.setFloat(3, total);

            pStatement.executeUpdate();

            System.out.println("Order create Query Done");

            String query2 = "SELECT order_no FROM `order_info` GROUP BY order_time DESC LIMIT 1";
            Statement statement;
            statement = connect.createStatement();
            rs = statement.executeQuery(query2);

            int currentOrder = 0;
            while (rs.next()) {
                //System.out.println("Current_orderNO:"+rs.getInt("order_no"));
                currentOrder = rs.getInt("order_no");
            }

            for (int i = 0; i < medId.size(); i++) {
                //System.out.println("medid"+medId.get(i));
                //System.out.println("medqty"+medqty.get(i));
                String query3 = "INSERT INTO order_medicine (med_id,order_no,quantity) values(?,?,?)";
                PreparedStatement p2Statement = connect.prepareStatement(query3);
                p2Statement.setInt(1, medId.get(i));
                p2Statement.setInt(2, currentOrder);
                p2Statement.setInt(3, medqty.get(i));
                p2Statement.executeUpdate();
            }
            System.out.println("Order_Medicine Create Query Done");

        } catch (Exception e) {
            System.out.println("Query Failed");
            e.printStackTrace();
        }

    }


    private void resetCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetCartBtnActionPerformed
        float total = 0;
        String s = "";
        odrText.setText(s);
        totalAmt.setText("Tk.         " + total);
        for (int i = 0; i < medTable.getRowCount(); i++) {
            medTable.setValueAt(false, i, 4);
            medTable.setValueAt(0, i, 5);
        }
    }//GEN-LAST:event_resetCartBtnActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        search(searchField.getText().toString());
    }//GEN-LAST:event_searchFieldKeyReleased

    private void NameDesRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameDesRadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameDesRadBtnActionPerformed

    private void priceAscRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceAscRadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceAscRadBtnActionPerformed

    private void priceDescRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceDescRadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceDescRadBtnActionPerformed

    private void NameAscRadBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NameAscRadBtnItemStateChanged
         if (evt.getStateChange() == ItemEvent.SELECTED) {
            
            NameDesRadBtn.setSelected(false);
            priceDescRadBtn.setSelected(false);
            priceAscRadBtn.setSelected(false);
            show_medTable(2);
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            show_medTable(0);
        }
    }//GEN-LAST:event_NameAscRadBtnItemStateChanged

    private void NameDesRadBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NameDesRadBtnItemStateChanged
         if (evt.getStateChange() == ItemEvent.SELECTED) {
            
            
            NameAscRadBtn.setSelected(false);
            priceAscRadBtn.setSelected(false);
            priceDescRadBtn.setSelected(false);
            show_medTable(1);
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            show_medTable(0);
        }
    }//GEN-LAST:event_NameDesRadBtnItemStateChanged

    private void priceAscRadBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_priceAscRadBtnItemStateChanged
         if (evt.getStateChange() == ItemEvent.SELECTED) {
            
            NameDesRadBtn.setSelected(false);
            NameAscRadBtn.setSelected(false);
            priceDescRadBtn.setSelected(false);
            show_medTable(4);
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            show_medTable(0);
        }
    }//GEN-LAST:event_priceAscRadBtnItemStateChanged

    public void search(String searchString) {
        DefaultTableModel model = (DefaultTableModel) medTable.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<DefaultTableModel>(model);
        medTable.setRowSorter(rowSorter);

        rowSorter.setRowFilter(RowFilter.regexFilter(searchString));

    }

    private boolean isChecked(int index, boolean s_check, int amt) {

        if (s_check == true && amt > 0 && amt <= (int) medTable.getValueAt(index, 3)) {
            return true;
        } else if (s_check == true && amt > (int) medTable.getValueAt(index, 3)) {
            JOptionPane.showMessageDialog(null, "Info invalid for " + medTable.getValueAt(index, 1).toString());
        }
        return false;

    }

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
            java.util.logging.Logger.getLogger(CustomerMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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

                int c = 0;
                new CustomerMenuView(c).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton NameAscRadBtn;
    private javax.swing.JRadioButton NameDesRadBtn;
    private javax.swing.JButton cnfmOrderBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable medTable;
    private javax.swing.JTextArea odrText;
    private javax.swing.JRadioButton priceAscRadBtn;
    private javax.swing.JRadioButton priceDescRadBtn;
    private javax.swing.JButton resetCartBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField totalAmt;
    private javax.swing.JButton viewOrderBtn;
    // End of variables declaration//GEN-END:variables
}