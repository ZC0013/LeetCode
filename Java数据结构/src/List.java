import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Created by zhang on 2021/11/11  21:07
 */
public class List {

    /*
    list 转 数组
     */
    @Test
    public void test(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        Integer[] integers = list.toArray(new Integer[0]);  // toArray() 中必须传入参数
        System.out.println(Arrays.toString(integers));
    }
}
