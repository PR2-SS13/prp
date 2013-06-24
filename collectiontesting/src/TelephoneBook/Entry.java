/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TelephoneBook;

/**
 *
 * @author sacry
 */
public class Entry extends AbstractUtils implements Comparable<Entry> {

    private String fname, lname, number;
    private Address address;

    public Entry(String fname, String lname, String number, Address address) {
        this.fname = fname;
        this.lname = lname;
        this.number = number;
        this.address = address;
    }

    public String getFullName() {
        return this.fname + " " + this.lname;
    }

    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.lname;
    }

    public Address getAddress() {
        return this.address;
    }

    public String getNumber() {
        return this.number;
    }

    @Override
    public int compareTo(Entry t) {
        int tmp = compareToHelper(this.lname, t.lname);
        if (tmp != 0) {
            return tmp;
        }
        tmp = compareToHelper(this.fname, t.fname);
        if (tmp != 0) {
            return tmp;
        }
        return compareToHelper(this.number, t.number);
    }

    private int compareToHelper(String s1, String s2) {
        if (s1.compareTo(s2) > 0) {
            return 1;
        } else if (s1.compareTo(s2) < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        return this.compareTo((Entry) obj) == 0;
    }

    @Override
    public int hashCode() {
        return hashDouble(getFullName());
    }

    @Override
    public String toString() {
        return "\t" + fname + " " + lname + ", " + number.toString() + ", " + address.toString();
    }
}
