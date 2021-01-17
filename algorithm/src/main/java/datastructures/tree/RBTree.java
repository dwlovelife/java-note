package datastructures.tree;

import lombok.Data;

@Data
public class RBTree {

    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private RBNode root;

    /**
     *      pf           pf
     *     /             /
     *     p       =>   pr
     *   /  \          /  \
     *  pl   pr       p    rr
     *      / \      / \
     *    rl   rr   pl  rl
     */
    private void leftRotate(RBNode p){
        if(p != null){
            RBNode pr = p.right;
            p.right = pr.left;
            if(pr.left != null){
                pr.left.parent = p  ;
            }
            pr.parent = p.parent;
            if(p.parent == null){
                root = pr;
            }else if(p.parent.left == p){
                p.parent.left = pr;
            }else{
                p.parent.right = pr;
            }
            pr.left = p;
            p.parent = pr;
        }
    }


    /**
     *  右旋
     *    pf            pf
     *     \             \
     *      p       =>   pl
     *    /  \          /  \
     *   pl   pr       ll   p
     *  / \                / \
     * ll lr             lr   pr
     */
    private void rightRotate(RBNode p){
        if(p != null){
            RBNode pl = p.left;
            p.left  = pl.right;
            if(pl.right != null){
                pl.right.parent = p  ;
            }
            pl.parent = p.parent;
            if(p.parent == null){
                root = pl;
            }else if(p.parent.right == p){
                p.parent.right = pl;
            }else{
                p.parent.left = pl;
            }
            pl.right = p;
            p.parent = pl;
        }
    }


    static class RBNode<K extends Comparable<K>, V> {
        private RBNode parent;
        private RBNode left;
        private RBNode right;
        private boolean color;
        private K key;
        private V value;

        private RBNode(){

        }

        public RBNode(RBNode parent, RBNode left,RBNode right, boolean color, K key, V value){
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }
    }

}
