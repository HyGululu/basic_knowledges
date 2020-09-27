package algorithm;


/**
 * 递归
 * 递归代码最重要的两个特征：结束条件和自我调用
 */
public class RecursiveTest {

    /**
     * 分治算法
     归并排序，典型的分治算法；分治，典型的递归结构。
     分治算法可以分三步走：分解 -> 解决 -> 合并

     分解原问题为结构相同的子问题。
     分解到某个容易求解的边界之后，进行第归求解。
     将子问题的解合并成原问题的解。
     */
    void sort(Comparable[] arr, int low, int high) {
        //int mid = (low+hight)/2;//加法可能会发生溢出,Java运算中不支持无符号整数,
        // 有一种是这样写的low + (high - low) >>> 1，在Java中>>>和>>的区别，则在于无符号和有符号。如果使用>>，会将符号位也参与运算。
        int mid = low + (high - low) / 2;

        if (low >= high) {
            return;
        }
        //左半边排序
        sort(arr, low, mid);
        //右半边排序
        sort(arr, mid, high);
        //合并两边  merge(arr,low,mid,high);
    }

    //给一个链表头，计算它的长度
    /**
     * 遍历二叉树
     * 给一课二叉树，和一个目标值，节点上的值有正有负，返回树中和等于目标值的路径条数，让你编写 pathSum 函数：
     * LeetCode PathSum III： https://leetcode.com/problems/path-sum-iii/ */


    //给他一个节点和一个目标值，他返回以这个节点为根的树中，和为目标值的路径总数
    int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //以自己为开头的路径数目
        int pathImLeading = count(root, sum);
        //左边路径总数
        int leftPathSum = pathSum(root.left, sum);
        //右边路径总数
        int rightPathSum = pathSum(root.right, sum);

        return leftPathSum + rightPathSum + pathImLeading;
    }

    //给他一个节点和一个目标值，他返回以这个节点为根的树中，能凑出几个以该节点为路径开头，和为目标值的路径总数
    int count(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        //自己作为单独路径
        int isMe = (node.val == sum) ? 1 : 0;
        //左边的，能凑出几个
        int leftBrother = count(node.left, sum - node.val);
        //右边的，能凑出几个
        int rightBrother = count(node.right, sum - node.val);
        //自己，能凑出几个
        return leftBrother + rightBrother + isMe;
    }


}

