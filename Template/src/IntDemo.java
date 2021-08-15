import java.util.Arrays;
import java.util.Scanner;

/**
 * @Created by zhang on 2021/8/14  16:15
 */
public class IntDemo {

    public static void main(StringDemo[] args) {

        input1();
    }


    /**
     * 输入数组
     * 格式为：
     * 第一行是一个数 T，表示有 T 组数据。
     * 对于每组数据：
     * 第一行有两个整数 n 和 k，分别表示小美将会给出 n 个数以及她给出的整数k。
     * 接下来一行有 n 个用空格隔开的正整数，表示小美给出的 n 个正整数。
     *
     * 2
     * 6 6
     * 1 6 6 2 1 3
     * 6 3
     * 1 6 5 2 2 5
     *
     */
    public static void input1(){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t>0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++)
                a[i] = scanner.nextInt();
            System.out.println(t +" "+ n +" "+ k +" "+ Arrays.toString(a));
            t--;
        }
    }



}
