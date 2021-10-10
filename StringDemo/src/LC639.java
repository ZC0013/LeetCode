import org.junit.Test;

/**
 * @Created by zhang on 2021/9/27  22:39
 */
public class LC639 {

    static final int MOD = 1000000007;

    @Test
    public void test(){
        int nums = Enum("123*113");
        System.out.println(nums);
    }

    int mod = (int)1e9+7;
    public int Enum(String s) {
        int n = s.length();
        long[] f = new long[3];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            int t = c - '0';
            long cnt = 0;
            int p1 = (i - 1) % 3, p2 = (i - 2) % 3;
            // 枚举组成什么 item（A -> 1; B -> 2 ...）
            for (int item = 1; item <= 26; item++) {
                if (item < 10) { // 该 item 由一个字符组成
                    if (c == '*' || t == item) cnt += f[p1];
                } else { // 该 item 由两个字符组成
                    if (i - 2 < 0) break;
                    char prev = s.charAt(i - 2);
                    int u = prev - '0';
                    int a = item / 10, b = item % 10;
                    if ((prev == '*' || u == a) && (t == b || (c == '*' && b != 0))) cnt += f[p2];
                }
            }
            f[i % 3] = cnt % mod;
        }
        return (int)(f[n % 3]);
    }



    public int numDecodings(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c = f[i]
        long a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = b * check1digit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * check2digits(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    public int check1digit(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }

    public int check2digits(char c0, char c1) {
        if (c0 == '*' && c1 == '*') {
            return 15;
        }
        if (c0 == '*') {
            return c1 <= '6' ? 2 : 1;
        }
        if (c1 == '*') {
            if (c0 == '1') {
                return 9;
            }
            if (c0 == '2') {
                return 6;
            }
            return 0;
        }
        return (c0 != '0' && (c0 - '0') * 10 + (c1 - '0') <= 26) ? 1 : 0;
    }
}
