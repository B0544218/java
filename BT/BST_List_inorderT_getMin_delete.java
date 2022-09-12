import test.BST_List;
import static test.BST_List.BST_Node;

public class BST_List_inorderT_getMin_delete {

    public static void main(String[] args) {

        BST_Node root = null;

        /** build tree **/
        int[] nums = {5,2,6,1,4,7,3};
        BST_List bst = new BST_List(nums);
        bst.buildtree();
        System.out.println();

        /** in-order traversal = n * (getMin + delete) **/

//        while (true) {
//            BST_Node node_min = bst.getMin();
//            if (node_min == null) break;
//            System.out.print(node_min.val + " ");
//            bst.delete(node_min.val);
//        }

        /** in-order traversal = n * (getMax + delete) **/
        while (true) {
            BST_Node node_max = bst.getMax();
            if (node_max == null) break;
            System.out.print(node_max.val + " ");
            bst.delete(node_max.val);
        }

    }
}
