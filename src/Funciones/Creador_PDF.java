package Funciones;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Creador_PDF {

    public static String createPDFWithTable(JTable table, String NombreArchivo, String nombre_R, String correo_R, int nie_R) {
        // Crear el PDF con los datos del JTable
        try {

            JFileChooser fileChooser
                    = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));
            fileChooser.setSelectedFile(new File(NombreArchivo + ".pdf"));

            int seleccionUsuario = fileChooser.showSaveDialog(null);

            if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {

                String newfilePath = fileChooser.getSelectedFile().getAbsolutePath();
                Document document = new Document();

                PdfWriter.getInstance(document, new FileOutputStream(newfilePath));
                document.open();
                // Encabezado
                Font fontHeader = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD);
                PdfPTable headerTable = new PdfPTable(1);
                headerTable.setWidthPercentage(100);
                // Logo de la empresa

                PdfPCell logoCell = new PdfPCell();
                try {
                    Image logo = Image.getInstance("C:\\Users\\kVo\\Desktop\\Año ll Cic ll\\visual\\Año ll Ciclo ll\\JaVa\\Colegio_JNSP\\src\\Imagenes\\cjnsp.jpg"); // Asegúrate de que la ruta al archivo de imagen es correcta
                    logo.scaleToFit(100, 100); // Ajusta el tamaño del logo
                    logoCell.addElement(logo);
                    logoCell.setBorder(PdfPCell.NO_BORDER);
                    headerTable.addCell(logoCell);
                } catch (BadElementException | IOException e) {
                    System.out.println("error>  " + e.getMessage());
                }

                PdfPCell companyInfoCell = new PdfPCell(new Phrase("Colegio Josefino Nuestra Señora de la Paz", fontHeader));
                companyInfoCell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                companyInfoCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(companyInfoCell);

                PdfPCell addressCell = new PdfPCell(new Phrase("Calle las Flores, Ciudad Jardin, San Miguel", FontFactory.getFont(FontFactory.HELVETICA, 12)));
                addressCell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                addressCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(addressCell);

                PdfPCell phoneCell = new PdfPCell(new Phrase("Teléfono: 6037-6783", FontFactory.getFont(FontFactory.HELVETICA, 12)));
                phoneCell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                phoneCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(phoneCell);

                // Espacio en blanco
                PdfPCell emptyCell = new PdfPCell(new Phrase(" "));
                emptyCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(emptyCell);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                String formattedDate = dateFormat.format(new Date());
                PdfPCell dateTimeCell = new PdfPCell(new Phrase("Factura emitida: " + formattedDate, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                dateTimeCell.setBorder(PdfPCell.NO_BORDER);
                dateTimeCell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                headerTable.addCell(dateTimeCell);

                // Espacio en blanco
                PdfPCell emptyCel = new PdfPCell(new Phrase(" "));
                emptyCel.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(emptyCel);
////////////////////
                PdfPCell NombreCliente = new PdfPCell(new Phrase("Nombre: " + nombre_R, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                NombreCliente.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(NombreCliente);

                // Dirección fiscal del emisor
                PdfPCell fiscalAddressCell = new PdfPCell(new Phrase("Dirección de correo: " + correo_R, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                fiscalAddressCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(fiscalAddressCell);

                // Número de Identificación Fiscal (NIF) del emisor
                PdfPCell nifCell = new PdfPCell(new Phrase("Numero de identificacion: " + nie_R, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                nifCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(nifCell);

                // Espacio en blanco
                PdfPCell emptyCelll = new PdfPCell(new Phrase(" "));
                emptyCelll.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(emptyCelll);

                /////////
                // Crear una tabla PDF con el mismo número de columnas que el JTable
                PdfPTable pdfTable = new PdfPTable(table.getColumnCount() - 1);

// Añadir los encabezados de columna (excepto la última columna)
                for (int i = 0; i < table.getColumnCount() - 1; i++) {
                    pdfTable.addCell(table.getColumnName(i));
                }

// Añadir las filas de datos (excepto la última columna)
                for (int row = 0; row < table.getRowCount(); row++) {
                    for (int col = 0; col < table.getColumnCount() - 1; col++) {
                        pdfTable.addCell(table.getValueAt(row, col).toString());
                    }
                }

                document.add(headerTable);
                document.add(pdfTable);
                document.close();
                return newfilePath;
            }
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String createPDFsinTabla(String NombreArchivo, String nombre_R, String correo_R, int nie_R, String Detalle) {
        // Crear el PDF con los datos del JTable
        try {

            JFileChooser fileChooser
                    = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));
            fileChooser.setSelectedFile(new File(NombreArchivo + ".pdf"));
            
            int seleccionUsuario = fileChooser.showSaveDialog(
                    null
            );

            if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
                String newfilePath = fileChooser.getSelectedFile().getAbsolutePath();
                Document document = new Document();

                PdfWriter.getInstance(document, new FileOutputStream(newfilePath));
                document.open();
                // Encabezado
                Font fontHeader = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD);
                PdfPTable headerTable = new PdfPTable(1);
                headerTable.setWidthPercentage(100);
                // Logo de la empresa

                PdfPCell logoCell = new PdfPCell();
                try {
                    Image logo = Image.getInstance("C:\\Users\\kVo\\Desktop\\Año ll Cic ll\\visual\\Año ll Ciclo ll\\JaVa\\Colegio_JNSP\\src\\Imagenes\\cjnsp.jpg"); // Asegúrate de que la ruta al archivo de imagen es correcta
                    logo.scaleToFit(100, 100); // Ajusta el tamaño del logo
                    logoCell.addElement(logo);
                    logoCell.setBorder(PdfPCell.NO_BORDER);
                    headerTable.addCell(logoCell);
                } catch (BadElementException | IOException e) {
                    System.out.println("error>  " + e.getMessage());
                }

                PdfPCell companyInfoCell = new PdfPCell(new Phrase("Colegio Josefino Nuestra Señora de la Paz", fontHeader));
                companyInfoCell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                companyInfoCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(companyInfoCell);

                PdfPCell addressCell = new PdfPCell(new Phrase("Calle las Flores, Ciudad Jardin, San Miguel", FontFactory.getFont(FontFactory.HELVETICA, 12)));
                addressCell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                addressCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(addressCell);

                PdfPCell phoneCell = new PdfPCell(new Phrase("Teléfono: 6037-6783", FontFactory.getFont(FontFactory.HELVETICA, 12)));
                phoneCell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                phoneCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(phoneCell);

                // Espacio en blanco
                PdfPCell emptyCell = new PdfPCell(new Phrase(" "));
                emptyCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(emptyCell);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                String formattedDate = dateFormat.format(new Date());
                PdfPCell dateTimeCell = new PdfPCell(new Phrase("Factura emitida: " + formattedDate, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                dateTimeCell.setBorder(PdfPCell.NO_BORDER);
                dateTimeCell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                headerTable.addCell(dateTimeCell);

                // Espacio en blanco
                PdfPCell emptyCel = new PdfPCell(new Phrase(" "));
                emptyCel.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(emptyCel);
////////////////////
                PdfPCell NombreCliente = new PdfPCell(new Phrase("Nombre: " + nombre_R, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                NombreCliente.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(NombreCliente);

                // Dirección fiscal del emisor
                PdfPCell fiscalAddressCell = new PdfPCell(new Phrase("Dirección de correo: " + correo_R, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                fiscalAddressCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(fiscalAddressCell);

                // Número de Identificación Fiscal (NIF) del emisor
                PdfPCell nifCell = new PdfPCell(new Phrase("Numero de identificacion: " + nie_R, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                nifCell.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(nifCell);

                // Espacio en blanco
                PdfPCell emptyCelll = new PdfPCell(new Phrase(" "));
                emptyCelll.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(emptyCelll);

                /////////
                PdfPCell Concepto = new PdfPCell(new Phrase(Detalle, FontFactory.getFont(FontFactory.HELVETICA, 12)));
                Concepto.setBorder(PdfPCell.NO_BORDER);
                headerTable.addCell(Concepto);

                document.add(headerTable);
                document.close();
                System.out.println("PDF creado con éxito: " + newfilePath);
                return newfilePath;
            }
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static PdfPCell createCell(String content, String fontFamily, float fontSize, int fontStyle) {
        Font font = FontFactory.getFont(fontFamily, fontSize, fontStyle);
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        return cell;
    }
}
