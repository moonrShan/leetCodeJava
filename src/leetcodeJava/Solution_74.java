package leetcodeJava;

class Solution_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n;
        int pivotIdx, pivotElement;
        while (left < right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            if (target < pivotElement)
                right = pivotIdx;
            else
                left = pivotIdx + 1;
        }
        return false;
    }
}