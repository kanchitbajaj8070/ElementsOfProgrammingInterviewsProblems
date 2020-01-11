import java.util.HashSet;

public class WordBreak {
    public static void main(String[] args) {
        String s = "iamace";
        HashSet<String> wordDict =new HashSet<>();
        wordDict.add("i");
        wordDict.add( "am");
        wordDict.add("a");
        wordDict.add( "ace");
        boolean [][]dp= new boolean[s.length()][s.length()];
        for (int i = 0; i <s.length() ; i++) {
            dp[i][i]=(wordDict.contains(s.charAt(i)+""));
            //length 1 is done
        }
        for(int l=2;l<=s.length();l++)
        {
            for (int i = 0; i <=s.length()-l ; i++) {
                int j=i+l;
                if(wordDict.contains(s.substring(i,j)))
                {
                    dp[i][j-1]=true;
                    continue;
                }
                for( int k=i+1;k<j;k++)
                {
                    if( dp[i][k-1]&& dp[k][j-1])
                    {
                        dp[i][j-1]=true;
                        break;
                    }
                }
            }
        }
        System.out.println(dp[0][s.length()-1]);
        for (int i = 0; i <s.length() ; i++) {
            System.out.print("    "+s.charAt(i)+"     ");
        }
        System.out.println();
        for (int i = 0; i <s.length() ; i++) {
            for (int j = 0; j < s.length(); j++) {
                if( j==0)
                    System.out.print(s.charAt(i)+"  ");
                System.out.print(dp[i][j]+"     ");
            }
            System.out.println();
        }
    }

}
