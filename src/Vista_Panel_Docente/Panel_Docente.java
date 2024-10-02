package Vista_Panel_Docente;

import static Funciones.Funciones.EnterMouse;
import static Funciones.Funciones.LeftMouse;
import java.awt.Color;
import static Funciones.Funciones.CentrarFrames;
import Log_Iin.log_in1;
import Modelos.Docente.Modelo_DocenteGuia;
import Vista_Panel_Docente.Opciones.Asignacion_Actividades;
import Vista_Panel_Docente.Opciones.Asignacion_Notas;
import Vista_Panel_Docente.Opciones.Registro_Asistencia;
import Vista_Panel_Docente.Opciones.Gestion_Notas;
import Vista_Panel_Docente.Opciones.Gestion_Voleta_Notas;
import Vista_Panel_Docente.Opciones.Toma_Asistencia;

public class Panel_Docente extends javax.swing.JFrame {

    public Panel_Docente() {
        getContentPane().setBackground(new Color(250, 250, 250));
        initComponents();
    }

    private Modelo_DocenteGuia DocenteGuia;

    public Panel_Docente(Modelo_DocenteGuia Docente) {
        getContentPane().setBackground(new Color(250, 250, 250));
        initComponents();
        this.DocenteGuia = Docente;

        Lb_Nombre.setText("Bienvenido: " + DocenteGuia.getApellidos() + " " + DocenteGuia.getNombres() + " GUia grado: " + DocenteGuia.getIdGradoGuia());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_bg = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Lb_Nombre = new javax.swing.JLabel();
        Lb_Logo = new javax.swing.JLabel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        Panel_Izq = new javax.swing.JPanel();
        Btn_AsignarActividades = new javax.swing.JPanel();
        Lb_MAtricula = new javax.swing.JLabel();
        Btn_Inventario8 = new javax.swing.JPanel();
        Btn_TomaAsistencia = new javax.swing.JPanel();
        Lb_Empleado = new javax.swing.JLabel();
        Btn_Inventario10 = new javax.swing.JPanel();
        Btn_Inventario_ = new Customizacion.Custom_Buttons();
        Btn_Inventario1 = new javax.swing.JPanel();
        Lb_Inventario = new javax.swing.JLabel();
        Btn_RegistroAsistencia = new javax.swing.JPanel();
        Btn_Inventario13 = new javax.swing.JPanel();
        Lb_RegistroVentas = new javax.swing.JLabel();
        Btn_Modificar_cuenta = new javax.swing.JPanel();
        Lb_ModificarCuenta = new javax.swing.JLabel();
        Btn_Inventario = new javax.swing.JPanel();
        Btn_Regresar1 = new javax.swing.JPanel();
        Lb_Ordenar1 = new javax.swing.JLabel();
        Btn_Asignar_Notas = new javax.swing.JPanel();
        Lb_AsignarNOtas = new javax.swing.JLabel();
        Btn_Inventario9 = new javax.swing.JPanel();
        Desk = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Panel_bg.setBackground(new java.awt.Color(247, 246, 187));
        Panel_bg.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 5, new java.awt.Color(0, 126, 112)));
        Panel_bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(17, 66, 50));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(0, 126, 112)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lb_Nombre.setBackground(new java.awt.Color(251, 238, 122));
        Lb_Nombre.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Lb_Nombre.setForeground(new java.awt.Color(203, 202, 104));
        Lb_Nombre.setText("Bienvenido:");
        jPanel3.add(Lb_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 610, 70));

        Lb_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO blsnco 80x80_1.jpg"))); // NOI18N
        jPanel3.add(Lb_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        Lb_Aerolinea2.setBackground(new java.awt.Color(251, 238, 122));
        Lb_Aerolinea2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(203, 202, 104));
        Lb_Aerolinea2.setText("Colegio Josefino Nuestra Señora De La Paz ");
        jPanel3.add(Lb_Aerolinea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 540, 70));

        Panel_bg.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 80));

        Panel_Izq.setBackground(new java.awt.Color(17, 66, 50));
        Panel_Izq.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 5, new java.awt.Color(0, 126, 112)));

        Btn_AsignarActividades.setBackground(new java.awt.Color(250, 244, 208));
        Btn_AsignarActividades.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 3, new java.awt.Color(255, 204, 0)));
        Btn_AsignarActividades.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_AsignarActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_AsignarActividadesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_AsignarActividadesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_AsignarActividadesMouseExited(evt);
            }
        });

        Lb_MAtricula.setBackground(new java.awt.Color(7, 3, 26));
        Lb_MAtricula.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_MAtricula.setForeground(new java.awt.Color(7, 3, 26));
        Lb_MAtricula.setText("Asignar actividades");

        Btn_Inventario8.setBackground(new java.awt.Color(255, 255, 102));
        Btn_Inventario8.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 153, 0)));
        Btn_Inventario8.setPreferredSize(new java.awt.Dimension(2, 15));

        javax.swing.GroupLayout Btn_Inventario8Layout = new javax.swing.GroupLayout(Btn_Inventario8);
        Btn_Inventario8.setLayout(Btn_Inventario8Layout);
        Btn_Inventario8Layout.setHorizontalGroup(
            Btn_Inventario8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Btn_Inventario8Layout.setVerticalGroup(
            Btn_Inventario8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Btn_AsignarActividadesLayout = new javax.swing.GroupLayout(Btn_AsignarActividades);
        Btn_AsignarActividades.setLayout(Btn_AsignarActividadesLayout);
        Btn_AsignarActividadesLayout.setHorizontalGroup(
            Btn_AsignarActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Inventario8, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(Btn_AsignarActividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_MAtricula)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        Btn_AsignarActividadesLayout.setVerticalGroup(
            Btn_AsignarActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_AsignarActividadesLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(Lb_MAtricula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Inventario8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Btn_TomaAsistencia.setBackground(new java.awt.Color(250, 244, 208));
        Btn_TomaAsistencia.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 3, new java.awt.Color(255, 204, 0)));
        Btn_TomaAsistencia.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_TomaAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_TomaAsistenciaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_TomaAsistenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_TomaAsistenciaMouseExited(evt);
            }
        });

        Lb_Empleado.setBackground(new java.awt.Color(7, 3, 26));
        Lb_Empleado.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Empleado.setForeground(new java.awt.Color(7, 3, 26));
        Lb_Empleado.setText("Toma de asistencia");

        Btn_Inventario10.setBackground(new java.awt.Color(255, 255, 102));
        Btn_Inventario10.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 153, 0)));
        Btn_Inventario10.setPreferredSize(new java.awt.Dimension(2, 15));

        javax.swing.GroupLayout Btn_Inventario10Layout = new javax.swing.GroupLayout(Btn_Inventario10);
        Btn_Inventario10.setLayout(Btn_Inventario10Layout);
        Btn_Inventario10Layout.setHorizontalGroup(
            Btn_Inventario10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Btn_Inventario10Layout.setVerticalGroup(
            Btn_Inventario10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Btn_TomaAsistenciaLayout = new javax.swing.GroupLayout(Btn_TomaAsistencia);
        Btn_TomaAsistencia.setLayout(Btn_TomaAsistenciaLayout);
        Btn_TomaAsistenciaLayout.setHorizontalGroup(
            Btn_TomaAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Inventario10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_TomaAsistenciaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lb_Empleado)
                .addContainerGap())
        );
        Btn_TomaAsistenciaLayout.setVerticalGroup(
            Btn_TomaAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_TomaAsistenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Empleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(Btn_Inventario10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Btn_Inventario_.setBackground(new java.awt.Color(250, 244, 208));
        Btn_Inventario_.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 3, new java.awt.Color(255, 204, 0)));
        Btn_Inventario_.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_Inventario_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_Inventario_MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_Inventario_MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_Inventario_MouseExited(evt);
            }
        });

        Btn_Inventario1.setBackground(new java.awt.Color(255, 255, 102));
        Btn_Inventario1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 153, 0)));
        Btn_Inventario1.setPreferredSize(new java.awt.Dimension(2, 15));

        javax.swing.GroupLayout Btn_Inventario1Layout = new javax.swing.GroupLayout(Btn_Inventario1);
        Btn_Inventario1.setLayout(Btn_Inventario1Layout);
        Btn_Inventario1Layout.setHorizontalGroup(
            Btn_Inventario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Btn_Inventario1Layout.setVerticalGroup(
            Btn_Inventario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        Lb_Inventario.setBackground(new java.awt.Color(7, 3, 26));
        Lb_Inventario.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Inventario.setForeground(new java.awt.Color(7, 3, 26));
        Lb_Inventario.setText("Gestion de notas");

        javax.swing.GroupLayout Btn_Inventario_Layout = new javax.swing.GroupLayout(Btn_Inventario_);
        Btn_Inventario_.setLayout(Btn_Inventario_Layout);
        Btn_Inventario_Layout.setHorizontalGroup(
            Btn_Inventario_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Inventario1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_Inventario_Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lb_Inventario)
                .addGap(24, 24, 24))
        );
        Btn_Inventario_Layout.setVerticalGroup(
            Btn_Inventario_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_Inventario_Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(Lb_Inventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Inventario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Btn_RegistroAsistencia.setBackground(new java.awt.Color(250, 244, 208));
        Btn_RegistroAsistencia.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 3, new java.awt.Color(255, 204, 0)));
        Btn_RegistroAsistencia.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_RegistroAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_RegistroAsistenciaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_RegistroAsistenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_RegistroAsistenciaMouseExited(evt);
            }
        });

        Btn_Inventario13.setBackground(new java.awt.Color(255, 255, 102));
        Btn_Inventario13.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 153, 0)));
        Btn_Inventario13.setPreferredSize(new java.awt.Dimension(2, 15));

        javax.swing.GroupLayout Btn_Inventario13Layout = new javax.swing.GroupLayout(Btn_Inventario13);
        Btn_Inventario13.setLayout(Btn_Inventario13Layout);
        Btn_Inventario13Layout.setHorizontalGroup(
            Btn_Inventario13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Btn_Inventario13Layout.setVerticalGroup(
            Btn_Inventario13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        Lb_RegistroVentas.setBackground(new java.awt.Color(7, 3, 26));
        Lb_RegistroVentas.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_RegistroVentas.setForeground(new java.awt.Color(7, 3, 26));
        Lb_RegistroVentas.setText("Registro Asistencias");

        javax.swing.GroupLayout Btn_RegistroAsistenciaLayout = new javax.swing.GroupLayout(Btn_RegistroAsistencia);
        Btn_RegistroAsistencia.setLayout(Btn_RegistroAsistenciaLayout);
        Btn_RegistroAsistenciaLayout.setHorizontalGroup(
            Btn_RegistroAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Inventario13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(Btn_RegistroAsistenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_RegistroVentas)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        Btn_RegistroAsistenciaLayout.setVerticalGroup(
            Btn_RegistroAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_RegistroAsistenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_RegistroVentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(Btn_Inventario13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Btn_Modificar_cuenta.setBackground(new java.awt.Color(250, 244, 208));
        Btn_Modificar_cuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 3, new java.awt.Color(255, 204, 0)));
        Btn_Modificar_cuenta.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_Modificar_cuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_Modificar_cuentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_Modificar_cuentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_Modificar_cuentaMouseExited(evt);
            }
        });

        Lb_ModificarCuenta.setBackground(new java.awt.Color(7, 3, 26));
        Lb_ModificarCuenta.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_ModificarCuenta.setForeground(new java.awt.Color(7, 3, 26));
        Lb_ModificarCuenta.setText("Notas Promediadas");

        Btn_Inventario.setBackground(new java.awt.Color(255, 255, 102));
        Btn_Inventario.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 153, 0)));
        Btn_Inventario.setPreferredSize(new java.awt.Dimension(2, 15));

        javax.swing.GroupLayout Btn_InventarioLayout = new javax.swing.GroupLayout(Btn_Inventario);
        Btn_Inventario.setLayout(Btn_InventarioLayout);
        Btn_InventarioLayout.setHorizontalGroup(
            Btn_InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
        Btn_InventarioLayout.setVerticalGroup(
            Btn_InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Btn_Modificar_cuentaLayout = new javax.swing.GroupLayout(Btn_Modificar_cuenta);
        Btn_Modificar_cuenta.setLayout(Btn_Modificar_cuentaLayout);
        Btn_Modificar_cuentaLayout.setHorizontalGroup(
            Btn_Modificar_cuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Inventario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(Btn_Modificar_cuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_ModificarCuenta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Btn_Modificar_cuentaLayout.setVerticalGroup(
            Btn_Modificar_cuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_Modificar_cuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_ModificarCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(Btn_Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Btn_Regresar1.setBackground(new java.awt.Color(152, 5, 5));
        Btn_Regresar1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 10, 0, new java.awt.Color(247, 17, 17)));
        Btn_Regresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_Regresar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_Regresar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_Regresar1MouseExited(evt);
            }
        });
        Btn_Regresar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lb_Ordenar1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Lb_Ordenar1.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Ordenar1.setText("Regresar");
        Lb_Ordenar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar1.add(Lb_Ordenar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 130, 40));

        Btn_Asignar_Notas.setBackground(new java.awt.Color(250, 244, 208));
        Btn_Asignar_Notas.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 3, new java.awt.Color(255, 204, 0)));
        Btn_Asignar_Notas.setPreferredSize(new java.awt.Dimension(180, 60));
        Btn_Asignar_Notas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_Asignar_NotasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_Asignar_NotasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_Asignar_NotasMouseExited(evt);
            }
        });

        Lb_AsignarNOtas.setBackground(new java.awt.Color(7, 3, 26));
        Lb_AsignarNOtas.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_AsignarNOtas.setForeground(new java.awt.Color(7, 3, 26));
        Lb_AsignarNOtas.setText("Asignar notas");

        Btn_Inventario9.setBackground(new java.awt.Color(255, 255, 102));
        Btn_Inventario9.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 153, 0)));
        Btn_Inventario9.setPreferredSize(new java.awt.Dimension(2, 15));

        javax.swing.GroupLayout Btn_Inventario9Layout = new javax.swing.GroupLayout(Btn_Inventario9);
        Btn_Inventario9.setLayout(Btn_Inventario9Layout);
        Btn_Inventario9Layout.setHorizontalGroup(
            Btn_Inventario9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Btn_Inventario9Layout.setVerticalGroup(
            Btn_Inventario9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Btn_Asignar_NotasLayout = new javax.swing.GroupLayout(Btn_Asignar_Notas);
        Btn_Asignar_Notas.setLayout(Btn_Asignar_NotasLayout);
        Btn_Asignar_NotasLayout.setHorizontalGroup(
            Btn_Asignar_NotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Inventario9, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(Btn_Asignar_NotasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_AsignarNOtas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Btn_Asignar_NotasLayout.setVerticalGroup(
            Btn_Asignar_NotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_Asignar_NotasLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(Lb_AsignarNOtas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Inventario9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout Panel_IzqLayout = new javax.swing.GroupLayout(Panel_Izq);
        Panel_Izq.setLayout(Panel_IzqLayout);
        Panel_IzqLayout.setHorizontalGroup(
            Panel_IzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_IzqLayout.createSequentialGroup()
                .addGroup(Panel_IzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_IzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Btn_Modificar_cuenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addComponent(Btn_Inventario_, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addComponent(Btn_AsignarActividades, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addComponent(Btn_TomaAsistencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addComponent(Btn_Asignar_Notas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                    .addComponent(Btn_RegistroAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_IzqLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(Btn_Regresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        Panel_IzqLayout.setVerticalGroup(
            Panel_IzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_IzqLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Btn_Inventario_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_AsignarActividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Asignar_Notas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_TomaAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_RegistroAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Modificar_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(Btn_Regresar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Panel_bg.add(Panel_Izq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, 630));

        Desk.setBackground(new java.awt.Color(250, 244, 208));

        javax.swing.GroupLayout DeskLayout = new javax.swing.GroupLayout(Desk);
        Desk.setLayout(DeskLayout);
        DeskLayout.setHorizontalGroup(
            DeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1160, Short.MAX_VALUE)
        );
        DeskLayout.setVerticalGroup(
            DeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        Panel_bg.add(Desk, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 1160, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1372, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_Modificar_cuentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Modificar_cuentaMouseEntered
        EnterMouse(Btn_Modificar_cuenta, Lb_ModificarCuenta, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_Modificar_cuentaMouseEntered

    private void Btn_Modificar_cuentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Modificar_cuentaMouseExited
        LeftMouse(Btn_Modificar_cuenta, Lb_ModificarCuenta, "#FAF4D0", "#000000");
    }//GEN-LAST:event_Btn_Modificar_cuentaMouseExited

    private void Btn_Regresar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Regresar1MouseClicked
        log_in1 gest = new log_in1();
        dispose();
        gest.setVisible(true);
    }//GEN-LAST:event_Btn_Regresar1MouseClicked

    private void Btn_Regresar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Regresar1MouseEntered
        EnterMouse(Btn_Regresar1, Lb_Ordenar1, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_Regresar1MouseEntered

    private void Btn_Regresar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Regresar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Regresar1MouseExited

    private void Btn_AsignarActividadesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AsignarActividadesMouseEntered
        EnterMouse(Btn_AsignarActividades, Lb_MAtricula, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_AsignarActividadesMouseEntered

    private void Btn_AsignarActividadesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AsignarActividadesMouseExited
        LeftMouse(Btn_AsignarActividades, Lb_MAtricula, "#FAF4D0", "#000000");
    }//GEN-LAST:event_Btn_AsignarActividadesMouseExited

    private void Btn_TomaAsistenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TomaAsistenciaMouseEntered
        EnterMouse(Btn_TomaAsistencia, Lb_Empleado, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_TomaAsistenciaMouseEntered

    private void Btn_TomaAsistenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TomaAsistenciaMouseExited
        LeftMouse(Btn_TomaAsistencia, Lb_Empleado, "#FAF4D0", "#000000");
    }//GEN-LAST:event_Btn_TomaAsistenciaMouseExited

    private void Btn_Inventario_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Inventario_MouseEntered
        EnterMouse(Btn_Inventario_, Lb_Inventario, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_Inventario_MouseEntered

    private void Btn_Inventario_MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Inventario_MouseExited
        LeftMouse(Btn_Inventario_, Lb_Inventario, "#FAF4D0", "#000000");
    }//GEN-LAST:event_Btn_Inventario_MouseExited

    private void Btn_RegistroAsistenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegistroAsistenciaMouseEntered
        EnterMouse(Btn_RegistroAsistencia, Lb_RegistroVentas, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_RegistroAsistenciaMouseEntered

    private void Btn_RegistroAsistenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegistroAsistenciaMouseExited
        LeftMouse(Btn_RegistroAsistencia, Lb_RegistroVentas, "#FAF4D0", "#000000");
    }//GEN-LAST:event_Btn_RegistroAsistenciaMouseExited

    private void Btn_Modificar_cuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Modificar_cuentaMouseClicked

        Gestion_Voleta_Notas gest = new Gestion_Voleta_Notas(DocenteGuia);

        gest.setResizable(false);
        gest.setBounds(0, 0, Desk.getWidth(), Desk.getHeight());
        gest.setVisible(true);
        CentrarFrames(Desk, gest);
        Desk.add(gest);
        gest.show();

    }//GEN-LAST:event_Btn_Modificar_cuentaMouseClicked

    private void Btn_Inventario_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Inventario_MouseClicked
        Gestion_Notas gest = new Gestion_Notas(DocenteGuia);

        gest.setResizable(false);
        gest.setBounds(0, 0, Desk.getWidth(), Desk.getHeight());
        gest.setVisible(true);
        CentrarFrames(Desk, gest);
        Desk.add(gest);
        gest.show();    }//GEN-LAST:event_Btn_Inventario_MouseClicked

    private void Btn_Asignar_NotasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Asignar_NotasMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Asignar_NotasMouseEntered

    private void Btn_Asignar_NotasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Asignar_NotasMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Asignar_NotasMouseExited

    private void Btn_AsignarActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_AsignarActividadesMouseClicked
        Asignacion_Actividades gest = new Asignacion_Actividades(DocenteGuia);

        gest.setResizable(false);
        gest.setBounds(0, 0, Desk.getWidth(), Desk.getHeight());
        gest.setVisible(true);
        CentrarFrames(Desk, gest);
        Desk.add(gest);
        gest.show();

    }//GEN-LAST:event_Btn_AsignarActividadesMouseClicked

    private void Btn_Asignar_NotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_Asignar_NotasMouseClicked
        Asignacion_Notas gest = new Asignacion_Notas(DocenteGuia);
        gest.setResizable(false);
        gest.setBounds(0, 0, Desk.getWidth(), Desk.getHeight());
        gest.setVisible(true);
        CentrarFrames(Desk, gest);
        Desk.add(gest);
        gest.show();

    }//GEN-LAST:event_Btn_Asignar_NotasMouseClicked

    private void Btn_TomaAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TomaAsistenciaMouseClicked
        Toma_Asistencia gest = new Toma_Asistencia(DocenteGuia);

        gest.setResizable(false);
        gest.setBounds(0, 0, Desk.getWidth(), Desk.getHeight());
        gest.setVisible(true);
        CentrarFrames(Desk, gest);
        Desk.add(gest);
        gest.show();

    }//GEN-LAST:event_Btn_TomaAsistenciaMouseClicked

    private void Btn_RegistroAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegistroAsistenciaMouseClicked
        Registro_Asistencia gest = new Registro_Asistencia(DocenteGuia);

        gest.setResizable(false);
        gest.setBounds(0, 0, Desk.getWidth(), Desk.getHeight());
        gest.setVisible(true);
        CentrarFrames(Desk, gest);
        Desk.add(gest);
        gest.show();

    }//GEN-LAST:event_Btn_RegistroAsistenciaMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Panel_Docente().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_AsignarActividades;
    private javax.swing.JPanel Btn_Asignar_Notas;
    private javax.swing.JPanel Btn_Inventario;
    private javax.swing.JPanel Btn_Inventario1;
    private javax.swing.JPanel Btn_Inventario10;
    private javax.swing.JPanel Btn_Inventario13;
    private javax.swing.JPanel Btn_Inventario8;
    private javax.swing.JPanel Btn_Inventario9;
    private javax.swing.JPanel Btn_Inventario_;
    private javax.swing.JPanel Btn_Modificar_cuenta;
    private javax.swing.JPanel Btn_RegistroAsistencia;
    private javax.swing.JPanel Btn_Regresar1;
    private javax.swing.JPanel Btn_TomaAsistencia;
    private javax.swing.JDesktopPane Desk;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_AsignarNOtas;
    private javax.swing.JLabel Lb_Empleado;
    private javax.swing.JLabel Lb_Inventario;
    private javax.swing.JLabel Lb_Logo;
    private javax.swing.JLabel Lb_MAtricula;
    private javax.swing.JLabel Lb_ModificarCuenta;
    private javax.swing.JLabel Lb_Nombre;
    private javax.swing.JLabel Lb_Ordenar1;
    private javax.swing.JLabel Lb_RegistroVentas;
    private javax.swing.JPanel Panel_Izq;
    private javax.swing.JPanel Panel_bg;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
