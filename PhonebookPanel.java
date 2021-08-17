/**
 * This is one of the panels that the user sees in the UI.
 * This panel contains the phonebook table, which lies on top of a scrollpane
 *
 * @Author Eran Meir
 */

import javax.swing.*;
import java.awt.*;

public class PhonebookPanel extends JPanel {

    // Model & Data
    IModel myModel;

    // Components
    JScrollPane scrollPane;
    JTable phoneTable;

    /**
     * Constructor for the phonebook panel
     *
     * @param myPhonebookModel the phonebook model
     */
    public PhonebookPanel(IModel myPhonebookModel) {
        this.myModel = myPhonebookModel;
        phoneTable = new JTable(new PhoneTabelModel(myModel));
        scrollPane = new JScrollPane(phoneTable);
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * sets a new table model
     */
    public void updateTableModel() {
        this.phoneTable.setModel(new PhoneTabelModel(myModel));
    }

    /**
     * @return the phone table
     */
    public JTable getPhoneTable() {
        return this.phoneTable;
    }
}
