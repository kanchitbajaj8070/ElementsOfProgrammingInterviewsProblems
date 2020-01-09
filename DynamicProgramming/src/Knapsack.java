public class Knapsack {
    public static void main(String[] args) {
        int [] weights={5,3,4,2};
        int[] prices={60,50,70,30};
        int capacity=6;
        System.out.println(knapsackDp(prices,weights,capacity));
    }

    private static int knapsackRecursive(int[] weights, int[] prices, int capacity, int i) {

        if( i==prices.length)
            return 0;
        if( capacity==0)
            return 0;
        int noincluding=Integer.MIN_VALUE;
        int including=Integer.MIN_VALUE;
        if(weights[i]<=capacity)
            including=knapsackRecursive(weights,prices,capacity-weights[i],i+1)+prices[i];
        noincluding=knapsackRecursive(weights,prices,capacity,i+1);
        return Math.max(including,noincluding);

    }
    public static int knapsackDp( int [] prices,int [] weights,int capacity)
    {
        int [][]dp=new int [prices.length+1][capacity+1];
        for (int i = 0; i <=capacity ; i++) {
            dp[0][i]=0;//no elements no profit
        }
        for (int i = 0; i <=prices.length ; i++) {
            dp[i][0]=0;//o capacity
        }

        for (int i = 1; i <=prices.length ; i++) {
            for (int j = 1; j <= capacity; j++) {
                int include = 0;
                int exclude = 0;
                exclude = dp[i - 1][j];
                if (j >=weights[i-1])
                    include = dp[i-1][j - weights[i-1]] + prices[i - 1];
                dp[i][j] = Math.max(include, exclude);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
                return dp[prices.length][capacity];
        }

    }
