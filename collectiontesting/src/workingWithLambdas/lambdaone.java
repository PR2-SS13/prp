/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workingWithLambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sacry
 */
public class lambdaone {

    public static void main(String[] args) {

        Lambda<Integer> lambda = new Lambda<Integer>() {
            public <T> boolean test(T t) {
                return (Integer) t > 5 && (Integer) t < 10;
            }
        };

        printGeneric(new ArrayList<>(Arrays.asList(5, 4, 6, 9, 9, 10)), lambda);

    }

    public static <T> void printGeneric(List<T> list,
            Lambda<T> predicate) {
        for (T t : list) {
            if (predicate.test(t)) {
                System.out.println(t);
            }
        }
    }
}
