public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return new int[]{-1,-1};
        return searchRange(nums, target, 0, nums.length-1);
    }

    public int[] searchRange(int[] nums, int target, int i_low, int i_high) {

        int[] result = new int[]{-1,-1};
        int[] result_tmp_left;
        int[] result_tmp_right;

        int i_mid = (i_low+i_high)/2;
        if (target == nums[i_mid]) {
            result[0] = i_mid; // update
            result[1] = i_mid; // update
            if (i_low < i_mid) {
                result_tmp_left = searchRange(nums, target, i_low, i_mid-1);
                if (result_tmp_left[0] != -1) {
                    result[0] = result_tmp_left[0]; // update
                }
            }

            if (i_mid < i_high) {
                result_tmp_right = searchRange(nums, target, i_mid+1, i_high);
                if (result_tmp_right[1] != -1) {
                    result[1] = result_tmp_right[1]; // update
                }
            }
        }else if (target < nums[i_mid]) {
            if (i_low < i_mid) {
                result = searchRange(nums, target, i_low, i_mid-1);
            }
        }else if (target > nums[i_mid]) {
            if (i_mid < i_high) {
                result = searchRange(nums, target, i_mid+1, i_high);
            }
        }

        return result;

    }
}
