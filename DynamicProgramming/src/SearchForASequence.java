import java.util.*;

public class SearchForASequence {
    public static void main(String[] args) {
        Scanner s= new Scanner( System.in);
        int n=s.nextInt();
        List<List<Integer>> grid= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                grid.get(i).add(s.nextInt());
            }
        }
        List<Integer> pattern= new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            pattern.add(s.nextInt());
        }
        System.out.println(isPossible(grid,pattern));
    }

    private static boolean isPossible(List<List<Integer>> grid, List<Integer> pattern) {
        Set< Attempt> previousAttempt= new HashSet<>();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if(isPossibleHelper(previousAttempt,grid,pattern,i,j,0));
                    return true;
            }
        }
            return false;
    }

    private static boolean isPossibleHelper(Set<Attempt> previousAttempt, List<List<Integer>> grid, List<Integer> pattern, int i, int j,
                                            int length) {
   if( i<0||j<0||j>=grid.size()||i>=grid.size())
    return false;
   if(pattern.size()==length)
       return true;
   if(previousAttempt.contains(new Attempt(i,j,length)))
            return false;
   if( grid.get(i).get(j)==pattern.get(0)&& (
           isPossibleHelper(previousAttempt,grid,pattern,i,j+1,length+1)||
        isPossibleHelper(previousAttempt,grid,pattern,i,j-1,length+1)||
                isPossibleHelper(previousAttempt,grid,pattern,i+1,j,length+1)||
                isPossibleHelper(previousAttempt,grid,pattern,i-1,j,length+1)))
       return true;
   previousAttempt.add( new Attempt(i,j,length));
   return false;
    }

    public static class Attempt
    {
        int x;
        int y;
     int length;
        Attempt( int x, int y,  int length)
        {
            this.x=x;
            this.y=y;
            this.length=length;
        }
    }

}/*
3
1 2 3
3 4 5
5 6 7
1 5 6 7*/
