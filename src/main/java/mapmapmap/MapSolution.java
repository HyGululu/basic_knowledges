package mapmapmap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MapSolution {

    //  给定一个整型数组中有且仅有两个数字之和等于目标值，求两个数字在数组中的序号
    public int[] isHaveSum2(int arr[], int target) {
        // 定义一个res数组用于记录两个数的下标并返回；
        int[] res = new int[2];
        ///定义一个Hashmap，遍历数组后存放其中，其中key为数组中元素的值；value为其对应的下标；
        HashMap<Integer, Integer> map = new HashMap<>();
        //遍历数组，将数据添加到hashmap中；
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        //遍历数组，用target-nums[i]得到差；
        for (int i = 0; i < arr.length; i++) {
            int t = target - arr[i];
            //判断这个差是否在hashmap中，也就是另一个待找出的数；
            if (map.containsKey(t)) {
                res[0] = i;
                res[1] = map.get(t);
                break;
            }
        }
        return res;
    }

    @Test
    public void isHaveSum2Test() {
        int[] a = {1, 2, 3, 4, 5};
        int[] haveSum2 = isHaveSum2(a, 5);
        for (int i = 0; i < haveSum2.length; i++) {
            System.out.println("数组中是否有两数之和等于目标值,两个数字在数组中的序号：" + haveSum2[i]);

        }
    }

}
