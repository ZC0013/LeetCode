import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Created by zhang on 2021/9/4  15:17
 */
public class LC912_SortArray {

    /*
    主要复习常见的排序方法：
    1. 冒泡排序法
    2. 快速排序
    3. 并归排序
    4. 桶排序

     */
    int[] arr = {1,3,4,2,5,6,8,10,4,2,9};
    @Test
    public void Sort(){
        quickSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void swap(int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 从左往右，每次选取未排定部分的最小部分，交换到未排定部分的开头
     * 算法思想 1：贪心算法：每一次决策只看当前，当前最优，则全局最优。注意：这种思想不是任何时候都适用。
     * 算法思想 2：减治思想：外层循环每一次都能排定一个元素，问题的规模逐渐减少，直到全部解决，即「大而化小，小而化了」。
     * 运用「减治思想」很典型的算法就是大名鼎鼎的「二分查找」。
     * 优点：交换次数最少。
     * 时间复杂度 O(N²), 空间复杂度O(1)
     * @param arr 待排序的数组
     *
     */
    public void selectSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int tem = i;
            for (int j = i + 1; j < n; j++) {
                if(arr[j] < arr[tem]){
                    tem = j;
                }
            }
            swap(i,tem);
        }
    }
    /*
    插入排序：
    每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组，有限次操作以后，数组整体有序。
    优点：
    由于「插入排序」在「几乎有序」的数组上表现良好，特别地，在「短数组」上的表现也很好。
    因为「短数组」的特点是：每个元素离它最终排定的位置都不会太远。
    为此，在小区间内执行排序任务的时候，可以转向使用「插入排序」。
    复杂度分析：
    时间复杂度：O(N²), 这里 N 是数组的长度；
    空间复杂度：O(1), 使用到常数个临时变量。
     */
    public void insertSort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int tem = arr[i];
            int index = i - 1;
            if(arr[index] < tem) continue;
            while (index >= 0 && arr[index] >= tem){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = tem;
        }
    }




    public void insertSort(int[] arr, int left, int right){
        for (int i = left + 1; i <= right; i++) {
            int tem = arr[i];
            int index = i - 1;
            if(arr[index] < tem) continue;
            while (index >= left && arr[index] >= tem){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = tem;
        }
    }

    /*
    归并排序：借助额外空间，合并两个有序数组，得到更长的有序数组。
    所以归并思想的核心就是先分组，再进行逐级合并成有序数组.

    优化 1：在「小区间」里转向使用「插入排序」，Java 源码里面也有类似这种操作，「小区间」的长度是个超参数，需要测试决定，我这里参考了 JDK 源码；
    优化 2： 在「两个数组」本身就是有序的情况下，无需合并；
    优化 3：全程使用一份临时数组进行「合并两个有序数组」的操作，避免创建临时数组和销毁的消耗，避免计算下标偏移量。
    注意：实现归并排序的时候，要特别注意，不要把这个算法实现成非稳定排序，区别就在 <= 和 < ，已在代码中注明。
   「归并排序」比「快速排序」好的一点是，它借助了额外空间，可以实现「稳定排序」，Java 里对于「对象数组」的排序任务，就是使用归并排序（的升级版 TimSort）
    复杂度分析：
    时间复杂度：O(N*logN)，这里 N 是数组的长度；
    空间复杂度：O(N)，辅助数组与输入数组规模相当。
     */
    static final int INSERTION_SORT_THRESHOLD = 7;
    public void mergeSort(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];

        merge(arr, 0, n - 1, temp);

    }

    public void merge(int[] nums, int left, int right, int[] temp){
        // 小区间时使用插入排序
        if(right - left <= INSERTION_SORT_THRESHOLD){
            insertSort(nums, left, right);
            return;
        }

        int mid = (left + right) >>> 1;
        merge(nums,left,mid,temp);
        merge(nums,mid+1,right,temp);
        if(nums[mid] <= nums[mid+1]) return;
        mergeTwoArrays(nums, left, mid, right, temp);

    }
    public void mergeTwoArrays(int[] nums, int left, int mid, int right, int[] temp){

        int t1 = left;
        int t2 = mid+1;
        System.arraycopy(nums,left,temp,left,right+1-left);
        for( int k = left; k <= right; k++){
            if( t1 == mid + 1 ){
                nums[k] = temp[t2];
                t2++;
            }else if(t2 == right){
                nums[k] = temp[t1];
                t1++;
            }else if( temp[t1] <= temp[t2]){
                nums[k] = temp[t1];
                t1++;
            }else {
                nums[k] = temp[t2];
                t2++;
            }
        }
    }

    // 快排
    public void quickSort1(int[] arr){
        int n = arr.length;
        quick(arr, 0 , n-1);
    }

    private void quick(int[] arr, int left, int right) {
//        if( right - left <= INSERTION_SORT_THRESHOLD){
//            insertSort(arr,left,right);
//            return;
//        }
        int pIndex = partition(arr, left, right);
        quick(arr, left, pIndex - 1);
        quick(arr, pIndex + 1, right);
    }

    private static final Random RANDOM = new Random();
    private int partition(int[] arr, int left, int right) {
        int randomIndex =  RANDOM.nextInt(right - left + 1) + left;
        swap(left, randomIndex);

        // 基准值
        int pivot = arr[left];
        int lt = left;

        for(int i = left + 1; i <= right; i++){
            if(arr[i] < pivot){
                lt++;
                swap(i,lt);
            }
        }
        swap(left,lt);
        return lt;
    }
}
