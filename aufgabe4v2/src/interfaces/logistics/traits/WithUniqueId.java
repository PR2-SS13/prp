/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.traits;

import interfaces.logistics.UniqueId;

/**
 *
 * @author SaCry
 */
public interface WithUniqueId<E> extends Comparable<E> {

    UniqueId id();
}