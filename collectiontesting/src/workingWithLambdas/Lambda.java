/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workingWithLambdas;

/**
 *
 * @author sacry
 */
public interface Lambda<T> {

    <T> boolean test(T t);
}
