package algorithm.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//排序
public class SortSolution {

    //冒泡排序
    public void bubbleSort(int[] arr) {
        int temp = 0;
        //第一层循环，控制趟数
        for (int i = 0; i < arr.length - 1; i++) {
            //第二层循环，控制第i+1趟时，要比较的次数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //交换元素
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Test
    public void bubbleSortTest() {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
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
        int i, j, temp, t;
        i = low;
        j = high;
        //temp是基准位
        temp = arr[low];

        while (i < j) {
            //先看左边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看右边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足交换条件
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
            //最后将基准为i和j相等位置的数字交换
            arr[low] = arr[i];
            arr[i] = temp;
            //递归调左半边数组
            quickSort(arr, low, j - 1);
            //递归调右半边数组
            quickSort(arr, j + 1, high);
        }
    }

    @Test
    public void quickSortTest() {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("quickSort排序后：" + Arrays.toString(arr));

    }
}
