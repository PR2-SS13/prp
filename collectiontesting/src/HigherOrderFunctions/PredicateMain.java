/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HigherOrderFunctions;

import static HigherOrderFunctions.TestStructures.*;
import static HigherOrderFunctions.HigherOrderFunctions.filter;
import static HigherOrderFunctions.HigherOrderFunctions.any;
import static HigherOrderFunctions.HigherOrderFunctions.all;
import static HigherOrderFunctions.HigherOrderFunctions.partition;
import static HigherOrderFunctions.HigherOrderFunctions.firstIndexFor;
import java.util.List;

/**
 *
 * @author sacry
 */
public class PredicateMain {

    public static void main(String[] args) {

        List<Integer> lfilter;
        lfilter = filter(nList(5,6,7,8,9,10), new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t > 5 && t < 10;
            }
        });

        System.out.println("filter (t > 5 && t < 10): " + lfilter);

        List<List<String>> lpartition;
        lpartition = partition(nList("Hello", "You", "Fucked", "Up", "World", "!"), 
                new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t.length() <= 3;
            }
        });

        System.out.println("partition (List<List<String>>): " + lpartition);

        boolean lany;
        lany = any(nList("Hello", "You", "Fucked", "Up", "World", "!"), 
                new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t.length() == 3;
            }
        });

        System.out.println("any (str.length == 3): " + lany);

        boolean lall;
        lall = all(nList("Hello", "You", "Fucked", "Up", "World", "!"), 
                new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t.length() == 3;
            }
        });

        System.out.println("all (str.length == 3): " + lall);

        int firstIndex;
        firstIndex = firstIndexFor(nList("Hello", "You", "Fucked", "Up", "World", "!"), 
                new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t.length() == 1;
            }
        });

        System.out.println("firstIndexFor (str.length == 3): " + firstIndex);

    }
}
