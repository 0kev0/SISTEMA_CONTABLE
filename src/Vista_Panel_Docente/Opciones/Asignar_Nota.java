package Vista_Panel_Docente.Opciones;

import Funciones.Funciones;
import static Funciones.Funciones.EnterMouse;
import static Funciones.Funciones.LeftMouse;
import static Funciones.Funciones.Mouse_EnterTextbox;
import static Funciones.Funciones.Mouse_LeftTextbox;
import static Funciones.Funciones.showMessageDialog;
import static Funciones.Funciones.validarCampos;
import Modelos.Docente.Modelo_AsignacionNotas;
import Modelos.Docente.Modelo_Asignacion_Actividades;
import Modelos.Docente.Modelo_Periodos;
import Modelos.Docente.Modelo_TipoActividades;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;

public final class Asignar_Nota extends javax.swing.JFrame {

    private final Modelo_Periodos Objeto_Periodos = new Modelo_Periodos();
    private List<Modelo_Periodos> List_Periodos;

    private final Modelo_TipoActividades Objeto_TipoActividad = new Modelo_TipoActividades();
    private List<Modelo_TipoActividades> List_TipoActividad;

    private final Modelo_Asignacion_Actividades Objeto_Actividades = new Modelo_Asignacion_Actividades();
    private Asignacion_Notas Objeto;
    private final JTable tbl_Act;
    private final int idActividad;
    private final int grado;

    public Asignar_Nota(int idActividad, int periodo, int _grado, Modelo_AsignacionNotas Objeto_AsignarNota, JTable tbl_Actividades, Asignacion_Notas _objeto) {
        initComponents();
        setLocationRelativeTo(this);

        this.idActividad = idActividad;
        this.tbl_Act = tbl_Actividades;
        this.grado = _grado;
        this.Objeto = _objeto;

        TB_NIE2.setText(Integer.toString(Objeto_AsignarNota.getNIE()));
        TB_Periodo.setText(Integer.toString(periodo));
        TB_NombreAlumno.setText(Objeto_AsignarNota.getApellidoEstudiante() + " " + Objeto_AsignarNota.getNombreEstudiante());
        TB_NombreActividad.setText(Objeto_AsignarNota.getNombreActividad());
    }

    public void Get_Periodos(JComboBox ComboBox) {

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_Periodos = Objeto_Periodos.Get_EstadosActividades();
        System.out.println("hay " + List_Periodos.size());

        for (Modelo_Periodos item : List_Periodos) {
            ModeloComboBox.addElement(item.getPeriodo());
        }

        ComboBox.setModel(ModeloComboBox);
    }

