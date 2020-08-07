import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HighScoreWindow extends JFrame {
    // Window Fields
    private JPanel highScorePanel = new JPanel();
    private JPanel exitPanel = new JPanel();
    private JButton exitButton = new JButton("Exit");

    private String[] columnNames = {"Player","Highscore"};
    private String[][] rowData;
    private JTable highScores = new JTable(rowData,columnNames);

    private Color panelColor = Color.WHITE;
    private int panelWidth = 300;
    private int panelHeight = 200;
    private Dimension panelDimension = new Dimension(panelWidth,panelHeight);

    private int lengthHighScoreTable = 10;
    private String scorePath = "\\Users\\delah\\Documents\\Programming\\workspace\\basic_programming_memory_game\\src\\highscores.txt";



    public HighScoreWindow(){
        // Create the Frame containing the highScores
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Memory Game Hall of Fame");
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));

        this.createPanel(highScorePanel,panelColor,panelDimension);
        this.add(highScores);

        loadHighScores(scorePath);

        // Add the Exit Button
        this.createPanel(exitPanel,panelColor,panelDimension);
        exitPanel.add(exitButton);
        ExitHandler exithandler = new ExitHandler(exitButton);
        exitButton.addActionListener(exithandler);

        this.pack();
        this.setVisible(true);
    }

    public void createPanel(JPanel panel, Color panelColor, Dimension panelDimension){
        panel.setBackground(panelColor);
        panel.setPreferredSize(panelDimension);
        panel.setLayout(new FlowLayout());
        this.getContentPane().add(panel);
    }

    public void loadHighScores(String scorePath){
        rowData = new String[10][2];
        int scoresLoaded = 0;
        try(Scanner scoreReader = new Scanner(new FileReader(scorePath))){
            while (scoreReader.hasNext()&& scoresLoaded <= 11){
                try {
                    String line = scoreReader.nextLine();
                    System.out.println(line);
                    String line_part[] = line.split(";");
                    if (scoresLoaded <= 11) {
                        rowData[scoresLoaded] = line_part;
                    }
                    System.out.println(scoresLoaded);
                    scoresLoaded += 1;
                } catch (InputMismatchException mismatch) {
                    System.out.println("Invalid entry in file, stop reading from file.");
                    break;
                }

            }
        } catch (FileNotFoundException e){
            System.out.println("Error: File " + e + " not found. Refer to the almighty Google");
            System.exit(0); // successful exit

        }


    }
}
