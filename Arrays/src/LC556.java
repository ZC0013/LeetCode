import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC556. 下一个更大元素 III
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。
 * 如果不存在这样的正整数，则返回 -1
 *
 * @Created by zhang on 2021/10/26  20:56
 */
public class LC556 {


    @Test
    public void test(){

        int i = nextGreaterElement(2147483486);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(i);
    }

    public int nextGreaterElement(int n) {
        char[] c = (""+n).toCharArray();
        int num = c.length;
        int i = num - 2;
        while( i >= 0 && c[i] >= c[i+1]){
            i--;
        }
        if( i < 0){
            return -1;
        }
        int j = num - 1;
        while( j >= 0 && c[j] <= c[i] ){
            j--;
        }
        swap(c, i, j);
        reverse(c, i+1, num-1);
        /*
        主要是为了避免，变大的数超过了 Integer.MAX_VALUE 2147483647
         */
        try {
            return Integer.parseInt(new String(c));
        } catch (Exception e) {
            return -1;
        }

    }

    public void swap( char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
    public void reverse( char[] c, int l, int r){
        while( l < r){
            swap(c,l,r);
            l++;
            r--;
        }
    }
}
