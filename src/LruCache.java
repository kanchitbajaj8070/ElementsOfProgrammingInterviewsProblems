import java.util.*;

public class LruCache {
    public static void main(String[] args) {
//int[] pages={ 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
int [] page={4, 7, 6, 1, 7, 6, 1, 2, 7, 2};
//int size =4;
//implementLru(pages,size);
implementLru(page,3);
    }
    public static void implementLru( int []pages, int size)
    { int hits=0;
    int faults=0;
      HashSet<Integer> set= new HashSet<>();
      Deque< Integer> queue= new LinkedList<>();
        int i=0; int j=0;
        while(i<pages.length)
        {
            for(j=i;j<i+size&&j<pages.length;j++)
            {
                if( !set.contains(pages[j]))
                {   faults++;
                    if(queue.size()>=size)
                    {
                    int t= queue.removeLast();
                     set.remove(t);

                    }
                    queue.addFirst(pages[j]);
                    set.add(pages[j]);
                }
                else
                {
                    queue.removeFirstOccurrence(pages[j]);
                    queue.addFirst(pages[j]);
                    hits++;

                }
                System.out.println(queue);
             }
             i+=size;

            }
        System.out.println(hits+"   "+faults);
        }


}