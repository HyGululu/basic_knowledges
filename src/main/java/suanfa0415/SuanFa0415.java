package suanfa0415;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SuanFa0415 {
    //leetcode03数组中重复的数字--set集合（唯一性）
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();//JDK1.8后后面的<>不用写泛型
        int repeat = -1;
        //循环遍历数组中每个元素
        for (int num : nums) {
            //数组中所有元素依次加到set集合中，如果加不进去，碰到的就是重复的元素
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;

    }

    @Test
    public void findRepeatNumberTest() {
        int[] nums = {0, 3, 1, 0, 2, 5, 3};//数组定义
        int repeatNumber = findRepeatNumber(nums);
        System.out.println("数组中重复的数字是 ：" + repeatNumber);
    }

    //leetcood 05 替换空格  遍历字符串（把每一位换成字符数组中的一位）字符数组和字符串长度是3倍关系，空格1位，%20是三位，
    public String replaceSpace(String s) {
        int length = s.length();
        char[] carry = new char[length * 3];
        int size = 0;
        //遍历字符串
        for (int i = 0; i < length; i++) {
            //charAt（i）字符串换成数组遍历
            char c = s.charAt(i);
            if (c == ' ') {
                carry[size++] = '%';
                carry[size++] = '2';
                carry[size++] = '0';
            } else {
                carry[size++] = c;
            }

        }
        //把字符数组转成字符串
        String newStr = new String(carry, 0, size);
        return newStr;

    }

    @Test
    public void replaceSpaceTest() {
        String s = "We are happy.";
        String s1 = replaceSpace(s);
        System.out.println("We are happy. 替换空格为%20 ： " + s1);
    }

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] newStr = new int[size];
        for (int i = 0; i < size; i++) {
            newStr[i] = stack.pop().val;
        }
        return newStr;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void reversePrintTest() {

    }


    //最长回文子串
    public String longestPalindrome(String s) {
        return "";
    }

    @Test
    public void longestPalindromeTest() {

    }

}

