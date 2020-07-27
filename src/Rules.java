import javax.swing.*;

public class Rules extends JPanel {

    private JPanel panel_rules = new JPanel();
    private JButton rulesButton = new JButton("Rules");

    public Rules (){
        this.add(rulesButton);
    }

    public JButton getRulesButton() {
        return rulesButton;
    }
}
