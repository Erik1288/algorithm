package com.eric.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/2/14
 */
public class QiNiuYun {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "abc");

        System.out.println(map.get(null));


//        test1(new int[] {3, 7, 9, 12, 13, 15}, new int[] {4, 8, 9, 13, 14});
    }



    public static List<Integer> test1(int[] array1, int[] array2) {
        int cur1 = 0;
        int cur2 = 0;

        List<Integer> resultList = new ArrayList<>();

        while (cur1 <= array1.length && cur2 <= array2.length) {
            if (cur1 == array1.length) { // array1 is over
                break;
            } else if (cur2 == array2.length) { // array2 is over
                while (cur1 != array1.length) { // iter over array1
                    if (array1[cur1] != array2[array2.length - 1]) {
                        resultList.add(array1[cur1]);
                    }
                    cur1 ++;
                }
                break;
            }



            if (array1[cur1] < array2[cur2]) { // 如果数组1的值比数组2的值小，就加入结果集
                resultList.add(array1[cur1]);
                cur1 ++ ;
            } else if (array1[cur1] == array2[cur2]) { // 由于是升序的，如果相等，那么跳过该数字
                cur1 ++;
                cur2 ++;
            } else if (array1[cur1] > array2[cur2] && cur2 < array2.length) { // 如果数组2的值比数组1的值小，往后即可
                cur2 ++;
            }
        }


        System.out.println(resultList);
        return resultList;
    }
}
