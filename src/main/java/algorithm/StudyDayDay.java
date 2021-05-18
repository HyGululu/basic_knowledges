package algorithm;

import java.util.HashSet;
import java.util.Set;

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
    //剑指 Offer 03. 数组中重复的数字（哈希表 / 原地交换，清晰图解）
    /*
    算法流程：
初始化： 新建 HashSet ，记为 dic ；
遍历数组 nums 中的每个数字 num ：
当 num 在 dic 中，说明重复，直接返回 num ；
将 num 添加至 dic 中；
返回 -1 。本题中一定有重复数字，因此这里返回多少都可以。


链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    //方法一：哈希表 / Set
    public int findRepeatNumber(int[] nums){
        Set<Integer> dic = new HashSet<>();
        for (int num:nums) {
            if (dic.contains(num)) {
                return num;
            }
            dic.add(num);
        }
        return -1;
    }
}
