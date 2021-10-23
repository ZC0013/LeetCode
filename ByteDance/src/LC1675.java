import org.junit.Test;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author zhangchuang
 * @create 2021-10-23 3:46 下午
 */
public class LC1675 {

    /*
    1675. 数组的最小偏移量
    数组中偶数除以2，奇数可以乘以2。
    数组的 偏移量 是数组中任意两个元素之间的 最大差值 。
     */

    @Test
    public void test(){
        int[] nums = new int[]{4,10,8,3};
        minimumDeviation(nums);
    }
    public int minimumDeviation(int[] nums) {
        int min = 0x7fffffff;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            if ((num & 1) == 1) {
                num = num << 1;
            }
            queue.offer(num);
            min = Math.min(min, num);
        }
        int offset = queue.peek() - min;
        while (!queue.isEmpty() && (queue.peek() & 1) == 0) {
            int temp = queue.peek() >> 1;
            queue.poll();
            queue.offer(temp);
            min = Math.min(min, temp);
            offset = Math.min(offset, queue.peek() - min);
        }
        return offset;
    }

    public int minimumDeviation_TreeSet(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num % 2 == 0 ? num : num * 2);
        }
        int res = set.last() - set.first();
        while (res > 0 && set.last() % 2 == 0) {
            int max = set.last();
            set.remove(max);
            set.add(max / 2);
            res = Math.min(res, set.last() - set.first());
        }
        return res;
    }
}
