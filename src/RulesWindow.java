import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RulesWindow extends JFrame {
    private JPanel rulesPanel = new JPanel();
    private JLabel rules = new JLabel("Rules of the game");
    private JButton exitButton = new JButton("Exit");
    private JPanel exitPanel = new JPanel();

    // Parameters
    private Color panelColor = Color.WHITE;
    private int panelWidth = 300;
    private int panelHeight = 200;
    private Dimension panelDimension = new Dimension(panelWidth,panelHeight);

    public RulesWindow(){
        // Create the Frame containing the rules
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Rules of the Game");
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));

        // Add the rules pane
        this.createPanel(rulesPanel,panelColor,panelDimension);
        rulesPanel.add(rules);

        // Add the Exit Button
        this.createPanel(exitPanel,panelColor,panelDimension);
        exitPanel.add(exitButton);

        exitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                JFrame welcomeFrame = (JFrame) SwingUtilities.windowForComponent(exitButton);
                if (event.getSource() == exitButton){
                    welcomeFrame.dispose();
                }
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
