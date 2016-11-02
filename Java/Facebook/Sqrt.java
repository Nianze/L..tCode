// Created by Rym on 11/1/2016

public class Sqrt {
    // If want to calculate the square root of a
    // that is to get x where x^2 = a.
    // that is to get the zero-point for function f(x) = x^2 - a
    // Newton Method: x_1 = x_0 - f(x_0) / f'(x_0)
    // so f(x) = x^2 - a, f'(x) = 2x
    // we get sequence: x_1 = (x_0 + a / x_0) / 2
    public int mySqrt (int x) {
        long ans = x; // use long in case that ans = integer.max_value, then ans + x/ans > max_value
        while (ans * ans  > x / ans) { // to avoid overflow, do not use ans * ans
            ans = (ans + x / ans) / 2;
        }
        return (int) ans;
    }
    
    // use binary search
    public int mySqrt (int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid;
            } else if (mid + 1 > x / (mid + 1)){
                return mid;
            } else {
                left = mid;
            }
        }
        if (right < x / right) return right;
        return left;
    }
}
