import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        this.setMinimumSize(new Dimension(500,500));
        this.setPreferredSize(new Dimension(500,500));
        this.setMaximumSize(new Dimension(800,800)); //TODO setmaximumsize doesnt seem to have an efect
        //this.setSize(new Dimension(500,500));



        // Rules
        this.createPanel(rulesPanel, panelColor,panelDimension);

        //TODO: Create a class that extends ActionListner. It takes as input the type of window to open.
        rulesPanel.getRulesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RulesWindow();
            }
        });

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


        //TODO: Ask Lionel if it is possible to refactor this ActionListener in a separate class while still getting access to the rows and columns
        // The issue is that if the rows and columns are passed outside the action listener it wont get the value
        extraSettingsPanel.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gets the players settings for the start of the game
                int rows = (int) gridSizePanel.getRowsSpinner().getValue(); // rows of the game
                int columns = (int) gridSizePanel.getColumnspinner().getValue(); // columns of the game

                String player = opponentPanel.getOpponentGroup().getSelection().getActionCommand(); // String: player_2 or computer

                String theme = extraSettingsPanel.getThemesCombobox().getSelectedItem().toString();


               //TODO: Adapt the constructor to accomodate the new fields for the start of the game
                new GameWindow(rows,columns,player, new Player("Nicolas",0), new Player("Jonathan",0),theme);
            }
        });

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
