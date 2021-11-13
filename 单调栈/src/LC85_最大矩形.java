import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Created by zhang on 2021/10/20  21:06
 */
public class LC85_最大矩形 {

    /*
    LC85 最大矩形
    给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     */
    @Test
    public void test(){
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };
        int res = maximalRectangle(matrix);
        System.out.println(res);

    }


    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0){
            return 0;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=0;
        int[] nums=new int[n+2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    nums[j+1]+=1;
                }else{
                    nums[j+1]=0;
                }
            }
            ans=Math.max(ans,area(nums));
        }
        return ans;
    }
    //参照84题解法，这里的入参就是84的数组+头尾两个哨兵
    public int area(int[] nums){
        LinkedList<Integer> stack=new LinkedList<>();
        stack.add(0);
        int sum=0;
        for(int i=1;i<nums.length;i++){
            while(nums[stack.getLast()]>nums[i]){
                int height=nums[stack.removeLast()];
                int width=i-stack.getLast()-1;
                sum=Math.max(sum,height*width);
            }
            stack.add(i);
        }
        return sum;
    }


}
