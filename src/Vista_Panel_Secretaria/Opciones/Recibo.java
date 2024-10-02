package Vista_Panel_Secretaria.Opciones;

import Funciones.Creador_PDF;
import Funciones.EnviarCorreo;
import static Funciones.Funciones.EnterMouse;
import static Funciones.Funciones.LeftMouse;
import Modelos.Secretaria.Modelo_Transacciones;
import java.util.List;
import javax.swing.JTable;

public class Recibo extends javax.swing.JFrame {

    private String Detalle;
    private Modelo_Transacciones Datos;

    private JTable Tabla;

    public Recibo(List<Modelo_Transacciones> ResumenCompra, Modelo_Transacciones _Datos) {
        initComponents();
        setLocationRelativeTo(this);
        Tb_Concepto.setLineWrap(true);
        this.Detalle = "";
        this.Datos = _Datos;

        lb_Responsable.setText("Responsable :" + _Datos.getResponsable());
        Lb_Estudiante.setText("Estudiante : " + _Datos.getEstudiante());
        Lb_Correo.setText("Correo : " + _Datos.getCorreo());

        Double sub_total = 0.0;
        if (ResumenCompra.size() > 1) {
            for (Modelo_Transacciones item : ResumenCompra) {
                Detalle += "- " + item.getDetalles() + "\nCantidad: " + item.getCantidades() + " Precio : " + item.getPrecio() + " Sub-Total : " + item.getMontos() + "\n";
                sub_total += item.getMontos();
            }
        } else {
            for (Modelo_Transacciones item : ResumenCompra) {
                Detalle += "- " + item.getDetalles() + " Cantidad: " + item.getCantidades() + " Sub-Total : " + item.getMontos();
                sub_total = item.getMontos();
            }
        }

        Tb_Concepto.setText(Detalle);
        Lb_SubTotal.setText("Sub_Total: $ " + sub_total);

    }

