class Solution {
    private int days(int[] weights, int mid)
    {
        int days = 1;
        int total = 0;

        for(int weight : weights)
        {
            if(total + weight > mid )
            {
                days++;
                total = weight;
            }
            else{
                total += weight;
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int weight : weights)
        {
            low = Math.max(low,weight);
            high += weight;
        }

        while(low < high)
        {
            int mid = low + (high - low )/2;

            int needed = days(weights, mid);

            if(needed <= days)
            {
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low ;
    }
}