package 查并集;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Created by zhang on 2021/8/14  16:47
 *
 * 小美给了小团一个长度为 n（n为偶数）的序列 A，序列中的数都是介于 [1,100000] 的整数。小团想把这个序列变得漂亮后再送回给小美。小美觉得一个序列是漂亮的当且仅当这个序列的前一半和后一半是一样的，即对于 1<=i<=n/2 都满足 A[i]==A[i+n/2]。
 * 小团可以按进行以下操作任意次：
 * 选择两个介于 [1, 100000] 之间的数 x 和 y，然后将序列 A 中所有值为 x 的数替换为 y。
 * 注意，每次操作都会在上一次操作后得到的序列上进行。小团想知道他最少需要操作多少次可以把序列变成漂亮的。
 *
 * 输入描述
 *      第一行是一个整数 n，表示序列的长度。数据保证 n 为偶数。
 *      第二行有 n 个用空格隔开的整数，第 i 个数表示 A[i] 的值。数据保证 1<=A[i]<=100000。
 * 输出描述
 *      输出小团需要的最少操作次数。
 *
 * 样例输入
 *      10
 *      4 2 1 5 2 10 2 1 5 8
 * 样例输出
 *      2
 */
public class Demo1 {

    static int[] f = new int[10001];

    public static void main(String[] args) {

        input();
    }


    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        int res = 0;
        for(int i=0;i<f.length;i++)
            f[i] = i;
        for(int i=0;i<n/2;i++){
            if(find(a[i])!=find(a[i+n/2])){
                union(a[i],a[i+n/2]);
                res++;
            }
        }
        System.out.println(res);

    }


    public static int find(int x){
        while(x!=f[x]){
            x = f[x];
        }
        return x;
    }
    public static void union(int x,int y){
        int a = find(x);
        int b = find(y);
        if(a==b)
            return;
        else
            f[a] = b;
    }
}
