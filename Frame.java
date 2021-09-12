import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Frame {

    public static int[][] numbomb = new int[15][15];
    public static int[][] array = new int[17][17];

    public static void main(String[] args) {
        canvas frame = new canvas();

        //frame set up
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(700, 700);
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
        int TOTAL_MINE = 30;
        Random rand = new Random();
        int i=0;
        while (i < TOTAL_MINE) {
            int x = rand.nextInt(14);
            int y = rand.nextInt(14);
            if (array[x+1][y+1] != -1) {
                array[x+1][y+1] = -1;
                i++;
            }
        }

        //count number of bomb
        for (int row = 1; row <16; row++){
            for (int col = 1; col <16; col ++){
                if ( array [row][col] == -1 ){   //if there is a bomb(-1), all the surrounding square value will plus 1
                    if ( array[row - 1][col - 1] != -1){
                        array[row - 1][col - 1] += 1;
                    }if ( array[row - 1][col] != -1){
                        array[row - 1][col] += 1;
                    }if ( array[row - 1][col + 1] != -1){
                        array[row - 1][col + 1] += 1;
                    }if ( array[row][col - 1] != -1){
                        array[row][col - 1] += 1;
                    }if ( array[row][col + 1] != -1){
                        array[row][col + 1] += 1;
                    }if ( array[row + 1][col - 1] != -1){
                        array[row + 1][col - 1] += 1;
                    }if ( array[row + 1][col] != -1){
                        array[row + 1][col] += 1;
                    }if ( array[row + 1][col + 1] != -1){
                        array[row + 1][col + 1] += 1;
                    }
                }
            }
        }
    }
}






