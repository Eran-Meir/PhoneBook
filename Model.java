/**
 * Our phonebook model, here we implement the whole "thing"
 *
 * @Author Eran Meir
 */

import java.util.*;

public class Model implements IModel {
    // Phone Book
    TreeMap<String, String> phoneBookMapData;

    /**
     * Constructor for our model
     */
    public Model() {
        phoneBookMapData = new TreeMap<String, String>();
    }

    /**
     * returns the phonebook map data which is implemented using a TreeMap that contains 2 strings.
     *
     * @return the phonebook map data
     */
    public Map<String, String> getPhoneBookMapData() {
        return this.phoneBookMapData;
    }

    /**
     * The iterator for the phonebook data
     *
     * @return the phonebook map data iterator
     */
    public Iterator<Map.Entry<String, String>> getPhoneBookMapDataIterator() {
        return this.phoneBookMapData.entrySet().iterator();
    }

    /**
     * Add an entry - note that there is not a validation check, the user is free to add whatever that he wishes
     *
     * @param name   the name to add
     * @param number the number to add
     */
    public void addToPhoneBook(String name, String number) {
        phoneBookMapData.put(name, number);
    }

    /**
     * Finding the row number using a key
     *
     * @param keyToFind the name we want to search
     * @return the wanted row number, or -1 if it doesn't exist in our data
     */
    public int getKeyRowNumber(String keyToFind) {
        int rowNumber = 0;
        boolean found = false;
        Iterator<Map.Entry<String, String>> treeIterator = this.getPhoneBookMapDataIterator();
        String currentMapKey;
        while (treeIterator.hasNext() && !found) {
            currentMapKey = treeIterator.next().getKey();
            if (currentMapKey.equals(keyToFind))
                found = true;
            else
                rowNumber++;
        }
        if (found)
            return rowNumber;
        else
            return -1;
    }
}
