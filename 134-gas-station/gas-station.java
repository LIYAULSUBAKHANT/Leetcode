class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int gas_total = 0;
        int cost_total = 0;
        for(int i = 0; i < n; i++)
        {
            gas_total += gas[i];
            cost_total += cost[i];
        }
        if(gas_total < cost_total) return -1;

        int start_index = 0;
        int current_gas = 0;
        for(int i = 0; i<n; i++)
        {
            current_gas += gas[i] - cost[i];

            if(current_gas < 0)
            {
                start_index = i + 1;
                current_gas = 0;
            }

        }
        return start_index;
    
    }
}