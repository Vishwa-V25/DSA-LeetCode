230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution
  class Solution {
    public int kthSmallest(TreeNode root, int k){
      List<Integer> list=new ArrayList<>();
      inorder(root,list);
      return list.get(k-1);
    }
    private void inorder(TreeNode node,List<Integer> list ){
        if(node==null) return ;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }
}
 
