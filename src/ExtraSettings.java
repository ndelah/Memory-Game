import javax.swing.*;

public class ExtraSettings extends JPanel {
    //private JButton themeButton = new JButton("Theme");

    private String[] themes = {"Colors","Confusing flags","California style flags","Flags","Isle of Man Flags"};
    private JComboBox themesCombobox = new JComboBox(themes);

    private JButton highscoreButton = new JButton("Highscore");
    private JButton startButton = new JButton("Start");
    private JButton exitButton = new JButton("Exit");

    public ExtraSettings (){
        this.add(themesCombobox);
        this.add(startButton);
        this.add(highscoreButton);
        this.add(exitButton);


        // Closes the Welcome Window when the exit button is clicked
        ExitHandler exithandler = new ExitHandler(this.getExitButton());
        this.getExitButton().addActionListener(exithandler);
    }


    public JButton getStartButton() {
        return startButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
