package leetcode.level.easy;


import java.util.Arrays;
import java.util.PriorityQueue;

public class MyCode1046 {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(lastStoneWeight(arr));
    }


    public static int lastStoneWeight(int[] stones) {
       int index = stones.length - 1;
       if(index == 0){
           return stones[index];
       }
       for(int i = 0; i < stones.length; i++){
           Arrays.sort(stones);
           if(stones[index - 1] == 0) {
               break;
           }
           stones[index] -= stones[index - 1];
           stones[index - 1] = 0;
       }
       return stones[index];
    }

    public static int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if(a > b){
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

}
