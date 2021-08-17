/**
 * This is a set of commands that we want the view to implement
 *
 * @Author Eran Meir
 */
public interface IView {

    /**
     *
     * @return the phonebook panel
     */
    PhonebookPanel getMyPhonebookPanel();

    /**
     * updates the phone table view
     * @param myPhonebookModel the model to update according to
     */
    void updatePhoneTable(IModel myPhonebookModel);

    /**
     * Adds a button listener for the Add button
     * @param buttonListenerAdd the listener to add
     */
    void addButtonListenerAdd(Controller.ButtonListenerAdd buttonListenerAdd);

    /**
     * Adds a button listener for the Delete button
     * @param buttonListenerDelete the listener to add
     */
    void addButtonListenerDelete(Controller.ButtonListenerDelete buttonListenerDelete);

    /**
     * Adds a button listener for the Edit button
     * @param buttonListenerEdit the listener to add
     */
    void addButtonListenerEdit(Controller.ButtonListenerEdit buttonListenerEdit);

    /**
     * Adds a button listener for the Search button
     * @param buttonListenerSearch the listener to add
     */
    void addButtonListenerSearch(Controller.ButtonListenerSearch buttonListenerSearch);

    /**
     * Adds a button listener for the Save button
     * @param buttonListenerSave the listener to add
     */
    void addButtonListenerSave(Controller.ButtonListenerSave buttonListenerSave);

    /**
     * Adds a button listener for the Import button
     * @param buttonListenerImport the listener to add
     */
    void addButtonListenerImport(Controller.ButtonListenerImport buttonListenerImport);
}
