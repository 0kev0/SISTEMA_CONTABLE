
package CambioCuenta;

import static Funciones.Funciones.EnterMouse;


public class Modificar_Cuenta extends javax.swing.JFrame {

    public Modificar_Cuenta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_bg = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Btn_Regresar1 = new javax.swing.JPanel();
        Lb_Ordenar1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        Lb_Logo1 = new javax.swing.JLabel();
        TB_DescripcionActividad1 = new javax.swing.JTextField();
        TB_DescripcionActividad2 = new javax.swing.JTextField();
        TB_DescripcionActividad3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel_bg.setBackground(new java.awt.Color(247, 246, 187));
        Panel_bg.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 5, new java.awt.Color(0, 126, 112)));
        Panel_bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(17, 66, 50));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(0, 126, 112)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Regresar1.setBackground(new java.awt.Color(152, 5, 5));
        Btn_Regresar1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 10, 0, new java.awt.Color(247, 17, 17)));
        Btn_Regresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_Regresar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_Regresar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_Regresar1MouseExited(evt);
            }
        });
        Btn_Regresar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lb_Ordenar1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Lb_Ordenar1.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Ordenar1.setText("Regresar");
        Lb_Ordenar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar1.add(Lb_Ordenar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 130, 40));

        jPanel3.add(Btn_Regresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        Panel_bg.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 670, 80));

        jPanel4.setBackground(new java.awt.Color(17, 66, 50));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(0, 126, 112)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lb_Aerolinea2.setBackground(new java.awt.Color(251, 238, 122));
        Lb_Aerolinea2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(203, 202, 104));
        Lb_Aerolinea2.setText("Modiicar cuenta ");
        jPanel4.add(Lb_Aerolinea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 200, 70));

        Lb_Logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO blsnco 80x80_1.jpg"))); // NOI18N
        jPanel4.add(Lb_Logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        Panel_bg.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 80));

        TB_DescripcionActividad1.setBackground(new java.awt.Color(224, 213, 170));
        TB_DescripcionActividad1.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_DescripcionActividad1.setForeground(new java.awt.Color(0, 0, 0));
        TB_DescripcionActividad1.setText("Ingrese contraseña actual");
        TB_DescripcionActividad1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Contraseña actual : ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Panel_bg.add(TB_DescripcionActividad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 208, 50));

        TB_DescripcionActividad2.setBackground(new java.awt.Color(224, 213, 170));
        TB_DescripcionActividad2.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_DescripcionActividad2.setForeground(new java.awt.Color(0, 0, 0));
        TB_DescripcionActividad2.setText("Ingrese contraseña nueva");
        TB_DescripcionActividad2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Contraseña nueva : ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        TB_DescripcionActividad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TB_DescripcionActividad2ActionPerformed(evt);
            }
        });
        Panel_bg.add(TB_DescripcionActividad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 208, 50));

        TB_DescripcionActividad3.setBackground(new java.awt.Color(224, 213, 170));
        TB_DescripcionActividad3.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_DescripcionActividad3.setForeground(new java.awt.Color(0, 0, 0));
        TB_DescripcionActividad3.setText("Ingrese contraseña nueva");
        TB_DescripcionActividad3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Repita la contraseña nueva : ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        TB_DescripcionActividad3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TB_DescripcionActividad3ActionPerformed(evt);
            }
        });
        Panel_bg.add(TB_DescripcionActividad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 208, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_bg, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_Regresar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Regresar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Regresar1MouseClicked

    private void Btn_Regresar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Regresar1MouseEntered
        EnterMouse(Btn_Regresar1, Lb_Ordenar1, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_Regresar1MouseEntered

    private void Btn_Regresar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Regresar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Regresar1MouseExited

    private void TB_DescripcionActividad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TB_DescripcionActividad2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TB_DescripcionActividad2ActionPerformed

    private void TB_DescripcionActividad3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TB_DescripcionActividad3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TB_DescripcionActividad3ActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar_Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_Cuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_Regresar1;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Logo1;
    private javax.swing.JLabel Lb_Ordenar1;
    private javax.swing.JPanel Panel_bg;
    private javax.swing.JTextField TB_DescripcionActividad1;
    private javax.swing.JTextField TB_DescripcionActividad2;
    private javax.swing.JTextField TB_DescripcionActividad3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
