import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Created by zhang on 2021/8/27  22:17
 */
public class LC295 {

    @Test
    public void test(){

        MedianFinder();
        addNum(6);
        double median1 = findMedian();
        addNum(10);
        double median2 = findMedian();
        addNum(2);
        double median3 = findMedian();
        addNum(6);
        double median4 = findMedian();
        addNum(5);
        double median5 = findMedian();
        addNum(6);
        double median6 = findMedian();
        addNum(3);
        double median7 = findMedian();
        addNum(1);
        double median8 = findMedian();
        addNum(0);
        double median9 = findMedian();
        addNum(0);
        double median10 = findMedian();

    }


    LinkedList<Integer> data;
    int size;
    /**
     *
     * 使用LinkedList维护一个有序数组超时。
     *
     */
    public void MedianFinder() {
        data = new LinkedList();
        size = 0;
    }

    public void addNum(int num) {

        if(size == 0 || num <= data.get(0)){
            data.addFirst(num);
            size++;
            return;
        }
        if(num >= data.get(size - 1)){
            data.add(num);
            size++;
            return;
        }
        int l = 0, r = size - 1;
        while(l < r){
            int mid = ( r + l ) / 2;
            if( num < data.get(mid)){
                r = mid - 1;
            }else if(num > data.get(mid)){
                l = mid + 1;
            }else {
                data.add(mid,num);
                size++;
                return;
            }
        }
        if(num > data.get(l)){
            data.add(l+1,num);
            size++;
        }else{
            data.add(l,num);
            size++;
        }


    }

    public double findMedian() {
        double res = 0.0;
        if(size % 2 == 0){
            return (double)(data.get(size/2-1) + data.get(size/2)) / 2;
        }else{
            return (double)data.get(size/2);
        }
    }
}
