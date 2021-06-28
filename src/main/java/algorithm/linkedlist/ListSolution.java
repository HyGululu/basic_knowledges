package algorithm.linkedlist;


import org.junit.jupiter.api.Test;

/*
反转链表思想
pre当前节点前一个节点，初始的时候pre为空
Cur当前节点
temp保持当前节点后续节点，改变当前节点指针指向(防止链表断开)
1–2–3–4–5—null
断开原有指针指向，改变指向
 */
public class ListSolution {
    //leetcode-206-反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;//cur为空，反转结束，返回cur前一个节点pre
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void reverseListTest() {
        //创建链表
        //创建首结点
        ListNode nodeStr = new ListNode(0);
        //创建下一个结点
        ListNode nextNode;
        //指向首结点
        nextNode = nodeStr;
        //创建链表
        for (int i = 0; i < 5; i++) {
            //创建新的结点
            ListNode newNode = new ListNode(i);
            //把新的结点连起来
            newNode.next = newNode;
            //把结点往后移
            newNode = nextNode.next;

        }
        //nextNode指向最后一个结点
        //重新指向首结点
        nextNode = nodeStr;
        //打印
        while (nextNode != null) {
            System.out.println("第一个结点值：" + nextNode.val);
            nextNode = nextNode.next;
        }



    }
}
