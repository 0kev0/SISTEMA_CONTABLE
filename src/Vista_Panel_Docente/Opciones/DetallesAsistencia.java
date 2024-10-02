package Vista_Panel_Docente.Opciones;

import Customizacion.TablaCusomizada;
import static Funciones.Funciones.EnterMouse;
import static Funciones.Funciones.Get_MES_Actual;
import static Funciones.Funciones.LeftMouse;
import Modelos.Docente.Modelo_RegistroAsistencia;
import Modelos.Docente.Modelo_TipoAsistencia;
import Modelos.Secretaria.Modelo_Estudiante;
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

public final class DetallesAsistencia extends javax.swing.JFrame {
    
    private final Registro_Asistencia asist = new Registro_Asistencia();
    private Modelo_Estudiante estudiante = new Modelo_Estudiante();
    
    private final Modelo_TipoAsistencia ObjetoEstadoAsistencias = new Modelo_TipoAsistencia();
    private List<Modelo_TipoAsistencia> ListEstadosAsistencias;
    
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private List<Modelo_RegistroAsistencia> ListDetallesAsistencia;
    
    private Modelo_RegistroAsistencia objetoRegistro = new Modelo_RegistroAsistencia();
    private DetallesAsistencia Form;
    
    public DetallesAsistencia() {
        this.objetoRegistro = new Modelo_RegistroAsistencia();
        initComponents();
    }
    
