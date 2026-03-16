import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        
        // sort array based on sorted string
        Arrays.sort(strs, (a, b) -> {
            char[] c1 = a.toCharArray();
            char[] c2 = b.toCharArray();
            
            Arrays.sort(c1);
            Arrays.sort(c2);
            
            return new String(c1).compareTo(new String(c2));
        });
        
        
        List<String> temp = new ArrayList<>();
        temp.add(strs[0]);
        
        for (int i = 1; i < strs.length; i++) {
            
            if (isAnagram(strs[i], strs[i-1])) {
                temp.add(strs[i]);
            } else {
                result.add(new ArrayList<>(temp));
                temp.clear();
                temp.add(strs[i]);
            }
        }
        
        result.add(temp);
        
        return result;
    }
    
    
    public boolean isAnagram(String a, String b) {
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        return Arrays.equals(c1, c2);
    }
}