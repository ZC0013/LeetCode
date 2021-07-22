import org.junit.Test;

import java.util.*;

/**
 * @author zhangchuang
 * @create 2021-07-22 3:26 下午
 */
public class LeetCode_1838_maxFrequency {

    @Test
    public void test(){

        int[] nums = new int[]{3,9,7};
        int k = 3;
        int res = dichotomy(nums, k);
        System.out.println(res);
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        int tempRes = 1;
        int length = nums.length - 1;
        int tempK = k;
        int max;
        int index;
        for(int i = length; i >= 0; i--){
            max = nums[i];
            index = i-1;
            tempRes = 1;
            while(index >= 0){
                if(tempK > 0 && max - nums[index] <= tempK){
                    tempRes++;
                    tempK -= max - nums[index];
                }else{
                    break;
                }
                index--;
            }
            tempK = k;
            res = res <= tempRes ? tempRes : res;
            if(index < 0) return res;
        }

        return res;

    }

    public int enumeration(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int ans = 1;
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i), cnt = map.get(x);
            if (i > 0) {
                int p = k;
                for (int j = i - 1; j >= 0; j--) {
                    int y = list.get(j);
                    int diff = x - y;
                    if (p >= diff) {
                        int add = p / diff;
                        int min = Math.min(map.get(y), add);
                        p -= min * diff;
                        cnt += min;
                    } else {
                        break;
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
        public int SlidingWindow(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;
            long total = 0;
            int l = 0, res = 1;
            for (int r = 1; r < n; ++r) {
                total += (long) (nums[r] - nums[r - 1]) * (r - l);
                while (total > k) {
                    total -= nums[r] - nums[l];
                    ++l;
                }
                res = Math.max(res, r - l + 1);
            }
            return res;
        }

    int[] nums, sum;
    int n, k;
    public int dichotomy(int[] _nums, int _k) {
        nums = _nums;
        k = _k;
        n = nums.length;
        Arrays.sort(nums);
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return r;
    }
    boolean check(int len) {
        for (int l = 0; l + len - 1 < n; l++) {
            int r = l + len - 1;
            int cur = sum[r + 1] - sum[l];
            int t = nums[r] * len;
            if (t - cur <= k) return true;
        }
        return false;
    }
}
