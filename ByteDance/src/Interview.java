import java.util.HashMap;
import java.util.Map;

/**
 * @Created by zhang on 2021/11/22  10:59
 */
public class Interview {

    /*
    map的key和value是Short和String，都是包装类，short型的i与Integer类型的1进行加减运算时，
    short会 向上转型 成为Integer（泛型只允许自动向上转型，不允许自动向下转型），
    在Integer的equals方法中，Short Instanceof Integer会返回false，所以每次都无法匹配成功，也就不能移除成功。
     */
    public static void main(String[] args) {
        Map<Short, String> map = new HashMap<>();
        for(short i = 0; i <100; i++) {
            map.put(i, String.valueOf(i));
            map.remove(i-1);
        }
        System.out.println(map.size());
    }
}
