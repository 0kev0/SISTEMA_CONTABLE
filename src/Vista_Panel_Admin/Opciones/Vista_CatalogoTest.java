package Vista_Panel_Admin.Opciones;

import Customizacion.TablaCusomizada;
import Modelos.Contador.Modelo_Catalogo;
import Modelos.Contador.Modelo_TipoCuenta;
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

/**
 *
 * @author kev
 */
public final class Vista_CatalogoTest extends javax.swing.JFrame {

    private final Modelo_Catalogo Objeto_Catalogo = new Modelo_Catalogo();
    private List<Modelo_Catalogo> List_Catalogo;

    private static final Modelo_TipoCuenta Objeto_TipoCuenta = new Modelo_TipoCuenta();
    private static List<Modelo_TipoCuenta> List_TipoCuenta;

    //el modelo de tabla para manipular la tabla
    private DefaultTableModel modeloTabla = new DefaultTableModel();

    public Vista_CatalogoTest() {
        initComponents();
        Get_Cb_Grados(Cb_TipoCuentas);
        DiseñoTabla(Tbl_Catalogo);
        Get_Tbl_Catalogo(Tbl_Catalogo);

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
        int id_TipoCuenta = Integer.parseInt(Cb_TipoCuentas.getSelectedItem().toString());
        modeloTabla.setNumRows(0);

        System.out.println("buscando por year: " + id_TipoCuenta);
        List_Catalogo = Objeto_Catalogo.Get_CatalogoFiltrado(id_TipoCuenta);
        System.out.println("Hay " + List_TipoCuenta.size() + " registros en la lista.");

        int cantCuentas = 0;
        for (Modelo_Catalogo item : List_Catalogo) {//aca recorres los objetos de la lista *aveces ocupa que cambies el tipo de obj

            modeloTabla.addRow(new Object[]{
                item.getId_Cuenta(),
                item.getTipoCuenta(),
                item.getNombreCuenta(),});
            cantCuentas++;
        }

        tabla.setModel(modeloTabla);

        Lb_CantidadCuentas.setText("Numero de cuentas : " + cantCuentas);

    }

    //etse metodo llena las tablas, este mismo vas a utilizar en todos, con la diferencia de la cantidad de columnas y los gets del item
    public void Get_Tbl_Catalogo(JTable tabla) {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setNumRows(0);

        double Utilidades = 0;

        List_Catalogo = Objeto_Catalogo.Get_Catalogo();//aca con el objeto manipulas la db y llenas una lista del objeto 
        System.out.println("hay " + List_Catalogo.size());

        ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));
        int cantCuentas = 0;
        for (Modelo_Catalogo item : List_Catalogo) {//aca recorres los objetos de la lista *aveces ocupa que cambies el tipo de obj

            modeloTabla.addRow(new Object[]{
                item.getId_Cuenta(),
                item.getTipoCuenta(),
                item.getNombreCuenta(),});
            cantCuentas++;
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

        System.out.println("modelo " + modeloTabla.getRowCount() + " tabla " + Tbl_Catalogo.getRowCount());
        //Esto renderiza el texto en el centro 
        for (int i = 0; i < Tbl_Catalogo.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Catalogo = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        Lb_Bienvenida = new javax.swing.JLabel();
        Lb_CantidadCuentas = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Cb_TipoCuentas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(242, 244, 209));

        jp_Main.setBackground(new java.awt.Color(178, 211, 190));

        Tbl_Catalogo.setAutoCreateRowSorter(true);
        Tbl_Catalogo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        Tbl_Catalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Tipo cuenta", "Nombre Cuenta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_Catalogo);
        if (Tbl_Catalogo.getColumnModel().getColumnCount() > 0) {
            Tbl_Catalogo.getColumnModel().getColumn(0).setPreferredWidth(80);
            Tbl_Catalogo.getColumnModel().getColumn(1).setPreferredWidth(80);
            Tbl_Catalogo.getColumnModel().getColumn(2).setPreferredWidth(400);
        }

        javax.swing.GroupLayout jp_MainLayout = new javax.swing.GroupLayout(jp_Main);
        jp_Main.setLayout(jp_MainLayout);
        jp_MainLayout.setHorizontalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MainLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jp_MainLayout.setVerticalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MainLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
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
                .addGap(257, 257, 257)
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

        Cb_TipoCuentas.setBackground(new java.awt.Color(137, 163, 178));
        Cb_TipoCuentas.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Cb_TipoCuentas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)), "Filtro tipo cuenta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(242, 244, 209))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cb_TipoCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(Cb_TipoCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jp_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
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

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Vista_CatalogoTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_CatalogoTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_CatalogoTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_CatalogoTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_CatalogoTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cb_TipoCuentas;
    private javax.swing.JLabel Lb_Bienvenida;
    private javax.swing.JLabel Lb_CantidadCuentas;
    private javax.swing.JTable Tbl_Catalogo;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_Main;
    // End of variables declaration//GEN-END:variables
}
