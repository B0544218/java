
public class BST_TreeSort {
    private int[] nums;
    private BST_Node root;

    public static class BST_Node {
        public BST_Node left;
        public BST_Node right;
        public int val;
        public String owner;

        public BST_Node(){}
        public BST_Node(int val, String owner) {
            this.val = val;
            this.owner = owner;
        }
        public BST_Node(int val) {
            this.val = val;
        }
    }

    public BST_TreeSort(int[] nums) {
        this.nums = nums;
    }

    public void buildtree() {
        for (int i = 0; i < this.nums.length; i++) {
            add(this.nums[i]);
        }
    }

    public void add(int val) {
        BST_Node root_after_add = add(this.root, val);
        if (this.root != root_after_add) {
            this.root = root_after_add;
        }
    }

    public static BST_Node add(BST_Node node, int val) {

        // found the right spot for inserting new node!
        if (node == null) {
            node = new BST_Node(val);
            return node;
        }

        if (val == node.val) {
            /** duplicates allowed: if equal, put as left child **/
            /** case1: X X , X right **/
            if (node.left == null) {
                node.left = new BST_Node(val);
            }
            /** case2: left X , left right -> 將[新節點]卡入中間 **/
            else if (node.left != null) {
                BST_Node new_left_node = new BST_Node(val);
                new_left_node.left = node.left;
                node.left = new_left_node;
            }
        }else if (val < node.val) {
            BST_Node node_child = add(node.left, val);                                    // traverse left
            if (node.left != node_child)
                node.left = node_child;
        }else if (val > node.val) {
            BST_Node node_child = add(node.right, val);                                   // traverse right
            if (node.right != node_child)
                node.right = node_child;
        }

        return node;
    }

    /** inorder traversal (DFS left) **/
    public void traverse_inorder() {
        if (this.root == null) return;
        this.traverse_inorder(this.root);
    }

    private void traverse_inorder(BST_Node node) {
        if (node == null) return;

        traverse_inorder(node.left);

        System.out.print(node.val + " ");

        traverse_inorder(node.right);
    }

    /** inorder traversal (DFS right) **/
    public void traverse_inorder_dfsright() {
        if (this.root == null) return;
        this.traverse_inorder_dfsright(this.root);
    }

    private void traverse_inorder_dfsright(BST_Node node) {
        if (node == null) return;

        traverse_inorder_dfsright(node.right);

        System.out.print(node.val + " ");

        traverse_inorder_dfsright(node.left);
    }

    /** tree sort (DFS left) **/
    public static void tree_sort_ascending(int[] nums) {
        BST_TreeSort bst = new BST_TreeSort(nums);
        bst.buildtree();
        bst.traverse_inorder();
    }

    /** tree sort (DFS right) **/
    public static void tree_sort_descending(int[] nums) {
        BST_TreeSort bst = new BST_TreeSort(nums);
        bst.buildtree();
        bst.traverse_inorder_dfsright();
    }

    public static void main(String[] args) {

        /** build tree **/
//        int[] nums = {5,6,7,2,4,1,3};
        int[] nums = {5,6,7,2,1,6,2}; // duplicates
        System.out.print("\ntree sort (dfs left): ");
        BST_TreeSort.tree_sort_ascending(nums);
        System.out.print("\ntree sort (dfs right): ");
        BST_TreeSort.tree_sort_descending(nums);

    }
}
