// Created by Rym on 10/18/2016
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (isBadVersion(start)) {
            return start;
        }
        return end;       
    }

    // recursive way?
    
}
