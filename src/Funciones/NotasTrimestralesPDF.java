package Funciones;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotasTrimestralesPDF {

    public void printJFrameToPdf(JPanel frame, String outputPdfPath) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));
            fileChooser.setSelectedFile(new File(outputPdfPath + ".pdf"));

            int seleccionUsuario = fileChooser.showSaveDialog(null);
            int panelWidth = frame.getWidth();
            int panelHeight = frame.getHeight();

            if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
                String newFilePath = fileChooser.getSelectedFile().getAbsolutePath();

                Document document = new Document(new com.itextpdf.text.Rectangle(panelWidth, panelHeight));
                PdfWriter.getInstance(document, new FileOutputStream(newFilePath));
                document.open();

                // Crear una imagen a partir del JPanel
                BufferedImage bufferedImage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = bufferedImage.createGraphics();
                frame.paint(g2d);
                Image image = Image.getInstance(bufferedImage, null);
                image.scaleAbsolute(document.getPageSize().getWidth(), document.getPageSize().getHeight());
                document.add(image);
                
                document.close();
                System.out.println("PDF creado con éxito: " + newFilePath);
            }
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
