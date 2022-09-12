
import java.util.LinkedList;
import java.util.Queue;

public class BT_Array {
    private Integer[] nums;

    public BT_Array(Integer[] nums) {
        this.nums = nums;
    }

    /** DFS left **/
    public void traverse_preorder() {
        if (this.nums.length < 0) return;
        int i_root = 0;
        if (this.nums[i_root] == null) return;
        this.traverse_preorder(i_root);
    }

    private void traverse_preorder(int i) {
        if (i >= this.nums.length) return;

        if (this.nums[i] != null) System.out.print(this.nums[i] + " ");

        /** next round step **/
        int i_plus_one = i + 1;
        int i_left_plus_one = i_plus_one * 2;
        int i_right_plus_one = i_plus_one * 2 + 1;

        int i_left = i_left_plus_one - 1;
        int i_right = i_right_plus_one - 1;

        traverse_preorder(i_left);
        traverse_preorder(i_right);
    }

    public void traverse_inorder() {
        if (this.nums.length < 0) return;
        int i_root = 0;
        if (this.nums[i_root] == null) return;
        this.traverse_inorder(i_root);
    }

    private void traverse_inorder(int i) {
        if (i >= this.nums.length) return;


        /** next round step **/
        int i_plus_one = i + 1;
        int i_left_plus_one = i_plus_one * 2;
        int i_right_plus_one = i_plus_one * 2 + 1;

        int i_left = i_left_plus_one - 1;
        int i_right = i_right_plus_one - 1;

        traverse_inorder(i_left);
        if (this.nums[i] != null) System.out.print(this.nums[i] + " ");
        traverse_inorder(i_right);
    }

    public void traverse_postorder() {
        if (this.nums.length < 0) return;
        int i_root = 0;
        if (this.nums[i_root] == null) return;
        this.traverse_postorder(i_root);
    }

    private void traverse_postorder(int i) {
        if (i >= this.nums.length) return;

        /** next round step **/
        int i_plus_one = i + 1;
        int i_left_plus_one = i_plus_one * 2;
        int i_right_plus_one = i_plus_one * 2 + 1;

        int i_left = i_left_plus_one - 1;
        int i_right = i_right_plus_one - 1;

        traverse_postorder(i_left);
        traverse_postorder(i_right);
        if (this.nums[i] != null) System.out.print(this.nums[i] + " ");

    }

    /** DFS right **/
    public void traverse_preorder_dfsright() {
        if (this.nums.length < 0) return;
        int i_root = 0;
        if (this.nums[i_root] == null) return;
        this.traverse_preorder_dfsright(i_root);
    }

    private void traverse_preorder_dfsright(int i) {
        if (i >= this.nums.length) return;

        if (this.nums[i] != null) System.out.print(this.nums[i] + " ");

        /** next round step **/
        int i_plus_one = i + 1;
        int i_left_plus_one = i_plus_one * 2;
        int i_right_plus_one = i_plus_one * 2 + 1;

        int i_left = i_left_plus_one - 1;
        int i_right = i_right_plus_one - 1;

        traverse_preorder_dfsright(i_left);
        traverse_preorder_dfsright(i_right);
    }

    public void traverse_inorder_dfsright() {
        if (this.nums.length < 0) return;
        int i_root = 0;
        if (this.nums[i_root] == null) return;
        this.traverse_inorder_dfsright(i_root);
    }

    private void traverse_inorder_dfsright(int i) {
        if (i >= this.nums.length) return;


        /** next round step **/
        int i_plus_one = i + 1;
        int i_left_plus_one = i_plus_one * 2;
        int i_right_plus_one = i_plus_one * 2 + 1;

        int i_left = i_left_plus_one - 1;
        int i_right = i_right_plus_one - 1;

        traverse_inorder_dfsright(i_left);
        if (this.nums[i] != null) System.out.print(this.nums[i] + " ");
        traverse_inorder_dfsright(i_right);
    }

    public void traverse_postorder_dfsright() {
        if (this.nums.length < 0) return;
        int i_root = 0;
        if (this.nums[i_root] == null) return;
        this.traverse_postorder_dfsright(i_root);
    }

    private void traverse_postorder_dfsright(int i) {
        if (i >= this.nums.length) return;

        /** next round step **/
        int i_plus_one = i + 1;
        int i_left_plus_one = i_plus_one * 2;
        int i_right_plus_one = i_plus_one * 2 + 1;

        int i_left = i_left_plus_one - 1;
        int i_right = i_right_plus_one - 1;

        traverse_postorder_dfsright(i_left);
        traverse_postorder_dfsright(i_right);
        if (this.nums[i] != null) System.out.print(this.nums[i] + " ");

    }
    
    public static void main(String[] args){
        Integer[] nums = new Integer[]{1,2,3,4,5};
        BT_Array bt_array = new BT_Array(nums);
        bt_array.traverse_preorder();

    }
}