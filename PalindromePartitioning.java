// Given a string, a partitioning of the string is a palindrome partitioning if every 
// substring of the partition is a palindrome. For example, “aba|b|bbabb|a|b|aba” is a 
// palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for a 
// palindrome partitioning of a given string. For example, minimum of 3 cuts are needed 
// for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”. If a string is a palindrome, 
// then minimum 0 cuts are needed. If a string of length n containing all different characters, 
// then minimum n-1 cuts are needed. 

// Input : str = “geek” 
// Output : 2 
// We need to make minimum 2 cuts, i.e., “g ee k”
// Input : str = “aaaa” 
// Output : 0 
// The string is already a palindrome.
// Input : str = “abcde” 
// Output : 4
// Input : str = “abbac” 
// Output : 1 


public class PalindromePartitioning {

static boolean isPalindrome(String string, int i, int j) {
	while(i < j) {
	if(string.charAt(i) != string.charAt(j))
		return false;
	i++;
	j--;
	}
	return true;
}

static int minPalPartion(String string, int i, int j) {
	if( i >= j || isPalindrome(string, i, j) )
	return 0;
	int ans = Integer.MAX_VALUE, count;
	for(int k = i; k < j; k++) {
	count = minPalPartion(string, i, k) +
		minPalPartion(string, k + 1, j) + 1;
	ans = Math.min(ans, count);
	}
	return ans;
}

public static void main(String args[]) {
	String str = "ababbbabbababa";
	System.out.println("Min cuts needed for " + "Palindrome Partitioning is " + minPalPartion(str, 0, str.length() - 1));
}
}
