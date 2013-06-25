/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HigherOrderFunctions;

import static HigherOrderFunctions.TestStructures.*;
import static HigherOrderFunctions.HigherOrderFunctions.reduce;
import java.util.HashSet;

/**
 *
 * @author sacry
 */
public class ReduceMain {

    public static void main(String[] args) {

        Double lreduce;
        lreduce = reduce(nList(2.0, 3.0, 4.0), new ReduceFunction<Double, Double>() {
            @Override
            public Double apply(Double a, Double b) {
                return a + b;
            }
        }, 0.0);

        System.out.println("reduce (sum of doubles): " + lreduce);

        HashSet<Double> lreduce2;
        lreduce2 = reduce(nList(2.0, 3.0, 4.0), new ReduceFunction<Double, HashSet<Double>>() {
            @Override
            public HashSet<Double> apply(HashSet<Double> a, Double b) {
                a.add(b);
                return a;
            }
        }, new HashSet<Double>());

        System.out.println("reduce (List to Set): " + lreduce2);

        String lreduce3;
        lreduce3 = reduce(nList("Hello", "You", "Fucked", "Up", "World", "!"),
                new ReduceFunction<String, String>() {
            @Override
            public String apply(String a, String b) {
                return a + (!"!".equals(b)
                        && !"Hello".equals(b) ? " " : "") + b;
            }
        }, "");

        System.out.println("reduce (List<String> to String): " + lreduce3);

        Double lreduce4;
        lreduce4 = reduce(new ReduceFunction<Double, Double>() {
            @Override
            public Double apply(Double a, Double b) {
                return a + b;
            }
        }, 0.0, 10.0, 10.0, 10.0, 10.0);

        System.out.println("reduce2 (4x 10.0 to sum): " + lreduce4);

        Double lreduce5;
        lreduce5 = reduce(new ReduceFunction<Double, Double>() {
            @Override
            public Double apply(Double a, Double b) {
                return a + b;
            }
        }, 0.0, nList(2.0, 3.0, 4.0), nList(2.0, 3.0, 4.0), nList(2.0, 3.0, 4.0));

        System.out.println("reduce3 (3x Double List to sum): " + lreduce5);

        HashSet<Double> lreduce6;
        lreduce6 = reduce(new ReduceFunction<Double, HashSet<Double>>() {
            @Override
            public HashSet<Double> apply(HashSet<Double> a, Double b) {
                a.add(b);
                return a;
            }
        }, new HashSet<Double>(), nList(2.0, 3.0, 4.0), nList(2.0, 3.0, 4.0),
                nList(2.0, 3.0, 4.0));

        System.out.println("reduce (Lists to Set): " + lreduce6);
    }
}
