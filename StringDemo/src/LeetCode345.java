import org.junit.Test;

/**
 * @Created by zhang on 2021/8/19  21:05
 */
public class LeetCode345 {

    @Test
    public void test(){
        char[] ss = new char[2];
        ss[0] = '1';
        ss[1] = '1';
        String s = String.valueOf(ss);
        System.out.println(s);
    }

    /*
    简单题：反转字符串中的元音字母
    题目很简单，但是如何判断某个字符是不是元音字母的判断方式值得学习
    "aeiouAEIOU".indexOf(ch) >= 0; 可以判断 字符ch 在字符串中第一次出现的索引位置，如果没有则返回 -1
    还有就是String 转 Char[]
        char[] arr = s.toCharArray();
    Char[] 转 String
        String s = new String(arr);
        String s = String.valueOf(arr);
     */
    public String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(arr[i])) {
                ++i;
            }
            while (j > 0 && !isVowel(arr[j])) {
                --j;
            }
            if (i < j) {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
