package Vista_Panel_Contador;

import static Funciones.Funciones.EnterMouse;
import static Funciones.Funciones.LeftMouse;
import java.awt.Color;
import static Funciones.Funciones.CentrarFrames;
import Log_Iin.Usuario.Modelo_Usuario;
import Log_Iin.Usuario.Modelo_Usuario;
import Log_Iin.Usuario.log_in1;
import Modelos.Contador.Modelo_Catalogo;
import Modelos.Contador.Modelo_TipoCuenta;
import Modelos.Contador.Modelo_TipoDocumento;
import Vista_Panel_Admin.Opciones.Gestion_CatalogoTest;
import Vista_Panel_Admin.Opciones.Vista_CatalogoTest;

public class Panel_Contador extends javax.swing.JFrame {

    public Panel_Contador() {
        getContentPane().setBackground(new Color(250, 250, 250));
        initComponents();
    }

    private Modelo_Usuario Modelo_Usuario;

    public Panel_Contador(Modelo_Usuario User) {
        getContentPane().setBackground(new Color(250, 250, 250));
        initComponents();
        this.Modelo_Usuario = User;

        // Lb_Nombre.setText("Bienvenido: " + Modelo_Usuario.getApellidos() + " " + Modelo_Usuario.getNombres() + " GUia grado: " + Modelo_Usuario.getId());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_bg = new javax.swing.JPanel();
        Desk = new javax.swing.JDesktopPane();
        jPanel5 = new javax.swing.JPanel();
        Btn_EXIT3 = new javax.swing.JPanel();
        Lb_X3 = new javax.swing.JLabel();
        Lb_Bienvenida = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Btn_LibroDiario2 = new Customizacion.Custom_Buttons();
        Lb_Inventario2 = new javax.swing.JLabel();
        Btn_LibroDiario1 = new Customizacion.Custom_Buttons();
        Lb_Inventario1 = new javax.swing.JLabel();
        Btn_LibroDiario3 = new Customizacion.Custom_Buttons();
        Lb_Inventario3 = new javax.swing.JLabel();
        Btn_LibroDiario = new Customizacion.Custom_Buttons();
        Lb_Inventario = new javax.swing.JLabel();
        Btn_Regresar1 = new javax.swing.JPanel();
        Lb_Ordenar1 = new javax.swing.JLabel();
        Btn_LibroDiario4 = new Customizacion.Custom_Buttons();
        Lb_Inventario4 = new javax.swing.JLabel();
        Btn_LibroDiario5 = new Customizacion.Custom_Buttons();
        Lb_Inventario5 = new javax.swing.JLabel();
        Btn_LibroDiario6 = new Customizacion.Custom_Buttons();
        Lb_Inventario6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Panel_bg.setBackground(new java.awt.Color(254, 244, 209));
        Panel_bg.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 10, new java.awt.Color(178, 211, 190)));
        Panel_bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Desk.setBackground(new java.awt.Color(178, 211, 190));

        javax.swing.GroupLayout DeskLayout = new javax.swing.GroupLayout(Desk);
        Desk.setLayout(DeskLayout);
        DeskLayout.setHorizontalGroup(
            DeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
        );
        DeskLayout.setVerticalGroup(
            DeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        Panel_bg.add(Desk, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 1180, 630));

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
                .addContainerGap(22, Short.MAX_VALUE)
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
        Lb_Bienvenida.setText("SISTEMA CONTABLE CONTADOR");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(354, Short.MAX_VALUE)
                .addComponent(Lb_Bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273)
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

        Panel_bg.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, -1));

        jPanel6.setBackground(new java.awt.Color(94, 96, 115));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1450, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        Panel_bg.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 730, 1450, -1));

        jPanel1.setBackground(new java.awt.Color(254, 244, 209));

        Btn_LibroDiario2.setBackground(new java.awt.Color(137, 163, 178));
        Btn_LibroDiario2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_LibroDiario2.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_LibroDiario2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario2MouseExited(evt);
            }
        });
        Btn_LibroDiario2.setLayout(new java.awt.GridBagLayout());

        Lb_Inventario2.setBackground(new java.awt.Color(7, 3, 26));
        Lb_Inventario2.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Inventario2.setForeground(new java.awt.Color(242, 244, 209));
        Lb_Inventario2.setText("Libro Diario");
        Btn_LibroDiario2.add(Lb_Inventario2, new java.awt.GridBagConstraints());

        Btn_LibroDiario1.setBackground(new java.awt.Color(137, 163, 178));
        Btn_LibroDiario1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_LibroDiario1.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_LibroDiario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario1MouseExited(evt);
            }
        });
        Btn_LibroDiario1.setLayout(new java.awt.GridBagLayout());

        Lb_Inventario1.setBackground(new java.awt.Color(7, 3, 26));
        Lb_Inventario1.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Inventario1.setForeground(new java.awt.Color(242, 244, 209));
        Lb_Inventario1.setText("Libro Mayor");
        Btn_LibroDiario1.add(Lb_Inventario1, new java.awt.GridBagConstraints());

        Btn_LibroDiario3.setBackground(new java.awt.Color(137, 163, 178));
        Btn_LibroDiario3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_LibroDiario3.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_LibroDiario3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario3MouseExited(evt);
            }
        });
        Btn_LibroDiario3.setLayout(new java.awt.GridBagLayout());

        Lb_Inventario3.setBackground(new java.awt.Color(7, 3, 26));
        Lb_Inventario3.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Inventario3.setForeground(new java.awt.Color(242, 244, 209));
        Lb_Inventario3.setText("Estados Financieros");
        Btn_LibroDiario3.add(Lb_Inventario3, new java.awt.GridBagConstraints());

        Btn_LibroDiario.setBackground(new java.awt.Color(137, 163, 178));
        Btn_LibroDiario.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_LibroDiario.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_LibroDiario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_LibroDiarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_LibroDiarioMouseExited(evt);
            }
        });
        Btn_LibroDiario.setLayout(new java.awt.GridBagLayout());

        Lb_Inventario.setBackground(new java.awt.Color(7, 3, 26));
        Lb_Inventario.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Inventario.setForeground(new java.awt.Color(242, 244, 209));
        Lb_Inventario.setText("Ver Registros");
        Btn_LibroDiario.add(Lb_Inventario, new java.awt.GridBagConstraints());

        Btn_Regresar1.setBackground(new java.awt.Color(152, 5, 5));
        Btn_Regresar1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 10, 0, new java.awt.Color(247, 17, 17)));
        Btn_Regresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar1.setMinimumSize(new java.awt.Dimension(160, 92));
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
        Btn_Regresar1.add(Lb_Ordenar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 130, 30));

        Btn_LibroDiario4.setBackground(new java.awt.Color(137, 163, 178));
        Btn_LibroDiario4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_LibroDiario4.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_LibroDiario4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario4MouseExited(evt);
            }
        });
        Btn_LibroDiario4.setLayout(new java.awt.GridBagLayout());

        Lb_Inventario4.setBackground(new java.awt.Color(7, 3, 26));
        Lb_Inventario4.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Inventario4.setForeground(new java.awt.Color(242, 244, 209));
        Lb_Inventario4.setText("Ver catalogo");
        Btn_LibroDiario4.add(Lb_Inventario4, new java.awt.GridBagConstraints());

        Btn_LibroDiario5.setBackground(new java.awt.Color(137, 163, 178));
        Btn_LibroDiario5.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_LibroDiario5.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_LibroDiario5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario5MouseExited(evt);
            }
        });
        Btn_LibroDiario5.setLayout(new java.awt.GridBagLayout());

        Lb_Inventario5.setBackground(new java.awt.Color(7, 3, 26));
        Lb_Inventario5.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Inventario5.setForeground(new java.awt.Color(242, 244, 209));
        Lb_Inventario5.setText("Ver tipo documentos");
        Btn_LibroDiario5.add(Lb_Inventario5, new java.awt.GridBagConstraints());

        Btn_LibroDiario6.setBackground(new java.awt.Color(137, 163, 178));
        Btn_LibroDiario6.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_LibroDiario6.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_LibroDiario6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_LibroDiario6MouseExited(evt);
            }
        });
        Btn_LibroDiario6.setLayout(new java.awt.GridBagLayout());

        Lb_Inventario6.setBackground(new java.awt.Color(7, 3, 26));
        Lb_Inventario6.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Inventario6.setForeground(new java.awt.Color(242, 244, 209));
        Lb_Inventario6.setText("Ver tipo cuentas");
        Btn_LibroDiario6.add(Lb_Inventario6, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_LibroDiario2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_LibroDiario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_LibroDiario3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_LibroDiario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Regresar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_LibroDiario4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Btn_LibroDiario5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_LibroDiario6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(Btn_LibroDiario6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_LibroDiario5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_LibroDiario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_LibroDiario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_LibroDiario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_LibroDiario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_LibroDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btn_Regresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        Panel_bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 250, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_Regresar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Regresar1MouseClicked
        log_in1 gest = new log_in1();
        dispose();
        gest.setVisible(true);
    }//GEN-LAST:event_Btn_Regresar1MouseClicked

    private void Btn_Regresar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Regresar1MouseEntered
        EnterMouse(Btn_Regresar1, Lb_Ordenar1, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_Regresar1MouseEntered

    private void Btn_Regresar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Regresar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Regresar1MouseExited

    private void Btn_LibroDiarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiarioMouseEntered
        EnterMouse(Btn_LibroDiario, Lb_Inventario, "#ABBEC8", "#FFFFFF");
    }//GEN-LAST:event_Btn_LibroDiarioMouseEntered

    private void Btn_LibroDiarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiarioMouseExited
        LeftMouse(Btn_LibroDiario, Lb_Inventario, "#89A3B2", "#F2F4D1");
    }//GEN-LAST:event_Btn_LibroDiarioMouseExited

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

    private void Btn_LibroDiario1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LibroDiario1MouseEntered

    private void Btn_LibroDiario1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LibroDiario1MouseExited

    private void Btn_LibroDiario2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LibroDiario2MouseEntered

    private void Btn_LibroDiario2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LibroDiario2MouseExited

    private void Btn_LibroDiario3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LibroDiario3MouseEntered

    private void Btn_LibroDiario3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LibroDiario3MouseExited

    private void Btn_LibroDiario4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LibroDiario4MouseEntered

    private void Btn_LibroDiario4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LibroDiario4MouseExited

    private void Btn_LibroDiario4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario4MouseClicked
        Modelo_Catalogo test = new Modelo_Catalogo();
        test.Get_Catalogo();

        Gestion_CatalogoTest gest = new Gestion_CatalogoTest();

        gest.setResizable(false);
        gest.setBounds(0, 0, Desk.getWidth(), Desk.getHeight());
        gest.setVisible(true);
        CentrarFrames(Desk, gest);
        Desk.add(gest);
        gest.show();

    }//GEN-LAST:event_Btn_LibroDiario4MouseClicked

    private void Btn_LibroDiario5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario5MouseClicked
        Modelo_TipoDocumento test = new Modelo_TipoDocumento();
        test.Get_TiposDocumentos();

    }//GEN-LAST:event_Btn_LibroDiario5MouseClicked

    private void Btn_LibroDiario5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LibroDiario5MouseEntered

    private void Btn_LibroDiario5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LibroDiario5MouseExited

    private void Btn_LibroDiario6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario6MouseClicked
        Modelo_TipoCuenta test = new Modelo_TipoCuenta();
        test.Get_TipoCuentas();


    }//GEN-LAST:event_Btn_LibroDiario6MouseClicked

    private void Btn_LibroDiario6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LibroDiario6MouseEntered

    private void Btn_LibroDiario6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroDiario6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LibroDiario6MouseExited

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Panel_Contador().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_EXIT3;
    private javax.swing.JPanel Btn_LibroDiario;
    private javax.swing.JPanel Btn_LibroDiario1;
    private javax.swing.JPanel Btn_LibroDiario2;
    private javax.swing.JPanel Btn_LibroDiario3;
    private javax.swing.JPanel Btn_LibroDiario4;
    private javax.swing.JPanel Btn_LibroDiario5;
    private javax.swing.JPanel Btn_LibroDiario6;
    private javax.swing.JPanel Btn_Regresar1;
    private javax.swing.JDesktopPane Desk;
    private javax.swing.JLabel Lb_Bienvenida;
    private javax.swing.JLabel Lb_Inventario;
    private javax.swing.JLabel Lb_Inventario1;
    private javax.swing.JLabel Lb_Inventario2;
    private javax.swing.JLabel Lb_Inventario3;
    private javax.swing.JLabel Lb_Inventario4;
    private javax.swing.JLabel Lb_Inventario5;
    private javax.swing.JLabel Lb_Inventario6;
    private javax.swing.JLabel Lb_Ordenar1;
    private javax.swing.JLabel Lb_X3;
    private javax.swing.JPanel Panel_bg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
