package Vista_Panel_Secretaria.Opciones;

import Customizacion.TablaCusomizada;
import static Funciones.Funciones.EnterMouse;
import Modelos.Secretaria.Modelo_Productos;
import Modelos.Secretaria.Modelo_TipoProducto;
import Vista_Panel_Director.Panel_Director1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

public final class Panel_InventarioEscolar extends javax.swing.JFrame {

    private DefaultTableModel modeloTabla_Productos = new DefaultTableModel();

    private final Modelo_TipoProducto Objeto_TipoProducto = new Modelo_TipoProducto();
    private List<Modelo_TipoProducto> List_TipoProducto;

    private final Modelo_Productos Objeto_Modelo_Productos = new Modelo_Productos();
    private List<Modelo_Productos> List_Productos;

    private DefaultTableModel modeloTabla = new DefaultTableModel();

    public Panel_InventarioEscolar() {
        initComponents();
        setLocationRelativeTo(this);

        this.modeloTabla_Productos = (DefaultTableModel) Tbl_InventarioEscolar.getModel();
        System.out.println("tiene " + Tbl_InventarioEscolar.getColumnCount());
        DiseñoTabla(Tbl_InventarioEscolar);
        Get_Tbl_Productos(Tbl_InventarioEscolar);
        Get_TiposProductos(Cb_TipoProducto);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Lb_Total = new javax.swing.JLabel();
        Cb_TipoProducto = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Lb_Aerolinea3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Lb_Materia_Periodo2 = new javax.swing.JLabel();
        Btn_Regresar = new javax.swing.JPanel();
        Lb_atras = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_InventarioEscolar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(234, 223, 180));
        jPanel1.setMinimumSize(new java.awt.Dimension(1060, 630));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(226, 215, 132));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 8, new java.awt.Color(255, 153, 51)));

        Lb_Total.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Total.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Total.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Total.setText("Total");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(Lb_Total)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(Lb_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 180, 30));

        Cb_TipoProducto.setBackground(new java.awt.Color(224, 213, 170));
        Cb_TipoProducto.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_TipoProducto.setForeground(new java.awt.Color(0, 0, 0));
        Cb_TipoProducto.setToolTipText("");
        Cb_TipoProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Tipo de producto: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_TipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_TipoProductoActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_TipoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 180, -1));

        jPanel4.setBackground(new java.awt.Color(226, 215, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea2.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea2.setText("Inventario ");

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

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 6, 370, -1));

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

        jPanel7.setBackground(new java.awt.Color(226, 215, 132));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 8, new java.awt.Color(255, 153, 51)));

        Lb_Materia_Periodo2.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Materia_Periodo2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Materia_Periodo2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Materia_Periodo2.setText("Productos");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(Lb_Materia_Periodo2)
                .addGap(16, 16, 16))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(Lb_Materia_Periodo2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 180, 30));

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

        jPanel1.add(Btn_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 140, -1));

        Tbl_InventarioEscolar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "item", "Descripcion", "Precio", "Costo", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Tbl_InventarioEscolar);
        if (Tbl_InventarioEscolar.getColumnModel().getColumnCount() > 0) {
            Tbl_InventarioEscolar.getColumnModel().getColumn(0).setPreferredWidth(80);
            Tbl_InventarioEscolar.getColumnModel().getColumn(1).setPreferredWidth(200);
            Tbl_InventarioEscolar.getColumnModel().getColumn(2).setPreferredWidth(200);
            Tbl_InventarioEscolar.getColumnModel().getColumn(3).setPreferredWidth(100);
            Tbl_InventarioEscolar.getColumnModel().getColumn(4).setPreferredWidth(100);
            Tbl_InventarioEscolar.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 780, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Get_Tbl_Productos(JTable tabla) {
        modeloTabla_Productos.setNumRows(0);

        List_Productos = Objeto_Modelo_Productos.Get_Productos();
        System.out.println("hay " + List_Productos.size());

        for (Modelo_Productos item : List_Productos) {

            modeloTabla_Productos.addRow(new Object[]{
                item.getid(),
                item.getNombre_Producto(),
                item.getDescripcion(),
                item.getPrecio(),
                item.getCosto(),
                item.getCant_Disponible()
            });
        }

        tabla.setModel(modeloTabla_Productos);
    }

    public void Get_TiposProductos(JComboBox ComboBox) {

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_TipoProducto = Objeto_TipoProducto.Get_TipoProductos();
        System.out.println("hay " + List_TipoProducto.size());

        for (Modelo_TipoProducto item : List_TipoProducto) {
            ModeloComboBox.addElement(item.getTipoProducto());
        }

        ComboBox.setModel(ModeloComboBox);
    }

    public void Get_Tbl_Productos_filtrada(JTable tabla) {
        int op = Cb_TipoProducto.getSelectedIndex() + 1;
        modeloTabla_Productos.setNumRows(0);

        System.out.println("buscando id tipo " + op);

        List_Productos = Objeto_Modelo_Productos.Get_Productos_filtrado(op);
        System.out.println("hay " + List_Productos.size());

        //ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));
        ImageIcon icono_add = new ImageIcon(getClass().getResource("/Imagenes/add.png"));
        ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/Imagenes/remove.png"));

        for (Modelo_Productos item : List_Productos) {

            modeloTabla_Productos.addRow(new Object[]{
                item.getid(),
                item.getNombre_Producto(),
                item.getDescripcion(),
                item.getPrecio(),
                item.getCosto(),
                item.getCant_Disponible(),});
        }

        tabla.setModel(modeloTabla_Productos);
    }

    public void DiseñoTabla(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new TablaCusomizada());
        tabla.setRowHeight(50);
        tabla.getTableHeader().setBackground(Color.decode("#5C636E"));
        tabla.getTableHeader().setForeground(Color.white);
        Font fuente = new Font("Roboto", Font.BOLD, 12);
        tabla.setFont(fuente);
        tabla.getTableHeader().setFont(fuente);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < 6; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        tabla.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
        tabla.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);

        JTableHeader header = tabla.getTableHeader();

        header.setPreferredSize(new Dimension(60, 45));

    }

    private void Cb_TipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_TipoProductoActionPerformed

        modeloTabla_Productos.setNumRows(0);
        Get_Tbl_Productos_filtrada(Tbl_InventarioEscolar);
    }//GEN-LAST:event_Cb_TipoProductoActionPerformed

    private void Btn_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseClicked

        dispose();
    }//GEN-LAST:event_Btn_RegresarMouseClicked

    private void Btn_RegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseEntered
        EnterMouse(Btn_Regresar, Lb_atras, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_RegresarMouseEntered

    private void Btn_RegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_RegresarMouseExited

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Panel_InventarioEscolar().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_Regresar;
    private javax.swing.JComboBox<String> Cb_TipoProducto;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Aerolinea3;
    private javax.swing.JLabel Lb_Materia_Periodo2;
    private javax.swing.JLabel Lb_Total;
    private javax.swing.JLabel Lb_atras;
    private javax.swing.JTable Tbl_InventarioEscolar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
