package zhenti;

import org.junit.jupiter.api.Test;

public class Study2 {
    //1.查找某个元素在有序数组中的位置
    //有序数组
    public static int binSearch(int arr[], int key) {
        int low=0;
        int high = arr.length;
        while (low<=high) {
            int mid = (low+high)/2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                high = mid - 1;
            }
            if (arr[mid] < key) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int i = binSearch(arr,  3);
        System.out.println("元素在数组中的位置: "+i);
    }


}
