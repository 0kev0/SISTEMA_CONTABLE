package Log_Iin.Usuario;

import Funciones.Funciones;
import static Funciones.Funciones.EnterMouse;
import static Funciones.Funciones.LeftMouse;
import static Funciones.Funciones.VaciarCampos;
import static Funciones.Funciones.validarCampos;
import Log_Iin.Usuario.Modelo_Usuario;
import Vista_Panel_Auxiliar.Panel_Auxiliar;
import Vista_Panel_Contador.Panel_Contador;
import Vista_Panel_Gerente.Panel_Gerente;
import javax.swing.JOptionPane;

public class log_in1 extends javax.swing.JFrame {

    public log_in1() {
        initComponents();
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        loading = new javax.swing.JLabel();
        barra = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jp_Main = new javax.swing.JPanel();
        TxbCorreo = new javax.swing.JTextField();
        TxbContraseña = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        Btn_EXIT3 = new javax.swing.JPanel();
        Lb_X3 = new javax.swing.JLabel();
        Lb_Bienvenida = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Btn_Reservar = new javax.swing.JPanel();
        LB_Log = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        Lb_Aerolinea11 = new javax.swing.JLabel();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel4.setBackground(new java.awt.Color(23, 42, 56));

        loading.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        loading.setText("LOADING...");

        barra.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        barra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(loading, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addComponent(loading)
                .addGap(18, 18, 18)
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jFrame1.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(242, 244, 209));

        jp_Main.setBackground(new java.awt.Color(178, 211, 190));

        TxbCorreo.setBackground(new java.awt.Color(5, 89, 91));
        TxbCorreo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        TxbCorreo.setForeground(new java.awt.Color(255, 255, 255));
        TxbCorreo.setText("a");
        TxbCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Sylfaen", 1, 18), new java.awt.Color(242, 244, 209))); // NOI18N
        TxbCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxbCorreoMouseClicked(evt);
            }
        });
        TxbCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxbCorreoActionPerformed(evt);
            }
        });

        TxbContraseña.setBackground(new java.awt.Color(5, 89, 91));
        TxbContraseña.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        TxbContraseña.setForeground(new java.awt.Color(255, 255, 255));
        TxbContraseña.setText("a");
        TxbContraseña.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseña ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Sylfaen", 1, 18), new java.awt.Color(242, 244, 209))); // NOI18N
        TxbContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxbContraseñaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jp_MainLayout = new javax.swing.GroupLayout(jp_Main);
        jp_Main.setLayout(jp_MainLayout);
        jp_MainLayout.setHorizontalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_MainLayout.createSequentialGroup()
                .addContainerGap(226, Short.MAX_VALUE)
                .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxbCorreo)
                    .addComponent(TxbContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(212, 212, 212))
        );
        jp_MainLayout.setVerticalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MainLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(TxbCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxbContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(94, 96, 115));

        Btn_EXIT3.setBackground(new java.awt.Color(255, 0, 0));
        Btn_EXIT3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_EXIT3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_EXIT3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_EXIT3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_EXIT3MouseExited(evt);
            }
        });

        Lb_X3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Lb_X3.setText("X");

        javax.swing.GroupLayout Btn_EXIT3Layout = new javax.swing.GroupLayout(Btn_EXIT3);
        Btn_EXIT3.setLayout(Btn_EXIT3Layout);
        Btn_EXIT3Layout.setHorizontalGroup(
            Btn_EXIT3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_EXIT3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(Lb_X3)
                .addContainerGap())
        );
        Btn_EXIT3Layout.setVerticalGroup(
            Btn_EXIT3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_EXIT3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_X3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Lb_Bienvenida.setFont(new java.awt.Font("Sylfaen", 1, 48)); // NOI18N
        Lb_Bienvenida.setForeground(new java.awt.Color(242, 244, 209));
        Lb_Bienvenida.setText("SISTEMA CONTABLE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(Lb_Bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_EXIT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(Btn_EXIT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Bienvenida)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(94, 96, 115));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        Btn_Reservar.setBackground(new java.awt.Color(17, 153, 158));
        Btn_Reservar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Reservar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_ReservarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_ReservarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_ReservarMouseExited(evt);
            }
        });

        LB_Log.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        LB_Log.setForeground(new java.awt.Color(255, 255, 255));
        LB_Log.setText("Iniciar secion");

        jPanel12.setBackground(new java.awt.Color(163, 222, 201));

        Lb_Aerolinea11.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea11.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Lb_Aerolinea11.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea11))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(Lb_Aerolinea11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Btn_ReservarLayout = new javax.swing.GroupLayout(Btn_Reservar);
        Btn_Reservar.setLayout(Btn_ReservarLayout);
        Btn_ReservarLayout.setHorizontalGroup(
            Btn_ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_ReservarLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(LB_Log)
                .addGap(14, 14, 14))
        );
        Btn_ReservarLayout.setVerticalGroup(
            Btn_ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_ReservarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LB_Log, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jp_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Btn_Reservar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(373, 373, 373))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jp_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btn_Reservar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barraActionPerformed

    private void TxbCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxbCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxbCorreoActionPerformed

    private void Btn_ReservarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ReservarMouseClicked
        String User = TxbCorreo.getText();
        String PASS = TxbContraseña.getText();
        String loginfo = "";
        String Log = "";

        if (validarCampos(jp_Main)) {

            Modelo_Usuario USER = new Modelo_Usuario();
            USER = USER.Validar_Usuario(User, PASS);

            if (USER.getNombres() != null) {

                Funciones.showMessageDialog("BIENVENIDO", "Bienvenido\n " + USER.getApellidos() + " " + USER.getNombres());

                int rol = USER.getId_Rol();

                switch (rol) {
                    case 1 -> {
                        int id = USER.getId();

                        //ADMIN
                        loginfo += " LOG in de nombre: " + USER.getNombres() + ", apellido: " + USER.getApellidos() + " Rol: " + USER.getRol();
                        Log = Funciones.Registro_Log(loginfo);
                        Funciones.escribirEnArchivo(Log);

                        Panel_Contador Contador = new Panel_Contador(USER);
                        Contador.setVisible(true);
                        dispose();
                    }
                    case 2 -> {
                        //CONTADOR
                        loginfo += " LOG in de nombre: " + USER.getNombres() + ", apellido: " + USER.getApellidos() + " Rol: " + USER.getRol();
                        Log = Funciones.Registro_Log(loginfo);
                        Funciones.escribirEnArchivo(Log);

                        Panel_Contador Contador = new Panel_Contador(USER);
                        Contador.setVisible(true);
                        dispose();
                    }
                    case 3 -> {
                        //Auxiliar
                        loginfo += " LOG in de nombre: " + USER.getNombres() + ", apellido: " + USER.getApellidos() + " Rol: " + USER.getRol();
                        Log = Funciones.Registro_Log(loginfo);
                        Funciones.escribirEnArchivo(Log);

                        Panel_Auxiliar Auxiliar  = new Panel_Auxiliar(USER);
                        Auxiliar.setVisible(true);
                        dispose();
                    }

                    case 4 -> {
                        //Gerente
                        loginfo += " LOG in de nombre: " + USER.getNombres() + ", apellido: " + USER.getApellidos() + " Rol: " + USER.getRol();
                        Log = Funciones.Registro_Log(loginfo);
                        Funciones.escribirEnArchivo(Log);

                        Panel_Gerente Gerente = new Panel_Gerente(USER);
                        Gerente.setVisible(true);
                        dispose();
                    }

                    default ->
                        throw new AssertionError();
                }

            } else {
                //Gerente
                loginfo += " Intento fallido de LOG in por : " + TxbCorreo.getText();
                 Log = Funciones.Registro_Log(loginfo);
                Funciones.escribirEnArchivo(Log);
                JOptionPane.showMessageDialog(rootPane, "CREDENCIALES INCORRECTAS\n INTENTE NUEVAMENTE ");
                VaciarCampos(jp_Main);
            }

        }


    }//GEN-LAST:event_Btn_ReservarMouseClicked

    private void Btn_ReservarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ReservarMouseEntered
        EnterMouse(Btn_Reservar, LB_Log, "#2072E3", "#000000");
    }//GEN-LAST:event_Btn_ReservarMouseEntered

    private void Btn_ReservarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ReservarMouseExited
        LeftMouse(Btn_Reservar, LB_Log, "#088BE2", "#FFFFFF");
    }//GEN-LAST:event_Btn_ReservarMouseExited

    private void TxbCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxbCorreoMouseClicked
        TxbCorreo.setText("");
    }//GEN-LAST:event_TxbCorreoMouseClicked

    private void TxbContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxbContraseñaMouseClicked
        TxbContraseña.setText("");
    }//GEN-LAST:event_TxbContraseñaMouseClicked

    private void Btn_EXIT3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_EXIT3MouseClicked
        dispose();
        System.out.println("Fin del programa");
        System.exit(0);
    }//GEN-LAST:event_Btn_EXIT3MouseClicked

    private void Btn_EXIT3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_EXIT3MouseEntered
//        EnterMouse(Btn_EXIT, Lb_X, "#860A35", "#000000");
    }//GEN-LAST:event_Btn_EXIT3MouseEntered

    private void Btn_EXIT3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_EXIT3MouseExited
//        LeftMouse(Btn_EXIT, Lb_X, "#F96D00", "#FFFFFF");
    }//GEN-LAST:event_Btn_EXIT3MouseExited

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new log_in1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_EXIT3;
    private javax.swing.JPanel Btn_Reservar;
    private javax.swing.JLabel LB_Log;
    private javax.swing.JLabel Lb_Aerolinea11;
    private javax.swing.JLabel Lb_Bienvenida;
    private javax.swing.JLabel Lb_X3;
    private javax.swing.JTextField TxbContraseña;
    private javax.swing.JTextField TxbCorreo;
    private javax.swing.JTextField barra;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jp_Main;
    private javax.swing.JLabel loading;
    // End of variables declaration//GEN-END:variables
}
