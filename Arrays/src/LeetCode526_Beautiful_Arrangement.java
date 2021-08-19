import org.junit.Test;

import java.util.*;

/**
 * @Created by zhang on 2021/8/16  15:45
 */
public class LeetCode526_Beautiful_Arrangement {

    @Test
    public void countArrangement(){
//        int res = backtrackTest(3);
//        int res2 = StateCompression_Add_DynamicProgramming(3);
//        System.out.println(res2);

        int[] ints = constructArray(5, 2);
        System.out.println(Arrays.toString(ints));
        System.out.println(Integer.MAX_VALUE);
    }

    List<Integer>[] match;
    boolean[] vis;
    int num;

    /*
        1. 我们可以使用回溯法解决本题，从左向右依次向目标排列中放入数即可。
        2. 保证去重的方法：
            回溯过程中，我们可以用 vis 数组标记哪些数被使用过，每次我们选中一个数 x，我们就将vis[x] 标记为 true，
            回溯完成后，我们再将其置为 false。
        3. 为了优化回溯效率，我们可以预处理每个位置的符合条件的数有哪些，
        用二维数组 match 保存。当我们尝试向位置 index 放入数时，我们只需要遍历 match[index] 即可。


     */
    public int backtrackTest(int n) {
        vis = new boolean[n + 1];
        match = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<Integer>();
        }
        /**
         * 预处理： 首先找出在 index 位置可以符合条件的值，放入match[index]中
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    match[i].add(j);
                }
            }
        }
        backtrack(1, n);
        return num;
    }

    /**
     *
     * @param index 表示尝试向位置 index 放入数
     * @param n 其中 n 表示排列的长度。
     */
    public void backtrack(int index, int n) {
        if (index == n + 1) {
            num++;
            return;
        }
        for (int x : match[index]) {
            if (!vis[x]) {
                vis[x] = true;
                backtrack(index + 1, n);
                vis[x] = false;
            }
        }
    }

    /*
    因为题目限制只能有15位数，所以可以用二进制的01来表示几个数的排列
    例如 0110 表示只有两个数 2,3 时有多少种符合要求的组合方式
    所以最终的结果需要知道 n = 4 时 1111的结果
     */
    public int StateCompression_Add_DynamicProgramming(int n) {
        // 2 的 n 次方个中间值： 1左移n位
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            // num 表示 mask的二进制数中有多少个1
            int num = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0 && ((num % (i + 1)) == 0 || (i + 1) % num == 0)) {
                    f[mask] += f[mask ^ (1 << i)];
                }
            }
        }
        return f[(1 << n) - 1];
    }

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0] = 1;
        boolean[] flag = new boolean[n + 1];
        flag[1] = true;
        int index = 1;
        while(index != n){
            if( res[index-1]+k <= n && !flag[res[index-1]+k] ){
                res[index] = res[index-1]+k;
                flag[res[index]] = true;
                if(k > 1 ) k--;
                index++;
            }else if(res[index-1]-k >= 0 && !flag[res[index-1]-k] ){
                res[index] = res[index-1]-k;
                flag[res[index]] = true;
                if(k > 1 ) k--;
                index++;
            }else{
                int temp = 0;
                for(int i = 1; i < n; i++){
                    temp = (res[index-1] + i) % n;
                    temp = temp == 0 ? 1 :temp;
                    if(!flag[temp]){
                        res[index] = temp;
                        flag[res[index]] = true;
                        index++;
                        break;
                    }
                }
            }
        }
        return res;
    }


}
