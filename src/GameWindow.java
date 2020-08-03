import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameWindow extends JFrame {

    // JButton Fields
    private JPanel gamePanel = new JPanel();
    private JPanel upperPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel lowerPanel = new JPanel();
    private JButton exitButton = new JButton();

    private JLabel playerOneLabel = new JLabel("Player 1");
    private JLabel playerTwoLabel = new JLabel("Player 2");

    private String player; // Whether we play against AI or human
    private Player playerOne;
    private Player playerTwo;
    private int rows;
    private int columns;
    private int gridSize; // TODO: make


    private ArrayList<ImageIcon> images;
    private Image testImage;



    // Parameters
    //TODO: Create some sort of template so that I dont always have to repeat those parameters.
    private Color panelColor = Color.WHITE;
    private int panelWidth = 300;
    private int panelHeight = 200;
    private Dimension panelDimension = new Dimension(panelWidth,panelHeight);
    private String theme;

    private JLabel timeLeft = new JLabel("10;00");

    public GameWindow(int rows, int columns, String player, Player playerOne, Player playerTwo, String theme){
        this.rows = rows;
        this.columns = columns;
        this.player = player;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playerOneLabel.setText(playerOne.getName());
        this.playerTwoLabel.setText(playerTwo.getName());
        this.theme = theme;


        this.setGridSize();


        // Create the Frame containing the Game
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Rules of the GameWindow");
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));

        // Game Panel
        BorderLayout borderLayout = new BorderLayout();
        this.createPanel(gamePanel, panelColor, panelDimension, borderLayout);



        //TODO: Opening the game should close the welcome menu
        //TODO: Readjust the format of the closing button

        // Upper Panel
        gamePanel.add(upperPanel, BorderLayout.NORTH);
        //leftPanel.setLayout();
        upperPanel.add(timeLeft);

        // Left Panel
        gamePanel.add(leftPanel, BorderLayout.WEST);
        //leftPanel.setLayout();
        leftPanel.add(playerOneLabel);

        // Right Panel
        gamePanel.add(rightPanel, BorderLayout.EAST);
        rightPanel.add(playerTwoLabel);

        // Center Panel
        centerPanel.setLayout(new GridLayout(this.getRows(),this.getColumns()));
        String themesPath = "C:\\Users\\delah\\Documents\\Programming\\workspace\\basic_programming_memory_game\\themes\\";

        // Create a list of images
        images = new ArrayList<ImageIcon>();
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < gridSize / 2; i++) {
                images.add(new ImageIcon(themesPath + theme + "\\" + i + ".jpg"));
            }
        }
        // Shuffle images
        Collections.shuffle(images);

        // Add Cards to board
        for (int i = 0; i < gridSize  ; i++) {
            centerPanel.add(new Card(images.get(i)));
        }

        gamePanel.add(centerPanel, BorderLayout.CENTER);


        // South Panel
            //FlowLayout flowLayout = new FlowLayout();
            //this.createPanel(exitPanel, panelColor, panelDimension, flowLayout);
            //exitPanel.add(exitButton);
        ExitHandler exithandler = new ExitHandler(exitButton);
        exitButton.addActionListener(exithandler);
        gamePanel.add(lowerPanel, BorderLayout.SOUTH);

        lowerPanel.add(exitButton);

        this.pack();
        this.setVisible(true);
    }

    public void createPanel(JPanel panel, Color panelColor, Dimension panelDimension, LayoutManager layout){
        panel.setBackground(panelColor);
        panel.setPreferredSize(panelDimension);
        panel.setLayout(layout);
        this.getContentPane().add(panel);
    }

    public void setGridSize() {
        this.gridSize = this.getColumns() * this.getRows();
    }

    public JPanel getGridPanel() {
        return centerPanel;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }



    public void setPlayerTwoLabel(JLabel playerTwoLabel) {
        this.playerTwoLabel = playerTwoLabel;
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public JPanel getExitPanel() {
        return lowerPanel;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public Color getPanelColor() {
        return panelColor;
    }

    public int getPanelWidth() {
        return panelWidth;
    }

    public int getPanelHeight() {
        return panelHeight;
    }

    public Dimension getPanelDimension() {
        return panelDimension;
    }
}
