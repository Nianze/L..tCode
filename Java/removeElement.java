public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        int left = 0, right = A.length - 1;
        while(left <= right) {
            if (A[left] == elem) {
                A[left] = A[right];
                right--;
            } else {
                left++;
            }
        }
        return right + 1;
    }
}
