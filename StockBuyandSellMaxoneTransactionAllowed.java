// User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
        int minSoFar = prices[0];
        int res = 0;
        
        for (int i = 1; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            res = Math.max(res, prices[i] - minSoFar);
        }
        return res;
    }
}