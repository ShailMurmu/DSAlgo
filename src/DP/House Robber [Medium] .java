package DP;// House Robber
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and 
it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.


For Every house, Either choose to rob or skip it.
1. If choosen -> sum = max sum till (i-2) + current house
2. If Skipped -> sum = max sum till (i-1) + 0

TC - O(n)
SC - O(n)

 */

class HouseRobber_Solution1 {
    public int rob(int[] nums) {
        int n = nums.length;
        int dpAmt[] = new int[n];
        
        if(n == 1) return nums[0];
        dpAmt[0] = nums[0];
        dpAmt[1] = Math.max(nums[1], nums[0]);
        
        for(int i=2; i<n; i++) {
            dpAmt[i] = Math.max(nums[i]+dpAmt[i-2], dpAmt[i-1]);
        }
        
        return dpAmt[n-1];
    }
}



// House Robber II

/*
 * House are in Circular order.
 * A - B - C - D
 * |           |
 * H - G - F - E
 *    
 * 1 2 3 1
 * 
 * We either have to start looting the house from 1st House then Skip the Last House as it is adjacent to 1st House --> max at dp1[n-1]
 * OR
 * We Can start looting the house from end (n-1)th house then We have to Skip 1st House as it is adjacent to Last house. --> max at dp1[1]
 * 
 * We can take the max of either of the possible loot sequence i.e. max ( dp1[n-1] , dp2[1] )
 */


class HouseRobber_Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[n-1] = nums[n-1];
        dp2[n-2] = Math.max(nums[n-1], nums[n-2]);
        
        for(int i=2; i<n-1; i++){
            dp1[i] = Math.max(nums[i]+dp1[i-2], dp1[i-1]);
            dp2[n-i-1] = Math.max(nums[n-i-1]+dp2[n-i+1], dp2[n-i]);
        }
        
        return Math.max(dp1[n-2], dp2[1]);
    }
}