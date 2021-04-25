package com.palindrome;

public class CheckPalindrome {

	public static boolean validPalindrome(String s) {

		StringBuilder str1 = new StringBuilder(s);
		String s1 = String.valueOf(str1.reverse());
		boolean flag = false;
		if(s.length() == 1) {
			flag = false;
		}else if(s.equals(s1)) {			
			flag = true;
		}else if(s.substring(1).equals(s1.substring(0,s1.length()-1))) {

			flag = true;
		}else if(s.substring(0,s.length()-1).equals(s1.substring(1))) {

			flag = true;
		}else {

			for(int i=0; i<s1.length();i++) {
				if(s.charAt(i) != s1.charAt(i)) {
					String ss1 = String.valueOf(str1.replace(0, str1.length(), s).deleteCharAt(i));
					String ss2 = String.valueOf(str1.replace(0, str1.length(), ss1).reverse());

					String ss3 = String.valueOf(str1.replace(0, str1.length(), s1).deleteCharAt(i));
					String ss4 = String.valueOf(str1.replace(0, str1.length(), ss3).reverse());

					if(ss1.equals(ss2)) {

						flag = true;
					}else if(ss3.equals(ss4)){

						flag = true;
					}
					break;
				}

			}
		}
		return flag;
	}
	
	public static String nearestPalindromic(String n) {
        long N = Long.parseLong(n), S = previous(String.valueOf(N-1).toCharArray()), L = next(String.valueOf(N+1).toCharArray());
        return String.valueOf(L - N < N - S ? L : S);
    }
    private static long previous(char[] s) {
        for(int i = 0, n = s.length; i < (n >> 1); i++) {
            while(s[i] != s[n - 1 - i]) {
                decrement(s, n - 1 - i);
                if(s[0] == '0') return Long.parseLong(new String(s));
            }
        }
        return Long.parseLong(new String(s));
    }
    private static void decrement(char[] s, int i) {
        while(s[i] == '0') s[i--] = '9';
        s[i]--;
    }
    private static long next(char[] s) {
        for(int i = 0, n = s.length; i < (n >> 1); i++) {
            while(s[i] != s[n - 1 - i]) {
                increment(s, n - 1 - i);
            }
        }
        return Long.parseLong(new String(s));
    }
    private static void increment(char[] s, int i) {
        while(s[i] == '9') s[i--] = '0';
        s[i]++;
    }
    
    public static String longestPalindrome(String s) {
        String result = "";
        for(int i=0; i< s.length(); i++)
        {
            String left = max_palindrome(s, i, i, s.length());
            String right = max_palindrome(s, i, i+1, s.length());
            String temp = (left.length() > right.length())? left: right;
            result = (result.length() > temp.length())? result: temp;
        }
        return result;
    }
        
    public static String max_palindrome(String s, int left, int right, int size)
    {
        while (left >= 0 && right < size && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validPalindrome("abca"));
		System.out.println(nearestPalindromic("125"));
		System.out.println(longestPalindrome("babad"));
	}

}
