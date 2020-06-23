package datastructures.tree;


public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先需要创建一个二叉树
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        /*
         *  创建需要的节点
         *      1
         *  2      3
         *      5    4
         */
        Node<Integer> root = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);

        //说明.先手动创建该二叉树,后面再采取用递归的方式创建二叉树
        root.left = node2;
        root.right = node3;
        node3.left = node5;
        node3.right = node4;
        binaryTree.setRoot(root);
//        System.out.println("下面开始二叉树遍历");
//        System.out.println("---前序遍历---");
//        binaryTree.preErgodic(); //前序遍历 1 2 3 5 4
//        System.out.println("---中序遍历---");
//        binaryTree.infixErgodic(); //中序遍历 2 1 5 3 4
//        System.out.println("---后序遍历---");
//        binaryTree.postErgodic(); //后序遍历 2 5 4 3 1

        Node<Integer> node = binaryTree.infixSearch(5);
        System.out.println(node);
    }
}

class BinaryTree<E> {
    private Node<E> root;

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preErgodic() {
        if (root != null) {
            root.preErgodic();
        }
    }

    /**
     * 中序遍历
     */
    public void infixErgodic() {
        if (root != null) {
            root.infixErgodic();
        }
    }

    /**
     * 后序遍历
     */
    public void postErgodic() {
        if (root != null) {
            root.postErgodic();
        }
    }

    /**
     * 前序查找
     */
    public Node<E> preSearch(E e){
        if(root != null){
            return root.preSearch(e);
        }
        return null;
    }

    public Node<E> infixSearch(E e){
        if(root != null){
            return root.infixSearch(e);
        }
        return null;
    }

    public Node<E> postSearch(E e){
        if(root != null){
            return root.postSearch(e);
        }
        return null;
    }

}

//先创建Node 节点
class Node<E> {
    Node<E> left;
    Node<E> right;
    private E e;

    Node(E e) {
        this.e = e;
    }

    /**
     * 前序遍历
     */
    void preErgodic() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preErgodic();
        }
        if (this.right != null) {
            this.right.preErgodic();
        }
    }

    /**
     * 中序遍历
     */
    void infixErgodic() {
        if (this.left != null) {
            this.left.infixErgodic();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixErgodic();
        }
    }

    /**
     * 后序遍历
     */
    void postErgodic() {
        if (this.left != null) {
            this.left.postErgodic();
        }
        if (this.right != null) {
            this.right.postErgodic();
        }
        System.out.println(this);
    }

    /**
     * 前序查找
     * @param e
     * @return
     */
    public Node<E> preSearch(E e) {
        //比较当前节点是不是
        if (this.e.equals(e)) {
            return this;
        }
        /*
         * 1. 则判断当前结点的左子节点是否为空,如果不为空，则递归前序查找
         * 2. 如果左递归前序查找,找到节点,则返回
         */
        Node<E> node = null;
        if (this.left != null) {
            node = this.left.preSearch(e);
        }
        if (node != null) {
            return node;
        }
        //1.左递归前序查找,找到节点,则返回,否则继续判断
        //2.当前的节点的右子节点是否为空,如果不为空,则继续向右递归前序查找
        if (this.right != null) {
            node = this.right.preSearch(e);
        }
        return node;
    }

    /**
     * 中序查找
     * @param e
     * @return
     */
    public Node<E> infixSearch(E e){
        Node<E> node = null;
        if(this.left != null){
            node = this.left.infixSearch(e);
        }
        if(node != null){
            return node;
        }
        if(this.e.equals(e)){
            return this;
        }
        if(this.right != null){
            node  = this.right.infixSearch(e);
        }
        return node;
    }

    /**
     * 后序查找
     * @param e
     * @return
     */
    public Node<E> postSearch(E e){
        //判断当前结点的左子节点是否为空,如果不为空,则递归后序查找
        Node<E> node = null;
        if(this.left != null){
            node = this.left.postSearch(e);
        }
        if(node != null){ //说明在左子数找到
            return node;
        }

        //如果左子树没有找到,则向右子树递归进行后序遍历查找
        if(this.right != null){
            node = this.right.postSearch(e);
        }
        if(node != null){
            return node;
        }
        if(this.e.equals(e)){
            return this;
        }
        return node;
    }

    @Override
    public String toString() {
        return "Node{" + "e=" + e + '}';
    }


}
