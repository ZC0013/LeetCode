import org.junit.Test;

/**
 * @Created by zhang on 2021/10/29  10:26
 */
public class LC335_路径交叉 {

    @Test
    public void test(){
        boolean selfCrossing = isSelfCrossing(new int[]{3,3,4,2,2});
        System.out.println(selfCrossing);
    }

    int l = 0;
    int r = 0;
    int up = 0;
    int down = 0;
    public boolean isSelfCrossing(int[] distance) {
        int index = 0;
        int n = distance.length;
        while( index < n ){
            if( index < n && distance[index] > ( up - down ) ){
                up = distance[index] + down;
                index++;
            }else{
                break;
            }
            if( index < n && distance[index] > ( r - l ) ){
                l = r - distance[index];
                index++;
            }else{
                break;
            }
            if( index < n && distance[index] > ( up - down )){
                down = up - distance[index];
                index++;
            }else{
                break;
            }
            if( index < n && distance[index] > ( r - l )){
                r = distance[index] + l;
                index++;
            }else{
                break;
            }
        }
        return !(n == index);
    }
}
