import org.junit.Test;

/**
 * @Created by zhang on 2021/11/7  22:11
 */
public class 剑指Offer_11_旋转数组的最小数字 {
    /*
    即找出一个半排序（将一个排序数字打断成两部分）数组中的最小数字
    例如找出 [3,4,5,1,2] 中的 1
     */
    @Test
    public void test(){
        int minArray = minArray(new int[]{3, 4, 5, 1, 2});
        System.out.println(minArray);
    }

    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            // 二分法（主要适用于排序数组）
            int m = (i + j) / 2;
            // 表示此时的 m 位于前半段的升序数组中，则答案下标在 [m+1, j]的闭区间
            if (numbers[m] > numbers[j]) i = m + 1;
            // 表示此时的 m 位于后半段的升序数组中，则答案下标在 [i, m]的闭区间中
            else if (numbers[m] < numbers[j]) j = m;
            else {
                // 一定有区间 [i, m] 内所有元素相等 或 区间 [m,j] 内所有元素相等
                int x = i;
                // 遍历寻找数组中的最小值
                for(int k = i + 1; k < j; k++) {
                    if(numbers[k] < numbers[x]) x = k;
                }
                return numbers[x];
            }
        }
        return numbers[i];
    }
}
