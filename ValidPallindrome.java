// https://leetcode.com/problems/valid-palindrome/

// Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 

// Example 1:

// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.
// Example 2:

// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.
 

// Constraints:

// 1 <= s.length <= 2 * 105
// s consists only of printable ASCII characters.

class ValidPallindrome {
    public boolean isPalindrome(String s) {
      
        int i=0, j=s.length()-1;
        char c1, c2;
        while(i<=j){
            c1 = Character.toLowerCase(s.charAt(i));
            c2 = Character.toLowerCase(s.charAt(j));
            // System.out.println("i: "+i+" j: "+j);
            
            if(!(c1 >= 'a' && c1 <= 'z') && !(c1 >= '0' && c1 <= '9')){
                i++;
                continue;
            }
            
            if(!(c2 >= 'a' && c2 <= 'z') && !(c2 >= '0' && c2 <= '9')){
                j--;
                continue;
            }
            
            if(c1!=c2){
                // System.out.println("c1: "+c1+" c2: "+c2);
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}
