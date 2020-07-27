import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RulesHandler implements ActionListener {
    private JButton button;

    public RulesHandler( JButton button){
        this.button = button;
    }

    public void actionPerformed(ActionEvent event){
        JFrame welcomeFrame = (JFrame) SwingUtilities.windowForComponent(button);
        if (event.getSource() == this.button)
        {
            RulesWindow rulesWindow = new RulesWindow();
        }
    }

}
