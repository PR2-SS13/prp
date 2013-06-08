/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.traits;

/**
 *
 * @author SaCry
 */
public interface WithUniqueId<UniqueId> extends Comparable<UniqueId> {

    UniqueId id();
}
