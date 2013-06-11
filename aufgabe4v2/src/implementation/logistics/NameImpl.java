/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import interfaces.logistics.Name;

/**
 *
 * @author SaCry
 */
public class NameImpl implements Name {

    private String name;

    private NameImpl(String name) {
        this.name = name;
    }

    public static NameImpl valueOf(String name) {
        return new NameImpl(name);
    }

    @Override
    public String nameString() {
        return this.name;
    }
}
