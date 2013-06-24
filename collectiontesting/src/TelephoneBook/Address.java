/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TelephoneBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author sacry
 */
public class Address extends AbstractUtils {

    private String street, country, state;
    private Integer postal, streetnum;

    public Address(String country, String state, Integer postal, String street, Integer streetnum) {
        this.country = country;
        this.state = state;
        this.postal = postal;
        this.street = street;
        this.streetnum = streetnum;
    }

    public ArrayList<Object> getAddress() {
        return new ArrayList<Object>(Arrays.asList(country, state, postal, street, streetnum));
    }

    public String getStreet() {
        return street;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public int getPostal() {
        return postal;
    }

    public int getStreetnum() {
        return streetnum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Address)) {
            return false;
        }
        Address addr = (Address) obj;
        if (addr.getAddress().containsAll(this.getAddress())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return hashDouble(this.street + this.country + this.postal.toString() + this.street + this.streetnum.toString());
    }

    @Override
    public String toString() {
        return state + ", " + postal.toString() + ", " + street + ", " + streetnum.toString();
    }
}
