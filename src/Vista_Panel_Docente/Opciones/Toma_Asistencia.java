package Vista_Panel_Docente.Opciones;

import Customizacion.TablaCusomizada;
import Funciones.Funciones;
import static Funciones.Funciones.clearScreen;
import static Funciones.Funciones.showMessageDialog;
import Modelos.Docente.Modelo_DocenteGuia;
import Modelos.Docente.Modelo_TomaAsistencia;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class Toma_Asistencia extends javax.swing.JInternalFrame {

    public Toma_Asistencia() {

    }
    private final Modelo_TomaAsistencia Objeto = new Modelo_TomaAsistencia();
    private List<Modelo_TomaAsistencia> ListObjeto;
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private int Grado;

    public Toma_Asistencia(Modelo_DocenteGuia docente) {
        clearScreen();
        initComponents();
        this.Grado = docente.getIdGradoGuia();
        
        DiseñoTabla(Tbl_ListadoAsistencia);
        get_TblAsistencia(Tbl_ListadoAsistencia);
        Lb_FechaActual.setText(Funciones.obtenerFechaActual());
        modeloTabla = (DefaultTableModel) Tbl_ListadoAsistencia.getModel();

        Tbl_ListadoAsistencia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int COL = Tbl_ListadoAsistencia.columnAtPoint(e.getPoint());
                int ROW = Tbl_ListadoAsistencia.rowAtPoint(e.getPoint());

                if (COL >= 3 && COL <= 5) {
                    for (int col = 3; col <= 5; col++) {
                        // Si no es la columna actual (entre 3 y 5), establece el valor en "false"
                        if (col != COL) {
                            modeloTabla.setValueAt(false, ROW, col);
                        }
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
        Tbl_ListadoAsistencia = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Lb_FechaActual = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Lb_Aerolinea3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Lb_Aerolinea4 = new javax.swing.JLabel();

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
        jPanel1.setMaximumSize(new java.awt.Dimension(1160, 630));
        jPanel1.setMinimumSize(new java.awt.Dimension(1160, 630));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tbl_ListadoAsistencia.setAutoCreateRowSorter(true);
        Tbl_ListadoAsistencia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        Tbl_ListadoAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIE", "Nombres", "Apellidos", "Presente", "Ausente", "Justificado", "Justificacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_ListadoAsistencia);
        if (Tbl_ListadoAsistencia.getColumnModel().getColumnCount() > 0) {
            Tbl_ListadoAsistencia.getColumnModel().getColumn(0).setResizable(false);
            Tbl_ListadoAsistencia.getColumnModel().getColumn(0).setPreferredWidth(80);
            Tbl_ListadoAsistencia.getColumnModel().getColumn(1).setResizable(false);
            Tbl_ListadoAsistencia.getColumnModel().getColumn(1).setPreferredWidth(200);
            Tbl_ListadoAsistencia.getColumnModel().getColumn(2).setResizable(false);
            Tbl_ListadoAsistencia.getColumnModel().getColumn(2).setPreferredWidth(200);
            Tbl_ListadoAsistencia.getColumnModel().getColumn(3).setPreferredWidth(80);
            Tbl_ListadoAsistencia.getColumnModel().getColumn(4).setResizable(false);
            Tbl_ListadoAsistencia.getColumnModel().getColumn(5).setResizable(false);
            Tbl_ListadoAsistencia.getColumnModel().getColumn(5).setPreferredWidth(80);
            Tbl_ListadoAsistencia.getColumnModel().getColumn(6).setResizable(false);
            Tbl_ListadoAsistencia.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 1040, 350));

        jPanel3.setBackground(new java.awt.Color(226, 215, 132));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 8, new java.awt.Color(255, 153, 51)));

        Lb_FechaActual.setBackground(new java.awt.Color(255, 255, 255));
        Lb_FechaActual.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Lb_FechaActual.setForeground(new java.awt.Color(0, 0, 0));
        Lb_FechaActual.setText("Fecha");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Lb_FechaActual, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(Lb_FechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 340, -1));

        jPanel4.setBackground(new java.awt.Color(226, 215, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea2.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea2.setText("Toma de Asistencia");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Aerolinea2)
                .addContainerGap(29, Short.MAX_VALUE))
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

        jPanel6.setBackground(new java.awt.Color(226, 215, 132));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 8, 0, new java.awt.Color(255, 153, 51)));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        Lb_Aerolinea4.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea4.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Aerolinea4.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea4.setText("Confirmar asistencia");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(10, Short.MAX_VALUE)
                    .addComponent(Lb_Aerolinea4)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lb_Aerolinea4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 550, 200, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked

        try {
            clearScreen();
            Date fecha = new Date();
            boolean all_fine = false;

            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                boolean columnaSeleccionada = false; // Verificar que la columna fue seleccionada

                for (int j = 3; j <= 5; j++) {
                    boolean asistenciaMarcada = (boolean) modeloTabla.getValueAt(i, j);
                    String justificacion = (String) Tbl_ListadoAsistencia.getValueAt(i, 6);

                    if (asistenciaMarcada && j == 5 && (justificacion == null || justificacion.trim().isEmpty())) {
                        System.out.println("¡Debe ingresar una justificación!");
                        columnaSeleccionada = true;
                        all_fine = false;
                        showMessageDialog("ERROR", "Hay justificaciones sin llenar el motivo.");
                        break;
                    }
                    if (asistenciaMarcada) {
                        columnaSeleccionada = true;
                        all_fine = true;
                        break;
                    }

                }

                if (columnaSeleccionada) {
                    System.out.println("[+] Todo está bien para la fila con NIE: " + modeloTabla.getValueAt(i, 0));
                } else {
                    all_fine = false;
                    System.out.println("[-] Asistencia sin marcar del NIE: " + modeloTabla.getValueAt(i, 0));
                    showMessageDialog("ERROR", "Asistencias sin marcar del NIE");
                    break;
                }

            }

            if (all_fine) {
                // entry
                for (int i = 0; i < modeloTabla.getRowCount(); i++) {

                    System.out.println("vuelta");

                    int NIE = Integer.parseInt(modeloTabla.getValueAt(i, 0).toString());
                    System.out.println("NIE" + NIE);

                    String Justificacion = (modeloTabla.getValueAt(i, 6) != null) ? modeloTabla.getValueAt(i, 6).toString() : "";

                    int EstadoAsistencia = 0;

                    if ((boolean) modeloTabla.getValueAt(i, 3)) {
                        EstadoAsistencia = 1;//present
                    }
                    if ((boolean) modeloTabla.getValueAt(i, 4)) {
                        EstadoAsistencia = 2;//absent
                    }
                    if ((boolean) modeloTabla.getValueAt(i, 5)) {
                        EstadoAsistencia = 3;//justified
                    }

                    System.out.println("estado: " + EstadoAsistencia);

                    Modelo_TomaAsistencia Asistencia = new Modelo_TomaAsistencia();

                    Asistencia.setIdDocente(9876);
                    Asistencia.setNIE(NIE);
                    Asistencia.setFecha(fecha);
                    Asistencia.setIdEstadoAsistencia(EstadoAsistencia);
                    Asistencia.setJustificacion(Justificacion);

                    Asistencia.RegistrarAsistencia(Asistencia);
                }
            } else {
                System.out.println("###ERROR");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error converting NIE to a number: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }


    }//GEN-LAST:event_jPanel6MouseClicked

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

        int numeroDeCeldas = 2; // Cambia este valor al número de celdas que necesites

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

    public void get_TblAsistencia(JTable tabla) {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setNumRows(0);

        ListObjeto = Objeto.GetListado(Grado);
        System.out.println("Hay " + ListObjeto.size() + " registros en la lista.");

        for (Modelo_TomaAsistencia item : ListObjeto) {
            modeloTabla.addRow(new Object[]{
                item.getNIE(),
                item.getNombreEstudiante(),
                item.getApellidoEstudiante(),
                Boolean.FALSE,
                Boolean.FALSE,
                Boolean.FALSE,});
        }

        tabla.setModel(modeloTabla);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Aerolinea3;
    private javax.swing.JLabel Lb_Aerolinea4;
    private javax.swing.JLabel Lb_FechaActual;
    private javax.swing.JTable Tbl_ListadoAsistencia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
