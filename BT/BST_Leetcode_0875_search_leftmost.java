public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        if (null == piles || piles.length == 0) return 0;
        int max_banana_number = 1000000000; // according to the specified max banana number in each slot
        return minEatingSpeed(piles, H, 1, max_banana_number);
    }
	
	// 至少要在某個時段吃完
	// k_low  吃香蕉最小速度(左邊最小)
	// k_high 吃香蕉最大速度(右邊最大)
    public int minEatingSpeed(int[] piles, int H, int k_low, int k_high) {
		
        int k_result = -1;
        int k_result_tmp = -1;
        int k_mid = (k_low+k_high)/2;

        /** main logic **/
        long h = calculateHour(piles, k_mid);
        /** data flow **/
		// 吃東西速度如果沒有小於要求速度，所以需要再找一個更快的吃香蕉速度
        if (h <= H) { // wow, just like find leftmost same number
            k_result = k_mid;
            if (k_low < k_mid) { // it means, the current k_mid may be still too big, so pick smaller one
                k_result_tmp = minEatingSpeed(piles, H, k_low, k_mid - 1);
                if (k_result_tmp != -1) k_result = k_result_tmp;
            }
        }else if (h > H) {
			// tree往右邊走
            if (k_mid < k_high)
                k_result = minEatingSpeed(piles, H, k_mid + 1, k_high);
			// 如果h > H，但是最快速吃香蕉的方式也沒辦法在 H時間內做完，k_result則為-1
        }
        return k_result;
    }

    public long calculateHour(int[] piles, int k) {
        int i = 0;
        long h = 0;
        while(true) {
            int bananas = piles[i];
            // be carefule about the rounding in integers
            if (bananas % k == 0)
                h += bananas/k;
            else
                h += (bananas/k + 1);

            i++;
            if (i >= piles.length) break;
        }

        return h;
    }
}