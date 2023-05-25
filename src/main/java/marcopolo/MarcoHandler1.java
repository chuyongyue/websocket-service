package marcopolo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Description
 * @Author cy
 * @Date 2023/5/23 16:44
 **/
public class MarcoHandler1 {
    public static void main(String[] args) {

    }

    public static void handle(int[] arr,int curNum) {
        int left = 0;
        int right = 0;
        int len = 0;
        int maxLen = 0;
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        while (right < arr.length) {
            if (arr[right] != curNum) {
                if (len != 0){
                    maxLen = Math.max(maxLen, len);
                    int[] indexes = new int[2];
                    indexes[0] = left;
                    indexes[1] = right;
                    List<int[]> resList = map.get(len);
                    if (resList == null) {
                        resList = new ArrayList<>();
                    }
                    resList.add(indexes);
                    map.put(len, resList);
                }
                left = right;
                len = 0;
            } else {
                len++;
            }
            right++;
        }
        if (len != 0) {
            int[] item = new int[2];
            item[0] = left;
            item[1] = right;
            List<int[]> resList = map.get(len);
            if (resList == null) {
                resList = new ArrayList<>();
            }
            resList.add(item);
            map.put(len, resList);
        }
        List<int[]> list = map.get(maxLen);
        int ans = -1;
        int mid = arr.length / 2;
        for (int i = 0; i < list.size(); i++) {
            int[] locals = list.get(i);
            if (locals[0] == 0) {
            }
            if (locals[1] == 1) {

            }
        }
    }

    public static void getOther(TreeMap<Integer, List<int[]>> map, int local) {

    }

    private static void print(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
