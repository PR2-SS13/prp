/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HigherOrderFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author sacry
 */
public class HigherOrderFunctioning {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>(Arrays.asList(5, 4, 6, 9, 9, 10));
        List<String> strings = new ArrayList<>(Arrays.asList("Hello", "You", "Fucked", "Up", "World", "!"));
        List<Double> doubles = new ArrayList<>(Arrays.asList(2.0, 3.0, 4.0));
        System.out.println("Integer List: " + integers);
        System.out.println("String List: " + strings);
        System.out.println("Double List: " + doubles);

        List<?> lmap;
        lmap = map(integers, new Function<Integer>() {
            @Override
            public Integer apply(Integer t) {
                return t + 5;
            }
        });

        System.out.println("map (+5): " + lmap);

        List<Integer> lfilter;
        lfilter = filter(integers, new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t > 5 && t < 10;
            }
        });

        System.out.println("filter (t > 5 && t < 10): " + lfilter);

        List<List<String>> lpartition;
        lpartition = partition(strings, new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t.length() <= 3;
            }
        });

        System.out.println("partition (List<List<String>>): " + lpartition);

        boolean lany;
        lany = any(strings, new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t.length() == 3;
            }
        });

        System.out.println("any (str.length == 3): " + lany);
        
        boolean lall;
        lall = all(strings, new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t.length() == 3;
            }
        });

        System.out.println("all (str.length == 3): " + lall);
        
        int firstIndex;
        firstIndex = firstIndexFor(strings, new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t.length() == 1;
            }
        });

        System.out.println("firstIndexFor (str.length == 3): " + firstIndex);
        
        Collection<Integer> cmapfilter;
        cmapfilter = mapFilter(integers, new Predicate<Integer>() {
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

        Double lreduce;
        lreduce = reduce(doubles, new ReduceFunction<Double, Double>() {
            @Override
            public Double apply(Double a, Double b) {
                return a + b;
            }
        }, 0.0);

        System.out.println("reduce (sum of doubles): " + lreduce);

        HashSet<Double> lreduce2;
        lreduce2 = reduce(doubles, new ReduceFunction<Double, HashSet<Double>>() {
            @Override
            public HashSet<Double> apply(HashSet<Double> a, Double b) {
                a.add(b);
                return a;
            }
        }, new HashSet<Double>());

        System.out.println("reduce (List to Set): " + lreduce2);

        String lreduce3;
        lreduce3 = reduce(strings, new ReduceFunction<String, String>() {
            @Override
            public String apply(String a, String b) {
                return a + (!"!".equals(b)
                        && !"Hello".equals(b) ? " " : "") + b;
            }
        }, "");

        System.out.println("reduce (List<String> to String): " + lreduce3);

        Double lreduce4;
        lreduce4 = reduce2(new ReduceFunction<Double, Double>() {
            @Override
            public Double apply(Double a, Double b) {
                return a + b;
            }
        }, 0.0, 10.0, 10.0, 10.0, 10.0);

        System.out.println("reduce2 (4x 10.0 to sum): " + lreduce4);

        Double lreduce5;
        lreduce5 = reduce3(new ReduceFunction<Double, Double>() {
            @Override
            public Double apply(Double a, Double b) {
                return a + b;
            }
        }, 0.0, doubles, doubles, doubles);

        System.out.println("reduce3 (3x Double List to sum): " + lreduce5);
    }

    public static <T, F> F reduce3(ReduceFunction<T, F> red, F accu, List<T>... t) {
        for (List<T> elem : t) {
            accu = reduce(elem, red, accu);
        }
        return accu;
    }

    public static <T, F> F reduce2(ReduceFunction<T, F> red, F accu, T... t) {
        for (T elem : t) {
            accu = red.apply(accu, elem);
        }
        return accu;
    }

    public static <T, F> F reduce(List<T> l, ReduceFunction<T, F> red, F accu) {
        for (T t : l) {
            accu = red.apply(accu, t);
        }
        return accu;
    }

    public static <T> Collection<T> mapFilter(Collection<T> coll,
            Predicate<T> predicate, Function<T> funct) {
        Collection<T> coll2 = new ArrayList<>();
        for (T t : coll) {
            if (predicate.test(t)) {
                coll2.add(funct.apply(t));
            }
        }
        return coll2;
    }

    public static <T> List<T> map(List<T> list, Function<T> funct) {
        List<T> l = new ArrayList<>();
        for (T t : list) {
            l.add(funct.apply(t));
        }
        return l;
    }

    public static <T> List<T> filter(List<T> list,
            Predicate<T> predicate) {
        List<T> l = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                l.add(t);
            }
        }
        return l;
    }

    public static <T> List<List<T>> partition(List<T> list,
            Predicate<T> predicate) {
        List<T> l1 = new ArrayList<>();
        List<T> l2 = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                l1.add(t);
            } else {
                l2.add(t);
            }
        }
        return new ArrayList<>(Arrays.asList(l1, l2));
    }

    public static <T> boolean any(List<T> list,
            Predicate<T> predicate) {
        for (T t : list) {
            if (predicate.test(t)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean all(List<T> list,
            Predicate<T> predicate) {
        for (T t : list) {
            if (!predicate.test(t)) {
                return false;
            }
        }
        return true;
    }

    public static <T> int firstIndexFor(List<T> list,
            Predicate<T> predicate) {
        for (int index = 0; index < list.size(); index++) {
            if (predicate.test(list.get(index))) {
                return index;
            }
        }
        return -1;
    }
}
