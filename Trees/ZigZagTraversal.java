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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }

        q.offer(root);
        boolean flag=true;
        while(!q.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int levelnum=q.size();
            for(int i=0;i<levelnum;i++){
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                if(flag==true){
                    temp.add(q.poll().val);
                }else{
                    temp.add(0,q.poll().val);
                }
            }
            flag=!flag;
            list.add(temp);
        }
        return list;
    }
}
