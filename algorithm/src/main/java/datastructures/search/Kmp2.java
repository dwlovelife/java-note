package datastructures.search;

public class Kmp2 {
    public static void main(String[] args) {

    }

    public static int[] kmpNext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i = 1, j = 0; i < dest.length(); i++){
            while(j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
