/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    TreeNode node;
    int currSum;
    Pair(TreeNode node,int currSum){
        this.node=node;
        this.currSum=currSum;
    }
}
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
         if(root==null){
           return false;
        }
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(root,0));
        while(!st.isEmpty()){
            Pair p=st.pop();
            TreeNode node=p.node;
            int currSum=p.currSum;
            currSum=currSum+node.val;
            //Reached to leaf node
            if(node.left==null && node.right==null){
                if(currSum==targetSum) return true;
            }
            if(node.left!=null){
                st.push(new Pair(node.left,currSum));
            }
            if(node.right!=null){
                st.push(new Pair(node.right,currSum));
            }
        }
        return false;
    }
}
