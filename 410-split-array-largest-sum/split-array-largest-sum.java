class Solution {
    private int part(int[] nums, int mid)
    {
        int partition = 1;
        int subArraySum = 0;

        for(int num : nums)
        {
            if(subArraySum + num <= mid)
            {
                subArraySum += num;
            }
            else{
                partition++;
                subArraySum = num;
            }
        }
        return partition;
    }
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int total = 0;

        for(int num : nums)
        {
            max = Math.max(max,num);
            total += num;
        }
        
        int low = max;
        int high = total;

        while(low <= high)
        {
            int mid = low + (high-low)/2;

            int partition = part(nums, mid);

            if(partition > k)
            {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
}