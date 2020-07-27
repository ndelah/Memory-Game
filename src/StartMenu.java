import javax.swing.*;
import java.awt.*;

public class StartMenu extends JFrame {

    // Parameters
    private String gameWindowTitle = "Memory GameWindow";
    private Color panelColor = Color.WHITE;
    private int panelWidth = 500;
    private int panelHeight = 50;
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
        this.setTitle(gameWindowTitle);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));

        // Rules
        this.createPanel(rulesPanel, panelColor,panelDimension);

        // Difficulty
        this.createPanel(difficultyPanel, panelColor,panelDimension);

        // Time
        this.createPanel(timePanel, panelColor,panelDimension);

        // Opponent
        this.createPanel(opponentPanel, panelColor,panelDimension);

        // GridSize: Rows and columns of the game
        this.createPanel(gridSizePanel, panelColor,panelDimension);

        // Settings on the last row: Theme high score, start and exit
        this.createPanel(extraSettingsPanel, panelColor,panelDimension);


        WindowChanger windowChanger = new WindowChanger(rulesPanel.getRulesButton(),extraSettingsPanel.getStartButton());
        windowChanger.setRows(3);
        windowChanger.setColumns(3);
        rulesPanel.getRulesButton().addActionListener(windowChanger);
        extraSettingsPanel.getStartButton().addActionListener(windowChanger);

        this.pack();
        this.setVisible(true);

    }
    public void createPanel(JPanel panel, Color panelColor, Dimension panelDimension){
        panel.setBackground(panelColor);
        panel.setPreferredSize(panelDimension);
        panel.setLayout(new FlowLayout());
        this.getContentPane().add(panel);
    }
}
