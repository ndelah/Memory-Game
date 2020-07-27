import javax.swing.*;

public class GridSize extends JPanel {

    // Gridsize
    private JPanel gridSizePanel = new JPanel();
    private JLabel rowsLabel = new JLabel("Rows");
    private JSpinner rowsSpinner = new JSpinner();
    private JLabel colummsLabel = new JLabel("Colums");
    private JSpinner columnspinner = new JSpinner();

    public GridSize(){
        this.add(rowsLabel);
        this.add(rowsSpinner);
        this.add(colummsLabel);
        this.add(columnspinner);
    }
}
