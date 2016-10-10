/*
20. Valid Parentheses  QuestionEditorial Solution  My Submissions

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Hide Company Tags Google Airbnb Facebook Twitter Zenefits Amazon Microsoft Bloomberg
Hide Tags Stack String
Hide Similar Problems (M) Generate Parentheses (H) Longest Valid Parentheses (H) Remove Invalid Parentheses
*/

/*
// solving thought
Both "{([])}" and "()[]{}" are examples.
*/

public class Solution {
    public boolean isValid(String s) {
        Stack <Character> st = new Stack<>();
        char [] ch = s.toCharArray();
        int n = s.length();
        if (n % 2 == 1) {
            //System.out.println ('1');
            return false;
        }
        for (int i = 0; i < n; i++) {
            if(ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
                st.push(ch[i]);
            } else if (ch[i] == ')') {
                if (!st.empty() && st.peek() == '(') {
                    //System.out.println("Execute 2 branch");
                    st.pop();
                } else {
                    //System.out.println ('2');
                    return false;
                }
            } else if (ch[i] == ']') {
                if (!st.empty() && st.peek() == '[') {
                    //System.out.println("Execute 2 branch");
                    st.pop();
                } else {
                    //System.out.println ('2');
                    return false;
                }
            } else if (ch[i] == '}') {
                if (!st.empty() && st.peek() == '{') {
                    //System.out.println("Execute 2 branch");
                    st.pop();
                } else {
                    //System.out.println ('2');
                    return false;
                }
            }
        }
        if (st.empty()) {
            //System.out.println ('5');
            return true;
        }
        else {
            //System.out.println ('6');
            //System.out.println (st);
            //System.out.println (j);
            return false;
        }
    }
}

