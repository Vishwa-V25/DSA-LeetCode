101. Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100

----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
     if(root==null){
        return true;
     }
     return ismirror(root.left,root.right);
    }
    public boolean ismirror(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null){
            return true;
        }
        if(node1==null||node2==null){
            return false;
        }
      return node1.val==node2.val&&ismirror(node1.right,node2.left)&&ismirror(node1.left,node2.right);
    }
}
 
