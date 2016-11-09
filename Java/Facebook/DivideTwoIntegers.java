// Created by Rym on 11/06/2016

// Do not use multiplication, division, and mod operator
// return MAX_INT for overflow case
public class DivideTwoIntegers {
    public int divide (int dividend, int divisor) {
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) sign = -1;
        if (divisor == 0) return Integer.MAX_VALUE;
        long lans = div(Math.abs((long)dividend), Math.abs((long)divisor));
        if (lans > Integer.MAX_VALUE) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return (int) (sign * lans);          
    }
    private long div(long divid, long divis) {
        if (divid < divis) return 0;
        long sum = divis;
        long multi = 1;
        while (sum + sum < divid) {
            sum += sum;
            multi += multi;
        }
        return multi + div(divid - sum, divis);
    }
}
