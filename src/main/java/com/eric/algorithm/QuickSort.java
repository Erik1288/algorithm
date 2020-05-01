package com.eric.algorithm;

import static com.eric.util.CommonOperation.swap;
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 2, 2, 2};
//        int[] arr = {3, 2, 2, 2, 2};
        int[] arr = {5, 3, 9, 6, 1, 2, 4, 7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(arr);
    }

    public static void quickSort(int[] a, int l, int r) {
        if (l >= r) return ;

        int partition = partition(a, l, r);
        quickSort(a, l, partition - 1);
        quickSort(a, partition + 1, r);
    }

    private static int partition(int[] a, int l, int r) {
        int p = l;
        while (l < r) {
            while (a[r] >= a[p] && l < r) r--;
            while (a[l] <= a[p] && l < r) l++;
            if (l == r) break;
            swap(a, l, r);
        }
        swap(a, p, l);
        return l;
    }

    private static int random_partition(int[] a, int l, int r) {
        int c = random(l, r);
        swap(a, l, c);

        return partition(a, l, r);
    }

    private static int random(int l, int r) {
        return 0;
    }
}
