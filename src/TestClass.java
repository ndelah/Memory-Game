import javax.swing.*;
import java.awt.*;

public class TestClass {

    JButton button = new JButton("Click me!");

    Dimension dimensions = new Dimension(300,200);

    private static JPanel makePanel(Color color){
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(100,100));
        return panel;
    }

    public static void main(String[] args) {
        // Setting the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Color app");

        // Panel rules
        JPanel panel_rules = new JPanel();
        panel_rules.setBackground(Color.WHITE);
        panel_rules.setPreferredSize(new Dimension(300,200));

        JButton rules = new JButton("Rules");
        panel_rules.add(rules);

        // Panel Difficulty
        JPanel panel_difficulty = new JPanel();
        panel_difficulty.setBackground(Color.WHITE);
        panel_difficulty.setPreferredSize(new Dimension(300,200));
        panel_difficulty.setLayout(new FlowLayout());

        JLabel label_difficulty = new JLabel("Difficulty");
        panel_difficulty.add(label_difficulty);

        JRadioButton touristButton = new JRadioButton("Tourist");
        panel_difficulty.add(touristButton);

        JRadioButton noviceButton = new JRadioButton("Novice");
        panel_difficulty.add(noviceButton);

        JRadioButton expertButton = new JRadioButton("Expert");
        panel_difficulty.add(expertButton);

        JRadioButton veteranButton = new JRadioButton("Veteran");
        panel_difficulty.add(veteranButton);

        JRadioButton seriousButton = new JRadioButton("Serious");
        panel_difficulty.add(seriousButton);

        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(touristButton);
        difficultyGroup.add(noviceButton);
        difficultyGroup.add(expertButton);
        difficultyGroup.add(veteranButton);
        difficultyGroup.add(seriousButton);

        // Time
        JPanel timePanel = new JPanel();
        timePanel.setBackground(Color.WHITE);
        timePanel.setPreferredSize(new Dimension(300,200));
        timePanel.setLayout(new FlowLayout());

        JLabel timeLabel = new JLabel("Time");
        timePanel.add(timeLabel);

        JSlider timeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100 , 50);
        timePanel.add(timeSlider);


        // Opponent
        JPanel opponentPanel = new JPanel();
        opponentPanel.setBackground(Color.WHITE);
        opponentPanel.setPreferredSize(new Dimension(300,300));
        opponentPanel.setLayout(new FlowLayout());

        JLabel opponentLabel = new JLabel("Opponent");
        opponentPanel.add(opponentLabel);

        JRadioButton player2Button = new JRadioButton("Player 2");
        opponentPanel.add(player2Button);

        JRadioButton compouterButton = new JRadioButton("Computer");
        opponentPanel.add(compouterButton);

        ButtonGroup opponentGroup = new ButtonGroup();
        opponentGroup.add(player2Button);
        opponentGroup.add(compouterButton);

        // Rows and columns of the game
        JPanel gridSizePanel = new JPanel();
        gridSizePanel.setBackground(Color.WHITE);
        gridSizePanel.setPreferredSize(new Dimension(300,300));
        gridSizePanel.setLayout(new FlowLayout());

        JLabel rowsLabel = new JLabel("Rows");
        gridSizePanel.add(rowsLabel);

        JSpinner rowsSpinner = new JSpinner();
        gridSizePanel.add(rowsSpinner);

        JLabel colummsLabel = new JLabel("Colums");
        gridSizePanel.add(colummsLabel);

        JSpinner columnspinner = new JSpinner();
        gridSizePanel.add(columnspinner);

        // Theme high score, start and exit

        JPanel lastSettings = new JPanel();
        lastSettings.setBackground(Color.WHITE);
        lastSettings.setPreferredSize(new Dimension(300,300));
        lastSettings.setLayout(new FlowLayout());


        // Easy way to add certain types of recucring panels. Could be useful for the grid
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.PAGE_AXIS));

        frame.getContentPane().add(panel_rules);
        frame.getContentPane().add(panel_difficulty);
        frame.getContentPane().add(timePanel);
        frame.getContentPane().add(opponentPanel);
        frame.getContentPane().add(gridSizePanel);

        frame.getContentPane().add(makePanel(Color.red));

        frame.pack();
        frame.setVisible(true);







    }

}
