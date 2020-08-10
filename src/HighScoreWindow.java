import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class HighScoreWindow extends JFrame {
    // Window Fields
    private JPanel highScorePanel = new JPanel();
    private JPanel exitPanel = new JPanel();
    private JButton exitButton = new JButton("Exit");

    // Table Fields
    private Object[] columnNames = new Object[]{"Player","Score"};
    private Object[][] rowData;
    private JTable highscores = new JTable(new DefaultTableModel(rowData, columnNames));
    private DefaultTableModel model = (DefaultTableModel) highscores.getModel();
    private JScrollPane scrollPane = new JScrollPane(highscores);
    private String scorePath = "\\Users\\delah\\Documents\\Programming\\workspace\\basic_programming_memory_game\\src\\highscores.txt";

    // Panel Fields
    private Color panelColor = Color.WHITE;
    private int panelWidth = 300;
    private int panelHeight = 200;
    private Dimension panelDimension = new Dimension(panelWidth,panelHeight);

    public HighScoreWindow(){
        // Create the Frame containing the highScores
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Memory Game Hall of Fame");
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));
        this.createPanel(highScorePanel,panelColor,panelDimension);

        // Table Containing scores
        highscores.setFillsViewportHeight(true);
        highScorePanel.add(scrollPane); // Table must be added to scrollpane to render correctly
        loader(scorePath,model); // Loads the scores from the text file
        Player player = new Player("Playertest",300);
        writeHighScores(player);

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

    public void writeHighScores(Player player){
        //
        System.out.println("writing scores to high score table");

        try (FileWriter fileWriter = new FileWriter(scorePath,true)){

            fileWriter.write(player.getName() + ";" + player.getScore());
            fileWriter.write(System.getProperty("line.separator"));

        }

        catch (IOException e){
            System.out.println("File not found");
        }

    }

    public String getScorePath() {
        return scorePath;
    }
}
