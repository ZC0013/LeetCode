import org.junit.Test;

/**
 * @author zhangchuang
 * @create 2021-10-15 8:44 下午
 */
public class LC38 {

    @Test
    public void test(){

        String s = countAndSay(5);
        System.out.println(s);

    }

    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n; i++){
            char t = res.charAt(0);
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for(int j = 1; j < res.length(); j++){


                if( res.charAt(j) == t){
                    count++;
                }else{
                    temp.append(count).append(t);
                    t = res.charAt(j);
                    count = 1;
                }

            }
            temp.append(count).append(t);
            res = temp.toString();

        }
        return res;
    }
}
