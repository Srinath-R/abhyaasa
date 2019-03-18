package sri.ds;

public class CheckForBst {
    public static boolean isBst(LevelOrderTraverser.TreeNode<Integer> node,int min,int max) {
        if(node == null) return true;

        if(node.getElement() < min || node.getElement() > max) return false;

        return isBst(node.getLeft(),min,node.getElement()-1) &&
                isBst(node.getRight(),node.getElement()+1,max);
    }

    public static LevelOrderTraverser.TreeNode<Integer> populateTree() {
        LevelOrderTraverser.TreeNode<Integer> root = new LevelOrderTraverser.TreeNode<>(1)
                .withLeftChild(new LevelOrderTraverser.TreeNode<>(2))
                .withRightChild(new LevelOrderTraverser.TreeNode<>(3));
        root.getLeft().withLeftChild(new LevelOrderTraverser.TreeNode<>(4))
                .withRightChild(new LevelOrderTraverser.TreeNode<>(5));
        root.getRight().withLeftChild(new LevelOrderTraverser.TreeNode<>(6))
                .withRightChild(new LevelOrderTraverser.TreeNode<>(7));
        root.getLeft().getRight().withLeftChild(new LevelOrderTraverser.TreeNode<>(8));

        return root;
    }

    public static void main(String[] args) {
        System.out.println(isBst(populateTree(),Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
}
