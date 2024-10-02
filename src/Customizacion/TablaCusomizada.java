package Customizacion;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TablaCusomizada extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (value instanceof JLabel labelCell) {

            // Ajusta el tamaño de la imagen a 20px si es un ImageIcon
            if (labelCell.getIcon() instanceof ImageIcon imageIcon) {
                Image image = imageIcon.getImage();
                Image newImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(newImage);
                labelCell.setIcon(imageIcon);
            }

            labelCell.setOpaque(true);
            labelCell.setForeground(Color.white);
            labelCell.setBackground(Color.WHITE);
            labelCell.setBorder(new EmptyBorder(2, 5, 5, 2));
            labelCell.setPreferredSize(new Dimension(60, 100));
            labelCell.setHorizontalAlignment(CENTER);



            return labelCell;

        } else {
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

}


