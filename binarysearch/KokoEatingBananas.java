class Solution {
    private long calculateHours(int[] piles, int speed) {
        long totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + (long) speed - 1) / speed;
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maximumPile = 0;
        for (int pile : piles) {
            maximumPile = Math.max(maximumPile, pile);
        }

        int low = 1;
        int high = maximumPile;
        int answer = maximumPile;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (calculateHours(piles, middle) <= h) {
                answer = middle;
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return answer;
    }
}
