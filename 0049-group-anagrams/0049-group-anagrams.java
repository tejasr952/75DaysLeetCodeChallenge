import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();

        boolean[] used = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {

            if (used[i]) continue;

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            used[i] = true;

            for (int j = i + 1; j < strs.length; j++) {

                if (!used[j] && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    used[j] = true;
                }
            }

            ans.add(group);
        }

        return ans;
    }


    // check anagram without sorting
    public boolean isAnagram(String a, String b) {

        if (a.length() != b.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;
        }

        for (int x : count) {
            if (x != 0) return false;
        }

        return true;
    }
}