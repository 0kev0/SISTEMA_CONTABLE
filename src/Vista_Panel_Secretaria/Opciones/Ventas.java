package Vista_Panel_Secretaria.Opciones;

import Modelos.Secretaria.Modelo_Productos;
import Customizacion.TablaCusomizada;
import Funciones.Funciones;
import static Funciones.Funciones.ValidNIE;
import static Funciones.Funciones.clearScreen;
import Modelos.Docente.Modelo_Materias;
import Modelos.Docente.Modelo_Periodos;
import Modelos.Secretaria.Modelo_Estudiante;
import Modelos.Secretaria.Modelo_Responsables;
import Modelos.Secretaria.Modelo_TipoProducto;
import Modelos.Secretaria.Modelo_Transacciones;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class Ventas extends javax.swing.JInternalFrame {
    
    private final Modelo_Productos Objeto_Modelo_Productos = new Modelo_Productos();
    private List<Modelo_Productos> List_Productos;
    
    private Modelo_Materias Objeto_Modelo_Materias = new Modelo_Materias();
    private List<Modelo_Materias> List_Materias;
    
    private final Modelo_Periodos Objeto_Periodos = new Modelo_Periodos();
    private List<Modelo_Periodos> List_Periodos;
    
    private final Modelo_TipoProducto Objeto_TipoProducto = new Modelo_TipoProducto();
    private List<Modelo_TipoProducto> List_TipoProducto;
    
    private final Modelo_Responsables Objeto_Responsable = new Modelo_Responsables();
    private List<Modelo_Estudiante> List_Estudiantes;
    
    private ArrayList<Modelo_Productos> Carrito = new ArrayList<>();
    
    private final List<Modelo_Transacciones> Recibo = new ArrayList<>();
    
    private DefaultTableModel modeloTabla_Productos = new DefaultTableModel();
    private DefaultTableModel modeloTabla_Carrito = new DefaultTableModel();
    private JTable tabla_recibo ;
    
    private final String materia;
    private final int idmateria;
    
    public Ventas() {
        clearScreen();
        initComponents();

        // Configura el JInternalFrame
        modeloTabla_Productos = (DefaultTableModel) Tbl_Productos.getModel();
        modeloTabla_Carrito = (DefaultTableModel) Tbl_Carrito.getModel();
        
        int[] izqProdcutos = {1, 2};
        int[] izqCarrito = {1};
        
        DiseñoTabla(Tbl_Productos, izqProdcutos);
        DiseñoTabla(Tbl_Carrito, izqCarrito);
        
        Get_TiposProductos(Cb_TipoProducto);
        Cb_TipoProducto.setSelectedIndex(3);
        
        Get_Tbl_Productos(Tbl_Productos);
        
        Objeto_Modelo_Materias = Objeto_Modelo_Materias.Get_Materia(9876);
        materia = Objeto_Modelo_Materias.getNombreMateria();
        idmateria = Objeto_Modelo_Materias.getidMateria();

        // Lb_Materia_Periodo.setText(materia + " Periodo: " + Cb_TipoProducto.getSelectedItem().toString());
        Tbl_Productos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int COL = Tbl_Productos.columnAtPoint(e.getPoint());
                int ROW = Tbl_Productos.rowAtPoint(e.getPoint());
                
                if (COL == 6) {
                    int id = Integer.parseInt(modeloTabla_Productos.getValueAt(ROW, 0).toString());
                    String nombre = modeloTabla_Productos.getValueAt(ROW, 1).toString();
                    double Precio = Double.parseDouble(modeloTabla_Productos.getValueAt(ROW, 3).toString());
                    int Cantidad = 1;
                    int cantDisponible = Integer.parseInt(modeloTabla_Productos.getValueAt(ROW, 5).toString());
                    
                    System.out.println("item tomado" + id);
                    
                    Modelo_Productos productoAgregado = new Modelo_Productos();
                    
                    productoAgregado.setid(id);
                    productoAgregado.setNombre_Producto(nombre);
                    productoAgregado.setPrecio(Precio);
                    productoAgregado.setCant_venta(Cantidad);
                    
                    boolean productoYaExiste = false;
                    int index = 0;
                    
                    if (cantDisponible > 0) {
                        for (Modelo_Productos producto : Carrito) {
                            if (producto.getid() == id) {
                                productoYaExiste = true;
                                producto.setCant_venta(producto.getCant_venta() + 1);
                                modeloTabla_Productos.setValueAt(cantDisponible - 1, ROW, 5);
                                
                                break;
                            }
                        }
                        
                        if (productoYaExiste) {
                            System.out.println("¡El producto ya está en el carrito!");
                            ActualizarCarrito(Tbl_Carrito);
                            
                        } else {
                            // Agrega el producto a la lista
                            modeloTabla_Productos.setValueAt(cantDisponible - 1, ROW, 5);
                            Carrito.add(productoAgregado);
                            ActualizarCarrito(Tbl_Carrito);
                            
                            System.out.println("Producto agregado al carrito.");
                        }
                    } else {
                        Funciones.showMessageDialog("no hay mas en existencias", "error");
                    }

                }
                
            }
        });
        
        Tbl_Carrito.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int COL = Tbl_Productos.columnAtPoint(e.getPoint());
                int ROW = Tbl_Productos.rowAtPoint(e.getPoint());
                
                if (COL == 6) {
                    int id = Integer.parseInt(modeloTabla_Carrito.getValueAt(ROW, 0).toString());
                    int cant = Integer.parseInt(modeloTabla_Carrito.getValueAt(ROW, 3).toString());
                    
                    if (cant == 1) {
                        System.out.println("A borrar");
                        for (int i = 0; i < Carrito.size(); i++) {
                            Modelo_Productos producto = Carrito.get(i);
                            if (producto.getid() == id) {
                                Carrito.remove(i);
                                
                                producto.setCant_venta(producto.getCant_venta() - 1);
                                System.out.println("restado de " + producto.getNombre_Producto() + producto.getCant_venta());
                                
                                for (int x = 0; x < modeloTabla_Productos.getRowCount(); x++) {
                                    
                                    if (Integer.parseInt(modeloTabla_Productos.getValueAt(x, 0).toString()) == id) {
                                        
                                        int cantidad = Integer.parseInt(modeloTabla_Productos.getValueAt(x, 5).toString());
                                        System.out.println("A sumar 1 a " + cantidad);
                                        modeloTabla_Productos.setValueAt(cantidad + 1, x, 5);
                                        break; // Salimos del bucle una vez que encontramos el producto
                                    }
                                }
                                ActualizarCarrito(Tbl_Carrito);
                                
                            }
                        }
                    }
                    
                    if (cant > 1) {
                        System.out.println("A restar");
                        
                        for (int i = 0; i < Carrito.size(); i++) {
                            Modelo_Productos producto = Carrito.get(i);
                            
                            if (producto.getid() == id) {
                                System.out.println("A restar de " + producto.getNombre_Producto() + producto.getCant_venta());
                                
                                producto.setCant_venta(producto.getCant_venta() - 1);
                                System.out.println("restado de " + producto.getNombre_Producto() + producto.getCant_venta());
                                
                                for (int x = 0; x < modeloTabla_Productos.getRowCount(); x++) {
                                    
                                    if (Integer.parseInt(modeloTabla_Productos.getValueAt(x, 0).toString()) == id) {
                                        
                                        int cantidad = Integer.parseInt(modeloTabla_Productos.getValueAt(x, 5).toString());
                                        System.out.println("A sumar 1 a " + cantidad);
                                        modeloTabla_Productos.setValueAt(cantidad + 1, x, 5);
                                        break; // Salimos del bucle una vez que encontramos el producto
                                    }
                                }
                                
                                ActualizarCarrito(Tbl_Carrito);
                                
                                break; // Salimos del bucle una vez que encontramos el producto
                            }
                        }
                        
                    }

                }
                
            }
        });
    }
    
    public void ActualizarCarrito(JTable tabla) {
        modeloTabla_Carrito.setNumRows(0);
        
        System.out.print("hay en carrito: " + Carrito.size());
        //List_Actividades = Objeto_Actividades.GetActividades(idmateria);
        //System.out.println("hay " + List_Actividades.size());

        //ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));
        ImageIcon icono_add = new ImageIcon(getClass().getResource("/Imagenes/add.png"));
        ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/Imagenes/remove.png"));
        
        double Total = 0.0;
        
        for (Modelo_Productos item : Carrito) {
            System.out.println("hola con item " + item.getNombre_Producto());
            double subTotal = item.getPrecio() * item.getCant_venta();
            
            modeloTabla_Carrito.addRow(new Object[]{
                item.getid(),
                item.getNombre_Producto(),
                item.getPrecio(),
                item.getCant_venta(),
                subTotal,
                new JLabel(iconoEliminar)
            
            });
            Total += subTotal;
        }
        
        Lb_Total.setText(Double.toString(Total) + " $");
        tabla.setModel(modeloTabla_Carrito);
    }
    
    public void Del_Carrito(JTable tabla, List<Integer> product) {
        modeloTabla_Carrito.setNumRows(0);
        
        System.out.println("id mat : " + idmateria);
        //List_Actividades = Objeto_Actividades.GetActividades(idmateria);
        //System.out.println("hay " + List_Actividades.size());

        //ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));
        ImageIcon icono_add = new ImageIcon(getClass().getResource("/Imagenes/add.png"));
        ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/Imagenes/remove.png"));
        
        for (Integer item : product) {
            
            modeloTabla_Carrito.addRow(new Object[]{
                item, item, item, item, item,
                new JLabel(icono_add),
                new JLabel(iconoEliminar)
            
            });
        }
        
        tabla.setModel(modeloTabla_Carrito);
    }
    
    public void Get_Tbl_Productos(JTable tabla) {
        modeloTabla_Productos.setNumRows(0);
        
        List_Productos = Objeto_Modelo_Productos.Get_Productos();
        System.out.println("hay " + List_Productos.size());

        //ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));
        ImageIcon icono_add = new ImageIcon(getClass().getResource("/Imagenes/add.png"));
        ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/Imagenes/remove.png"));
        
        for (Modelo_Productos item : List_Productos) {
            
            modeloTabla_Productos.addRow(new Object[]{
                item.getid(),
                item.getNombre_Producto(),
                item.getDescripcion(),
                item.getPrecio(),
                item.getCosto(),
                item.getCant_Disponible(),
                new JLabel(icono_add)
            
            });
        }
        
        tabla.setModel(modeloTabla_Productos);
    }
    
    public void Get_Tbl_Productos_filtrada(JTable tabla) {
        int op = Cb_TipoProducto.getSelectedIndex() + 1;
        modeloTabla_Productos.setNumRows(0);
        
        System.out.println("buscando id tipo " + op);
        
        List_Productos = Objeto_Modelo_Productos.Get_Productos_filtrado(op);
        System.out.println("hay " + List_Productos.size());

        //ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/Imagenes/Edit_.png"));
        ImageIcon icono_add = new ImageIcon(getClass().getResource("/Imagenes/add.png"));
        ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/Imagenes/remove.png"));
        
        for (Modelo_Productos item : List_Productos) {
            
            modeloTabla_Productos.addRow(new Object[]{
                item.getid(),
                item.getNombre_Producto(),
                item.getDescripcion(),
                item.getPrecio(),
                item.getCosto(),
                item.getCant_Disponible(),
                new JLabel(icono_add)
            
            });
        }
        
        tabla.setModel(modeloTabla_Productos);
    }
    
    public void Get_TiposProductos(JComboBox ComboBox) {
        
        DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();
        
        List_TipoProducto = Objeto_TipoProducto.Get_TipoProductos();
        System.out.println("hay " + List_TipoProducto.size());
        
        for (Modelo_TipoProducto item : List_TipoProducto) {
            ModeloComboBox.addElement(item.getTipoProducto());
        }
        
        ComboBox.setModel(ModeloComboBox);
    }
    
    public void Get_Estudiantes(JComboBox ComboBox, int idResponsable) {
        try {
            DefaultComboBoxModel ModeloComboBox = new DefaultComboBoxModel();
            
            List_Estudiantes = Objeto_Responsable.Get_Estudiantes_delResponsable(idResponsable);
            System.out.println("hay " + List_TipoProducto.size());
            
            for (Modelo_Estudiante item : List_Estudiantes) {
                ModeloComboBox.addElement(item.getNIE() + " " + item.getNombres_Estudiante());
            }
            
            ComboBox.setModel(ModeloComboBox);
        } catch (Exception e) {
            // Manejo de excepciones aquí
            System.err.println("Error al cargar los elementos en el combo box: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Lb_Total = new javax.swing.JLabel();
        Cb_TipoProducto = new javax.swing.JComboBox<>();
        TB_CodigoResponsable = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Lb_Aerolinea2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Lb_Aerolinea3 = new javax.swing.JLabel();
        Btn_Vender = new javax.swing.JPanel();
        Lb_Guardar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Productos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_Carrito = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        Lb_Materia_Periodo2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Lb_Materia_Periodo1 = new javax.swing.JLabel();
        errorTb_CodigoResponsable = new javax.swing.JLabel();
        Cb_Estudiantes = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(153, 153, 153));
        setBorder(null);
        setTitle("Asignacion de actividades");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setEnabled(false);
        setFocusCycleRoot(false);
        setFocusable(false);
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jPanel1.setBackground(new java.awt.Color(234, 223, 180));
        jPanel1.setMinimumSize(new java.awt.Dimension(1060, 630));
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 180, 30));

        Cb_TipoProducto.setBackground(new java.awt.Color(224, 213, 170));
        Cb_TipoProducto.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_TipoProducto.setForeground(new java.awt.Color(0, 0, 0));
        Cb_TipoProducto.setToolTipText("");
        Cb_TipoProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Tipo de producto: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_TipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_TipoProductoActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_TipoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 180, -1));

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
        jPanel1.add(TB_CodigoResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 180, 50));

        jPanel4.setBackground(new java.awt.Color(226, 215, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 8, 0, new java.awt.Color(255, 153, 51)));

        Lb_Aerolinea2.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Aerolinea2.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Aerolinea2.setText("Venta de productos");

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

        Btn_Vender.setBackground(new java.awt.Color(226, 215, 132));
        Btn_Vender.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 8, 0, new java.awt.Color(255, 153, 51)));
        Btn_Vender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_VenderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_VenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_VenderMouseExited(evt);
            }
        });

        Lb_Guardar.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Guardar.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Lb_Guardar.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Guardar.setText("Realizar Venta");

        javax.swing.GroupLayout Btn_VenderLayout = new javax.swing.GroupLayout(Btn_Vender);
        Btn_Vender.setLayout(Btn_VenderLayout);
        Btn_VenderLayout.setHorizontalGroup(
            Btn_VenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(Btn_VenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_VenderLayout.createSequentialGroup()
                    .addContainerGap(21, Short.MAX_VALUE)
                    .addComponent(Lb_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        Btn_VenderLayout.setVerticalGroup(
            Btn_VenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
            .addGroup(Btn_VenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_VenderLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lb_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(Btn_Vender, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 200, 50));

        Tbl_Productos.setAutoCreateRowSorter(true);
        Tbl_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "iD", "Item", "Descripcion", "Precio", "Costo", "Cantidad", "Add"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tbl_Productos);
        if (Tbl_Productos.getColumnModel().getColumnCount() > 0) {
            Tbl_Productos.getColumnModel().getColumn(0).setPreferredWidth(40);
            Tbl_Productos.getColumnModel().getColumn(1).setPreferredWidth(200);
            Tbl_Productos.getColumnModel().getColumn(2).setPreferredWidth(350);
            Tbl_Productos.getColumnModel().getColumn(3).setPreferredWidth(80);
            Tbl_Productos.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 750, 220));

        Tbl_Carrito.setAutoCreateRowSorter(true);
        Tbl_Carrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "iD", "Item", "Precio", "Cantidad", "Sub-Total", "Remove"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Tbl_Carrito);
        if (Tbl_Carrito.getColumnModel().getColumnCount() > 0) {
            Tbl_Carrito.getColumnModel().getColumn(0).setPreferredWidth(40);
            Tbl_Carrito.getColumnModel().getColumn(1).setPreferredWidth(200);
            Tbl_Carrito.getColumnModel().getColumn(2).setPreferredWidth(80);
            Tbl_Carrito.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 750, 240));

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

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 180, 30));

        jPanel6.setBackground(new java.awt.Color(226, 215, 132));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 8, new java.awt.Color(255, 153, 51)));

        Lb_Materia_Periodo1.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Materia_Periodo1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        Lb_Materia_Periodo1.setForeground(new java.awt.Color(0, 0, 0));
        Lb_Materia_Periodo1.setText("Carrito");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(Lb_Materia_Periodo1)
                .addGap(17, 17, 17))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(Lb_Materia_Periodo1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 330, 180, 30));

        errorTb_CodigoResponsable.setBackground(new java.awt.Color(23, 42, 56));
        errorTb_CodigoResponsable.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        errorTb_CodigoResponsable.setForeground(new java.awt.Color(23, 42, 56));
        errorTb_CodigoResponsable.setText("Error");
        jPanel1.add(errorTb_CodigoResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 280, -1));

        Cb_Estudiantes.setBackground(new java.awt.Color(224, 213, 170));
        Cb_Estudiantes.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        Cb_Estudiantes.setForeground(new java.awt.Color(0, 0, 0));
        Cb_Estudiantes.setToolTipText("");
        Cb_Estudiantes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)), "Estudiantes :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Variable", 1, 14), new java.awt.Color(255, 153, 51))); // NOI18N
        Cb_Estudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_EstudiantesActionPerformed(evt);
            }
        });
        jPanel1.add(Cb_Estudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 180, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_VenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_VenderMouseClicked
        System.out.println("conteo: " + modeloTabla_Carrito.getRowCount());
        if (!Funciones.validarCampos(jPanel1) || modeloTabla_Carrito.getRowCount() == 0) {
            Funciones.showMessageDialog("Error", "Hay campos invalidos");
        } else {
            
            Date fecha = new Date();
            
            int respuesta = JOptionPane.showConfirmDialog(rootPane, "Resumen de compra\n Total de: " + Lb_Total.getText(), "Compra", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            
            switch (respuesta) {
                case JOptionPane.YES_OPTION -> {
                    int responsableid = Integer.parseInt(TB_CodigoResponsable.getText());//padre                       
                    int NIE = Funciones.convertirStringAInt(Cb_Estudiantes.getSelectedItem().toString());
                    
                    for (int fila = 0; fila < Tbl_Carrito.getRowCount(); fila++) {
                        
                        Modelo_Transacciones transaccion = new Modelo_Transacciones();
                        
                        String detalle = Tbl_Carrito.getValueAt(fila, 1).toString();
                        int id = Integer.parseInt(Tbl_Carrito.getValueAt(fila, 0).toString());
                        int cant = Integer.parseInt(Tbl_Carrito.getValueAt(fila, 3).toString());
                        double Sub_Total = Double.parseDouble(Tbl_Carrito.getValueAt(fila, 4).toString());
                        double precio = Double.parseDouble(Tbl_Carrito.getValueAt(fila, 2).toString());
                        
                        int tipo = 3;
                        double Precio = Double.parseDouble(Tbl_Carrito.getValueAt(fila, 2).toString());
                        double ganancia = Double.parseDouble(Tbl_Carrito.getValueAt(fila, 4).toString());
                        
                        double Costo = Objeto_Modelo_Productos.Get_Data(id);
                        double Ganancia = Sub_Total - (cant * Costo);
                        
                        transaccion.setId(id);
                        transaccion.setDetalles(detalle);
                        transaccion.setCantidades(cant);
                        transaccion.setPrecio(Precio);
                        transaccion.setMontos(Sub_Total);
                        transaccion.setId_tipo_transaccion(tipo);
                        transaccion.setCostos(Precio);
                        transaccion.setGanancias(ganancia);
                        transaccion.setNIES_Responsable(responsableid);
                        transaccion.setEstudiante_id(NIE);
                        transaccion.setFecha(fecha);
                        transaccion.setGanancias(Ganancia);
                        
                        transaccion.Insert_Transaccion(transaccion);
                        transaccion.Edit_Resta_inventario(transaccion);
                        Recibo.add(transaccion);
                        
                        Get_Tbl_Productos(Tbl_Productos);
                        
                    }
                    Modelo_Transacciones Datos = new Modelo_Transacciones();
                    Datos = Datos.Get_DatosRecibo(responsableid, NIE);
                    Recibo resumenDeCompra = new Recibo(Recibo, Datos,Tbl_Carrito);
                    resumenDeCompra.setVisible(true);
                }
                case JOptionPane.NO_OPTION ->
                    Funciones.showMessageDialog("Info", "Orden cancelada");
                default -> {
                }
            }
            
        }

// TODO add your handling code here:
    }//GEN-LAST:event_Btn_VenderMouseClicked

    private void Btn_VenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_VenderMouseEntered
        Funciones.EnterMouse(Btn_Vender, Lb_Guardar, "#FFF099", "#FF9900");
    }//GEN-LAST:event_Btn_VenderMouseEntered

    private void Btn_VenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_VenderMouseExited
        Funciones.LeftMouse(Btn_Vender, Lb_Guardar, "#E2D784", "#000000");
    }//GEN-LAST:event_Btn_VenderMouseExited

    private void TB_CodigoResponsableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_CodigoResponsableMouseEntered
        Funciones.Mouse_EnterTextbox(TB_CodigoResponsable);
    }//GEN-LAST:event_TB_CodigoResponsableMouseEntered

    private void TB_CodigoResponsableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_CodigoResponsableMouseExited
        Funciones.Mouse_LeftTextbox("Ingrese el codigo del responsable", TB_CodigoResponsable);
    }//GEN-LAST:event_TB_CodigoResponsableMouseExited

    private void Cb_TipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_TipoProductoActionPerformed
        
        modeloTabla_Productos.setNumRows(0);
        Get_Tbl_Productos_filtrada(Tbl_Productos);
    }//GEN-LAST:event_Cb_TipoProductoActionPerformed

    private void TB_CodigoResponsableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_CodigoResponsableKeyReleased
        ValidNIE(TB_CodigoResponsable, errorTb_CodigoResponsable);
        if (!TB_CodigoResponsable.getText().isBlank()) {
            int Id_Responsable = Integer.parseInt(TB_CodigoResponsable.getText());
            Get_Estudiantes(Cb_Estudiantes, Id_Responsable);
        }

    }//GEN-LAST:event_TB_CodigoResponsableKeyReleased

    private void TB_CodigoResponsableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TB_CodigoResponsableKeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_TB_CodigoResponsableKeyTyped

    private void Cb_EstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_EstudiantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cb_EstudiantesActionPerformed
    
    public void DiseñoTabla(JTable tabla, int[] izq) {
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
        
        int numeroDeCeldas = tabla.getColumnCount() - 1; // Cambia este valor al número de celdas que necesites

        for (int i = 0; i < numeroDeCeldas; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        
        for (int i = 0; i < izq.length; i++) {
            tabla.getColumnModel().getColumn(izq[i]).setCellRenderer(leftRenderer);
        }
        
        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(60, 45));
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_Vender;
    private javax.swing.JComboBox<String> Cb_Estudiantes;
    private javax.swing.JComboBox<String> Cb_TipoProducto;
    private javax.swing.JLabel Lb_Aerolinea2;
    private javax.swing.JLabel Lb_Aerolinea3;
    private javax.swing.JLabel Lb_Guardar;
    private javax.swing.JLabel Lb_Materia_Periodo1;
    private javax.swing.JLabel Lb_Materia_Periodo2;
    private javax.swing.JLabel Lb_Total;
    private javax.swing.JTextField TB_CodigoResponsable;
    private javax.swing.JTable Tbl_Carrito;
    private javax.swing.JTable Tbl_Productos;
    private javax.swing.JLabel errorTb_CodigoResponsable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
