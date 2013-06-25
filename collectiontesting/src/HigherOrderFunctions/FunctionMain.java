/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HigherOrderFunctions;

import static HigherOrderFunctions.TestStructures.*;
import static HigherOrderFunctions.HigherOrderFunctions.map;
import static HigherOrderFunctions.HigherOrderFunctions.mapFilter;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author sacry
 */
public class FunctionMain {

    public static void main(String[] args) {

        List<?> lmap;
        lmap = map(nList(5, 4, 6, 9, 9, 10), new Function<Integer>() {
            @Override
            public Integer apply(Integer t) {
                return t + 5;
            }
        });

        System.out.println("map (+5): " + lmap);

        Collection<Integer> cmapfilter;
        cmapfilter = mapFilter(nList(5, 4, 6, 9, 9, 10),
                new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t > 5 && t < 10;
            }
        },
                new Function<Integer>() {
            @Override
            public Integer apply(Integer t) {
                return t + 5;
            }
        });

        System.out.println("map + filter (combined above): " + cmapfilter);
    }
}
