package Vista_Panel_Docente.Opciones;

import Customizacion.TablaCusomizada;
import Funciones.Funciones;
import static Funciones.Funciones.clearScreen;
import Modelos.Docente.Modelo_Asignacion_Actividades;
import Modelos.Docente.Modelo_DocenteGuia;
import Modelos.Docente.Modelo_Grados;
import Modelos.Docente.Modelo_Materias;
import Modelos.Docente.Modelo_Periodos;
import Modelos.Docente.Modelo_TipoActividades;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class Asignacion_Actividades extends javax.swing.JInternalFrame {

    public Asignacion_Actividades() {
    }
    private final Modelo_Asignacion_Actividades Objeto_Actividades = new Modelo_Asignacion_Actividades();
    private List<Modelo_Asignacion_Actividades> List_Actividades;

    private Modelo_Materias Objeto_Modelo_Materias = new Modelo_Materias();
    private List<Modelo_Materias> List_Materias;

    private final Modelo_Periodos Objeto_Periodos = new Modelo_Periodos();
    private List<Modelo_Periodos> List_Periodos;

    private final Modelo_TipoActividades Objeto_TipoActividad = new Modelo_TipoActividades();
    private List<Modelo_TipoActividades> List_TipoActividad;

    private Modelo_DocenteGuia Objeto_Docente = new Modelo_DocenteGuia();

    private final Modelo_Grados Objeto_Grados = new Modelo_Grados();
    private List<Modelo_Grados> List_Grados;

    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private String materia;
    private int idmateria;
    private int Grado;

    public Asignacion_Actividades(Modelo_DocenteGuia DocenteGuia) {
        initComponents();
        clearScreen();

        this.idmateria = DocenteGuia.getIdMateriaImpartir();
        this.materia = DocenteGuia.getMateriaImpartida();
        Get_Cb_Grados(Cb_Grado, List_Grados, Objeto_Grados);
        Get_Periodos(Cb_Periodo);
        Get_TipoActividad(Cb_TipoActividad);

        Objeto_Docente = DocenteGuia;
        Grado = Objeto_Docente.getIdGradoGuia();
        System.out.println("docente guia " + Objeto_Docente.getNombres() + Objeto_Docente.getNIE() + Objeto_Docente.getIdGradoGuia());
        Lb_Materia_Periodo.setText(Objeto_Docente.getMateriaImpartida() + " " + Cb_Periodo.getSelectedItem().toString());

        DiseñoTabla(Tbl_Actividades);
        modeloTabla = (DefaultTableModel) Tbl_Actividades.getModel();

        Objeto_Modelo_Materias = Objeto_Modelo_Materias.Get_Materia(Objeto_Docente.getNIE());
        materia = Objeto_Modelo_Materias.getNombreMateria();

        Lb_Materia_Periodo.setText(materia + " Periodo: " + Cb_Periodo.getSelectedItem().toString());

        Get_Tbl_Actividades(Tbl_Actividades, Objeto_Docente.getMateriaImpartida(), Grado, 1);

        Tbl_Actividades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int COL = Tbl_Actividades.columnAtPoint(e.getPoint());
                int ROW = Tbl_Actividades.rowAtPoint(e.getPoint());
                int periodo = Cb_Periodo.getSelectedIndex() + 1;
                int grado = Cb_Grado.getSelectedIndex() + 1;

                if (COL == 6) {
                    int id = Integer.parseInt(modeloTabla.getValueAt(ROW, 0).toString());
                    System.out.println("id> " + id);
                    Funciones.showMessageDialog("Editar notas", "Se a habilitado editar la actividad, una vez editado vualva a presionar el icono ");
                    Edicion_Actividad editar = new Edicion_Actividad(Objeto_Actividades.GetActividad(Grado, id), materia,id, Tbl_Actividades, periodo, grado);
                    editar.setVisible(true);

                }

            }
        });
    }

    public static void Get_Cb_Grados(JComboBox ComboBox, List<Modelo_Grados> List_Grados, Modelo_Grados Objeto_Grados) {

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_Grados = Objeto_Grados.Get_Grados();
        System.out.println("hay " + List_Grados.size());

        for (Modelo_Grados item : List_Grados) {
            ModeloComboBox.addElement(item.getGrado());
        }

        ComboBox.setModel(ModeloComboBox);
    }

    public void Get_Tbl_Actividades(JTable tabla, String materia, int grado, int periodo) {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setNumRows(0);
        System.out.println("id mat : " + idmateria);

        List_Actividades = Objeto_Actividades.GetActividades(materia, grado, periodo);
        System.out.println("hay " + List_Actividades.size());

        ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));
        for (Modelo_Asignacion_Actividades item : List_Actividades) {

            modeloTabla.addRow(new Object[]{
                item.getIdActividad(),
                item.getPeriodo(),
                item.getNombreActividad(),
                item.getTipoActividad(),
                item.getDescripcion(),
                item.getPonderacion(),
                new JLabel(iconoEditar)});
        }

        tabla.setModel(modeloTabla);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Actividades = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Lb_Materia_Periodo = new javax.swing.JLabel();
        Cb_TipoActividad = new javax.swing.JComboBox<>();
        Cb_Periodo = new javax.swing.JComboBox<>();
        TB_NombreActividad = new javax.swing.JTextField();
        TB_DescripcionActividad = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        Btn_GuardarActividad = new javax.swing.JPanel();
        Lb_Guardar = new javax.swing.JLabel();
        Cb_Grado = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(153, 153, 153));
        setBorder(null);
        setTitle("Asignacion de actividades");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setEnabled(false);
        setFocusCycleRoot(false);
        setFocusable(false);
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jPanel1.setBackground(new java.awt.Color(234, 223, 180));
        jPanel1.setMinimumSize(new java.awt.Dimension(1160, 630));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tbl_Actividades.setAutoCreateRowSorter(true);
        Tbl_Actividades.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        Tbl_Actividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Periodo", "Nombre actividad", "Tipo", "Descripcion", "Ponderacion", "Editar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_Actividades);
        if (Tbl_Actividades.getColumnModel().getColumnCount() > 0) {
            Tbl_Actividades.getColumnModel().getColumn(0).setPreferredWidth(40);
            Tbl_Actividades.getColumnModel().getColumn(1).setPreferredWidth(40);
            Tbl_Actividades.getColumnModel().getColumn(2).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(2).setPreferredWidth(150);
            Tbl_Actividades.getColumnModel().getColumn(3).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(3).setPreferredWidth(100);
            Tbl_Actividades.getColumnModel().getColumn(4).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(4).setPreferredWidth(250);
            Tbl_Actividades.getColumnModel().getColumn(5).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(5).setPreferredWidth(100);
            Tbl_Actividades.getColumnModel().getColumn(6).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 800, 390));

        jPanel3.setBackground(new java.awt.Color(226, 215, 132));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 8, new java.awt.Color(255, 153, 51)));

        Lb_Materia_Periodo.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Materia_Periodo.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Materia_Periodo.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Materia_Periodo.setText("materia y periodo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Lb_Materia_Periodo, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addGap(39, 39, 39)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(14, Short.MAX_VALUE)
                    .addComponent(Lb_Materia_Periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 430, -1));

        Cb_TipoActividad.setBackground(new java.awt.Color(224, 213, 170));
        Cb_TipoActividad.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_TipoActividad.setForeground(new java.awt.Color(0, 0, 0));
        Cb_TipoActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarea", "Examen", "Auto-Evaluacion", "Expocicion" }));
        Cb_TipoActividad.setToolTipText("");
        Cb_TipoActividad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Tipo de actividad:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_TipoActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_TipoActividadActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_TipoActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 134, -1));

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
        jPanel1.add(Cb_Periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 134, -1));

        TB_NombreActividad.setBackground(new java.awt.Color(224, 213, 170));
        TB_NombreActividad.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_NombreActividad.setForeground(new java.awt.Color(0, 0, 0));
        TB_NombreActividad.setText("Ingrese el nombre");
        TB_NombreActividad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Nombre de la actividad", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        TB_NombreActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TB_NombreActividadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TB_NombreActividadMouseExited(evt);
            }
        });
        jPanel1.add(TB_NombreActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 208, 50));

        TB_DescripcionActividad.setBackground(new java.awt.Color(224, 213, 170));
        TB_DescripcionActividad.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_DescripcionActividad.setForeground(new java.awt.Color(0, 0, 0));
        TB_DescripcionActividad.setText("Ingrese descripcion");
        TB_DescripcionActividad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Descripcion de la actividad", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        TB_DescripcionActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TB_DescripcionActividadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TB_DescripcionActividadMouseExited(evt);
            }
        });
        jPanel1.add(TB_DescripcionActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 208, 50));

        jPanel4.setBackground(new java.awt.Color(226, 215, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea2.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea2.setText("Asignacion de actividades");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Aerolinea2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 370, -1));

        Btn_GuardarActividad.setBackground(new java.awt.Color(226, 215, 132));
        Btn_GuardarActividad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 8, 0, new java.awt.Color(255, 153, 51)));
        Btn_GuardarActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_GuardarActividadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_GuardarActividadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_GuardarActividadMouseExited(evt);
            }
        });

        Lb_Guardar.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Guardar.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Guardar.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Guardar.setText("Guardar actividad");

        javax.swing.GroupLayout Btn_GuardarActividadLayout = new javax.swing.GroupLayout(Btn_GuardarActividad);
        Btn_GuardarActividad.setLayout(Btn_GuardarActividadLayout);
        Btn_GuardarActividadLayout.setHorizontalGroup(
            Btn_GuardarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(Btn_GuardarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_GuardarActividadLayout.createSequentialGroup()
                    .addContainerGap(21, Short.MAX_VALUE)
                    .addComponent(Lb_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        Btn_GuardarActividadLayout.setVerticalGroup(
            Btn_GuardarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
            .addGroup(Btn_GuardarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_GuardarActividadLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lb_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(Btn_GuardarActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 200, 50));

        Cb_Grado.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Grado.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Grado.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Grado.setToolTipText("");
        Cb_Grado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Grados : ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Grado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_GradoActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, -1));

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

    private void Btn_GuardarActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_GuardarActividadMouseClicked
        String nobreActividad = TB_NombreActividad.getText();
        String descripcion = TB_DescripcionActividad.getText();

        int periodo = Cb_Periodo.getSelectedIndex() + 1;
        int TipoActividad = Cb_TipoActividad.getSelectedIndex() + 1;
        int grado = Cb_Grado.getSelectedIndex() + 1;

        System.out.println("/////////////////a asignar nota para grado " + grado + " estudiante  ");
        if (Funciones.validarCampos(jPanel1)) {

            if (Objeto_Actividades.ComprobarCant_Actividades(periodo, idmateria, TipoActividad)) {

                Modelo_Materias objMateria = new Modelo_Materias();
                int idMateria = objMateria.Get_IDMateria(materia, grado);

                Objeto_Actividades.setNombreActividad(nobreActividad);
                Objeto_Actividades.setDescripcion(descripcion);
                Objeto_Actividades.setIdTipoActividad(TipoActividad);
                Objeto_Actividades.setId_Materia(idMateria);
                Objeto_Actividades.setPeriodo(periodo);

                Objeto_Actividades.Insert_Actividad(Objeto_Actividades, grado);

                modeloTabla = (DefaultTableModel) Tbl_Actividades.getModel();
                modeloTabla.setNumRows(0);

                System.out.println("id mat : " + idmateria);
                List_Actividades = Objeto_Actividades.GetActividades_PorPeriodo(idmateria, periodo);
                System.out.println("hay " + List_Actividades.size());

                ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));
                for (Modelo_Asignacion_Actividades item : List_Actividades) {

                    modeloTabla.addRow(new Object[]{
                        item.getIdActividad(),
                        item.getPeriodo(),
                        item.getNombreActividad(),
                        item.getTipoActividad(),
                        item.getDescripcion(),
                        item.getPonderacion(),
                        new JLabel(iconoEditar)});
                }

                Tbl_Actividades.setModel(modeloTabla);
            }
        }


    }//GEN-LAST:event_Btn_GuardarActividadMouseClicked

    private void Btn_GuardarActividadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_GuardarActividadMouseEntered
        Funciones.EnterMouse(Btn_GuardarActividad, Lb_Guardar, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_GuardarActividadMouseEntered

    private void Btn_GuardarActividadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_GuardarActividadMouseExited
        Funciones.LeftMouse(Btn_GuardarActividad, Lb_Guardar, "#E2D784", "#000000");
    }//GEN-LAST:event_Btn_GuardarActividadMouseExited

    private void TB_NombreActividadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_NombreActividadMouseEntered
        Funciones.Mouse_EnterTextbox(TB_NombreActividad);
    }//GEN-LAST:event_TB_NombreActividadMouseEntered

    private void TB_DescripcionActividadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_DescripcionActividadMouseEntered
        Funciones.Mouse_EnterTextbox(TB_DescripcionActividad);
    }//GEN-LAST:event_TB_DescripcionActividadMouseEntered

    private void TB_DescripcionActividadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_DescripcionActividadMouseExited
        Funciones.Mouse_LeftTextbox("Ingrese descripcion", TB_DescripcionActividad);
    }//GEN-LAST:event_TB_DescripcionActividadMouseExited

    private void TB_NombreActividadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_NombreActividadMouseExited
        Funciones.Mouse_LeftTextbox("Ingrese nombre", TB_NombreActividad);
    }//GEN-LAST:event_TB_NombreActividadMouseExited

    private void Cb_PeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_PeriodoActionPerformed
        int periodo = Cb_Periodo.getSelectedIndex();
        int grado = Cb_Grado.getSelectedIndex();

        if (periodo == 0) {

            Get_Tbl_Actividades(Tbl_Actividades, materia, grado, periodo);
        } else {
            modeloTabla = (DefaultTableModel) Tbl_Actividades.getModel();
            modeloTabla.setNumRows(0);

            System.out.println("id mat : " + idmateria);
            List_Actividades = Objeto_Actividades.GetActividades_PorPeriodo(idmateria, periodo);
            System.out.println("hay " + List_Actividades.size());

            ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));
            for (Modelo_Asignacion_Actividades item : List_Actividades) {

                modeloTabla.addRow(new Object[]{
                    item.getIdActividad(),
                    item.getPeriodo(),
                    item.getNombreActividad(),
                    item.getTipoActividad(),
                    item.getDescripcion(),
                    item.getPonderacion(),
                    new JLabel(iconoEditar)});
            }

            Tbl_Actividades.setModel(modeloTabla);
        }
    }//GEN-LAST:event_Cb_PeriodoActionPerformed

    private void Cb_TipoActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_TipoActividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cb_TipoActividadActionPerformed

    private void Cb_GradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_GradoActionPerformed
        int grado = Cb_Grado.getSelectedIndex() + 1;
        int periodo = Cb_Periodo.getSelectedIndex() + 1;
        Get_Tbl_Actividades(Tbl_Actividades, materia, grado, periodo);

    }//GEN-LAST:event_Cb_GradoActionPerformed

    public void DiseñoTabla(JTable tabla) {
        tabla.setDefaultRenderer(Object.class,
                new TablaCusomizada());
        tabla.setRowHeight(40);
        tabla.getTableHeader().setBackground(Color.decode("#5C636E"));
        tabla.getTableHeader().setForeground(Color.white);
        Font fuente = new Font("Roboto", Font.BOLD, 12);
        tabla.setFont(fuente);
        tabla.getTableHeader().setFont(fuente);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        int numeroDeCeldas = Tbl_Actividades.getColumnCount(); // Cambia este valor al número de celdas que necesites

        for (int i = 0; i < numeroDeCeldas - 1; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        tabla.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
        tabla.getColumnModel().getColumn(4).setCellRenderer(leftRenderer);

        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(60, 45));

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_GuardarActividad;
    private javax.swing.JComboBox<String> Cb_Grado;
    private javax.swing.JComboBox<String> Cb_Periodo;
    private javax.swing.JComboBox<String> Cb_TipoActividad;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Guardar;
    private javax.swing.JLabel Lb_Materia_Periodo;
    private javax.swing.JTextField TB_DescripcionActividad;
    private javax.swing.JTextField TB_NombreActividad;
    private javax.swing.JTable Tbl_Actividades;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
