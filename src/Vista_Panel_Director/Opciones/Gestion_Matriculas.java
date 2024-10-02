package Vista_Panel_Director.Opciones;

import Customizacion.TablaCusomizada;
import Funciones.Funciones;
import static Funciones.Funciones.EnterMouse;
import Modelos.Docente.Modelo_Grados;
import Modelos.Secretaria.Modelo_RegistrosInscripciones;
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

public final class Gestion_Matriculas extends javax.swing.JFrame {
//vas a darle refactor a este form y a la clase manipuladora de la base de datos
//lo que cambiaria es el diseno, y las clases para el objeto y lista

    //Vas a ocupar este par de objetos, el objeto de la clase que manipula la base de datos
    //y la lista de objetos de del mismo tipo para llenar las tablas 
    private final Modelo_RegistrosInscripciones Objeto_RegistrosInscripciones = new Modelo_RegistrosInscripciones();
    private List<Modelo_RegistrosInscripciones> List_RegistrosInscripciones;

    private final Modelo_Grados Objeto_Grados = new Modelo_Grados();
    private List<Modelo_Grados> List_Grados;

    //el modelo de tabla para manipular la tabla
    private DefaultTableModel modeloTabla = new DefaultTableModel();

    public Gestion_Matriculas() {
        initComponents();
        setLocationRelativeTo(this);
        modeloTabla = (DefaultTableModel) Tbl_RegistroInscripcion.getModel();

        Get_Cb_Grados(Cb_Grados,List_Grados,Objeto_Grados);
        Get_Tbl_Inscripciones(Tbl_RegistroInscripcion);
        DiseñoTabla(Tbl_RegistroInscripcion);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Lb_Total = new javax.swing.JLabel();
        Cb_Grados = new javax.swing.JComboBox<>();
        TB_CodigoResponsable = new javax.swing.JTextField();
        TB_NIE = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Lb_Aerolinea3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_RegistroInscripcion = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        Lb_Materia_Periodo2 = new javax.swing.JLabel();
        errorTb_CodigoResponsable = new javax.swing.JLabel();
        errorTb_NIE = new javax.swing.JLabel();
        Cb_Año = new javax.swing.JComboBox<>();
        Cb_Mes = new javax.swing.JComboBox<>();
        Btn_Regresar = new javax.swing.JPanel();
        Lb_atras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(234, 223, 180));
        jPanel1.setMinimumSize(new java.awt.Dimension(1160, 600));
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 10, 180, 30));

        Cb_Grados.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Grados.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Grados.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Grados.setToolTipText("");
        Cb_Grados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Grado: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Grados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_GradosActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Grados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 140, -1));

        TB_CodigoResponsable.setBackground(new java.awt.Color(224, 213, 170));
        TB_CodigoResponsable.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_CodigoResponsable.setForeground(new java.awt.Color(0, 0, 0));
        TB_CodigoResponsable.setText("Ingrese el codigo del responsable");
        TB_CodigoResponsable.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Codigo responsable: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        TB_CodigoResponsable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TB_CodigoResponsableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TB_CodigoResponsableMouseExited(evt);
            }
        });
        TB_CodigoResponsable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TB_CodigoResponsableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TB_CodigoResponsableKeyTyped(evt);
            }
        });
        jPanel1.add(TB_CodigoResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 270, 50));

        TB_NIE.setBackground(new java.awt.Color(224, 213, 170));
        TB_NIE.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        TB_NIE.setForeground(new java.awt.Color(0, 0, 0));
        TB_NIE.setText("Ingrese NIE del estudiante");
        TB_NIE.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "NIE estudiante", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        TB_NIE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TB_NIEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TB_NIEMouseExited(evt);
            }
        });
        TB_NIE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TB_NIEKeyReleased(evt);
            }
        });
        jPanel1.add(TB_NIE, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 270, 50));

        jPanel4.setBackground(new java.awt.Color(226, 215, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Lb_Aerolinea2.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea2.setText("Registro de inscripciones ");

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

        Tbl_RegistroInscripcion.setAutoCreateRowSorter(true);
        Tbl_RegistroInscripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 51)));
        Tbl_RegistroInscripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "iD", "Apellidos", "Nombres", "Tipo A", "Apellidos", "Nombres", "Tipo B", "Nombres", "Apellidos", "NIE", "Grado", "Fecha", "Direccion", "Correo", "desc.", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tbl_RegistroInscripcion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane1.setViewportView(Tbl_RegistroInscripcion);
        if (Tbl_RegistroInscripcion.getColumnModel().getColumnCount() > 0) {
            Tbl_RegistroInscripcion.getColumnModel().getColumn(0).setPreferredWidth(30);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(1).setPreferredWidth(100);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(2).setPreferredWidth(100);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(3).setPreferredWidth(60);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(4).setPreferredWidth(100);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(5).setPreferredWidth(100);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(6).setPreferredWidth(60);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(7).setPreferredWidth(150);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(8).setPreferredWidth(150);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(9).setPreferredWidth(60);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(10).setPreferredWidth(150);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(11).setPreferredWidth(80);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(12).setPreferredWidth(150);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(13).setPreferredWidth(200);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(14).setPreferredWidth(60);
            Tbl_RegistroInscripcion.getColumnModel().getColumn(15).setPreferredWidth(80);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 1430, 310));

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
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(Lb_Materia_Periodo2)
                .addGap(16, 16, 16))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(Lb_Materia_Periodo2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 180, 30));

        errorTb_CodigoResponsable.setBackground(new java.awt.Color(23, 42, 56));
        errorTb_CodigoResponsable.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        errorTb_CodigoResponsable.setForeground(new java.awt.Color(23, 42, 56));
        errorTb_CodigoResponsable.setText("Error");
        jPanel1.add(errorTb_CodigoResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 280, -1));

        errorTb_NIE.setBackground(new java.awt.Color(23, 42, 56));
        errorTb_NIE.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        errorTb_NIE.setForeground(new java.awt.Color(23, 42, 56));
        errorTb_NIE.setText("Error");
        jPanel1.add(errorTb_NIE, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 280, -1));

        Cb_Año.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Año.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Año.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Año.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", "2026" }));
        Cb_Año.setToolTipText("");
        Cb_Año.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Año :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Año.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_AñoActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Año, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 134, -1));

        Cb_Mes.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Mes.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Mes.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        Cb_Mes.setToolTipText("");
        Cb_Mes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Mes :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_MesActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 134, -1));

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

        jPanel1.add(Btn_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1446, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void Get_Cb_Grados(JComboBox ComboBox,List<Modelo_Grados> List_Grados,Modelo_Grados Objeto_Grados ) {

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_Grados = Objeto_Grados.Get_Grados();
        System.out.println("hay " + List_Grados.size());

        for (Modelo_Grados item : List_Grados) {
            ModeloComboBox.addElement(item.getGrado());
        }

        ComboBox.setModel(ModeloComboBox);
    }

    private void Cb_GradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_GradosActionPerformed

        modeloTabla.setNumRows(0);
        Get_Inscripciones_FiltroGrado(Tbl_RegistroInscripcion);
    }//GEN-LAST:event_Cb_GradosActionPerformed

    private void TB_CodigoResponsableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_CodigoResponsableMouseEntered
        Funciones.Mouse_EnterTextbox(TB_CodigoResponsable);
    }//GEN-LAST:event_TB_CodigoResponsableMouseEntered

    private void TB_CodigoResponsableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_CodigoResponsableMouseExited
        Funciones.Mouse_LeftTextbox("Ingrese el codigo del responsable", TB_CodigoResponsable);
    }//GEN-LAST:event_TB_CodigoResponsableMouseExited

    private void TB_CodigoResponsableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_CodigoResponsableKeyReleased

    }//GEN-LAST:event_TB_CodigoResponsableKeyReleased

    private void TB_CodigoResponsableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_CodigoResponsableKeyTyped
        //ValidNIE(TB_CodigoResponsable, errorTb_CodigoResponsable);

        // TODO add your handling code here:
    }//GEN-LAST:event_TB_CodigoResponsableKeyTyped

    private void TB_NIEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_NIEMouseEntered
        Funciones.Mouse_EnterTextbox(TB_NIE);
    }//GEN-LAST:event_TB_NIEMouseEntered

    private void TB_NIEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_NIEMouseExited
        Funciones.Mouse_LeftTextbox("Ingrese NIE del estudiante", TB_NIE);
    }//GEN-LAST:event_TB_NIEMouseExited

    private void TB_NIEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_NIEKeyReleased
        // ValidNIE(TB_NIE, errorTb_NIE);
    }//GEN-LAST:event_TB_NIEKeyReleased

    private void Cb_AñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_AñoActionPerformed
        Get_Inscripciones_FiltroYear(Tbl_RegistroInscripcion);
    }//GEN-LAST:event_Cb_AñoActionPerformed

    private void Cb_MesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_MesActionPerformed
        Get_Inscripciones_FiltroMes(Tbl_RegistroInscripcion);
    }//GEN-LAST:event_Cb_MesActionPerformed

    private void Btn_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseClicked
        Panel_Director1 gest = new Panel_Director1();
        gest.setVisible(true);
        dispose();
    }//GEN-LAST:event_Btn_RegresarMouseClicked

    private void Btn_RegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseEntered
        EnterMouse(Btn_Regresar, Lb_atras, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_RegresarMouseEntered

    private void Btn_RegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_RegresarMouseExited

    public void Get_Inscripciones_FiltroGrado(JTable tabla) {
        int Grado = Cb_Grados.getSelectedIndex() + 1;
        modeloTabla.setNumRows(0);

        System.out.println("buscando por gardo: " + Grado);
        List_RegistrosInscripciones = Objeto_RegistrosInscripciones.Get_Inscripciones_Filtro_Grados(Grado);
        System.out.println("Hay " + List_RegistrosInscripciones.size() + " registros en la lista.");

        double Utilidades = 0;

        for (Modelo_RegistrosInscripciones item : List_RegistrosInscripciones) {

            modeloTabla.addRow(new Object[]{
                item.getId(),
                item.getApellidos_A(), item.getNombres_A(),
                item.getTipoResponsables_A(),
                item.getApellidos_B(), item.getNombres_B(),
                item.getTipoResponsables_B(),
                item.getApellidos_Estudiante(), item.getNombres_Estudiante(),
                item.getNIE(),
                item.getGrado(),
                item.getFecha(),
                item.getDireccion(),
                item.getCorreo(),
                item.getDescuento(),
                item.getMonto()

            });

            Utilidades += item.getMonto();
        }
        tabla.setModel(modeloTabla);
        Lb_Total.setText(Utilidades + " $");

    }

    public void Get_Inscripciones_FiltroYear(JTable tabla) {
        int year = Integer.parseInt(Cb_Año.getSelectedItem().toString());
        modeloTabla.setNumRows(0);

        System.out.println("buscando por year: " + year);
        List_RegistrosInscripciones = Objeto_RegistrosInscripciones.Get_Inscripciones_Filtro_Year(year);
        System.out.println("Hay " + List_RegistrosInscripciones.size() + " registros en la lista.");

        double Utilidades = 0;

        for (Modelo_RegistrosInscripciones item : List_RegistrosInscripciones) {

            modeloTabla.addRow(new Object[]{
                item.getId(),
                item.getApellidos_A(), item.getNombres_A(),
                item.getTipoResponsables_A(),
                item.getApellidos_B(), item.getNombres_B(),
                item.getTipoResponsables_B(),
                item.getApellidos_Estudiante(), item.getNombres_Estudiante(),
                item.getNIE(),
                item.getGrado(),
                item.getFecha(),
                item.getDireccion(),
                item.getCorreo(),
                item.getDescuento(),
                item.getMonto()

            });

            Utilidades += item.getMonto();
        }
        
        tabla.setModel(modeloTabla);
        Lb_Total.setText(Utilidades + " $");

    }

    public void Get_Inscripciones_FiltroMes(JTable tabla) {
        int mes = Cb_Mes.getSelectedIndex() + 1;
        modeloTabla.setNumRows(0);

        System.out.println("buscando por mes: " + mes);
        List_RegistrosInscripciones = Objeto_RegistrosInscripciones.Get_Inscripciones_Filtro_Mes(mes);
        System.out.println("Hay " + List_RegistrosInscripciones.size() + " registros en la lista.");

        double Utilidades = 0;

        for (Modelo_RegistrosInscripciones item : List_RegistrosInscripciones) {

            modeloTabla.addRow(new Object[]{
                item.getId(),
                item.getApellidos_A(), item.getNombres_A(),
                item.getTipoResponsables_A(),
                item.getApellidos_B(), item.getNombres_B(),
                item.getTipoResponsables_B(),
                item.getApellidos_Estudiante(), item.getNombres_Estudiante(),
                item.getNIE(),
                item.getGrado(),
                item.getFecha(),
                item.getDireccion(),
                item.getCorreo(),
                item.getDescuento(),
                item.getMonto()

            });

            Utilidades += item.getMonto();
        }
        tabla.setModel(modeloTabla);
        Lb_Total.setText(Utilidades + " $");

    }

    //etse metodo llena las tablas, este mismo vas a utilizar en todos, con la diferencia de la cantidad de columnas y los gets del item
    public void Get_Tbl_Inscripciones(JTable tabla) {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setNumRows(0);

        double Utilidades = 0;

        List_RegistrosInscripciones = Objeto_RegistrosInscripciones.Get_Inscripciones();//aca con el objeto manipulas la db y llenas una lista del objeto 
        System.out.println("hay " + List_RegistrosInscripciones.size());

        ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));

        for (Modelo_RegistrosInscripciones item : List_RegistrosInscripciones) {//aca recorres los objetos de la lista *aveces ocupa que cambies el tipo de obj

            modeloTabla.addRow(new Object[]{
                item.getId(),
                item.getApellidos_A(), item.getNombres_A(),
                item.getTipoResponsables_A(),
                item.getApellidos_B(), item.getNombres_B(),
                item.getTipoResponsables_B(),
                item.getApellidos_Estudiante(), item.getNombres_Estudiante(),
                item.getNIE(),
                item.getGrado(),
                item.getFecha(),
                item.getDireccion(),
                item.getCorreo(),
                item.getDescuento(),
                item.getMonto()
            });

            Utilidades += item.getMonto();
        }

        tabla.setModel(modeloTabla);

        Lb_Total.setText(Utilidades + " $");
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

        System.out.println("modelo " + modeloTabla.getRowCount() + " tabla " + Tbl_RegistroInscripcion.getRowCount());
        //Esto renderiza el texto en el centro 
        for (int i = 0; i < Tbl_RegistroInscripcion.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        //aca pone las columnas que quieras que el texto aparezca a la izquierda
        tabla.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
        tabla.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
        tabla.getColumnModel().getColumn(4).setCellRenderer(leftRenderer);
        tabla.getColumnModel().getColumn(5).setCellRenderer(leftRenderer);
        tabla.getColumnModel().getColumn(7).setCellRenderer(leftRenderer);
        tabla.getColumnModel().getColumn(8).setCellRenderer(leftRenderer);
        tabla.getColumnModel().getColumn(12).setCellRenderer(leftRenderer);
        tabla.getColumnModel().getColumn(13).setCellRenderer(leftRenderer);

        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(60, 45));

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Gestion_Matriculas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_Regresar;
    private javax.swing.JComboBox<String> Cb_Año;
    private javax.swing.JComboBox<String> Cb_Grados;
    private javax.swing.JComboBox<String> Cb_Mes;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Aerolinea3;
    private javax.swing.JLabel Lb_Materia_Periodo2;
    private javax.swing.JLabel Lb_Total;
    private javax.swing.JLabel Lb_atras;
    private javax.swing.JTextField TB_CodigoResponsable;
    private javax.swing.JTextField TB_NIE;
    private javax.swing.JTable Tbl_RegistroInscripcion;
    private javax.swing.JLabel errorTb_CodigoResponsable;
    private javax.swing.JLabel errorTb_NIE;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
