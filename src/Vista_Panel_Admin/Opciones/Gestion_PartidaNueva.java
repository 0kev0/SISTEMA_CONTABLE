package Vista_Panel_Admin.Opciones;

import Customizacion.TablaCusomizada;
import Funciones.Funciones;
import static Funciones.Funciones.EnterMouse;
import static Funciones.Funciones.LeftMouse;
import static Funciones.Funciones.clearScreen;
import Modelos.Contador.Modelo_Catalogo;
import Modelos.Contador.Modelo_LibroDiario;
import Modelos.Contador.Modelo_TipoCuenta;
import static Vista_Panel_Admin.Opciones.Vista_CatalogoTest.Get_Cb_Grados;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author kev
 */
public final class Gestion_PartidaNueva extends javax.swing.JInternalFrame {

    private final Modelo_LibroDiario Objeto_LibroDiario = new Modelo_LibroDiario();
    private Map<Integer, ArrayList<Modelo_LibroDiario>> List_LibroDiario;

    private static final Modelo_TipoCuenta Objeto_TipoCuenta = new Modelo_TipoCuenta();
    private static List<Modelo_TipoCuenta> List_TipoCuenta;
    
    private static final Modelo_Catalogo Objeto_Cuenta = new Modelo_Catalogo();
    private static List<Modelo_Catalogo> List_Cuenta;

    //el modelo de tabla para manipular la tabla
    private DefaultTableModel modeloTabla = new DefaultTableModel();

    public Gestion_PartidaNueva() throws SQLException {
        initComponents();
        clearScreen();

        Get_Cb_TipoCuenta(Cb_TipoCuentas);
        Cb_TipoCuentas.setSelectedItem(0);
        
        Get_Cb_Cuetnas(Cb_Cuetna);

    }

    public static void Get_Cb_TipoCuenta(JComboBox ComboBox) {

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_TipoCuenta = Objeto_TipoCuenta.Get_TipoCuentas();
        System.out.println("hay " + List_TipoCuenta.size());

        for (Modelo_TipoCuenta item : List_TipoCuenta) {
            ModeloComboBox.addElement(item.getNombreTipoCuenta());
        }

        ComboBox.setModel(ModeloComboBox);
    }

    public  void Get_Cb_Cuetnas(JComboBox ComboBox) {

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();
        int id_tipocuetna = Cb_TipoCuentas.getSelectedIndex()+1;

        List_Cuenta = Objeto_Cuenta.Get_CatalogoFiltrado(id_tipocuetna);
        System.out.println("hay " + List_Cuenta.size());

        for (Modelo_Catalogo item : List_Cuenta) {
            ModeloComboBox.addElement(item.getId_Cuenta()+" ) " + item.getNombreCuenta());
        }

        ComboBox.setModel(ModeloComboBox);
    }

    public void Get_Tbl_CatalogoFiltrada(JTable tabla) {
//        int id_TipoCuenta = Cb_TipoCuentas.getSelectedIndex()+1;
//        modeloTabla.setNumRows(0);
//
//        System.out.println("buscando por year: " + id_TipoCuenta);
//        List_LibroDiario = Objeto_LibroDiario.Get_CatalogoFiltrado(id_TipoCuenta);
//        System.out.println("Hay " + List_TipoCuenta.size() + " registros en la lista.");
//
//        int cantCuentas = 0;
//        for (Modelo_LibroDiario item : List_LibroDiario) {//aca recorres los objetos de la lista *aveces ocupa que cambies el tipo de obj
//
//            modeloTabla.addRow(new Object[]{
//                item.getId_Cuenta(),
//                item.getTipoCuenta(),
//                item.getNombreCuenta(),});
//            cantCuentas++;
//        }
//
//        tabla.setModel(modeloTabla);
//
//        Lb_CantidadCuentas.setText("Numero de cuentas : " + cantCuentas);

    }

