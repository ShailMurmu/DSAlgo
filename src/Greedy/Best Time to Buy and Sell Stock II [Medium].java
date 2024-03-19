package Greedy;

class StockBuySell2 {
    public int maxProfitSol2(int[] prices) {
        int maxProfit = 0;
        int minIdx = 0;
        int maxIdx = 1;
        int tempProfit = 0;

        while(maxIdx < prices.length) {
            if(prices[maxIdx-1] < prices[maxIdx]) {
                tempProfit = Math.max(tempProfit, prices[maxIdx] - prices[minIdx]);
            }
            else{
                maxProfit = maxProfit + (prices[maxIdx-1] - prices[minIdx]);
                minIdx = maxIdx;
                tempProfit = 0;
            }
            maxIdx++;
        }

        if(tempProfit > 0) return maxProfit + tempProfit;
        else return maxProfit;
    }


    /*
    Using Greedy Algorithm:
    We approach this problem greedily by maximizing profit at each opportunity.
    Since we can buy and sell on the same day if there's a price increase,
    instead of looking for the overall optimal solution,
    we focus on maximizing profit at each step, which eventually leads to the maximum overall profit.
    */

    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        int days = prices.length;
        for(int i=1;i<days;i++) {
            if(buy < prices[i]) profit += prices[i] - buy;
            buy = prices[i];
        }
        return profit;
    }
}
