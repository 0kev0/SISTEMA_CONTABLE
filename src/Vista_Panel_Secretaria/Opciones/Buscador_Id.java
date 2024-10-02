
package Vista_Panel_Secretaria.Opciones;

import Funciones.Funciones;
import Modelos.Secretaria.Modelo_Estudiante;
import Modelos.Secretaria.Modelo_Matricula;
import Modelos.Secretaria.Modelo_Responsables;
import Vista_Panel_Secretaria.Panel_Secretaria;
import java.util.Date;

public class Buscador_Id extends javax.swing.JFrame {

    public Buscador_Id() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        Txb_Apellido_Alumno = new javax.swing.JTextField();
        Txb_Nombre_Alumno = new javax.swing.JTextField();
        Txb_Direccion = new javax.swing.JTextField();
        TxbTelefono1 = new javax.swing.JTextField();
        Txb_Correo = new javax.swing.JTextField();
        Cb_TipoResponsableA = new javax.swing.JComboBox<>();
        Txb_ApellidosResponsableA = new javax.swing.JTextField();
        Txb_NombresResponsableA = new javax.swing.JTextField();
        Txb_ApellidosResponsableB = new javax.swing.JTextField();
        Txb_NombresResponsableB = new javax.swing.JTextField();
        Cb_TipoResponsable_B = new javax.swing.JComboBox<>();
        loading1 = new javax.swing.JLabel();
        Cb_Grado = new javax.swing.JComboBox<>();
        Cb_Edad = new javax.swing.JComboBox<>();
        TxbTelefono2 = new javax.swing.JTextField();
        Txb_NIE = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Btn_Inscripcion = new Customizacion.Custom_Buttons();
        Btn_Inventario1 = new javax.swing.JPanel();
        Lb_Inventario = new javax.swing.JLabel();
        Btn_Regresar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        Lb_Aerolinea7 = new javax.swing.JLabel();
        Lb_Ordenar = new javax.swing.JLabel();
        Btn_Inscribir = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        Lb_Aerolinea6 = new javax.swing.JLabel();
        Lb_Crearcuenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(17, 66, 50));

        Txb_Apellido_Alumno.setBackground(new java.awt.Color(17, 66, 50));
        Txb_Apellido_Alumno.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_Apellido_Alumno.setForeground(new java.awt.Color(255, 255, 255));
        Txb_Apellido_Alumno.setText("ingrese su apellidos");
        Txb_Apellido_Alumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_Apellido_Alumno.setCaretColor(new java.awt.Color(203, 174, 104));

        Txb_Nombre_Alumno.setBackground(new java.awt.Color(17, 66, 50));
        Txb_Nombre_Alumno.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_Nombre_Alumno.setForeground(new java.awt.Color(255, 255, 255));
        Txb_Nombre_Alumno.setText("ingrese su nombre");
        Txb_Nombre_Alumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_Nombre_Alumno.setCaretColor(new java.awt.Color(17, 66, 50));

        Txb_Direccion.setBackground(new java.awt.Color(17, 66, 50));
        Txb_Direccion.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_Direccion.setForeground(new java.awt.Color(255, 255, 255));
        Txb_Direccion.setText("ingrese su direccion");
        Txb_Direccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Direccion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_Direccion.setCaretColor(new java.awt.Color(203, 174, 104));

        TxbTelefono1.setBackground(new java.awt.Color(17, 66, 50));
        TxbTelefono1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        TxbTelefono1.setForeground(new java.awt.Color(255, 255, 255));
        TxbTelefono1.setText("ingrese su numero de telefono");
        TxbTelefono1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        TxbTelefono1.setCaretColor(new java.awt.Color(203, 174, 104));

        Txb_Correo.setBackground(new java.awt.Color(17, 66, 50));
        Txb_Correo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_Correo.setForeground(new java.awt.Color(255, 255, 255));
        Txb_Correo.setText("ingrese su correo");
        Txb_Correo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_Correo.setCaretColor(new java.awt.Color(203, 174, 104));

        Cb_TipoResponsableA.setBackground(new java.awt.Color(17, 66, 50));
        Cb_TipoResponsableA.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Cb_TipoResponsableA.setForeground(new java.awt.Color(255, 255, 255));
        Cb_TipoResponsableA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de responsable A", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(203, 174, 104))); // NOI18N

        Txb_ApellidosResponsableA.setBackground(new java.awt.Color(17, 66, 50));
        Txb_ApellidosResponsableA.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_ApellidosResponsableA.setForeground(new java.awt.Color(255, 255, 255));
        Txb_ApellidosResponsableA.setText("Ingrese apellidos responsable A");
        Txb_ApellidosResponsableA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos responsable A", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_ApellidosResponsableA.setCaretColor(new java.awt.Color(203, 174, 104));

        Txb_NombresResponsableA.setBackground(new java.awt.Color(17, 66, 50));
        Txb_NombresResponsableA.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_NombresResponsableA.setForeground(new java.awt.Color(255, 255, 255));
        Txb_NombresResponsableA.setText("Ingrese nombres responsable A");
        Txb_NombresResponsableA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres Responsable A", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_NombresResponsableA.setCaretColor(new java.awt.Color(17, 66, 50));

        Txb_ApellidosResponsableB.setBackground(new java.awt.Color(17, 66, 50));
        Txb_ApellidosResponsableB.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_ApellidosResponsableB.setForeground(new java.awt.Color(255, 255, 255));
        Txb_ApellidosResponsableB.setText("Ingrese apellidos responsable B");
        Txb_ApellidosResponsableB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos responsable B", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_ApellidosResponsableB.setCaretColor(new java.awt.Color(203, 174, 104));

        Txb_NombresResponsableB.setBackground(new java.awt.Color(17, 66, 50));
        Txb_NombresResponsableB.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_NombresResponsableB.setForeground(new java.awt.Color(255, 255, 255));
        Txb_NombresResponsableB.setText("Ingrese nombres responsable B");
        Txb_NombresResponsableB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres Responsable B", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_NombresResponsableB.setCaretColor(new java.awt.Color(17, 66, 50));

        Cb_TipoResponsable_B.setBackground(new java.awt.Color(17, 66, 50));
        Cb_TipoResponsable_B.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Cb_TipoResponsable_B.setForeground(new java.awt.Color(255, 255, 255));
        Cb_TipoResponsable_B.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de responsable B", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(203, 174, 104))); // NOI18N

        loading1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        loading1.setForeground(new java.awt.Color(203, 174, 104));
        loading1.setText("Buscador");
        loading1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(203, 174, 104)));

        Cb_Grado.setBackground(new java.awt.Color(17, 66, 50));
        Cb_Grado.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Cb_Grado.setForeground(new java.awt.Color(255, 255, 255));
        Cb_Grado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante", "Responsables" }));
        Cb_Grado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(203, 174, 104))); // NOI18N
        Cb_Grado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Cb_GradoItemStateChanged(evt);
            }
        });

        Cb_Edad.setBackground(new java.awt.Color(17, 66, 50));
        Cb_Edad.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Cb_Edad.setForeground(new java.awt.Color(255, 255, 255));
        Cb_Edad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        Cb_Edad.setSelectedIndex(-1);
        Cb_Edad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edad : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(203, 174, 104))); // NOI18N

        TxbTelefono2.setBackground(new java.awt.Color(17, 66, 50));
        TxbTelefono2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        TxbTelefono2.setForeground(new java.awt.Color(255, 255, 255));
        TxbTelefono2.setText("ingrese su numero de telefono");
        TxbTelefono2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        TxbTelefono2.setCaretColor(new java.awt.Color(203, 174, 104));

        Txb_NIE.setBackground(new java.awt.Color(17, 66, 50));
        Txb_NIE.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_NIE.setForeground(new java.awt.Color(255, 255, 255));
        Txb_NIE.setText("Ingrese NIE");
        Txb_NIE.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_NIE.setCaretColor(new java.awt.Color(203, 174, 104));
        Txb_NIE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Txb_NIEMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Txb_NIEMouseExited(evt);
            }
        });
        Txb_NIE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Txb_NIEKeyTyped(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 0, 0, 0, new java.awt.Color(0, 126, 112)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Inscripcion.setBackground(new java.awt.Color(250, 244, 208));
        Btn_Inscripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 3, new java.awt.Color(255, 204, 0)));
        Btn_Inscripcion.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_Inscripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_InscripcionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_InscripcionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_InscripcionMouseExited(evt);
            }
        });

        Btn_Inventario1.setBackground(new java.awt.Color(255, 255, 102));
        Btn_Inventario1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 153, 0)));
        Btn_Inventario1.setPreferredSize(new java.awt.Dimension(2, 15));

        javax.swing.GroupLayout Btn_Inventario1Layout = new javax.swing.GroupLayout(Btn_Inventario1);
        Btn_Inventario1.setLayout(Btn_Inventario1Layout);
        Btn_Inventario1Layout.setHorizontalGroup(
            Btn_Inventario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );
        Btn_Inventario1Layout.setVerticalGroup(
            Btn_Inventario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        Lb_Inventario.setBackground(new java.awt.Color(7, 3, 26));
        Lb_Inventario.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Inventario.setForeground(new java.awt.Color(7, 3, 26));
        Lb_Inventario.setText("Reinscripcion");

        javax.swing.GroupLayout Btn_InscripcionLayout = new javax.swing.GroupLayout(Btn_Inscripcion);
        Btn_Inscripcion.setLayout(Btn_InscripcionLayout);
        Btn_InscripcionLayout.setHorizontalGroup(
            Btn_InscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Inventario1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_InscripcionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lb_Inventario)
                .addGap(17, 17, 17))
        );
        Btn_InscripcionLayout.setVerticalGroup(
            Btn_InscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_InscripcionLayout.createSequentialGroup()
                .addComponent(Lb_Inventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Inventario1, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE))
        );

        jPanel4.add(Btn_Inscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 150, 50));

        Btn_Regresar.setBackground(new java.awt.Color(152, 5, 5));
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

        jPanel8.setBackground(new java.awt.Color(255, 10, 10));

        Lb_Aerolinea7.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea7.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Lb_Aerolinea7.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea7))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lb_Aerolinea7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Btn_Regresar.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 149, 12));

        Lb_Ordenar.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Lb_Ordenar.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Ordenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back (1).png"))); // NOI18N
        Lb_Ordenar.setText("Regresar");
        Lb_Ordenar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar.add(Lb_Ordenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 130, 30));

        jPanel4.add(Btn_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, -1, -1));

        Btn_Inscribir.setBackground(new java.awt.Color(64, 124, 62));
        Btn_Inscribir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Inscribir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_InscribirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_InscribirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_InscribirMouseExited(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(40, 200, 35));

        Lb_Aerolinea6.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea6.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Lb_Aerolinea6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 119, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea6))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lb_Aerolinea6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Lb_Crearcuenta.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Lb_Crearcuenta.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Crearcuenta.setText("Registrar");
        Lb_Crearcuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout Btn_InscribirLayout = new javax.swing.GroupLayout(Btn_Inscribir);
        Btn_Inscribir.setLayout(Btn_InscribirLayout);
        Btn_InscribirLayout.setHorizontalGroup(
            Btn_InscribirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Btn_InscribirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Crearcuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Btn_InscribirLayout.setVerticalGroup(
            Btn_InscribirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_InscribirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Crearcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, Short.MAX_VALUE))
        );

        jPanel4.add(Btn_Inscribir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, 50));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1159, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(Txb_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(Txb_Correo))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(Txb_NombresResponsableB, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Txb_ApellidosResponsableB)
                                .addGap(18, 18, 18)
                                .addComponent(TxbTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Cb_TipoResponsable_B, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(Txb_NombresResponsableA, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Txb_ApellidosResponsableA)
                                .addGap(18, 18, 18)
                                .addComponent(TxbTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Cb_TipoResponsableA, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(Cb_Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Txb_NIE, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(Txb_Nombre_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Txb_Apellido_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Cb_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(loading1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(loading1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cb_Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txb_NIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txb_Nombre_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txb_Apellido_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cb_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Cb_TipoResponsableA, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxbTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Txb_ApellidosResponsableA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Txb_NombresResponsableA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Txb_ApellidosResponsableB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxbTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cb_TipoResponsable_B, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Txb_NombresResponsableB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txb_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txb_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cb_GradoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cb_GradoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Cb_GradoItemStateChanged

    private void Txb_NIEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_NIEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Txb_NIEMouseClicked

    private void Txb_NIEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_NIEMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Txb_NIEMouseExited

    private void Txb_NIEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txb_NIEKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Txb_NIEKeyTyped

    private void Btn_InscripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_InscripcionMouseClicked
        Panel_Inscripcion gest = new Panel_Inscripcion();
        dispose();
        gest.setVisible(true);
    }//GEN-LAST:event_Btn_InscripcionMouseClicked

    private void Btn_InscripcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_InscripcionMouseEntered
        Funciones.EnterMouse(Btn_Inscripcion, Lb_Inventario, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_InscripcionMouseEntered

    private void Btn_InscripcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_InscripcionMouseExited
        Funciones.LeftMouse(Btn_Inscripcion, Lb_Inventario, "#FAF4D0", "#000000");
    }//GEN-LAST:event_Btn_InscripcionMouseExited

    private void Btn_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseClicked
        Panel_Secretaria log = new Panel_Secretaria();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_Btn_RegresarMouseClicked

    private void Btn_RegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseEntered
        Funciones.EnterMouse(Btn_Regresar, Lb_Ordenar, "#D90707", "#000000");
    }//GEN-LAST:event_Btn_RegresarMouseEntered

    private void Btn_RegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseExited
        Funciones.LeftMouse(Btn_Regresar, Lb_Ordenar, "#980505", "#FFFFFF");
    }//GEN-LAST:event_Btn_RegresarMouseExited

    private void Btn_InscribirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_InscribirMouseClicked
        if (Funciones.validarCampos(jPanel5)) {
            System.out.println("Todo bien");
            Modelo_Responsables Responsables = new Modelo_Responsables();

            Responsables.setApellidos_A(Txb_ApellidosResponsableA.getText());
            Responsables.setNombres_A(Txb_NombresResponsableA.getText());
            Responsables.setId_TipoA(Cb_TipoResponsableA.getSelectedIndex());
            Responsables.setTelefonoA(TxbTelefono1.getText());

            Responsables.setApellidos_B(Txb_ApellidosResponsableB.getText());
            Responsables.setNombres_B(Txb_NombresResponsableB.getText());
            Responsables.setId_TipoB(Cb_TipoResponsable_B.getSelectedIndex());
            Responsables.setTelefonoB(TxbTelefono2.getText());

            Responsables.setDireccion(Txb_Direccion.getText());
            Responsables.setCorreo(Txb_Correo.getText());

            if (Responsables.Insert_Responsables(Responsables) > 0) {

                int idresponsable = Responsables.Get_IdReciente()+1;
                System.out.println("Responsables agregados id " + idresponsable);

                Modelo_Estudiante EstudianteNuevo = new Modelo_Estudiante();

                EstudianteNuevo.setNIE(Integer.parseInt(Txb_NIE.getText()));
                EstudianteNuevo.setNombres_Estudiante(Txb_Nombre_Alumno.getText());
                EstudianteNuevo.setApellidos_Estudiante(Txb_Apellido_Alumno.getText());
                EstudianteNuevo.setId_Responsables(idresponsable);
                EstudianteNuevo.setId_Grado(Cb_Grado.getSelectedIndex());
                EstudianteNuevo.setEdad(Integer.parseInt(Cb_Edad.getSelectedItem().toString()));

                if (EstudianteNuevo.Insert_Estudiante(EstudianteNuevo) > 0) {
                    int NIE = EstudianteNuevo.getNIE();
                    int id_grado = EstudianteNuevo.getId_Grado();
                    Date fecha = new Date();

                    int Year = Funciones.Get_Year_Actual();
                    //valores de prueba
                    int descuento_id = 0;

                    Modelo_Matricula Matricula = new Modelo_Matricula();
                    Matricula.setNIE(NIE);
                    Matricula.setId_Responsables(idresponsable);
                    Matricula.setYear(Year);
                    Matricula.setFecha(fecha);
                    Matricula.setMontoNeto(100);
                    Matricula.setId_Descuento(descuento_id);
                    Matricula.setMontoFinal(150);
                    Matricula.setId_Grado(id_grado);

                    if (Matricula.Insert_Matricula(Matricula) > 0) {
                    }
                    System.out.println("Exito se matriculo al joven " + EstudianteNuevo.getApellidos_Estudiante() + " "
                        + EstudianteNuevo.getNombres_Estudiante() + " NIE " + EstudianteNuevo.getNIE());
                }

            }
        }
    }//GEN-LAST:event_Btn_InscribirMouseClicked

    private void Btn_InscribirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_InscribirMouseEntered
        Funciones.EnterMouse(Btn_Inscribir, Lb_Crearcuenta, "#7BC778", "#000000");
    }//GEN-LAST:event_Btn_InscribirMouseEntered

    private void Btn_InscribirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_InscribirMouseExited
        Funciones.LeftMouse(Btn_Inscribir, Lb_Crearcuenta, "#407C3E", "#FFFFFF");
    }//GEN-LAST:event_Btn_InscribirMouseExited

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
            java.util.logging.Logger.getLogger(Buscador_Id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscador_Id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscador_Id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscador_Id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscador_Id().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_Inscribir;
    private javax.swing.JPanel Btn_Inscripcion;
    private javax.swing.JPanel Btn_Inventario1;
    private javax.swing.JPanel Btn_Regresar;
    private javax.swing.JComboBox<String> Cb_Edad;
    private javax.swing.JComboBox<String> Cb_Grado;
    private javax.swing.JComboBox<String> Cb_TipoResponsableA;
    private javax.swing.JComboBox<String> Cb_TipoResponsable_B;
    private javax.swing.JLabel Lb_Aerolinea6;
    private javax.swing.JLabel Lb_Aerolinea7;
    private javax.swing.JLabel Lb_Crearcuenta;
    private javax.swing.JLabel Lb_Inventario;
    private javax.swing.JLabel Lb_Ordenar;
    private javax.swing.JTextField TxbTelefono1;
    private javax.swing.JTextField TxbTelefono2;
    private javax.swing.JTextField Txb_Apellido_Alumno;
    private javax.swing.JTextField Txb_ApellidosResponsableA;
    private javax.swing.JTextField Txb_ApellidosResponsableB;
    private javax.swing.JTextField Txb_Correo;
    private javax.swing.JTextField Txb_Direccion;
    private javax.swing.JTextField Txb_NIE;
    private javax.swing.JTextField Txb_Nombre_Alumno;
    private javax.swing.JTextField Txb_NombresResponsableA;
    private javax.swing.JTextField Txb_NombresResponsableB;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel loading1;
    // End of variables declaration//GEN-END:variables
}
