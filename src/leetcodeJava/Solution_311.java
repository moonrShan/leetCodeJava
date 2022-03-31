package leetcodeJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution_311 {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int row1 = mat1.length;
        int col1 = mat1[0].length;
        int row2 = mat2.length;
        int col2 = mat2[0].length;

        Map<Integer, List<int[]>> map1 = new HashMap<>();
        for(int i=0; i<row1; i++) {
            List<int[]> tmp = new ArrayList<>();
            for(int j=0; j<col1; j++) {
                if(mat1[i][j] != 0) {
                    tmp.add(new int[]{j, mat1[i][j]});
                }
            }
            map1.put(i, tmp);
        }

        Map<Integer, List<int[]>> map2 = new HashMap<>();
        for(int j=0; j<col2; j++) {
            List<int[]> tmp = new ArrayList<>();
            for(int i=0; i<row2; i++) {
                if(mat2[i][j] != 0) {
                    tmp.add(new int[]{i, mat2[i][j]});
                }
            }
            map2.put(j, tmp);
        }

        int[][] res = new int[row1][col2];
        for(int i=0; i<row1; i++) {
            for(int j=0; j<col2; j++) {
                res[i][j] = dotOperation(map1.get(i), map2.get(j));
            }
        }
        return res;
    }

    private int dotOperation(List<int[]> row, List<int[]> col) {
        int p1 = 0, p2 = 0;
        int res = 0;
        while(p1 < row.size() && p2 < col.size()) {
            int idx1 = row.get(p1)[0];
            int idx2 = col.get(p2)[0];
            if(idx1 == idx2) {
                res += row.get(p1)[1] * col.get(p2)[1];
                p1++;
                p2++;
            } else if(idx1 < idx2) {
                p1++;
            } else {
                p2++;
            }
        }
        return res;
    }
}