// Created by Rym on 2016.12.9

public class Solution {
    public String decodeString(String s) {
        Deque<String> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        s1.push("");
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int start = i;
                while (Character.isDigit(s.charAt(i))) { i++;}
                s2.push(Integer.parseInt(s.substring(start, i--))); // here i-- is to cancel the i++ in for loop
            } else if (s.charAt(i) == '[') {
                s1.push("");
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                int times = s2.pop();
                String str = s1.pop();
                for (int j = 0; j < times; j++) { sb.append(str); }
                s1.push(s1.pop() + sb.toString());
            } else {
                s1.push(s1.pop() + s.charAt(i));
            }
        }
        return s1.pop();
    }
}
