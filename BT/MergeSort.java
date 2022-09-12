public class MergeSort {

    public static void merge_sort(int[] nums){
        merge_sort(nums, 0, nums.length-1);
    }
    
    public static void merge_sort(int[] nums, int low_i, int high_i){
        /** end condition - one-element array is sorted already **/
        if (low_i == high_i) return;

        /** data flow - divide **/
        int mid_i = (low_i + high_i) / 2;
        merge_sort(nums, low_i, mid_i);
        merge_sort(nums, mid_i + 1, high_i);

        /** main logic - conquer - sort **/
        sort(nums, low_i, mid_i, high_i);
    }

    private static void sort(int[] nums, int low_i, int mid_i, int high_i) {
        int[] nums_tmp = new int[nums.length];
        int i_nums_tmp = low_i;         // low_i ~ high_i
        int i_left_ary = low_i;         // low_i ~ mid_i
        int i_right_ary = (mid_i + 1);  // mid_i + 1 ~ high_i
        while (true) {
            if (i_nums_tmp > high_i) break;

            Integer num_left = null;
            Integer num_right = null;
            /** pick one number from left_ary **/
            if (i_left_ary <= mid_i)
                num_left = nums[i_left_ary];
            /** pick one number from right_ary **/
            if (i_right_ary <= high_i)
                num_right = nums[i_right_ary];

            /** compare and put into nums_tmp array **/
            if (null != num_left && null != num_right) {
                if (num_left <= num_right) {
                    nums_tmp[i_nums_tmp] = num_left;
                    i_left_ary++;
                }
                if (num_left > num_right) {
                    nums_tmp[i_nums_tmp] = num_right;
                    i_right_ary++;
                }
            }else if (null != num_left && null == num_right) {
                nums_tmp[i_nums_tmp] = num_left;
                i_left_ary++;
            }else if (null == num_left && null != num_right) {
                nums_tmp[i_nums_tmp] = num_right;
                i_right_ary++;
            }else {
                throw new RuntimeException("no element is left. shouldn't see this at all");
            }

            i_nums_tmp++;

        } // end of while

        /** copy back to original array **/
        int k = low_i;
        while (true) {
            if (k > high_i) break;

            nums[k] = nums_tmp[k];

            k++;
        } // end of while

    }


    public static void main(String[] args) {
//        int[] ary = {5,4,3,2,1};
//        int[] ary = {1,2,3,4,5};
//        int[] ary = {5,4,3,3,3};
//        int[] ary = {3,3,3,2,1};
        int[] ary = {24,2,45,20,56,75,2,56,99,53,12};
        MergeSort.merge_sort(ary);
        System.out.println();
    }


}
