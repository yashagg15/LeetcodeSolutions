package dfs;

public class longeest_univalue_path {

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

        int maxResult=0;

        public int iterateTree(TreeNode root){
            if(root==null)
                return 0 ;
            int left=iterateTree(root.left);
            int right=iterateTree(root.right);
            if(root.left!=null && root.val==root.left.val){
                left++;
            }
            else{
                left=0;
            }

            if(root.right!=null && root.val==root.right.val){
                right++;
            }
            else{
                right=0;
            }
            int total=left+right;
            maxResult=Math.max(maxResult,total);
            return Math.max(left,right);

        }

        public int longestUnivaluePath(TreeNode root) {


            iterateTree(root);
            return maxResult;

        }
    }
}
