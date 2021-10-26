import org.junit.Test;

import java.util.*;

/**
 * @Created by zhang on 2021/10/26  16:19
 */
public class LC496_NextGreaterNumber_I {

    /*
    LC496. 下一个更大元素I
    单调栈专门解决Next Greater Number
     */
    @Test
    public void test(){

        int[] nums1 = new int[]{4,1,3};
        int[] nums2 = new int[]{1,2,1};
        int[] ints = nextGreaterElement2(nums1, nums2);

        System.out.println(Arrays.toString(ints));
    }

    /*
    方法二： 单调栈 + 哈希表

     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1];
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = n2 - 1; i >= 0; i--){
            int temp = nums2[i];
            while( !stack.isEmpty() && temp > stack.peek()){
                stack.pop();
            }
            map.put(temp, stack.isEmpty() ? -1 : stack.peek());
            stack.push(temp);
        }
        for(int i = 0; i < n1; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n2; i++){
            map.put(nums2[i], i);
        }
        for(int i = 0; i < n1; i++){
            int index = map.get(nums1[i]);
            while( index < n2 && nums2[index] <= nums1[i]){
                index++;
            }
            res[i] = index == n2 ? -1 : nums2[index];
        }
        return res;
    }





}
