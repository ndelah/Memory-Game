import javax.swing.table.DefaultTableModel;

public class ScoresTableModel extends DefaultTableModel {

    public ScoresTableModel(Object rowData[][], Object columnNames[]) {
        super(rowData, columnNames);
    }

    @Override
    public Class getColumnClass(int col) {
        if (col == 1)       //second column accepts only Integer values
            return Integer.class;
        else return String.class;  //other columns accept String values
    }
}
