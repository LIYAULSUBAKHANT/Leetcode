class Solution {
    public int beautySum(String s) {

        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];

            for (int j = i; j < n; j++) {

                int index = s.charAt(j) - 'a';
                freq[index]++;

                int max = 0;
                int min = Integer.MAX_VALUE;

                // Find max and min frequency
                for (int k = 0; k < 26; k++) {

                    if (freq[k] > 0) {
                        max = Math.max(max, freq[k]);
                        min = Math.min(min, freq[k]);
                    }
                }

                ans += max - min;
            }
        }

        return ans;
    }
}