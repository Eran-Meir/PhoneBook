/**
 * Here we implement our table model. The data here will be viewed as our phonebook
 *
 * @Author Eran Meir
 */

import javax.swing.table.AbstractTableModel;
import java.util.Iterator;
import java.util.Map;

public class PhoneTabelModel extends AbstractTableModel {
    private final int FIRST_COLUMN = 0;
    private final int SECOND_COLUMN = 1;

    // Model
    IModel myModel;
    // For the table
    String[] columns = {"Name", "Phone Number"};
    String[][] phoneArray;

    /**
     * Constructor for the table model
     *
     * @param myPhonebookModel the phonebook model
     */
    public PhoneTabelModel(IModel myPhonebookModel) {
        this.myModel = myPhonebookModel;
        updatePhoneArray(myModel);
    }

    /**
     * updates the phone array
     *
     * @param myModel our phonebook model
     */
    public void updatePhoneArray(IModel myModel) {
        int i = 0;
        phoneArray = new String[myModel.getPhoneBookMapData().size()][columns.length];
        Map.Entry<String, String> phoneBookEntry;
        Iterator<Map.Entry<String, String>> mapIterator = myModel.getPhoneBookMapDataIterator();
        while (mapIterator.hasNext()) {
            phoneBookEntry = mapIterator.next();
            phoneArray[i][FIRST_COLUMN] = phoneBookEntry.getKey();
            phoneArray[i][SECOND_COLUMN] = phoneBookEntry.getValue();
            i++;
        }
    }

    /**
     * deletes a table row
     *
     * @param row the number of row to delete
     */
    public void deleteTableRow(int row) {
        this.fireTableRowsDeleted(row, row);
    }

    /**
     * @return the column length
     */
    public int getColumnCount() {
        return this.columns.length;
    }

    /**
     * @return the rows length
     */
    public int getRowCount() {
        return this.phoneArray.length;
    }

    /**
     * returns a name from column number col
     *
     * @param col the column number to retrieve info from
     * @return the name
     */
    public String getColumnName(int col) {
        return this.columns[col];
    }

    /**
     * returns the data from the phone matrix
     *
     * @param row the row number
     * @param col the column number
     * @return the value from the phone array matrix
     */
    public String getValueAt(int row, int col) {
        return this.phoneArray[row][col];
    }
}
