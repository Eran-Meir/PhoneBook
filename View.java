/**
 * Our view contains two panels:
 * 1. The phonebook with it's contents
 * 2. UI buttons
 *
 * @Author Eran Meir
 */

import javax.swing.*;
import java.awt.*;

public class View extends JFrame implements IView {
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 800;

    // Components
    private PhonebookPanel myPhonebookPanel;
    private ButtonsPanel myButtonsPanel;

    // Model
    private IModel myPhonebookModel;

    /**
     * Constructor for the View
     *
     * @param phonebookModel the phonebook model
     */
    public View(IModel phonebookModel) {
        this.myPhonebookModel = phonebookModel;
        this.myPhonebookPanel = new PhonebookPanel(myPhonebookModel);
        this.myButtonsPanel = new ButtonsPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.add(myPhonebookPanel, BorderLayout.CENTER);
        this.add(myButtonsPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    } // End Constructor

    /**
     * @return the phonebook panel
     */
    public PhonebookPanel getMyPhonebookPanel() {
        return this.myPhonebookPanel;
    }

    /**
     * updates the phone table
     *
     * @param myPhonebookModel the phonebook model
     */
    public void updatePhoneTable(IModel myPhonebookModel) {
        this.myPhonebookPanel.updateTableModel();
    }

    /**
     * adds a button listener to the view
     *
     * @param buttonListenerAdd the button listener from the controller
     */
    public void addButtonListenerAdd(Controller.ButtonListenerAdd buttonListenerAdd) {
        this.myButtonsPanel.getAddButton().addActionListener(buttonListenerAdd);
    }

    /**
     * adds a button listener to the view
     *
     * @param buttonListenerDelete the button listener from the controller
     */
    public void addButtonListenerDelete(Controller.ButtonListenerDelete buttonListenerDelete) {
        this.myButtonsPanel.getDeleteButton().addActionListener(buttonListenerDelete);
    }

    /**
     * adds a button listener to the view
     *
     * @param buttonListenerEdit the button listener from the controller
     */
    public void addButtonListenerEdit(Controller.ButtonListenerEdit buttonListenerEdit) {
        this.myButtonsPanel.getEditButton().addActionListener(buttonListenerEdit);
    }

    /**
     * adds a button listener to the view
     *
     * @param buttonListenerSearch button listener from the controller
     */
    public void addButtonListenerSearch(Controller.ButtonListenerSearch buttonListenerSearch) {
        this.myButtonsPanel.getSearchButton().addActionListener(buttonListenerSearch);
    }

    /**
     * adds a button listener to the view
     *
     * @param buttonListenerSave the button listener from the controller
     */

    public void addButtonListenerSave(Controller.ButtonListenerSave buttonListenerSave) {
        this.myButtonsPanel.getSaveButton().addActionListener(buttonListenerSave);
    }

    /**
     * adds a button listener to the view
     *
     * @param buttonListenerImport the button listener from the controller
     */
    public void addButtonListenerImport(Controller.ButtonListenerImport buttonListenerImport) {
        this.myButtonsPanel.getImportButton().addActionListener(buttonListenerImport);
    }
}
