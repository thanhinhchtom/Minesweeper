import javax.swing.*;

public class frame {
    public static void main (String[] args){
        JFrame frame = new JFrame ("Mini games");
        frame.add(new canvas());
        frame.setSize(360,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
