class Solution {
    private boolean isPossible(int[] nums, int divisor, int threshold) {
        long sum = 0;
        for (int num : nums) {
            sum += ((long) num + divisor - 1) / divisor;
        }
        return sum <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int maximum = 0;
        for (int num : nums) {
            maximum = Math.max(maximum, num);
        }

        int low = 1;
        int high = maximum;
        int answer = maximum;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (isPossible(nums, middle, threshold)) {
                answer = middle;
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return answer;
    }
}