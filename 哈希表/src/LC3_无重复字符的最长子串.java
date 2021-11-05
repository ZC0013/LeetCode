import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Created by zhang on 2021/11/4  20:52
 */
public class LC3_无重复字符的最长子串 {

    @Test
    public void test(){
        int res = lengthOfLongestSubstring("bbbc");
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        Arrays.fill(last,-1);
        int n = s.length();
        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }


}
