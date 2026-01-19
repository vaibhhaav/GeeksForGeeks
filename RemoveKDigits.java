class Solution {
    public String removeKdig(String s, int k) {
        int n = s.length();
        if (k >= n) return "0";

        char[] stack = new char[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            while (top > 0 && k > 0 && stack[top - 1] > c) {
                top--;
                k--;
            }
            stack[top++] = c;
        }

        top -= k;

        int idx = 0;
        while (idx < top && stack[idx] == '0') idx++;

        if (idx == top) return "0";

        return new String(stack, idx, top - idx);
    }
}
