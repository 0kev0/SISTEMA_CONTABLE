package Vista_Panel_Contador;

import Funciones.Funciones;
import static Funciones.Funciones.EnterMouse;
import static Funciones.Funciones.LeftMouse;
import java.awt.Color;
import static Funciones.Funciones.CentrarFrames;
import Log_Iin.Usuario.Modelo_Usuario;
import Log_Iin.Usuario.Modelo_Usuario;
import Log_Iin.Usuario.log_in1;
import Modelos.Contador.Modelo_Catalogo;
import Modelos.Contador.Modelo_LibroDiario;
import Modelos.Contador.Modelo_TipoCuenta;
import Modelos.Contador.Modelo_TipoDocumento;
import Vista_Panel_Admin.Opciones.Gestion_CatalogoTest;
import Vista_Panel_Admin.Opciones.Gestion_LibroDiario;
import Vista_Panel_Admin.Opciones.Gestion_LibroMayor;
import Vista_Panel_Admin.Opciones.Vista_CatalogoTest;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Panel_Contador extends javax.swing.JFrame {

    public Panel_Contador() {
        getContentPane().setBackground(new Color(250, 250, 250));
        initComponents();
    }

    private Modelo_Usuario Modelo_Usuario;

    public Panel_Contador(Modelo_Usuario User) {
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
        Btn_Libro_Diario = new Customizacion.Custom_Buttons();
        Lb_LibroDiario = new javax.swing.JLabel();
        Btn_LibroMayor = new Customizacion.Custom_Buttons();
        Lb_LibroMayor = new javax.swing.JLabel();
        Btn_EstadosFinancieros = new Customizacion.Custom_Buttons();
        Lb_EstadosFinancieros = new javax.swing.JLabel();
        Btn_VerRegistros = new Customizacion.Custom_Buttons();
        Lb_VerRegistros = new javax.swing.JLabel();
        Btn_Regresar1 = new javax.swing.JPanel();
        Lb_Regresar = new javax.swing.JLabel();
        Btn_VerCatalogo = new Customizacion.Custom_Buttons();
        Lb_VerCatalogo = new javax.swing.JLabel();
        Btn_TipoDocumentos = new Customizacion.Custom_Buttons();
        Lb_TipoDocs = new javax.swing.JLabel();
        Btn_TipoCuentas = new Customizacion.Custom_Buttons();
        Lb_TipoCuentas = new javax.swing.JLabel();

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
        Lb_Bienvenida.setText("SISTEMA CONTABLE CONTADOR (demo)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(Lb_Bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
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

        Btn_Libro_Diario.setBackground(new java.awt.Color(137, 163, 178));
        Btn_Libro_Diario.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_Libro_Diario.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_Libro_Diario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_Libro_DiarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_Libro_DiarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_Libro_DiarioMouseExited(evt);
            }
        });
        Btn_Libro_Diario.setLayout(new java.awt.GridBagLayout());

        Lb_LibroDiario.setBackground(new java.awt.Color(7, 3, 26));
        Lb_LibroDiario.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_LibroDiario.setForeground(new java.awt.Color(242, 244, 209));
        Lb_LibroDiario.setText("Libro Diario");
        Btn_Libro_Diario.add(Lb_LibroDiario, new java.awt.GridBagConstraints());

        Btn_LibroMayor.setBackground(new java.awt.Color(137, 163, 178));
        Btn_LibroMayor.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_LibroMayor.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_LibroMayor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_LibroMayorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_LibroMayorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_LibroMayorMouseExited(evt);
            }
        });
        Btn_LibroMayor.setLayout(new java.awt.GridBagLayout());

        Lb_LibroMayor.setBackground(new java.awt.Color(7, 3, 26));
        Lb_LibroMayor.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_LibroMayor.setForeground(new java.awt.Color(242, 244, 209));
        Lb_LibroMayor.setText("Libro Mayor");
        Btn_LibroMayor.add(Lb_LibroMayor, new java.awt.GridBagConstraints());

        Btn_EstadosFinancieros.setBackground(new java.awt.Color(137, 163, 178));
        Btn_EstadosFinancieros.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_EstadosFinancieros.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_EstadosFinancieros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_EstadosFinancierosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_EstadosFinancierosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_EstadosFinancierosMouseExited(evt);
            }
        });
        Btn_EstadosFinancieros.setLayout(new java.awt.GridBagLayout());

        Lb_EstadosFinancieros.setBackground(new java.awt.Color(7, 3, 26));
        Lb_EstadosFinancieros.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_EstadosFinancieros.setForeground(new java.awt.Color(242, 244, 209));
        Lb_EstadosFinancieros.setText("Estados Financieros");
        Btn_EstadosFinancieros.add(Lb_EstadosFinancieros, new java.awt.GridBagConstraints());

        Btn_VerRegistros.setBackground(new java.awt.Color(137, 163, 178));
        Btn_VerRegistros.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_VerRegistros.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_VerRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_VerRegistrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_VerRegistrosMouseExited(evt);
            }
        });
        Btn_VerRegistros.setLayout(new java.awt.GridBagLayout());

        Lb_VerRegistros.setBackground(new java.awt.Color(7, 3, 26));
        Lb_VerRegistros.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_VerRegistros.setForeground(new java.awt.Color(242, 244, 209));
        Lb_VerRegistros.setText("Ver Registros");
        Btn_VerRegistros.add(Lb_VerRegistros, new java.awt.GridBagConstraints());

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

        Lb_Regresar.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Lb_Regresar.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Regresar.setText("Regresar");
        Lb_Regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar1.add(Lb_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 130, 30));

        Btn_VerCatalogo.setBackground(new java.awt.Color(137, 163, 178));
        Btn_VerCatalogo.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_VerCatalogo.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_VerCatalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_VerCatalogoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_VerCatalogoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_VerCatalogoMouseExited(evt);
            }
        });
        Btn_VerCatalogo.setLayout(new java.awt.GridBagLayout());

        Lb_VerCatalogo.setBackground(new java.awt.Color(7, 3, 26));
        Lb_VerCatalogo.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_VerCatalogo.setForeground(new java.awt.Color(242, 244, 209));
        Lb_VerCatalogo.setText("Ver catalogo");
        Btn_VerCatalogo.add(Lb_VerCatalogo, new java.awt.GridBagConstraints());

        Btn_TipoDocumentos.setBackground(new java.awt.Color(137, 163, 178));
        Btn_TipoDocumentos.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_TipoDocumentos.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_TipoDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_TipoDocumentosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_TipoDocumentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_TipoDocumentosMouseExited(evt);
            }
        });
        Btn_TipoDocumentos.setLayout(new java.awt.GridBagLayout());

        Lb_TipoDocs.setBackground(new java.awt.Color(7, 3, 26));
        Lb_TipoDocs.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_TipoDocs.setForeground(new java.awt.Color(242, 244, 209));
        Lb_TipoDocs.setText("Ver tipo documentos");
        Btn_TipoDocumentos.add(Lb_TipoDocs, new java.awt.GridBagConstraints());

        Btn_TipoCuentas.setBackground(new java.awt.Color(137, 163, 178));
        Btn_TipoCuentas.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_TipoCuentas.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_TipoCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_TipoCuentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_TipoCuentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_TipoCuentasMouseExited(evt);
            }
        });
        Btn_TipoCuentas.setLayout(new java.awt.GridBagLayout());

        Lb_TipoCuentas.setBackground(new java.awt.Color(7, 3, 26));
        Lb_TipoCuentas.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_TipoCuentas.setForeground(new java.awt.Color(242, 244, 209));
        Lb_TipoCuentas.setText("Ver tipo cuentas");
        Btn_TipoCuentas.add(Lb_TipoCuentas, new java.awt.GridBagConstraints());

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
                            .addComponent(Btn_Libro_Diario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_LibroMayor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_EstadosFinancieros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_VerRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Regresar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_VerCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Btn_TipoDocumentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_TipoCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(Btn_TipoCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_TipoDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_VerCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Libro_Diario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_LibroMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_EstadosFinancieros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_VerRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        String loginfo = " Cerro sesion el usuario " + Modelo_Usuario.getNombres() + " ***";
        String Log = Funciones.Registro_Log(loginfo);
        Funciones.escribirEnArchivo(Log);

        log_in1 gest = new log_in1();
        dispose();
        gest.setVisible(true);
    }//GEN-LAST:event_Btn_Regresar1MouseClicked

    private void Btn_Regresar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Regresar1MouseEntered
        EnterMouse(Btn_Regresar1, Lb_Regresar, "#F71111", "#FFFFFF");
    }//GEN-LAST:event_Btn_Regresar1MouseEntered

    private void Btn_Regresar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Regresar1MouseExited
        // TODO add your handling code here:980505
        LeftMouse(Btn_Regresar1, Lb_Regresar, "#980505", "#F2F4D1");

    }//GEN-LAST:event_Btn_Regresar1MouseExited

    private void Btn_VerRegistrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_VerRegistrosMouseEntered
        EnterMouse(Btn_VerRegistros, Lb_VerRegistros, "#ABBEC8", "#FFFFFF");
    }//GEN-LAST:event_Btn_VerRegistrosMouseEntered

    private void Btn_VerRegistrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_VerRegistrosMouseExited
        LeftMouse(Btn_VerRegistros, Lb_VerRegistros, "#89A3B2", "#F2F4D1");
    }//GEN-LAST:event_Btn_VerRegistrosMouseExited

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

    private void Btn_LibroMayorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroMayorMouseEntered
        EnterMouse(Btn_LibroMayor, Lb_LibroMayor, "#ABBEC8", "#FFFFFF");
    }//GEN-LAST:event_Btn_LibroMayorMouseEntered

    private void Btn_LibroMayorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroMayorMouseExited
        LeftMouse(Btn_LibroMayor, Lb_LibroMayor, "#89A3B2", "#F2F4D1");
    }//GEN-LAST:event_Btn_LibroMayorMouseExited

    private void Btn_Libro_DiarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Libro_DiarioMouseEntered
        EnterMouse(Btn_Libro_Diario, Lb_LibroDiario, "#ABBEC8", "#FFFFFF");
    }//GEN-LAST:event_Btn_Libro_DiarioMouseEntered

    private void Btn_Libro_DiarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Libro_DiarioMouseExited
        LeftMouse(Btn_Libro_Diario, Lb_LibroDiario, "#89A3B2", "#F2F4D1");
    }//GEN-LAST:event_Btn_Libro_DiarioMouseExited

    private void Btn_EstadosFinancierosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_EstadosFinancierosMouseEntered
        EnterMouse(Btn_EstadosFinancieros, Lb_EstadosFinancieros, "#ABBEC8", "#FFFFFF");
    }//GEN-LAST:event_Btn_EstadosFinancierosMouseEntered

    private void Btn_EstadosFinancierosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_EstadosFinancierosMouseExited
        LeftMouse(Btn_EstadosFinancieros, Lb_EstadosFinancieros, "#89A3B2", "#F2F4D1");
    }//GEN-LAST:event_Btn_EstadosFinancierosMouseExited

    private void Btn_VerCatalogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_VerCatalogoMouseEntered
        EnterMouse(Btn_VerCatalogo, Lb_VerCatalogo, "#ABBEC8", "#FFFFFF");
    }//GEN-LAST:event_Btn_VerCatalogoMouseEntered

    private void Btn_VerCatalogoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_VerCatalogoMouseExited
        LeftMouse(Btn_VerCatalogo, Lb_VerCatalogo, "#89A3B2", "#F2F4D1");
    }//GEN-LAST:event_Btn_VerCatalogoMouseExited

    private void Btn_VerCatalogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_VerCatalogoMouseClicked
        String loginfo = " Usuario : " + Modelo_Usuario.getNombres() + " Mostrando vista catalogo de cuentas...";
        String Log = Funciones.Registro_Log(loginfo);
        Funciones.escribirEnArchivo(Log);

        Modelo_Catalogo test = new Modelo_Catalogo();
        test.Get_Catalogo();

        Gestion_CatalogoTest gest = new Gestion_CatalogoTest();

        gest.setResizable(false);
        gest.setBounds(0, 0, Desk.getWidth(), Desk.getHeight());
        gest.setVisible(true);
        CentrarFrames(Desk, gest);
        Desk.add(gest);
        gest.show();

    }//GEN-LAST:event_Btn_VerCatalogoMouseClicked

    private void Btn_TipoDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TipoDocumentosMouseClicked
        String loginfo = " Usuario : " + Modelo_Usuario.getNombres() + " Mostrando lista de tipos de Documentos...";
        String Log = Funciones.Registro_Log(loginfo);
        Funciones.escribirEnArchivo(Log);

        Modelo_TipoDocumento test = new Modelo_TipoDocumento();
        test.Get_TiposDocumentos();

    }//GEN-LAST:event_Btn_TipoDocumentosMouseClicked

    private void Btn_TipoDocumentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TipoDocumentosMouseEntered
        EnterMouse(Btn_TipoDocumentos, Lb_TipoDocs, "#ABBEC8", "#FFFFFF");
    }//GEN-LAST:event_Btn_TipoDocumentosMouseEntered

    private void Btn_TipoDocumentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TipoDocumentosMouseExited
        LeftMouse(Btn_TipoDocumentos, Lb_TipoDocs, "#89A3B2", "#F2F4D1");
    }//GEN-LAST:event_Btn_TipoDocumentosMouseExited

    private void Btn_TipoCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TipoCuentasMouseClicked
        String loginfo = " Usuario : " + Modelo_Usuario.getNombres() + " Mostrando lista de tipos de cuentas";
        String Log = Funciones.Registro_Log(loginfo);
        Funciones.escribirEnArchivo(Log);

        Modelo_TipoCuenta test = new Modelo_TipoCuenta();
        test.Get_TipoCuentas();


    }//GEN-LAST:event_Btn_TipoCuentasMouseClicked

    private void Btn_TipoCuentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TipoCuentasMouseEntered
        EnterMouse(Btn_TipoCuentas, Lb_TipoCuentas, "#ABBEC8", "#FFFFFF");
    }//GEN-LAST:event_Btn_TipoCuentasMouseEntered

    private void Btn_TipoCuentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TipoCuentasMouseExited
        LeftMouse(Btn_TipoCuentas, Lb_TipoCuentas, "#89A3B2", "#F2F4D1");
    }//GEN-LAST:event_Btn_TipoCuentasMouseExited

    private void Btn_Libro_DiarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Libro_DiarioMouseClicked
        String loginfo = " Usuario : " + Modelo_Usuario.getNombres() + " Mostrando registros del libro diario...";
        String Log = Funciones.Registro_Log(loginfo);
        Funciones.escribirEnArchivo(Log);

        Modelo_LibroDiario get = new Modelo_LibroDiario();

        try {
            get.Get_LibroDiario();

            Gestion_LibroDiario gest = new Gestion_LibroDiario();
            gest.setResizable(false);
            gest.setBounds(0, 0, Desk.getWidth(), Desk.getHeight());
            gest.setVisible(true);
            CentrarFrames(Desk, gest);
            Desk.add(gest);
            gest.show();

        } catch (SQLException ex) {
            Logger.getLogger(Panel_Contador.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_Btn_Libro_DiarioMouseClicked

    private void Btn_LibroMayorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LibroMayorMouseClicked
        String loginfo = " Usuario : " + Modelo_Usuario.getNombres() + " Mostrando registro de libro mayor...aun no esta lista :) ..";
        String Log = Funciones.Registro_Log(loginfo);
        Funciones.escribirEnArchivo(Log);

        try {
            Gestion_LibroMayor gest = new Gestion_LibroMayor();
            gest.setResizable(false);
            gest.setBounds(0, 0, Desk.getWidth(), Desk.getHeight());
            gest.setVisible(true);
            CentrarFrames(Desk, gest);
            Desk.add(gest);
            gest.show();

        } catch (SQLException ex) {
            Logger.getLogger(Panel_Contador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Btn_LibroMayorMouseClicked

    private void Btn_EstadosFinancierosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_EstadosFinancierosMouseClicked
        String loginfo = " Usuario : " + Modelo_Usuario.getNombres() + " Mostrando Vista de estados Financieros...";
        String Log = Funciones.Registro_Log(loginfo);
        Funciones.escribirEnArchivo(Log);

    }//GEN-LAST:event_Btn_EstadosFinancierosMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Panel_Contador().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_EXIT3;
    private javax.swing.JPanel Btn_EstadosFinancieros;
    private javax.swing.JPanel Btn_LibroMayor;
    private javax.swing.JPanel Btn_Libro_Diario;
    private javax.swing.JPanel Btn_Regresar1;
    private javax.swing.JPanel Btn_TipoCuentas;
    private javax.swing.JPanel Btn_TipoDocumentos;
    private javax.swing.JPanel Btn_VerCatalogo;
    private javax.swing.JPanel Btn_VerRegistros;
    private javax.swing.JDesktopPane Desk;
    private javax.swing.JLabel Lb_Bienvenida;
    private javax.swing.JLabel Lb_EstadosFinancieros;
    private javax.swing.JLabel Lb_LibroDiario;
    private javax.swing.JLabel Lb_LibroMayor;
    private javax.swing.JLabel Lb_Regresar;
    private javax.swing.JLabel Lb_TipoCuentas;
    private javax.swing.JLabel Lb_TipoDocs;
    private javax.swing.JLabel Lb_VerCatalogo;
    private javax.swing.JLabel Lb_VerRegistros;
    private javax.swing.JLabel Lb_X3;
    private javax.swing.JPanel Panel_bg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
