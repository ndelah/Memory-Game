import javax.swing.*;

public class Rules extends JPanel {

    private JPanel panel_rules = new JPanel();
    private JButton rulesButton = new JButton("Rules");

    public Rules (){
        this.add(rulesButton);

        RulesHandler rulesHandler = new RulesHandler(this.rulesButton);
        this.rulesButton.addActionListener(rulesHandler);
    }
}
