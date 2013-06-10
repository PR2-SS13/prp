/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics;

/**
 *
 * @author SaCry
 */
public interface UniqueId extends AdminValue, Comparable<UniqueId> {

    long idNumber();
}
