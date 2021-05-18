package leetcode.stack;

import datastructures.stack.Stack;

public class LeetCode739 {


    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length < 1) return T;
        int[] result = new int[T.length];
        for(int i = 0; i < T.length; i++){
            for(int j = i + 1; j < T.length; j++){
                if(T[j] > T[i]){
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

}
