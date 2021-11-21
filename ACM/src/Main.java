import java.util.Arrays;
import java.util.Scanner;

/**
 * @Created by zhang on 2021/10/31  21:59
 */
public class Main {


    /*
    ACM 输入输出
    1. 一般的 import
    import java.util.*;
    import java.io.*;
    import java.math.*;
    2. 首先必须有的 Scanner 类 (默认的分隔符就是空格)
    Scanner scanner = new Scanner(System.in); scanner = new Scanner(System.in);
    3.
    while( sc.hasNext() ){
        int n = sc.nextInt();   // 下一个 int
        int l = sc.nextLong();  // 下一个 long
        String s = sc.next();
    }
     */

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
    public static void main(String[] args) {

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

    public static void List(){

        //输入是一串数字，请将其转换成单链表格式之后，再进行操作
        //输入描述:
        //一串数字，用逗号分隔
        //输入
        //1,2,3,4,5
        Scanner scanner = new Scanner(System.in);
        //以字符串形式作为输入
        String str = scanner.next();
        //通过分隔符将其转为字符串数组
        String[] arr  = str.split(",");
        //初始化一个整数数组
        int[] ints = new int[arr.length];
        //给整数数组赋值
        for(int j = 0; j<ints.length;j++) {
            ints[j] = Integer.parseInt(arr[j]);
        }
    }
}
