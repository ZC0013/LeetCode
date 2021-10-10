import org.junit.Test;

/**
 * @Created by zhang on 2021/9/23  15:11
 */
public class LC326_PowerOfNum {


    @Test
    public void test(){
        boolean powerOfThree = isPowerOfThree(27);
        System.out.println(Integer.MAX_VALUE);
        System.out.println( Math.pow(3,20));

    }

    /*
    循环的办法
     */
    public boolean isPowerOfThree(int n) {

        while( n > 0 && n % 3 == 0){
            n /= 3;
        }
        return n == 1;
    }

    /*
    结合数论的知识，因为 3 的幂整数，只有3一个质约数，所以又因为题目要求为32位的有符号整数，最大的就是3的19次幂，
    所以 整数 n 为 3的幂，即能将 3的19次幂整除，余数为零。
     */
    public boolean isPowerOfThreePro(int n) {

        return n > 0 && 1162261467 % n == 0;
    }


}
