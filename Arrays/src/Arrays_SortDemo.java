import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Created by zhang on 2021/8/26  15:33
 */
public class Arrays_SortDemo {

    /**
     * Arrays.sort() 提供的排序方法默认是升序的即自然排序，如果想要改成降序的话有两种办法：
     * 但是这两种方法都要求 提供的是一个 Integer[]
     * 方法一：使用 Collections 中写好的一个降序排列接口
     * 方法二：重写compare接口
     */

    /*
    Arrays.sort()
    对于Arrays.sort()方法，传入的是基本类型则使用 Dual-Pivot 快速排序，其他类型的排序使用 TimeSort 排序 ( legacyMergeSort 将在未来的版本中删除 )
     */
    @Test
    public void test(){
        int[] sum = {1,2,3,4,5,4,3};
//        sort1(intToInteger(sum));
        sort2(intToInteger(sum));
//        Arrays.sort(sum);
    }

    public void sort1(Integer[] arr){

        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(Arrays.toString(arr));
    }

    public void sort2(Integer[] arr){

        /*
        老方法：使用匿名表达式
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
         */

        // 使用 Lambda 表达式
        Arrays.sort(arr, (o1, o2) -> o2 - o1);

        System.out.println(Arrays.toString(arr));
    }

    public Integer[] intToInteger(int[] nums){
        //将int数组转换为Integer数组
        //先将int数组转换为数值流
        IntStream stream = Arrays.stream(nums);
        //流中的元素全部装箱，转换为流 ---->int转为Integer
        Stream<Integer> integerStream = stream.boxed();
        //将流转换为数组 Lambar 表达式
        return integerStream.toArray(Integer[]::new);
    }

    public void Insert_Official(int left, int right, int[] a){
        for (int i = left, j = i; i < right; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == left) {
                    break;
                }
            }
            a[j + 1] = ai;
        }
    }


}
