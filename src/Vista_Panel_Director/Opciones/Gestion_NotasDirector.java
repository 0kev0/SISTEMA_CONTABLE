package Vista_Panel_Director.Opciones;

import Customizacion.TablaCusomizada;
import static Funciones.Funciones.EnterMouse;
import Modelos.Docente.Modelo_GestionNotas;
import Modelos.Docente.Modelo_Materias;
import Vista_Panel_Director.Panel_Director1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class Gestion_NotasDirector extends javax.swing.JInternalFrame {

    public Gestion_NotasDirector() {
        initComponents();
        
        Get_ListMAterias(Cb_Materias);
        modeloTabla = (DefaultTableModel) Tbl_RegistroNotas.getModel();
        DiseñoTabla(Tbl_RegistroNotas);
        Get_ListadoNotas(Tbl_RegistroNotas, Grado, idMateriaGuia);

    }

    private final Modelo_GestionNotas Objeto_GestionNotas = new Modelo_GestionNotas();
    private List<Modelo_GestionNotas> List_Notas;

    private List<Modelo_Materias> List_Materias;
    private final Modelo_Materias Objeto_Modelo_Materias = new Modelo_Materias();

    private DefaultTableModel modeloTabla = new DefaultTableModel();

    private int Grado;
    private int idMateriaGuia;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_RegistroNotas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Lb_Aerolinea1 = new javax.swing.JLabel();
        Cb_Periodo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        Lb_MateriaGuia = new javax.swing.JLabel();
        Cb_Materias = new javax.swing.JComboBox<>();
        Cb_Grado = new javax.swing.JComboBox<>();
        Btn_Regresar = new javax.swing.JPanel();
        Lb_atras = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setBorder(null);
        setTitle("Registro de notas ");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setEnabled(false);
        setFocusCycleRoot(false);
        setFocusable(false);
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jPanel1.setBackground(new java.awt.Color(234, 223, 180));
        jPanel1.setMinimumSize(new java.awt.Dimension(1060, 630));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tbl_RegistroNotas.setAutoCreateRowSorter(true);
        Tbl_RegistroNotas.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        Tbl_RegistroNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIE", "Apellidos", "Nombre", "Act.1 (15%)", "Act.2 (15%)", " Act.3 (15%)", "Act.4 (15%)", "Examen (30%)", "Auto-eval (10%)", "Promedio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_RegistroNotas);
        if (Tbl_RegistroNotas.getColumnModel().getColumnCount() > 0) {
            Tbl_RegistroNotas.getColumnModel().getColumn(0).setPreferredWidth(30);
            Tbl_RegistroNotas.getColumnModel().getColumn(9).setPreferredWidth(50);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 1060, 340));

        jPanel3.setBackground(new java.awt.Color(226, 215, 132));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea1.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea1.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea1.setText("Registro de Notas ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Aerolinea1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 6, 490, -1));

        Cb_Periodo.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Periodo.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Periodo.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1er periodo", "2do periodo", "3er periodo", "4to periodo" }));
        Cb_Periodo.setToolTipText("");
        Cb_Periodo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Periodo: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Periodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_PeriodoActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, 130, -1));

        jPanel4.setBackground(new java.awt.Color(226, 215, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 8, new java.awt.Color(255, 153, 51)));

        Lb_MateriaGuia.setBackground(new java.awt.Color(255, 255, 255));
        Lb_MateriaGuia.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_MateriaGuia.setForeground(new java.awt.Color(0, 0, 0));
        Lb_MateriaGuia.setText("materia");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_MateriaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(Lb_MateriaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 320, -1));

        Cb_Materias.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Materias.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Materias.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Materias.setToolTipText("");
        Cb_Materias.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Materias : ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Materias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_MateriasActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Materias, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 180, -1));

        Cb_Grado.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Grado.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Grado.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Grado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1er Grado", "2do Grado", "3er Grado", "4to Grado", "5to Grado", "6to Grado", "7mo Grado", "8vo Grado", "9no Grado" }));
        Cb_Grado.setToolTipText("");
        Cb_Grado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Periodo: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Grado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_GradoActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(934, 140, 130, -1));

        Btn_Regresar.setBackground(new java.awt.Color(152, 5, 5));
        Btn_Regresar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 10, 0, new java.awt.Color(247, 17, 17)));
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

        Lb_atras.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Lb_atras.setForeground(new java.awt.Color(255, 255, 255));
        Lb_atras.setText("Regresar");
        Lb_atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar.add(Lb_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel1.add(Btn_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1102, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void Cb_PeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_PeriodoActionPerformed
        System.out.println("CARGANDO TODAS LAS NOTAS");
        modeloTabla.setNumRows(0);
        String Materia = Cb_Materias.getSelectedItem().toString();
        int periodo = Cb_Periodo.getSelectedIndex() + 1;

        List_Notas = Objeto_GestionNotas.GetRegistroNotas(Grado, periodo, Materia);
        System.out.println("###hay " + List_Notas.size());
        for (Modelo_GestionNotas item : List_Notas) {
            System.out.println("Notas ver 2 tareas " + item.getTareas().size() + " parcial " + item.getParcial() + " auto " + item.getAutoE());

            double prom = 0;
            for (int i = 0; i < 4; i++) {
                prom += item.getTareas().get(i) * .15;
                System.out.println("bien " + item.getTareas().get(i));
            }

            prom += item.getParcial() * .50;
            prom += item.getAutoE() * .10;

            modeloTabla.addRow(new Object[]{
                item.getNIE(),
                item.getApellido(),
                item.getNombre(),
                item.getTareas().get(0),
                item.getTareas().get(1),
                item.getTareas().get(2),
                item.getTareas().get(3),
                item.getParcial(),
                item.getAutoE(),
                Math.round(prom * 100.0) / 100.0
            });
        }

        Tbl_RegistroNotas.setModel(modeloTabla);

    }//GEN-LAST:event_Cb_PeriodoActionPerformed

    public void Get_ListMAterias(JComboBox ComboBox) {
        int grado = Cb_Grado.getSelectedIndex() + 1;
        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_Materias = Objeto_Modelo_Materias.GetListadoMaterias(grado);
        System.out.println("hay " + List_Materias.size());

        for (Modelo_Materias item : List_Materias) {
            ModeloComboBox.addElement(item.getNombreMateria());
        }

        ComboBox.setModel(ModeloComboBox);
    }

    private void Cb_MateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_MateriasActionPerformed
        int filtro = Cb_Materias.getSelectedIndex();

        List_Materias = Objeto_Modelo_Materias.GetListadoMaterias(Grado);

        String materiaSeleccionada = List_Materias.get(filtro).getNombreMateria();
        int Id_materiaSeleccionada = List_Materias.get(filtro).getidMateria();

        Lb_MateriaGuia.setText(materiaSeleccionada);
        Get_ListadoNotas_Materia(Tbl_RegistroNotas, Id_materiaSeleccionada);


    }//GEN-LAST:event_Cb_MateriasActionPerformed

    private void Cb_GradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_GradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cb_GradoActionPerformed

    private void Btn_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseClicked
        Panel_Director1 gest = new Panel_Director1();
        gest.setVisible(true);
        dispose();

    }//GEN-LAST:event_Btn_RegresarMouseClicked

    private void Btn_RegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseEntered
        EnterMouse(Btn_Regresar, Lb_atras, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_RegresarMouseEntered

    private void Btn_RegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_RegresarMouseExited

    public void DiseñoTabla(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new TablaCusomizada());
        tabla.setRowHeight(40);
        tabla.getTableHeader().setBackground(Color.decode("#5C636E"));
        tabla.getTableHeader().setForeground(Color.white);
        Font fuente = new Font("Roboto", Font.BOLD, 12);
        tabla.setFont(fuente);
        tabla.getTableHeader().setFont(fuente);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        int numeroDeCeldas = 10; // Cambia este valor al número de celdas que necesites

        for (int i = 0; i < numeroDeCeldas; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        tabla.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
        tabla.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);

        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(60, 45));

    }

    public void Get_ListadoNotas(JTable tabla, int grado, int id_materia) {
        System.out.println("CARGANDO TODAS LAS NOTAS");
        modeloTabla.setNumRows(0);
        String Materia = Cb_Materias.getSelectedItem().toString();

        int periodo = Cb_Periodo.getSelectedIndex() + 1;

        System.out.println(">>>>>>>>>>>>>buscando notas grado " + grado + " periodo " + periodo + " materia " + Materia);
        List_Notas = Objeto_GestionNotas.GetRegistroNotas(grado, periodo, Materia);
        System.out.println("###hay " + List_Notas.size());
        for (Modelo_GestionNotas item : List_Notas) {
            System.out.println("Notas ver 2 tareas " + item.getTareas().size() + " parcial " + item.getParcial() + " auto " + item.getAutoE());

            double prom = 0;
            for (int i = 0; i < 4; i++) {
                prom += item.getTareas().get(i) * .15;
                System.out.println("bien " + item.getTareas().get(i));
            }

            prom += item.getParcial() * .50;
            prom += item.getAutoE() * .10;

            modeloTabla.addRow(new Object[]{
                item.getNIE(),
                item.getApellido(),
                item.getNombre(),
                item.getTareas().get(0),
                item.getTareas().get(1),
                item.getTareas().get(2),
                item.getTareas().get(3),
                item.getParcial(),
                item.getAutoE(),
                Math.round(prom * 100.0) / 100.0
            });
        }

        tabla.setModel(modeloTabla);
    }

    public void Get_ListadoNotas_Materia(JTable tabla, int idmateria) {
        System.out.println("CARGANDO TODAS LAS NOTAS");
        modeloTabla.setNumRows(0);
        String Materia = Cb_Materias.getSelectedItem().toString();

        int periodo = Cb_Periodo.getSelectedIndex() + 1;

        System.out.println(">>>>>>>>>>>>>buscando notas grado " + Grado + " periodo " + periodo + " materia " + Materia);
        List_Notas = Objeto_GestionNotas.GetRegistroNotas(Grado, periodo, Materia);
        System.out.println("###hay " + List_Notas.size());
        for (Modelo_GestionNotas item : List_Notas) {
            System.out.println("Notas ver 2 tareas " + item.getTareas().size() + " parcial " + item.getParcial() + " auto " + item.getAutoE());

            double prom = 0;
            for (int i = 0; i < 4; i++) {
                prom += item.getTareas().get(i) * .15;
                System.out.println("bien " + item.getTareas().get(i));
            }

            prom += item.getParcial() * .50;
            prom += item.getAutoE() * .10;

            modeloTabla.addRow(new Object[]{
                item.getNIE(),
                item.getApellido(),
                item.getNombre(),
                item.getTareas().get(0),
                item.getTareas().get(1),
                item.getTareas().get(2),
                item.getTareas().get(3),
                item.getParcial(),
                item.getAutoE(),
                Math.round(prom * 100.0) / 100.0
            });
        }

        tabla.setModel(modeloTabla);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_Regresar;
    private javax.swing.JComboBox<String> Cb_Grado;
    private javax.swing.JComboBox<String> Cb_Materias;
    private javax.swing.JComboBox<String> Cb_Periodo;
    private javax.swing.JLabel Lb_Aerolinea1;
    private javax.swing.JLabel Lb_MateriaGuia;
    private javax.swing.JLabel Lb_atras;
    private javax.swing.JTable Tbl_RegistroNotas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
