package marcopolo;

import util.InputUtil;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 星际MVP争夺战
 */
public class MVPHandler {
    public static void main(String[] args) {
        Scanner input = new Scanner(InputUtil.getInput("marcopolo/input1"));
        while (input.hasNextLine()) {
            int t = input.nextInt();
            input.nextLine();
            String[] strs = input.nextLine().split(" ");
            int[] ints = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
            int total = 0;
            // 将数组排序
            Arrays.sort(ints);
            int max = ints[t-1];
            for (int num: ints) {
                total = total + num;
            }

            int res = 0;
            for (int i = max; i <= total / 2 ; i++) {
                // total 可以被MVP得分整除
                if (total % i == 0) {
                    // 这个数组中的值为-1，代表该位置的得分已被使用
                    int[] temp = new int[t];
                    if (handle(ints, i)) {
                        res = i;
                        break;
                    }
                }
            }
            System.out.println(res == 0 ? total : res);
        }
    }

    // 处理该可能
    public static boolean handle(int[] ints, int mvp) {
        int[] temp = new int[ints.length];
        for (int i = ints.length - 1; i >= 0; i--) {
            getHandle(ints, mvp, temp, i);
        }

        for (int soc: temp) {
            if (soc != -1) {
                return false;
            }
        }
        return true;
    }


    public static void getHandle(int[] ints, int mvp, int[] temp, int start) {
        if (mvp == 0) {
            return;
        }
        for (int i = start; i >= 0 ; i--) {
            if (temp[i] != -1) {
                if (mvp - ints[i] >= 0) {
                    temp[i] = -1;
                    getHandle(ints, mvp - ints[i], temp, i - 1);
                }
            }
        }
    }
}
