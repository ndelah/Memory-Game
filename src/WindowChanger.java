import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowChanger implements ActionListener {
    private JButton rulesButton;
    private JButton startGameButton;

    public WindowChanger(JButton rulesButton,JButton startGameButton){
        this.rulesButton = rulesButton;
        this.startGameButton = startGameButton;
    }

    public void actionPerformed(ActionEvent event){
        JFrame welcomeFrame = (JFrame) SwingUtilities.windowForComponent(rulesButton);
        if (event.getSource() == this.rulesButton)
        {
            RulesWindow rulesWindow = new RulesWindow();
        }
        else if (event.getSource() == this.startGameButton)
        {
            GameWindow gameWindow = new GameWindow();
        }
    }

}

// je fais une clas spour le window changer et jinstantie une windowchanger