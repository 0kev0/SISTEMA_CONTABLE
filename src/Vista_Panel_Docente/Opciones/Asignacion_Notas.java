package Vista_Panel_Docente.Opciones;

import Customizacion.TablaCusomizada;
import Funciones.Funciones;
import Modelos.Docente.Modelo_AsignacionNotas;
import Modelos.Docente.Modelo_DocenteGuia;
import Modelos.Docente.Modelo_EstadoActividad;
import Modelos.Docente.Modelo_Grados;
import Modelos.Docente.Modelo_Periodos;
import Modelos.Docente.Modelo_TipoActividades;
import static Vista_Panel_Docente.Opciones.Asignacion_Actividades.Get_Cb_Grados;
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

public final class Asignacion_Notas extends javax.swing.JInternalFrame {

    public Asignacion_Notas() {
        initComponents();

    }

    private final Modelo_AsignacionNotas Objeto = new Modelo_AsignacionNotas();
    private List<Modelo_AsignacionNotas> ListObjeto;

    private final Modelo_EstadoActividad Objeto_EstadoActividad = new Modelo_EstadoActividad();
    private List<Modelo_EstadoActividad> List_EstadoActividad;

    private final Modelo_Periodos Objeto_Periodos = new Modelo_Periodos();
    private List<Modelo_Periodos> List_Periodos;

    private final Modelo_TipoActividades Objeto_TipoActividad = new Modelo_TipoActividades();
    private List<Modelo_TipoActividades> List_Modelo_TipoActividad;

    private DefaultTableModel modeloTabla = new DefaultTableModel();

    private final Modelo_Grados Objeto_Grados = new Modelo_Grados();
    private List<Modelo_Grados> List_Grados;

    private Modelo_DocenteGuia Objeto_Docente = new Modelo_DocenteGuia();
    private Asignacion_Notas objeto;
    private int grado;
    private String Materia;

