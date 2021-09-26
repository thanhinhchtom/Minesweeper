public class Blank{
    public static int e = 0;
    public static int r = 0;
    public static void blank( int x, int y ){
        Frame.numbomb[x][y] = 1;
        for (int q = x - 1; q < x + 2; q++){
            for (int w = y - 1 ; w < y + 2; w++){
                if (q > -1 && w > -1 && q < Frame.w && w < Frame.h) {
                    //if there is a bomb, not open
                    if (Frame.array[q + 1][w + 1] == -1){
                        Frame.numbomb[q][w] = 0;
                    }
                    //if not blank, reveal
                    else if (Frame.array[q + 1][w + 1] != 0) {
                        Frame.numbomb[q][w] = 1;
                    }
                    //if blank, call the blank method again
                    else if (Frame.array[q + 1][w + 1] == 0 ) {
                        e = q;
                        r = w;
                        if (Frame.numbomb[q][w] == 0){
                            blank(e,r);
                        }

                    }
                }
            }
        }
    }
}