package algorithm.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//排序
public class SortSolution {

    //冒泡排序
    public void bubbleSort(int[] arr) {

        int temp = 0;
        //比较到数组尾部，每比较一次，确定最后位置的数据后，尾部位置依次递减
        for (int end = arr.length - 1; end > 0; end--) {
            //boolean sortOk=true;
            //从头开始，相邻的两个元素比较，比较后加1
            for (int begin = 1; begin <= end; begin++) {
                if (arr[begin] < arr[begin - 1]) {
                    //sortOk =false;
                    //交换元素
                    temp = arr[begin];
                    arr[begin] = arr[begin - 1];
                    arr[begin - 1] = temp;

                }
            }
            //if (sortOk){break;}
        }
    }

    @Test
    public void bubbleSortTest() {
        //int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        int[] arr = {1, 2, 2, 3, 4, 4, 7, 7, 8, 9, 10, 19, 62};
        bubbleSort(arr);
        System.out.println("bubbleSort排序后：" + Arrays.toString(arr));
    }
    /*
        BubbleSort时间复杂度：O(n^2)
     */


    //快速排序
    public void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int left, right, pivot, temp;
        left = low;
        right = high;
        //pivot是中心轴
        pivot = arr[low];

        while (left < right) {
            //先看左边，依次往左递减
            while (pivot <= arr[right] && left < right) {
                right--;
            }
            //再看右边，依次往右递增
            while (pivot >= arr[left] && left < right) {
                left++;
            }
            //如果满足交换条件
            if (left < right) {
                temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
            //最后将基准（中心轴点）为left和right相等位置的数字交换
            arr[low] = arr[left];
            arr[left] = pivot;
            //递归调左半边数组
            quickSort(arr, low, left - 1);
            //递归调右半边数组
            quickSort(arr, right + 1, high);
        }
    }

    @Test
    public void quickSortTest() {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("quickSort排序后：" + Arrays.toString(arr));

    }

    public void quickSort2(int[] nums, int low, int high) {

    }
}

/*
快速排序思想
随机数列（19，97，9，17，1，8），对所有数字遍历，在其中选择一个作为基准点（Basic）选择19
左标记（19）：从左往右移动，找比Basic大的数字，放到序列的右边
右标记（8）：从又往左移动，找比Basic小的数字，放到序列的左边
两坐标重合，Basic（19）放到重合位置
（8，1，9，17，19，97）
发现左子序列（8，1，9，17）都比19小
右子序列（97）比19大
再对左子序列和右子序列重复操作
（8，1，9，17），选取8作为Basic
 */