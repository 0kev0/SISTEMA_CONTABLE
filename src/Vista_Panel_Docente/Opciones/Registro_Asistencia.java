package Vista_Panel_Docente.Opciones;

import Customizacion.TablaCusomizada;
import Funciones.Funciones;
import Modelos.Docente.Modelo_DocenteGuia;
import Modelos.Docente.Modelo_RegistroAsistencia;
import Modelos.Secretaria.Modelo_Estudiante;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class Registro_Asistencia extends javax.swing.JInternalFrame {
    
    private final Modelo_RegistroAsistencia Objeto = new Modelo_RegistroAsistencia();
    private List<Modelo_RegistroAsistencia> ListObjeto;
    
    private List<Modelo_RegistroAsistencia> ListDetallesAsistencia;
    
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private int Grado;
    
    public Registro_Asistencia() {
        
    }
    
    public Registro_Asistencia(Modelo_DocenteGuia docente) {
        initComponents();
        this.Grado = docente.getIdGradoGuia();
        int mesActual = Funciones.Get_MES_Actual()-1;
        
        modeloTabla = (DefaultTableModel) Tbl_RegistroAsistencia.getModel();
        DiseñoTabla(Tbl_RegistroAsistencia);
        Cargar_Listado_Registro(Tbl_RegistroAsistencia);
        System.out.println("mes num" + mesActual);
        Cb_BuscarPorMes_.setSelectedIndex(mesActual);
        Tbl_RegistroAsistencia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int COL = Tbl_RegistroAsistencia.columnAtPoint(e.getPoint());
                int ROW = Tbl_RegistroAsistencia.rowAtPoint(e.getPoint());
                
                if (COL == 6) {
                    int NIE = Integer.parseInt(Tbl_RegistroAsistencia.getValueAt(ROW, 0).toString());
                    int Mes = Funciones.Get_MES_Actual();
                    int year = Funciones.Get_Year_Actual();
                    
                    Modelo_RegistroAsistencia registro = new Modelo_RegistroAsistencia();
                    ListDetallesAsistencia = registro.Get_List_DetalleAsistencia(NIE, Grado, Mes);
                    System.out.println("hay > " + ListDetallesAsistencia.size());
                    
                    Modelo_Estudiante DataEstudiante = new Modelo_Estudiante();
                    DataEstudiante = DataEstudiante.Get_DataEstudiante(NIE);
                    
                    DetallesAsistencia RESUMEN = new DetallesAsistencia(ListDetallesAsistencia, DataEstudiante);
                    RESUMEN.setVisible(true);
                    
                }
            }
        });
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_RegistroAsistencia = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Lb_Aerolinea1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Lb_Aerolinea3 = new javax.swing.JLabel();
        Cb_Dia = new javax.swing.JComboBox<>();
        Cb_Año = new javax.swing.JComboBox<>();
        Cb_BuscarPorMes_ = new javax.swing.JComboBox<>();
        Btn_LimpiarFiltros = new javax.swing.JPanel();
        Lb_LimpiarFiltros = new javax.swing.JLabel();

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
        jPanel1.setPreferredSize(new java.awt.Dimension(1160, 630));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tbl_RegistroAsistencia.setAutoCreateRowSorter(true);
        Tbl_RegistroAsistencia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        Tbl_RegistroAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIE", "Nombres", "Apellidos", "Asistencia", "Fallas", "Fallas justificadas", "Detalles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_RegistroAsistencia);
        if (Tbl_RegistroAsistencia.getColumnModel().getColumnCount() > 0) {
            Tbl_RegistroAsistencia.getColumnModel().getColumn(0).setResizable(false);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(0).setPreferredWidth(80);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(1).setResizable(false);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(1).setPreferredWidth(250);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(2).setResizable(false);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(2).setPreferredWidth(250);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(3).setResizable(false);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(3).setPreferredWidth(80);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(4).setResizable(false);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(4).setPreferredWidth(80);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(5).setResizable(false);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(5).setPreferredWidth(80);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 1000, 350));

        jPanel3.setBackground(new java.awt.Color(226, 215, 132));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 8, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea1.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea1.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea1.setText("Fecha");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lb_Aerolinea1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(104, 104, 104)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(14, Short.MAX_VALUE)
                    .addComponent(Lb_Aerolinea1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 180, -1));

        jPanel4.setBackground(new java.awt.Color(226, 215, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea2.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea2.setText("Registro Asistencia");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Aerolinea2)
                .addContainerGap(31, Short.MAX_VALUE))
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

        Cb_Dia.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Dia.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Dia.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        Cb_Dia.setToolTipText("");
        Cb_Dia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Dia :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_DiaActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 134, -1));

        Cb_Año.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Año.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Año.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Año.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025", "2026" }));
        Cb_Año.setToolTipText("");
        Cb_Año.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Año :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.add(Cb_Año, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 134, -1));

        Cb_BuscarPorMes_.setBackground(new java.awt.Color(224, 213, 170));
        Cb_BuscarPorMes_.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_BuscarPorMes_.setForeground(new java.awt.Color(0, 0, 0));
        Cb_BuscarPorMes_.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        Cb_BuscarPorMes_.setToolTipText("");
        Cb_BuscarPorMes_.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Mes :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_BuscarPorMes_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_BuscarPorMes_ActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_BuscarPorMes_, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 134, -1));

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

        jPanel1.add(Btn_LimpiarFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cb_BuscarPorMes_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_BuscarPorMes_ActionPerformed
        Cargar_Listado_Registro_Busqueda(Tbl_RegistroAsistencia);
    }//GEN-LAST:event_Cb_BuscarPorMes_ActionPerformed

    private void Cb_DiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_DiaActionPerformed
        Cargar_Listado_Registro_Busqueda_dia(Tbl_RegistroAsistencia);

    }//GEN-LAST:event_Cb_DiaActionPerformed

    private void Btn_LimpiarFiltrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseClicked
        Cargar_Listado_Registro(Tbl_RegistroAsistencia);
    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseClicked

    private void Btn_LimpiarFiltrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseEntered
        Funciones.EnterMouse(Btn_LimpiarFiltros, Lb_LimpiarFiltros, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseEntered

    private void Btn_LimpiarFiltrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseExited
        Funciones.LeftMouse(Btn_LimpiarFiltros, Lb_LimpiarFiltros, "#E2D784", "#000000");
    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseExited
    
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
        
        int numeroDeCeldas = Tbl_RegistroAsistencia.getColumnCount() - 1; // Cambia este valor al número de celdas que necesites

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
    
    public void Cargar_Listado_Registro(JTable tabla) {
        modeloTabla.setNumRows(0);
        
        ListObjeto = Objeto.GetListado(Grado);
        System.out.println("Hay " + ListObjeto.size() + " registros en la lista.");
        
        ImageIcon VerDetalles = new ImageIcon(getClass().getResource("/Imagenes/VerDetalles.png"));
        
        for (Modelo_RegistroAsistencia item : ListObjeto) {
            modeloTabla.addRow(new Object[]{
                item.getNIE(),
                item.getNombreEstudiante(),
                item.getApellidoEstudiante(),
                item.getCantAsistencias(),
                item.getCantAusencias(),
                item.getCantAusenciaJustificadas(),
                new JLabel(VerDetalles)});
        }
        
        tabla.setModel(modeloTabla);
    }
    
    public void Cargar_Listado_Registro_Busqueda(JTable tabla) {
        int mes = Cb_BuscarPorMes_.getSelectedIndex() + 1;
        int Year = Integer.parseInt(Cb_Año.getSelectedItem().toString());
        modeloTabla.setNumRows(0);
        
        System.out.println("buscando por año: " + Year + "  por mes : " + mes);
        ListObjeto = Objeto.GetListadoCustom(1, mes, Year);
        System.out.println("Hay " + ListObjeto.size() + " registros en la lista.");
        
        ImageIcon VerDetalles = new ImageIcon(getClass().getResource("/Imagenes/VerDetalles.png"));
        
        for (Modelo_RegistroAsistencia item : ListObjeto) {
            modeloTabla.addRow(new Object[]{
                item.getNIE(),
                item.getNombreEstudiante(),
                item.getApellidoEstudiante(),
                item.getCantAsistencias(),
                item.getCantAusencias(),
                item.getCantAusenciaJustificadas(),
                new JLabel(VerDetalles)});
        }
        
        tabla.setModel(modeloTabla);
    }
    
    public void Cargar_Listado_Registro_Busqueda_dia(JTable tabla) {
        int mes = Cb_BuscarPorMes_.getSelectedIndex() + 1;
        int Year = Integer.parseInt(Cb_Año.getSelectedItem().toString());
        int dia = Integer.parseInt(Cb_Dia.getSelectedItem().toString());
        
        modeloTabla.setNumRows(0);
        
        System.out.println("buscando por año: " + Year + "  por mes : " + mes + " por dia: " + dia);
        ListObjeto = Objeto.GetListadoCustom_dia(Grado, dia, mes, Year);
        System.out.println("Hay " + ListObjeto.size() + " registros en la lista.");
        
        ImageIcon VerDetalles = new ImageIcon(getClass().getResource("/Imagenes/VerDetalles.png"));
        
        for (Modelo_RegistroAsistencia item : ListObjeto) {
            modeloTabla.addRow(new Object[]{
                item.getNIE(),
                item.getNombreEstudiante(),
                item.getApellidoEstudiante(),
                item.getCantAsistencias(),
                item.getCantAusencias(),
                item.getCantAusenciaJustificadas(),
                new JLabel(VerDetalles)});
        }
        
        tabla.setModel(modeloTabla);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_LimpiarFiltros;
    private javax.swing.JComboBox<String> Cb_Año;
    private javax.swing.JComboBox<String> Cb_BuscarPorMes_;
    private javax.swing.JComboBox<String> Cb_Dia;
    private javax.swing.JLabel Lb_Aerolinea1;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Aerolinea3;
    private javax.swing.JLabel Lb_LimpiarFiltros;
    private javax.swing.JTable Tbl_RegistroAsistencia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
