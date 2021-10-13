import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhangchuang
 * @create 2021-10-13 6:55 下午
 */
public class LC912_Practice {

    @Test
    public void test(){
        quick(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    int[] arr = new int[]{1,2,5,7,3};

    public void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void binarySearch(){
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;

        int m = ( l + r ) >>> 1;
        System.out.println(m);
    }

    public void merge(int[] arr, int[] temp, int l, int r){
        int m = ( l + r ) >>> 1;
        merge(arr, temp, l, m);
        merge(arr, temp, m + 1, r);
        he(arr,temp,l,r,m);
    }

    public void he(int[] arr, int[] temp, int l, int r,int m){
        System.arraycopy(arr,l,temp,l,r-l+1);
        int index = 0;
        int t1 = l;
        int t2 = m+1;
        while( t1 <= m+1 && t2 <= r){
            if(temp[t1] <= temp[t2]){
                arr[index] = temp[t1];
                t1++;
            }else{
                arr[index] = temp[t2];
                t2++;
            }
            index++;
        }



    }


    public void quick(int[] arr, int left, int right){

        if (left < right) {
            int partition = partition(arr, left, right);

            quick(arr, left, partition - 1);
            quick(arr, partition + 1, right);
        }


    }

    public int partition(int[] arr, int left, int right){
        Random random = new Random();
        int randomIndex = random.nextInt(right - left + 1) +left;
        swap(randomIndex,left);
        int pivot = arr[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if( arr[i] < pivot){
                lt++;
                swap(lt,i);
            }
        }
        swap(left,lt);
        return lt;
    }

}
