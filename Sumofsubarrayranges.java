class Solution {
    public int subarrayRanges(int[] arr) {
        long result = sumSubarrayMax(arr) - sumSubarrayMin(arr);
        return (int) result;
    }

    private long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        long res = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] <= (i == n ? Integer.MAX_VALUE : arr[i]))) {
                int idx = stack.pop();
                int left = stack.isEmpty() ? idx + 1 : idx - stack.peek();
                int right = i - idx;
                res += (long) arr[idx] * left * right;
            }
            stack.push(i);
        }
        return res;
    }

    private long sumSubarrayMin(int[] arr) {
        int n = arr.length;
        long res = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] >= (i == n ? Integer.MIN_VALUE : arr[i]))) {
                int idx = stack.pop();
                int left = stack.isEmpty() ? idx + 1 : idx - stack.peek();
                int right = i - idx;
                res += (long) arr[idx] * left * right;
            }
            stack.push(i);
        }
        return res;
    }
}