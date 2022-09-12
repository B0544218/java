
public class BHT_HeapSort {

    public static void heapsort_ascending(int[] nums) {
        /** step01: convert to BHT **/
        BHT_MaxHeap bht = new BHT_MaxHeap(nums);
        bht.buildheap();
        /** step02: remove n times, each time we pick one max to the current end position **/
        int i = nums.length - 1;
        while (true) {
            if (i < 0) break;

            bht.remove_from_top();

            i--;
        }
    }

    public static void main(String[] str) {

        /** HeapSort **/
        int[] num = {66,78,27,35,6,2,44,58,29,76};
        BHT_HeapSort.heapsort_ascending(num);
        System.out.println();

    }
}
