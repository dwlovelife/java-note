package datastructures.arr;

import static datastructures.util.DataStructureUtil.arrIsEmpty;

/**
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //假设先声明一个数组作为棋盘,棋盘上有两个若干棋子
        int[][] originArr = new int[11][10];
        originArr[2][3] = 1;
        originArr[3][4] = 1;
        //打印数组
        printArr(originArr);
        int[][] elements = getSparseArray(originArr);
        printArr(elements);
    }

    /**
     * 获取一个稀疏数组
     */
    private static int[][] getSparseArray(int[][] elements) {
        boolean isEmpty = arrIsEmpty(elements);
        //如果数组是空,那么也办法转换为稀疏数组,则原样返回
        if (isEmpty) {
            return elements;
        }
        int sum = 0;
        for (int[] element : elements) {
            for (int j : element) {
                if(j != 0) {
                    ++sum;
                }
            }
        }
        //已经求得sum总数那么,有列数为3,行数为sum + 1,由此创建一个二维数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = elements.length;     //行
        sparseArr[0][1] = elements[0].length;    //列
        sparseArr[0][2] = sum;    //值
        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                if(elements[i][j] != 0){
                    sparseArr[++count][0] =  i;
                    sparseArr[count][1] =  j;
                    sparseArr[count][2] =  elements[i][j];
                }
            }
        }
        return sparseArr;
    }

    private static void printArr(int[][] elements){
        for(int i = 0 ; i < elements.length;i++){
            for(int j = 0; j < elements[i].length;j++){
                System.out.print(elements[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }

}
