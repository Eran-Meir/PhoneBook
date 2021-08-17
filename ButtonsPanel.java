/**
 * This is a panel for the buttons that will be shown in the UI
 *
 * @Author Eran Meir
 */

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    // Constants
    final String BUTTON_TEXT_ADD = "Add";
    final String BUTTON_TEXT_EDIT = "Edit Selected Field";
    final String BUTTON_TEXT_DELETE = "Delete";
    final String BUTTON_TEXT_SEARCH = "Search";
    final String BUTTON_TEXT_SAVE = "Save Contacts";
    final String BUTTON_TEXT_IMPORT = "Import Contacts";

    // Components
    private JButton addButton, editButton, deleteButton, searchButton, saveButton, importButton;

    /**
     * Constructor for the panel
     */
    public ButtonsPanel() {
        this.setLayout(new FlowLayout());
        addButton = new JButton(BUTTON_TEXT_ADD);
        editButton = new JButton(BUTTON_TEXT_EDIT);
        deleteButton = new JButton(BUTTON_TEXT_DELETE);
        searchButton = new JButton(BUTTON_TEXT_SEARCH);
        saveButton = new JButton(BUTTON_TEXT_SAVE);
        importButton = new JButton(BUTTON_TEXT_IMPORT);
        this.add(addButton);
        this.add(editButton);
        this.add(deleteButton);
        this.add(searchButton);
        this.add(saveButton);
        this.add(importButton);
    }

    /**
     * @return the Add button
     */
    public JButton getAddButton() {
        return this.addButton;
    }

    /**
     * @return the Delete button
     */
    public JButton getDeleteButton() {
        return this.deleteButton;
    }

    /**
     * @return the Edit button
     */
    public JButton getEditButton() {
        return this.editButton;
    }

    /**
     * @return the Search button
     */
    public JButton getSearchButton() {
        return this.searchButton;
    }

    /**
     * @return the Save button
     */
    public JButton getSaveButton() {
        return this.saveButton;
    }

    /**
     * @return the Import button
     */
    public JButton getImportButton() {
        return this.importButton;
    }
}
