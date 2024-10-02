package Vista_Panel_Secretaria.Opciones;

import static Funciones.Funciones.EnterMouse;
import static Funciones.Funciones.LeftMouse;
import Modelos.Docente.Modelo_Asignacion_Actividades;
import Modelos.Docente.Modelo_Periodos;
import Modelos.Secretaria.Modelo_Mensualidad;
import Modelos.Secretaria.Modelo_Responsables;
import Modelos.Secretaria.Modelo_Transacciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public final class Efectuar_PagoMesnualidad extends javax.swing.JFrame {

    private final Gestion_Mensualidades Objeto_GetionMensualidad = new Gestion_Mensualidades();
    private List<Modelo_Periodos> List_Periodos;

    private Modelo_Mensualidad _DataMensualidad = new Modelo_Mensualidad();
    private List<Modelo_Mensualidad> List_TipoActividad;

    private final Modelo_Asignacion_Actividades Objeto_Actividades = new Modelo_Asignacion_Actividades();

    private final JTable tbl_Mensualidades;
    private Gestion_Mensualidades Form_Mensualidades;

    public Efectuar_PagoMesnualidad(Modelo_Mensualidad Objeto_Mensualidad, JTable tbl_Actividades, Gestion_Mensualidades _Form_Mensualidades) {
        initComponents();
        setLocationRelativeTo(this);

        this.tbl_Mensualidades = tbl_Actividades;
        this.Form_Mensualidades = _Form_Mensualidades;

        this._DataMensualidad = Objeto_Mensualidad;

        TB_NIE.setText(Integer.toString(_DataMensualidad.getNIE()));
        TB_NombreAlumno.setText(_DataMensualidad.getNombre_estudiante());

        TB_NombreResponsableA.setText(_DataMensualidad.getNombre_ResponsableA());
        TB_NombreResponsableB.setText(_DataMensualidad.getNombre_ResponsableB());

        TB_Mes.setText(Integer.toString(_DataMensualidad.getMes()));
        TB_Grado.setText(Integer.toString(Objeto_Actividades.getGrado()));

        TB_Mora.setText(Double.toString(_DataMensualidad.getMora()));
        TB_Monto.setText(Double.toString(_DataMensualidad.getMontoFinal()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TB_Monto = new javax.swing.JTextField();
        TB_NombreAlumno = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Lb_Aerolinea3 = new javax.swing.JLabel();
        TB_Mes = new javax.swing.JTextField();
        TB_NIE = new javax.swing.JTextField();
        TB_NombreResponsableB = new javax.swing.JTextField();
        TB_NombreResponsableA = new javax.swing.JTextField();
        TB_Grado = new javax.swing.JTextField();
        TB_Mora = new javax.swing.JTextField();
        Btn_Regresar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        Lb_Aerolinea7 = new javax.swing.JLabel();
        Lb_Ordenar = new javax.swing.JLabel();
        Btn_Pago = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        Lb_Aerolinea6 = new javax.swing.JLabel();
        Lb_Crearcuenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(234, 223, 180));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TB_Monto.setEditable(false);
        TB_Monto.setBackground(new java.awt.Color(224, 213, 170));
        TB_Monto.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_Monto.setForeground(new java.awt.Color(0, 0, 0));
        TB_Monto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Monto  :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_Monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 120, 50));

        TB_NombreAlumno.setBackground(new java.awt.Color(224, 213, 170));
        TB_NombreAlumno.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_NombreAlumno.setForeground(new java.awt.Color(0, 0, 0));
        TB_NombreAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Nombre alumno : ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_NombreAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 430, 50));

        jPanel4.setBackground(new java.awt.Color(226, 215, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea2.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea2.setText("Pago Mensualidad");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Aerolinea2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 6, 300, -1));

        jPanel5.setBackground(new java.awt.Color(226, 215, 132));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea3.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea3.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea3.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea3.setText("Asignacion de notas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addGap(0, 18, Short.MAX_VALUE)
                    .addComponent(Lb_Aerolinea3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(14, Short.MAX_VALUE)
                    .addComponent(Lb_Aerolinea3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 6, 300, -1));

        TB_Mes.setEditable(false);
        TB_Mes.setBackground(new java.awt.Color(224, 213, 170));
        TB_Mes.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_Mes.setForeground(new java.awt.Color(0, 0, 0));
        TB_Mes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Mes : ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_Mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, 50));

        TB_NIE.setBackground(new java.awt.Color(224, 213, 170));
        TB_NIE.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_NIE.setForeground(new java.awt.Color(0, 0, 0));
        TB_NIE.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "NIE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_NIE, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 120, 50));

        TB_NombreResponsableB.setEditable(false);
        TB_NombreResponsableB.setBackground(new java.awt.Color(224, 213, 170));
        TB_NombreResponsableB.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_NombreResponsableB.setForeground(new java.awt.Color(0, 0, 0));
        TB_NombreResponsableB.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Nombre responsable B :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_NombreResponsableB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 430, 50));

        TB_NombreResponsableA.setEditable(false);
        TB_NombreResponsableA.setBackground(new java.awt.Color(224, 213, 170));
        TB_NombreResponsableA.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_NombreResponsableA.setForeground(new java.awt.Color(0, 0, 0));
        TB_NombreResponsableA.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Nombre responsable A :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_NombreResponsableA, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 430, 50));

        TB_Grado.setEditable(false);
        TB_Grado.setBackground(new java.awt.Color(224, 213, 170));
        TB_Grado.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_Grado.setForeground(new java.awt.Color(0, 0, 0));
        TB_Grado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Grado :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_Grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 120, 50));

        TB_Mora.setEditable(false);
        TB_Mora.setBackground(new java.awt.Color(224, 213, 170));
        TB_Mora.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_Mora.setForeground(new java.awt.Color(0, 0, 0));
        TB_Mora.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Mora  :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_Mora, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 120, 50));

        Btn_Regresar.setBackground(new java.awt.Color(152, 5, 5));
        Btn_Regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_RegresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_RegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_RegresarMouseExited(evt);
            }
        });
        Btn_Regresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 10, 10));

        Lb_Aerolinea7.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea7.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Lb_Aerolinea7.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea7))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lb_Aerolinea7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Btn_Regresar.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 149, 12));

        Lb_Ordenar.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Lb_Ordenar.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Ordenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back (1).png"))); // NOI18N
        Lb_Ordenar.setText("Regresar");
        Lb_Ordenar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar.add(Lb_Ordenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 130, 30));

        jPanel1.add(Btn_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, 50));

        Btn_Pago.setBackground(new java.awt.Color(64, 124, 62));
        Btn_Pago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Pago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_PagoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_PagoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_PagoMouseExited(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(40, 200, 35));

        Lb_Aerolinea6.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea6.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Lb_Aerolinea6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea6))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lb_Aerolinea6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Lb_Crearcuenta.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Lb_Crearcuenta.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Crearcuenta.setText("Realizar pago");
        Lb_Crearcuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout Btn_PagoLayout = new javax.swing.GroupLayout(Btn_Pago);
        Btn_Pago.setLayout(Btn_PagoLayout);
        Btn_PagoLayout.setHorizontalGroup(
            Btn_PagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Btn_PagoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Crearcuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Btn_PagoLayout.setVerticalGroup(
            Btn_PagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_PagoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Lb_Crearcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(Btn_Pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 160, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseClicked
        Gestion_Mensualidades log = new Gestion_Mensualidades();
        log.setVisible(true);
        dispose();

    }//GEN-LAST:event_Btn_RegresarMouseClicked

    private void Btn_RegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseEntered
        EnterMouse(Btn_Regresar, Lb_Ordenar, "#D90707", "#000000");
    }//GEN-LAST:event_Btn_RegresarMouseEntered

    private void Btn_RegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseExited
        LeftMouse(Btn_Regresar, Lb_Ordenar, "#980505", "#FFFFFF");
    }//GEN-LAST:event_Btn_RegresarMouseExited

    private void Btn_PagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_PagoMouseClicked

        if (_DataMensualidad.Edit_PagoMensualidad(_DataMensualidad) == 1) {

            Modelo_Responsables responsable = new Modelo_Responsables();
            int NIE = Integer.parseInt(TB_NIE.getText());
            String detalle = "Pago de mensualidad";
            double monto = _DataMensualidad.getMontoFinal();

            double mora = _DataMensualidad.getMora();
            if (mora > 1) {
                detalle = "Pago de mensualidad tardia";
            }

            String correo = responsable.Get_CorreoporNIE(NIE);

            Modelo_Transacciones datos = new Modelo_Transacciones();
            datos.setCantidades(1);
            datos.setDetalles(detalle);
            datos.setMontos(monto);
            datos.setCorreo(correo);
            datos.setPrecio(monto);

            datos.setResponsable(_DataMensualidad.getNombre_ResponsableA());
            datos.setEstudiante(_DataMensualidad.getNombre_estudiante());

            List<Modelo_Transacciones> resumen = new ArrayList<>();
            resumen.add(datos);

            Form_Mensualidades.Get_list_MesActual_Mensualidades(tbl_Mensualidades);

            Recibo recibo = new Recibo(resumen, datos);
            recibo.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_Btn_PagoMouseClicked

    private void Btn_PagoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_PagoMouseEntered
        EnterMouse(Btn_Pago, Lb_Crearcuenta, "#7BC778", "#000000");
    }//GEN-LAST:event_Btn_PagoMouseEntered

    private void Btn_PagoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_PagoMouseExited
        LeftMouse(Btn_Pago, Lb_Crearcuenta, "#407C3E", "#FFFFFF");
    }//GEN-LAST:event_Btn_PagoMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_Pago;
    private javax.swing.JPanel Btn_Regresar;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Aerolinea3;
    private javax.swing.JLabel Lb_Aerolinea6;
    private javax.swing.JLabel Lb_Aerolinea7;
    private javax.swing.JLabel Lb_Crearcuenta;
    private javax.swing.JLabel Lb_Ordenar;
    private javax.swing.JTextField TB_Grado;
    private javax.swing.JTextField TB_Mes;
    private javax.swing.JTextField TB_Monto;
    private javax.swing.JTextField TB_Mora;
    private javax.swing.JTextField TB_NIE;
    private javax.swing.JTextField TB_NombreAlumno;
    private javax.swing.JTextField TB_NombreResponsableA;
    private javax.swing.JTextField TB_NombreResponsableB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables

}
