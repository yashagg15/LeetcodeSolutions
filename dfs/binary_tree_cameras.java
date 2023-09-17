package dfs;

public class binary_tree_cameras {
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

        public int notavailable=0;
        public int notmonitored=1;
        public int monitored=2;
        public int res=0;

        public int callItr(TreeNode root){

            if(root==null){
                return notavailable;
            }
            int left=callItr(root.left);
            int right=callItr(root.right);
            if(left==notavailable && right==notavailable){
                return notmonitored;
            }else if(left==notmonitored || right==notmonitored){
                res++;
                return monitored;
            }
            return notavailable;

        }


        public int minCameraCover(TreeNode root) {

            res=0;
            if(callItr(root)==notmonitored){
                return res+1;
            }
            return res;

        }
    }
}
