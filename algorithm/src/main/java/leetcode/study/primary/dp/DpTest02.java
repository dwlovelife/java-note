package leetcode.study.primary.dp;


public class DpTest02 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            int currentPrice = prices[i];
            if(currentPrice <= minPrice){
                minPrice = currentPrice;
                continue;
            }
            maxProfit = Math.max(maxProfit, currentPrice - minPrice);
        }
        return maxProfit;
    }

}
