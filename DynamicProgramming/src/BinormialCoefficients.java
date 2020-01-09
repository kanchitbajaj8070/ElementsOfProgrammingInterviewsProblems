public class BinormialCoefficients {
    public static void main(String[] args) {
        System.out.println(Commbinations(5,2));
    }
    public static int Commbinations( int n, int r)
    {
        int [][]dp=new int [n+1][r+1];

        for( int i=1;i<=r;i++)
            dp[0][i]=0;
        for (int i = 1; i <=n ; i++)
            dp[i][0]=1;
        dp[0][0]=0;
        for( int i=1;i<=n;i++)
        {
            for( int j=1;j<=r;j++)
            {       if(i==j)
             {
                dp[i][j]=1;
                continue;
             }
                dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
            }
        }
        return dp[n][r];
    }
}

