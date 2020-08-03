import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLauncher implements ActionListener {
    private int rows;
    private int columns;
    private String player;
    private JButton startButton;

    public GameLauncher(JButton startButton, int rows, int columns){
        this.startButton = startButton ;
        this.rows = rows;
        this.columns = columns;
    }


    public void actionPerformed(ActionEvent event){
        JFrame welcomeFrame = (JFrame) SwingUtilities.windowForComponent(startButton);
        if (event.getSource() == this.startButton)
        {
            new GameWindow(this.rows,this.columns, this.player);
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
