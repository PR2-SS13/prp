/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontesting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author sacry
 */
public class invaraiantChecks {

    
    public static List<String> interleave(List<String> l1, List<String> l2) {
        
        List<String> result = new ArrayList<>();
        
        Iterator<String> it2 = l2.iterator();
        for (Iterator<String> it1 = l1.iterator(); 
                it1.hasNext() || it2.hasNext();) {
            
            if (it1.hasNext())
                result.add(it1.next());
            if (it2.hasNext())
                result.add(it2.next());
            
        }
        return result;
    }
    
    
}
