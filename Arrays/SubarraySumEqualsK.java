class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefixSum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            int remain=prefixSum-k;
            if(map.containsKey(remain)){
                cnt+=map.get(remain);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
            
        }
        return cnt;
    }
}
