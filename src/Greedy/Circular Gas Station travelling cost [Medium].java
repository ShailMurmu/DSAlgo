package Greedy;

class CircularGasStation {
    /*
    Approach:
    In the question given that
    If there exists a solution, it is guaranteed to be unique
    -This lines clearly tells us that we have unique or no solution exists

    Here two cases are possible

    1. if our total_gas is less than our total cost in that case we can't complete our journey ,so will return -1
    2. Now we have a unique solution that means single starting_point exists
    3. To find that point we will keep track of my current_gas+=gas[i]-cost[i]

    lets suppose at any index our current gas became negative so we can clearly say
    that till that index all the gas station between ith and starting point are bad, starting point as well.
    So, this means we can start trying at next gas_station on the i+1 station

    */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas = 0, total_cost = 0;
        int curr_gas = 0, starting_point = 0;
        for(int i=0; i<gas.length; i++)
        {
            //these two variable are to check if no case is possible
            total_gas += gas[i];
            total_cost += cost[i];
            //for checking the total present gas at index i
            curr_gas += gas[i]-cost[i];
            if(curr_gas < 0)
            {
                //there is a breakdown....so we will start from next point or index
                starting_point = i+1;
                //reset our fuel
                curr_gas = 0;
            }
        }
        return (total_gas < total_cost) ? -1: starting_point;
    }
}
