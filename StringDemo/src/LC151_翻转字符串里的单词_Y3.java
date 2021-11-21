import org.junit.Test;

/**
 * @Created by zhang on 2021/11/18  22:06
 */
public class LC151_翻转字符串里的单词_Y3 {

    @Test
    public void test(){
        String s = reverseWords("     ");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        char[] ss = s.toCharArray();
        int n = ss.length;
        int k = 0;
        for( int i = 0; i < n; i++ ){
            while ( i < n && ss[i] == ' ') i++;
            if( i == n ) break;
            int j = i;
            while ( j < n && ss[j] != ' ' ) j++;
            reverse(ss, i, j-1);
            if(k != 0) ss[k++] = ' ';
            while ( i < j ) ss[k++] = ss[i++];

        }
        reverse(ss, 0, k-1);
        return String.valueOf(ss,0,k);
    }

    public void reverse( char[] ss, int begin, int end ){
        while( begin < end ){
            char temp = ss[begin];
            ss[begin] = ss[end];
            ss[end] = temp;
            begin++;
            end--;
        }
    }
}
