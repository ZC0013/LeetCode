import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Created by zhang on 2021/11/12  16:36
 */
public class LC752_打开转盘锁 {


    @Test
    public void test(){
        int openLock = openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(openLock);
    }
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for( String s : deadends) deads.add(s);
        Set<String> visited = new HashSet<>();
        // 用集合不用队列，可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        int step = 0;
        q1.add("0000");
        q2.add(target);
        while( !q1.isEmpty() && !q2.isEmpty() ){
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();
            // 将 q1 中的所有节点向周围扩散
            for( String cur : q1){
                if( deads.contains(cur) ){
                    continue;
                }
                if( q2.contains(cur) ){
                    return step;
                }
                visited.add(cur);

                /* 将一个节点的未遍历相邻节点加入集合 */
                for( int j = 0; j < 4; j++){
                    String up = plusOne(cur,j);
                    if( !visited.contains(up)){
                        temp.add(up);
                    }
                    String down = minusOne(cur,j);
                    if( !visited.contains( down )){
                        temp.add(down);
                    }
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    public String plusOne( String s, int i){
        char[] ss = s.toCharArray();
        if( ss[i] == '9'){
            ss[i] = '0';
        }else{
            ss[i] += 1;
        }
        return new String(ss);
    }

    public String minusOne( String s, int i){
        char[] ss = s.toCharArray();
        if( ss[i] == '0'){
            ss[i] = '9';
        }else{
            ss[i] -= 1;
        }
        return new String(ss);
    }
}
