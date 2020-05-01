package com.eric.leetcode.heap;

import org.junit.Assert;

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(10, (o1, o2) -> o1 >= o2 ? -1: 1);
        heap.add(12);
        heap.add(15);
        heap.add(13);
        heap.add(10);
        System.out.println(heap.peek());

        Assert.assertEquals(5, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (o1, o2) -> o1 - o2);
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else {
                if (num > minHeap.peek()) { // 如果新来的比最小的大，那么它有可能成结果，需要加入
                    minHeap.poll(); // 剔除最小的
                    minHeap.add(num);
                }
            }
        }

        return minHeap.peek();
    }
}
