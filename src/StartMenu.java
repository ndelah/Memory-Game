import javax.swing.*;
import java.awt.*;

public class StartMenu extends JFrame {

    // Parameters
    private Color panelColor = Color.WHITE;
    private int panelWidth = 300;
    private int panelHeight = 200;
    private Dimension panelDimension = new Dimension(panelWidth,panelHeight);

    private Rules rulesPanel = new Rules();
    private Difficulty difficultyPanel = new Difficulty();
    private Time timePanel = new Time();
    private Opponent opponentPanel = new Opponent();
    private GridSize gridSizePanel = new GridSize();
    private ExtraSettings extraSettingsPanel = new ExtraSettings();


    public StartMenu() {
        // Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Color app");
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));

        // Rules
        this.createPanel(rulesPanel, panelColor,panelDimension);
        this.getContentPane().add(rulesPanel);

        // Difficulty
        this.createPanel(difficultyPanel, panelColor,panelDimension);
        this.getContentPane().add(difficultyPanel);

        // Time
        this.createPanel(timePanel, panelColor,panelDimension);
        this.getContentPane().add(timePanel);

        // Opponent
        this.createPanel(opponentPanel, panelColor,panelDimension);
        this.getContentPane().add(opponentPanel);

        // GridSize: Rows and columns of the game
        this.createPanel(gridSizePanel, panelColor,panelDimension);
        this.getContentPane().add(gridSizePanel);

        // Settings on the last row: Theme high score, start and exit
        this.createPanel(extraSettingsPanel, panelColor,panelDimension);


        //eventhandling of the exit button
        JButton exitButton = extraSettingsPanel.getExitButton();
        ExitHandler exithandler = new ExitHandler(exitButton);
        exitButton.addActionListener(exithandler);
        this.getContentPane().add(extraSettingsPanel);








        this.pack();
        this.setVisible(true);

    }
    public void createPanel(JPanel panel, Color panelColor, Dimension panelDimension){
        panel.setBackground(panelColor);
        panel.setPreferredSize(panelDimension);
        panel.setLayout(new FlowLayout());
    }
}
