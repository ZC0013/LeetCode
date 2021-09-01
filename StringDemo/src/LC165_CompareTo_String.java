import org.junit.Test;

/**
 * @Created by zhang on 2021/9/1  19:23
 */
public class LC165_CompareTo_String {

    @Test
    public void compareVersion(){
        String s1 = "1.10.0.1";
        String s2 = "1";

        int test = TwoPoint(s1, s2);
        System.out.println(test);

    }

    /*
    自己解决的方法：首先使用字符串分割，分割成若干数组，然后比较大小，但是逻辑可以更加简化。
     */
    public int test(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int n1 = split1.length;
        int n2 = split2.length;
        for(int i = 0; i < n1 && i < n2; i++){
            int i1 = replaceZero(split1[i]).compareTo(replaceZero(split2[i]));
            if(i1 != 0){
                return i1 > 0 ? 1 : -1;
            }
        }
        if( n1 == n2 ){
            return 0;
        }else if( n1 < n2){
            int r1 = replaceZero(version2.split("\\.",n1+1)[n1]).compareTo(0);
            if(r1 == 0) return 0;
            return r1 > 0 ? -1 : 1;
        }else {
            int r2 = replaceZero(version1.split("\\.",n2+1)[n2]).compareTo(0);
            if(r2 == 0) return 0;
            return r2 > 0 ? 1 : -1;
        }
    }

    public Integer replaceZero(String s1){
        s1 = s1.replace(".","");
        char[] chars = s1.toCharArray();
        char zero = '0';
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != zero){
                return Integer.parseInt(s1.substring(i));
            }
        }
        return 0;
    }

    /*
    官方的第一种解法，对于逻辑进行优化
    时间复杂度 O(n + m) 或 O(max(n,m))，两者是等价的
    空间复杂度 O( n + m )
     */
    public int testPro(String version1, String version2){
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i = 0; i < v1.length || i < v2.length; i++){
            int x = 0, y = 0;
            if( i < v1.length){
                x = Integer.parseInt(v1[i]);
            }
            if( i < v2.length){
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }
    /*
    双指针：
     */
    public int TwoPoint(String version1, String version2){
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while ( i < n || j < m){
            int x = 0 , y = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i){
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i;
            for(; j < m && version2.charAt(j) != '.'; ++j){
                y = y* 10 + version2.charAt(j) - '0';
            }
            ++j;
            if( x != y){
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
