public class LinkedList {
    public class Node
    {
        public int data;
        public Node link;
        Node(int data)
        {
            this.data=data;
        }
        Node()
        {}
    }

    public Node head;
    public void insert( int data)
    {
        insert(head,data);
    }

    private void insert(Node trav, int data) {
    if( trav==null)
    {
        this.head = new Node(data);
    }else
    {
        Node tail=head;
        while(tail.link!=null) tail=tail.link;
        Node nn= new Node( data);
        tail.link=nn;
    }
    }

    public void display()
    {
        display(this.head);
    }

    private void display(Node head) {
    if( head==null) {
        System.out.println();
        return;
    }
        System.out.print(head.data+" -> ");
    display(head.link);
    }
    public void reverse()
    {
       reverse(this.head);
    }

    private void reverse(Node trav) {
        if( trav.link==null) {
         this.head=trav;
         return;
        }
        reverse(trav.link);
        trav.link.link=trav;
        trav.link=null;
    }
    public void Itreverse()
    {
        Iterativereverse(this.head);
    }
    private void Iterativereverse(Node trav) {
       Node prev=null;
       Node cur=trav;
       Node next=null;
       while( cur!=null)
       {
           next=cur.link;
            cur.link=prev;
            prev=cur;
            cur=next;
       }
       this.head=prev;
    }
    public void kreverseRecursive( int k)
    {
    this.head=    kreverseRecursive(this.head,k);
    }

    private Node kreverseRecursive(Node trav,int k)
    {   if(trav==null)
        return null;
        Node prev=null;
        Node cur=trav;
        Node old_head=trav;
        Node next=cur.link;
        int c=1;
        while(c<=k&&cur!=null)
        {
         next=cur.link;
         cur.link=prev;
         prev=cur;
         cur=next;
         c++;
        }
        old_head.link=kreverseRecursive(cur,k);
        return prev;// old head of first segments point to prev( or new head ) of the next segment

    }
     private Node get( int index)
    {
        Node trav=this.head;
        if( trav==null)
            return null;
        for(int i=1;i<=index;i++)
            trav=trav.link;
        return trav;
    }
public void delete( int data)
{

    Node trav=this.head;
    if(trav==null)
        return;
    if( trav.link==null)
    {
        head=null;
        return;
    }
    Node prev=null;
    while( trav.data!=data) {
        prev=trav;
        trav=trav.link;
    }
    if( prev==null)
        head=trav.link;
    else
    prev.link=trav.link;
}
public int nthNodeFromEnd(int index)
{
 Node slow=this.head;
 Node fast=this.head;

 while(index>0)
 {
     index--;
     fast=fast.link;
 }
 while(fast!=null)
 {
     slow=slow.link;
     fast=fast.link;
 }
 return slow.data;
}

public void segregateOddEvenNodeOrderDoesntMatter( )
{
    segregateOddEvenNodeOrderDoesntMatter(this.head,null);
    display();
}
public Node tailHelper=null;
    private void segregateOddEvenNodeOrderDoesntMatter(Node head,Node prev) {

        if(head.link==null)
        {
            tailHelper=head;
            return;
        }
        int f=0;
        if(head.data%2==1)
            f=1;
        segregateOddEvenNodeOrderDoesntMatter(head.link,head);
        if( f==1)
        {
            tailHelper.link=head;
            if(prev!=null)
                prev.link=head.link;
            else
                this.head=head.link;
            head.link=null;
            tailHelper=head;
        }

    }


    public void seperateOddEvenOrderSame()
    {  Node evenHead=null,evenTail=null ,oddHead=null,oddTail=null;
    Node prev=null;
    Node trav=this.head;
    while( trav!=null)
    {
        if(trav.data%2==1)
        {
            if(oddHead==null)
            {
                oddHead=trav;
                oddTail=trav;
            }
            else
            {
                oddTail.link=trav;
                oddTail=trav;
            }

        }
        else {
            if (evenHead == null) {
                evenHead = trav;
                evenTail = trav;
            } else {
                evenTail.link = trav;
                evenTail = trav;
            }

        }
     Node t=trav.link;
        trav.link=null;
        trav=t;
    }
    if(evenTail!=null) {
        evenTail.link = oddHead;
        this.head = evenHead;
    }
    else
        this.head=oddHead;
        display();
    }

}
