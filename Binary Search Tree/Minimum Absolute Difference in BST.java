530. Minimum Absolute Difference in BST

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105

----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution
  class Solution {
     int prev=Integer.MAX_VALUE;
        int ans=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
       inorder(root);
       return ans;
    }
    public void inorder(TreeNode root){
        if(root.left!=null) inorder(root.left);
        ans=Math.min(ans,Math.abs(prev-root.val));
        prev=root.val;
        if(root.right!=null) inorder(root.right);
    }
}
