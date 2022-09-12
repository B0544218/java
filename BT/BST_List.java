package test;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST_List {
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

    public BST_List(int[] nums) {
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
            System.out.print("\nnode:" + val + " already exists. skip insert." );   // traverse stop
        }else if (val < node.val) {
            BST_Node node_child = add(node.left, val);                              // traverse left
            if (node.left != node_child)
                node.left = node_child;
        }else if (val > node.val) {
            BST_Node node_child = add(node.right, val);                             // traverse right
            if (node.right != node_child)
                node.right = node_child;
        }

        return node;
    }

    public void delete(int val) {
        if (this.root == null) return;
        BST_Node root_after_remove = delete(this.root, val);
        if (this.root != root_after_remove) {
            this.root = root_after_remove;
        }
    }
    // return the current node (only changed if deleted)
    private BST_Node delete(BST_Node node, int val) {
        if (node == null) return null;

        BST_Node node_final = node;

        if (val == node.val) {                                                                 // traverse stop
            // 接骨概念 - 被刪除節點 兩邊都無 - 將null回傳給上一層接上
            if (node.left == null && node.right == null)
                node_final = null;
                // 接骨概念 - 被刪除節點 只剩右邊 - 將右節點回傳給上一層接上
            else if (node.left == null && node.right != null)
                node_final = node.right;
                // 接骨概念 - 被刪除節點 只剩左邊 - 將左節點回傳給上一層接上
            else if (node.left != null && node.right == null)
                node_final = node.left;
                // 接骨概念 - 被刪除節點 剩左右邊
            else if (node.left != null && node.right != null) {
                // 將 被刪除節點 與 右子樹中最小的節點 互換「值」
                BST_Node node_min = getMin(node.right); // 找出右子樹中最小的節點
                swap_node_value(node, node_min); // 互換「值」
                // 開啟第二戰場 - 最後會停在「被刪除節點 只剩右邊」這個狀態
                BST_Node node_child = delete(node.right, val);
                if (node.right != node_child)
                    node.right = node_child;
            }

        }else if (val < node.val) {
            BST_Node node_child = delete(node.left, val);                                    // traverse left
            if (node.left != node_child) // if any child link changed, update it
                node.left = node_child;
        }else if (val > node.val) {
            BST_Node node_child = delete(node.right, val);                                   // traver right
            if (node.right != node_child) // if any child link changed, update it
                node.right = node_child;
        }

        return node_final;
    }

    public BST_Node getMin() {
        return getMin(this.root);
    }

    private BST_Node getMin(BST_Node root) {
        if (root == null) return null;
        BST_Node node_min = root;
        while (true) {
            if (node_min.left == null) break;
            node_min = node_min.left;
        }
        return node_min;
    }

    public BST_Node getMax() {
        return getMax(this.root);
    }

    private BST_Node getMax(BST_Node root) {
        if (root == null) return null;
        BST_Node node_max = root;
        while (true) {
            if (node_max.right == null) break;
            node_max = node_max.right;
        }
        return node_max;
    }

    private void swap_node_value(BST_Node a, BST_Node b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public BST_Node search(int val) {
        if (this.root == null) return null;
        return search(this.root, val);
    }

    private BST_Node search(BST_Node node, int val) {
        if (node == null) return null;

        BST_Node result = null;

        if (val == node.val) {
            result = node;                   // traverse stop
        }else if (val < node.val) {
            result = search(node.left, val); // traverse left
        }else if (val > node.val) {
            result = search(node.right, val); // traver right
        }

        return result;
    }

    public static void main(String[] args){
        // Integer[] nums = new Integer[]{1,2,3,4,5}; 沒辦法用，因為上面是用int[] nums
        int[] nums = {1,2,3,4,5};
        // System.out.println();
        BST_List bst_list = new BST_List(nums);
        bst_list.buildtree();
        System.out.println(bst_list.search(3).val);
    }    
}
