class Solution {
    public int minMen(int arr[]) {
        int n = arr.length;
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int left = Math.max(0, i - arr[i]);
                int right = Math.min(n - 1, i + arr[i]);
                intervals.add(new int[]{left, right});
            }
        }
        intervals.sort((a, b) -> a[0] - b[0]);
        int workers = 0, covered = 0, i = 0;
        while (covered < n) {
            int maxReach = covered;
            while (i < intervals.size() && intervals.get(i)[0] <= covered) {
                maxReach = Math.max(maxReach, intervals.get(i)[1] + 1);
                i++;
            }
            if (maxReach == covered) return -1;
            covered = maxReach;
            workers++;
        }
        return workers;

    }
}