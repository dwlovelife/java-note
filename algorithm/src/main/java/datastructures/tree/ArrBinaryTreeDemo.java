package datastructures.tree;

/**
 * 编写一个ArrayBinaryTree 实现顺序存储的二叉树遍历
 * 顺序存储二叉树的特点
 * 1).顺序二叉树通常只考虑完全二叉树
 * 2).第n个元素的左子节点为 2*n + 1
 * 3).第n个元素的右子节点为 2*n + 2
 * 4).第n个元素的父节点为 (n - 1)/2
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        /**
         *       1
         *    2      3
         * 4    5  6    7
         */
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preErgodic(0);
    }
}

class ArrBinaryTree {
    private int[] arr;//存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //编写一个方法完成顺序存储的二叉树前序遍历
    public void preErgodic(int index) {
        //如果数组为空或者arr.length = 0
        checkArrIsIllegal(arr);
        //输出当前这个元素
        System.out.println(arr[index]);
        if (2 * index + 1 < arr.length) {
            preErgodic(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            preErgodic(2 * index + 2);
        }
    }

    public void infixErgodic(int index) {
        checkArrIsIllegal(arr);
        if (2 * index + 1 < arr.length) {
            infixErgodic(2 * index + 1);
        }
        System.out.println(arr[index]);
        if (2 * index + 2 < arr.length) {
            infixErgodic(2 * index + 2);
        }
    }

    public void postErgodic(int index) {
        checkArrIsIllegal(arr);
        if (2 * index + 1 < arr.length) {
            postErgodic(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            postErgodic(2 * index + 2);
        }
        System.out.println(arr[index]);
    }

    private void checkArrIsIllegal(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空,不能按照二叉树的前序遍历");
        }
    }


}
