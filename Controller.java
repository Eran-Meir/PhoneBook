/**
 * This is the controller, from here we control both the model and the view
 * Here we define Classes that implement ActionListeners for our each of our view buttons
 *
 * @Author Eran Meir
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Map;

public class Controller implements IController {

    IModel myModel;
    IView myView;

    /**
     * Constructor for our Controller
     *
     * @param myPhonebookModel the phonebook model
     * @param myPhonebookView  the phonebook view
     */
    public Controller(IModel myPhonebookModel, IView myPhonebookView) {
        this.myModel = myPhonebookModel;
        this.myView = myPhonebookView;
        this.myView.addButtonListenerAdd(new ButtonListenerAdd());
        this.myView.addButtonListenerDelete(new ButtonListenerDelete());
        this.myView.addButtonListenerEdit(new ButtonListenerEdit());
        this.myView.addButtonListenerSearch(new ButtonListenerSearch());
        this.myView.addButtonListenerSave(new ButtonListenerSave());
        this.myView.addButtonListenerImport(new ButtonListenerImport());
    }

    /**
     * Button Listener Class for the Add function
     */
    public class ButtonListenerAdd implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nameToAdd = JOptionPane.showInputDialog((Component) myView, "Enter Name:");
            String numberToAdd = JOptionPane.showInputDialog((Component) myView, "Enter Phone Number:");
            if (nameToAdd != null && numberToAdd != null && !nameToAdd.equals("") && !numberToAdd.equals("")) {
                myModel.addToPhoneBook(nameToAdd, numberToAdd);
                myView.getMyPhonebookPanel().updateTableModel();
            } else {
                JOptionPane.showMessageDialog((Component) myView, "Error: Wrong Name/Number input",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } // End of actionPerformed
    } // End of inner class ButtonListenerAdd

    /**
     * Button Listener class for the Delete function
     */
    public class ButtonListenerDelete implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int rowToRemove = myView.getMyPhonebookPanel().getPhoneTable().getSelectedRow();
                Object keyToRemove = myView.getMyPhonebookPanel().getPhoneTable().getValueAt(rowToRemove, 0);
                myModel.getPhoneBookMapData().remove((String) keyToRemove);
                ((PhoneTabelModel) myView.getMyPhonebookPanel().getPhoneTable().getModel()).deleteTableRow(rowToRemove);
                myView.getMyPhonebookPanel().updateTableModel();
            } catch (ArrayIndexOutOfBoundsException e1) {
                JOptionPane.showMessageDialog((Component) myView, "Error: You must choose a line in the table to delete",
                        "Delete Error", JOptionPane.ERROR_MESSAGE);
            }
        } // End of actionPerformed
    } // End of inner class ButtonListenerDelete

    /**
     * Button Listener Class for the Edit function
     */
    public class ButtonListenerEdit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int rowToRemove = myView.getMyPhonebookPanel().getPhoneTable().getSelectedRow();
                int colToEdit = myView.getMyPhonebookPanel().getPhoneTable().getSelectedColumn();
                Object currentKey = myView.getMyPhonebookPanel().getPhoneTable().getValueAt(rowToRemove, 0);
                Object currentVal = myView.getMyPhonebookPanel().getPhoneTable().getValueAt(rowToRemove, 0);
                Object keyToSet = null, valueToSet = null;
                if (colToEdit == 0) {
                    valueToSet = currentVal;
                    keyToSet = JOptionPane.showInputDialog((Component) myView, "Enter the NAME:");
                } else if (colToEdit == 1) {
                    keyToSet = currentKey;
                    valueToSet = JOptionPane.showInputDialog((Component) myView, "Enter the PHONE NUMBER:");
                }
                if (keyToSet != null && valueToSet != null && !keyToSet.equals("") && !valueToSet.equals("")) {
                    myModel.getPhoneBookMapData().remove((String) currentKey);
                    ((PhoneTabelModel) myView.getMyPhonebookPanel().getPhoneTable().getModel()).deleteTableRow(rowToRemove);
                    myModel.addToPhoneBook((String) keyToSet, (String) valueToSet);
                    myView.getMyPhonebookPanel().updateTableModel();
                } else {
                    JOptionPane.showMessageDialog((Component) myView, "Error: Wrong Name/Number input",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ArrayIndexOutOfBoundsException e1) {
                JOptionPane.showMessageDialog((Component) myView, "Error: You must choose a field to edit Name/Phone",
                        "Edit Error", JOptionPane.ERROR_MESSAGE);
            }
        } // End of actionPerformed
    } // End of inner class ButtonListenerEdit

    /**
     * Button Listener Class for the Search function
     */
    public class ButtonListenerSearch implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row;
            String nameToSearch = JOptionPane.showInputDialog((Component) myView, "Enter the Name to search:");
            row = myModel.getKeyRowNumber(nameToSearch);
            if (row != -1)
                myView.getMyPhonebookPanel().getPhoneTable().setRowSelectionInterval(row, row);
            else
                JOptionPane.showMessageDialog((Component) myView, "Error: Name was not found",
                        "Name Not Found Error", JOptionPane.ERROR_MESSAGE);
        } // End of actionPerformed
    } // End of inner class ButtonListenerClear

    /**
     * Button Listener Class for the Save function
     */
    public class ButtonListenerSave implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            boolean success = true;
            Map<String, String> mapToWrite = myModel.getPhoneBookMapData();
            final String fileName = "./ContactsOutput.txt";
            FileWriter myStream = null;
            try {
                myStream = new FileWriter(fileName);
            } catch (IOException e1) {
                JOptionPane.showMessageDialog((Component) myView, "Error opening the file file",
                        "File Error", JOptionPane.ERROR_MESSAGE);
                success = false;
            }
            BufferedWriter output = new BufferedWriter(myStream);
            for (Map.Entry<String, String> myPhoneData : mapToWrite.entrySet()) {
                try {
                    output.write(myPhoneData.getKey() + "," + myPhoneData.getValue() + '\n');
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog((Component) myView, "Error writing to file",
                            "File Error", JOptionPane.ERROR_MESSAGE);
                    success = false;
                }
            }
            try {
                output.flush();
            } catch (IOException e1) {
                JOptionPane.showMessageDialog((Component) myView, "Error flushing the buffer",
                        "File Error", JOptionPane.ERROR_MESSAGE);
                success = false;
            }
            try {
                output.close();
            } catch (IOException e1) {
                JOptionPane.showMessageDialog((Component) myView, "Error closing the file",
                        "File Error", JOptionPane.ERROR_MESSAGE);
                success = false;
            }
            if (success)
                JOptionPane.showMessageDialog((Component) myView, "The contacts were Succefully saved!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
        } // End of actionPerformed
    } // End of inner class ButtonListenerClear

    /**
     * Button Listener Class for the Import function
     */
    public class ButtonListenerImport implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            final int ENTRY_NAME = 0;
            final int ENTRY_PHONE = 1;
            final int STRING_SPLIT_SIZE = 2;
            final String fileName = "./ContactsOutput.txt";
            BufferedReader br = null;
            String line = null;
            String[] splitString;
            boolean success = true;
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e1) {
                JOptionPane.showMessageDialog((Component) myView, "Error file not found!",
                        "File Error", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (br != null)
                    line = br.readLine();
                else
                    success = false;
                while (line != null) {
                    splitString = line.split(",", STRING_SPLIT_SIZE);
                    myModel.addToPhoneBook(splitString[ENTRY_NAME], splitString[ENTRY_PHONE]);
                    line = br.readLine();
                }
                if (success) {
                    myView.updatePhoneTable(myModel);
                    JOptionPane.showMessageDialog((Component) myView, "The contacts were Succefully imported!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException e1) {
                JOptionPane.showMessageDialog((Component) myView, "Error writing to file",
                        "File Error", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (br != null)
                    br.close();
            } catch (IOException e1) {
                JOptionPane.showMessageDialog((Component) myView, "Error closing the file",
                        "File Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } // End inner class
} // End Controller class

