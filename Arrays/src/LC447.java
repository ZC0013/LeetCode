import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created by zhang on 2021/9/13  22:53
 */
public class LC447 {


    @Test
    public void test(){

        int[][] arr = new int[][]{{1,1},{2,2},{3,3}};
        int i = numberOfBoomerangs(arr);
        System.out.println(i);
    }

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }
}
