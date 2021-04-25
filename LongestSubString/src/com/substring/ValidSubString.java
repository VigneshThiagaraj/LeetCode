package com.substring;

public class ValidSubString {

	public int lengthOfLongestSubstring(String s) {
		int seqLen = 0;
		StringBuilder sbrLongSub = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if(!sbrLongSub.toString().contains(String.valueOf(curr))) {
				sbrLongSub.append(curr);
			}else {
				sbrLongSub.delete(0, sbrLongSub.indexOf(String.valueOf(curr)) + 1);
				sbrLongSub.append(curr);
			}
			seqLen = Math.max(seqLen, sbrLongSub.length());
		}
		return seqLen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
