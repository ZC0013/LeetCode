import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created by zhang on 2021/11/5  21:09
 */
public class LC1218_最长定差子序列 {

    @Test
    public void test(){
        int i = longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2);
        System.out.println(i);

    }


    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

    /*
    方法二：
     */
    public int longestSubsequence2(int[] arr, int difference) {
        // 通过数组的方式 代替 哈希表
        int res[] = new int[40001];
        int max = 0;
        for(int x : arr){
            int i = res[x-difference+20000] + 1;
            res[x+20000] = i;
            max = Math.max(max,i);
        }
        return max;
    }
}
