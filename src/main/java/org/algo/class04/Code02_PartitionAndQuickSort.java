package org.algo.class04;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/6/7
 * Time: 23:00
 * Description: 快速排序
 */
public class Code02_PartitionAndQuickSort {

    // 拿该数组的最右层一个数作为划分数
    // <=num | > num
    //无序    | 无序
    public static void splitNum1(int[] arr) {
        int lessEqualR = -1;
        int mostR = arr.length - 1;
        int index = 0;
        while (index < arr.length) {
            if (arr[index] <= arr[mostR]) {
                swap(arr, lessEqualR + 1, index);
                lessEqualR++;
                index++;
            } else {
                index++;
            }
        }
    }

    // 拿该数组的最右层一个数作为划分数
    // <num  |  ==num | > num
    //无序    |        |  无序
    public static void splitNum2(int[] arr) {
        int lessR = -1;
        int moreL = arr.length - 1;
        int mostR = arr.length - 1;
        int index = 0;
        while (index < moreL) {
            if (arr[index] < arr[mostR]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[mostR]) {
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        swap(arr, moreL, arr.length - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int L, int R) {
        return 0;
    }
}
