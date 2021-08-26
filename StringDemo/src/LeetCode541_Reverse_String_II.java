import org.junit.Test;

/**
 * @Created by zhang on 2021/8/21  13:05
 */
public class LeetCode541_Reverse_String_II {

    @Test
    public void test(){
        String s = "abcdefgh";
        String s1 = reverseStr(s, 3);
        System.out.println(s1);
    }

    char[] ss;
    public String Own(String s, int k) {
        ss = s.toCharArray();
        int num = s.length();
        int l = 0, r = 0, count = 0;
        for(int i = 0; i < num;){
            if( i+1 < k + 2 * k * count){
                r++;
                i++;
            }else{
                r = i;
                rev(l,r);
                if(num <= 2 * k * (count + 1)){
                    return String.valueOf(ss);
                }else{
                    i = 2 * k * (count + 1);
                    l = i;
                    r = i - 1;
                    count++;
                }
            }
        }
        if (r == num) {
            rev(l, r - 1);
        } else {
            rev(l, r);
        }
        return String.valueOf(ss);
    }

    public void rev(int a, int b){
        char temp = ' ';
        int r = b;
        for(int i = a; i <= (b+a) / 2; i++){
            temp = ss[i];
            ss[i] = ss[r];
            ss[r--] = temp;
        }
    }

    //*****************官方题解************************
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        // 交换时的方法：方法一 双指针
//        while (left < right) {
//            char temp = arr[left];
//            arr[left] = arr[right];
//            arr[right] = temp;
//            left++;
//            right--;
//        }
        // 方法二：遍历
        char temp = ' ';
        int r = right;
        for(int i = left; i <= (left+right) / 2; i++){
            temp = arr[i];
            arr[i] = arr[r];
            arr[r--] = temp;
        }
    }

}
