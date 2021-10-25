import org.junit.Test;

import java.util.*;

/**
 * @Created by zhang on 2021/10/24  22:53
 */
public class LC638_Shopping_Offers {

    /*
    LC638. 大礼包

    输入：price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]

    输出：14

    解释：有 A 和 B 两种物品，价格分别为 ¥2 和 ¥5 。
    大礼包 1 ，你可以以 ¥5 的价格购买 3A 和 0B 。
    大礼包 2 ，你可以以 ¥10 的价格购买 1A 和 2B 。
    需要购买 3 个 A 和 2 个 B ， 所以付 ¥10 购买 1A 和 2B（大礼包 2），以及 ¥4 购买 2A 。

     */

    @Test
    public void test(){
        List<Integer> price = Arrays.asList(2,5);

        List<List<Integer>> special = new ArrayList<>();
        List<Integer> special1 = Arrays.asList(3,0,5);
        List<Integer> special2 = Arrays.asList(1,2,10);
        special.add(special1);
        special.add(special2);
        List<Integer> needs = Arrays.asList(3,2);
        int res = shoppingOffers(price, special, needs);
        System.out.println(res);
    }

    Map<List<Integer>, Integer> memo = new HashMap<List<Integer>, Integer>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();

        // 过滤不需要计算的大礼包，只保留需要计算的大礼包
        List<List<Integer>> filterSpecial = new ArrayList<List<Integer>>();
        for (List<Integer> sp : special) {
            int totalCount = 0, totalPrice = 0;
            for (int i = 0; i < n; ++i) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > sp.get(n)) {
                filterSpecial.add(sp);
            }
        }

        return dfs(price, special, needs, filterSpecial, n);
    }

    // 记忆化搜索计算满足购物清单所需花费的最低价格
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> curNeeds, List<List<Integer>> filterSpecial, int n) {
        if (!memo.containsKey(curNeeds)) {
            int minPrice = 0;
            for (int i = 0; i < n; ++i) {
                minPrice += curNeeds.get(i) * price.get(i); // 不购买任何大礼包，原价购买购物清单中的所有物品
            }
            for (List<Integer> curSpecial : filterSpecial) {
                int specialPrice = curSpecial.get(n);
                List<Integer> nxtNeeds = new ArrayList<Integer>();
                for (int i = 0; i < n; ++i) {
                    if (curSpecial.get(i) > curNeeds.get(i)) { // 不能购买超出购物清单指定数量的物品
                        break;
                    }
                    nxtNeeds.add(curNeeds.get(i) - curSpecial.get(i));
                }
                if (nxtNeeds.size() == n) { // 大礼包可以购买
                    minPrice = Math.min(minPrice, dfs(price, special, nxtNeeds, filterSpecial, n) + specialPrice);
                }
            }
            memo.put(curNeeds, minPrice);
        }
        return memo.get(curNeeds);
    }
}
