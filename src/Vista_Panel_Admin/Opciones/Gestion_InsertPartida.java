package Vista_Panel_Admin.Opciones;

import Customizacion.TablaCusomizada;
import Funciones.Funciones;
import static Funciones.Funciones.EnterMouse;
import static Funciones.Funciones.LeftMouse;
import static Funciones.Funciones.ValidarSaldo;
import Modelos.Contador.Modelo_Catalogo;
import Modelos.Contador.Modelo_Partida;
import Modelos.Contador.Modelo_TipoCuenta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
public final class Gestion_InsertPartida extends javax.swing.JFrame {

    private static final Modelo_TipoCuenta Objeto_TipoCuenta = new Modelo_TipoCuenta();
    private static List<Modelo_TipoCuenta> List_TipoCuenta;

    private static final Modelo_Catalogo Objeto_Cuenta = new Modelo_Catalogo();
    private static List<Modelo_Catalogo> List_Cuenta;

    private DefaultTableModel modeloTabla = new DefaultTableModel();

    public Gestion_InsertPartida() {
        initComponents();
        setLocationRelativeTo(this);

        Get_Cb_TipoCuenta(Cb_TipoCuentas);
        Cb_TipoCuentas.setSelectedItem(0);
        Get_Cb_Cuetnas(Cb_Cuetna);

        modeloTabla = (DefaultTableModel) Tbl_LibroDiario.getModel();
        DiseñoTabla(Tbl_LibroDiario);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jp_Main = new javax.swing.JPanel();
        Tb_Saldo = new javax.swing.JTextField();
        Cb_Cuetna = new javax.swing.JComboBox<>();
        Cb_TipoCuentas = new javax.swing.JComboBox<>();
        Cb_TipoSaldo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_LibroDiario = new javax.swing.JTable();
        Btn_AgregarALibroDiario = new Customizacion.Custom_Buttons();
        Lb_TipoCuentas = new javax.swing.JLabel();
        Btn_AgregarPartida = new Customizacion.Custom_Buttons();
        Lb_TipoCuentas2 = new javax.swing.JLabel();
        Lb_Error = new javax.swing.JLabel();
        Tb_Concepto = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        Lb_Bienvenida = new javax.swing.JLabel();
        Lb_CantidadCuentas = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Btn_Regresar = new javax.swing.JPanel();
        Lb_Regresar3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(242, 244, 209));

