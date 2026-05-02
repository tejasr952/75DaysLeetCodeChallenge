class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int left = 0, right = n - 1;

        // Continue swapping until the pointers meet in the middle
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // Move pointers toward each other
            left++;
            right--;
        }
    }
}