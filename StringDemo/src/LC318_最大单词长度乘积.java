import org.junit.Test;

/**
 * @Created by zhang on 2021/11/17  19:37
 */
public class LC318_最大单词长度乘积 {

    @Test
    public void test(){
        int res = maxProduct(new String[]{
                "abcw","baz","foo","bar","xtfn","abcdef"
        });
        System.out.println(res);
    }

    public int maxProduct(String[] words) {
        int length = words.length;
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                // 每个 masks[i] 记录 第 i 个字符串的 数字，a 代表第一个1，b 代表 第二位的 1 ...
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                // 意味着没有数字重叠
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }
}
