package DP;//Climbing Stairs
/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

            3
        /       \
      2          1
    /  \        /
   1    0      0
/
0

Total = 3 => dp[n] = dp[n-1] + dp[n-2];

Time Complexity - O(n)
Space Complexity - O(n)

 */

class ClimbingStairs_Solution1 {
    int dp[] = new int[46];
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(dp[n] != 0) return dp[n];
        else return dp[n] = climbStairs(n-1) + climbStairs(n-2);
    }
}


class ClimbingStairs_Solution2 {
    public int climbStairs(int n) {
        int dp[] = new int[n+1] ;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
};



/*
 * Min Cost Climbing Stairs
 * 
 *  You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *  You can either start from the step with index 0, or the step with index 1.
 *  Return the minimum cost to reach the top of the floor.
 * 
 */


class ClimbingStairs_Solution3 {
    int minCost[] = new int[1001];
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for(int i=2; i<=n; i++){
            minCost[i] = Math.min(minCost[i-1]+cost[i-1], minCost[i-2]+cost[i-2]);
        }
        
        return minCost[n];
    }
}