        jp_Main.setBackground(new java.awt.Color(178, 211, 190));
        jp_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        Tb_Saldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Tb_SaldoKeyTyped(evt);
            }
        });
        jp_Main.add(Tb_Saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 150, 52));

        Cb_Cuetna.setBackground(new java.awt.Color(94, 96, 115));
        Cb_Cuetna.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Cb_Cuetna.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)), "Cuenta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(242, 244, 209))); // NOI18N
        jp_Main.add(Cb_Cuetna, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 500, -1));

        Cb_TipoCuentas.setBackground(new java.awt.Color(94, 96, 115));
        Cb_TipoCuentas.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Cb_TipoCuentas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)), "Tipo cuenta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(242, 244, 209))); // NOI18N
        Cb_TipoCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_TipoCuentasActionPerformed(evt);
            }
        });
        jp_Main.add(Cb_TipoCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 260, -1));

        Cb_TipoSaldo.setBackground(new java.awt.Color(94, 96, 115));
        Cb_TipoSaldo.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Cb_TipoSaldo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deudor", "Acreedor" }));
        Cb_TipoSaldo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)), "Tipo saldo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(242, 244, 209))); // NOI18N
        jp_Main.add(Cb_TipoSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 220, -1));

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

        jp_Main.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 727, 240));

        Btn_AgregarALibroDiario.setBackground(new java.awt.Color(137, 163, 178));
        Btn_AgregarALibroDiario.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(94, 147, 178)));
        Btn_AgregarALibroDiario.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_AgregarALibroDiario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_AgregarALibroDiarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_AgregarALibroDiarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_AgregarALibroDiarioMouseExited(evt);
            }
        });
        Btn_AgregarALibroDiario.setLayout(new java.awt.GridBagLayout());

        Lb_TipoCuentas.setBackground(new java.awt.Color(7, 3, 26));
        Lb_TipoCuentas.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_TipoCuentas.setForeground(new java.awt.Color(242, 244, 209));
        Lb_TipoCuentas.setText("Agregar a libro diario");
        Btn_AgregarALibroDiario.add(Lb_TipoCuentas, new java.awt.GridBagConstraints());

        jp_Main.add(Btn_AgregarALibroDiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 360, 201, -1));

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

        Lb_TipoCuentas2.setBackground(new java.awt.Color(7, 3, 26));
        Lb_TipoCuentas2.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_TipoCuentas2.setForeground(new java.awt.Color(242, 244, 209));
        Lb_TipoCuentas2.setText("Agregar");
        Btn_AgregarPartida.add(Lb_TipoCuentas2, new java.awt.GridBagConstraints());

        jp_Main.add(Btn_AgregarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 200, -1));

        Lb_Error.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        Lb_Error.setForeground(new java.awt.Color(178, 211, 190));
        Lb_Error.setText("Error");
        jp_Main.add(Lb_Error, new org.netbeans.lib.awtextra.AbsoluteConstraints(1187, 98, 145, -1));

        Tb_Concepto.setBackground(new java.awt.Color(94, 96, 115));
        Tb_Concepto.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Tb_Concepto.setForeground(new java.awt.Color(255, 255, 255));
        Tb_Concepto.setText("Concepto");
        Tb_Concepto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Concepto: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(242, 244, 209))); // NOI18N
        Tb_Concepto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_ConceptoMouseClicked(evt);
            }
        });
        Tb_Concepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tb_ConceptoActionPerformed(evt);
            }
        });
        Tb_Concepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Tb_ConceptoKeyTyped(evt);
            }
        });
        jp_Main.add(Tb_Concepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 340, 52));

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

        Btn_Regresar.setBackground(new java.awt.Color(152, 5, 5));
        Btn_Regresar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 10, 0, new java.awt.Color(247, 17, 17)));
        Btn_Regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar.setMinimumSize(new java.awt.Dimension(160, 92));
        Btn_Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_RegresarMouseClicked(evt);
            }
        });
        Btn_Regresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lb_Regresar3.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Lb_Regresar3.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Regresar3.setText("Regresar");
        Lb_Regresar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar.add(Lb_Regresar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 130, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jp_Main, javax.swing.GroupLayout.DEFAULT_SIZE, 1335, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Btn_Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(Btn_Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jp_Main, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
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
        //tabla.setBackground(Color.lightGray);
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

    private Boolean ValidarSaldos(Double SubtotalDebe, Double SubtotalHaber) {
        if (SubtotalDebe.equals(SubtotalHaber)) {
            System.out.println("Todo bien");

            return true;
        } else {
            System.out.println("mal");
            return false;

        }
    }

    private void Btn_AgregarPartidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarPartidaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_AgregarPartidaMouseExited

    private void Btn_AgregarPartidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarPartidaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_AgregarPartidaMouseEntered

    private void Btn_AgregarPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarPartidaMouseClicked
        String tipoSaldo = Cb_TipoSaldo.getSelectedItem().toString();
        int Codigo = Funciones.convertirStringAInt(Cb_Cuetna.getSelectedItem().toString());
        String Cuenta = Funciones.eliminarNumeros(Cb_Cuetna.getSelectedItem().toString());
        Double Saldo = Double.valueOf(Tb_Saldo.getText());

        for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--) {
            if (modeloTabla.getValueAt(i, 0).equals("")) {
                modeloTabla.removeRow(i);
            }
        }

        //Verificando saldo ingresado
        if (tipoSaldo.equals("Deudor")) {
            modeloTabla.addRow(new Object[]{Codigo, Cuenta, Saldo, ""});
        }
        if (tipoSaldo.equals("Acreedor")) {
            modeloTabla.addRow(new Object[]{Codigo, Cuenta, "", Saldo});
        }

        double SubtotalDebe = 0;
        double SubtotalHaber = 0;

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            String Sub_TotalDebe = modeloTabla.getValueAt(i, 2).toString();
            String Sub_TotalHaber = modeloTabla.getValueAt(i, 3).toString();

            try {
                if (!Sub_TotalDebe.isEmpty()) {
                    SubtotalDebe += Double.parseDouble(Sub_TotalDebe);
                }
                if (!Sub_TotalHaber.isEmpty()) {
                    SubtotalHaber += Double.parseDouble(Sub_TotalHaber);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir a double: " + e.getMessage());
            }

        }

        modeloTabla.addRow(new Object[]{"", "", "", ""});
        modeloTabla.addRow(new Object[]{"", "Sub-Total:", SubtotalDebe, SubtotalHaber});

    }//GEN-LAST:event_Btn_AgregarPartidaMouseClicked

    private void Btn_AgregarALibroDiarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarALibroDiarioMouseExited
        LeftMouse(Btn_AgregarALibroDiario, Lb_TipoCuentas, "#89A3B2", "#F2F4D1");
    }//GEN-LAST:event_Btn_AgregarALibroDiarioMouseExited

    private void Btn_AgregarALibroDiarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarALibroDiarioMouseEntered
        EnterMouse(Btn_AgregarALibroDiario, Lb_TipoCuentas, "#ABBEC8", "#FFFFFF");
    }//GEN-LAST:event_Btn_AgregarALibroDiarioMouseEntered

    private void Btn_AgregarALibroDiarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AgregarALibroDiarioMouseClicked

        int LastRow = modeloTabla.getRowCount() - 1;
        System.out.println(">" + LastRow);
        Double Sub_totalDebe = Double.valueOf(modeloTabla.getValueAt(LastRow, 2).toString());
        Double Sub_totalHaber = Double.valueOf(modeloTabla.getValueAt(LastRow, 3).toString());
        String Concepto = Tb_Concepto.getText();

        if (!ValidarSaldos(Sub_totalDebe, Sub_totalHaber)) {
            Funciones.showMessageDialog("Error", "Saldos incorrectos");
            return; // Detiene la ejecución del método

        }

        Date fecha = Funciones.obtenerFechaActual();
        int Cant_partidas = modeloTabla.getRowCount() - 2;

        System.out.println("cantidad de par " + Cant_partidas);

        Modelo_Partida partida = new Modelo_Partida();

        ArrayList<Modelo_Partida> ListId;

        for (int i = 0; i < Cant_partidas; i++) {
            partida.InsertarLibroDiario();
        }

        ListId = partida.Get_idPartidaActual(Cant_partidas);
        ArrayList<Modelo_Partida> ListPartidas = new ArrayList<>();

        for (int i = 0; i < Cant_partidas; i++) {
            int codigo = Integer.parseInt(modeloTabla.getValueAt(i, 0).toString());
            int TipoSaldo = 0;
            Double Monto = 0.0;

            if (!modeloTabla.getValueAt(i, 2).toString().equals("")) {
                Monto = Double.valueOf(modeloTabla.getValueAt(i, 2).toString());
                TipoSaldo = 1;
                System.out.println("saldo dudor " + Monto);

            }
            if ((!modeloTabla.getValueAt(i, 3).toString().equals(""))) {

                Monto = Double.valueOf(modeloTabla.getValueAt(i, 3).toString());
                TipoSaldo = 2;
                System.out.println("saldo acreedor " + Monto);
            }

            System.out.println("id de partida id>" + ListId.get(i).getId_Partida());

            Modelo_Partida diario = new Modelo_Partida();
            diario.setId_Cuenta(codigo);
            diario.setId_TipoSaldo(TipoSaldo);
            diario.setId_TipoDocumento(0);
            diario.setMonto(Monto);
            diario.setFecha(fecha);
            diario.setId_Partida(ListId.get(i).getId_Partida());

            //agregar concepto 
            ListPartidas.add(diario);
        }

        try {
            partida.insertarPartidas(ListPartidas, Concepto);
        } catch (SQLException ex) {
            Logger.getLogger(Gestion_InsertPartida.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Btn_AgregarALibroDiarioMouseClicked

    private void Cb_TipoCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_TipoCuentasActionPerformed
        Get_Cb_Cuetnas(Cb_Cuetna);
        System.out.println("****Obteniendo cuentas\n");

    }//GEN-LAST:event_Cb_TipoCuentasActionPerformed

    private void Tb_SaldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tb_SaldoKeyTyped
        ValidarSaldo(Tb_Saldo, Lb_Error);
    }//GEN-LAST:event_Tb_SaldoKeyTyped

    private void Tb_SaldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_SaldoMouseClicked
        Tb_Saldo.setText("");
    }//GEN-LAST:event_Tb_SaldoMouseClicked

    private void Btn_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseClicked
        dispose();

    }//GEN-LAST:event_Btn_RegresarMouseClicked

    private void Tb_ConceptoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_ConceptoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Tb_ConceptoMouseClicked

    private void Tb_ConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tb_ConceptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tb_ConceptoActionPerformed

    private void Tb_ConceptoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tb_ConceptoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Tb_ConceptoKeyTyped

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
            java.util.logging.Logger.getLogger(Gestion_InsertPartida.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_InsertPartida.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_InsertPartida.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_InsertPartida.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_InsertPartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_AgregarALibroDiario;
    private javax.swing.JPanel Btn_AgregarPartida;
    private javax.swing.JPanel Btn_Regresar;
    private javax.swing.JComboBox<String> Cb_Cuetna;
    private javax.swing.JComboBox<String> Cb_TipoCuentas;
    private javax.swing.JComboBox<String> Cb_TipoSaldo;
    private javax.swing.JLabel Lb_Bienvenida;
    private javax.swing.JLabel Lb_CantidadCuentas;
    private javax.swing.JLabel Lb_Error;
    private javax.swing.JLabel Lb_Regresar3;
    private javax.swing.JLabel Lb_TipoCuentas;
    private javax.swing.JLabel Lb_TipoCuentas2;
    private javax.swing.JTextField Tb_Concepto;
    private javax.swing.JTextField Tb_Saldo;
    private javax.swing.JTable Tbl_LibroDiario;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_Main;
    // End of variables declaration//GEN-END:variables
}
