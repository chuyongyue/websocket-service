package org.algo.class04;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/6/7
 * Time: 0:22
 * Description: 归并排序 递归和非递归实现
 */
public class Code01_MergeSort {
    // 递归实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // 让arr[L...R]范围上的数有序
    public static void process(int[] arr, int L, int R) {
        // basecase定义
        if (L == R) {
            return;
        }
        // 或者 (L + R) / 2
        int mid = L + (R - L) >> 1;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        // 下面是merge
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int step = 1;
        int N = arr.length;
        while (step < N) {
            int L = 0;
            while (L < N) {
                int M = 0;
                // 从长度推，避免越界
                if (N - L >= step) {
                    M = L + step - 1;
                } else {
                    M = N - 1;
                }
                // L....M
                if (M == N-1) {
                    break;
                }
                int R = 0;
                if (N - 1 - M >= step) {
                    R = M + step;
                } else {
                    R = N - 1;
                }
                // L...MM+...R merge
                merge(arr, L, M, R);

                // L = R + 1; 直接写有可能越界
                if (R == N-1) {
                    break;
                } else {
                    L = R + 1;
                }
            }
            if (step > (N / 2)) {
                break;
            } else {
                step *= 2;
            }
        }
    }
}
