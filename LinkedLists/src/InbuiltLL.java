import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class InbuiltLL {
    public static void main(String[] args) {
        LinkedList<Integer> l= new LinkedList<>();
        l.add(1);
        l.add(2);
        System.out.println(l);
        l.remove(1);// index is passed in linked lists
        System.out.println(l);
        l.remove(l.get(0));
        l.add(2);
        System.out.println(l);
        ListIterator<Integer> l1 =l.listIterator();
        System.out.println(l1.next());
        System.out.println(l1.hasNext());
        l.set(0,3);
        System.out.println(l);
        System.out.println(l.contains(3));
        //poll- remove and no exceptio
        // remove - exception if list is empty
        //peek- only gets the element without removing
        l.add(5);
        l.add(4);
        l.add(2);
        System.out.println(l);
        System.out.println(l.removeFirst());
        System.out.println(l.removeLast());
        System.out.println(l);
        System.out.println(l.removeFirstOccurrence(4));
        System.out.println(l.removeLastOccurrence(5));
        System.out.println(l.pollFirst());
        //System.out.println(l.remove());// throws exception when empty
        l.add(1);
        l.add(2);
        l.add(3); l.add(4);
        System.out.println(l.subList(2,4));
        l.sort(Collections.reverseOrder());
        System.out.println(l);
       Collections.rotate(l,2);
        System.out.println(l);
    }
}
