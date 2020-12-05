package ShelterSystem.UserInterface;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private ImageIcon icon;
    private Image img;

    public ImagePanel() {
        icon = new ImageIcon(AdministratorFrame.class.getResource("/background.jpg"));
        img = icon.getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }
}