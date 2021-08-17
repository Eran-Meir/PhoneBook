/**
 * This is a set of commands that we want the model to implement
 *
 * @Author Eran Meir
 */

import java.util.Iterator;
import java.util.Map;

public interface IModel {
    /**
     * @return the phonebook map data
     */
    Map<String, String> getPhoneBookMapData();

    /**
     * @return the map iterator
     */
    Iterator<Map.Entry<String, String>> getPhoneBookMapDataIterator();

    /**
     * Adds to the phone book
     *
     * @param name   the name to add
     * @param number the number to add
     */
    void addToPhoneBook(String name, String number);

    /**
     * Returns a row by a key
     *
     * @param keyToFind the key to find
     * @return the row number
     */
    int getKeyRowNumber(String keyToFind);
}
