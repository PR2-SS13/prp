/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HigherOrderFunctions;

/**
 *
 * @author sacry
 */
public interface ReduceFunction<F, T> {

    T apply(T a, F b);
}
