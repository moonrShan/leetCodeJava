package leetcodeJava;

class Solution_344 {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r)
        {
            char temp = s[r];
            s[r] = s[l];
            s[l] = temp;
            l ++;
            r --;
        }
    }
}
