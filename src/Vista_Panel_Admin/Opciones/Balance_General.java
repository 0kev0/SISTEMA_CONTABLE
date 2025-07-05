package Vista_Panel_Admin.Opciones;

import Customizacion.TablaCusomizada;
import static Funciones.Funciones.clearScreen;
import Modelos.Contador.Modelo_BalanceGeneral;
import Modelos.Contador.Modelo_TipoCuenta;
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

/**
 *
 * @author kev
 */
public final class Balance_General extends javax.swing.JInternalFrame {

    private final Modelo_BalanceGeneral Objeto_EstadoResultado = new Modelo_BalanceGeneral();
    private ArrayList<Modelo_BalanceGeneral> List_EstadoResultado;

    private static final Modelo_TipoCuenta Objeto_TipoCuenta = new Modelo_TipoCuenta();
    private static List<Modelo_TipoCuenta> List_TipoCuenta;

    //el modelo de tabla para manipular la tabla
    private DefaultTableModel modeloTabla = new DefaultTableModel();

    public Balance_General() throws SQLException {
        initComponents();
        clearScreen();

       // Get_Cb_Grados(Cb_Mes);
        DiseñoTabla(Tbl_EstadoResultado);
        Get_Tbl_BalanceGeneral(Tbl_EstadoResultado);

        Modelo_BalanceGeneral g = new Modelo_BalanceGeneral();
        g.Get_EstadoFinanciero();

    }

    public static void Get_Cb_Grados(JComboBox ComboBox) {

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_TipoCuenta = Objeto_TipoCuenta.Get_TipoCuentas();
        System.out.println("hay " + List_TipoCuenta.size());

        for (Modelo_TipoCuenta item : List_TipoCuenta) {
            ModeloComboBox.addElement(item.getNombreTipoCuenta());
        }

        ComboBox.setModel(ModeloComboBox);
    }

    //etse metodo llena las tablas, este mismo vas a utilizar en todos, con la diferencia de la cantidad de columnas y los gets del item
public void Get_Tbl_BalanceGeneral(JTable tabla) throws SQLException {
    modeloTabla = (DefaultTableModel) tabla.getModel();
    modeloTabla.setNumRows(0);

    double totalDebe = 0; // Variable para acumular el total del debe
    double totalHaber = 0; // Variable para acumular el total del haber

    List_EstadoResultado = Objeto_EstadoResultado.Get_EstadoFinanciero(); // Llenar la lista desde la base de datos
    System.out.println("hay " + List_EstadoResultado.size());

    for (Modelo_BalanceGeneral item : List_EstadoResultado) {
        String SaldoDebe = "";
        String SaldoHaber = "";

        if (item.getTipo_saldo().equals("Deudor")) {
            SaldoDebe = "$ " + Double.toString(item.getSaldo());
            totalDebe += item.getSaldo(); // Acumular el total del debe
            System.out.println("debe");
        }

        if (item.getTipo_saldo().equals("Acreedor")) {
            SaldoHaber = "$ " + Double.toString(item.getSaldo());
            totalHaber += item.getSaldo(); // Acumular el total del haber
            System.out.println("haber");
        }

        modeloTabla.addRow(new Object[]{item.getId_CodigoCuenta(), item.getNombre_cuenta(), SaldoDebe, SaldoHaber});
    }

    // Agregar la fila de totales
    modeloTabla.addRow(new Object[]{"Totales", "", "$ " + totalDebe, "$ " + totalHaber});

    tabla.setModel(modeloTabla);
    Lb_CantidadCuentas.setText("Numero de cuentas : " + List_EstadoResultado.size());
}
    
        public void Get_Tbl_BalanceGeneral_FiltroMes(JTable tabla) throws SQLException {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setNumRows(0);
        
                int mes = Cb_Mes.getSelectedIndex() + 1;
        int year = Funciones.Funciones.Get_Year_Actual();

        double Utilidades = 0;

        List_EstadoResultado = Objeto_EstadoResultado.Get_EstadoFinanciero_MES(mes, year);//aca con el objeto manipulas la db y llenas una lista del objeto 
        System.out.println("hay " + List_EstadoResultado.size());

        for (Modelo_BalanceGeneral item : List_EstadoResultado) {

            String SaldoDebe = "";
            String SaldoHaber = "";
            
            if (item.getTipo_saldo().equals("Deudor")) {
                SaldoDebe = "$ " +  Double.toString(item.getSaldo() );

                System.out.println("debe");
            }

            if (item.getTipo_saldo().equals("Acreedor")) {
                SaldoHaber = "$ " + Double.toString(item.getSaldo());
                System.out.println("haber");

            }

            modeloTabla.addRow(new Object[]{item.getId_CodigoCuenta(), item.getNombre_cuenta(), SaldoDebe, SaldoHaber});

        }

        tabla.setModel(modeloTabla);

        Lb_CantidadCuentas.setText("Numero de cuentas : " + List_EstadoResultado);
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

        System.out.println("modelo " + modeloTabla.getRowCount() + " tabla " + Tbl_EstadoResultado.getRowCount());
        //Esto renderiza el texto en el centro 
        for (int i = 0; i < Tbl_EstadoResultado.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        //aca pone las columnas que quieras que el texto aparezca a la izquierda
        tabla.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);        


        

        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(60, 45));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jp_Main = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_EstadoResultado = new javax.swing.JTable();
        Lb_CantidadCuentas3 = new javax.swing.JLabel();
        Lb_CantidadCuentas1 = new javax.swing.JLabel();
        Lb_CantidadCuentas2 = new javax.swing.JLabel();
        Lb_CantidadCuentas4 = new javax.swing.JLabel();
        Cb_Mes = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        Lb_Bienvenida = new javax.swing.JLabel();
        Lb_CantidadCuentas = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        jPanel3.setBackground(new java.awt.Color(242, 244, 209));

