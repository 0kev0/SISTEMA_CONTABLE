package Vista_Panel_Secretaria.Opciones;

import Funciones.Funciones;
import Modelos.Docente.Modelo_Grados;
import Modelos.Secretaria.Modelo_Estudiante;
import Modelos.Secretaria.Modelo_Matricula;
import Modelos.Secretaria.Modelo_Responsables;
import Modelos.Secretaria.Modelo_TipoResponsable;
import Modelos.Secretaria.Modelo_Transacciones;
import Vista_Panel_Secretaria.Panel_Secretaria;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Panel_Inscripcion extends javax.swing.JFrame {

    private final Modelo_Grados Objeto_Grados = new Modelo_Grados();
    private List<Modelo_Grados> List_Grados;

    private final List<Modelo_Transacciones> Recibo = new ArrayList<>();

    private final Modelo_TipoResponsable Objeto_TipoResponsables = new Modelo_TipoResponsable();
    private List<Modelo_TipoResponsable> List_TipoResponsables;

    public Panel_Inscripcion() {
        initComponents();
        setLocationRelativeTo(this);
        Gestion_RegistrosInscripciones.Get_Cb_Grados(Cb_Grado, List_Grados, Objeto_Grados);
        Get_TipoResponsables(Cb_TipoResponsableA, List_TipoResponsables, Objeto_TipoResponsables);
        Get_TipoResponsables(Cb_TipoResponsable_B, List_TipoResponsables, Objeto_TipoResponsables);

    }

    public static void Get_TipoResponsables(JComboBox ComboBox, List<Modelo_TipoResponsable> List_TipoResponsables, Modelo_TipoResponsable Objeto_TipoResponsables) {

        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();

        List_TipoResponsables = Objeto_TipoResponsables.Get_List_TipoResponsable();
        System.out.println("hay " + List_TipoResponsables.size());

        for (Modelo_TipoResponsable item : List_TipoResponsables) {
            ModeloComboBox.addElement(item.getTipoResponsable());
        }

        ComboBox.setModel(ModeloComboBox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Txb_Apellido_Alumno = new javax.swing.JTextField();
        Txb_Nombre_Alumno = new javax.swing.JTextField();
        Txb_Direccion = new javax.swing.JTextField();
        TxbTelefono1 = new javax.swing.JTextField();
        Txb_Correo = new javax.swing.JTextField();
        Cb_TipoResponsableA = new javax.swing.JComboBox<>();
        errorNombre = new javax.swing.JLabel();
        LbErrorDirecc = new javax.swing.JLabel();
        LbErrorCorreo = new javax.swing.JLabel();
        LbErrorTel = new javax.swing.JLabel();
        LbErrorTel1 = new javax.swing.JLabel();
        Txb_ApellidosResponsableA = new javax.swing.JTextField();
        Txb_NombresResponsableA = new javax.swing.JTextField();
        errorNombre3 = new javax.swing.JLabel();
        errorNombre4 = new javax.swing.JLabel();
        errorNombre5 = new javax.swing.JLabel();
        Txb_ApellidosResponsableB = new javax.swing.JTextField();
        Txb_NombresResponsableB = new javax.swing.JTextField();
        errorNombre6 = new javax.swing.JLabel();
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
        Txb_idPadres = new javax.swing.JTextField();
        Btn_Buscar = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        Lb_Aerolinea8 = new javax.swing.JLabel();
        Lb_Buscar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jPanel5.setBackground(new java.awt.Color(17, 66, 50));

        Txb_Apellido_Alumno.setBackground(new java.awt.Color(17, 66, 50));
        Txb_Apellido_Alumno.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_Apellido_Alumno.setForeground(new java.awt.Color(255, 255, 255));
        Txb_Apellido_Alumno.setText("ingrese su apellidos");
        Txb_Apellido_Alumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_Apellido_Alumno.setCaretColor(new java.awt.Color(203, 174, 104));
        Txb_Apellido_Alumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Txb_Apellido_AlumnoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Txb_Apellido_AlumnoMouseExited(evt);
            }
        });
        Txb_Apellido_Alumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Txb_Apellido_AlumnoKeyTyped(evt);
            }
        });

        Txb_Nombre_Alumno.setBackground(new java.awt.Color(17, 66, 50));
        Txb_Nombre_Alumno.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_Nombre_Alumno.setForeground(new java.awt.Color(255, 255, 255));
        Txb_Nombre_Alumno.setText("ingrese su nombre");
        Txb_Nombre_Alumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_Nombre_Alumno.setCaretColor(new java.awt.Color(17, 66, 50));
        Txb_Nombre_Alumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Txb_Nombre_AlumnoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Txb_Nombre_AlumnoMouseExited(evt);
            }
        });
        Txb_Nombre_Alumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Txb_Nombre_AlumnoKeyTyped(evt);
            }
        });

        Txb_Direccion.setBackground(new java.awt.Color(17, 66, 50));
        Txb_Direccion.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_Direccion.setForeground(new java.awt.Color(255, 255, 255));
        Txb_Direccion.setText("ingrese su direccion");
        Txb_Direccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Direccion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_Direccion.setCaretColor(new java.awt.Color(203, 174, 104));
        Txb_Direccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Txb_DireccionMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Txb_DireccionMouseExited(evt);
            }
        });

        TxbTelefono1.setBackground(new java.awt.Color(17, 66, 50));
        TxbTelefono1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        TxbTelefono1.setForeground(new java.awt.Color(255, 255, 255));
        TxbTelefono1.setText("ingrese su numero de telefono");
        TxbTelefono1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        TxbTelefono1.setCaretColor(new java.awt.Color(203, 174, 104));
        TxbTelefono1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxbTelefono1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TxbTelefono1MouseExited(evt);
            }
        });
        TxbTelefono1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxbTelefono1KeyTyped(evt);
            }
        });

        Txb_Correo.setBackground(new java.awt.Color(17, 66, 50));
        Txb_Correo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_Correo.setForeground(new java.awt.Color(255, 255, 255));
        Txb_Correo.setText("ingrese su correo");
        Txb_Correo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_Correo.setCaretColor(new java.awt.Color(203, 174, 104));
        Txb_Correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Txb_CorreoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Txb_CorreoMouseExited(evt);
            }
        });
        Txb_Correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Txb_CorreoKeyTyped(evt);
            }
        });

        Cb_TipoResponsableA.setBackground(new java.awt.Color(17, 66, 50));
        Cb_TipoResponsableA.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Cb_TipoResponsableA.setForeground(new java.awt.Color(255, 255, 255));
        Cb_TipoResponsableA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de responsable A", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(203, 174, 104))); // NOI18N
        Cb_TipoResponsableA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Cb_TipoResponsableAItemStateChanged(evt);
            }
        });

        errorNombre.setBackground(new java.awt.Color(23, 42, 56));
        errorNombre.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        errorNombre.setForeground(new java.awt.Color(23, 42, 56));
        errorNombre.setText("Error");

        LbErrorDirecc.setBackground(new java.awt.Color(23, 42, 56));
        LbErrorDirecc.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        LbErrorDirecc.setForeground(new java.awt.Color(23, 42, 56));
        LbErrorDirecc.setText("Error");

        LbErrorCorreo.setBackground(new java.awt.Color(23, 42, 56));
        LbErrorCorreo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        LbErrorCorreo.setForeground(new java.awt.Color(23, 42, 56));
        LbErrorCorreo.setText("Error");

        LbErrorTel.setBackground(new java.awt.Color(23, 42, 56));
        LbErrorTel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        LbErrorTel.setForeground(new java.awt.Color(23, 42, 56));
        LbErrorTel.setText("Error");

        LbErrorTel1.setBackground(new java.awt.Color(23, 42, 56));
        LbErrorTel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        LbErrorTel1.setForeground(new java.awt.Color(23, 42, 56));
        LbErrorTel1.setText("Error");

        Txb_ApellidosResponsableA.setBackground(new java.awt.Color(17, 66, 50));
        Txb_ApellidosResponsableA.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_ApellidosResponsableA.setForeground(new java.awt.Color(255, 255, 255));
        Txb_ApellidosResponsableA.setText("Ingrese apellidos responsable A");
        Txb_ApellidosResponsableA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos responsable A", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_ApellidosResponsableA.setCaretColor(new java.awt.Color(203, 174, 104));
        Txb_ApellidosResponsableA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Txb_ApellidosResponsableAMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Txb_ApellidosResponsableAMouseExited(evt);
            }
        });
        Txb_ApellidosResponsableA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Txb_ApellidosResponsableAKeyTyped(evt);
            }
        });

        Txb_NombresResponsableA.setBackground(new java.awt.Color(17, 66, 50));
        Txb_NombresResponsableA.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_NombresResponsableA.setForeground(new java.awt.Color(255, 255, 255));
        Txb_NombresResponsableA.setText("Ingrese nombres responsable A");
        Txb_NombresResponsableA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres Responsable A", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_NombresResponsableA.setCaretColor(new java.awt.Color(17, 66, 50));
        Txb_NombresResponsableA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Txb_NombresResponsableAMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Txb_NombresResponsableAMouseExited(evt);
            }
        });
        Txb_NombresResponsableA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Txb_NombresResponsableAKeyTyped(evt);
            }
        });

        errorNombre3.setBackground(new java.awt.Color(23, 42, 56));
        errorNombre3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        errorNombre3.setForeground(new java.awt.Color(23, 42, 56));
        errorNombre3.setText("Error");

        errorNombre4.setBackground(new java.awt.Color(23, 42, 56));
        errorNombre4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        errorNombre4.setForeground(new java.awt.Color(23, 42, 56));
        errorNombre4.setText("Error");

        errorNombre5.setBackground(new java.awt.Color(23, 42, 56));
        errorNombre5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        errorNombre5.setForeground(new java.awt.Color(23, 42, 56));
        errorNombre5.setText("Error");

        Txb_ApellidosResponsableB.setBackground(new java.awt.Color(17, 66, 50));
        Txb_ApellidosResponsableB.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_ApellidosResponsableB.setForeground(new java.awt.Color(255, 255, 255));
        Txb_ApellidosResponsableB.setText("Ingrese apellidos responsable B");
        Txb_ApellidosResponsableB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos responsable B", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_ApellidosResponsableB.setCaretColor(new java.awt.Color(203, 174, 104));
        Txb_ApellidosResponsableB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Txb_ApellidosResponsableBMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Txb_ApellidosResponsableBMouseExited(evt);
            }
        });
        Txb_ApellidosResponsableB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Txb_ApellidosResponsableBKeyTyped(evt);
            }
        });

        Txb_NombresResponsableB.setBackground(new java.awt.Color(17, 66, 50));
        Txb_NombresResponsableB.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_NombresResponsableB.setForeground(new java.awt.Color(255, 255, 255));
        Txb_NombresResponsableB.setText("Ingrese nombres responsable B");
        Txb_NombresResponsableB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres Responsable B", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_NombresResponsableB.setCaretColor(new java.awt.Color(17, 66, 50));
        Txb_NombresResponsableB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Txb_NombresResponsableBMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Txb_NombresResponsableBMouseExited(evt);
            }
        });
        Txb_NombresResponsableB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Txb_NombresResponsableBKeyTyped(evt);
            }
        });

        errorNombre6.setBackground(new java.awt.Color(23, 42, 56));
        errorNombre6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        errorNombre6.setForeground(new java.awt.Color(23, 42, 56));
        errorNombre6.setText("Error");

        Cb_TipoResponsable_B.setBackground(new java.awt.Color(17, 66, 50));
        Cb_TipoResponsable_B.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Cb_TipoResponsable_B.setForeground(new java.awt.Color(255, 255, 255));
        Cb_TipoResponsable_B.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de responsable B", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(203, 174, 104))); // NOI18N
        Cb_TipoResponsable_B.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Cb_TipoResponsable_BItemStateChanged(evt);
            }
        });

        loading1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        loading1.setForeground(new java.awt.Color(203, 174, 104));
        loading1.setText("Primera Inscripcion");
        loading1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(203, 174, 104)));

        Cb_Grado.setBackground(new java.awt.Color(17, 66, 50));
        Cb_Grado.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Cb_Grado.setForeground(new java.awt.Color(255, 255, 255));
        Cb_Grado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grado: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(203, 174, 104))); // NOI18N
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
        Cb_Edad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Cb_EdadItemStateChanged(evt);
            }
        });

        TxbTelefono2.setBackground(new java.awt.Color(17, 66, 50));
        TxbTelefono2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        TxbTelefono2.setForeground(new java.awt.Color(255, 255, 255));
        TxbTelefono2.setText("ingrese su numero de telefono");
        TxbTelefono2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        TxbTelefono2.setCaretColor(new java.awt.Color(203, 174, 104));
        TxbTelefono2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxbTelefono2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TxbTelefono2MouseExited(evt);
            }
        });
        TxbTelefono2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxbTelefono2KeyTyped(evt);
            }
        });

        Txb_NIE.setBackground(new java.awt.Color(17, 66, 50));
        Txb_NIE.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_NIE.setForeground(new java.awt.Color(255, 255, 255));
        Txb_NIE.setText("Ingrese NIE");
        Txb_NIE.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NIE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
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

        Txb_idPadres.setBackground(new java.awt.Color(17, 66, 50));
        Txb_idPadres.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Txb_idPadres.setForeground(new java.awt.Color(255, 255, 255));
        Txb_idPadres.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo de esponsables :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 196, 54))); // NOI18N
        Txb_idPadres.setCaretColor(new java.awt.Color(203, 174, 104));
        Txb_idPadres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Txb_idPadresMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Txb_idPadresMouseExited(evt);
            }
        });
        Txb_idPadres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txb_idPadresKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txb_idPadresKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Txb_idPadresKeyTyped(evt);
            }
        });
        jPanel4.add(Txb_idPadres, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 171, -1));

        Btn_Buscar.setBackground(new java.awt.Color(64, 124, 62));
        Btn_Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_BuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_BuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_BuscarMouseExited(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(40, 200, 35));

        Lb_Aerolinea8.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Lb_Aerolinea8.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea8))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lb_Aerolinea8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Lb_Buscar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Lb_Buscar.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Buscar.setText("Buscar");
        Lb_Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout Btn_BuscarLayout = new javax.swing.GroupLayout(Btn_Buscar);
        Btn_Buscar.setLayout(Btn_BuscarLayout);
        Btn_BuscarLayout.setHorizontalGroup(
            Btn_BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_BuscarLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(Lb_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Btn_BuscarLayout.setVerticalGroup(
            Btn_BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_BuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 3, Short.MAX_VALUE))
        );

        jPanel4.add(Btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LbErrorDirecc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Txb_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(LbErrorCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 391, Short.MAX_VALUE))
                                    .addComponent(Txb_Correo)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(errorNombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(errorNombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(Txb_NombresResponsableB, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Txb_ApellidosResponsableB)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(TxbTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Cb_TipoResponsable_B, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(LbErrorTel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(errorNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(errorNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(Txb_NombresResponsableA, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Txb_ApellidosResponsableA)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(TxbTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Cb_TipoResponsableA, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(LbErrorTel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(errorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(64, 64, 64))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loading1)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(Txb_Nombre_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Txb_Apellido_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Cb_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Cb_Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Txb_NIE, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cb_Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cb_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txb_NIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(loading1)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txb_Nombre_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txb_Apellido_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorNombre)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(errorNombre3)
                        .addComponent(errorNombre4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Cb_TipoResponsableA, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxbTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Txb_ApellidosResponsableA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Txb_NombresResponsableA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LbErrorTel)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Txb_ApellidosResponsableB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxbTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cb_TipoResponsable_B, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Txb_NombresResponsableB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(errorNombre6)
                    .addComponent(errorNombre5)
                    .addComponent(LbErrorTel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Txb_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LbErrorDirecc))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Txb_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LbErrorCorreo)))
                .addGap(44, 44, 44)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxbTelefono2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxbTelefono2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TxbTelefono2KeyTyped

    private void TxbTelefono2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxbTelefono2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_TxbTelefono2MouseExited

    private void TxbTelefono2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxbTelefono2MouseClicked
        TxbTelefono2.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_TxbTelefono2MouseClicked

    private void Cb_EdadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cb_EdadItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Cb_EdadItemStateChanged

    private void Cb_GradoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cb_GradoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Cb_GradoItemStateChanged

    private void Cb_TipoResponsable_BItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cb_TipoResponsable_BItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Cb_TipoResponsable_BItemStateChanged

    private void Txb_NombresResponsableBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txb_NombresResponsableBKeyTyped

    }//GEN-LAST:event_Txb_NombresResponsableBKeyTyped

    private void Txb_NombresResponsableBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_NombresResponsableBMouseExited

    }//GEN-LAST:event_Txb_NombresResponsableBMouseExited

    private void Txb_NombresResponsableBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_NombresResponsableBMouseClicked
        clearTxb(Txb_NombresResponsableB);

    }//GEN-LAST:event_Txb_NombresResponsableBMouseClicked

    private void Txb_ApellidosResponsableBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txb_ApellidosResponsableBKeyTyped

    }//GEN-LAST:event_Txb_ApellidosResponsableBKeyTyped

    private void Txb_ApellidosResponsableBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_ApellidosResponsableBMouseExited

    }//GEN-LAST:event_Txb_ApellidosResponsableBMouseExited

    private void Txb_ApellidosResponsableBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_ApellidosResponsableBMouseClicked
        clearTxb(Txb_ApellidosResponsableB);

    }//GEN-LAST:event_Txb_ApellidosResponsableBMouseClicked

    private void Txb_NombresResponsableAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txb_NombresResponsableAKeyTyped

    }//GEN-LAST:event_Txb_NombresResponsableAKeyTyped

    private void Txb_NombresResponsableAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_NombresResponsableAMouseExited

    }//GEN-LAST:event_Txb_NombresResponsableAMouseExited

    private void Txb_NombresResponsableAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_NombresResponsableAMouseClicked
        clearTxb(Txb_NombresResponsableA);

    }//GEN-LAST:event_Txb_NombresResponsableAMouseClicked

    private void Txb_ApellidosResponsableAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txb_ApellidosResponsableAKeyTyped

    }//GEN-LAST:event_Txb_ApellidosResponsableAKeyTyped

    private void Txb_ApellidosResponsableAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_ApellidosResponsableAMouseExited
        clearTxb(Txb_ApellidosResponsableA);

    }//GEN-LAST:event_Txb_ApellidosResponsableAMouseExited

    private void Txb_ApellidosResponsableAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_ApellidosResponsableAMouseClicked
        clearTxb(Txb_ApellidosResponsableA);

    }//GEN-LAST:event_Txb_ApellidosResponsableAMouseClicked

    private void Btn_InscribirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_InscribirMouseExited
        Funciones.LeftMouse(Btn_Inscribir, Lb_Crearcuenta, "#407C3E", "#FFFFFF");
    }//GEN-LAST:event_Btn_InscribirMouseExited

    private void Btn_InscribirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_InscribirMouseEntered
        Funciones.EnterMouse(Btn_Inscribir, Lb_Crearcuenta, "#7BC778", "#000000");
    }//GEN-LAST:event_Btn_InscribirMouseEntered

    private void Btn_InscribirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_InscribirMouseClicked
        ///con id previo
        Modelo_Responsables Responsables = new Modelo_Responsables();
        int idResponsable = Integer.parseInt(Txb_idPadres.getText());

        if (Responsables.Valid_IdResponsable(idResponsable)) {

            if (Funciones.validarCampos(jPanel5)) {
                System.out.println("Todo bien");

                System.out.println("Responsables agregados id " + idResponsable);

                Modelo_Estudiante EstudianteNuevo = new Modelo_Estudiante();

                EstudianteNuevo.setNIE(Integer.parseInt(Txb_NIE.getText()));
                EstudianteNuevo.setNombres_Estudiante(Txb_Nombre_Alumno.getText());
                EstudianteNuevo.setApellidos_Estudiante(Txb_Apellido_Alumno.getText());
                EstudianteNuevo.setId_Responsables(idResponsable);
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
                    Matricula.setId_Responsables(idResponsable);
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

                    int respuesta = JOptionPane.showConfirmDialog(rootPane, "Resumen de compra\n Total de: " + 100, "Inscripcion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                    switch (respuesta) {
                        case JOptionPane.YES_OPTION -> {

                            Modelo_Transacciones transaccion = new Modelo_Transacciones();

                            String detalle = "Inscripcion alumno " + EstudianteNuevo.getNombres_Estudiante();
                            int cant = 1;
                            double Sub_Total = 100;

                            int tipo = 3;//id de transaccion de tipo inscripcion
                            double Precio = 100;
                            double ganancia = 100;

                            double Costo = 0;
                            double Ganancia = Sub_Total - (cant * Costo);

                            transaccion.setDetalles(detalle);
                            transaccion.setCantidades(cant);
                            transaccion.setPrecio(Precio);
                            transaccion.setMontos(Sub_Total);
                            transaccion.setId_tipo_transaccion(tipo);
                            transaccion.setCostos(Precio);
                            transaccion.setGanancias(ganancia);
                            transaccion.setNIES_Responsable(idResponsable);
                            transaccion.setEstudiante_id(NIE);
                            transaccion.setFecha(fecha);
                            transaccion.setGanancias(Ganancia);

                            transaccion.Insert_Transaccion(transaccion);
                            transaccion.Edit_Resta_inventario(transaccion);
                            Recibo.add(transaccion);

                            Modelo_Transacciones Datos = new Modelo_Transacciones();
                            Datos = Datos.Get_DatosRecibo(idResponsable, NIE);

                            Recibo resumenDeCompra = new Recibo(Recibo, Datos);
                            resumenDeCompra.setVisible(true);
                        }
                        case JOptionPane.NO_OPTION ->
                            Funciones.showMessageDialog("Info", "Orden cancelada");
                        default -> {
                        }
                    }
                }

            }
        } else {
            if (Funciones.validarCampos(jPanel5)) {
                System.out.println("Todo bien");

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

                    int idresponsable = Responsables.Get_IdReciente() + 1;
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

                        int respuesta = JOptionPane.showConfirmDialog(rootPane, "Resumen de compra\n Total de: " + 100, "Inscripcion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                        switch (respuesta) {
                            case JOptionPane.YES_OPTION -> {

                                Modelo_Transacciones transaccion = new Modelo_Transacciones();

                                String detalle = "Inscripcion alumno " + EstudianteNuevo.getNombres_Estudiante();
                                int cant = 1;
                                double Sub_Total = 100;

                                int tipo = 3;//id de transaccion de tipo inscripcion
                                double Precio = 100;
                                double ganancia = 100;

                                double Costo = 0;
                                double Ganancia = Sub_Total - (cant * Costo);

                                transaccion.setDetalles(detalle);
                                transaccion.setCantidades(cant);
                                transaccion.setPrecio(Precio);
                                transaccion.setMontos(Sub_Total);
                                transaccion.setId_tipo_transaccion(tipo);
                                transaccion.setCostos(Precio);
                                transaccion.setGanancias(ganancia);
                                transaccion.setNIES_Responsable(idresponsable);
                                transaccion.setEstudiante_id(NIE);
                                transaccion.setFecha(fecha);
                                transaccion.setGanancias(Ganancia);

                                transaccion.Insert_Transaccion(transaccion);
                                transaccion.Edit_Resta_inventario(transaccion);
                                Recibo.add(transaccion);

                                Modelo_Transacciones Datos = new Modelo_Transacciones();
                                Datos = Datos.Get_DatosRecibo(idresponsable, NIE);

                                Recibo resumenDeCompra = new Recibo(Recibo, Datos);
                                resumenDeCompra.setVisible(true);
                            }
                            case JOptionPane.NO_OPTION ->
                                Funciones.showMessageDialog("Info", "Orden cancelada");
                            default -> {
                            }
                        }
                    }

                }
            }
        }

    }//GEN-LAST:event_Btn_InscribirMouseClicked

    private void Btn_RegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseExited
        Funciones.LeftMouse(Btn_Regresar, Lb_Ordenar, "#980505", "#FFFFFF");
    }//GEN-LAST:event_Btn_RegresarMouseExited

    private void Btn_RegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseEntered
        Funciones.EnterMouse(Btn_Regresar, Lb_Ordenar, "#D90707", "#000000");
    }//GEN-LAST:event_Btn_RegresarMouseEntered

    private void Btn_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseClicked
        Panel_Secretaria log = new Panel_Secretaria();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_Btn_RegresarMouseClicked

    private void Cb_TipoResponsableAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cb_TipoResponsableAItemStateChanged
        String doc = Cb_TipoResponsableA.getSelectedItem().toString();
        //        TxbDocIdentidad.setText("Ingrese su " + doc);
    }//GEN-LAST:event_Cb_TipoResponsableAItemStateChanged

    private void Txb_CorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txb_CorreoKeyTyped

    }//GEN-LAST:event_Txb_CorreoKeyTyped

    private void Txb_CorreoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_CorreoMouseExited
        if (Txb_Correo.getText().equals("")) {
            Txb_Correo.setText("Ingrese su correo");
        }
    }//GEN-LAST:event_Txb_CorreoMouseExited

    private void Txb_CorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_CorreoMouseClicked
        clearTxb(Txb_Correo);
    }//GEN-LAST:event_Txb_CorreoMouseClicked

    private void TxbTelefono1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxbTelefono1KeyTyped
        Funciones.ValidNumeroTel(TxbTelefono1, LbErrorTel);
    }//GEN-LAST:event_TxbTelefono1KeyTyped

    private void TxbTelefono1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxbTelefono1MouseExited
        if (TxbTelefono1.getText().equals("")) {
            TxbTelefono1.setText("Ingrese su numero de telefono");
        }
    }//GEN-LAST:event_TxbTelefono1MouseExited

    private void TxbTelefono1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxbTelefono1MouseClicked
        clearTxb(TxbTelefono1);

    }//GEN-LAST:event_TxbTelefono1MouseClicked

    private void Txb_DireccionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_DireccionMouseExited
        if (Txb_Direccion.getText().equals("")) {
            Txb_Direccion.setText("Ingrese su direccion");
        }
    }//GEN-LAST:event_Txb_DireccionMouseExited

    private void Txb_DireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_DireccionMouseClicked
        clearTxb(Txb_Direccion);

    }//GEN-LAST:event_Txb_DireccionMouseClicked

    private void Txb_Nombre_AlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txb_Nombre_AlumnoKeyTyped
        Funciones.ValidNombres(Txb_Nombre_Alumno, errorNombre);
    }//GEN-LAST:event_Txb_Nombre_AlumnoKeyTyped

    private void Txb_Nombre_AlumnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_Nombre_AlumnoMouseExited
        if (Txb_Nombre_Alumno.getText().equals("")) {
            Txb_Nombre_Alumno.setText("Ingrese su nombre");
        }
    }//GEN-LAST:event_Txb_Nombre_AlumnoMouseExited

    private void Txb_Nombre_AlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_Nombre_AlumnoMouseClicked
        clearTxb(Txb_Nombre_Alumno);
    }//GEN-LAST:event_Txb_Nombre_AlumnoMouseClicked

    private void Txb_Apellido_AlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txb_Apellido_AlumnoKeyTyped
