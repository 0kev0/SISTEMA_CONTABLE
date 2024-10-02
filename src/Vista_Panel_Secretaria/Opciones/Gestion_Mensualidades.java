package Vista_Panel_Secretaria.Opciones;

import Customizacion.TablaCusomizada;
import Funciones.Funciones;
import Modelos.Docente.Modelo_DocenteGuia;
import Modelos.Docente.Modelo_EstadoActividad;
import Modelos.Docente.Modelo_Grados;
import Modelos.Docente.Modelo_Periodos;
import Modelos.Docente.Modelo_TipoActividades;
import Modelos.Secretaria.Modelo_EstadoPago;
import Modelos.Secretaria.Modelo_Mensualidad;
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

public final class Gestion_Mensualidades extends javax.swing.JInternalFrame {

    private final Modelo_Mensualidad Mensualidad = new Modelo_Mensualidad();
    private List<Modelo_Mensualidad> ListMensualidades;

    private final Modelo_EstadoActividad Objeto_EstadoActividad = new Modelo_EstadoActividad();
    private List<Modelo_EstadoActividad> List_EstadoActividad;

    private final Modelo_Periodos Objeto_Periodos = new Modelo_Periodos();
    private List<Modelo_Periodos> List_Periodos;

    private final Modelo_TipoActividades Objeto_TipoActividad = new Modelo_TipoActividades();
    private List<Modelo_TipoActividades> List_Modelo_TipoActividad;

    private DefaultTableModel modeloTabla = new DefaultTableModel();

    private final Modelo_Grados Objeto_Grados = new Modelo_Grados();
    private List<Modelo_Grados> List_Grados;

    private final Modelo_EstadoPago Objeto_estado = new Modelo_EstadoPago();
    private List<Modelo_EstadoPago> List_estado;

    private Modelo_DocenteGuia Objeto_Docente = new Modelo_DocenteGuia();
    private Gestion_Mensualidades form;
    private int grado;
    private String Materia;

