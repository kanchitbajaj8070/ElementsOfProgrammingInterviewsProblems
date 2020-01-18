import sun.awt.image.ImageWatched;

public class MergeSortedll {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.insert(2);
        l1.insert(7);


        l2.insert(4);
        l2.insert(6);
        //LinkedList l3 = merge(l1, l2);
        //l3.display();
        mergeSpaceOptimised(l1,l2);
    }

    private static LinkedList merge(LinkedList l1, LinkedList l2) {
        LinkedList l3 = new LinkedList();
        LinkedList.Node head1 = l1.head;
        LinkedList.Node head2 = l2.head;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                l3.insert(head1.data);
                head1 = head1.link;
            } else {
                l3.insert(head2.data);
                head2 = head2.link;
            }
        }
        while(head1!=null)
        {
            l3.insert(head1.data);
            head1=head1.link;
        }

        while(head2!=null)
        {
            l3.insert(head2.data);
            head2=head2.link;
        }
        return l3;
    }
    private static void mergeSpaceOptimised(LinkedList l1, LinkedList l2) {
        LinkedList.Node head1 = l1.head;
        LinkedList.Node head2 = l2.head;
        LinkedList.Node prev1 = null;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                prev1=head1;
                head1 = head1.link;
            } else {
                LinkedList.Node t=head2.link;
                if(prev1!=null)
                prev1.link=head2;
                else
                    l1.head=head2;
                head2.link=head1;
                prev1=head2;
                head2 = t;
            }
        }
        while(head2!=null)
        {
           prev1.link=head2;
           prev1=head2;
           head2=head2.link;
        }
     l1.display();
    }
}