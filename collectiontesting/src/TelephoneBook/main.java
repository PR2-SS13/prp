/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TelephoneBook;

/**
 *
 * @author sacry
 */
public class main {

    public static void main(String[] args) {
        
        AbstractBook ab = new AbstractBook();
        
        Telephone t1 = new Telephone("Germany");
        ab.add(t1);

        Address adr1 = new Address("Germany", "Hamburg", 22085, "Herderstraße", 77);
        Entry e1 = new Entry("Matthias", "Nitsche", "017680210824", adr1);
        t1.add(e1);

        Address adr2 = new Address("Germany", "Hamburg", 123456, "Harburgerstraße", 12);
        Entry e2 = new Entry("Kai", "Brusch", "0156782910", adr2);
        t1.add(e2);
        
        Telephone t2 = new Telephone("Russia");
        ab.add(t2);

        Address adr3 = new Address("Russia", "Moscow", 43564, "Vladivostocstreet", 4);
        Entry e3 = new Entry("Ivan", "chock", "017680210824", adr3);
        t2.add(e3);

        Address adr4 = new Address("Russia", "Moscow", 43564, "Vladivostocstreet", 7);
        Entry e4 = new Entry("Boris", "Berezovsky", "0156782910", adr4);
        t2.add(e4);
        
        System.out.println(ab.toString());
        System.out.println(ab.get("Germany").toString());
        System.out.println(ab.get("Russia").toString());
    }
    
}
