import org.junit.Test;

import java.util.Arrays;

/**
 * @Created by zhang on 2021/8/26  15:25
 */
public class LC881 {

    @Test
    public void test(){
        int[] people = {3,5,3,4};
        int s = numRescueBoats(people, 5);
        System.out.println(s);
    }
    public int numRescueBoats(int[] people, int limit) {
        int ship = 0;
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        while( l <= r){
            if(people[r] == limit){
                ship++;
                r--;
            }
            if( l == r ){
                ship++;
                break;
            }
            while( l < r){
                if(people[l] + people[r] <= limit){
                    ship++;
                    l++;
                    r--;
                }else{
                    r--;
                    ship++;
                }

            }
        }

        return ship;
    }
}
