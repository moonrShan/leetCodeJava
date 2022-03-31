package leetcodeJava;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution_1762 {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i = 1; i<heights.length;i++){
            while(!stack.isEmpty() && heights[i] >= heights[stack.peek()]){
                stack.pop();
            }
            stack.push(i);
        }
        int[] result = new int[stack.size()];
        int n = stack.size();
        for(int i = n-1; i>=0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}
