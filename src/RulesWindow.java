import javax.swing.*;
import java.awt.*;

public class RulesWindow extends JFrame {
    private JPanel rulesPanel = new JPanel();
    private JLabel rules = new JLabel("Rules of the game");
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
