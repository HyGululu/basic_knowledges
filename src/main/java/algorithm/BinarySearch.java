package algorithm;

/**
 * 二分查找
 * 1、找一个数，存在返回索引，不存在返回-1
 */
public class BinarySearch {

    //1、找一个数，存在返回索引，不存在返回-1

    int binarySearchNum(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }
        }
        return -1;
    }

    /*二分查找框架
    int binarySearch(int[]nums,int target){
        int left=0,right = ……;

        while (……){
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                ……
            }else  if(nums[mid]<target){
                left = ……
            }else if (nums[mid]>target){
                right =……
            }
        }

        return ……;
    }*/
}
