import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowChanger implements ActionListener {
    private JButton rulesButton;
    private JButton startGameButton;
    private int rows; //Todo; Ask lionel if it is correct to add the rows here. or if there is another way to keeep the rows in the start model
    private int columns;

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
            GameWindow gameWindow = new GameWindow(this.rows,this.columns);
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}

// je fais une clas spour le window changer et jinstantie une windowchanger