//        Funciones.ValidNombres(Txb_Apellido_Alumno, errorApellidoMaterno);
    }//GEN-LAST:event_Txb_Apellido_AlumnoKeyTyped

    private void Txb_Apellido_AlumnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_Apellido_AlumnoMouseExited
        if (Txb_Apellido_Alumno.getText().equals("")) {
            Txb_Apellido_Alumno.setText("Ingrese su apellido materno");
        }
    }//GEN-LAST:event_Txb_Apellido_AlumnoMouseExited

    private void Txb_Apellido_AlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_Apellido_AlumnoMouseClicked
        Txb_Apellido_Alumno.setText("");
    }//GEN-LAST:event_Txb_Apellido_AlumnoMouseClicked

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
        Panel_Reinscripcion gest = new Panel_Reinscripcion();
        dispose();
        gest.setVisible(true);
    }//GEN-LAST:event_Btn_InscripcionMouseClicked

    private void Btn_InscripcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_InscripcionMouseEntered
        Funciones.EnterMouse(Btn_Inscripcion, Lb_Inventario, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_InscripcionMouseEntered

    private void Btn_InscripcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_InscripcionMouseExited
        Funciones.LeftMouse(Btn_Inscripcion, Lb_Inventario, "#FAF4D0", "#000000");
    }//GEN-LAST:event_Btn_InscripcionMouseExited

    private void Txb_idPadresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_idPadresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Txb_idPadresMouseClicked

    private void Txb_idPadresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Txb_idPadresMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Txb_idPadresMouseExited

    private void Txb_idPadresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txb_idPadresKeyTyped


    }//GEN-LAST:event_Txb_idPadresKeyTyped

    private void Txb_idPadresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txb_idPadresKeyPressed

    }//GEN-LAST:event_Txb_idPadresKeyPressed

    private void Txb_idPadresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txb_idPadresKeyReleased
        // verificar y cargar datos de padres .


    }//GEN-LAST:event_Txb_idPadresKeyReleased

    private void Btn_BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_BuscarMouseClicked
        int id = Integer.parseInt(Txb_idPadres.getText());
        Modelo_Responsables responsable = new Modelo_Responsables();
        responsable = responsable.Get_DataResponsable(id);

        if (responsable.getId() != 0) {
            Txb_ApellidosResponsableA.setText(responsable.getApellidos_A());
            Txb_NombresResponsableA.setText(responsable.getNombres_A());
            TxbTelefono1.setText(responsable.getTelefonoA());
            Cb_TipoResponsableA.setSelectedIndex(responsable.getId_TipoA());

            Txb_ApellidosResponsableB.setText(responsable.getApellidos_B());
            Txb_NombresResponsableB.setText(responsable.getNombres_B());
            TxbTelefono2.setText(responsable.getTelefonoB());
            Cb_TipoResponsable_B.setSelectedIndex(responsable.getId_TipoB());

            Txb_Direccion.setText(responsable.getDireccion());
            Txb_Correo.setText(responsable.getCorreo());

        }

    }//GEN-LAST:event_Btn_BuscarMouseClicked

    private void Btn_BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_BuscarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_BuscarMouseEntered

    private void Btn_BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_BuscarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_BuscarMouseExited

    public static void clearTxb(JTextField TextBox) {
        TextBox.setText("");
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Panel_Inscripcion().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_Buscar;
    private javax.swing.JPanel Btn_Inscribir;
    private javax.swing.JPanel Btn_Inscripcion;
    private javax.swing.JPanel Btn_Inventario1;
    private javax.swing.JPanel Btn_Regresar;
    private javax.swing.JComboBox<String> Cb_Edad;
    private javax.swing.JComboBox<String> Cb_Grado;
    private javax.swing.JComboBox<String> Cb_TipoResponsableA;
    private javax.swing.JComboBox<String> Cb_TipoResponsable_B;
    private javax.swing.JLabel LbErrorCorreo;
    private javax.swing.JLabel LbErrorDirecc;
    private javax.swing.JLabel LbErrorTel;
    private javax.swing.JLabel LbErrorTel1;
    private javax.swing.JLabel Lb_Aerolinea6;
    private javax.swing.JLabel Lb_Aerolinea7;
    private javax.swing.JLabel Lb_Aerolinea8;
    private javax.swing.JLabel Lb_Buscar;
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
    private javax.swing.JTextField Txb_idPadres;
    private javax.swing.JLabel errorNombre;
    private javax.swing.JLabel errorNombre3;
    private javax.swing.JLabel errorNombre4;
    private javax.swing.JLabel errorNombre5;
    private javax.swing.JLabel errorNombre6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel loading1;
    // End of variables declaration//GEN-END:variables
}
