// Create by Rym on 11/16/2016

public class ReadNCharactersGivenRead4 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int pointer = 0;
        char[] smallbuf = new char[4];
        while (pointer < n) {
            int count = read4(smallbuf);
            int smallpoint = 0;
            while (pointer < n && smallpoint < count) {
                buf[pointer++] = smallbuf[smallpoint++];
            }
            if (count < 4) break;
        }
        return pointer;
    }
}
