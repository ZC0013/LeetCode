import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchuang
 * @create 2021-06-21 7:55 下午
 */
public class LeetCode401_BinaryWatch {

    @Test
    public void test(){

        List<String> strings = readBinaryWatch(2);
        System.out.println(strings);

    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }
}
