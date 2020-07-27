import javax.swing.*;

public class Difficulty extends JPanel{

    private JLabel label_difficulty = new JLabel("Difficulty");
    private JRadioButton touristButton = new JRadioButton("Tourist");
    private JRadioButton noviceButton = new JRadioButton("Novice");
    private JRadioButton expertButton = new JRadioButton("Expert");
    private JRadioButton veteranButton = new JRadioButton("Veteran");
    private JRadioButton seriousButton = new JRadioButton("Serious");

    private ButtonGroup difficultyGroup = new ButtonGroup();

    public Difficulty(){
        this.add(label_difficulty);
        this.add(touristButton);
        this.add(noviceButton);
        this.add(expertButton);
        this.add(veteranButton);
        this.add(seriousButton);

        difficultyGroup.add(touristButton);
        difficultyGroup.add(noviceButton);
        difficultyGroup.add(expertButton);
        difficultyGroup.add(veteranButton);
        difficultyGroup.add(seriousButton);
    }




}
