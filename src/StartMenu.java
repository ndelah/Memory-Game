import javax.swing.*;
import java.awt.*;

public class StartMenu extends JFrame {
    // Rules
    private JPanel panel_rules = new JPanel();
    private JButton rulesButton = new JButton("Rules");;


    // Players
    private JPanel opponentPanel = new JPanel();
    private JLabel opponentLabel = new JLabel("Opponent");
    private JRadioButton player2Button = new JRadioButton("Player 2");
    private JRadioButton compouterButton = new JRadioButton("Computer");
    private ButtonGroup opponentGroup = new ButtonGroup();
    // Gridsize
    private JPanel gridSizePanel = new JPanel();
    private JLabel rowsLabel = new JLabel("Rows");
    private JSpinner rowsSpinner = new JSpinner();
    private JLabel colummsLabel = new JLabel("Colums");
    private JSpinner columnspinner = new JSpinner();
    // Settings on bottom row
    private JPanel lastSettingsPanel = new JPanel();
    private JButton themeButton = new JButton("Theme");
    private JButton highscoreButton = new JButton("Highscore");
    private JButton startButton = new JButton("Start");
    private JButton exitButton = new JButton("Exit");
    // Parameters
    private Color panelColor = Color.WHITE;
    private int panelWidth = 300;
    private int panelHeight = 200;
    private Dimension panelDimension = new Dimension(panelWidth,panelHeight);

    private Difficulty difficulty = new Difficulty();
    private Time timePanel = new Time();

    public StartMenu() {
        // Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Color app");
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));

        // Rules
        this.createPanel(panel_rules, panelColor,panelDimension);
        panel_rules.add(rulesButton);
        this.getContentPane().add(panel_rules);

        // Difficulty
        this.createPanel(difficulty, panelColor,panelDimension);
        this.getContentPane().add(difficulty);

        // Time
        this.createPanel(timePanel, panelColor,panelDimension);
        this.getContentPane().add(timePanel);


        // Opponent
        this.createPanel(opponentPanel, panelColor,panelDimension);
        opponentPanel.add(opponentLabel);
        opponentPanel.add(player2Button);
        opponentPanel.add(compouterButton);
        opponentGroup.add(player2Button);
        opponentGroup.add(compouterButton);
        this.getContentPane().add(opponentPanel);

        // GridSize: Rows and columns of the game
        this.createPanel(gridSizePanel, panelColor,panelDimension);
        gridSizePanel.add(rowsLabel);
        gridSizePanel.add(rowsSpinner);
        gridSizePanel.add(colummsLabel);
        gridSizePanel.add(columnspinner);
        this.getContentPane().add(gridSizePanel);

        // Settings on the last row: Theme high score, start and exit
        this.createPanel(lastSettingsPanel, panelColor,panelDimension);
        lastSettingsPanel.add(themeButton);
        lastSettingsPanel.add(themeButton);
        lastSettingsPanel.add(startButton);
        lastSettingsPanel.add(exitButton);

        //eventhandling of the exit button
        ExitHandler exithandler = new ExitHandler(exitButton);
        exitButton.addActionListener(exithandler);
        this.getContentPane().add(lastSettingsPanel);








        this.pack();
        this.setVisible(true);

    }
    public void createPanel(JPanel panel, Color panelColor, Dimension panelDimension){
        panel.setBackground(panelColor);
        panel.setPreferredSize(panelDimension);
        panel.setLayout(new FlowLayout());
    }
}
