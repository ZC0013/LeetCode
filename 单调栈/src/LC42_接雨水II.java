import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Created by zhang on 2021/11/3  16:54
 */
public class LC42_接雨水II {

    @Test
    public void test(){
        int trap = trap3(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(trap);
        int t = 46340;
        System.out.println(t *t);
    }

    /*
    方法二：单调栈
     */
    public int trap2(int[] height) {
        int ans = 0;

        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            // 栈中维持了一个单调递减栈，当前位置小于栈顶元素就进栈，当前位置大于栈顶元素时，就证明可能有积水，要出栈进行运算
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 弹出的为栈顶元素，即为当前阶段的最低元素，为低洼处
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                // left 为低洼处的前一个位置
                int left = stack.peek();
                int currWidth = i - left - 1;

                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    /*
    方法三：双指针法
     */
    public int trap3(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    /*
    方法一：朴素解法
     */
    public int trap(int[] height) {
        int total = 0;
        int leftHigh = height[0];
        int nextPeek = nextPeek(height, 0);
        for( int i = 0; i < height.length; i++){
            if( height[i] >= leftHigh){
                if( height[i] < nextPeek ){
                    leftHigh = height[i];
                }else {
                    nextPeek = nextPeek(height, i);
                    if( height[i] <= nextPeek){
                        leftHigh = height[i];
                    }else{
                        leftHigh = nextPeek;
                    }
                }
            }else{
                total += ( leftHigh - height[i]);
            }
        }
        return total;
    }
    public int nextPeek( int[] height, int i){
        int ori = height[i];
        int[] temp = Arrays.copyOf(height,height.length);
        Arrays.sort(temp,i+1,temp.length);
        return temp[temp.length - 1];
    }
}
