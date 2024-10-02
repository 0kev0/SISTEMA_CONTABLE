package Funciones;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.System.out;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Funciones {
    
    
    

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void TiemSql() {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();

        long elapsedTimeInNanoseconds = endTime - startTime;

        System.out.println("Tiempo de ejecucion : " + elapsedTimeInNanoseconds + " ns");
    }

    public static void Menu_Item_Mouse_Action(JMenu JMenu_1, String color) throws NumberFormatException {
        JMenu_1.setOpaque(true);
        JMenu_1.setBackground(Color.decode(color));
    }

    public static void EnterMouse_Menu(MenuItem MenuItem, JLabel lable, String color1, String color2) throws NumberFormatException {
        JMenuItem menuItem = new JMenuItem("Mi elemento de menú");
        menuItem.setOpaque(true);
        menuItem.setBackground(Color.RED);

    }

    public static void LeftMouse_Menu(JPanel panel, JLabel lable, String color1, String color2) throws NumberFormatException {
        panel.setBackground(Color.decode(color1));
        lable.setForeground(Color.decode(color2));
    }

    public static void EnterMouse(JPanel panel, JLabel lable, String color1, String color2) throws NumberFormatException {
        panel.setBackground(Color.decode(color1));
        lable.setForeground(Color.decode(color2));
    }

    public static void LeftMouse(JPanel panel, JLabel lable, String color1, String color2) throws NumberFormatException {
        panel.setBackground(Color.decode(color1));
        lable.setForeground(Color.decode(color2));
    }

    public static void ClickTxbFecha(JTextField Textbox) throws NumberFormatException {
        Textbox.setText("");
    }

    public static void LeftMouseTxb(JTextField Textbox, String text) throws NumberFormatException {
        if (Textbox.getText().equals("")) {
            Textbox.setText(text);
        }

    }

    public static void Mouse_EnterTextbox(JTextField textbox) {
        if (textbox.getText().contains("Ingrese")) {
            textbox.setText("");
        }
    }

    public static void Mouse_LeftTextbox(String textoinicial, JTextField textbox) {
        if (textbox.getText().equalsIgnoreCase("")) {
            textbox.setText(textoinicial);
        }
    }

    public static int Get_Year_Actual() {
        // Obtener el año actual
        int añoActual = Calendar.getInstance().get(Calendar.YEAR);
        return añoActual;
    }

    public static int Get_MES_Actual() {
        // Obtener el mes actual
        int mesActual = Calendar.getInstance().get(Calendar.MONTH) + 1;
        return mesActual;
    }

        public static int Get_DIA_Actual() {
        // Obtener el mes actual
        int mesActual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) ;
        return mesActual;
    }
        
    public static String obtenerFechaActual() {
        // Obtener la fecha y hora actual
        Date fecha = new Date();

        // Formatear la fecha como una cadena
        SimpleDateFormat formato = new SimpleDateFormat("EEEE / dd / MMMM / yyyy", new Locale("es"));
        String fechaFormateada = formato.format(fecha);

        return fechaFormateada;
    }

    public static void DateValid(JTextField textbox, int maxlimit, JLabel error, int DigitLimit) {
        textbox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    showError("***Formato erroneo, solo numeros***");
                    e.consume();
                }

                if (textbox.getText().length() >= DigitLimit) // limit textfield  2 digitos
                {
                    showError("***Cantidad de digitos excedido***");
                    e.consume();
                }

                try {
                    String input = textbox.getText() + c;
                    if (!input.isEmpty()) {

                        int date = Integer.parseInt(input);
                        if (date > maxlimit) {
                            showError("***Numero invalido***");
                            e.consume();
                        }
                    }
                } catch (NumberFormatException ex) {
                    out.println("El texto no se pudo convertir a un número, maneja el error aquí" + ex.getMessage());
                }
            }

            private void showError(String errorMessage) {
                error.setText(errorMessage);
                error.setForeground(Color.RED);
                out.println(errorMessage);
                textbox.setText("");
                Timer timer = new Timer(1000, e -> error.setForeground(Color.decode("#172A38")));
                timer.setRepeats(false);
                timer.start();
            }
        });
    }

    public static void ValidNombres(JTextField textbox, JLabel error) {
        textbox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    showError("***Formato erroneo, solo letras***");
                    e.consume();
                    textbox.removeKeyListener(this);
                }

                if (textbox.getText().length() >= 30) {
                    showError("***Cantidad de caracteres excedido***");
                    e.consume();
                    textbox.removeKeyListener(this);

                }
            }

            private void showError(String errorMessage) {
                error.setText(errorMessage);
                error.setForeground(Color.RED);
                System.out.println(errorMessage);
                textbox.setText("");

                Timer timer = new Timer(2000, e -> {
                    // Después de 2 segundos, restablece el color del error y vacía el campo de texto
                    error.setForeground(Color.decode("#172A38"));
                    textbox.setText("");
                    error.setText("");
                    textbox.removeKeyListener(this); // Detiene el KeyListener
                });
                timer.setRepeats(false);
                timer.start();
            }
        });
    }

    public static int convertirStringAInt(String cadena) {
        // Eliminar letras y espacios de la cadena
        String cadenaSinLetras = cadena.replaceAll("[^0-9]", "");

        // Convertir la cadena sin letras a un entero
        int resultado = Integer.parseInt(cadenaSinLetras);

        return resultado;
    }

    public static void ValidNIE(JTextField textbox, JLabel error) {
        textbox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    showError("***Formato erróneo, solo números enteros***");
                    e.consume();
                } else if (textbox.getText().length() >= 5) {
                    showError("***El NIE debe tener máximo 5 dígitos***");
                    e.consume();
                }
            }

            private void showError(String errorMessage) {
                error.setText(errorMessage);
                error.setForeground(Color.RED);
                System.out.println(errorMessage);
                textbox.setText("");

                Timer timer = new Timer(2000, e -> {
                    // Después de 2 segundos, restablece el color del error y vacía el campo de texto
                    error.setForeground(Color.decode("#172A38"));
                    textbox.setText("");
                    error.setText("");
                    textbox.removeKeyListener(this); // Detiene el KeyListener
                });
                timer.setRepeats(false);
                timer.start();
            }
        });
    }

    public static void ValidEnteros(JTextField textbox, JLabel error) {
        textbox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    showError("***Formato erroneo, solo números enteros***");
                    e.consume();
                }

            }

            private void showError(String errorMessage) {
                error.setText(errorMessage);
                error.setForeground(Color.RED);
                System.out.println(errorMessage);
                textbox.setText("");
                Timer timer = new Timer(1000, e -> error.setForeground(Color.decode("#172A38")));
                timer.setRepeats(false);
                timer.start();
            }
        });
    }

    public static void ValidarNota(JTextField textbox, JLabel error) {
        textbox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!(Character.isDigit(c) || c == '.' || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    showError("***Formato erróneo, solo números enteros o fraccionarios***");
                    e.consume();
                } else {
                    try {
                        double nota = Double.parseDouble(textbox.getText());
                        if (nota < 0 || nota > 10) {
                            showError("***La nota debe estar entre 0 y 10***");
                            e.consume();
                        }
                    } catch (NumberFormatException ex) {
                        showError("***Formato erróneo, ingresa un número válido***");
                        e.consume();
                    }
                }
            }

            private void showError(String errorMessage) {
                error.setText(errorMessage);
                error.setForeground(Color.RED);
                System.out.println(errorMessage);
                textbox.setText("");
                Timer timer = new Timer(1000, e -> error.setForeground(Color.decode("#172A38")));
                timer.setRepeats(false);
                timer.start();
            }
        });
    }

    public static void ValidNumeroTel(JTextField textbox, JLabel error) {
        textbox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = textbox.getText();

                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '-'))) {
                    showError("***Formato erroneo, solo números y un guión***");
                    e.consume();
                } else if (c == '-' && (text.contains("--") || text.length() != 4)) {
                    showError("***El guión solo puede estar una ves***");
                    e.consume();
                } else if (Character.isDigit(c) && text.length() >= 9) {
                    showError("***No puede ingresar más de 8 números***");
                    e.consume();
                }
            }

            private void showError(String errorMessage) {
                error.setText(errorMessage);
                error.setForeground(Color.RED);
                System.out.println(errorMessage);
                textbox.setText("");
                Timer timer = new Timer(1000, e -> error.setForeground(Color.decode("#172A38")));
                timer.setRepeats(false);
                timer.start();
            }
        });
    }

    public static void ValidDoc(JTextField textbox, JLabel error) {
        textbox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = textbox.getText();

                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '-'))) {
                    showError("***Formato erroneo, solo números y un guión***");
                    e.consume();
                } else if (c == '-' && text.contains("-")) {
                    showError("***El guión solo puede estar una vez***");
                    e.consume();
                } else if (Character.isDigit(c) && text.length() >= 10) {
                    showError("***No puede ingresar más de 8 números***");
                    e.consume();
                }
            }

            private void showError(String errorMessage) {
                error.setText(errorMessage);
                error.setForeground(Color.RED);
                System.out.println(errorMessage);
                textbox.setText("");
                Timer timer = new Timer(1000, e -> error.setForeground(Color.decode("#172A38")));
                timer.setRepeats(false);
                timer.start();
            }
        });
    }

    public static void ValidFraciones(JTextField textbox, JLabel error) {
        textbox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '.'))) {
                    showError("***Formato erroneo, solo fracciones o números enteros***");
                    e.consume();
                } else if (c == '.' && textbox.getText().contains(".")) {
                    showError("***No puede ingresar más de un punto decimal***");
                    e.consume();
                }

            }

            private void showError(String errorMessage) {
                error.setText(errorMessage);
                error.setForeground(Color.RED);
                System.out.println(errorMessage);
                textbox.setText("");
                Timer timer = new Timer(1000, e -> error.setForeground(Color.decode("#172A38")));
                timer.setRepeats(false);
                timer.start();
            }
        });
    }

    public static void CentrarFrames(JDesktopPane jDesktopPane1, JInternalFrame internalFrame) {
        for (JInternalFrame frame : jDesktopPane1.getAllFrames()) {
            frame.dispose();
        }

        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = internalFrame.getSize();
        internalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

    }

    public static boolean validarCampos(JPanel panel) {
        for (Component c : panel.getComponents()) {
            if (c instanceof JTextField jTextField) {
                if (jTextField.getText().trim().isEmpty() || jTextField.getText().trim().toLowerCase().contains("ingrese")) {
                    System.out.println(">" + jTextField.getText());
                    JOptionPane.showMessageDialog(c, "Campos vacios, por favor llene todos los campos ");
                    return false;
                }

            }
        }
        return true;
    }

    public static boolean validarDates(JPanel panel) {
        for (Component c : panel.getComponents()) {
            if (c instanceof JTextField jTextField) {
                if (jTextField.getText().trim().isEmpty() && jTextField.getText().contains("-")) {
                    JOptionPane.showMessageDialog(c, "Campos vacios, por favor llene todos los campos ");
                    return false;
                }
            }
        }
        return true;
    }

    public static void VaciarCampos(JPanel panel) {
        for (Component c : panel.getComponents()) {
            if (c instanceof JTextField jTextField) {
                jTextField.setText("");
            }
        }
    }

    public static void reset(JLabel cant, JLabel subt) {
        cant.setText("Items : ");
        subt.setText("Sub-Total: $ ");
    }

    public void setImage(JLabel label, String rutaImagen) {
        ImageIcon imagen = new ImageIcon(getClass().getResource(rutaImagen));
        Icon icon_Label = new ImageIcon(imagen.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));

        label.setIcon(icon_Label);
    }

    public static int JOption(String titulo, String mensaje, String[] opciones) {
        // Crea un JOptionPane con las opciones proporcionadas
        int seleccion = JOptionPane.showOptionDialog(
                null, // Componente padre (null para centrar en la pantalla)
                mensaje, // Mensaje a mostrar
                titulo, // Título del diálogo
                JOptionPane.DEFAULT_OPTION, // Tipo de opciones (DEFAULT_OPTION muestra botones OK/CANCEL)
                JOptionPane.PLAIN_MESSAGE, // Tipo de mensaje (PLAIN_MESSAGE muestra solo texto)
                null, // Icono personalizado (null para usar el icono predeterminado)
                opciones, // Array de opciones
                opciones[0] // Opción predeterminada
        );

        // Maneja la selección del usuario
        switch (seleccion) {
            case 0 -> {
                System.out.println("El usuario seleccionó: " + opciones[0]);
                return 0;
            }
            case 1 -> {
                System.out.println("El usuario seleccionó: " + opciones[1]);
                return 1;
            }
            case 2 -> {
                System.out.println("El usuario seleccionó: " + opciones[2]);
                return 2;
            }
            default ->
                System.out.println("El usuario cerró el diálogo sin seleccionar una opción.");
        }
        return 0;
    }

    public static void showMessageDialog(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
