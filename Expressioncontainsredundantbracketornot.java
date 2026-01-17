class Solution {
    public static boolean checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                boolean operatorFound = false;
                
                while (!st.isEmpty() && st.peek() != '(') {
                    char top = st.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        operatorFound = true;
                    }
                }
                
                if (!st.isEmpty()) st.pop(); // remove '('
                
                if (!operatorFound) return true; // redundant
            } else {
                st.push(ch);
            }
        }
        
        return false;

    }
}