        jp_Main.setBackground(new java.awt.Color(178, 211, 190));

        Tbl_EstadoResultado.setAutoCreateRowSorter(true);
        Tbl_EstadoResultado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        Tbl_EstadoResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cuenta", "Cargos", "Abonos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_EstadoResultado);
        if (Tbl_EstadoResultado.getColumnModel().getColumnCount() > 0) {
            Tbl_EstadoResultado.getColumnModel().getColumn(0).setPreferredWidth(80);
            Tbl_EstadoResultado.getColumnModel().getColumn(1).setPreferredWidth(300);
            Tbl_EstadoResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
            Tbl_EstadoResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        Lb_CantidadCuentas3.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        Lb_CantidadCuentas3.setForeground(new java.awt.Color(0, 0, 0));
        Lb_CantidadCuentas3.setText("Fecha Periodo");

        Lb_CantidadCuentas1.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        Lb_CantidadCuentas1.setForeground(new java.awt.Color(0, 0, 0));
        Lb_CantidadCuentas1.setText("Estado Financiero");

        Lb_CantidadCuentas2.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        Lb_CantidadCuentas2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_CantidadCuentas2.setText("Nombre Empresa");

        Lb_CantidadCuentas4.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        Lb_CantidadCuentas4.setForeground(new java.awt.Color(0, 0, 0));
        Lb_CantidadCuentas4.setText("Saldos");

        Cb_Mes.setBackground(new java.awt.Color(137, 163, 178));
        Cb_Mes.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Cb_Mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Dicicembre" }));
        Cb_Mes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)), "Mes periodo contable:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(242, 244, 209))); // NOI18N
        Cb_Mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_MesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_MainLayout = new javax.swing.GroupLayout(jp_Main);
        jp_Main.setLayout(jp_MainLayout);
        jp_MainLayout.setHorizontalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MainLayout.createSequentialGroup()
                .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_MainLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_MainLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Cb_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_MainLayout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lb_CantidadCuentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Lb_CantidadCuentas3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Lb_CantidadCuentas2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jp_MainLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Lb_CantidadCuentas4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jp_MainLayout.setVerticalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_MainLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(Lb_CantidadCuentas2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lb_CantidadCuentas1)
                .addGap(18, 18, 18)
                .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_MainLayout.createSequentialGroup()
                        .addComponent(Lb_CantidadCuentas3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Lb_CantidadCuentas4))
                    .addComponent(Cb_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jPanel5.setBackground(new java.awt.Color(94, 96, 115));

        Lb_Bienvenida.setFont(new java.awt.Font("Sylfaen", 1, 48)); // NOI18N
        Lb_Bienvenida.setForeground(new java.awt.Color(242, 244, 209));
        Lb_Bienvenida.setText("SISTEMA CONTABLE");

        Lb_CantidadCuentas.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        Lb_CantidadCuentas.setForeground(new java.awt.Color(242, 244, 209));
        Lb_CantidadCuentas.setText("Numero de cuentas :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(Lb_Bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jp_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jp_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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

    private void Cb_MesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_MesActionPerformed
int opcion = Cb_Mes.getSelectedIndex();
        try {
    if (opcion == 0) {
        Get_Tbl_BalanceGeneral(Tbl_EstadoResultado);
    } else {
        Get_Tbl_BalanceGeneral_FiltroMes(Tbl_EstadoResultado);
    }
} catch (SQLException ex) {
    Logger.getLogger(Balance_General.class.getName()).log(Level.SEVERE, null, ex);
}
        
    }//GEN-LAST:event_Cb_MesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cb_Mes;
    private javax.swing.JLabel Lb_Bienvenida;
    private javax.swing.JLabel Lb_CantidadCuentas;
    private javax.swing.JLabel Lb_CantidadCuentas1;
    private javax.swing.JLabel Lb_CantidadCuentas2;
    private javax.swing.JLabel Lb_CantidadCuentas3;
    private javax.swing.JLabel Lb_CantidadCuentas4;
    private javax.swing.JTable Tbl_EstadoResultado;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_Main;
    // End of variables declaration//GEN-END:variables
}
