import org.junit.Test;

/**
 * @Created by zhang on 2021/11/14  21:52
 */
public class LC4_寻找两个正序数组的中位数 {


    @Test
    public void test(){
        double medianSortedArrays = findMedianSortedArrays(new int[]{1,2,3,7}, new int[]{5,6,8,9,11});
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int tot = nums1.length + nums2.length;
        if( tot % 2 == 0 ){
            // 此处的 k 表示为 第 k 大的数，不是下标（从1开始）
            int left = find( nums1, 0, nums2, 0, tot / 2 );
            int right = find( nums1, 0, nums2, 0, tot / 2 + 1 );
            return ( left + right ) / 2.0;
        }else{
            return find( nums1, 0, nums2, 0, tot / 2 + 1);
        }
    }
    // 每次递归 排除 k / 2的数字
    public int find( int[] nums1, int i, int[] nums2, int j, int k){
        // 保证 nums1 为较短的数组
        if( nums1.length - i > nums2.length - j ) return find( nums2, j, nums1, i, k);
        if( k == 1){
            if( nums1.length == i ) return nums2[j];    // 表示此时 nums1 没有数字了
            else return Math.min( nums1[i], nums2[j]);
        }
        if( nums1.length == i ) return nums2[ j + k - 1];   // 表示此时 nums1 没有数字了
        // 防止 nums1 角标越界
        int si = Math.min( nums1.length, i + k / 2 ), sj = j + k - k / 2;
        if( nums1[ si - 1 ] > nums2[ sj - 1 ])
            return find( nums1, i , nums2, sj, k - ( sj - j ));
        else
            return find( nums1, si, nums2, j, k - ( si - i ));
    }
}