    public Gestion_Mensualidades() {
        initComponents();
        int mes = Funciones.Get_MES_Actual();
        int year = Funciones.Get_Year_Actual();

        DiseñoTabla(Tbl_Mensualidades);

        Get_Cb_Grados(Cb_Grado, List_Grados, Objeto_Grados);
        Get_Cb_Estados(Cb_EstadoPago, List_estado, Objeto_estado);

        Cb_Meses.setSelectedIndex(mes - 1);
        Lb_Materia_Grado.setText("Mes : " + Cb_Meses.getSelectedItem().toString() + " " + Cb_Grado.getSelectedItem().toString());

        this.grado = Objeto_Docente.getIdGradoGuia();
        this.Materia = Objeto_Docente.getMateriaImpartida();

        verificarTalonarioMensual();
        ValidarMensualidadesAtrasadas();
        Get_list_MesActual_Mensualidades(Tbl_Mensualidades);

        this.form = this;

        Tbl_Mensualidades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int COL = Tbl_Mensualidades.columnAtPoint(e.getPoint());
                int ROW = Tbl_Mensualidades.rowAtPoint(e.getPoint());
                if (COL == 9) {

                    String estado = modeloTabla.getValueAt(ROW, 6).toString();
                    // Check if the estado is "Pendiente"
                    if ("Pendiente".equals(estado)) {
                        int NIE = Integer.parseInt(Tbl_Mensualidades.getValueAt(ROW, 0).toString());
                        int mes = Integer.parseInt(Tbl_Mensualidades.getValueAt(ROW, 4).toString());
                        int grado = Integer.parseInt(Tbl_Mensualidades.getValueAt(ROW, 5).toString());
                        int year = Funciones.Get_Year_Actual();

                        Modelo_Mensualidad DatosMensualidad = new Modelo_Mensualidad();
                        DatosMensualidad = DatosMensualidad.Get_DatoMensualidad(year, mes, NIE, grado);

                        Efectuar_PagoMesnualidad PagoMensualidad = new Efectuar_PagoMesnualidad(DatosMensualidad, Tbl_Mensualidades, form);
                        PagoMensualidad.setVisible(true);

                        System.out.println("Editable column: " + COL);
                    } else {
                        Funciones.showMessageDialog("Problema", "Ya se ha cancelado este mes.");
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
        Tbl_Mensualidades = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Lb_Materia_Grado = new javax.swing.JLabel();
        Cb_EstadoPago = new javax.swing.JComboBox<>();
        Cb_Meses = new javax.swing.JComboBox<>();
        Btn_LimpiarFiltros = new javax.swing.JPanel();
        Lb_LimpiarFiltros = new javax.swing.JLabel();
        Cb_Grado = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setBorder(null);
        setTitle("Gestion Mensualidades");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setEnabled(false);
        setFocusCycleRoot(false);
        setFocusable(false);
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jPanel1.setBackground(new java.awt.Color(234, 223, 180));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tbl_Mensualidades.setAutoCreateRowSorter(true);
        Tbl_Mensualidades.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        Tbl_Mensualidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIE", "ResponsableA", "ResponsableB", "Estudiante", "Mes", "Grado", "Estado", "Mora", "Monto", "Pagar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_Mensualidades);
        if (Tbl_Mensualidades.getColumnModel().getColumnCount() > 0) {
            Tbl_Mensualidades.getColumnModel().getColumn(0).setResizable(false);
            Tbl_Mensualidades.getColumnModel().getColumn(0).setPreferredWidth(70);
            Tbl_Mensualidades.getColumnModel().getColumn(1).setResizable(false);
            Tbl_Mensualidades.getColumnModel().getColumn(1).setPreferredWidth(200);
            Tbl_Mensualidades.getColumnModel().getColumn(2).setResizable(false);
            Tbl_Mensualidades.getColumnModel().getColumn(2).setPreferredWidth(200);
            Tbl_Mensualidades.getColumnModel().getColumn(3).setResizable(false);
            Tbl_Mensualidades.getColumnModel().getColumn(3).setPreferredWidth(200);
            Tbl_Mensualidades.getColumnModel().getColumn(4).setResizable(false);
            Tbl_Mensualidades.getColumnModel().getColumn(4).setPreferredWidth(80);
            Tbl_Mensualidades.getColumnModel().getColumn(5).setResizable(false);
            Tbl_Mensualidades.getColumnModel().getColumn(5).setPreferredWidth(80);
            Tbl_Mensualidades.getColumnModel().getColumn(6).setResizable(false);
            Tbl_Mensualidades.getColumnModel().getColumn(6).setPreferredWidth(100);
            Tbl_Mensualidades.getColumnModel().getColumn(7).setResizable(false);
            Tbl_Mensualidades.getColumnModel().getColumn(7).setPreferredWidth(100);
            Tbl_Mensualidades.getColumnModel().getColumn(8).setResizable(false);
            Tbl_Mensualidades.getColumnModel().getColumn(8).setPreferredWidth(80);
            Tbl_Mensualidades.getColumnModel().getColumn(9).setResizable(false);
            Tbl_Mensualidades.getColumnModel().getColumn(9).setPreferredWidth(60);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 950, 430));

        jPanel3.setBackground(new java.awt.Color(226, 215, 132));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 8, new java.awt.Color(255, 153, 51)));

        Lb_Materia_Grado.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Materia_Grado.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Materia_Grado.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Materia_Grado.setText("Mes de talonario");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(Lb_Materia_Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Lb_Materia_Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 450, -1));

        Cb_EstadoPago.setBackground(new java.awt.Color(224, 213, 170));
        Cb_EstadoPago.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_EstadoPago.setForeground(new java.awt.Color(0, 0, 0));
        Cb_EstadoPago.setToolTipText("");
        Cb_EstadoPago.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Estado pago :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_EstadoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_EstadoPagoActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_EstadoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 160, -1));

        Cb_Meses.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Meses.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Meses.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Meses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julo", "Agosto", "Septiembre", "Octubre", "Novienmbre", "Diciembre" }));
        Cb_Meses.setToolTipText("");
        Cb_Meses.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Mes : ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Meses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_MesesActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Meses, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 160, -1));

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

        jPanel1.add(Btn_LimpiarFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 140, 40));

        Cb_Grado.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Grado.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Grado.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Grado.setToolTipText("");
        Cb_Grado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Grado :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Grado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_GradoActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 160, -1));

        jPanel4.setBackground(new java.awt.Color(226, 215, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea2.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea2.setText("Gestion Mensualidades");

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

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 6, 360, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1193, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cb_EstadoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_EstadoPagoActionPerformed
        Get_list_Filtrada_Mensualidades(Tbl_Mensualidades);
    }//GEN-LAST:event_Cb_EstadoPagoActionPerformed

    private void Cb_MesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_MesesActionPerformed
        Lb_Materia_Grado.setText("Mes : " + Cb_Meses.getSelectedItem().toString() + " " + Cb_Grado.getSelectedItem().toString());
        Get_list_Filtrada_Mensualidades(Tbl_Mensualidades);

    }//GEN-LAST:event_Cb_MesesActionPerformed

    private void Btn_LimpiarFiltrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseClicked
        Cb_Meses.setSelectedIndex(0);
        Cb_EstadoPago.setSelectedIndex(0);
        Cb_Grado.setSelectedIndex(0);

        Get_list_MesActual_Mensualidades(Tbl_Mensualidades);

    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseClicked

    private void Btn_LimpiarFiltrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseEntered
        Funciones.EnterMouse(Btn_LimpiarFiltros, Lb_LimpiarFiltros, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseEntered

    private void Btn_LimpiarFiltrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseExited
        Funciones.LeftMouse(Btn_LimpiarFiltros, Lb_LimpiarFiltros, "#E2D784", "#000000");
    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseExited

    private void Cb_GradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_GradoActionPerformed
        Lb_Materia_Grado.setText("Mes : " + Cb_Meses.getSelectedItem().toString() + " " + Cb_Grado.getSelectedItem().toString());
        Get_list_Filtrada_Mensualidades(Tbl_Mensualidades);

    }//GEN-LAST:event_Cb_GradoActionPerformed

    public void verificarTalonarioMensual() {
        // asignara el talonario de mensualidad del mes actual si no se a asignado ya
        int year = Funciones.Get_Year_Actual();
        int mes = Funciones.Get_MES_Actual();

        if (!Mensualidad.Validartalonario(mes)) {
            System.out.println("ingresando en mes " + mes + " year " + year);

            Modelo_Mensualidad Mesnualidad = new Modelo_Mensualidad();
            Mesnualidad.Insert_Mensualidad_MesActual(year, mes);
        }
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

    public static void Get_Cb_Estados(JComboBox ComboBox, List<Modelo_EstadoPago> List_Estados, Modelo_EstadoPago Objeto_Estado) {

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_Estados = Objeto_Estado.Get_Estados();
        System.out.println("hay " + List_Estados.size());

        for (Modelo_EstadoPago item : List_Estados) {
            ModeloComboBox.addElement(item.getEstadoMensualidad());
        }

        ComboBox.setModel(ModeloComboBox);
    }

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

        for (int i = 0; i < Tbl_Mensualidades.getColumnCount() - 1; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        tabla.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
        tabla.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);

        JTableHeader header = tabla.getTableHeader();

        header.setPreferredSize(new Dimension(60, 45));

    }

    public void Get_list_MesActual_Mensualidades(JTable tabla) {
        int year = Funciones.Get_Year_Actual();
        int mes = Funciones.Get_MES_Actual();

        modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setNumRows(0);

        ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/icono pago.png"));

        ListMensualidades = Mensualidad.Get_list_FechaActual_Mensualidades(year, mes);

        for (Modelo_Mensualidad item : ListMensualidades) {

            modeloTabla.addRow(new Object[]{
                item.getNIE(),
                item.getNombre_ResponsableA(),
                item.getNombre_ResponsableB(),
                item.getNombre_estudiante(),
                item.getMes(),
                item.getId_Grado(),
                item.getEstado(),
                item.getMora(),
                item.getMontoFinal(),
                new JLabel(iconoEditar)});
        }

        tabla.setModel(modeloTabla);
    }

    public void ValidarMensualidadesAtrasadas() {
        int mes = Funciones.Get_MES_Actual();
        int year = Funciones.Get_Year_Actual();

        System.out.println("######Verificando mensualidades atrasadas mes actual " + mes);
        Mensualidad.Edit_AtrasoMensualidad(year, mes);

    }

    public void Get_list_Filtrada_Mensualidades(JTable tabla) {

        modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setNumRows(0);

        ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/icono pago.png"));

        int GradoBuscar = Cb_Grado.getSelectedIndex() + 1;
        int estadoBuscar = Cb_EstadoPago.getSelectedIndex();
        int mesBuscar = Cb_Meses.getSelectedIndex() + 1;

        ListMensualidades = Mensualidad.Get_list_MensualidadesFiltrada(GradoBuscar, estadoBuscar, mesBuscar);

        for (Modelo_Mensualidad item : ListMensualidades) {

            modeloTabla.addRow(new Object[]{
                item.getNIE(),
                item.getNombre_ResponsableA(),
                item.getNombre_ResponsableB(),
                item.getNombre_estudiante(),
                item.getMes(),
                item.getId_Grado(),
                item.getEstado(),
                item.getMora(),
                item.getMontoFinal(),
                new JLabel(iconoEditar)});
        }

        tabla.setModel(modeloTabla);
    }

    public void Get_Tabla_NotaActividades_Filtrada(JTable tabla, int Criterio, String Parametro) {

//        int periodo = Cb_Periodo.getSelectedIndex();
//        modeloTabla = (DefaultTableModel) tabla.getModel();
//        modeloTabla.setNumRows(0);
//
//        ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));
//
//        ListObjeto = Objeto.get_ListadoActividades_Filtrada(Criterio, periodo, grado, Parametro);
//        System.out.println("hay " + ListObjeto.size());
//
//        for (Modelo_AsignacionNotas item : ListObjeto) {
//
//            modeloTabla.addRow(new Object[]{
//                item.getId_Actividad(),
//                item.getNIE(),
//                item.getNombreEstudiante(),
//                item.getApellidoEstudiante(),
//                item.getPeriodo(),
//                item.getNombreActividad(),
//                item.getEstadoActividad(),
//                item.getPonderacion(),
//                item.getNota(),
//                new JLabel(iconoEditar)});
//        }
//
//        tabla.setModel(modeloTabla);
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
    private javax.swing.JPanel Btn_LimpiarFiltros;
    private javax.swing.JComboBox<String> Cb_EstadoPago;
    private javax.swing.JComboBox<String> Cb_Grado;
    private javax.swing.JComboBox<String> Cb_Meses;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_LimpiarFiltros;
    private javax.swing.JLabel Lb_Materia_Grado;
    private javax.swing.JTable Tbl_Mensualidades;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
