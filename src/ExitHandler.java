import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitHandler implements ActionListener {
    private JButton button;

    public ExitHandler(JButton button){
        this.button = button;
    }

    public void actionPerformed (ActionEvent event){
        JFrame f1 = (JFrame) SwingUtilities.windowForComponent(button);
        if (event.getSource() == this.button){
            f1.dispose();

        }
    }


}
