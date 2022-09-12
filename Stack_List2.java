public class Stack_List2 {

    static class Node {
        Integer val;
        Node next;

        public Node(Integer val) {
            this.val = val;
        }
    }

    Integer[] ary;
    Node node_top;

    public Stack_List2(Integer[] ary) {
        this.ary = ary;
    }

    public void build_stack() {
        for (int i = 0; i < this.ary.length; i++) {
            push(ary[i]);
        }
    }

    public void push(Integer val) {
        if (node_top == null) {
            node_top = new Node(val);
        }else {
            Node node_new = new Node(val);
            node_new.next = node_top;
            node_top = node_new;
        }
    }

    public Integer pop() {
        if (node_top == null) {
            return null;
        }

        Node node = node_top;
        node_top = node_top.next;

        return node.val;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,4,5};
        Stack_List2 stack_list = new Stack_List2(nums);
        stack_list.build_stack();

        // full - extend the storage size
        stack_list.push(6);

        Integer num = stack_list.pop();
        num = stack_list.pop();
        num = stack_list.pop();
        num = stack_list.pop();
        num = stack_list.pop();
        num = stack_list.pop();

        // empty
        num = stack_list.pop();

        // push + pop
        stack_list.push(11);
        stack_list.push(12);
        stack_list.push(13);
        num = stack_list.pop();
        num = stack_list.pop();
        stack_list.push(14);
        num = stack_list.pop();

        System.out.println();
    }
    
}