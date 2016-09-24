public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    // three state: 00 -> 01 -> 10 -> 00
    // 'ones = ones ^ A[i]; if (twos == 1) then ones = 0' tansformed to 'ones = (ones ^ A[i]) & ~twos'. "if statement" is for "10->00"
    // same for bitTwo: 'twos = twos ^ A[i]; if (ones* == 1) then twos = 0' and 'twos = (twos ^ A[i]) & ~ones'. "if statement" is for "00->01"
    public int singleNumberII(int[] A) {
        int bitOne = 0, bitTwo = 0;
        for (int i = 0; i < A.length; i++) {
            bitOne = (bitOne ^ A[i]) & ~bitTwo;
            bitTwo = (bitTwo ^ A[i]) & ~bitOne;
        }
        return bitOne;
    }
}
