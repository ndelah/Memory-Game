import javax.swing.*;
import java.awt.*;

public class TestClass {

    JButton button = new JButton("Click me!");
    MySimpleButtonListener listener = new MySimpleButtonListener();
    button.addActionListener(klistener);





    private static JPanel makePanel(Color color){
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(100,100));
        return panel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Color app");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(makePanel(Color.red));
        frame.getContentPane().add(makePanel(Color.orange));
        frame.getContentPane().add(makePanel(Color.GREEN));
        frame.getContentPane().add(makePanel(Color.BLUE));
        frame.getContentPane().add(makePanel(Color.PINK));
        frame.getContentPane().add(makePanel(Color.CYAN));


        frame.pack();
        frame.setVisible(true);







    }

}
