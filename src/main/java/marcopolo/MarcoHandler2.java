package marcopolo;

/**
 * @Description 方波信号
 * @Author cy
 * @Date 2023/5/26 18:42
 **/
public class MarcoHandler2 {
    public static void handle(String signals) {
        int start = 0;
        int end = 0;
        int pre = 0;
        int ansStart = -1;
        int ansEnd = -1;
        int ansLen = Integer.MIN_VALUE;
        while (true) {
            if (signals.charAt(start) == '0') {
                break;
            }
            start++;
        }
        end = start + 1;
        pre = start;
        boolean isJiaoti = true;
        while (end < signals.length()) {
            // 相等
            if (signals.charAt(end) == signals.charAt(pre)) {
                if (signals.charAt(end) == '0') {
                    if (start == pre) {
                        // 连续0的情况
                        start++;
                        pre = start;
                        end++;
                    } else {
                        // 到达一个信号的结束
                        int len = end - start;
                        if (isJiaoti && len > ansLen) {
                            ansLen = len;
                            ansStart = start;
                            ansEnd = end;
                        }
                        start = end;
                        pre = start;
                        isJiaoti = true;
                        end++;
                    }
                } else {
                    // 相等等于1的情况
                    end++;
                    pre++;
                    isJiaoti = false;
                }
            } else {
                // 当前和前一个不相等
                end++;
                pre++;
            }
        }

        // 判断最后一个情况
        // 1、最后一个end不为0不是一个信号
        // 2、end为0,判断start pre end是否是连续0
        // 即上述判断是否为一个信号
        // 是的话，判断是否为交替的，是的话，再判断是否为最长。
        //if (signals.charAt())
    }
}
