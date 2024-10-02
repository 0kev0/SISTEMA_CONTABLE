package Vista_Panel_Director.Opciones;

import Modelo.Director.Modelo_Gestion_Transacciones;
import Customizacion.TablaCusomizada;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class Gestion_Transacciones_1 extends javax.swing.JFrame {
//vas a darle refactor a este form y a la clase manipuladora de la base de datos
//lo que cambiaria es el diseno, y las clases para el objeto y lista

    //Vas a ocupar este par de objetos, el objeto de la clase que manipula la base de datos
    //y la lista de objetos de del mismo tipo para llenar las tablas 
    private final Modelo_Gestion_Transacciones Objeto_Actividades = new Modelo_Gestion_Transacciones();
    private List<Modelo_Gestion_Transacciones> List_Actividades;

    //el modelo de tabla para manipular la tabla
    private DefaultTableModel modeloTabla = new DefaultTableModel();

    public Gestion_Transacciones_1() {
        initComponents();
        modeloTabla = (DefaultTableModel) Tbl_RegistoInscripciones.getModel();

        Get_Tbl_Transacciones(Tbl_RegistoInscripciones);
        DiseñoTabla(Tbl_RegistoInscripciones);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_RegistoInscripciones = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Lb_Utilidades = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Lb_Aerolinea3 = new javax.swing.JLabel();
        Btn_LimpiarFiltros = new javax.swing.JPanel();
        Lb_LimpiarFiltros = new javax.swing.JLabel();
        Cb_Año = new javax.swing.JComboBox<>();
        Cb_BuscarPorMes_ = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(234, 223, 180));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tbl_RegistoInscripciones.setAutoCreateRowSorter(true);
        Tbl_RegistoInscripciones.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        Tbl_RegistoInscripciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "NIE", "Detalle", "Fecha", "Cantidad", "Monto", "Costo", "Utilidades", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_RegistoInscripciones);
        if (Tbl_RegistoInscripciones.getColumnModel().getColumnCount() > 0) {
            Tbl_RegistoInscripciones.getColumnModel().getColumn(0).setPreferredWidth(40);
            Tbl_RegistoInscripciones.getColumnModel().getColumn(1).setPreferredWidth(40);
            Tbl_RegistoInscripciones.getColumnModel().getColumn(2).setPreferredWidth(200);
            Tbl_RegistoInscripciones.getColumnModel().getColumn(3).setPreferredWidth(100);
            Tbl_RegistoInscripciones.getColumnModel().getColumn(4).setPreferredWidth(80);
            Tbl_RegistoInscripciones.getColumnModel().getColumn(5).setPreferredWidth(80);
            Tbl_RegistoInscripciones.getColumnModel().getColumn(8).setPreferredWidth(200);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 910, 490));

        jPanel3.setBackground(new java.awt.Color(226, 215, 132));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 8, new java.awt.Color(255, 153, 51)));

        Lb_Utilidades.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Utilidades.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Utilidades.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Utilidades.setText("materia");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lb_Utilidades, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(104, 104, 104)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(14, Short.MAX_VALUE)
                    .addComponent(Lb_Utilidades, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 180, -1));

        jPanel4.setBackground(new java.awt.Color(226, 215, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea2.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea2.setText("Gestion de transacciones");

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

        jPanel1.add(Btn_LimpiarFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 140, 40));

        Cb_Año.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Año.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Año.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Año.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025", "2026" }));
        Cb_Año.setToolTipText("");
        Cb_Año.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Año :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Año.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_AñoActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Año, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 134, -1));

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
        jPanel1.add(Cb_BuscarPorMes_, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 134, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1196, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void Btn_LimpiarFiltrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseClicked
        Get_Tbl_Transacciones(Tbl_RegistoInscripciones);
    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseClicked

    private void Btn_LimpiarFiltrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseEntered
        Funciones.Funciones.EnterMouse(Btn_LimpiarFiltros, Lb_LimpiarFiltros, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseEntered

    private void Btn_LimpiarFiltrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_LimpiarFiltrosMouseExited
        Funciones.Funciones.LeftMouse(Btn_LimpiarFiltros, Lb_LimpiarFiltros, "#E2D784", "#000000");
    }//GEN-LAST:event_Btn_LimpiarFiltrosMouseExited

    private void Cb_BuscarPorMes_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_BuscarPorMes_ActionPerformed
        Cargar_Listado_Registro_Busqueda_dia(Tbl_RegistoInscripciones);

    }//GEN-LAST:event_Cb_BuscarPorMes_ActionPerformed

    private void Cb_AñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_AñoActionPerformed
        Cargar_Listado_Registro_Busqueda_dia(Tbl_RegistoInscripciones);

    }//GEN-LAST:event_Cb_AñoActionPerformed

    public void Cargar_Listado_Registro_Busqueda_dia(JTable tabla) {
        int mes = Cb_BuscarPorMes_.getSelectedIndex() + 1;
        int Year = Integer.parseInt(Cb_Año.getSelectedItem().toString());

        modeloTabla.setNumRows(0);

        System.out.println("buscando por año: " + Year + "  por mes : " + mes);
        List_Actividades = Objeto_Actividades.Get_transacciones_PorFecha(mes, Year);
        System.out.println("Hay " + List_Actividades.size() + " registros en la lista.");

        double Utilidades = 0;

        for (Modelo_Gestion_Transacciones item : List_Actividades) {

            modeloTabla.addRow(new Object[]{
                item.getId(),
                item.getNIE(),
                item.getDetalle(),
                item.getFecha(),
                item.getCantidad(),
                item.getMonto(),
                item.getCosto(),
                item.getGanancia(),
                item.getCorreo(),});

            Utilidades += item.getGanancia();
        }
        tabla.setModel(modeloTabla);
        Lb_Utilidades.setText(Utilidades + " $");

    }

    //etse metodo llena las tablas, este mismo vas a utilizar en todos, con la diferencia de la cantidad de columnas y los gets del item
    public void Get_Tbl_Transacciones(JTable tabla) {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setNumRows(0);

        double Utilidades = 0;

        List_Actividades = Objeto_Actividades.get_Transacciones();//aca con el objeto manipulas la db y llenas una lista del objeto 
        System.out.println("hay " + List_Actividades.size());

        ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));

        for (Modelo_Gestion_Transacciones item : List_Actividades) {//aca recorres los objetos de la lista *aveces ocupa que cambies el tipo de obj

            modeloTabla.addRow(new Object[]{
                item.getId(),
                item.getNIE(),
                item.getDetalle(),
                item.getFecha(),
                item.getCantidad(),
                item.getMonto(),
                item.getCosto(),
                item.getGanancia(),
                item.getCorreo(),});

            Utilidades += item.getGanancia();
        }

        tabla.setModel(modeloTabla);

        Lb_Utilidades.setText(Utilidades + " $");
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

        System.out.println("modelo " + modeloTabla.getRowCount() + " tabla " + Tbl_RegistoInscripciones.getRowCount());
        //Esto renderiza el texto en el centro 
        for (int i = 0; i < Tbl_RegistoInscripciones.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        //aca pone las columnas que quieras que el texto aparezca a la izquierda
        tabla.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
        tabla.getColumnModel().getColumn(8).setCellRenderer(leftRenderer);

        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(60, 45));

    }

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
            java.util.logging.Logger.getLogger(Gestion_Transacciones_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_Transacciones_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_Transacciones_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_Transacciones_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_Transacciones_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_LimpiarFiltros;
    private javax.swing.JComboBox<String> Cb_Año;
    private javax.swing.JComboBox<String> Cb_BuscarPorMes_;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Aerolinea3;
    private javax.swing.JLabel Lb_LimpiarFiltros;
    private javax.swing.JLabel Lb_Utilidades;
    private javax.swing.JTable Tbl_RegistoInscripciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
