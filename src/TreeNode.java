import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreeNode<E extends Comparable<E>> {
    private E value;
    private TreeNode<E> left;
    private TreeNode<E> right;

    public TreeNode(E value, TreeNode<E> left, TreeNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /*
     * Return the maximum value among all nodes in the tree rooted at the current node.
     *
     *
     * Hint: because it may not make sense to use comparison symbols '<' or '>' with the generic type E,
     * we instead use the fact that E is of type Comparable<E>. Specifically, use
     * "a.compareTo(b) > 0" to mean a > b
     * "a.compareTo(b) < 0" to mean a < b
     * "a.compareTo(b) == 0" to mean a == b.
     */
    public E max() {
        E currentMax = this.value; //current node

        //keep going to the left until none, and keep checking
        if(left!=null){
            E leftMax = this.left.max();
            if(leftMax.compareTo(currentMax)>0){
                currentMax = leftMax;
            }
        }

        if(right!=null){
            E rightMax = this.right.max();
            if(rightMax.compareTo(currentMax)>0){
                currentMax = rightMax;
            }
        }

        if(this.value.compareTo(currentMax)>0){
            currentMax = this.value;
        }
        return currentMax;
    }

    public int size() {
      return size(this);
    }

    private int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    /*
     * Return a list of the nodes in the tree rooted at the current node, ordered by in-order traversal.
     * INORDER --> LEFT, ROOT, RIGHT
     */
    public List<E> inorder() {
        List<E> list = new ArrayList<>();
        // left subtree
        if (left != null) { //breaking condition
            List<E> leftList = left.inorder();
            list.addAll(leftList);
        }
        // do a little work
        list.add(value);
        // right subtree
        if (right != null) {
            List<E> rightList = right.inorder();
            list.addAll(rightList);
        }
        return list;
    }

    /*
     * Return a list of the nodes in the tree rooted at the current node, ordered by post-order traversal.
     * POSTORDER --> LEFT, RIGHT, ROOT
     */
    public List<E> postorder() {
        List<E> list = new ArrayList<>();

        //checking for left list
        if (left != null) {
            List<E> leftList = left.postorder();
            list.addAll(leftList);
        }

        //checking for left list
        if (right != null) {
            List<E> rightList = right.postorder();
            list.addAll(rightList);
        }
        //add values here.
        list.add(value);
        return list;
    }

    /*
     * Generate a full binary tree with the given number of levels, and whose nodes contain integer values
     * less than the value given by bound.
     */
    public static TreeNode<Integer> generateTree(int levels, int bound) {
        // base case
        if (levels == 0)
            return null;
        // recursive calls
        TreeNode<Integer> leftSubtreeRoot = generateTree(levels - 1, bound);
        TreeNode<Integer> rightSubtreeRoot = generateTree(levels - 1, bound);
        // do a little work
        int value = (new Random()).nextInt(bound);
        return new TreeNode<>(value, leftSubtreeRoot, rightSubtreeRoot);
    }

    public static void main(String[] args) {
        TreeNode<Integer> node = generateTree(4, 100);
        System.out.println("-----INORDER------");
        System.out.println(node.inorder());
        System.out.println("-----POST ORDER------");
        System.out.println(node.postorder());
        System.out.println("-----SIZE OF TREE------");
        System.out.println(node.size());
        System.out.println("-----MAX ELEMENT------");
        System.out.println(node.max());

    }


}