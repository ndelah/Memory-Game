import javax.swing.*;

public class ExtraSettings extends JPanel {
    private JButton themeButton = new JButton("Theme");
    private JButton highscoreButton = new JButton("Highscore");
    private JButton startButton = new JButton("Start");
    private JButton exitButton = new JButton("Exit");

    public ExtraSettings (){
        this.add(themeButton);
        this.add(themeButton);
        this.add(startButton);
        this.add(exitButton);
    }

    public JButton getThemeButton() {
        return themeButton;
    }

    public JButton getHighscoreButton() {
        return highscoreButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
