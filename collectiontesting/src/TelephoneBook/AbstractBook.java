/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TelephoneBook;

import java.util.HashMap;

/**
 *
 * @author sacry
 */
public class AbstractBook {

    private HashMap<String, Telephone> countries = new HashMap<>();

    public AbstractBook() {
    }

    public void add(Telephone t) {
        if (!countries.containsKey(t.getCountry())) {
            countries.put(t.getCountry(), t);
        }
    }

    public void remove(Telephone t) {
        if (countries.containsKey(t.getCountry())) {
            countries.remove(t.getCountry());
        }
    }

    public Telephone get(String country) {
        if (countries.containsKey(country)) {
            return countries.get(country);
        }
        return null;
    }

    @Override
    public String toString() {
        String accu = "";
        for (Telephone t : countries.values()) {
            accu += t.toString() + "\n";
        }
        return "All Books" + ":\n" + accu;
    }
}
