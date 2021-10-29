import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Created by zhang on 2021/10/28  19:54
 */
public class LC869 {

    @Test
    public void test(){
        boolean b = reorderedPowerOf2(64);
        System.out.println(b);
    }

    public boolean reorderedPowerOf2(int n) {
        String[] x = new String[]{"1", "2", "4", "8", "16", "23", "46", "128", "256", "125", "0124", "0248", "0469", "1289", "13468", "23678", "35566", "011237", "122446", "224588", "0145678", "0122579", "0134449", "0368888", "11266777", "23334455", "01466788", "112234778", "234455668", "012356789", "0112344778"};
        Set<String> uset = new HashSet<>();
        Collections.addAll(uset,x);
        char[] nums = String.valueOf(n).toCharArray();
        Arrays.sort(nums);
        return uset.contains(String.valueOf(nums));
    }
}
