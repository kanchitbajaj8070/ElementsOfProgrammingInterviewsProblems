public class LevensiteinDistance {
    public static void main(String[] args) {
       String str1="CARTHORSE";
       String str2="ORCHESTRA";
        //System.out.println(recursiveEditDistance(str1,str2,str1.length()-1,str2.length()-1));

        System.out.println(minEditDp(str1,str2));
    }
    public static int recursiveEditDistance( String src, String dest, int i, int j)
    {
        if( i==0)
            return j+1;
        if( j==0)
            return i+1;
        if(src.charAt(i)==dest.charAt(j))
            return recursiveEditDistance(src,dest,i-1,j-1);
        else {
            int result = Integer.MAX_VALUE;
            int insert_res = recursiveEditDistance(src, dest, i, j - 1);
            int delete_res = recursiveEditDistance(src, dest, i - 1, j);
            int replace_res = recursiveEditDistance(src, dest, i - 1, j - 1);
            result = 1 + Math.min(insert_res, Math.min(delete_res, replace_res));
            return result;
        }
    }
    public static int minEditDp( String src, String dest)
    {
        int m=src.length();
        int n=dest.length();
        int [][]dp=new int [m+1][n+1];
        for (int i = 1; i <=m; i++) {
            dp[i][0]=i;
        }
        for( int i=1;i<=n;i++)
            dp[0][i]=i;
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if( src.charAt(i-1)==dest.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                {
                   dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        getStepsToTransform(dp,src,dest);
        return dp[m][n];
    }
    public static void getStepsToTransform( int [][]dp,String src, String dest)
    {
      int i = src.length();
            int j = dest.length();
            while( i>0&&j>0)
            {
                if(src.charAt(i-1)==dest.charAt(j-1)) {
                    i--;
                    j--;
                }
                else {
                    int temp = dp[i][j];
                    int ins = dp[i][j - 1];
                    int del = dp[i - 1][j];
                    int rep = dp[i - 1][j - 1];
                    if (temp == ins + 1) {
                        System.out.println(" Insert " + dest.charAt(j - 1));
                        j--;
                    } else if (temp == del + 1) {
                        System.out.println("Delete " + src.charAt(i - 1));
                        i--;
                    } else if (temp == rep + 1) {
                        System.out.println(" Replace " + src.charAt(i - 1) + " with " + dest.charAt(j - 1));
                        i--;
                        j--;
                    } else {
                        i--;
                        j--;
                    }
                }
            }
        }

    }

