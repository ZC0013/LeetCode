import org.junit.Test;

/**
 * @Created by zhang on 2021/10/21  16:47
 */
public class LC1739 {

    @Test
    public void test(){
        int res = minimumBoxes(10);
        System.out.println(res);
    }

    int minimumBoxes(int n) {
        int k=1;
        int sum=0;
        while(sum+(k*(k+1))/2<n){
            sum=sum+(k*(k+1))/2;
            k++;
        }
        k--;
        int res=(k*(k+1))/2;
        k=1;
        while(sum<n){
            sum=sum+k;
            k++;
            res++;
        }
        return res;
    }


}
