package recursion_lecture;

import java.util.Arrays;

public class recursiveBinarySearch {
    public static int binarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        int mid = arr.length / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(Arrays.copyOfRange(arr, 0, mid), target);
        } else {
            int result = binarySearch(Arrays.copyOfRange(arr, mid + 1, arr.length), target);
            return (result == -1) ? -1 : mid + 1 + result;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int target = 5;
        System.out.println("Index " + binarySearch(arr, target));
    }
}

