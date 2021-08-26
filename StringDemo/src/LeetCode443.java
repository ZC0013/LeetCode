import org.junit.Test;

/**
 * @Created by zhang on 2021/8/21  11:00
 */
public class LeetCode443 {

    @Test
    public void test(){
        char[] chars = new char[]{'a','b','c'};
        int compress = compress(chars);
        System.out.println(compress);
    }

    public int compress(char[] chars) {
        int n = chars.length;
        char a = chars[0];
        int num = 1;
        String s = "";
        if(n == 1) return 1;
        for(int i = 1; i < n; i++){
            if(a == chars[i]){
                num++;
            }else{
                s += num > 1 ? a +String.valueOf( num ) : a;
                a = chars[i];
                num = 1;
            }
        }
        s += num > 1 ? chars[n-1] + String.valueOf( num ) : chars[n-1];
        int res = s.length();
        for(int i = 0; i < res; i++){
            chars[i] = s.charAt(i);
        }
        return res;
    }
}
