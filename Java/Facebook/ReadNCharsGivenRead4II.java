// Created by Rym on 10/31/2016
public class Reader4II extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int buffPoint = 0; // mark the last read's position
    private int buffCount = 0; // store each time's return value by read4
    private char[] smallBuf = new char[4]; // cache the read4 chars
    public inn read(char[] buf, int n) {
        int pointer = 0;
        while (pointer < n) {
            if (buffPoint == 0) {
                buffCount = read4(smallBuf);
            }
            if (buffCount == 0) break;
            while (pointer < n && buffPoint < buffCount) {
                buf[pointer++] = smallBuf[buffPoint++];
            }
            if (buffPoint == buffCount) {
                buffPoint = 0;
            }
        }
        return pointer;
    }
}
