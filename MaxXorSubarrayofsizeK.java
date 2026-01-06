class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return 0;

        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i];
        }

        int maxXor = Integer.MIN_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int j = i + k - 1; 
            int currentXor;
            if (i == 0) {
                currentXor = prefix[j];
            } else {
                currentXor = prefix[j] ^ prefix[i - 1];
            }
            maxXor = Math.max(maxXor, currentXor);
        }

        return maxXor;


    }
}
