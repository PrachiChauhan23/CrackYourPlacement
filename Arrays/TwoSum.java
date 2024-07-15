class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int ans[][]=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            ans[i][0]=i;
            ans[i][1]=nums[i];
        }
        Arrays.sort(ans,Comparator.comparingDouble(o->o[1]));
        while(l<r){
            int sum=ans[l][1]+ans[r][1];
            if(sum==target){
                return new int[]{ans[l][0],ans[r][0]};
            }else if(sum<target){
                l++;
            }else{
                r--;
            }
        }
        return null;
    }
}
