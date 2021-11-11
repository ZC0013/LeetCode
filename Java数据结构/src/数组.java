import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Created by zhang on 2021/11/11  21:03
 */
public class 数组 {

    /* int数组 和 Integer数组的相互转换 */
    @Test
    public void test(){
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        Integer[] newNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(newNums, (a, b) -> b - a );
        nums = Arrays.stream(newNums).mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(nums));
    }
}