    public Recibo(List<Modelo_Transacciones> ResumenCompra, Modelo_Transacciones _Datos, JTable _tabla) {
        initComponents();
        setLocationRelativeTo(this);
        Tb_Concepto.setLineWrap(true);
        this.Detalle = "";
        this.Tabla = _tabla;
        this.Datos = _Datos;

        lb_Responsable.setText("Responsable :" + _Datos.getResponsable());
        Lb_Estudiante.setText("Estudiante : " + _Datos.getEstudiante());
        Lb_Correo.setText("Correo : " + _Datos.getCorreo());

        Double sub_total = 0.0;
        if (ResumenCompra.size() > 1) {
            for (Modelo_Transacciones item : ResumenCompra) {
                Detalle += "- " + item.getDetalles() + "\nCantidad: " + item.getCantidades() + " Precio : " + item.getPrecio() + " Sub-Total : " + item.getMontos() + "\n";
                sub_total += item.getMontos();
            }
        } else {
            for (Modelo_Transacciones item : ResumenCompra) {
                Detalle += "- " + item.getDetalles() + " Cantidad: " + item.getCantidades() + " Sub-Total : " + item.getMontos();
                sub_total = item.getMontos();
            }
        }

        Tb_Concepto.setText(Detalle);
        Lb_SubTotal.setText("Sub_Total: $ " + sub_total);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        loading2 = new javax.swing.JLabel();
        Lb_SubTotal = new javax.swing.JLabel();
        Lb_Estudiante = new javax.swing.JLabel();
        lb_Responsable = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tb_Concepto = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        Btn_Regresar = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        Lb_Aerolinea9 = new javax.swing.JLabel();
        Lb_Ordenar = new javax.swing.JLabel();
        Lb_Correo = new javax.swing.JLabel();
        Btn_EnviarComprobante = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        Lb_Aerolinea6 = new javax.swing.JLabel();
        Lb_Crearcuenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recibo");
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jPanel5.setBackground(new java.awt.Color(23, 42, 56));

        loading2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        loading2.setForeground(new java.awt.Color(255, 255, 255));
        loading2.setText("Recibo");
        loading2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(255, 255, 255)));

        Lb_SubTotal.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        Lb_SubTotal.setForeground(new java.awt.Color(255, 255, 255));
        Lb_SubTotal.setText(" Sub-Total : $ ");

        Lb_Estudiante.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        Lb_Estudiante.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Estudiante.setText("Estudiante :");

        lb_Responsable.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lb_Responsable.setForeground(new java.awt.Color(255, 255, 255));
        lb_Responsable.setText("Responsable :");

        Tb_Concepto.setBackground(new java.awt.Color(61, 87, 88));
        Tb_Concepto.setColumns(20);
        Tb_Concepto.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Tb_Concepto.setForeground(new java.awt.Color(255, 255, 255));
        Tb_Concepto.setRows(5);
        Tb_Concepto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Concepto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(203, 174, 104))); // NOI18N
        jScrollPane1.setViewportView(Tb_Concepto);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO blsnco 80x80.jpg"))); // NOI18N

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

        jPanel10.setBackground(new java.awt.Color(255, 10, 10));

        Lb_Aerolinea9.setBackground(new java.awt.Color(255, 255, 255));
        Lb_Aerolinea9.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Lb_Aerolinea9.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea9))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lb_Aerolinea9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Btn_Regresar.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 149, 12));

        Lb_Ordenar.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Lb_Ordenar.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Ordenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back (1).png"))); // NOI18N
        Lb_Ordenar.setText("Regresar");
        Lb_Ordenar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Regresar.add(Lb_Ordenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 130, 30));

        Lb_Correo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        Lb_Correo.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Correo.setText("Correo :");

        Btn_EnviarComprobante.setBackground(new java.awt.Color(64, 124, 62));
        Btn_EnviarComprobante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_EnviarComprobante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_EnviarComprobanteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_EnviarComprobanteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_EnviarComprobanteMouseExited(evt);
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Lb_Aerolinea6))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lb_Aerolinea6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Lb_Crearcuenta.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Lb_Crearcuenta.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Crearcuenta.setText("Enviar Comprobante");
        Lb_Crearcuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout Btn_EnviarComprobanteLayout = new javax.swing.GroupLayout(Btn_EnviarComprobante);
        Btn_EnviarComprobante.setLayout(Btn_EnviarComprobanteLayout);
        Btn_EnviarComprobanteLayout.setHorizontalGroup(
            Btn_EnviarComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Btn_EnviarComprobanteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Crearcuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Btn_EnviarComprobanteLayout.setVerticalGroup(
            Btn_EnviarComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_EnviarComprobanteLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Lb_Crearcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_Responsable, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                            .addComponent(Lb_Estudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Lb_Correo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(233, Short.MAX_VALUE)
                        .addComponent(loading2)
                        .addGap(167, 167, 167)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Btn_Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_EnviarComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Lb_SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loading2))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_Responsable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lb_Estudiante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lb_Correo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lb_SubTotal)
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_EnviarComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
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
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseClicked

        dispose();
    }//GEN-LAST:event_Btn_RegresarMouseClicked

    private void Btn_RegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseEntered
        EnterMouse(Btn_Regresar, Lb_Ordenar, "#D90707", "#000000");
    }//GEN-LAST:event_Btn_RegresarMouseEntered

    private void Btn_RegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_RegresarMouseExited
        LeftMouse(Btn_Regresar, Lb_Ordenar, "#980505", "#FFFFFF");
    }//GEN-LAST:event_Btn_RegresarMouseExited

    private void Btn_EnviarComprobanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_EnviarComprobanteMouseClicked
        String FECHA = Funciones.Funciones.Get_DIA_Actual() + " " + Funciones.Funciones.Get_MES_Actual() + " " + Funciones.Funciones.Get_Year_Actual() + " ";

        if (Tabla != null) {

            String rutaPDF = Creador_PDF.createPDFWithTable(Tabla, "Comprobante_" + FECHA + " " + Datos.getNIES_Responsable() , Datos.getResponsable(), Datos.getCorreo(), Datos.getNIES_Responsable());
            Funciones.Funciones.showMessageDialog("info", "Comprobante enviado...");
            EnviarCorreo factura = new EnviarCorreo();


            String destinatario = "rr19118@ues.edu.sv";
            String asunto = "Prueba de envío de factura";
            String mensaje = Detalle;

            factura.enviarFactura(destinatario, asunto, mensaje, rutaPDF);
        } else {
            String rutaPDF = Creador_PDF.createPDFsinTabla("Comprobante_" + FECHA + " " + Datos.getNIES_Responsable() + ".pdf", Datos.getResponsable(), Datos.getCorreo(), Datos.getNIES_Responsable(), Detalle);
            Funciones.Funciones.showMessageDialog("info", "Comprobante enviado");
            EnviarCorreo factura = new EnviarCorreo();
            
            String destinatario = "rr19118@ues.edu.sv";
            String asunto = "Prueba de envío de factura";
            String mensaje = Detalle;

            factura.enviarFactura(destinatario, asunto, mensaje, rutaPDF);
        }


    }//GEN-LAST:event_Btn_EnviarComprobanteMouseClicked

    private void Btn_EnviarComprobanteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_EnviarComprobanteMouseEntered
        EnterMouse(Btn_EnviarComprobante, Lb_Crearcuenta, "#7BC778", "#000000");
    }//GEN-LAST:event_Btn_EnviarComprobanteMouseEntered

    private void Btn_EnviarComprobanteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_EnviarComprobanteMouseExited
        LeftMouse(Btn_EnviarComprobante, Lb_Crearcuenta, "#407C3E", "#FFFFFF");
    }//GEN-LAST:event_Btn_EnviarComprobanteMouseExited

    public Recibo() {
        initComponents();

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Recibo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_EnviarComprobante;
    private javax.swing.JPanel Btn_Regresar;
    private javax.swing.JLabel Lb_Aerolinea6;
    private javax.swing.JLabel Lb_Aerolinea9;
    private javax.swing.JLabel Lb_Correo;
    private javax.swing.JLabel Lb_Crearcuenta;
    private javax.swing.JLabel Lb_Estudiante;
    private javax.swing.JLabel Lb_Ordenar;
    private javax.swing.JLabel Lb_SubTotal;
    private javax.swing.JTextArea Tb_Concepto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Responsable;
    private javax.swing.JLabel loading2;
    // End of variables declaration//GEN-END:variables

}