    public DetallesAsistencia(List<Modelo_RegistroAsistencia> ListDetallesAsistencia_, Modelo_Estudiante DataEstudiante_) {
        initComponents();
        setLocationRelativeTo(this);
        
        int mesActual = Get_MES_Actual() - 1;
        this.Form = this;
        
        Lb_Info.setText("NIE : " + DataEstudiante_.getNIE());
        this.modeloTabla = (DefaultTableModel) Tbl_RegistroAsistencia.getModel();
        this.ListDetallesAsistencia = ListDetallesAsistencia_;
        this.estudiante = DataEstudiante_;
        Get_TipoAsistencias(Cb_Tipo);
        
        Cb_BuscarPorMes_.setSelectedIndex(mesActual);
        
        DiseñoTabla(Tbl_RegistroAsistencia);
        Cargar_Listado_Registro_Busqueda(Tbl_RegistroAsistencia);
        
        Tbl_RegistroAsistencia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int COL = Tbl_RegistroAsistencia.columnAtPoint(e.getPoint());
                int ROW = Tbl_RegistroAsistencia.rowAtPoint(e.getPoint());
                
                if (COL == 3) {
                    String asistencia = Tbl_RegistroAsistencia.getValueAt(ROW, 1).toString();
                    if (asistencia.equalsIgnoreCase("Ausente")) {
                        System.out.println("activa");
                        int MesActual = Get_MES_Actual();
                        int NIE = DataEstudiante_.getNIE();
                        int grado = estudiante.getId_Grado();
                        
                        Modelo_RegistroAsistencia EditarRegistro = new Modelo_RegistroAsistencia();
                        EditarRegistro = EditarRegistro.Get_DetalleAsistencia(NIE, grado, MesActual);
                        
                        Editar_Asistencia Edicion = new Editar_Asistencia(EditarRegistro, Tbl_RegistroAsistencia, Form);
                        Form.setVisible(false);
                        Edicion.setVisible(true);
                    }
                 
                }
            }
        });
    }
    
    public void Get_TipoAsistencias(JComboBox ComboBox) {
        
        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();
        
        ListEstadosAsistencias = ObjetoEstadoAsistencias.Get_EstadosAsistencias();
        System.out.println("hay " + ListEstadosAsistencias.size());
        
        for (Modelo_TipoAsistencia item : ListEstadosAsistencias) {
            ModeloComboBox.addElement(item.getEstadoAsistencia());
        }
        
        ComboBox.setModel(ModeloComboBox);
    }
    
    public void Cargar_Listado_Registro_Busqueda(JTable tabla) {
        int mes = Cb_BuscarPorMes_.getSelectedIndex() + 1;
        modeloTabla.setNumRows(0);
        
        System.out.println("buscando por mes : " + mes);
        System.out.println("Hay " + ListDetallesAsistencia.size() + " registros en la lista.");
        
        ImageIcon IconEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit.png"));
        
        for (Modelo_RegistroAsistencia item : ListDetallesAsistencia) {
            modeloTabla.addRow(new Object[]{
                item.getFecha(),
                item.getEstadoAsistencia(),
                item.getJustificacion(),
                new JLabel(IconEditar)});
            
        }
        
        tabla.setModel(modeloTabla);
    }
    
    public void Cargar_Listado_Registro_Busqueda_Detalles(JTable tabla) {
        int mes = Cb_BuscarPorMes_.getSelectedIndex() + 1;
        
        modeloTabla.setNumRows(0);
        
        ListDetallesAsistencia = objetoRegistro.Get_List_DetalleAsistencia(estudiante.getNIE(), estudiante.getId_Grado(), mes);
        System.out.println("Hay " + ListDetallesAsistencia.size() + " registros en la lista.");
        
        ImageIcon IconEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit.png"));
        
        for (Modelo_RegistroAsistencia item : ListDetallesAsistencia) {
            modeloTabla.addRow(new Object[]{
                item.getFecha(),
                item.getEstadoAsistencia(),
                item.getJustificacion(),
                new JLabel(IconEditar)});
            
        }
        
        tabla.setModel(modeloTabla);
    }
    
    public void Cargar_Listado_Registro_Busqueda_FiltradaTipo(JTable tabla) {
        int mes = Cb_BuscarPorMes_.getSelectedIndex() + 1;
        int Tipo = Cb_Tipo.getSelectedIndex() + 1;
        
        modeloTabla.setNumRows(0);
        
        ListDetallesAsistencia = objetoRegistro.Get_DetalleAsistencia_FiltroTipoAsistencia(estudiante.getNIE(), estudiante.getId_Grado(), mes, Tipo);
        System.out.println("Hay " + ListDetallesAsistencia.size() + " registros en la lista.");
        
        ImageIcon IconEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit.png"));
        
        for (Modelo_RegistroAsistencia item : ListDetallesAsistencia) {
            modeloTabla.addRow(new Object[]{
                item.getFecha(),
                item.getEstadoAsistencia(),
                item.getJustificacion(),
                new JLabel(IconEditar)});
            
        }
        
        tabla.setModel(modeloTabla);
    }
    
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
        
        tabla.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
        
        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(60, 45));
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_RegistroAsistencia = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Lb_Info = new javax.swing.JLabel();
        Lb_Info1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Lb_Aerolinea3 = new javax.swing.JLabel();
        Cb_Tipo = new javax.swing.JComboBox<>();
        Cb_BuscarPorMes_ = new javax.swing.JComboBox<>();
        Btn_LimpiarFiltros = new javax.swing.JPanel();
        Lb_LimpiarFiltros = new javax.swing.JLabel();
        Btn_Regresar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        Lb_Aerolinea7 = new javax.swing.JLabel();
        Lb_Ordenar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(234, 223, 180));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tbl_RegistroAsistencia.setAutoCreateRowSorter(true);
        Tbl_RegistroAsistencia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        Tbl_RegistroAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Asistencia", "justificacion", "Editar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_RegistroAsistencia);
        if (Tbl_RegistroAsistencia.getColumnModel().getColumnCount() > 0) {
            Tbl_RegistroAsistencia.getColumnModel().getColumn(0).setResizable(false);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(0).setPreferredWidth(100);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(1).setResizable(false);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(1).setPreferredWidth(200);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(2).setResizable(false);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(2).setPreferredWidth(200);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(3).setResizable(false);
            Tbl_RegistroAsistencia.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 600, 290));

        jPanel3.setBackground(new java.awt.Color(226, 215, 132));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 8, new java.awt.Color(255, 153, 51)));

        Lb_Info.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Info.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Info.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Info.setText("de: NIE");

        Lb_Info1.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Info1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Info1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Info1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lb_Info, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lb_Info, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lb_Info1))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 230, 50));

        jPanel4.setBackground(new java.awt.Color(226, 215, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea2.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea2.setText("Resumen de asistencias");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Aerolinea2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 6, 340, -1));

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

        Cb_Tipo.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Tipo.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Tipo.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Tipo.setToolTipText("");
        Cb_Tipo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Tipo Asistencia :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_TipoActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 134, -1));

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
        jPanel1.add(Cb_BuscarPorMes_, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 134, -1));

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
                .addContainerGap(26, Short.MAX_VALUE))
        );
        Btn_LimpiarFiltrosLayout.setVerticalGroup(
            Btn_LimpiarFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_LimpiarFiltrosLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(Lb_LimpiarFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(Btn_LimpiarFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 140, 40));

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

        jPanel1.add(Btn_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, -1, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cb_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_TipoActionPerformed
        Cargar_Listado_Registro_Busqueda_FiltradaTipo(Tbl_RegistroAsistencia);

    }//GEN-LAST:event_Cb_TipoActionPerformed

    private void Cb_BuscarPorMes_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_BuscarPorMes_ActionPerformed
        Cargar_Listado_Registro_Busqueda_Detalles(Tbl_RegistroAsistencia);
    }//GEN-LAST:event_Cb_BuscarPorMes_ActionPerformed

    private void Btn_LimpiarFiltrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseClicked
        asist.Cargar_Listado_Registro(Tbl_RegistroAsistencia);
    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseClicked

    private void Btn_LimpiarFiltrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseEntered
        EnterMouse(Btn_LimpiarFiltros, Lb_LimpiarFiltros, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseEntered

    private void Btn_LimpiarFiltrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseExited
        LeftMouse(Btn_LimpiarFiltros, Lb_LimpiarFiltros, "#E2D784", "#000000");
    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseExited

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
            new DetallesAsistencia().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_LimpiarFiltros;
    private javax.swing.JPanel Btn_Regresar;
    private javax.swing.JComboBox<String> Cb_BuscarPorMes_;
    private javax.swing.JComboBox<String> Cb_Tipo;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Aerolinea3;
    private javax.swing.JLabel Lb_Aerolinea7;
    private javax.swing.JLabel Lb_Info;
    private javax.swing.JLabel Lb_Info1;
    private javax.swing.JLabel Lb_LimpiarFiltros;
    private javax.swing.JLabel Lb_Ordenar;
    private javax.swing.JTable Tbl_RegistroAsistencia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
