
import java.util.LinkedList;
import java.util.Queue;

public class BT_List {
    private Integer[] nums;
    private Node root;

    public static class Node {
        public Node left;
        public Node right;
        public int val;

        public Node(){}
        public Node(int val) {
            this.val = val;
        }
    }

    public BT_List(Integer[] nums) {
        this.nums = nums;
    }

    // 非本章學習重點(本方法僅模擬測試資料用）
    public void buildtree () {
        if (this.nums.length < 0) return;
        if (this.nums[0] == null) return;

        // prepare Node instances
        Node[] nodes_tmp = new Node[this.nums.length];
        for (int i = 0; i < this.nums.length; i++) {
            if (this.nums[i] == null) continue;
            nodes_tmp[i] = new Node(this.nums[i]);
        }
        // set root
        this.root = nodes_tmp[0];
        // this.root指到nodes_tmp[0]位置

        for (int i = 0; i < this.nums.length; i++) {
            int i_left = (i + 1) * 2 - 1; // i_left_plus_one = (i_node_plus_one) * 2 -> i_left = i_left_plus_one - 1
            int i_right = (i + 1) * 2 + 1 - 1; // i_right_plus_one = (i_node_plus_one) * 2 + 1-> i_right = i_right_plus_one - 1

            Node node = nodes_tmp[i];
            // 一開始指到nodes_tmp[0]位置(等同於this.root)
            // 接著指到nodes_tmp[1]位置
            
            if (node == null) continue;

            if (i_left < this.nums.length) {
                node.left = nodes_tmp[i_left];
            }
            if (i_right < this.nums.length) {
                node.right = nodes_tmp[i_right];
            }
        }
    }

    /** preorder traversal (DFS left) **/
    public void traverse_preorder() {
        if (this.root == null) return;
        this.traverse_preorder(this.root);
    }

    private void traverse_preorder(Node node) {
        if (node == null) return;

        System.out.print(node.val + " ");

        /** next round step **/
        traverse_preorder(node.left);
        traverse_preorder(node.right);
    }

    /** inorder traversal (DFS left) **/
    public void traverse_inorder() {
        if (this.root == null) return;
        this.traverse_inorder(this.root);
    }

    private void traverse_inorder(Node node) {
        if (node == null) return;

        traverse_inorder(node.left);

        System.out.print(node.val + " ");

        traverse_inorder(node.right);
    }

    /** postorder traversal (DFS left) **/
    public void traverse_postorder() {
        if (this.root == null) return;
        this.traverse_postorder(this.root);
    }

    private void traverse_postorder(Node node) {
        if (node == null) return;

        traverse_postorder(node.left);
        traverse_postorder(node.right);

        System.out.print(node.val + " ");
    }

    //// DFS right

    /** preorder traversal (DFS right) **/
    public void traverse_preorder_dfsright() {
        if (this.root == null) return;
        this.traverse_preorder_dfsright(this.root);
    }

    private void traverse_preorder_dfsright(Node node) {
        if (node == null) return;

        System.out.print(node.val + " ");

        /** next round step **/
        traverse_preorder_dfsright(node.right);
        traverse_preorder_dfsright(node.left);
    }

    /** inorder traversal (DFS right) **/
    public void traverse_inorder_dfsright() {
        if (this.root == null) return;
        this.traverse_inorder_dfsright(this.root);
    }

    private void traverse_inorder_dfsright(Node node) {
        if (node == null) return;

        traverse_inorder_dfsright(node.right);

        System.out.print(node.val + " ");

        traverse_inorder_dfsright(node.left);
    }

    /** postorder traversal (DFS right) **/
    public void traverse_postorder_dfsright() {
        if (this.root == null) return;
        this.traverse_postorder_dfsright(this.root);
    }

    private void traverse_postorder_dfsright(Node node) {
        if (node == null) return;

        traverse_postorder_dfsright(node.right);
        traverse_postorder_dfsright(node.left);

        System.out.print(node.val + " ");
    }

    public static void main(String[] args){
        Integer[] nums = new Integer[]{1,2,3,4,5};
        BT_List bt_list = new BT_List(nums);
        bt_list.buildtree();
        bt_list.traverse_preorder();

    }
}