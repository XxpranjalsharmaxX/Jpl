import javax.swing.*;
import java.awt.*;

class MyCanvas extends JComponent {
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fill3DRect(20, 20, 200, 200,true);
        g.drawRoundRect(180,180,120,120,120,120);

    }
}

public class Jpl142 {
    public static void main(String[] a) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 450, 450);
        window.getContentPane().add(new MyCanvas());
        window.setVisible(true);
    }
}