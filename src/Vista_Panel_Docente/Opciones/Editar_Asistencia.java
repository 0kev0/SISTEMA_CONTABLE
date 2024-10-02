package Vista_Panel_Docente.Opciones;

import static Funciones.Funciones.EnterMouse;
import static Funciones.Funciones.LeftMouse;
import static Funciones.Funciones.validarCampos;
import Modelos.Docente.Modelo_RegistroAsistencia;
import javax.swing.JTable;

public final class Editar_Asistencia extends javax.swing.JFrame {

    private Modelo_RegistroAsistencia Objeto_EditarAsistencia = new Modelo_RegistroAsistencia();
    private final DetallesAsistencia Objeto;
    private final JTable tbl_Act;

    public Editar_Asistencia(Modelo_RegistroAsistencia _ObjetoEditarasistencia, JTable tbl_Actividades, DetallesAsistencia _objeto) {
        initComponents();
        setLocationRelativeTo(this);

        this.Objeto_EditarAsistencia = _ObjetoEditarasistencia;
        this.tbl_Act = tbl_Actividades;
        this.Objeto = _objeto;

        TB_NIE.setText(Integer.toString(Objeto_EditarAsistencia.getNIE()));
        TB_Fecha.setText(Objeto_EditarAsistencia.getFecha().toString());
        TB_NombreAlumno.setText(Objeto_EditarAsistencia.getApellidoEstudiante() + " " + Objeto_EditarAsistencia.getNombreEstudiante());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Tb_Justificacion = new javax.swing.JTextField();
        TB_NombreAlumno = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Lb_Aerolinea3 = new javax.swing.JLabel();
        Btn_EsitarAsistencia = new javax.swing.JPanel();
        Lb_Guardar = new javax.swing.JLabel();
        TB_Fecha = new javax.swing.JTextField();
        TB_NIE = new javax.swing.JTextField();
        errorTb_Nota = new javax.swing.JLabel();
        Btn_Regresar = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        Lb_Aerolinea9 = new javax.swing.JLabel();
        Lb_Ordenar = new javax.swing.JLabel();
        Cb_TipoAsistencia = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(234, 223, 180));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tb_Justificacion.setBackground(new java.awt.Color(224, 213, 170));
        Tb_Justificacion.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Tb_Justificacion.setForeground(new java.awt.Color(0, 0, 0));
        Tb_Justificacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Justificacion : ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(Tb_Justificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 430, 50));

        TB_NombreAlumno.setEditable(false);
        TB_NombreAlumno.setBackground(new java.awt.Color(224, 213, 170));
        TB_NombreAlumno.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_NombreAlumno.setForeground(new java.awt.Color(0, 0, 0));
        TB_NombreAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Nombre alumno : ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_NombreAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 300, 50));

        jPanel4.setBackground(new java.awt.Color(226, 215, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea2.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea2.setText("Editar asistencia");

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

        Btn_EsitarAsistencia.setBackground(new java.awt.Color(226, 215, 132));
        Btn_EsitarAsistencia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 8, 0, new java.awt.Color(255, 153, 51)));
        Btn_EsitarAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_EsitarAsistenciaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_EsitarAsistenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_EsitarAsistenciaMouseExited(evt);
            }
        });

        Lb_Guardar.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Guardar.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Guardar.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Guardar.setText("Asignar nota");

        javax.swing.GroupLayout Btn_EsitarAsistenciaLayout = new javax.swing.GroupLayout(Btn_EsitarAsistencia);
        Btn_EsitarAsistencia.setLayout(Btn_EsitarAsistenciaLayout);
        Btn_EsitarAsistenciaLayout.setHorizontalGroup(
            Btn_EsitarAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_EsitarAsistenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Btn_EsitarAsistenciaLayout.setVerticalGroup(
            Btn_EsitarAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_EsitarAsistenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(Btn_EsitarAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 120, 50));

        TB_Fecha.setEditable(false);
        TB_Fecha.setBackground(new java.awt.Color(224, 213, 170));
        TB_Fecha.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_Fecha.setForeground(new java.awt.Color(0, 0, 0));
        TB_Fecha.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Fecha :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 120, 50));

        TB_NIE.setEditable(false);
        TB_NIE.setBackground(new java.awt.Color(224, 213, 170));
        TB_NIE.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_NIE.setForeground(new java.awt.Color(0, 0, 0));
        TB_NIE.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "NIE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_NIE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 50));

        errorTb_Nota.setBackground(new java.awt.Color(23, 42, 56));
        errorTb_Nota.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        errorTb_Nota.setForeground(new java.awt.Color(23, 42, 56));
        errorTb_Nota.setText("Error");
        jPanel1.add(errorTb_Nota, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 200, -1));

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

        jPanel10.setBackground(new java.awt.Color(255, 10, 10));

        Lb_Aerolinea9.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea9.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Lb_Aerolinea9.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea9))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lb_Aerolinea9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Btn_Regresar.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 149, 12));

        Lb_Ordenar.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Lb_Ordenar.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Ordenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back (1).png"))); // NOI18N
        Lb_Ordenar.setText("Regresar");
        Lb_Ordenar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar.add(Lb_Ordenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 130, 20));

        jPanel1.add(Btn_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 130, -1));

        Cb_TipoAsistencia.setBackground(new java.awt.Color(224, 213, 170));
        Cb_TipoAsistencia.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_TipoAsistencia.setForeground(new java.awt.Color(0, 0, 0));
        Cb_TipoAsistencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Justificada" }));
        Cb_TipoAsistencia.setToolTipText("");
        Cb_TipoAsistencia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Tipo Asistencia :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(Cb_TipoAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_EsitarAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_EsitarAsistenciaMouseClicked

        if (!validarCampos(jPanel1)) {
            System.out.println("faltan campos");
        } else {
            Objeto_EditarAsistencia.setJustificacion(Tb_Justificacion.getText());
            Objeto_EditarAsistencia.setIdEstado(3);//3 es estado asistencia justificada.

            Objeto_EditarAsistencia.Edit_Asistencia(Objeto_EditarAsistencia);
            Objeto.setVisible(true);
            Objeto.Cargar_Listado_Registro_Busqueda_Detalles(tbl_Act);
            dispose();
        }

    }//GEN-LAST:event_Btn_EsitarAsistenciaMouseClicked

    private void Btn_EsitarAsistenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_EsitarAsistenciaMouseEntered
        EnterMouse(Btn_EsitarAsistencia, Lb_Guardar, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_EsitarAsistenciaMouseEntered

    private void Btn_EsitarAsistenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_EsitarAsistenciaMouseExited
        LeftMouse(Btn_EsitarAsistencia, Lb_Guardar, "#E2D784", "#000000");
    }//GEN-LAST:event_Btn_EsitarAsistenciaMouseExited

    private void Btn_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseClicked
        dispose();
    }//GEN-LAST:event_Btn_RegresarMouseClicked

    private void Btn_RegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseEntered
        EnterMouse(Btn_Regresar, Lb_Ordenar, "#D90707", "#000000");
    }//GEN-LAST:event_Btn_RegresarMouseEntered

    private void Btn_RegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseExited
        LeftMouse(Btn_Regresar, Lb_Ordenar, "#980505", "#FFFFFF");
    }//GEN-LAST:event_Btn_RegresarMouseExited

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_EsitarAsistencia;
    private javax.swing.JPanel Btn_Regresar;
    private javax.swing.JComboBox<String> Cb_TipoAsistencia;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Aerolinea3;
    private javax.swing.JLabel Lb_Aerolinea9;
    private javax.swing.JLabel Lb_Guardar;
    private javax.swing.JLabel Lb_Ordenar;
    private javax.swing.JTextField TB_Fecha;
    private javax.swing.JTextField TB_NIE;
    private javax.swing.JTextField TB_NombreAlumno;
    private javax.swing.JTextField Tb_Justificacion;
    private javax.swing.JLabel errorTb_Nota;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

}
