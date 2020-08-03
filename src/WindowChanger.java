import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowChanger implements ActionListener {
    private JButton rulesButton;
    private JButton startGameButton;
    private int rows; //Todo; Ask lionel if it is correct to add the rows here. or if there is another way to keeep the rows in the start model
    private int columns;
    private String player;

    public WindowChanger(JButton rulesButton,JButton startGameButton){
        this.rulesButton = rulesButton;
        this.startGameButton = startGameButton;
    }

    public void actionPerformed(ActionEvent event){
        JFrame welcomeFrame = (JFrame) SwingUtilities.windowForComponent(rulesButton);
        if (event.getSource() == this.rulesButton)
        {
            new RulesWindow();
        }
        else if (event.getSource() == this.startGameButton)
        {
            new GameWindow(this.rows,this.columns,this.player);
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
