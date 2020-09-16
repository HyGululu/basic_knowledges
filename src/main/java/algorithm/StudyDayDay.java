package algorithm;

import java.util.HashSet;

public class StudyDayDay {
    public static void main(String[] args) {
        int[] arrays = new int[7];
        arrays[0] = 2;
        arrays[1] = 3;
        arrays[2] = 1;
        arrays[3] = 0;
        arrays[4] = 2;
        arrays[5] = 5;
        arrays[6] = 3;
        int solution = Solution(arrays);
        System.out.println("结果是："+ solution);
    }

    /**
     * 找出数组中的重复数字
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     */
    public static int Solution(int[] ints) {
        HashSet<Integer> set = new HashSet<>();
        int help = -1;

        for (int num :ints){
            if (set.contains(num)){
                help = num;
                break;
            }else {
                set.add(num);
            }

        }
        return help;
    }
}