    //etse metodo llena las tablas, este mismo vas a utilizar en todos, con la diferencia de la cantidad de columnas y los gets del item
    public void Get_Tbl_Catalogo(JTable tabla) throws SQLException {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setNumRows(0);

        double Utilidades = 0;

        List_LibroDiario = Objeto_LibroDiario.Get_LibroDiario();//aca con el objeto manipulas la db y llenas una lista del objeto 
        System.out.println("hay " + List_LibroDiario.size());

        String SaldoDebe = "";
        String SaldoHaber = "";

        ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));
        int cantCuentas = 0;

        for (Map.Entry<Integer, ArrayList<Modelo_LibroDiario>> Entrada : List_LibroDiario.entrySet()) {
            int partidaId = Entrada.getKey();
            int num = 0;
            Double SubTotal_Debe = 0.0;
            Double SubTotal_Haber = 0.0;

            ArrayList<Modelo_LibroDiario> periodos = Entrada.getValue();
            for (Modelo_LibroDiario item : periodos) {

                if (item.getTipo_saldo().equals("Deudor")) {
                    SaldoDebe = Double.toString(item.getSaldo());
                    SubTotal_Debe += item.getSaldo();

                    System.out.println("debe");
                }
                if (item.getTipo_saldo().equals("Acreedor")) {
                    SaldoHaber = Double.toString(item.getSaldo());
                    SubTotal_Haber += item.getSaldo();
                    System.out.println("haber");

                }

                if (num == 0) {
                    modeloTabla.addRow(new Object[]{
                        item.getFecha(), "",
                        "Partida #" + item.getId_Libro_diario()});

                }

                modeloTabla.addRow(new Object[]{
                    "", 0000,
                    item.getNombre_cuenta(),
                    SaldoDebe, SaldoHaber});
                cantCuentas++;

                SaldoDebe = "";
                SaldoHaber = "";

                num++;

                if (num == periodos.size()) {
                    modeloTabla.addRow(new Object[]{
                        "", "", "",
                        SubTotal_Debe,
                        SubTotal_Haber});
                    modeloTabla.addRow(new Object[]{
                        "", "", "",
                        "",
                        ""});
                }

            }
        }

        tabla.setModel(modeloTabla);

        Lb_CantidadCuentas.setText("Numero de cuentas : " + cantCuentas);
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

