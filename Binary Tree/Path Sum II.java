113. Path Sum II

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
--------------------------------------------------------------------------------------------------------------------------------------------------------------------

Solution
  class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<List<Integer>> list=new ArrayList<>();
       List<Integer> list2=new ArrayList<>();
       help(root,targetSum,list,list2);
       return list;
    }
    private void help(TreeNode root, int targetSum,List<List<Integer>> list,List<Integer> list2){
        if(root==null){
            return;
        }
        list2.add(root.val);

        if(root.left==null && root.right==null){
            if(root.val==targetSum){
                list.add(new ArrayList<>(list2));
            }
        }
        int remaining=targetSum-root.val;
        help(root.left,remaining,list,list2);
        help(root.right,remaining,list,list2);
        list2.remove(list2.size()-1);
    }
}
