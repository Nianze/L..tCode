// Created by Rym on 11/03/2016

public class MultiplyStrings {
    // refer to the graph at
    // https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation/2
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] buffer = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                mul += buffer[i+j+1];
                buffer[i+j] += mul / 10;
                buffer[i+j+1] = mul % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : buffer) if (!(sb.length() == 0 && i == 0)) sb.append(i);
        return (sb.length() == 0) ?  "0" : sb.toString();
    }
}
