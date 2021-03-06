/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HighScoresDialog.java
 *
 * Created on Nov 21, 2011, 3:45:10 AM
 */
package javasnakes.gui;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oladeji
 */
public class HighScoresDialog extends javax.swing.JDialog {

    private static final File scoreDir;
    static {
        scoreDir = new File(System.getProperty("user.home", ".") + "/.snakes316");
        scoreDir.mkdir();
    }
    private static final File highScoresFile;
    static {
        highScoresFile = new File(scoreDir, "highscores.db");
        try {
            highScoresFile.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(HighScoresDialog.class.getName()).log(Level.SEVERE, "Unable to create the highscores file.", ex);
        }
    }
    
    /** Creates new form HighScoresDialog
     * @param parent the hosting frame
     * @param modal the modality type
     */
    public HighScoresDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        readData();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();

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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(mainTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                HighScoresDialog dialog = new HighScoresDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void readData() {
        Properties p = new Properties();
        //BufferedInputStream bis = new BufferedInputStream(getClass().getResourceAsStream(highScoresFile.getAbsolutePath()));
        try {
            p.load(getClass().getResourceAsStream(highScoresFile.getName()));
        } catch (IOException ex) {
            Logger.getLogger(HighScoresDialog.class.getName()).log(Level.SEVERE, 
                    "Unable to read the highscores database.", ex);
        }
        mainTable.setModel(new HighScoresTableModel(p));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable mainTable;
    // End of variables declaration//GEN-END:variables
}
