import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWindow extends JFrame {

    // Frame Parameters
    //TODO: Create some sort of template so that I dont always have to repeat those parameters.
    private Color panelColor = Color.WHITE;
    private int panelWidth = 500;
    private int panelHeight = 500;
    private Dimension panelDimension = new Dimension(panelWidth,panelHeight);
    FrameSettings frameSettings = new FrameSettings();

    // Panels
    private JPanel gamePanel = new JPanel();
    private JPanel upperPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel lowerPanel = new JPanel();

    // Upper Panel Fields
    private JLabel timeLeft = new JLabel();
    private JLabel playerTurn = new JLabel("Player 1's turn");

    // TODO: Justify why static and make private
    // TODO: getters and settsers
    static int interval;
    static Timer timer;
    int gameTime;
    int delay = 0;
    int period = 1000;

    // Left Panel Fields
    private JLabel playerOneLabel = new JLabel("Player 1",SwingConstants.CENTER);
    private Player playerOne;
    private JLabel scorePlayerOne = new JLabel("0",0);

    // Right Panel Fields
    private Boolean playerIsMachine; // Whether we play against AI or human
    private JLabel playerTwoLabel = new JLabel("Player 2");
    private Player playerTwo;
    private JLabel scorePlayerTwo = new JLabel("0");

    // Center Panel Fields
    private ArrayList<ImageIcon> images;
    private int rows;
    private int columns;
    private int gridSize;
    private String theme;

    private int nbCardsFound = 0;

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);


    // Lower Panel Fields
    private JButton exitButton = new JButton();

    // Unsorted Fields
    ArrayList<Card> flippedTiles = new ArrayList<Card>();
    int pointsPerPair = 500;

    // New Highscore window writes the data to a file.
    HighScoreWindow highScoreWindow = new HighScoreWindow();

    public GameWindow(int rows, int columns, Boolean playerIsMachine, Player playerOne, Player playerTwo, String theme, int gameTime){
        // Setting constructor fields
        this.rows = rows;
        this.columns = columns;
        this.playerIsMachine = playerIsMachine;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playerOneLabel.setText(playerOne.getName());
        this.playerTwoLabel.setText(playerTwo.getName());
        this.theme = theme;
        this.setGridSize();
        this.gameTime = gameTime;

        this.setMinimumSize(frameSettings.getMinimumSize());
        this.setPreferredSize(frameSettings.getPreferredSize());
        this.setMaximumSize(frameSettings.getMaximumSize());

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
        // Game CountDown
        timer = new Timer();
        interval = gameTime;
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println(setInterval());
                timeLeft.setText(Integer.toString(setInterval()));
                gameOver();

            }
        }, delay, period);
        upperPanel.add(timeLeft);
        upperPanel.add(playerTurn);

        // Left Panel
        gamePanel.add(leftPanel, BorderLayout.WEST);
        //leftPanel.setLayout();
        leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.PAGE_AXIS));
        playerOneLabel.setHorizontalAlignment(JLabel.CENTER);
        scorePlayerOne.setHorizontalAlignment(JLabel.CENTER);
        leftPanel.add(playerOneLabel);
        leftPanel.add(scorePlayerOne);

        
        // Right Panel
        gamePanel.add(rightPanel, BorderLayout.EAST);
        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.PAGE_AXIS));
        rightPanel.add(playerTwoLabel);
        rightPanel.add(scorePlayerTwo);

        // Center Panel
        centerPanel.setLayout(new GridLayout(this.getRows(),this.getColumns()));
        images = createImages();
        createBoard();
        gamePanel.add(centerPanel, BorderLayout.CENTER);


        // South Panel
        // TODO: Fix the exit button

            //FlowLayout flowLayout = new FlowLayout();
            //this.createPanel(exitPanel, panelColor, panelDimension, flowLayout);
            //exitPanel.add(exitButton);
        ExitHandler exithandler = new ExitHandler(exitButton);
        exitButton.addActionListener(exithandler);
        gamePanel.add(lowerPanel, BorderLayout.SOUTH);
        lowerPanel.add(exitButton);

        // Frame Parameters
        this.pack();
        this.setLocationRelativeTo(null); // Centers the frame
        this.setVisible(true);
    }



    public ArrayList<ImageIcon> createImages(){
        // Create a list of images
        // TODO: Make sure this path also works on another computer
        String themesPath = "C:\\Users\\delah\\Documents\\Programming\\workspace\\basic_programming_memory_game\\themes\\";
        ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < gridSize / 2; i++) {
                images.add(new ImageIcon(themesPath + theme + "\\" + i + ".jpg"));
            }
        }
        // Shuffle images
        Collections.shuffle(images);
        return images;
    }

    public void createBoard(){
        for (int i = 0; i < gridSize  ; i++) {
            centerPanel.add(new Card(this.getImages().get(i),this,i));

        }
    }


    public void playerTurn(Card card){
        // TODO: Stop timer when game exits
        // Turn cards when clicked
        getFlippedTiles().add(card);
        card.turnCard();

        // What to do when two cards are turned
        if (getFlippedTiles().size() > 1 ){

            Card card1 = getFlippedTiles().get(getFlippedTiles().size() - 2);
            Card card2 = getFlippedTiles().get(getFlippedTiles().size() - 1);
            // Prevents comparing the new card with a card chosen by the previous player
            if (getFlippedTiles().size() % 2 == 0) {
                //If the two images are the same
                if (card1.getName().equals(card2.getName())) {
                    System.out.println("They are the same image");
                    // TODO: Leave them locked
                    this.setNbCardsFound(this.getNbCardsFound() +2);
                    System.out.println(nbCardsFound);

                    // Give points to the right player
                    if (this.getPlayerTurn().getText().equals("Player 1's turn")) {
                        playerOne.incrementScore(pointsPerPair);
                        scorePlayerOne.setText((Integer.toString(playerOne.getScore())));
                        this.getPlayerTurn().setText("Player 2's turn");
                  } else {
                        playerTwo.incrementScore(pointsPerPair);
                        scorePlayerTwo.setText((Integer.toString(playerTwo.getScore())));
                        this.getPlayerTurn().setText("Player 1's turn");
                  }

              //TODO if they are different images
                    // TODO: Refactor the repetition in a different method
              } else {
                    System.out.println("they are different images");
                    if (card.isFlipped()) {
                        scheduler.schedule(new Runnable() {
                                               @Override
                                               public void run() {
                                                   card1.turnCard();
                                                   card2.turnCard();
                                                   card1.setClickable(true);
                                                   card2.setClickable(true);
                                               }
                                           }
                                , 1, TimeUnit.SECONDS);
                    }

                  // TODO: Change the player turn
                  if (this.getPlayerTurn().getText().equals("Player 1's turn")) {
                      this.getPlayerTurn().setText("Player 2's turn");

                  } else {
                      this.getPlayerTurn().setText("Player 1's turn");
                  }
              }
          }
            // TODO: CHeck if the game is done
            gameOver();

        }


    }
    public void gameOver(){
        // Check if game is over
        if (Integer.parseInt(timeLeft.getText()) <= 0 | nbCardsFound == gridSize ){
            System.out.println("no more time. game is over");
            timer.cancel();
            // Freeze all cards
            for (Component component : centerPanel.getComponents()){
                if (component instanceof Card){
                    ((Card) component).setClickable(false);
                }
            }
            // TODO: Stop timer once game is stopped.
            timer.cancel();


            if (playerIsMachine == true){
                // save the player 1 score to highscores
            } else {
                // Player One wins
                if (playerOne.getScore() > playerTwo.getScore()){
                    System.out.println("Player 1 Wins!!");
                    playerTurn.setText("Player 1 Wins!!");
                    highScoreWindow.writeHighScores(playerOne);
                }
                // It's a draw
                else if (playerOne.getScore() == playerTwo.getScore()){
                    System.out.println("Draw!");
                    playerTurn.setText("Draw :(");
                    highScoreWindow.writeHighScores(playerOne);
                    highScoreWindow.writeHighScores(playerTwo);

                    // Player 2 Wins
                } else if (playerOne.getScore() < playerTwo.getScore()){
                    System.out.println("Player 2 Wins!!");
                    playerTurn.setText("Player 2 Wins!!");
                    highScoreWindow.writeHighScores(playerTwo);
                // Nobody plays
                } else if (playerOne.getScore() == 0 & playerTwo.getScore() == 0){
                    playerTurn.setText("Is this game a joke to you?");
                }

            }
        } else {
            System.out.println("The game is still running");
        }
    }

    private static final int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
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


    public JLabel getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(JLabel playerTurn) {
        this.playerTurn = playerTurn;
    }

    public ArrayList<ImageIcon> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImageIcon> images) {
        this.images = images;
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

    public int getNbCardsFound() {
        return nbCardsFound;
    }

    public void setNbCardsFound(int nbCardsFound) {
        this.nbCardsFound = nbCardsFound;
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

    public ArrayList<Card> getFlippedTiles() {
        return flippedTiles;
    }

    public void setFlippedTiles(ArrayList<Card> flippedTiles) {
        this.flippedTiles = flippedTiles;
    }
}