    public Asignacion_Notas(Modelo_DocenteGuia docente) {
        initComponents();
        DiseñoTabla(Tbl_Actividades);
        Get_TipoActividad(Cb_TipoActividad);
        Get_Periodos(Cb_Periodo);
        Get_Cb_Grados(Cb_Grado, List_Grados, Objeto_Grados);
        Get_EstadosActividades(Cb_EstadoActividad);

        this.objeto = this;

        Cb_EstadoActividad.setSelectedIndex(1);

        Objeto_Docente = docente;

        this.grado = Objeto_Docente.getIdGradoGuia();
        this.Materia = Objeto_Docente.getMateriaImpartida();

        Lb_Materia_Grado.setText(docente.getMateriaImpartida() + " Grado: " + grado);

        System.out.println("docente " + docente.getNombres() + " grado " + docente.getIdGradoGuia() + " materia " + docente.getMateriaImpartida());
        Get_Tabla_NotaActividades_Todas(Tbl_Actividades);

        Tbl_Actividades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int COL = Tbl_Actividades.columnAtPoint(e.getPoint());
                int ROW = Tbl_Actividades.rowAtPoint(e.getPoint());

                if (COL == 9) {
                    String estado = modeloTabla.getValueAt(ROW, 6).toString();
                    // Check if the estado is "Pendiente"
                    if ("Pendiente".equals(estado)) {
                        int idActividad = Integer.parseInt(Tbl_Actividades.getValueAt(ROW, 0).toString());
                        int nie = Integer.parseInt(Tbl_Actividades.getValueAt(ROW, 1).toString());

                        String nombre = Tbl_Actividades.getValueAt(ROW, 2).toString();
                        String apellido = Tbl_Actividades.getValueAt(ROW, 3).toString();
                        int periodo = Integer.parseInt(Tbl_Actividades.getValueAt(ROW, 4).toString());
                        String actividad = Tbl_Actividades.getValueAt(ROW, 5).toString();
                        grado = Cb_Grado.getSelectedIndex() + 1;

                        Modelo_AsignacionNotas Objeto_AsignarNota = new Modelo_AsignacionNotas();
                        Objeto_AsignarNota.setApellidoEstudiante(apellido);
                        Objeto_AsignarNota.setNombreEstudiante(nombre);
                        Objeto_AsignarNota.setNombreActividad(actividad);
                        Objeto_AsignarNota.setNIE(nie);

                        System.out.println("a asignar nota para grado " + grado + " estudiante  "  + Objeto_AsignarNota.getEstadoActividad());
                        
                        Asignar_Nota notaObtenida = new Asignar_Nota(idActividad, periodo, grado, Objeto_AsignarNota, Tbl_Actividades, objeto);
                        notaObtenida.setVisible(true);

                        System.out.println("Editable column: " + COL);
                    } else {
                        Funciones.showMessageDialog("Problema", "Ya se a calificado la actividad.");
                    }
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Actividades = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Lb_Materia_Grado = new javax.swing.JLabel();
        Cb_TipoActividad = new javax.swing.JComboBox<>();
        Cb_Periodo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Lb_Aerolinea3 = new javax.swing.JLabel();
        Cb_EstadoActividad = new javax.swing.JComboBox<>();
        Btn_GuardarActividad = new javax.swing.JPanel();
        Lb_Guardar = new javax.swing.JLabel();
        Btn_LimpiarFiltros = new javax.swing.JPanel();
        Lb_LimpiarFiltros = new javax.swing.JLabel();
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
                "id", "NIE", "Nombres", "Apellidos", "Periodo", "Actividad", "Estado", "Ponderacion", "Nota", "Editar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_Actividades);
        if (Tbl_Actividades.getColumnModel().getColumnCount() > 0) {
            Tbl_Actividades.getColumnModel().getColumn(0).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(0).setPreferredWidth(70);
            Tbl_Actividades.getColumnModel().getColumn(1).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(1).setPreferredWidth(70);
            Tbl_Actividades.getColumnModel().getColumn(2).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(2).setPreferredWidth(200);
            Tbl_Actividades.getColumnModel().getColumn(3).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(3).setPreferredWidth(200);
            Tbl_Actividades.getColumnModel().getColumn(4).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(4).setPreferredWidth(70);
            Tbl_Actividades.getColumnModel().getColumn(5).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(5).setPreferredWidth(80);
            Tbl_Actividades.getColumnModel().getColumn(6).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(6).setPreferredWidth(80);
            Tbl_Actividades.getColumnModel().getColumn(7).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(7).setPreferredWidth(100);
            Tbl_Actividades.getColumnModel().getColumn(8).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(8).setPreferredWidth(80);
            Tbl_Actividades.getColumnModel().getColumn(9).setResizable(false);
            Tbl_Actividades.getColumnModel().getColumn(9).setPreferredWidth(60);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 850, 350));

        jPanel3.setBackground(new java.awt.Color(226, 215, 132));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 8, new java.awt.Color(255, 153, 51)));

        Lb_Materia_Grado.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Materia_Grado.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Materia_Grado.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Materia_Grado.setText("materia y grado");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lb_Materia_Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(14, Short.MAX_VALUE)
                    .addComponent(Lb_Materia_Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 260, -1));

        Cb_TipoActividad.setBackground(new java.awt.Color(224, 213, 170));
        Cb_TipoActividad.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_TipoActividad.setForeground(new java.awt.Color(0, 0, 0));
        Cb_TipoActividad.setToolTipText("");
        Cb_TipoActividad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Actividad:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_TipoActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_TipoActividadActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_TipoActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 160, -1));

        Cb_Periodo.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Periodo.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Periodo.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Periodo.setToolTipText("");
        Cb_Periodo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Periodo: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Periodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_PeriodoActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 160, -1));

        jPanel4.setBackground(new java.awt.Color(226, 215, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea2.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea2.setText("Asignacion de notas ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Aerolinea2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
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

        Cb_EstadoActividad.setBackground(new java.awt.Color(224, 213, 170));
        Cb_EstadoActividad.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_EstadoActividad.setForeground(new java.awt.Color(0, 0, 0));
        Cb_EstadoActividad.setToolTipText("");
        Cb_EstadoActividad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Estado actividad :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_EstadoActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_EstadoActividadActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_EstadoActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 160, -1));

        Btn_GuardarActividad.setBackground(new java.awt.Color(226, 215, 132));
        Btn_GuardarActividad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 8, 0, new java.awt.Color(255, 153, 51)));
        Btn_GuardarActividad.setEnabled(false);
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
        Lb_Guardar.setText("Cuadrar notas parciales");

        javax.swing.GroupLayout Btn_GuardarActividadLayout = new javax.swing.GroupLayout(Btn_GuardarActividad);
        Btn_GuardarActividad.setLayout(Btn_GuardarActividadLayout);
        Btn_GuardarActividadLayout.setHorizontalGroup(
            Btn_GuardarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_GuardarActividadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );
        Btn_GuardarActividadLayout.setVerticalGroup(
            Btn_GuardarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_GuardarActividadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(Btn_GuardarActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 530, 240, 50));

        Btn_LimpiarFiltros.setBackground(new java.awt.Color(226, 215, 132));
        Btn_LimpiarFiltros.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 8, 0, new java.awt.Color(255, 153, 51)));
        Btn_LimpiarFiltros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_LimpiarFiltrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_LimpiarFiltrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_LimpiarFiltrosMouseExited(evt);
            }
        });

        Lb_LimpiarFiltros.setBackground(new java.awt.Color(255, 255, 255));
        Lb_LimpiarFiltros.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        Lb_LimpiarFiltros.setForeground(new java.awt.Color(0, 0, 0));
        Lb_LimpiarFiltros.setText("Limpiar Filtros");

        javax.swing.GroupLayout Btn_LimpiarFiltrosLayout = new javax.swing.GroupLayout(Btn_LimpiarFiltros);
        Btn_LimpiarFiltros.setLayout(Btn_LimpiarFiltrosLayout);
        Btn_LimpiarFiltrosLayout.setHorizontalGroup(
            Btn_LimpiarFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_LimpiarFiltrosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Lb_LimpiarFiltros)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        Btn_LimpiarFiltrosLayout.setVerticalGroup(
            Btn_LimpiarFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_LimpiarFiltrosLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(Lb_LimpiarFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(Btn_LimpiarFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 140, 40));

        Cb_Grado.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Grado.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Grado.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Grado.setToolTipText("");
        Cb_Grado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Grados  a evaluar: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Grado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_GradoActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 160, -1));

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
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_GuardarActividadMouseClicked

    private void Btn_GuardarActividadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_GuardarActividadMouseEntered
        Funciones.EnterMouse(Btn_GuardarActividad, Lb_Guardar, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_GuardarActividadMouseEntered

    private void Btn_GuardarActividadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_GuardarActividadMouseExited
        Funciones.LeftMouse(Btn_GuardarActividad, Lb_Guardar, "#E2D784", "#000000");
    }//GEN-LAST:event_Btn_GuardarActividadMouseExited

    private void Cb_EstadoActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_EstadoActividadActionPerformed
        int id_IdEstado = Cb_EstadoActividad.getSelectedIndex() + 1;

        Get_Tabla_NotaActividades(Tbl_Actividades);


    }//GEN-LAST:event_Cb_EstadoActividadActionPerformed

    private void Cb_TipoActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_TipoActividadActionPerformed
        int id_TipoActividad = Cb_TipoActividad.getSelectedIndex() + 1;

        Get_Tabla_NotaActividades(Tbl_Actividades);


    }//GEN-LAST:event_Cb_TipoActividadActionPerformed

    private void Cb_PeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_PeriodoActionPerformed
        int id_periodo = Cb_Periodo.getSelectedIndex();

        if (id_periodo == 0) {
            Get_Tabla_NotaActividades(Tbl_Actividades);
            System.out.println("all");
        } else {
            Get_Tabla_NotaActividades(Tbl_Actividades);
        }

    }//GEN-LAST:event_Cb_PeriodoActionPerformed

    private void Btn_LimpiarFiltrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseClicked
        Cb_Periodo.setSelectedIndex(0);
        Cb_EstadoActividad.setSelectedIndex(0);
        Cb_TipoActividad.setSelectedIndex(0);

        Get_Tabla_NotaActividades_QuitarFiltros(Tbl_Actividades);

    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseClicked

    private void Btn_LimpiarFiltrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseEntered
        Funciones.EnterMouse(Btn_LimpiarFiltros, Lb_LimpiarFiltros, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseEntered

    private void Btn_LimpiarFiltrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseExited
        Funciones.LeftMouse(Btn_LimpiarFiltros, Lb_LimpiarFiltros, "#E2D784", "#000000");
    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseExited

    private void Cb_GradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_GradoActionPerformed
        grado = Cb_Grado.getSelectedIndex() + 1;
        Lb_Materia_Grado.setText(Materia + " Grado: " + grado);

        Get_Tabla_NotaActividades(Tbl_Actividades);
    }//GEN-LAST:event_Cb_GradoActionPerformed

    public void DiseñoTabla(JTable tabla) {
        tabla.setDefaultRenderer(Object.class,
                new TablaCusomizada());
        tabla.setRowHeight(50);
        tabla.getTableHeader().setBackground(Color.decode("#5C636E"));
        tabla.getTableHeader().setForeground(Color.white);
        Font fuente = new Font("Roboto", Font.BOLD, 12);
        tabla.setFont(fuente);
        tabla.getTableHeader().setFont(fuente);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < Tbl_Actividades.getColumnCount() - 1; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        tabla.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
        tabla.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);

        JTableHeader header = tabla.getTableHeader();

        header.setPreferredSize(new Dimension(60, 45));

    }

    public void Get_Tabla_NotaActividades(JTable tabla) {

        modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setNumRows(0);

        ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));
        int Grado = Cb_Grado.getSelectedIndex() + 1;
        int Periodo = Cb_Periodo.getSelectedIndex() + 1;
        int Actividad = Cb_TipoActividad.getSelectedIndex() + 1;
        int Estado = Cb_EstadoActividad.getSelectedIndex() + 1;

        System.out.println("consultando por grado " + Grado + " periodo " + Periodo + " iDestado " + Estado + " iDActividad " + Actividad);
        ListObjeto = Objeto.getListadoActividades(Grado, Periodo, Estado, Actividad);
        System.out.println("hay " + ListObjeto.size());

        for (Modelo_AsignacionNotas item : ListObjeto) {

            modeloTabla.addRow(new Object[]{
                item.getId_Actividad(),
                item.getNIE(),
                item.getNombreEstudiante(),
                item.getApellidoEstudiante(),
                item.getPeriodo(),
                item.getNombreActividad(),
                item.getEstadoActividad(),
                item.getPonderacion(),
                item.getNota(),
                new JLabel(iconoEditar)});
        }

        tabla.setModel(modeloTabla);
    }

    public void Get_Tabla_NotaActividades_Todas(JTable tabla) {

        modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setNumRows(0);

        ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));

        ListObjeto = Objeto.get_NotasTodos(grado);
        System.out.println("###buscar todo por grado " + grado + " hay " + ListObjeto.size());

        for (Modelo_AsignacionNotas item : ListObjeto) {

            modeloTabla.addRow(new Object[]{
                item.getId_Actividad(),
                item.getNIE(),
                item.getNombreEstudiante(),
                item.getApellidoEstudiante(),
                item.getPeriodo(),
                item.getNombreActividad(),
                item.getEstadoActividad(),
                item.getPonderacion(),
                item.getNota(),
                new JLabel(iconoEditar)});
        }

        tabla.setModel(modeloTabla);
    }

    public void Get_Tabla_NotaActividades_QuitarFiltros(JTable tabla) {

        modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setNumRows(0);

        ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));
        int Grado = Cb_Grado.getSelectedIndex() + 1;

        ListObjeto = Objeto.get_NotasTodos(Grado);
        System.out.println("hay " + ListObjeto.size());

        for (Modelo_AsignacionNotas item : ListObjeto) {

            modeloTabla.addRow(new Object[]{
                item.getId_Actividad(),
                item.getNIE(),
                item.getNombreEstudiante(),
                item.getApellidoEstudiante(),
                item.getPeriodo(),
                item.getNombreActividad(),
                item.getEstadoActividad(),
                item.getPonderacion(),
                item.getNota(),
                new JLabel(iconoEditar)});
        }

        tabla.setModel(modeloTabla);
    }

    public void Get_EstadosActividades(JComboBox ComboBox) {

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_EstadoActividad = Objeto_EstadoActividad.Get_EstadosActividades();
        System.out.println("hay " + List_EstadoActividad.size());

        for (Modelo_EstadoActividad item : List_EstadoActividad) {
            ModeloComboBox.addElement(item.getNombreMateria());
        }

        ComboBox.setModel(ModeloComboBox);
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

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_Modelo_TipoActividad = Objeto_TipoActividad.Get_EstadosActividades();
        System.out.println("hay " + List_Modelo_TipoActividad.size());

        for (Modelo_TipoActividades item : List_Modelo_TipoActividad) {
            ModeloComboBox.addElement(item.getTipoActividad());
        }

        ComboBox.setModel(ModeloComboBox);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_GuardarActividad;
    private javax.swing.JPanel Btn_LimpiarFiltros;
    private javax.swing.JComboBox<String> Cb_EstadoActividad;
    private javax.swing.JComboBox<String> Cb_Grado;
    private javax.swing.JComboBox<String> Cb_Periodo;
    private javax.swing.JComboBox<String> Cb_TipoActividad;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Aerolinea3;
    private javax.swing.JLabel Lb_Guardar;
    private javax.swing.JLabel Lb_LimpiarFiltros;
    private javax.swing.JLabel Lb_Materia_Grado;
    private javax.swing.JTable Tbl_Actividades;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
