//https://leetcode.com/problems/valid-parentheses/

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false
// Example 4:

// Input: s = "([)]"
// Output: false
// Example 5:

// Input: s = "{[]}"
// Output: true
 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
    
class ValidPrenProblem {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        
        
        for(int i=0;i<s.length(); i++){
            char c = s.charAt(i);
            if(st.isEmpty()){
                if(c==')' ||c=='}'||c==']'){
                    return false;   
                }
                else{
                   st.push(c); 
                }
            }
            else{
                char top = st.peek();
                if((c==')' &&  top=='(') ||(c=='}' &&  top=='{') || (c==']' &&  top=='[')){
                st.pop();
                }
                else if(c=='(' || c=='{' || c=='['){
                    st.push(c);
                }
                else{
                    return false;
                }
            }
        }
        System.out.println(st);
        return st.isEmpty();
    }
}
