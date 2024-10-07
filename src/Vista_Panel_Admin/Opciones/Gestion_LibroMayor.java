package Vista_Panel_Admin.Opciones;

import Customizacion.TablaCusomizada;
import static Funciones.Funciones.clearScreen;
import Modelos.Contador.Modelo_Catalogo;
import Modelos.Contador.Modelo_LibroDiario;
import Modelos.Contador.Modelo_LibroMayor;
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
public class Gestion_LibroMayor extends javax.swing.JInternalFrame {

    private Modelo_LibroMayor Objeto_LibroDiario = new Modelo_LibroMayor();
    private Map<Integer, ArrayList<Modelo_LibroDiario>> List_LibroDiario;

    private static final Modelo_TipoCuenta Objeto_TipoCuenta = new Modelo_TipoCuenta();
    private static List<Modelo_TipoCuenta> List_TipoCuenta;

    //el modelo de tabla para manipular la tabla
    private DefaultTableModel modeloTabla = new DefaultTableModel();

    public Gestion_LibroMayor() throws SQLException {
        initComponents();
        clearScreen();

        //Get_Cb_Grados(Cb_TipoCuentas);
        DiseñoTabla(Tbl_LibroDiario);
        Get_Tbl_Catalogo(Tbl_LibroDiario);

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

    public void Get_Tbl_Catalogo(JTable tabla) throws SQLException {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setNumRows(0);

        Objeto_LibroDiario = Objeto_LibroDiario.Get_LibroMayor_();

        ArrayList<Modelo_LibroMayor> deudores = Objeto_LibroDiario.getDeudores();
        ArrayList<Modelo_LibroMayor> acreedores = Objeto_LibroDiario.getAcreedores();

        int sizeDeudores = deudores.size();
        int sizeAcreedores = acreedores.size();
        int maxSize = Math.max(sizeDeudores, sizeAcreedores);

        for (int i = 0; i < maxSize; i++) {
            String fechaDeudor = "";
            String numPartidaDeudor = "";
            String saldoDebe = "";

            String fechaAcreedor = "";
            String numPartidaAcreedor = "";
            String saldoHaber = "";

            Modelo_LibroMayor deudor = deudores.get(i);
            if (deudor.getFecha() != null) {
                fechaDeudor = deudor.getFecha().toString();
            }

            numPartidaDeudor = Integer.toString(deudor.getId_Libro_diario());
            saldoDebe = String.valueOf(deudor.getSaldo());

            Modelo_LibroMayor acreedor = acreedores.get(i);
            if (acreedor.getFecha() != null) {
                fechaAcreedor = acreedor.getFecha().toString();
            }

            numPartidaAcreedor = Integer.toString(acreedor.getId_Libro_diario());
            saldoHaber = String.valueOf(acreedor.getSaldo());

            modeloTabla.addRow(new Object[]{
                fechaDeudor,
                "( " + numPartidaDeudor + " )",
                saldoDebe,
                saldoHaber,
                "( " + numPartidaAcreedor + " )",
                fechaAcreedor
            });
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

        System.out.println("modelo " + modeloTabla.getRowCount() + " tabla " + Tbl_LibroDiario.getRowCount());
        //Esto renderiza el texto en el centro 
        for (int i = 0; i < Tbl_LibroDiario.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        //aca pone las columnas que quieras que el texto aparezca a la izquierda
        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(60, 45));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jp_Main = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_LibroDiario = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        Lb_Bienvenida = new javax.swing.JLabel();
        Lb_CantidadCuentas = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Cb_TipoCuentas = new javax.swing.JComboBox<>();

        jPanel3.setBackground(new java.awt.Color(242, 244, 209));

        jp_Main.setBackground(new java.awt.Color(178, 211, 190));

        Tbl_LibroDiario.setAutoCreateRowSorter(true);
        Tbl_LibroDiario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        Tbl_LibroDiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Num Partida", "Debe", "Haber", "Num partida", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_LibroDiario);
        if (Tbl_LibroDiario.getColumnModel().getColumnCount() > 0) {
            Tbl_LibroDiario.getColumnModel().getColumn(0).setResizable(false);
            Tbl_LibroDiario.getColumnModel().getColumn(0).setPreferredWidth(70);
            Tbl_LibroDiario.getColumnModel().getColumn(1).setResizable(false);
            Tbl_LibroDiario.getColumnModel().getColumn(1).setPreferredWidth(70);
            Tbl_LibroDiario.getColumnModel().getColumn(2).setResizable(false);
            Tbl_LibroDiario.getColumnModel().getColumn(2).setPreferredWidth(200);
            Tbl_LibroDiario.getColumnModel().getColumn(3).setPreferredWidth(200);
            Tbl_LibroDiario.getColumnModel().getColumn(4).setPreferredWidth(70);
            Tbl_LibroDiario.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        javax.swing.GroupLayout jp_MainLayout = new javax.swing.GroupLayout(jp_Main);
        jp_Main.setLayout(jp_MainLayout);
        jp_MainLayout.setHorizontalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MainLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jp_MainLayout.setVerticalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MainLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(94, 96, 115));

        Lb_Bienvenida.setFont(new java.awt.Font("Sylfaen", 1, 48)); // NOI18N
        Lb_Bienvenida.setForeground(new java.awt.Color(242, 244, 209));
        Lb_Bienvenida.setText("LIBRO DIARIO");

        Lb_CantidadCuentas.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        Lb_CantidadCuentas.setForeground(new java.awt.Color(242, 244, 209));
        Lb_CantidadCuentas.setText("Numero de cuentas :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lb_Bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(Cb_TipoCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cb_TipoCuentas;
    private javax.swing.JLabel Lb_Bienvenida;
    private javax.swing.JLabel Lb_CantidadCuentas;
    private javax.swing.JTable Tbl_LibroDiario;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_Main;
    // End of variables declaration//GEN-END:variables
}
