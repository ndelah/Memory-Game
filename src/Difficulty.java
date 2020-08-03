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
        // Add Labels and Radio Buttons
        this.add(this.getLabel_difficulty());
        this.add(this.getTouristButton());
        this.add(this.getNoviceButton());
        this.add(this.getExpertButton());
        this.add(this.getVeteranButton());
        this.add(this.getSeriousButton());

        // set default level of difficulty
        this.getTouristButton().setSelected(true);

        // Add RadioButtons to their parent group
        difficultyGroup.add(this.getTouristButton());
        difficultyGroup.add(this.getNoviceButton());
        difficultyGroup.add(this.getExpertButton());
        difficultyGroup.add(this.getVeteranButton());
        difficultyGroup.add(this.getSeriousButton());
    }

    public JLabel getLabel_difficulty() {
        return label_difficulty;
    }

    public void setLabel_difficulty(JLabel label_difficulty) {
        this.label_difficulty = label_difficulty;
    }

    public JRadioButton getTouristButton() {
        return touristButton;
    }

    public void setTouristButton(JRadioButton touristButton) {
        this.touristButton = touristButton;
    }

    public JRadioButton getNoviceButton() {
        return noviceButton;
    }

    public void setNoviceButton(JRadioButton noviceButton) {
        this.noviceButton = noviceButton;
    }

    public JRadioButton getExpertButton() {
        return expertButton;
    }

    public void setExpertButton(JRadioButton expertButton) {
        this.expertButton = expertButton;
    }

    public JRadioButton getVeteranButton() {
        return veteranButton;
    }

    public void setVeteranButton(JRadioButton veteranButton) {
        this.veteranButton = veteranButton;
    }

    public JRadioButton getSeriousButton() {
        return seriousButton;
    }

    public void setSeriousButton(JRadioButton seriousButton) {
        this.seriousButton = seriousButton;
    }

    public ButtonGroup getDifficultyGroup() {
        return difficultyGroup;
    }

    public void setDifficultyGroup(ButtonGroup difficultyGroup) {
        this.difficultyGroup = difficultyGroup;
    }
}
