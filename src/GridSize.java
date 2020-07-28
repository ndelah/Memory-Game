import javax.swing.*;

public class GridSize extends JPanel {

    // Gridsize
    private JPanel gridSizePanel = new JPanel();
    private JLabel rowsLabel = new JLabel("Rows");
    private JSpinner rowsSpinner = new JSpinner(new SpinnerNumberModel(2,2,10,2));
    private JLabel colummsLabel = new JLabel("Colums");
    private JSpinner columnspinner = new JSpinner(new SpinnerNumberModel(2,2,10,2));

    public GridSize(){
        this.add(rowsLabel);
        this.add(rowsSpinner);
        this.add(colummsLabel);
        this.add(columnspinner);

    }

    public JSpinner getRowsSpinner() {
        return rowsSpinner;
    }

    public JSpinner getColumnspinner() {
        return columnspinner;
    }
}