//        System.out.println("modelo " + modeloTabla.getRowCount() + " tabla " + Tbl_LibroDiario.getRowCount());
//        //Esto renderiza el texto en el centro 
//        for (int i = 0; i < Tbl_LibroDiario.getColumnCount(); i++) {
//            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
//        }

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        //aca pone las columnas que quieras que el texto aparezca a la izquierda
        tabla.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);

        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(60, 45));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jp_Main = new javax.swing.JPanel();
        Tb_Saldo = new javax.swing.JTextField();
        Cb_TipoCuentas1 = new javax.swing.JComboBox<>();
        Cb_Cuetna = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        Lb_Bienvenida = new javax.swing.JLabel();
        Lb_CantidadCuentas = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Cb_TipoCuentas = new javax.swing.JComboBox<>();
        Btn_TipoCuentas = new Customizacion.Custom_Buttons();
        Lb_TipoCuentas = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(242, 244, 209));

        jp_Main.setBackground(new java.awt.Color(178, 211, 190));

        Tb_Saldo.setBackground(new java.awt.Color(94, 96, 115));
        Tb_Saldo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Tb_Saldo.setForeground(new java.awt.Color(255, 255, 255));
        Tb_Saldo.setText("a");
        Tb_Saldo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saldo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Sylfaen", 1, 18), new java.awt.Color(242, 244, 209))); // NOI18N
        Tb_Saldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_SaldoMouseClicked(evt);
            }
        });
        Tb_Saldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tb_SaldoActionPerformed(evt);
            }
        });

        Cb_TipoCuentas1.setBackground(new java.awt.Color(94, 96, 115));
        Cb_TipoCuentas1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Cb_TipoCuentas1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)), "Tipo cuenta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(242, 244, 209))); // NOI18N
        Cb_TipoCuentas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_TipoCuentas1ActionPerformed(evt);
            }
        });

        Cb_Cuetna.setBackground(new java.awt.Color(94, 96, 115));
        Cb_Cuetna.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Cb_Cuetna.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)), "Cuenta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(242, 244, 209))); // NOI18N

        javax.swing.GroupLayout jp_MainLayout = new javax.swing.GroupLayout(jp_Main);
        jp_Main.setLayout(jp_MainLayout);
        jp_MainLayout.setHorizontalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MainLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(Cb_TipoCuentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Cb_Cuetna, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Tb_Saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_MainLayout.setVerticalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MainLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cb_TipoCuentas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cb_Cuetna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tb_Saldo))
                .addGap(341, 341, 341))
        );

        jPanel5.setBackground(new java.awt.Color(94, 96, 115));

        Lb_Bienvenida.setFont(new java.awt.Font("Sylfaen", 1, 48)); // NOI18N
        Lb_Bienvenida.setForeground(new java.awt.Color(242, 244, 209));
        Lb_Bienvenida.setText("Agregar partida");

        Lb_CantidadCuentas.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        Lb_CantidadCuentas.setForeground(new java.awt.Color(242, 244, 209));
        Lb_CantidadCuentas.setText("Numero de cuentas :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lb_Bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(Lb_CantidadCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lb_Bienvenida)
                    .addComponent(Lb_CantidadCuentas))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(94, 96, 115));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        Cb_TipoCuentas.setBackground(new java.awt.Color(137, 163, 178));
        Cb_TipoCuentas.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Cb_TipoCuentas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)), "Filtro tipo cuenta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(242, 244, 209))); // NOI18N
        Cb_TipoCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_TipoCuentasActionPerformed(evt);
            }
        });

        Btn_TipoCuentas.setBackground(new java.awt.Color(137, 163, 178));
        Btn_TipoCuentas.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_TipoCuentas.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_TipoCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_TipoCuentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_TipoCuentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_TipoCuentasMouseExited(evt);
            }
        });
        Btn_TipoCuentas.setLayout(new java.awt.GridBagLayout());

        Lb_TipoCuentas.setBackground(new java.awt.Color(7, 3, 26));
        Lb_TipoCuentas.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_TipoCuentas.setForeground(new java.awt.Color(242, 244, 209));
        Lb_TipoCuentas.setText("Agregar partida");
        Btn_TipoCuentas.add(Lb_TipoCuentas, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jp_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Cb_TipoCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(638, 638, 638)
                .addComponent(Btn_TipoCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_TipoCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cb_TipoCuentas))
                .addGap(34, 34, 34)
                .addComponent(jp_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cb_TipoCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_TipoCuentasActionPerformed
//        if ("Todos".equals(Cb_TipoCuentas.getSelectedItem().toString())) {
//            try {
//                Get_Tbl_Catalogo(Tbl_LibroDiario);
//            } catch (SQLException ex) {
//                Logger.getLogger(Gestion_LibroDiario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//
//            Get_Tbl_CatalogoFiltrada(Tbl_LibroDiario);
//        }

    }//GEN-LAST:event_Cb_TipoCuentasActionPerformed

    private void Btn_TipoCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TipoCuentasMouseClicked

        Modelo_TipoCuenta test = new Modelo_TipoCuenta();
        test.Get_TipoCuentas();

    }//GEN-LAST:event_Btn_TipoCuentasMouseClicked

    private void Btn_TipoCuentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TipoCuentasMouseEntered
        EnterMouse(Btn_TipoCuentas, Lb_TipoCuentas, "#ABBEC8", "#FFFFFF");
    }//GEN-LAST:event_Btn_TipoCuentasMouseEntered

    private void Btn_TipoCuentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TipoCuentasMouseExited
        LeftMouse(Btn_TipoCuentas, Lb_TipoCuentas, "#89A3B2", "#F2F4D1");
    }//GEN-LAST:event_Btn_TipoCuentasMouseExited

    private void Tb_SaldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_SaldoMouseClicked
        Tb_Saldo.setText("");
    }//GEN-LAST:event_Tb_SaldoMouseClicked

    private void Tb_SaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tb_SaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tb_SaldoActionPerformed

    private void Cb_TipoCuentas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_TipoCuentas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cb_TipoCuentas1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_TipoCuentas;
    private javax.swing.JComboBox<String> Cb_Cuetna;
    private javax.swing.JComboBox<String> Cb_TipoCuentas;
    private javax.swing.JComboBox<String> Cb_TipoCuentas1;
    private javax.swing.JLabel Lb_Bienvenida;
    private javax.swing.JLabel Lb_CantidadCuentas;
    private javax.swing.JLabel Lb_TipoCuentas;
    private javax.swing.JTextField Tb_Saldo;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jp_Main;
    // End of variables declaration//GEN-END:variables
}
