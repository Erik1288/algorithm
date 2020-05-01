package com.eric.algorithm;

public class HeapSort {
    public static void main(String[] args) {
        int NO_MEANING = 0;
        int[] arr = {NO_MEANING, 3, 2, 1, 0, -1, -2, -3};
        System.out.println("Before heap:");
        printArray(arr);
        heap_sort(arr);
        System.out.println("After heap sort:");
        printArray(arr);
    }

    public static void heap_sort(int[] arr) {
        if (arr == null || arr.length - 1 <= 1) {
            return;
        }

        int size = arr.length - 1;

        // 从第一个叶子节点开始进行堆化
        for (int i = size / 2; i >= 1; i--) {
            heapfy_with_sink(arr, i, size);
        }

        for (;size > 1;) {
            swap(arr, 1, size);
            size --;
            heapfy_with_sink(arr, 1, size);
        }

    }

    public static void heapfy_with_sink(int[] arr, int root, int size) {
        int cur = root;
        while (cur * 2 <= size) {
            // 没有到底，至少有leftChild
            int sink = cur * 2;

            // 看看rightChild是否比leftChild还要大
            if (sink + 1 <= size && arr[sink] < arr[sink + 1]) sink = sink + 1;
            if (arr[cur] > arr[sink]) break;
            swap(arr, cur, sink);

            // 往下移动，具体向left还是right，需要看sink的值
            cur = sink;
        }
    }

    public static void printArray(int[] arr) { //打印数组
        System.out.print("{");
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("}");
    }

    public static void swap(int[] arr, int index1, int index2) { //交换元素
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}