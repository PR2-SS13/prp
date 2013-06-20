/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author sacry
 */
public class CollectionExcercises {

    public static void main(String[] args) {
        
        Collection<Object> coll1 = new ArrayList<Object>(Arrays.asList("a", "b"));
        Collection<Object> coll2 = new ArrayList<Object>(Arrays.asList("a", "b"));
        Collection<Object> coll3 = new LinkedList<Object>(Arrays.asList("a", "b"));
        Collection<Object> coll4 = new ArrayList<Object>(Arrays.asList("a", "b"));
        coll2.add(coll3);
        coll1.add(coll2);
        coll3.add(coll4);
        System.out.println(maxDebth(coll1));

        ArrayList<Object> l1 = new ArrayList<Object>(Arrays.asList("a", "b"));
        ArrayList<Object> l2 = new ArrayList<Object>(Arrays.asList("c", "d"));
        ArrayList<Object> l3 = new ArrayList<Object>(Arrays.asList("e", "f"));
        ArrayList<Object> l4 = new ArrayList<Object>(Arrays.asList("g", "h"));
        l2.add(l3);
        l1.add(l2);
        l1.add(l4);
        System.out.println(deepReverse(l1));
        System.out.println(l1);
    }

    public static int maxDebth(Collection<?> coll) {
        int max = 0;
        for (Object o : coll) {
            if (o instanceof Collection) {
                max = Math.max(maxDebth((Collection<?>) o) + 1, max);
            }
        }
        return max;
    }

    public static List<Object> deepReverse(List<Object> list) {
        List<Object> al = new ArrayList<>();
        for (ListIterator iterator = list.listIterator(list.size()); 
                iterator.hasPrevious();) {
            Object listElement = iterator.previous();
            if(listElement instanceof List){
                al.add(deepReverse((List<Object>)listElement));
            } else {
                al.add(listElement);
            }
        }
        return al;
    }
}
