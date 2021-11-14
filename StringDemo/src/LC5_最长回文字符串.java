import org.junit.Test;

/**
 * @Created by zhang on 2021/11/4  22:18
 */
public class LC5_最长回文字符串 {

    @Test
    public void test(){
        String res = longestPalindrome2("cbbd");
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public String longestPalindrome2(String s) {
        String res = "";
        // 循环遍历字符串 ，依次从中间往两边进行查找
        // 时间复杂度 O(N2)
        for( int i = 0; i < s.length(); i++ ){
            // 字符串为奇数情况
            int l = i - 1, r = i + 1;
            while( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r) ){
                l--;
                r++;
            }
            if( res.length() < ( r - l - 1) ){
                res = s.substring(l+1, r);
            }
            // 字符串为偶数情况
            l = i;
            r = i + 1;
            while( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r) ){
                l--;
                r++;
            }
            if( res.length() < ( r - l - 1) ){
                res = s.substring(l+1, r);
            }
        }
        return res;
    }

}
