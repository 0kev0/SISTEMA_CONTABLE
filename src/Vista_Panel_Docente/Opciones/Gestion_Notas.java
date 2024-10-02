package Vista_Panel_Docente.Opciones;

import Customizacion.TablaCusomizada;
import Funciones.Funciones;
import static Funciones.Funciones.ValidNIE;
import static Funciones.Funciones.ValidNombres;
import Modelos.Docente.Modelo_DocenteGuia;
import Modelos.Docente.Modelo_GestionNotas;
import Modelos.Docente.Modelo_Materias;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class Gestion_Notas extends javax.swing.JInternalFrame {

    public Gestion_Notas() {
        initComponents();

    }

    private final Modelo_GestionNotas Objeto_GestionNotas = new Modelo_GestionNotas();
    private List<Modelo_GestionNotas> List_Notas;

    private List<Modelo_Materias> List_Materias;
    private final Modelo_Materias Objeto_Modelo_Materias = new Modelo_Materias();

    private Modelo_DocenteGuia Objeto_Docente = new Modelo_DocenteGuia();
    private DefaultTableModel modeloTabla = new DefaultTableModel();

    private int Grado;
    private int idMateriaGuia;

    public Gestion_Notas(Modelo_DocenteGuia Docente) {
        initComponents();
        Objeto_Docente = Docente;

        System.out.println("grado del docente guia" + Objeto_Docente.getIdGradoGuia());
        Grado = Objeto_Docente.getIdGradoGuia();
        idMateriaGuia = Objeto_Docente.getIdMateriaImpartir();

        Get_ListMAterias(Cb_Materias);
        modeloTabla = (DefaultTableModel) Tbl_RegistroNotas.getModel();
        DiseñoTabla(Tbl_RegistroNotas);
        Get_ListadoNotas(Tbl_RegistroNotas, Grado, idMateriaGuia);
        Lb_MateriaGuia.setText(Objeto_Docente.getMateriaImpartida());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_RegistroNotas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Lb_Aerolinea1 = new javax.swing.JLabel();
        Cb_Busqueda = new javax.swing.JComboBox<>();
        Cb_Periodo = new javax.swing.JComboBox<>();
        TB_Buscar = new javax.swing.JTextField();
        errorTb_Busqueda = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Lb_MateriaGuia = new javax.swing.JLabel();
        Cb_Materias = new javax.swing.JComboBox<>();
        Btn_CuadrarNota = new javax.swing.JPanel();
        Lb_Guardar = new javax.swing.JLabel();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 1100, 340));

        jPanel3.setBackground(new java.awt.Color(226, 215, 132));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea1.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea1.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea1.setText("Registro de Notas de docente guia");

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

        Cb_Busqueda.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Busqueda.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Busqueda.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Busqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NIE", "Apellido", "Nombre" }));
        Cb_Busqueda.setToolTipText("");
        Cb_Busqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Buscar por: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_BusquedaActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 134, -1));

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
        jPanel1.add(Cb_Periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 130, 130, -1));

        TB_Buscar.setBackground(new java.awt.Color(224, 213, 170));
        TB_Buscar.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_Buscar.setForeground(new java.awt.Color(0, 0, 0));
        TB_Buscar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Buscar", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        TB_Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_BuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TB_BuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TB_BuscarMouseExited(evt);
            }
        });
        TB_Buscar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TB_BuscarInputMethodTextChanged(evt);
            }
        });
        TB_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TB_BuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TB_BuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TB_BuscarKeyTyped(evt);
            }
        });
        jPanel1.add(TB_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 208, 50));

        errorTb_Busqueda.setBackground(new java.awt.Color(23, 42, 56));
        errorTb_Busqueda.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        errorTb_Busqueda.setForeground(new java.awt.Color(234, 223, 180));
        errorTb_Busqueda.setText("Error");
        jPanel1.add(errorTb_Busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 280, -1));

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

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 320, -1));

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

        Btn_CuadrarNota.setBackground(new java.awt.Color(226, 215, 132));
        Btn_CuadrarNota.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 8, 0, new java.awt.Color(255, 153, 51)));
        Btn_CuadrarNota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_CuadrarNotaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_CuadrarNotaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_CuadrarNotaMouseExited(evt);
            }
        });

        Lb_Guardar.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Guardar.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Guardar.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Guardar.setText("Cuadrar Notas");

        javax.swing.GroupLayout Btn_CuadrarNotaLayout = new javax.swing.GroupLayout(Btn_CuadrarNota);
        Btn_CuadrarNota.setLayout(Btn_CuadrarNotaLayout);
        Btn_CuadrarNotaLayout.setHorizontalGroup(
            Btn_CuadrarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_CuadrarNotaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(Lb_Guardar)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        Btn_CuadrarNotaLayout.setVerticalGroup(
            Btn_CuadrarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_CuadrarNotaLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(Lb_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(Btn_CuadrarNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 560, 200, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String parametrobusqueda() {
        switch (Cb_Busqueda.getSelectedItem().toString()) {
            case "NIE" -> {
                System.out.println("NIE");
                return " TbEst.\"NIE\" ";

            }
            case "Apellido" -> {
                System.out.println("apellido");
                return " TbEst.\"Apellidos\"";

            }
            case "Nombre" -> {
                System.out.println("Nombres");
                return " TbEst.\"Nombres\"";

            }
            default ->
                throw new AssertionError();
        }
    }

    private void Cb_BusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_BusquedaActionPerformed
        int filtro = Cb_Materias.getSelectedIndex();

        List_Materias = Objeto_Modelo_Materias.GetListadoMaterias(Grado);

        String materiaSeleccionada = List_Materias.get(filtro).getNombreMateria();
        int Id_materiaSeleccionada = List_Materias.get(filtro).getidMateria();

        Lb_MateriaGuia.setText(materiaSeleccionada);
        Get_ListadoNotas_Materia(Tbl_RegistroNotas, Id_materiaSeleccionada);

        switch (Cb_Busqueda.getSelectedItem().toString()) {
            case "NIE" -> {

                TB_Buscar.setToolTipText("Introduzca NIE");
                Get_ListadoNotas(Tbl_RegistroNotas, Grado, Id_materiaSeleccionada);
                TB_Buscar.setText("Ingrese NIE");

            }

            case "Apellido" -> {

                TB_Buscar.setToolTipText("Introduzca NIE");
                Get_ListadoNotas(Tbl_RegistroNotas, Grado, Id_materiaSeleccionada);
                TB_Buscar.setText("Ingrese Apellido");

            }
            case "Nombre" -> {

                TB_Buscar.setToolTipText("Introduzca NIE");
                Get_ListadoNotas(Tbl_RegistroNotas, Grado, Id_materiaSeleccionada);
                TB_Buscar.setText("Ingrese Nombre");

            }
            default ->
                throw new AssertionError();
        }

    }//GEN-LAST:event_Cb_BusquedaActionPerformed

    private void TB_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_BuscarKeyReleased
        String Palabra = TB_Buscar.getText();

        System.out.println("#######################palabra es " + Palabra);

        String ParametroBusqueda = parametrobusqueda();
        int i = Cb_Busqueda.getSelectedIndex();
        System.out.println("INDICE " + i);

        int filtro = Cb_Materias.getSelectedIndex();

        List_Materias = Objeto_Modelo_Materias.GetListadoMaterias(Grado);

        String materiaSeleccionada = List_Materias.get(filtro).getNombreMateria();
        int Id_materiaSeleccionada = List_Materias.get(filtro).getidMateria();

        Lb_MateriaGuia.setText(materiaSeleccionada);
        Get_ListadoNotas_Materia(Tbl_RegistroNotas, Id_materiaSeleccionada);

        switch (i) {
            case 0 ->
                ValidNIE(TB_Buscar, errorTb_Busqueda);
            case 1 ->
                ValidNombres(TB_Buscar, errorTb_Busqueda);
            case 2 ->
                ValidNombres(TB_Buscar, errorTb_Busqueda);

            default ->
                throw new AssertionError();
        }

        if (Palabra.equals("")) {
            Get_ListadoNotas(Tbl_RegistroNotas, Grado, Id_materiaSeleccionada);
            Funciones.clearScreen();

        } else {

            int periodo = Cb_Periodo.getSelectedIndex() + 1;
            modeloTabla.setNumRows(0);

            System.out.println("buscando periodo: " + periodo + " y parametro: " + ParametroBusqueda);

            List<Modelo_GestionNotas> obj;

            List_Notas = Objeto_GestionNotas.Get_Busqueda(Palabra, ParametroBusqueda, periodo, 1, 1);

            try {
                int size = List_Notas.size();
                System.out.println("*** *** ***hay " + size);

                for (Modelo_GestionNotas item : List_Notas) {

                    double prom = 0;
                    for (int y = 0; y < 4; y++) {
                        prom += item.getNotas().get(y) * .10;
                    }
                    prom += item.getNotas().get(4) * .50;
                    prom += item.getNotas().get(5) * .10;

                    modeloTabla.addRow(new Object[]{
                        item.getNIE(),
                        item.getApellido(),
                        item.getNombre(),
                        item.getNotas().get(0),
                        item.getNotas().get(1),
                        item.getNotas().get(2),
                        item.getNotas().get(3),
                        item.getNotas().get(4),
                        item.getNotas().get(5),
                        Math.round(prom * 100.0) / 100.0
                    });
                }

                Tbl_RegistroNotas.setModel(modeloTabla);
            } catch (Error ex) {
                System.out.println("$$$La lista obtenida esta vacia");
            } catch (IndexOutOfBoundsException err) {
                System.out.println("$$$Indice fuera del tamaño de la lista.");

            }
        }

    }//GEN-LAST:event_TB_BuscarKeyReleased

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

    private void TB_BuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_BuscarKeyTyped


    }//GEN-LAST:event_TB_BuscarKeyTyped

    private void TB_BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_BuscarMouseEntered
        Funciones.Mouse_EnterTextbox(TB_Buscar);
    }//GEN-LAST:event_TB_BuscarMouseEntered

    public void Get_ListMAterias(JComboBox ComboBox) {

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_Materias = Objeto_Modelo_Materias.GetListadoMaterias(Grado);
        System.out.println("hay " + List_Materias.size());

        for (Modelo_Materias item : List_Materias) {
            ModeloComboBox.addElement(item.getNombreMateria());
        }

        ComboBox.setModel(ModeloComboBox);
    }

    private void TB_BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_BuscarMouseExited
        if (TB_Buscar.getText().isBlank()) {
            switch (Cb_Busqueda.getSelectedIndex()) {
                case 0 -> {
                    Funciones.Mouse_LeftTextbox("Ingrese " + Cb_Busqueda.getItemAt(0), TB_Buscar);

                }

                case 1 -> {
                    Funciones.Mouse_LeftTextbox("Ingrese " + Cb_Busqueda.getItemAt(1), TB_Buscar);

                }
                case 2 -> {
                    Funciones.Mouse_LeftTextbox("Ingrese " + Cb_Busqueda.getItemAt(2), TB_Buscar);

                }
                default ->
                    throw new AssertionError();
            }
        }

    }//GEN-LAST:event_TB_BuscarMouseExited

    private void Cb_MateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_MateriasActionPerformed
        int filtro = Cb_Materias.getSelectedIndex();

        List_Materias = Objeto_Modelo_Materias.GetListadoMaterias(Grado);

        String materiaSeleccionada = List_Materias.get(filtro).getNombreMateria();
        int Id_materiaSeleccionada = List_Materias.get(filtro).getidMateria();

        Lb_MateriaGuia.setText(materiaSeleccionada);
        Get_ListadoNotas_Materia(Tbl_RegistroNotas, Id_materiaSeleccionada);


    }//GEN-LAST:event_Cb_MateriasActionPerformed

    private void TB_BuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_BuscarKeyPressed


    }//GEN-LAST:event_TB_BuscarKeyPressed

    private void TB_BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_BuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TB_BuscarMouseClicked

    private void TB_BuscarInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TB_BuscarInputMethodTextChanged

    }//GEN-LAST:event_TB_BuscarInputMethodTextChanged

    private void Btn_CuadrarNotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_CuadrarNotaMouseClicked
        Boolean validarNotasCalificadas = false;
        ArrayList<Integer> NIES = new ArrayList<>();
        ArrayList<Double> NOTAS = new ArrayList<>();

        int Periodo = Cb_Periodo.getSelectedIndex()+1;
        
        for (int i = 0 ; i < Tbl_RegistroNotas.getRowCount(); i++) {
            int NIE = Integer.parseInt(Tbl_RegistroNotas.getValueAt(i, 0).toString());
            double NOTAfINAL = Double.parseDouble(Tbl_RegistroNotas.getValueAt(i, 9).toString());
            NIES.add(NIE);
            NOTAS.add(NOTAfINAL);

        }

        try {
            validarNotasCalificadas = Objeto_GestionNotas.vALIDAR_nOTAS(NIES, Periodo, Grado);
        } catch (SQLException ex) {
            Logger.getLogger(Gestion_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (validarNotasCalificadas) {
            try {
            Funciones.showMessageDialog("info", "Cuadrando notas.");
                Objeto_GestionNotas.UPDATE_CuadrarNotasPeriodo(NIES, Periodo, idMateriaGuia, NOTAS);
            } catch (SQLException ex) {
                Logger.getLogger(Gestion_Notas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            Funciones.showMessageDialog("info", "hay ctividades pendientes de calificar.");
        }


    }//GEN-LAST:event_Btn_CuadrarNotaMouseClicked

    private void Btn_CuadrarNotaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_CuadrarNotaMouseEntered
        Funciones.EnterMouse(Btn_CuadrarNota, Lb_Guardar, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_CuadrarNotaMouseEntered

    private void Btn_CuadrarNotaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_CuadrarNotaMouseExited
        Funciones.LeftMouse(Btn_CuadrarNota, Lb_Guardar, "#E2D784", "#000000");
    }//GEN-LAST:event_Btn_CuadrarNotaMouseExited

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
    private javax.swing.JPanel Btn_CuadrarNota;
    private javax.swing.JComboBox<String> Cb_Busqueda;
    private javax.swing.JComboBox<String> Cb_Materias;
    private javax.swing.JComboBox<String> Cb_Periodo;
    private javax.swing.JLabel Lb_Aerolinea1;
    private javax.swing.JLabel Lb_Guardar;
    private javax.swing.JLabel Lb_MateriaGuia;
    private javax.swing.JTextField TB_Buscar;
    private javax.swing.JTable Tbl_RegistroNotas;
    private javax.swing.JLabel errorTb_Busqueda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
