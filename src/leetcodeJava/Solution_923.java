package leetcodeJava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution_923 {
    public int threeSumMulti(int[] arr, int target) {
        int result = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 1; i ++)
        {
            Map<Integer,Integer> map = new HashMap<>();
            int rest = target - arr[i];
            for(int j = i + 1; j < arr.length; j++)
            {
                int complement = rest - arr[j];
                if (map.containsKey(complement))
                {
                    result += map.get(complement);
                    result %= 1_000_000_007;
                }
                int curr = map.containsKey(arr[j]) ? map.get(arr[j]) : 0;
                map.put(arr[j], curr + 1);
            }
        }
        return result;
    }
}