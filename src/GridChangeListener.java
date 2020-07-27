import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GridChangeListener  implements ChangeListener {
    private JSpinner rowsSpinner;
    private JSpinner columnsSpinner;
    private int rows;
    private int columns;

    public GridChangeListener(JSpinner rows, JSpinner columns){
        this.rowsSpinner = rows;
        this.columnsSpinner = columns;
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == this.rowsSpinner){
           JSpinner test = (JSpinner) (e.getSource());
            System.out.println(test.getValue());
            this.setRows((int) test.getValue());

        }
        else if (e.getSource() == this.columnsSpinner){
            JSpinner test = (JSpinner) (e.getSource());
            System.out.println(test.getValue());
            this.setColumns((int) test.getValue());

        }
    }

    public JSpinner getRowsSpinner() {
        return rowsSpinner;
    }

    public void setRowsSpinner(JSpinner rowsSpinner) {
        this.rowsSpinner = rowsSpinner;
    }

    public JSpinner getColumnsSpinner() {
        return columnsSpinner;
    }

    public void setColumnsSpinner(JSpinner columnsSpinner) {
        this.columnsSpinner = columnsSpinner;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
