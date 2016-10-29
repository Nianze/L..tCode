// Created by Rym on 10/29/2016
public class HIndex{
    // use bucket sort, index is the citation, stores the count num
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int[] bucket = new int[citations.length+1];
        for (int c : citations) {
            if (c > citations.length) bucket[citations.length]++;
            else bucket[c]++;
        }
        int sum = 0;
        for (int i = citations.length; i >= 0; i--) {
            sum += bucket[i];
            if (sum >= i) return i;
        }
        return 0;
    }
}
