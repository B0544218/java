// 完全二元樹 (Complete Binary Tree): 節點靠左邊
public class BHT_MaxHeap {

    private int[] binary_heap_tree;
    private int i_array_end;

    public BHT_MaxHeap(int[] nums) {
        this.binary_heap_tree = nums;
        this.i_array_end = nums.length - 1;
    }

    /** BigO = n **/
    public void buildheap(){
        // BFS - from bottom to top
        int i = this.i_array_end;
        while (true) {
            if (i < 0) break;

            shift_down(i);

            i--;
        }
    }

    /** BigO = log(n) **/
    private void shift_down(int i) {
        // end condition
        if (i > this.i_array_end) return;

        // pick the bigger child node - binary tree concept, but only pick one node to go
        Integer i_bigger = get_i_bigger_node(i);
        // if no child, return
        if (i_bigger == null) return;

        if (this.binary_heap_tree[i] < this.binary_heap_tree[i_bigger]) {
            // if smaller, swap value with the child node
            swap(i, i_bigger);
            // if smaller, go down and do it again
            shift_down(i_bigger);
        }

    }

    private void swap(int i, Integer i_bigger) {
        int tmp = this.binary_heap_tree[i];
        this.binary_heap_tree[i] = this.binary_heap_tree[i_bigger];
        this.binary_heap_tree[i_bigger] = tmp;
    }

    private Integer get_i_bigger_node(int i) {
        Integer i_bigger = null;

        int i_plus_one = i + 1;
        int i_left_plus_one = i_plus_one * 2;
        int i_right_plus_one = i_plus_one * 2 + 1;

        int i_left = i_left_plus_one - 1;
        int i_right = i_right_plus_one - 1;

        if (i_left <= this.i_array_end && i_right <= this.i_array_end) {
            if (this.binary_heap_tree[i_left] >= this.binary_heap_tree[i_right]) {
                i_bigger = i_left;
            }
            else if (this.binary_heap_tree[i_left] < this.binary_heap_tree[i_right]){
                i_bigger = i_right;
            }
        }else if (i_left <= this.i_array_end) {
            i_bigger = i_left;
        }else if (i_right <= this.i_array_end) {
            i_bigger = i_right;
        }

        return i_bigger;
    }

    /** BigO = log(n) **/
    public void remove_from_top() {

        /** ste01: swap top node with last node **/
        int i_top = 0;
        swap(i_top, this.i_array_end);

        /** ste02: pretend the last element removed from the tree **/
        i_array_end--;

        /** ste03: shift down the current top node, if necessary **/
        shift_down(i_top);

    }

    /** BigO = log(n) **/
    public void add_to_bottom(int num_to_add) {

        /** ste01: extend inner storage if necessary **/
        if (this.i_array_end + 1 > this.binary_heap_tree.length - 1) {
            extend_storage();
        }

        /** ste02: add to the end of the tree **/
        i_array_end++;
        this.binary_heap_tree[this.i_array_end] = num_to_add;

        /** ste03: shift up, if necessary **/
        shift_up(i_array_end);

    }

    private void extend_storage() {
        int[] binary_heap_tree_new = new int[this.binary_heap_tree.length * 2];
        for (int i = 0; i < this.binary_heap_tree.length; i++) {
            binary_heap_tree_new[i] = this.binary_heap_tree[i];
        }
        this.binary_heap_tree = binary_heap_tree_new;
    }

    /** BigO = log(n) **/
    private void shift_up(int i) {
        // end condition
        if (i < 0) return;
        if (i == 0) return; // root already

        // get parent node index
        int i_plus_one = i + 1;
        int i_parent_plus = i_plus_one / 2;
        int i_parent = i_parent_plus - 1;

        if (this.binary_heap_tree[i] > this.binary_heap_tree[i_parent]) {
            // if bigger, swap value
            swap(i, i_parent);
            // if bigger, go up and do it again
            shift_up(i_parent);
        }

    }

}