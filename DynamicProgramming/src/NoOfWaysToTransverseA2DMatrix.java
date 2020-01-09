import java.lang.reflect.Array;
import java.util.Arrays;

public class NoOfWaysToTransverseA2DMatrix {
    public static void main(String[] args) {
        int rows=5;
        int cols=5;
        System.out.println(countWaysSpaceOptimised(5,5));
    }
    public static int countWays( int r, int c)
    {
        int[][] dp= new int[r][c];
        for (int i = 0; i <r ; i++) {
            dp[i][0]=1;//for only bottom
        }
        for (int i = 0; i < c; i++) {
            dp[0][i]=1;//only right
        }
        for (int i = 1; i <r ; i++) {
            for (int j = 1; j <c ; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
            }
            return dp[r-1][c-1];
    }
    public static int countWaysSpaceOptimised( int r, int c)
    {
        int prevleft=1;
        int prevup[]= new int[c];
        Arrays.fill(prevup,1);
        int cur=0;
        for (int i = 1; i <r ; i++) {
            prevleft=1;
            for (int j = 1; j <c ; j++) {
               cur=prevleft+prevup[j];
                   prevup[j]=cur;
               prevleft=cur;
            }
        }
        return cur;
    }
}

