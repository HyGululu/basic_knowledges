package algorithm.stringokok;

import org.junit.jupiter.api.Test;

public class StringSolution2 {

    /**
     * 字符串数字相加
     * @param str
     */
    public void numPlusInString(String str) {
        int num = 0;
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            try {
                int parseInt = Integer.parseInt(charArray[i] + "");
                num += parseInt;
                System.out.println(parseInt + " ");
            } catch (NumberFormatException exception) {
                exception.getMessage();
            }
        }
        System.out.println("这些数字之和：" + num);
    }


    @Test
    public void testNumPlusInString() {
        String str1 = "21aaa24";
        String str2 = "1ee7";
        String str = str1 + str2;
        numPlusInString(str);
    }
}



