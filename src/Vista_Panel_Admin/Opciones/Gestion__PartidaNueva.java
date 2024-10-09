package Vista_Panel_Admin.Opciones;

import Customizacion.TablaCusomizada;
import Funciones.Funciones;
import static Funciones.Funciones.EnterMouse;
import static Funciones.Funciones.LeftMouse;
import static Funciones.Funciones.ValidarSaldo;
import Modelos.Contador.Modelo_Catalogo;
import Modelos.Contador.Modelo_LibroDiario;
import Modelos.Contador.Modelo_TipoCuenta;
import static Vista_Panel_Admin.Opciones.Gestion_PartidaNueva.Get_Cb_TipoCuenta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author kev
 */
public final class Gestion__PartidaNueva extends javax.swing.JFrame {

    private final Modelo_LibroDiario Objeto_LibroDiario = new Modelo_LibroDiario();
    private Map<Integer, ArrayList<Modelo_LibroDiario>> List_LibroDiario;

    private static final Modelo_TipoCuenta Objeto_TipoCuenta = new Modelo_TipoCuenta();
    private static List<Modelo_TipoCuenta> List_TipoCuenta;

    private static final Modelo_Catalogo Objeto_Cuenta = new Modelo_Catalogo();
    private static List<Modelo_Catalogo> List_Cuenta;

    private DefaultTableModel modeloTabla = new DefaultTableModel();

