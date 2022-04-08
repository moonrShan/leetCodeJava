package leetcodeJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_1087{
    public String[] expand(String S) {
        String[] array = S.split("\\{|\\}");
        List<String> res = new ArrayList<>();
        dfs(res, array, 0, "");
        return res.toArray(new String[res.size()]);
    }

    private void dfs(List<String> res, String[] array, int curr, String word) {
        if (curr >= array.length) {
            res.add(word);
            return;
        }
        String[] possibles = array[curr].split(",");
        Arrays.sort(possibles);
        for (String s : possibles) dfs(res, array, curr + 1, word + s);
    }
}
