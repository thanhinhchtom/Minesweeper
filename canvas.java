import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class canvas extends JFrame{

    canvas() {
        //create replay button
        int k = ((Frame.w) * 30 + 200) / 2 - 50;
        JButton button = new JButton("Replay");
        button.setBounds(k,20, 100,30);
        button.setVisible(true);
        this.add(button);
        button.addActionListener(e -> {
            if (e.getSource()== button){
                for (int k1 = 0; k1 < Frame.w + 2; k1++){
                    for (int r = 0; r < Frame.h + 2; r++){
                        Frame.array[k1][r] = 0;
                    }
                }
                Frame.bombcount2();
                for (int k1 = 0; k1 < Frame.w; k1++){
                    for (int r = 0; r < Frame.h; r++){
                        Frame.numbomb[k1][r] = 0;
                    }
                }

                this.add(button);
                canvas.super.paint(getGraphics());
                repaint();
            }
        });

        //catch mouse click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int mousex = (e.getX() - 100) / 30;
                int mousey = (e.getY() - 100) / 30;

                //show number of that square when left click
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (Frame.numbomb[mousex][mousey] == 0) {
                        Frame.draw(mousex, mousey);
                    }
                    repaint();
                }

                //flag when right click
                if (e.getButton() == MouseEvent.BUTTON3) {
                    //if it was not flagged, change the square to flag
                    if (Frame.numbomb[mousex][mousey] == 0) {
                        Frame.numbomb[mousex][mousey] = 2;
                    }
                    //if it was flagged already, change it to the normal square
                    else if (Frame.numbomb[mousex][mousey] == 2) {
                        canvas.super.paint(getGraphics());
                        Frame.numbomb[mousex][mousey] = 0;
                    }
                    repaint();
                }
            }
        });
    }

    // draw square and value of each square after click
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        Font font = new Font("abc",Font.BOLD, 20);
        g2d.setFont(font);
        int n, k;
        for (int i = 0; i < Frame.w; i++) {
            n = i * 30 + 100;
            for (int l = 0; l < Frame.h; l++) {
                k = l * 30 + 100;

                //if 1 reveal that square
                if (Frame.numbomb[i][l] == 1) {
                    if (Frame.array[i + 1][l + 1] == 0) {
                        g2d.fillRect(n, k, 30, 30);
                    }
                    String value = String.valueOf(Frame.array[i + 1][l + 1]);
                    if (!value.equals("-1")) {
                        g2d.drawString(value, n + 10, k + 25);
                    }
                    // if click on the bomb, open the full table
                    if (Frame.array[i + 1][l + 1] == -1) {
                        g2d.setColor(Color.RED);
                        g2d.drawString("x", n + 10, k + 20);
                        g2d.drawArc(n, k, 30, 30, 0, 360);
                        g2d.setColor(Color.BLACK);
                        for (int e = 0; e < Frame.w; e++) {
                            for (int r = 0; r < Frame.h; r++) {
                                Frame.numbomb[e][r] = 1;
                            }
                        }
                        repaint();
                    }
                }

                //if 2 draw green square as flag
                else if (Frame.numbomb[i][l] == 2) {
                        g2d.setColor(Color.GREEN);
                        g2d.fillRect(n + 5, k + 5, 20, 20);
                        g2d.setColor(Color.BLACK);
                }

                //if not 1 or 2, draw the square border only
                else g2d.drawRect(n, k, 30, 30);
            }
        }
    }
}