    public Gestion__PartidaNueva() {
        initComponents();

        Get_Cb_TipoCuenta(Cb_TipoCuentas);
        Cb_TipoCuentas.setSelectedItem(0);
        Get_Cb_Cuetnas(Cb_Cuetna);

        modeloTabla = (DefaultTableModel) Tbl_LibroDiario.getModel();
        DiseñoTabla(Tbl_LibroDiario);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_AgregarPartida1 = new Customizacion.Custom_Buttons();
        Lb_TipoCuentas1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jp_Main = new javax.swing.JPanel();
        Tb_Saldo = new javax.swing.JTextField();
        Cb_Cuetna = new javax.swing.JComboBox<>();
        Cb_TipoCuentas = new javax.swing.JComboBox<>();
        Cb_TipoSaldo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_LibroDiario = new javax.swing.JTable();
        Btn_AgregarPartida = new Customizacion.Custom_Buttons();
        Lb_TipoCuentas = new javax.swing.JLabel();
        Btn_AgregarPartida2 = new Customizacion.Custom_Buttons();
        Lb_TipoCuentas2 = new javax.swing.JLabel();
        Lb_Error = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Lb_Bienvenida = new javax.swing.JLabel();
        Lb_CantidadCuentas = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        Btn_AgregarPartida1.setBackground(new java.awt.Color(137, 163, 178));
        Btn_AgregarPartida1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_AgregarPartida1.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_AgregarPartida1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_AgregarPartida1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_AgregarPartida1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_AgregarPartida1MouseExited(evt);
            }
        });
        Btn_AgregarPartida1.setLayout(new java.awt.GridBagLayout());

        Lb_TipoCuentas1.setBackground(new java.awt.Color(7, 3, 26));
        Lb_TipoCuentas1.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_TipoCuentas1.setForeground(new java.awt.Color(242, 244, 209));
        Lb_TipoCuentas1.setText("Agregar partida");
        Btn_AgregarPartida1.add(Lb_TipoCuentas1, new java.awt.GridBagConstraints());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(242, 244, 209));

        jp_Main.setBackground(new java.awt.Color(178, 211, 190));

        Tb_Saldo.setBackground(new java.awt.Color(94, 96, 115));
        Tb_Saldo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Tb_Saldo.setForeground(new java.awt.Color(255, 255, 255));
        Tb_Saldo.setText("100.00");
        Tb_Saldo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saldo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(242, 244, 209))); // NOI18N
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
        Tb_Saldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Tb_SaldoKeyTyped(evt);
            }
        });

        Cb_Cuetna.setBackground(new java.awt.Color(94, 96, 115));
        Cb_Cuetna.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Cb_Cuetna.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)), "Cuenta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(242, 244, 209))); // NOI18N

        Cb_TipoCuentas.setBackground(new java.awt.Color(94, 96, 115));
        Cb_TipoCuentas.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Cb_TipoCuentas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)), "Tipo cuenta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(242, 244, 209))); // NOI18N
        Cb_TipoCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_TipoCuentasActionPerformed(evt);
            }
        });

        Cb_TipoSaldo.setBackground(new java.awt.Color(94, 96, 115));
        Cb_TipoSaldo.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Cb_TipoSaldo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deudor", "Acreedor" }));
        Cb_TipoSaldo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)), "Tipo saldo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(242, 244, 209))); // NOI18N
        Cb_TipoSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_TipoSaldoActionPerformed(evt);
            }
        });

        Tbl_LibroDiario.setAutoCreateRowSorter(true);
        Tbl_LibroDiario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        Tbl_LibroDiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cuenta", "Debe", "Haber"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_LibroDiario);
        if (Tbl_LibroDiario.getColumnModel().getColumnCount() > 0) {
            Tbl_LibroDiario.getColumnModel().getColumn(0).setPreferredWidth(80);
            Tbl_LibroDiario.getColumnModel().getColumn(1).setPreferredWidth(300);
            Tbl_LibroDiario.getColumnModel().getColumn(2).setPreferredWidth(100);
            Tbl_LibroDiario.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        Btn_AgregarPartida.setBackground(new java.awt.Color(137, 163, 178));
        Btn_AgregarPartida.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_AgregarPartida.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_AgregarPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_AgregarPartidaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_AgregarPartidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_AgregarPartidaMouseExited(evt);
            }
        });
        Btn_AgregarPartida.setLayout(new java.awt.GridBagLayout());

        Lb_TipoCuentas.setBackground(new java.awt.Color(7, 3, 26));
        Lb_TipoCuentas.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_TipoCuentas.setForeground(new java.awt.Color(242, 244, 209));
        Lb_TipoCuentas.setText("Agregar a libro diario");
        Btn_AgregarPartida.add(Lb_TipoCuentas, new java.awt.GridBagConstraints());

        Btn_AgregarPartida2.setBackground(new java.awt.Color(137, 163, 178));
        Btn_AgregarPartida2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_AgregarPartida2.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_AgregarPartida2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_AgregarPartida2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_AgregarPartida2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_AgregarPartida2MouseExited(evt);
            }
        });
        Btn_AgregarPartida2.setLayout(new java.awt.GridBagLayout());

        Lb_TipoCuentas2.setBackground(new java.awt.Color(7, 3, 26));
        Lb_TipoCuentas2.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_TipoCuentas2.setForeground(new java.awt.Color(242, 244, 209));
        Lb_TipoCuentas2.setText("Agregar");
        Btn_AgregarPartida2.add(Lb_TipoCuentas2, new java.awt.GridBagConstraints());

        Lb_Error.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        Lb_Error.setForeground(new java.awt.Color(178, 211, 190));
        Lb_Error.setText("Error");

        javax.swing.GroupLayout jp_MainLayout = new javax.swing.GroupLayout(jp_Main);
        jp_Main.setLayout(jp_MainLayout);
        jp_MainLayout.setHorizontalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MainLayout.createSequentialGroup()
                .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_MainLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Cb_TipoCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cb_TipoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cb_Cuetna, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Tb_Saldo, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_AgregarPartida2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_MainLayout.createSequentialGroup()
                        .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_MainLayout.createSequentialGroup()
                                .addGap(856, 856, 856)
                                .addComponent(Lb_Error, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jp_MainLayout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_AgregarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jp_MainLayout.setVerticalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MainLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Cb_Cuetna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Tb_Saldo)
                        .addComponent(Cb_TipoCuentas)
                        .addComponent(Cb_TipoSaldo))
                    .addComponent(Btn_AgregarPartida2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lb_Error)
                .addGap(57, 57, 57)
                .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_AgregarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jp_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jp_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void Get_Cb_TipoCuenta(JComboBox ComboBox) {
        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_TipoCuenta = Objeto_TipoCuenta.Get_TipoCuentas();
        System.out.println("hay " + List_TipoCuenta.size());

        for (Modelo_TipoCuenta item : List_TipoCuenta) {
            ModeloComboBox.addElement(item.getNombreTipoCuenta());
        }

        ComboBox.setModel(ModeloComboBox);
    }

    public void Get_Cb_Cuetnas(JComboBox ComboBox) {

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();
        int id_tipocuetna = Cb_TipoCuentas.getSelectedIndex() + 1;

        List_Cuenta = Objeto_Cuenta.Get_CatalogoFiltrado(id_tipocuetna);
        System.out.println("hay " + List_Cuenta.size());

        for (Modelo_Catalogo item : List_Cuenta) {
            ModeloComboBox.addElement(item.getId_Cuenta() + " ) " + item.getNombreCuenta());
        }

        ComboBox.setModel(ModeloComboBox);
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
        tabla.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);

        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(60, 45));

    }

    private void Tb_SaldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_SaldoMouseClicked
        Tb_Saldo.setText("");
    }//GEN-LAST:event_Tb_SaldoMouseClicked

    private void Tb_SaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tb_SaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tb_SaldoActionPerformed

    private void Cb_TipoCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_TipoCuentasActionPerformed
        Get_Cb_Cuetnas(Cb_Cuetna);
        System.out.println("oooo");

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

    private void Btn_AgregarPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarPartidaMouseClicked

