package zhenti;

import org.apache.kahadb.index.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Study3 {
    /* 数组
     */
    //数组中的第K个最大元素
    public int findKthLargest(int[] nums, int k) {
        System.out.println("数组长度是： " + nums.length);
        //给数组排序
        Arrays.sort(nums);
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            System.out.println("遍历数组： " + nums[i]);
        }
        //打印数组元素
        System.out.println("排序后数组结果： " + Arrays.toString(nums));
        return -1;
    }


    @Test
    public void findKthLargestTest() {
        int nums[] = new int[]{1, 3, 2, 5, 4};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println("数组中的第K个最大元素是： " + kthLargest);
        System.out.println("xy的toString： " + myString(nums));

    }

    //给数组排序-冒泡排序
    public void bubbleSort(int[] a){
        for (int i = 0; i < a.length; i++) {
            if (a[i]>a[i+1]){

            }
        }
    }


    //打印数组元素
    public String myString(int[] a) {
        //非空校验
        if (a == null) {
            return "arr is null";
        }
        if (a.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; ; i++) {
            sb.append(a[i]);
            if (i == a.length-1) {
                return sb.append("]").toString();
            }
            sb.append(",");
        }
    }

    /* 链表
     */
    public ListNode reverseList(ListNode head) {
        return new ListNode();
    }
}
