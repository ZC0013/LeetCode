import java.util.Scanner;

/**
 * @Created by zhang on 2021/11/17  23:47
 */
public class ACwing135_最大子序和 {

    static final int N = 300010;
    public static void main(String[] args)
    {

        int[] q = new int[N];
        Scanner sc = new Scanner(System.in);
        while( sc.hasNext() )
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[] nums = new long[N];
            // 前缀和数组 nums 在读入的时候就进行处理 使用long 数组防止溢出
            for( int i = 1; i <= n; i++ )
            {
                nums[i] = sc.nextInt();
                nums[i] += nums[i - 1];
            }
            /*
                q[] 为维护的一个单调递减队列, 其中存储的 q[hh] = 原数组中队头元素的下标
                hh 指向队头, tt指向队尾
             */
            int hh = 0, tt = 0; // 队列的队头和队尾
            long res = Integer.MIN_VALUE;
            for( int i = 1; i <= n; i++ ){
                // q[hh] = 原数组中队头元素的下标
                // i - q[hh]用于判断当前子序列的和有没有超过题目要求的m
                // 原数组 nums 为前缀和数组，nums[i] 表示的是前 i 个元素的和
                if( i - q[hh] > m ) hh++;
                // q[] 为维护的一个单调递减队列, 所以队头元素最小，想要 nums[i] - nums[q[hh]] 最大，则维护单调栈，使得 nums[q[hh]] 最小
                res = Math.max( res, nums[i] - nums[q[hh]]);
                while( hh <= tt && nums[q[tt]] >= nums[i]) tt--; //如果队尾的元素大于当前值时，一直弹出队尾元素
                // 将当前元素压入栈
                q[++tt] = i;
            }
             System.out.println(res);
        }
    }
}
