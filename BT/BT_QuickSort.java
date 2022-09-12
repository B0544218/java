
public class BT_QuickSort{

    public static void quick_sort(int[] nums){
        quick_sort(nums, 0, nums.length - 1);
    }

    /**
     * Quick Sort is very much liks BST's Pre-order traversal !
     */
    public static void quick_sort(int[] nums, int left_i, int right_i){
        /** end condition - one-element array is sorted already **/
        if (left_i == right_i) return; // one element means sorted already
        if (left_i > right_i) return; // out of boundary sub-array

        /** main logic - conquer - pick pivot **/
        int pivot_i_guess = pick_pivot_index(nums, left_i, right_i);

        /** main logic - conquer - sort the current array chunk - pivot index would be moved around here **/
        int pivot_i_final = sort(nums, left_i, pivot_i_guess, right_i);

        /** data flow - divide **/
        quick_sort(nums, left_i, pivot_i_final-1);
        quick_sort(nums, pivot_i_final+1, right_i);

    }

    public static int sort(int[] nums, int start_i, int pivot_i_guess, int end_i) {

        /** goal: use existing space only ! **/
        int pivot_i_now = pivot_i_guess;

        /** step01: swap pivot value to the last element **/
        /** purpose: 讓左側部分先整理好 (最後再將pivot element放到適當位置) **/
        swap(nums, pivot_i_now, end_i); // swap value
        pivot_i_now = end_i; // update index

        /** step02: sort the rest of the array **/
        int left_i = start_i;
        int right_i = end_i - 1; // exclude pivot from the following process
        while (true) {

            while (true) {
                if (left_i == right_i) break;                    /** end condition **/
                if (nums[left_i] > nums[pivot_i_now]) break;     /** main logic - 找出不應該出現在「左」側的數 **/
                left_i++;                                        /** next step **/
            }

            while (true) {
                if (left_i == right_i) break;                    /** end condition **/
                if (nums[right_i] < nums[pivot_i_now]) break;    /** main logic - 找出不應該出現在「右」側的數 **/
                right_i--;                                       /** next step **/
            }

            if (left_i == right_i) break;                         /** end condition **/

            swap(nums, left_i, right_i);                          /** main logic - swap **/

        }

        /** step03: put pivot element to the right place **/
        int meeting_point_i = left_i; // or meeting_point_i = right_i
        if (nums[meeting_point_i] >= nums[pivot_i_now]) {
            swap(nums, pivot_i_now, meeting_point_i);
            pivot_i_now = meeting_point_i;
        }

        return pivot_i_now;
    }

    private static void swap(int[] nums, int left_i, int right_i) {
        int tmp = nums[left_i];
        nums[left_i] = nums[right_i];
        nums[right_i] = tmp;
    }

    public static int pick_pivot_index(int[] nums, int left_i, int right_i) {
        int result = (left_i+right_i)/2;
        return result;
    }



    public static void main(String[] args) {
//        int[] ary = {5,4,3,2,1};
//        int[] ary = {7,6,5,4,3,2,1};
//        int[] ary = {1,2,3,4,5};
//        int[] ary = {5,4,3,3,3};
//        int[] ary = {3,3,3,2,1};
//        int[] ary = {24,2,45,20,56,75,2,56,99,53,12};
        int[] ary = {20,10,50,30,70,60,40};
        BT_QuickSort.quick_sort(ary);
        System.out.println();
    }
    
}
