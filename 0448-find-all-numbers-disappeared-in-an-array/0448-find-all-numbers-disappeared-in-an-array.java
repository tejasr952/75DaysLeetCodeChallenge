class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       int n = nums.length;
       boolean[] seen = new boolean[n+1];
       for(int i=0;i<n;i++){
        seen[nums[i]] = true;
       }
         List<Integer> result = new ArrayList<>();

        for(int i=1;i<=n;i++){
            if(seen[i]==false){
            result.add(i);
        }
       }        
       return result;
        
    }
}