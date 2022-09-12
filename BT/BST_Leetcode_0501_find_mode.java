public class Solution {

    Integer prev_val = null;
    Integer count_max = 0;
    Integer count_now = 0;
    List<Integer> modes = new ArrayList<>();

    // mode: 眾數
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        findMode_helper(root);
        return convertToArray();
    }

    public void findMode_helper(TreeNode node) {
        if (node == null) return;

        findMode(node.left);

        // in-order traversal - small to big
        // in-order traversal - finding [Min] all the time
        // System.out.print(node.val + " ");
        if (this.prev_val == null) {           // first node met (also the Min node of the whole tree)
            this.prev_val = node.val;
            this.count_now = 1;
        }else if (this.prev_val != node.val) { // another bigger number met
            this.prev_val = node.val;
            this.count_now = 1;
        }else if (this.prev_val == node.val) { // same number met
            this.count_now++;
        }

        // check count_max
        if (this.count_now > this.count_max) {
            this.count_max = this.count_now;
            modes.clear();
            modes.add(node.val);
        }else if (this.count_now == this.count_max) { // another mode
            modes.add(node.val);
        }else if (this.count_now < this.count_max) {
            // do nothing
        }

        findMode(node.right);

        return;
    }

    public int[] convertToArray() {
        int[] modes_ary = new int[this.modes.size()];
        for (int i = 0; i < modes_ary.length; i++) {
            modes_ary[i] = this.modes.get(i);
        }

        return modes_ary;
    }
}
