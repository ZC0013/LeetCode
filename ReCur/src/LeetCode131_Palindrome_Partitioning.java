import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangchuang
 * @create 2021-06-15 9:33 上午
 */
public class LeetCode131_Palindrome_Partitioning {

    @Test
    public void test(){
        List<List<String>> partition = partition("adad");
        System.out.println(partition);
        String str = "adada";
        Integer.parseInt(str);

    }

    List<List<String>> res = new ArrayList<>();
    LinkedList<String> tmp = new LinkedList<>();
    public List<List<String>> partition(String s) {
        cur(s, 0);
        return res;
    }

    void cur(String s, int index){
        if(index == s.length()){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = index + 1; i <= s.length(); i++){
            if(judge(s.substring(index, i))){
                tmp.add(s.substring(index, i));
            }else {
                continue;
            }
            cur(s, i);
            tmp.removeLast();
        }
    }

    boolean judge(String s){
        String reverse = new StringBuffer(s).reverse().toString();
        return reverse.equals(s);
    }

}
