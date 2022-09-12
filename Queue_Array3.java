public class Queue_Array3 {
    Integer[] ary;
    Integer[] queue;
    // i_front 要被pop，i_end要被offer
    Integer i_front = null; 
    Integer i_end = null;

    public Queue_Array3(Integer[] ary){
        this.ary = ary;
    }

    public void build_queue(){
        this.queue = new Integer[this.ary.length];
        for (int i = 0 ; i < ary.length; i++) {
            offer(ary[i]);
        }
    }

    private void offer(Integer val) {
        if (size() == queue.length) {
            // warning
            expand_space();
        }

        if (size() == 0) {
            i_front = 0;
            i_end = 0;
            queue[i_end] = val;
        }else {
            i_end++; // circular array
            i_end %= queue.length;
            queue[i_end] = val;
        }

    }

    private void expand_space() {
        Integer[] queue_new = new Integer[this.queue.length * 2];
        int i = 0;
        while (true) {
            if (size() == 0) break;

            Integer val = poll();
            queue_new[i] = val;
            i++;

        }

        this.i_front = 0;
        this.i_end = i - 1;

        this.queue = queue_new;

    }

    private int size() {
        if (i_front == null && i_end == null) {
            return 0;
        }else if (i_end >= i_front) {
            return (i_end - i_front) + 1;
        }else if (i_end < i_front) {
            return (queue.length - i_front) + (i_end) + 1;
        }
        return -1;
    }

    public Integer poll() {
        if (size() == 0) {
            return null;
        }

        Integer val = queue[i_front];
        queue[i_front] = null;

        if (size() == 1) {
            i_front = null;
            i_end = null;
        }else {
            i_front++; // circual array
            i_front %= queue.length;
        }
        return val;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,4,5};
        Queue_Array3 queue_array = new Queue_Array3(nums);
        queue_array.build_queue();

        // full - extend the storage size
        queue_array.offer(6);

        Integer val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();

        // empty
        val = queue_array.poll();

        // circular queue - i_end test
        queue_array.offer(11);
        queue_array.offer(12);
        queue_array.offer(13);
        queue_array.offer(14);
        queue_array.offer(15);
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();

        for (int i = 0; i < 80; i++) {
            queue_array.offer(30 + i);
        }

        System.out.println();
    }

}