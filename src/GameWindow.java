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
    private int panelWidth = 300;
    private int panelHeight = 200;
    private Dimension panelDimension = new Dimension(panelWidth,panelHeight);

    // Panels
    private JPanel gamePanel = new JPanel();
    private JPanel upperPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel lowerPanel = new JPanel();

    // Upper Panel Fields
    private JLabel timeLeft = new JLabel();
    private JLabel playerTurn = new JLabel("Player 1");

    // Make a timer
    // (reference) Why the current approach over Timer class: https://stackoverflow.com/questions/10820033/make-a-simple-timer-in-java/14323134
//    long startTime = System.currentTimeMillis();
//
//    long elapsedTime = System.currentTimeMillis() - startTime;
//    long elapsedSeconds = elapsedTime / 1000;
//    long secondsDisplay = elapsedSeconds / 60;
//    long elapsedMinutes = elapsedSeconds / 60;
//    String timeString = Long.toString(elapsedSeconds);

    static int interval;
    static Timer timer;




    // Left Panel Fields
    private JLabel playerOneLabel = new JLabel("Player 1");
    private Player playerOne;
    private JLabel scorePlayerOne = new JLabel("0");

    // Right Panel Fields
    private String player; // Whether we play against AI or human
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

        System.out.print("Input seconds => : ");
        int secs = 60;
        int delay = 0;
        int period = 1000;
        timer = new Timer();
        interval = secs;
        System.out.println(secs);
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println(setInterval());
                timeLeft.setText(Integer.toString(setInterval()));
            }
        }, delay, period);

        upperPanel.add(timeLeft);
        upperPanel.add(playerTurn);

        // Left Panel
        gamePanel.add(leftPanel, BorderLayout.WEST);
        //leftPanel.setLayout();
        leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.PAGE_AXIS));
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
            //FlowLayout flowLayout = new FlowLayout();
            //this.createPanel(exitPanel, panelColor, panelDimension, flowLayout);
            //exitPanel.add(exitButton);
        ExitHandler exithandler = new ExitHandler(exitButton);
        exitButton.addActionListener(exithandler);
        gamePanel.add(lowerPanel, BorderLayout.SOUTH);
        lowerPanel.add(exitButton);

        // Frame Parameters
        this.pack();
        this.setVisible(true);
    }



    public ArrayList<ImageIcon> createImages(){
        // Create a list of images
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
        // Todo: click a card
        getFlippedTiles().add(card);
        card.turnCard();


        //TODO: What happens when Two cards is turned
        if (getFlippedTiles().size() > 1 ){
          // Prevents comparing the new card with a card chosen by the previous player
            Card card1 = getFlippedTiles().get(getFlippedTiles().size() - 2);
            Card card2 = getFlippedTiles().get(getFlippedTiles().size() - 1);

            if (getFlippedTiles().size() % 2 == 0) {
                //If the two images are the same
                if (card1.getName().equals(card2.getName())) {
                    System.out.println("They are the same image");
                    // TODO: Leave them locked
                    this.setNbCardsFound(this.getNbCardsFound() +2);
                    System.out.println(nbCardsFound);

                    // TODO: Give points to the right player
                    if (this.getPlayerTurn().getText().equals("Player 1")) {
                        playerOne.incrementScore(pointsPerPair);
                        scorePlayerOne.setText((Integer.toString(playerOne.getScore())));
                        this.getPlayerTurn().setText("Player 2");
                  } else {
                        playerTwo.incrementScore(pointsPerPair);
                        scorePlayerTwo.setText((Integer.toString(playerTwo.getScore())));
                        this.getPlayerTurn().setText("Player 1");
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
                  if (this.getPlayerTurn().getText().equals("Player 1c")) {
                      this.getPlayerTurn().setText("Player 2's turn");

                  } else {
                      this.getPlayerTurn().setText("Player 1's turn");
                  }


              }
          }
            // TODO: CHeck if the game is done
            if (nbCardsFound == gridSize){
                System.out.println("the game is over");

            } else {
                System.out.println("The game is still running");
            }


        }


        //TODO: What Happens when no cards are turned
            // check whose turn it is
            // if player 1 or 2 let them play
            // if computer, let computer make a move
            //



        //TODO: What happens when two cards are turned
            // if they are the same, keep them up and give the player points


            // if they are not the same turn them around

    }
    public void gameOver(){
        // Save scores to highscores
        // If you were playing against a computer
//        if (){

//        }
        // If you were playing against the human


        // close game window


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
