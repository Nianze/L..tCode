// Created by Rym on 11/03/2016

// Note the corner case:
// "/../" -> "/", "/a//b" -> "/a/b"
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque();
        for (String s : path.split("/")) {
            if (s.equals(".") || s.equals("")) continue;
            if (s.equals("..")) { 
                if (!deque.isEmpty()) deque.removeLast(); 
            } else deque.addLast(s);
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) { sb.append("/").append(deque.removeFirst()); }
        if (sb.length() == 0) sb.append("/");
        return sb.toString();        
    }
}
