// Created on 10/16/16 by Rym
public class CountAndSay {
    /*
     * Explanation:
     * build the final result one layer by one layer
     * in each layer, read and iterate through the previously built result
     * from left to right, count the same number
     * and append the count and the number in the new layer's result 
     */
    public String countAndSay(int n) {
        String prevLayer = "1";
        while (--n > 0) {
            StringBuilder newLayer = new StringBuilder();
            for (int i = 0; i < prevLayer.length(); i++) {
                int count = 1;
                while (i < prevLayer.length() - 1 &&
                       prevLayer.charAt(i) == prevLayer.charAt(i+1)) {
                    i++;
                    count++;
                }
                newLayer.append("" + count + prevLayer.charAt(i));
            }
            prevLayer = newLayer.toString();
        }
        return prevLayer;
    }

    public static void main(String[] arg) {
        CountAndSay cas = new CountAndSay();
        System.out.print(cas.countAndSay(1));
        System.out.print(cas.countAndSay(2));
        System.out.print(cas.countAndSay(3));
        System.out.print(cas.countAndSay(4));
    }
}
