import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @Created by zhang on 2021/9/14  23:17
 */
public class LC524_StringSort {

    @Test
    public void test(){

    }
    /*

    LC524. 通过删除字母匹配到字典里最长单词
    首先重写排序方法：
    优先级1：字符串的长度最大；
    优先级2：字典序最小（首先比较两个字符串的首字符，ASCII码小的字符串更小，如果第一个字符串相同则比较第二个）
     */
    public String findLongestWord(String s, List<String> list) {
        Collections.sort(list, (a, b)->{
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        int n = s.length();
        for (String ss : list) {
            int m = ss.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == ss.charAt(j)) j++;
                i++;
            }
            if (j == m) return ss;
        }
        return "";
    }
}
