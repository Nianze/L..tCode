package FibonacciCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lnz on 11/20/16.
 */
public class Encoding {
    public static String fibonacciEncoding(int n) {
        if (n < 1) return "";
        int idx = 0;
        List<Integer> fib = new ArrayList<>(Arrays.asList(1,2));
        // find the max fib index that is less or equal to n
        while (fib.get(idx+1) <= n) {
            fib.add(fib.get(idx) + fib.get(idx+1));
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        while (idx >= 0) {
            if (fib.get(idx) <= n) {
                sb.append('1');
                n -= fib.get(idx--);
            } else {
                sb.append('0');
                idx--;
            }
        }
        return sb.reverse().toString();
    }
}
