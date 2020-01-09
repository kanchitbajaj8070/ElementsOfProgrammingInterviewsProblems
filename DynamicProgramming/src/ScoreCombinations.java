import java.util.Arrays;

public class ScoreCombinations {
    public static void main(String[] args) {
        int []a={2,3,7};
        int score=12;
        int[] []dp= new int [a.length][score+1];
        System.out.println(getCountRecursive(a,score,0));
        for(int[]d:dp)
        Arrays.fill(d,-1);
      //  System.out.println(getCountRecursiveMemoised(a,12,0,dp));
        System.out.println(getCountRecursiveDp(a,score,dp));
    }

    public static int getCountRecursive( int [] a, int score , int curIndex )
    {
        if( score==0)
            return 1;
        if( score<0)
            return 0;
        int ResultOfOneLevel=0;
        for( int j=curIndex;j<a.length;j++)
        {
            ResultOfOneLevel+=getCountRecursive(a,score-a[j],j);
        }
        return ResultOfOneLevel;
        }

    public static int getCountRecursiveMemoised( int [] a, int score , int curIndex,int[][]dp )
    {
        if( score==0)
            return 1;
        if( score<0)
            return 0;
        if(dp[curIndex][score]!=-1)
            return dp[curIndex][score];
        int ResultOfOneLevel=0;
        for( int j=curIndex;j<a.length;j++)
        {
            ResultOfOneLevel+=getCountRecursiveMemoised(a,score-a[j],j,dp);
        }
        dp[curIndex][score]=ResultOfOneLevel;
        return ResultOfOneLevel;
    }
    public static int getCountRecursiveDp( int [] a, int score ,int[][]dp )
    {
    for( int i=0;i<dp.length;i++)
        dp[i][0]=1;
        for (int i = 0; i <dp.length ; i++) {
            for (int j = 1; j <=score; j++) {
              int withoutIncludingThisScore=(i>0)?dp[i-1][j]:0;
              int withIncludingThisScore=(j>=a[i])?dp[i][j-a[i]]:0;
              dp[i][j]=withIncludingThisScore+withoutIncludingThisScore;
            }
        }
        return dp[a.length-1][score];
    }
}
