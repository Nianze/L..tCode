// Created by Rym on 11/02/2016

public class RomanToInteger {
    public int romanToInt(String s) {
        int ans = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
            case 'I':
                ans += (ans >= 5 ? -1 : 1 );
                break;
            case 'V':
                ans += 5;
                break;
            case 'X':
                ans += 10 * (ans >= 50 ? -1 : 1);
                break;
            case 'L':
                ans += 50;
                break;
            case 'C':
                ans += 100 * (ans >= 500 ? -1 : 1);
                break;
            case 'D':
                ans += 500;
                break;
            case 'M':
                ans += 1000;
                break;
            }
        }
        return ans;
    }
}
