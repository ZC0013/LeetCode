import org.junit.Test;

/**
 * @Created by zhang on 2021/8/22  14:36
 */
public class LC789 {

    @Test
    public void test(){

        int[][] ghosts = new int[][]{{1,0},{0,3}};
        int[] target = new int[]{0,1};
        boolean b = escapeGhosts(ghosts, target);
        System.out.println(b);
    }
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] start = new int[]{0,0};
        int a = shortWay(start ,target);
        int b = Integer.MAX_VALUE;
        for(int[] temp : ghosts){
            int tem = shortWay(temp, target);
            b = tem > b ? b : tem;
        }

        return a < b;
    }

    public int shortWay(int[] start, int[] end){
        return Math.abs(end[0] - start[0]) + Math.abs(end[1] - start[1]);
    }
}
