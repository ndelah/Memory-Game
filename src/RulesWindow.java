import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RulesWindow extends JFrame {
    private JPanel rulesPanel = new JPanel();
    private JTextArea rules = new JTextArea("Rules of the game\n lolilolz");
    private JButton exitButton = new JButton("Exit");
    private JPanel exitPanel = new JPanel();

    FrameSettings frameSettings = new FrameSettings();

    // Parameters
    private Color panelColor = Color.WHITE;
    private int panelWidth = 300;
    private int panelHeight = 200;
    private Dimension panelDimension = new Dimension(panelWidth,panelHeight);


    public RulesWindow(){
        // Create the Frame containing the rules
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Rules of the GameWindow");
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));

        this.setMinimumSize(frameSettings.getMinimumSize());
        this.setPreferredSize(frameSettings.getPreferredSize());
        this.setMaximumSize(frameSettings.getMaximumSize());

        // Add the rules pane
        this.createPanel(rulesPanel,panelColor,panelDimension);
        rulesPanel.add(rules);
        try {
            Scanner scanner = new Scanner( new File("C:\\Users\\delah\\Documents\\Programming\\workspace\\basic_programming_memory_game\\src\\rules.txt") );
            String text = scanner.useDelimiter("\\A").next();
            rules.setText(text);
            scanner.close();
        } catch (IOException e){
            System.out.println("kjk");
        }



        // Add the Exit Button
        this.createPanel(exitPanel,panelColor,panelDimension);
        exitPanel.add(exitButton);
        ExitHandler exithandler = new ExitHandler(exitButton);
        exitButton.addActionListener(exithandler);

        this.pack();
        this.setLocationRelativeTo(null); // Centers the frame
        this.setVisible(true);
    }

    public void createPanel(JPanel panel, Color panelColor, Dimension panelDimension){
        panel.setBackground(panelColor);
        panel.setPreferredSize(panelDimension);
        panel.setLayout(new FlowLayout());
        this.getContentPane().add(panel);
    }


}
