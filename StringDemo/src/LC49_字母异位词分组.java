import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Created by zhang on 2021/11/18  21:31
 */
public class LC49_字母异位词分组 {

    @Test
    public void test(){
        List<List<String>> lists = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for( String str : strs ){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String ss = String.valueOf(s);
            List<String> temp = map.getOrDefault(String.valueOf(s), new LinkedList<>());
            temp.add(str);
            map.put(ss, temp);
        }

        return new LinkedList<>(map.values());
    }
}
