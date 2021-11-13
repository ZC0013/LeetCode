import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Created by zhang on 2021/11/11  23:24
 */
public class LC77 {

    @Test
    public void test(){
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrack( n, k, path, res, 1);
        return res;
    }

    public void backtrack(int n, int k, LinkedList<Integer> path, List<List<Integer>> res, int start){
        if( path.size() == k ){
            res.add( new ArrayList(path));
            return;
        }
        // 在基础版的基础上，进行剪切优化
        // 保证在每一层是都为后续留有足够的元素，
        // 比如在第一层时，此时 path.size() = 0 ，[1,2,3,4,5] k = 3, 则只需遍历到 3 即可停止，因为最后一个即为 3,4,5. 遍历4,5没有意义
        for( int i = start; i <= n-(k - path.size()) + 1; i++){
            path.addLast(i);
            backtrack( n, k, path, res, i+1 );
            path.removeLast();
        }
    }
}
