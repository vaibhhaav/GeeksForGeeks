class Solution {
    public int catchThieves(char[] arr, int k) {
        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') police.add(i);
            else thieves.add(i);
        }
        int i = 0, j = 0, caught = 0;
        while (i < police.size() && j < thieves.size()) {
            if (Math.abs(police.get(i) - thieves.get(j)) <= k) {
                caught++;
                i++;
                j++;
            } else if (thieves.get(j) < police.get(i)) {
                j++;
            } else {
                i++;
            }
        }
        return caught;
    }
}