class Solution {
    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0;
        int consecutiveFlowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                consecutiveFlowers++;
                if (consecutiveFlowers == k) {
                    bouquets++;
                    consecutiveFlowers = 0;
                }
            } else {
                consecutiveFlowers = 0;
            }
        }

        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int minimumDay = Integer.MAX_VALUE;
        int maximumDay = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            minimumDay = Math.min(minimumDay, day);
            maximumDay = Math.max(maximumDay, day);
        }

        int low = minimumDay;
        int high = maximumDay;
        int answer = maximumDay;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (canMakeBouquets(bloomDay, middle, m, k)) {
                answer = middle;
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return answer;
    }
}
