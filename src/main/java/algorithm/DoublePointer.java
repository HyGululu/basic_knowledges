package algorithm;

import suanfa0415.SuanFa0415;

/**
 * 双指针
 * 一类是「快慢指针」：主要解决链表中的问题，比如典型的判定链表中是否包含环
 * 初始化指向链表的头结点 head，前进时快指针 fast 在前，慢指针 slow 在后
 * 一类是「左右指针」：主要解决数组（或者字符串）中的问题，比如二分查找
 */
public class DoublePointer {

    /**
     * 一、快慢指针的常见算法
     */

    //1、判定链表中是否含有环
    //陷入死循环
    boolean hasCycle(ListNode head) {
        while (head != null) {
            head = head.next;
        }
        return false;
    }

    //经典解法就是用两个指针，一个跑得快，一个跑得慢。
    // 如果不含有环，跑得快的那个指针最终会遇到 null，说明链表不含环；如果含有环，快指针最终会超慢指针一圈，和慢指针相遇，说明链表含有环
    boolean hasCycle01(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //2、已知链表中含有环，返回这个环的起始位置
    //3、寻找链表的中点--->递归排序
    //还可以让快指针一次前进两步，慢指针一次前进一步，当快指针到达链表尽头时，慢指针就处于链表的中间位置
    //当链表的长度是奇数时，slow 恰巧停在中点位置；如果长度是偶数，slow 最终的位置是中间偏右
    ListNode center(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow; //slow在中点位置
    }

    //4、寻找链表的倒数第 k 个元素--->快慢指针
    //让快指针先走 k 步，然后快慢指针开始同速前进。这样当快指针走到链表末尾 null 时，慢指针所在的位置就是倒数第 k 个链表节点（为了简化，假设 k 不会超过链表长度）
    ListNode findK(ListNode head, int k) {
        ListNode fast, slow;
        slow = fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /**
     * 二、左右指针的常用算法
     * 左右指针在数组中实际是指两个索引值，一般初始化为 left = 0, right = nums.length - 1
     */

    //1、二分查找
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    //2、两数之和
    //只要数组有序，就应该想到双指针技巧,通过调节 left 和 right 可以调整 sum 的大小
    int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                //题目要求的索引从1开始的
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;//让sum大一点
            } else if (sum > target) {
                right--;//让sum小一点
            }
        }
        return new int[]{-1, -1};
    }

    //3、反转数组
    void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // swap(nums[left], nums[right])
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    //链表中倒数第 k 个节点（双指针，清晰图解）
    //https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/solution/mian-shi-ti-22-lian-biao-zhong-dao-shu-di-kge-j-11/
    public ListNode getKthFromEnd(ListNode head,int k){
        //头节点 head
        //初始化，双指针都指向头节点
        //前指针
        ListNode former=head;
        //后指针
        ListNode latter=head;
        //构建距离：前指针向前移动k步
        //构建距离：此时，latter和former间距是k
        for (int i = 0; i < k; i++) {
            former =former.next;
        }
        while (former!=null){
            //共同移动：双指针每轮一起向前移动一步
            //当前指针=null跳出，此时latter与尾部节点距离是k-1.即latter是倒数第k个节点，返回latter即可
            former =former.next;
            latter=latter.next;
        }
        //返回后指针
        return latter;
    }

}
