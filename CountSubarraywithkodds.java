class Solution {
    private long atMostX(int[] arr, int x) {
        int n = arr.length;
        long ans = 0;
        int oddCount = 0;
        int start = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
            
            while (oddCount > x && start <= i) {
                if (arr[start] % 2 != 0) {
                    oddCount--;
                }
                start++;
            }
            
            ans += (i - start + 1L);
        }
        return ans;
    }
    
    public int countSubarrays(int[] arr, int k) {
        if (k == 0) {
            return (int) atMostX(arr, 0);
        }
        return (int) (atMostX(arr, k) - atMostX(arr, k - 1));
    }
}
