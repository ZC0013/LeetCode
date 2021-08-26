import org.junit.Test;

/**
 * @Created by zhang on 2021/8/22  20:52
 */
public class LC233_Number_of_Digit_One {

    @Test
    public void test(){
        int num = 13;
        int ans = 0;
        for (int i = 0; i <= num; i++) {
            ans += one(i);
        }

        System.out.println(ans);
    }
    public int one(int num){
        int res = 0;
        if(num % 10 == 1) res++;
        int temp = 0;
        while (num / 10 != 0){
            temp = num / 10;
            if(temp % 10 == 1) res++;
            num /= 10;
        }
        return res;
    }
}
