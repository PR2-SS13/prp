/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.vehicle;

import interfaces.logistics.traits.WithUniqueId;
import interfaces.logistics.traits.WithStowLoc;
import interfaces.logistics.traits.WithForm;
import interfaces.Immutable;

/**
 *
 * @author SaCry
 *
 * Eine ADT für Paletten, deren Inhalt hier nicht weiter modelliert werden soll.
 * Wäre aber natürlich möglich und sinnvoll.
 */
public interface Pallet extends Immutable, Body, WithUniqueId<Pallet>,
        WithStowLoc, WithForm, Comparable<Pallet> {
}
