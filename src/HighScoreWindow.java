import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HighScoreWindow extends JFrame {
    // Window Fields
    private JPanel highScorePanel = new JPanel();
    private JPanel exitPanel = new JPanel();
    private JButton exitButton = new JButton("Exit");

//    private String[] columnNames = {"Player","Highscore"};
//    private String[][] rowData;
//    private DefaultTableModel model;
//    private JTable highScores = new JTable(rowData,columnNames);
    private Object[] columnNames1 = new Object[]{"Player","Score"};


    private Object[][] data;

    private JTable highscores = new JTable(new DefaultTableModel(data,columnNames1));
    private DefaultTableModel model = (DefaultTableModel) highscores.getModel();

    private JScrollPane scrollPane = new JScrollPane(highscores);


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
        highscores.setFillsViewportHeight(true);
        highScorePanel.add(scrollPane);

        loader(scorePath,model);

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

    public void loader(String scorePath, DefaultTableModel model) {
        try {
            File file = new File(scorePath);
            FileReader fileReader = new FileReader(file);   //reads the file
            BufferedReader bufferedReader = new BufferedReader(fileReader);  //creates a buffering character input stream
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String line_part[] = line.split(";");
                Object[] data = {line_part[0],line_part[1]};
                model.addRow(data);
            }
            fileReader.close();    //closes the stream and release the resources
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeHighscores(){
        //
        System.out.println("writing scores to high score table");

    }
}
