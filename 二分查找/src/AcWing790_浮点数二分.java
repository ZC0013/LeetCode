import java.util.Scanner;

/**
 * @author zhangchuang
 * @create 2021-11-25 11:25 上午
 */
public class AcWing790_浮点数二分 {

    public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        int flage = 1;
        if( n < 0 ){
            n = -n;
            flage = -1;
        }
        double eps = 1e-8;
        double l = 0, r = 23;
        while( r - l > eps ){
            double mid = l + r / 2;
            if( mid * mid * mid >= n ) r = mid;
            else l = mid;
        }
        System.out.println(String.format("%.6f", l)); // 保留 6位小数

    }
}
