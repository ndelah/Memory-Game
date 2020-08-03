import javax.swing.*;

public class Opponent extends JPanel {
    // Players
    private JLabel opponentLabel = new JLabel("Opponent");
    private JRadioButton player2Button = new JRadioButton("Human");
    private JRadioButton compouterButton = new JRadioButton("Computer");
    private ButtonGroup opponentGroup = new ButtonGroup();



    public Opponent(){
        // Add Labels and Buttons
        this.add(opponentLabel);
        this.add(player2Button);
        this.add(compouterButton);

        // Add RadioButtons to their parent group
        this.getOpponentGroup().add(player2Button);
        this.getOpponentGroup().add(compouterButton);

        // Set default player
        this.player2Button.setSelected(true);

        // Set action commands for radio buttons
        this.getPlayer2Button().setActionCommand("player_2");
        this.getCompouterButton().setActionCommand("computer");
    }

    public JLabel getOpponentLabel() {
        return opponentLabel;
    }

    public void setOpponentLabel(JLabel opponentLabel) {
        this.opponentLabel = opponentLabel;
    }

    public JRadioButton getPlayer2Button() {
        return player2Button;
    }

    public void setPlayer2Button(JRadioButton player2Button) {
        this.player2Button = player2Button;
    }

    public JRadioButton getCompouterButton() {
        return compouterButton;
    }

    public void setCompouterButton(JRadioButton compouterButton) {
        this.compouterButton = compouterButton;
    }

    public void setOpponentGroup(ButtonGroup opponentGroup) {
        this.opponentGroup = opponentGroup;
    }

    public ButtonGroup getOpponentGroup() {
        return opponentGroup;
    }
}
