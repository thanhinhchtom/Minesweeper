import javax.swing.*;
import java.awt.*;
public class canvas extends JPanel {
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        int n,k;
        for (int i = 0; i<12;i++) {
            n =i*30;
            for (int l = 0; l<10;l++) {
                k= l*30;
                g2d.drawRect(n, k,30,30);
            }
        }
    }
}
