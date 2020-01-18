import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedList list= new LinkedList();
        Random r= new Random(11);
        //list.insert(77);
        for (int i = 1; i <= 10; i+=2) {
            list.insert(i);
        }
        //list.Itreverse();
        //list.display();
        //list.kreverseRecursive(6);
        list.display();
        list.seperateOddEvenOrderSame();
      // list.segregateOddEvenNodeOrderDoesntMatter();
        // System.out.println(list.nthNodeFromEnd(3));
      /*  list.delete(2);
        list.display();
        list.delete(0);
        list.display();
        list.delete(9);
        list.display();*/
    }
}
