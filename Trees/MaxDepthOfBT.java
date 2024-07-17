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
    int depth;
    Pair(TreeNode node,int depth){
        this.node=node;
        this.depth=depth;
    }
} 
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int maxDepth=0;
        Stack<Pair> st=new Stack<>(); //we are storing pairs bcoz in iterative approach we can move forward only
        st.push(new Pair(root,1));
        while(!st.isEmpty()){
            Pair p=st.pop();
            maxDepth=Math.max(maxDepth,p.depth);
            if(p.node.left!=null) st.push(new Pair(p.node.left,p.depth+1));
            if(p.node.right!=null) st.push(new Pair(p.node.right,p.depth+1));
        }
        return maxDepth;
    }
}
