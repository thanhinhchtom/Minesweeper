
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class canvas extends JFrame{

    // when mouse click print the number of that square
    public canvas() {
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
                    if (Frame.numbomb[mousex][mousey] == 0) {
                        Frame.numbomb[mousex][mousey] = 2;
                    } else if (Frame.numbomb[mousex][mousey] == 2) {
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
        for (int i = 0; i < 15; i++) {
            n = i * 30+100;
            for (int l = 0; l < 15; l++) {
                k = l * 30+100;
                if (Frame.numbomb[i][l]==1){
                    if (Frame.array[i+1][l+1]==1) {
                        g2d.drawString("1", n + 10, k + 25);
                    }if (Frame.array[i+1][l+1]==2) {
                        g2d.drawString("2", n + 10, k + 25);
                    }if (Frame.array[i+1][l+1]==3) {
                        g2d.drawString("3", n + 10, k + 25);
                    }if (Frame.array[i+1][l+1]==4) {
                        g2d.drawString("4", n + 10, k + 25);
                    }if (Frame.array[i + 1][l + 1]==5) {
                        g2d.drawString("5", n + 10, k + 25);
                    }if (Frame.array[i+1][l+1]==6) {
                        g2d.drawString("6", n + 10, k + 25);
                    }if (Frame.array[i+1][l+1]==7) {
                        g2d.drawString("7", n + 10, k + 25);
                    }if (Frame.array[i+1][l+1]==8) {
                        g2d.drawString("8", n + 10, k + 25);
                    }if (Frame.array[i+1][l+1]==0) {
                        g2d.fillRect(n,k,30,30);
                    }

                    if (Frame.array[i+1][l+1]==-1) {
                        g2d.setColor(Color.RED);
                        g2d.drawString("x",n+10, k+20);
                        g2d.drawArc(n,k, 30, 30,0, 360);
                        g2d.setColor(Color.BLACK);
                        for (int e =0; e < 15; e++){
                            for (int r = 0; r < 15; r++){
                                Frame.numbomb[e][r] = 1;
                                repaint();
                            }
                        }
                    }
                }
                else if (Frame.numbomb[i][l] == 2){
                    g2d.setColor( Color.GREEN);
                    g2d.fillRect(n+5, k+5, 20,20);
                    g2d.setColor( Color.BLACK);
//                    g2d.drawImage(flag1, n, k, 30, 30, this);
                }
                else g2d.drawRect(n, k, 30, 30);

            }
        }
    }
}