//        int LastRow = modeloTabla.getRowCount();
//        Double SubtotalDebe = Double.valueOf(modeloTabla.getValueAt(LastRow, 2).toString());
//        Double SubtotalHaber = Double.valueOf(modeloTabla.getValueAt(LastRow, 3).toString());
//
//        if (SubtotalDebe.equals(SubtotalHaber)) {
//            System.out.println("Todo bien");
//        } else {
//            System.out.println("mal");
//        }

    }//GEN-LAST:event_Btn_AgregarPartidaMouseClicked

    private void Btn_AgregarPartidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarPartidaMouseEntered
        EnterMouse(Btn_AgregarPartida, Lb_TipoCuentas, "#ABBEC8", "#FFFFFF");
    }//GEN-LAST:event_Btn_AgregarPartidaMouseEntered

    private void Btn_AgregarPartidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarPartidaMouseExited
        LeftMouse(Btn_AgregarPartida, Lb_TipoCuentas, "#89A3B2", "#F2F4D1");
    }//GEN-LAST:event_Btn_AgregarPartidaMouseExited

    private void Cb_TipoSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_TipoSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cb_TipoSaldoActionPerformed

    private void Btn_AgregarPartida1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarPartida1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_AgregarPartida1MouseClicked

    private void Btn_AgregarPartida1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarPartida1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_AgregarPartida1MouseEntered

    private void Btn_AgregarPartida1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarPartida1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_AgregarPartida1MouseExited

    private void Btn_AgregarPartida2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarPartida2MouseClicked
        int tipoSaldo = Cb_TipoSaldo.getSelectedIndex();
        int Codigo = Funciones.convertirStringAInt(Cb_Cuetna.getSelectedItem().toString());
        String Cuenta = Funciones.eliminarNumeros(Cb_Cuetna.getSelectedItem().toString());
        Double Saldo = Double.valueOf(Tb_Saldo.getText());

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            if (modeloTabla.getValueAt(i, 1) == "Sub-Total:") {
                modeloTabla.removeRow(i);
            }
        }

        if (tipoSaldo == 0) {
            modeloTabla.addRow(new Object[]{Codigo, Cuenta, Saldo, ""});
        }
        if (tipoSaldo == 1) {
            modeloTabla.addRow(new Object[]{Codigo, Cuenta, "", Saldo});
        }

        // Variables para almacenar los valores de las columnas 2 y 3
        double SubtotalDebe = 0;
        double SubtotalHaber = 0;

        // Recorrer las filas de la tabla
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            // Obtener el valor de la columna 2 (índice 2) y columna 3 (índice 3)
            String valorColumna2 = modeloTabla.getValueAt(i, 2).toString();
            String valorColumna3 = modeloTabla.getValueAt(i, 3).toString();

            // Convertir a double y manejar posibles excepciones
            try {
                if (!valorColumna2.isEmpty()) {
                    SubtotalDebe += Double.parseDouble(valorColumna2);
                }
                if (!valorColumna3.isEmpty()) {
                    SubtotalHaber += Double.parseDouble(valorColumna3);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir a double: " + e.getMessage());
            }

            // Aquí puedes hacer lo que necesites con columna2 y columna3
        }

        int cantRows = modeloTabla.getRowCount();

        modeloTabla.addRow(new Object[]{"", "Sub-Total:", SubtotalDebe, SubtotalHaber});


    }//GEN-LAST:event_Btn_AgregarPartida2MouseClicked

    private void Btn_AgregarPartida2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarPartida2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_AgregarPartida2MouseEntered

    private void Btn_AgregarPartida2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarPartida2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_AgregarPartida2MouseExited

    private void Tb_SaldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tb_SaldoKeyTyped
        ValidarSaldo(Tb_Saldo, Lb_Error);

    }//GEN-LAST:event_Tb_SaldoKeyTyped

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
            java.util.logging.Logger.getLogger(Gestion__PartidaNueva.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion__PartidaNueva.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion__PartidaNueva.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion__PartidaNueva.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion__PartidaNueva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_AgregarPartida;
    private javax.swing.JPanel Btn_AgregarPartida1;
    private javax.swing.JPanel Btn_AgregarPartida2;
    private javax.swing.JComboBox<String> Cb_Cuetna;
    private javax.swing.JComboBox<String> Cb_TipoCuentas;
    private javax.swing.JComboBox<String> Cb_TipoSaldo;
    private javax.swing.JLabel Lb_Bienvenida;
    private javax.swing.JLabel Lb_CantidadCuentas;
    private javax.swing.JLabel Lb_Error;
    private javax.swing.JLabel Lb_TipoCuentas;
    private javax.swing.JLabel Lb_TipoCuentas1;
    private javax.swing.JLabel Lb_TipoCuentas2;
    private javax.swing.JTextField Tb_Saldo;
    private javax.swing.JTable Tbl_LibroDiario;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_Main;
    // End of variables declaration//GEN-END:variables
}
