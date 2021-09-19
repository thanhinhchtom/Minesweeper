import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Frame {
    public static int w = 20;
    public static int h = 15;
    public static int boardwidth = w * 30 +200;
    public static int boardheight = h * 30 +200;
    public static int bombs = 30;
    public static int[][] numbomb = new int[w][h];
    public static int[][] array = new int[w + 2][h + 2];


    public static void main(String[] args) {
        canvas frame = new canvas();

        //frame set up
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(boardwidth, boardheight);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) dimension.getWidth() / 2 - frame.getWidth() / 2;
        int y = (int) dimension.getHeight() / 2 - frame.getHeight() / 2;
        frame.setLocation(x, y);
        frame.setVisible(true);

        Frame.bombcount2();
    }

    // if 1, show number,
    //    0, do nothing
    public static void draw(int x, int y){
        if (Frame.array[x + 1][y + 1] == 0){
            numbomb[x][y] = 1;
            Blank.blank(x,y);
        }
        else numbomb[x][y] = 1;
    }

    //count the number of bomb around for each square
    public static void bombcount2(){

        //random the place of all bombs
        Random rand = new Random();
        int i=0;
        while (i < bombs) {
            int x = rand.nextInt(w-1);
            int y = rand.nextInt(h-1);
            if (array[x+1][y+1] != -1) {
                array[x+1][y+1] = -1;
                i++;
            }
        }

        //count number of bomb
        for (int row = 1; row < w + 1; row++){
            for (int col = 1; col < h + 1; col++){
                if ( array [row][col] == -1 ){   //if there is a bomb(-1), all the surrounding square value will plus 1
                    for (int y = -1 ; y < 2 ; y++){
                        for (int u = -1; u < 2 ; u++){
                            if(array[row + y][col+u]!=-1){
                                array[row + y][col+u] ++;
                            }
                        }
                    }
                }
            }
        }
    }
}






