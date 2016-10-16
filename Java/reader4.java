/* The read4 API is defined in the parent class Reader4. 
   int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        boolean eof = false;
        char[] temp = new char[4];
        while (!eof && count < n) {
            int num = read4(temp);
            if (num < 4) {
                eof = true;
            }
            for (int i = 0; i < num && count < n;) {
                buf[count++] = temp[i++];
            }
        }
        return count;
    }
}
