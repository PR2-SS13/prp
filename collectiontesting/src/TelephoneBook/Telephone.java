/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TelephoneBook;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sacry
 */
public class Telephone {

    private Map<String, Entry> people;
    private String country;

    public Telephone(String country) {
        this.country = country;
        people = new HashMap<>();
    }

    public String getCountry() {
        return country;
    }

    public void add(Entry e) {
        if (!people.containsKey(e.getFullName())) {
            people.put(e.getFullName(), e);
        } else {
            Entry tmp = people.get(e.getFullName());
            if (tmp.compareTo(e) < 0) {
                people.put(e.getFullName(), e);
            }
        }
    }

    public void remove(Entry e) {
        if (people.containsKey(e.getFullName())) {
            people.remove(e.getFullName());
        }
    }

    public void addAll(Collection<Entry> c) {
        for (Entry e : c) {
            add(e);
        }
    }

    public void removeAll(Collection<Entry> c) {
        for (Entry e : c) {
            remove(e);
        }
    }

    public Entry get(String fullname) {
        if (people.containsKey(fullname)) {
            return people.get(fullname);
        }
        return null;
    }

    @Override
    public String toString() {
        String accu = "";
        for (Entry e : people.values()) {
            accu += e.toString() + "\n";
        }
        return "\t" + country + ":\n" + accu;
    }
}