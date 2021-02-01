// https://leetcode.com/problems/longest-common-prefix/
// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

 

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
 

// Constraints:

// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lower-case English letters.


class LongestCommonPrefixProblem {
    public String longestCommonPrefix(String[] strs) {
        String match = (strs.length>0)?strs[0]:"";
        for(int i=1; i< strs.length ;i++){
            match = checkSub(match,strs[i],0);
            if(match.length()==0){
                return match;
            }
        }
        return match;
    }
    private String checkSub(String s1, String s2,int i){
        
        if(i >=s1.length() || i >=s2.length()){
            return "";
        }
        char a = s1.charAt(i);
        char b = s2.charAt(i);
        
        if(a!=b){
            return "";
        }
        return a+checkSub(s1,s2,i+1);
    }
}
