package oa2;

public class LongestPalindrome {
	public String longestPalindrome_Slow(String s) {
		int len = s.length();
		while (len >= 0) {
			for (int i = 0; i + len - 1 < s.length(); i++) {
				int left = i, right = i + len - 1;
				boolean isPalind = true;
				while (left < right) {
					if (s.charAt(left) != s.charAt(right)) {
						isPalind = false; 
						break;
					}
					left++;
					right--;
				}
				if (isPalind) {
					return s.substring(i, i + len);
				}
			}
			len--;
		}
		return "";
	}
	
	public String longestPalindrome(String s) {
		int max = 0, idx = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = extend(s, i, i), len2 = extend(s, i, i + 1);
			if (max < Math.max(len1, len2)) {
				idx = (len1 > len2) ? (i - len1 / 2) : (i - len2 / 2 + 1);
				max = Math.max(len1, len2);
			}
		}
		return s.substring(idx, idx + max);
	}
	
	private int extend(String s, int i, int j) {
		for (; i >= 0 && j < s.length(); i--, j++) {
			if (s.charAt(i) != s.charAt(j)) {
				break;
			}
		}
		return j - i + 1 - 2;
	}
	
}
