/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics;

/**
 *
 * @author SaCry
 *
 * Abstraktion des Konzepts der relativen Position von Körpern in 3d-Stapeln.
 *
 */
public interface StowageLocation extends AdminValue {

    int bay();

    int row();

    int tier();

    boolean isNull();
}
