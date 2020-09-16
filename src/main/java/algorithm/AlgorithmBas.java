package algorithm;

/**
 * 数据结构的基本操作：遍历+访问
 * 线性：for/while迭代
 * 非线性：递归
 */
public class AlgorithmBas {

    public static void main(String[] args) {

    }

    //1、数组的遍历框架，典型的线性迭代结构
    public void  traverseArrays(int[] arrays){
        for (int i = 0; i < arrays.length; i++) {
            //迭代访问arrays[i]
        }
    }

    //2、链表的遍历框架，兼具迭代和递归结构
    public void  traverseList1(ListNode head){
        for (ListNode p = head; p!=null;p=p.next){
            //迭代访问p.val
        }
    }
    public void  traverseList2(ListNode head){
        //递归访问head.val
        traverseList2(head.next);
    }

    //3、二叉树的遍历框架，典型的非线性递归遍历结构
    public void  traverseTreeNode(TreeNode root){
        traverseTreeNode(root.left);
        traverseTreeNode(root.right);
    }
}

//基本的单链表节点
class ListNode{
    int val;
    ListNode next;
}

//基本的二叉树节点
class TreeNode{
    int val;
    TreeNode left,right;
}