// Created by Rym on 11/02/2016

public class MyPow {
    // recursive
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) { 
            if (n == Integer.MIN_VALUE) {
                return 1/x * myPow(x, n+1);
            } else {
                return myPow(1/x, -n);
            }
        }
        return (n%2 == 0) ? (myPow(x*x, n/2)) : x * myPow(x*x, n/2);        
    }
    
    // iterative
    public double myPow(double x, int n) {
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                x = 1 / (x * x);
                n = - (n + 1);
            } else {
                x = 1 / x;
                n = -n;
            }
        }
        double ans = 1.0;
        while (n > 0) {
            if ( n%2 == 1) {
                ans *= x;
            }
            x *= x;
            n /= 2;
        }
        return ans;        
    }
}
