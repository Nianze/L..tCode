// Created by Rym on 10/18/2016
public class AddBinary {
    public String addBinary(String a, String b) {
        int l1 = a.length() - 1, l2 = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 >= 0 || l2 >= 0) {
            int sum = carry;
            if (l1 >= 0) { sum += a.charAt(l1--) - '0';}
            if (l2 >= 0) { sum += b.charAt(l2--) - '0';}
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    // follow up: do not use + - * / %, only use bit manipulation
    public String addBinary(String a, String b) {
        int l1 = a.length() - 1, l2 = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 >= 0 || l2 >= 0) {
            int buf1 = 0, buf2 = 0;
            if (l1 >= 0) buf1 = a.charAt(l1--) - '0';
            if (l2 >= 0) buf2 = b.charAt(l2--) - '0';
            sb.append(buf1 ^ buf2 ^ carry);
            carry = (buf1 & buf2) | (buf1 & carry) | (buf2 & carry);
        }
        if (carry > 0) { sb.append(carry); }
        return sb.reverse().toString();
    }
    
}
