import org.junit.Test;

/**
 * @Created by zhang on 2021/9/23  16:30
 */
public class LC56 {

    @Test
    public void lengthOfLastWord(){
        String str = "   fly me   to   the moon  ";
        int lastWord = ToCharArray(str);
        System.out.println(lastWord);
    }

    /*
        无敌函数法
     */
    public int Function(String s) {
        String trim = s.trim();
        String[] split = trim.split(" ");
        return split[split.length-1].length();
    }

    public int ToCharArray(String s){
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }

}
