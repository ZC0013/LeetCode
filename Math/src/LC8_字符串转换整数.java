import org.junit.Test;

/**
 * @Created by zhang on 2021/11/14  23:56
 */
public class LC8_字符串转换整数 {

    @Test
    public void test(){
        int res = myAtoi("-01324000");
        System.out.println(res);
    }


    public int myAtoi(String s) {
        int res = 0;
        char[] ss = s.toCharArray();
        int k = 0;
        while( k < s.length() && ss[k] == ' ') k++;
        if( s.length() == k ) return 0;
        int minus = 1;
        if( ss[k] == '-'){
            minus = -1;
            k++;
        }else if( ss[k] == '+'){
            k++;
        }
        while( k < s.length() && ( ss[k] >= '0' && ss[k] <= '9')){
            int x = ss[k++] - '0';
            if( minus == 1 && res  > (Integer.MAX_VALUE - x) / 10 ) return Integer.MAX_VALUE;
            if( minus == -1 && - 1 * res < ( Integer.MIN_VALUE + x) / 10 ) return Integer.MIN_VALUE;
            res = res * 10 + x;
        }

        return res * minus;
    }
}
