
import java.util.LinkedList;
import java.util.Queue;

public class BST_Array {
    private Integer[] nums;
    private Integer[] bst; // independent space needed

    public BST_Array(Integer[] nums) {
        this.nums = nums;
    }

    public void buildtree() {
        this.bst = new Integer[nums.length];
        for (int i = 0; i < this.nums.length; i++) {
            add(this.nums[i]);
        }
    }

    public void add(int val) {
        int i_root = 0;
        add(i_root, val);
    }

    private void add(int i_node, int val) {

        // check storage size
        if (i_node >= this.bst.length) {
            extend_storage();
        }

        // found the right spot for inserting new node!
        if (this.bst[i_node] == null) {
            this.bst[i_node] = val;
            return;
        }

        if (val == this.bst[i_node]) {
            System.out.print("\nnode:" + val + " already exists. skip insert." );   // traverse stop
        }else if (val < this.bst[i_node]) {
            int i_node_left = (i_node+1)*2 - 1;
            add(i_node_left, val);                                    // traverse left
        }else if (val > this.bst[i_node]) {
            int i_node_right = (i_node+1)*2 + 1 - 1;
            add(i_node_right, val);                                   // traverse right
        }

        return;
    }

    private void extend_storage() {
        Integer[] binary_heap_tree_new = new Integer[this.bst.length * 3];
        for (int i = 0; i < this.bst.length; i++) {
            binary_heap_tree_new[i] = this.bst[i];
        }
        this.bst = binary_heap_tree_new;
    }

    /**
     * attention: we can NOT implement delete in array for BST
     * why: it's too complex to maintain
     * example: delete one node, "all" of its child nodes have to be moved left
     * example: {5,X,6,1,4,7,3,9,11,19,13,21}
     */
    public void delete(int val) {
    }

    public Integer search(int val) {
        int i_root = 0;
        if (this.bst[i_root] == null) return null;
        return search(i_root, val);
    }

    private Integer search(int i_node, int val) {
        if (i_node >= this.bst.length) return null;
        if (this.bst[i_node] == null) return null;

        Integer result = null;

        if (val == this.bst[i_node]) {
            result = this.bst[i_node];         // traverse stop
        }else if (val < this.bst[i_node]) {
            int i_node_left = (i_node+1)*2 - 1;
            result = search(i_node_left, val); // traverse left
        }else if (val > this.bst[i_node]) {
            int i_node_right = (i_node+1)*2 + 1 - 1;
            result = search(i_node_right, val); // traver right
        }

        return result;
    }

    public static void main(String[] args){
        Integer[] nums = new Integer[]{1,2,3,4,5};
        // System.out.println();
        BST_Array bst_array = new BST_Array(nums);
        bst_array.buildtree();
        System.out.println(bst_array.search(3));
    }  
}
