/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.awt.*;
/**
 *
 * @author kbrusch
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // System.out.println(sumTo(5));
       // System.out.println(sumEvenTo(5));
       // System.out.println(sumOddTo(5));
        String [] coaster = new String[3];
        coaster[0] = "asdasd";
        coaster[1] = "bbbb";
        Dimension o = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(o.width+" "+o.height);
    }

    
    public static int len(String b){
    
           return b.length();
    }
    
    
    public static int sumTo(int n) {
        int sum = 0;
        for (int x = 1; x <= n; x++) {
            sum = sum + x;
        }
        return sum;
    }

    static int sumEvenTo(int n) {
        int sum = 0;
        for (int x = 1; x <= n; x++) {
            if (x % 2 == 0) {
                sum = sum + x;
            }
        }
        return sum;
    }

    static int sumOddTo(int n) {
        int sum = 0;
        for (int x = 1; x <= n; x++) {
            if (x % 2 != 0) {
                sum = sum + x;
            }
        }
        return sum;
    }
}
