package algorithm;

import java.util.*;

/**
 * 首先把数组排序再考虑双指针技巧
 * HashMap 或者 HashSet 也可以帮助我们处理无序数组相关的简单问题
 * nums = [3,1,3,6],target = 6   ===>   [0,2]  ,因为3+3=6
 */
public class TowSum {

    //1、暴力解法：穷举数组中的数  时间复杂度O(n^2)  空间复杂度O(1)
    int[] towSum(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]==target-nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        //数组中不存在这个两个数
        return new int[]{-1,-1};
    }

    //2、哈希表，减少时间复杂度  时间复杂度 O(N)，空间复杂度O(N)
    int[] towSumHash(int[] nums,int target){
        int n =nums.length;
        HashMap<Integer, Integer> hashIndex = new HashMap<>();
        //构造一个哈希表，元素映射到相应的索引
        for (int i = 0; i < n; i++) {
            hashIndex.put(nums[i],i);
        }

        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            //如果other存在并且不是num[i]本身
            if (hashIndex.containsKey(other)&&hashIndex.get(other)!=i){
                return new int[]{i,hashIndex.get(other)};
            }

        }
        return new int[]{-1,-1};
    }
}

//TowSumII，设计一个类，拥有两个API
abstract class TowSumII{
    //向数据结构中添加一个数number
     abstract void add(int number);
     //寻找当前数据结构中是否存在两个数的和未value
     abstract boolean find(int value);
}

//实现上面的API，使用一个哈希表辅助find方法
class TowSumII01{
    Map<Integer,Integer> freq = new HashMap<>();

    public void add (int number){
     //记录number出现的次数
     freq.put(number,freq.getOrDefault(number,0)+1);
    }

    public boolean find(int value ){
        for (Integer key:freq.keySet()){
            int other = value-key;
            //情况一:add 了 [3,3,2,5] 之后，执行 find(6)，由于 3 出现了两次，3 + 3 = 6，所以返回 true
            if (other == key&&freq.get(key)>1){
                return true;
            }
            //情况二:add 了 [3,3,2,5] 之后，执行 find(7)，那么 key 为 2，other 为 5 时算法可以返回 true
            if (other!=key&&freq.containsKey(other)){
                return true;
            }
        }
        return false;
    }
}

class TowSumII02{
    //sum 中就储存了所有加入数字可能组成的和
    Set<Integer> sum =new HashSet<>();
    List<Integer> nums = new ArrayList<>();

    public void add(int number){
        //记录所有可能组合的和
        for (int n:nums) {
            sum.add(n+number);
            nums.add(number);
        }
    }
    public boolean find(int value){
        //每次 find 只要花费 O(1) 的时间在集合中判断一下是否存在就行
        return sum.contains(value);
    }
}

//给的数组是有序的--->双指针
class TowSumIII{
    int[] twoSum(int[]nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int sum = nums[left]+nums[right];
            if (sum == target){
                return new int[]{left,right};
            }else if(sum<target){
                left++;//让sum大一点
            }else if(sum>target){
                right--;//让sum小一点
            }
        }
        //不存在这样的两个数
        return new int[]{-1,-1};
    }

}