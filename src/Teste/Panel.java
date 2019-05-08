package Teste;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Panel {

    public static void main(String[] args) {
        
        Image image = null;
        try {
            URL url = new URL("https://img.olx.com.br/images/15/154811099907584.jpg");
            image = ImageIO.read(url.openStream());
            System.out.println(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
    }
}
