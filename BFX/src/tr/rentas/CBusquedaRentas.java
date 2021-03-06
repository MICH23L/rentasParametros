/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.rentas;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import vista.mensajes.Mensajes;

/**
 *
 * @author DELL
 */
public class CBusquedaRentas extends javax.swing.JFrame {

    /**
     * Creates new form CBusquedaRentas
     */
    public CBusquedaRentas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        RentaActual = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tabla);

        jLabel2.setText("Renta Actual:");

        RentaActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RentaActualKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RentaActualKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(RentaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(RentaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RentaActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RentaActualKeyTyped
        // TODO add your handling code here:
       Validaciones.flotante(evt);
    }//GEN-LAST:event_RentaActualKeyTyped

    private void RentaActualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RentaActualKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n')
        {
            ManipulaInterfaces.limpia(Tabla);
            //agregamos los titulos de las tablas
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("id");
            modelo.addColumn("Fecha Actual");
            modelo.addColumn("Renta Actual");
            modelo.addColumn("Fecha Anterior");
            modelo.addColumn("Renta Anterior");
            Tabla.setModel(modelo);//las agregamos a la tabla

            //variables a ocupar
            String datos[] = new String[5];

            ArrayList<Object> reg = new ArrayList();
            Conexion con = new Conexion();
            con.Conecta("localhost", "trajin", "root", "123456");
            if (con.con != null)
            {
                //String s = "idregiones";
                //Querys q = new Querys();
                //reg = q.Seleccion(con.con, s, "regiones", "nombre = '" + NombreRegion.getSelectedItem().toString() + "'");
                try
                {
                    //NombreCuadro.setModel(new DefaultComboBoxModel(reg.toArray()));
                    String sql = "SELECT * FROM rentasparametros WHERE rentaactual = " + RentaActual.getText();
                    System.out.println(sql);
                    Statement st = con.con.createStatement();
                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next())
                    {
                        datos[0] = rs.getString(1);
                        datos[1] = rs.getString(5);
                        datos[2] = rs.getString(4);
                        datos[3] = rs.getString(3);
                        datos[4] = rs.getString(2);
                        modelo.addRow(datos);
                    }

                    Tabla.setModel(modelo);
                    con.con.close();
                    // Mensajes.exito(this);
                } catch (Exception ex)
                {
                    Mensajes.msj(this, "Error en DB... " + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_RentaActualKeyPressed

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
            java.util.logging.Logger.getLogger(CBusquedaRentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CBusquedaRentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CBusquedaRentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CBusquedaRentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CBusquedaRentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField RentaActual;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
