package com.eric.algorithm;

public class MergeSort {
    private static int[] tmp;
    public static void main(String[] args) {
        int[] a = {5, 3, 9};
//        int[] a = {5, 3, 9, 6, 1, 2, 4, 7};
        tmp = new int[a.length];

        merge_sort(a, 0, a.length - 1);

        System.out.println(a);
    }

    public static void merge_sort(int[] a, int l, int r) {
        if (l >= r) return;

        int m = (l + r) / 2;
        merge_sort(a, l, m);
        merge_sort(a, m + 1, r);
        merge(a, l, m, r);
    }

    private static void merge(int[] a, int l, int m, int r) {
        int lb = l; // 左半部分开头
        int rb = m + 1; // 右半部分开头

        for (int i = l; i <= r; i++) {
            tmp[i] = a[i];
        }

        for (int i = l; i <= r; i++) {
            if (lb > m)                 a[i] = tmp[rb++];
            else if (rb > r)            a[i] = tmp[lb++];
            else if (tmp[lb] < tmp[rb]) a[i] = tmp[lb++];
            else                        a[i] = tmp[rb++];
        }

    }
}
