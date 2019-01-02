class Solution {
    /*
    The basic idea is every time we start from a station, we go as far as possible by increasing end until remaining gas is less than 0. If 'end' finally hits start we know we can travel around from 'start'. If we haven't traveled around, we know we cannot start from this station. Then we check the station before our start station if we can start from this station. Repeat until we have checked all stations.
    */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int start = len - 1, end = 0;
        int sum = gas[start] - cost[start];
        while (start > end) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                end++;
            } else {
                start--;
                sum += gas[start] - cost[start];
            }
        }

        return (sum >= 0) ? start : -1;
    }
}
