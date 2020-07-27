import javax.swing.*;

public class Opponent extends JPanel {
    // Players
    private JLabel opponentLabel = new JLabel("Opponent");
    private JRadioButton player2Button = new JRadioButton("Human");
    private JRadioButton compouterButton = new JRadioButton("Computer");
    private ButtonGroup opponentGroup = new ButtonGroup();

    public Opponent(){
        this.add(opponentLabel);
        this.add(player2Button);
        this.add(compouterButton);
        opponentGroup.add(player2Button);
        opponentGroup.add(compouterButton);
    }

}