    public void Get_TipoActividad(JComboBox ComboBox) {
        try {
            DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

            List_TipoActividad = Objeto_TipoActividad.Get_EstadosActividades();
            System.out.println("hay " + List_TipoActividad.size());

            for (Modelo_TipoActividades item : List_TipoActividad) {
                ModeloComboBox.addElement(item.getTipoActividad());
            }

            ComboBox.setModel(ModeloComboBox);
        } catch (Exception e) {
            // Manejo de excepciones aquí
            System.err.println("Error al cargar los elementos en el combo box: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TB_NombreActividad = new javax.swing.JTextField();
        TB_NombreAlumno = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Lb_Aerolinea3 = new javax.swing.JLabel();
        Btn_AsignarNota = new javax.swing.JPanel();
        Lb_Guardar = new javax.swing.JLabel();
        TB_Nota = new javax.swing.JTextField();
        TB_Periodo = new javax.swing.JTextField();
        TB_NIE2 = new javax.swing.JTextField();
        errorTb_Nota = new javax.swing.JLabel();
        Btn_Regresar = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        Lb_Aerolinea9 = new javax.swing.JLabel();
        Lb_Ordenar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(234, 223, 180));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TB_NombreActividad.setEditable(false);
        TB_NombreActividad.setBackground(new java.awt.Color(224, 213, 170));
        TB_NombreActividad.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_NombreActividad.setForeground(new java.awt.Color(0, 0, 0));
        TB_NombreActividad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Nombre de la actividad", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_NombreActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 300, 50));

        TB_NombreAlumno.setEditable(false);
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
        Lb_Aerolinea2.setText("Asignar nota");

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

        Btn_AsignarNota.setBackground(new java.awt.Color(226, 215, 132));
        Btn_AsignarNota.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 8, 0, new java.awt.Color(255, 153, 51)));
        Btn_AsignarNota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_AsignarNotaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_AsignarNotaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_AsignarNotaMouseExited(evt);
            }
        });

        Lb_Guardar.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Guardar.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Guardar.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Guardar.setText("Asignar nota");

        javax.swing.GroupLayout Btn_AsignarNotaLayout = new javax.swing.GroupLayout(Btn_AsignarNota);
        Btn_AsignarNota.setLayout(Btn_AsignarNotaLayout);
        Btn_AsignarNotaLayout.setHorizontalGroup(
            Btn_AsignarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_AsignarNotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Btn_AsignarNotaLayout.setVerticalGroup(
            Btn_AsignarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_AsignarNotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(Btn_AsignarNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 120, 50));

        TB_Nota.setBackground(new java.awt.Color(224, 213, 170));
        TB_Nota.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_Nota.setForeground(new java.awt.Color(0, 0, 0));
        TB_Nota.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Nota obtenida :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        TB_Nota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TB_NotaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TB_NotaMouseExited(evt);
            }
        });
        TB_Nota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TB_NotaKeyTyped(evt);
            }
        });
        jPanel1.add(TB_Nota, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 120, 50));

        TB_Periodo.setEditable(false);
        TB_Periodo.setBackground(new java.awt.Color(224, 213, 170));
        TB_Periodo.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_Periodo.setForeground(new java.awt.Color(0, 0, 0));
        TB_Periodo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Periodo: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_Periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 120, 50));

        TB_NIE2.setEditable(false);
        TB_NIE2.setBackground(new java.awt.Color(224, 213, 170));
        TB_NIE2.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_NIE2.setForeground(new java.awt.Color(0, 0, 0));
        TB_NIE2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "NIE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(TB_NIE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 120, 50));

        errorTb_Nota.setBackground(new java.awt.Color(23, 42, 56));
        errorTb_Nota.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        errorTb_Nota.setForeground(new java.awt.Color(23, 42, 56));
        errorTb_Nota.setText("Error");
        jPanel1.add(errorTb_Nota, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 200, -1));

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

    private void Btn_AsignarNotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AsignarNotaMouseClicked
        int NIE = Integer.parseInt(TB_NIE2.getText());
        double notaObtenida = Double.parseDouble(TB_Nota.getText());
        
        if (!validarCampos(jPanel1)) {
            System.out.println("faltan campos");
        } else {
            Modelo_AsignacionNotas edit = new Modelo_AsignacionNotas();

            edit.setId_Actividad(idActividad);
            edit.setNota(notaObtenida);
            edit.setNIE(NIE);

            edit.Edit_AsignarNotas(edit);

            showMessageDialog("Edicion exitosa", "la actividad fue editada exitosamente");

            Objeto.Get_Tabla_NotaActividades_Todas(tbl_Act);

            dispose();
        }

    }//GEN-LAST:event_Btn_AsignarNotaMouseClicked

    private void Btn_AsignarNotaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AsignarNotaMouseEntered
        EnterMouse(Btn_AsignarNota, Lb_Guardar, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_AsignarNotaMouseEntered

    private void Btn_AsignarNotaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AsignarNotaMouseExited
        LeftMouse(Btn_AsignarNota, Lb_Guardar, "#E2D784", "#000000");
    }//GEN-LAST:event_Btn_AsignarNotaMouseExited

    private void TB_NotaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_NotaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TB_NotaMouseEntered

    private void TB_NotaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_NotaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_TB_NotaMouseExited

    private void TB_NotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_NotaKeyTyped
        Funciones.ValidarNota(TB_Nota, errorTb_Nota);


    }//GEN-LAST:event_TB_NotaKeyTyped

    private void Btn_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseClicked
        dispose();
    }//GEN-LAST:event_Btn_RegresarMouseClicked

    private void Btn_RegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseEntered
        Funciones.EnterMouse(Btn_Regresar, Lb_Ordenar, "#D90707", "#000000");
    }//GEN-LAST:event_Btn_RegresarMouseEntered

    private void Btn_RegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseExited
        Funciones.LeftMouse(Btn_Regresar, Lb_Ordenar, "#980505", "#FFFFFF");
    }//GEN-LAST:event_Btn_RegresarMouseExited

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
            java.util.logging.Logger.getLogger(Asignar_Nota.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asignar_Nota.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asignar_Nota.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asignar_Nota.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_AsignarNota;
    private javax.swing.JPanel Btn_Regresar;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Aerolinea3;
    private javax.swing.JLabel Lb_Aerolinea9;
    private javax.swing.JLabel Lb_Guardar;
    private javax.swing.JLabel Lb_Ordenar;
    private javax.swing.JTextField TB_NIE2;
    private javax.swing.JTextField TB_NombreActividad;
    private javax.swing.JTextField TB_NombreAlumno;
    private javax.swing.JTextField TB_Nota;
    private javax.swing.JTextField TB_Periodo;
    private javax.swing.JLabel errorTb_Nota;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

}
