import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Created by zhang on 2021/11/23  16:57
 */
public class LC384_打乱数组 {

    int[] nums;
    int n;
    Random random = new Random();
    @Test
    public void test(){
        nums = new int[]{1, 2, 3};
        n = nums.length;
        int[] shuffle = shuffle();
        System.out.println(Arrays.toString(shuffle));
        int[] reset = reset();
        System.out.println(Arrays.toString(reset));

    }

    public int[] reset() {
        return nums;
    }

    // 洗牌算法 从后面的牌随机抽一张与当前的牌交换
    public int[] shuffle() {
        int[] ans = nums.clone();
        for (int i = 0; i < n; i++) {
            swap(ans, i, i + random.nextInt(n - i));
        }
        return ans;
    }
    void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
