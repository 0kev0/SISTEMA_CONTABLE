package Vista_Panel_Docente.Opciones;

import Customizacion.TablaCusomizada;
import static Funciones.Funciones.EnterMouse;
import static Funciones.Funciones.LeftMouse;
import Funciones.NotasTrimestralesPDF;
import Modelos.Docente.Modelo_DocenteGuia;
import Modelos.Docente.Modelo_GestionPromedios;
import Modelos.Secretaria.Modelo_Estudiante;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class Gestion_Voleta_Notas extends javax.swing.JInternalFrame {

    private final Modelo_GestionPromedios Objeto_Modelo_GestionPromedios = new Modelo_GestionPromedios();
    private List<Modelo_GestionPromedios> List_Modelo_GestionPromedios;
    private DefaultTableModel modeloTablaPeriodo = new DefaultTableModel();
    private DefaultTableModel modeloTablaTrimestres = new DefaultTableModel();

    private Modelo_Estudiante Objeto_Estudiante = new Modelo_Estudiante();
    private List<Modelo_Estudiante> List_NIES;

    private final int Grado;

    public Gestion_Voleta_Notas(Modelo_DocenteGuia docente) {
        initComponents();

        this.Grado = docente.getIdGradoGuia();
        modeloTablaPeriodo = (DefaultTableModel) Tbl_RegistroNotaPeriodo.getModel();
        modeloTablaTrimestres = (DefaultTableModel) Tbl_RegistroNotasTrimestres.getModel();

        Get_NIES(Cb_NIES);
        int nie = Integer.parseInt(Cb_NIES.getSelectedItem().toString());
        String periodo = Cb_Periodo.getSelectedItem().toString();

        this.Objeto_Estudiante = Objeto_Estudiante.Get_DataEstudiante(nie);

        Lb_Grado.setText("Grado : " + docente.getIdGradoGuia());
        Lb_Estudiante.setText("Estudiante : " + Objeto_Estudiante.getApellidos_Estudiante() + " " + Objeto_Estudiante.getNombres_Estudiante());
        Lb_Docente.setText("Docente : " + docente.getApellidos() + " " + docente.getNombres());
        Lb_Periodo.setText(periodo);

        DiseñoTablaPeriodo(Tbl_RegistroNotaPeriodo);
        DiseñoTablaPeriodo(Tbl_RegistroNotasTrimestres);

        Get_ListadoNotas(Tbl_RegistroNotaPeriodo);
        Get_ListadoNotasTrimestres(Tbl_RegistroNotasTrimestres);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Lb_Aerolinea1 = new javax.swing.JLabel();
        Cb_Periodo = new javax.swing.JComboBox<>();
        Btn_GuardarActividad = new javax.swing.JPanel();
        Lb_Guardar = new javax.swing.JLabel();
        Cb_NIES = new javax.swing.JComboBox<>();
        Pnl_Boleta = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Lb_Aerolinea4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_RegistroNotaPeriodo = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_RegistroNotasTrimestres = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_logo = new javax.swing.JLabel();
        Lb_Periodo = new javax.swing.JLabel();
        Lb_Estudiante = new javax.swing.JLabel();
        Lb_Grado = new javax.swing.JLabel();
        Lb_Docente = new javax.swing.JLabel();
        Lb_Estudiante1 = new javax.swing.JLabel();
        Lb_Estudiante2 = new javax.swing.JLabel();
        Lb_Estudiante3 = new javax.swing.JLabel();
        Lb_Estudiante4 = new javax.swing.JLabel();
        Lb_Estudiante5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setBorder(null);
        setTitle("Registro voleta de notas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setEnabled(false);
        setFocusCycleRoot(false);
        setFocusable(false);
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jPanel1.setBackground(new java.awt.Color(234, 223, 180));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(226, 215, 132));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea1.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea1.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea1.setText("Registro voleta de notas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Aerolinea1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 6, 370, -1));

        Cb_Periodo.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Periodo.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Periodo.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1er periodo", "2do periodo", "3er periodo", "4to periodo" }));
        Cb_Periodo.setToolTipText("");
        Cb_Periodo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Periodo: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Periodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_PeriodoActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 134, -1));

        Btn_GuardarActividad.setBackground(new java.awt.Color(226, 215, 132));
        Btn_GuardarActividad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 8, 0, new java.awt.Color(255, 153, 51)));
        Btn_GuardarActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_GuardarActividadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_GuardarActividadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_GuardarActividadMouseExited(evt);
            }
        });

        Lb_Guardar.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Guardar.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Guardar.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Guardar.setText("Imprimir boleta de notas");

        javax.swing.GroupLayout Btn_GuardarActividadLayout = new javax.swing.GroupLayout(Btn_GuardarActividad);
        Btn_GuardarActividad.setLayout(Btn_GuardarActividadLayout);
        Btn_GuardarActividadLayout.setHorizontalGroup(
            Btn_GuardarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_GuardarActividadLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(Lb_Guardar)
                .addGap(14, 14, 14))
        );
        Btn_GuardarActividadLayout.setVerticalGroup(
            Btn_GuardarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_GuardarActividadLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(Lb_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(Btn_GuardarActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 570, 240, 40));

        Cb_NIES.setBackground(new java.awt.Color(224, 213, 170));
        Cb_NIES.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_NIES.setForeground(new java.awt.Color(0, 0, 0));
        Cb_NIES.setToolTipText("");
        Cb_NIES.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Buscar NIE: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_NIES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_NIESActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_NIES, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 100, -1));

        Pnl_Boleta.setBackground(new java.awt.Color(255, 255, 255));
        Pnl_Boleta.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        Lb_Aerolinea4.setBackground(new java.awt.Color(204, 204, 204));
        Lb_Aerolinea4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Lb_Aerolinea4.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea4.setText("Trimestres");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(Lb_Aerolinea4)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(Lb_Aerolinea4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        Lb_Aerolinea2.setBackground(new java.awt.Color(204, 204, 204));
        Lb_Aerolinea2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea2.setText("Actividades");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(Lb_Aerolinea2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        Lb_Aerolinea3.setBackground(new java.awt.Color(204, 204, 204));
        Lb_Aerolinea3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Lb_Aerolinea3.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea3.setText("P.O");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Tbl_RegistroNotaPeriodo.setAutoCreateRowSorter(true);
        Tbl_RegistroNotaPeriodo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        Tbl_RegistroNotaPeriodo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Materias", "Act 1", "Act 2", "Act 3", "Act 4", "60%", "10%", "Examen", "30%", "Promedio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_RegistroNotaPeriodo);
        if (Tbl_RegistroNotaPeriodo.getColumnModel().getColumnCount() > 0) {
            Tbl_RegistroNotaPeriodo.getColumnModel().getColumn(0).setPreferredWidth(200);
            Tbl_RegistroNotaPeriodo.getColumnModel().getColumn(1).setPreferredWidth(60);
            Tbl_RegistroNotaPeriodo.getColumnModel().getColumn(2).setPreferredWidth(60);
            Tbl_RegistroNotaPeriodo.getColumnModel().getColumn(3).setResizable(false);
            Tbl_RegistroNotaPeriodo.getColumnModel().getColumn(3).setPreferredWidth(60);
            Tbl_RegistroNotaPeriodo.getColumnModel().getColumn(4).setPreferredWidth(60);
            Tbl_RegistroNotaPeriodo.getColumnModel().getColumn(5).setPreferredWidth(60);
            Tbl_RegistroNotaPeriodo.getColumnModel().getColumn(6).setPreferredWidth(60);
            Tbl_RegistroNotaPeriodo.getColumnModel().getColumn(7).setPreferredWidth(60);
            Tbl_RegistroNotaPeriodo.getColumnModel().getColumn(8).setPreferredWidth(60);
            Tbl_RegistroNotaPeriodo.getColumnModel().getColumn(9).setPreferredWidth(80);
        }

        Tbl_RegistroNotasTrimestres.setAutoCreateRowSorter(true);
        Tbl_RegistroNotasTrimestres.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 51)));
        Tbl_RegistroNotasTrimestres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "T1", "T2", "T3", "T4", "NF"
            }
        ));
        jScrollPane2.setViewportView(Tbl_RegistroNotasTrimestres);
        if (Tbl_RegistroNotasTrimestres.getColumnModel().getColumnCount() > 0) {
            Tbl_RegistroNotasTrimestres.getColumnModel().getColumn(0).setPreferredWidth(60);
            Tbl_RegistroNotasTrimestres.getColumnModel().getColumn(0).setHeaderValue("T1");
            Tbl_RegistroNotasTrimestres.getColumnModel().getColumn(1).setPreferredWidth(60);
            Tbl_RegistroNotasTrimestres.getColumnModel().getColumn(1).setHeaderValue("T2");
            Tbl_RegistroNotasTrimestres.getColumnModel().getColumn(2).setPreferredWidth(60);
            Tbl_RegistroNotasTrimestres.getColumnModel().getColumn(2).setHeaderValue("T3");
            Tbl_RegistroNotasTrimestres.getColumnModel().getColumn(3).setPreferredWidth(60);
            Tbl_RegistroNotasTrimestres.getColumnModel().getColumn(3).setHeaderValue("T4");
            Tbl_RegistroNotasTrimestres.getColumnModel().getColumn(4).setPreferredWidth(60);
            Tbl_RegistroNotasTrimestres.getColumnModel().getColumn(4).setHeaderValue("NF");
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("TODO POR LA GLORIA DE JESUS MARIA Y JOSE");

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("COLEGIO JOSEFINO NUESTRA SEÑORA DE LA PAZ");

        lb_logo.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_logo.setForeground(new java.awt.Color(0, 0, 0));
        lb_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO blsnco 80x80.jpg"))); // NOI18N

        Lb_Periodo.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        Lb_Periodo.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Periodo.setText("BOLETA DE NOTAS TRIMESTRE :");

        Lb_Estudiante.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        Lb_Estudiante.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Estudiante.setText("Estudiante : ");

        Lb_Grado.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        Lb_Grado.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Grado.setText("Grado :");

        Lb_Docente.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        Lb_Docente.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Docente.setText("Docente : ");

        Lb_Estudiante1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        Lb_Estudiante1.setForeground(new java.awt.Color(0, 0, 0));

        Lb_Estudiante2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        Lb_Estudiante2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Estudiante2.setText("Direccion");

        Lb_Estudiante3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        Lb_Estudiante3.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Estudiante3.setText("Registro Academico");

        Lb_Estudiante4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        Lb_Estudiante4.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Estudiante4.setText("__________________________");

        Lb_Estudiante5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        Lb_Estudiante5.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Estudiante5.setText("__________________________");

        javax.swing.GroupLayout Pnl_BoletaLayout = new javax.swing.GroupLayout(Pnl_Boleta);
        Pnl_Boleta.setLayout(Pnl_BoletaLayout);
        Pnl_BoletaLayout.setHorizontalGroup(
            Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(Lb_Estudiante1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(Lb_Estudiante2))
                    .addComponent(Lb_Estudiante4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lb_Estudiante5)
                    .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Lb_Estudiante3)))
                .addContainerGap(501, Short.MAX_VALUE))
            .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                        .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lb_Grado)
                            .addComponent(Lb_Docente)
                            .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                                .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                        .addComponent(Lb_Estudiante)
                        .addGap(207, 207, 207)
                        .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20))
                            .addComponent(jLabel2)
                            .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                                .addComponent(Lb_Periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_logo)
                        .addGap(94, 94, 94))))
        );
        Pnl_BoletaLayout.setVerticalGroup(
            Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lb_Periodo))
                            .addComponent(lb_logo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_BoletaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Lb_Estudiante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lb_Grado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lb_Docente)
                        .addGap(32, 32, 32)))
                .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_BoletaLayout.createSequentialGroup()
                        .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_BoletaLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lb_Estudiante2)
                            .addComponent(Lb_Estudiante3)))
                    .addGroup(Pnl_BoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Lb_Estudiante4)
                        .addComponent(Lb_Estudiante5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lb_Estudiante1)
                .addGap(40, 40, 40))
        );

        jPanel1.add(Pnl_Boleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1070, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Get_NIES(JComboBox ComboBox) {

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_NIES = Objeto_Estudiante.Get_Listado_NIES_porGrado(Grado);
        System.out.println("hay " + List_NIES.size());

        for (Modelo_Estudiante item : List_NIES) {
            ModeloComboBox.addElement(item.getNIE());
        }

        ComboBox.setModel(ModeloComboBox);
    }


    private void Cb_PeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_PeriodoActionPerformed
        Get_ListadoNotas(Tbl_RegistroNotaPeriodo);
        Get_ListadoNotasTrimestres(Tbl_RegistroNotasTrimestres);
        String periodo = Cb_Periodo.getSelectedItem().toString();
        Lb_Periodo.setText("BOLETA DE NOTAS TRIMESTRE : " + periodo);

    }//GEN-LAST:event_Cb_PeriodoActionPerformed

    private void Btn_GuardarActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_GuardarActividadMouseClicked
        String periodo = Cb_Periodo.getSelectedItem().toString();
        NotasTrimestralesPDF Boleta = new NotasTrimestralesPDF();
        Boleta.printJFrameToPdf(Pnl_Boleta, "Boleta de notas " + Objeto_Estudiante.getNombres_Estudiante() + periodo);


    }//GEN-LAST:event_Btn_GuardarActividadMouseClicked

    private void Btn_GuardarActividadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_GuardarActividadMouseEntered
        EnterMouse(Btn_GuardarActividad, Lb_Guardar, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_GuardarActividadMouseEntered

    private void Btn_GuardarActividadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_GuardarActividadMouseExited
        LeftMouse(Btn_GuardarActividad, Lb_Guardar, "#E2D784", "#000000");
    }//GEN-LAST:event_Btn_GuardarActividadMouseExited

    private void Cb_NIESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_NIESActionPerformed
        int nie = Integer.parseInt(Cb_NIES.getSelectedItem().toString());
        String periodo = Cb_Periodo.getSelectedItem().toString();

        this.Objeto_Estudiante = Objeto_Estudiante.Get_DataEstudiante(nie);
        Lb_Estudiante.setText("Estudiante : " + Objeto_Estudiante.getApellidos_Estudiante() + " " + Objeto_Estudiante.getNombres_Estudiante());
        Lb_Periodo.setText("BOLETA DE NOTAS TRIMESTRE : " + periodo);

        Get_ListadoNotas(Tbl_RegistroNotaPeriodo);
        Get_ListadoNotasTrimestres(Tbl_RegistroNotasTrimestres);


    }//GEN-LAST:event_Cb_NIESActionPerformed

    public void DiseñoTablaPeriodo(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new TablaCusomizada());
        tabla.setRowHeight(30); // Altura de las filas de datos
        tabla.getTableHeader().setBackground(Color.decode("#5C636E"));
        tabla.getTableHeader().setForeground(Color.white);
        Font fuente = new Font("Roboto", Font.BOLD, 12);
        tabla.setFont(fuente);
        tabla.getTableHeader().setFont(fuente);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        int numeroDeCeldas = tabla.getColumnCount(); // Cambia este valor al número de celdas que necesites

        for (int i = 0; i < numeroDeCeldas; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        tabla.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);

        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(60, 50)); // Ajusta la altura del encabezado
    }

    public void DiseñoTablaTrimestres(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new TablaCusomizada());
        tabla.setRowHeight(30); // Altura de las filas de datos
        tabla.getTableHeader().setBackground(Color.decode("#5C636E"));
        tabla.getTableHeader().setForeground(Color.white);
        Font fuente = new Font("Roboto", Font.BOLD, 12);
        tabla.setFont(fuente);
        tabla.getTableHeader().setFont(fuente);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        int numeroDeCeldas = tabla.getColumnCount(); // Cambia este valor al número de celdas que necesites

        for (int i = 0; i < numeroDeCeldas; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(60, 50)); // Ajusta la altura del encabezado
    }

    public void Get_ListadoNotasTrimestres(JTable tabla) {
        System.out.println("CARGANDO NOTAS TRIMESTRALES");
        int NIE = Integer.parseInt(Cb_NIES.getSelectedItem().toString());
        int periodo = Cb_Periodo.getSelectedIndex() + 1;

        modeloTablaTrimestres.setNumRows(0);

        List_Modelo_GestionPromedios = Objeto_Modelo_GestionPromedios.Get_TrimestresPeriodo_NIE(NIE, Grado, periodo);
        System.out.println("###hay " + List_Modelo_GestionPromedios.size());

        for (Modelo_GestionPromedios item : List_Modelo_GestionPromedios) {

            modeloTablaTrimestres.addRow(new Object[]{
                item.getNotaPeriodo_1(),
                item.getNotaPeriodo_2(),
                item.getNotaPeriodo_3(),
                item.getNotaPeriodo_4(),
                (item.getNotaPeriodo_1() + item.getNotaPeriodo_2() + item.getNotaPeriodo_3() + item.getNotaPeriodo_4()) / 4

            });
        }

        tabla.setModel(modeloTablaTrimestres);

    }

    public void Get_ListadoNotas(JTable tabla) {
        System.out.println("CARGANDO TODAS LAS NOTAS");

        int NIE = Integer.parseInt(Cb_NIES.getSelectedItem().toString());
        int periodo = Cb_Periodo.getSelectedIndex() + 1;

        modeloTablaPeriodo.setNumRows(0);

        System.out.println("buscando periodo: " + periodo);

        List_Modelo_GestionPromedios = Objeto_Modelo_GestionPromedios.Get_NotasPeriodo_NIE(NIE, Grado, periodo);
        System.out.println("###hay " + List_Modelo_GestionPromedios.size());

        for (Modelo_GestionPromedios item : List_Modelo_GestionPromedios) {
            double tareas;
            double parcial;
            double promedio;
            double AutoEvaluacion;

            tareas = (item.getNotasActividades().get(0) * .15 + item.getNotasActividades().get(1) * .15 + item.getNotasActividades().get(2) * .15 + item.getNotasActividades().get(3) * .15);
            tareas = Math.round(tareas * 100.0) / 100.0;

            parcial = (item.getParcial()) * .30;
            parcial = Math.round(parcial * 100.0) / 100.0;

            AutoEvaluacion = (item.getAutoE()) * .10;
            AutoEvaluacion = Math.round(AutoEvaluacion * 100.0) / 100.0;

            promedio = Math.round((parcial + tareas + AutoEvaluacion) * 100.0) / 100.0;

            System.out.println("Promedio tareas 60% = " + tareas + " del alumno :" + item.getNombre());

            modeloTablaPeriodo.addRow(new Object[]{
                item.getNombre(),
                item.getNotasActividades().get(0),
                item.getNotasActividades().get(1),
                item.getNotasActividades().get(2),
                item.getNotasActividades().get(3),
                tareas,
                AutoEvaluacion,
                item.getParcial(),
                parcial,
                promedio,});
        }

        tabla.setModel(modeloTablaPeriodo);
        /////////////////////////

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_GuardarActividad;
    private javax.swing.JComboBox<String> Cb_NIES;
    private javax.swing.JComboBox<String> Cb_Periodo;
    private javax.swing.JLabel Lb_Aerolinea1;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Aerolinea3;
    private javax.swing.JLabel Lb_Aerolinea4;
    private javax.swing.JLabel Lb_Docente;
    private javax.swing.JLabel Lb_Estudiante;
    private javax.swing.JLabel Lb_Estudiante1;
    private javax.swing.JLabel Lb_Estudiante2;
    private javax.swing.JLabel Lb_Estudiante3;
    private javax.swing.JLabel Lb_Estudiante4;
    private javax.swing.JLabel Lb_Estudiante5;
    private javax.swing.JLabel Lb_Grado;
    private javax.swing.JLabel Lb_Guardar;
    private javax.swing.JLabel Lb_Periodo;
    private javax.swing.JPanel Pnl_Boleta;
    private javax.swing.JTable Tbl_RegistroNotaPeriodo;
    private javax.swing.JTable Tbl_RegistroNotasTrimestres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_logo;
    // End of variables declaration//GEN-END:variables
}
