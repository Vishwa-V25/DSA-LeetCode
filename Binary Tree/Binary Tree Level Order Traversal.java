102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
     Queue<TreeNode> q=new LinkedList<>();
     List<List<Integer>> finall=new ArrayList<>();
     if(root==null){
        return finall;
     }
     q.add(root);
     while(!q.isEmpty()){
        int levels=q.size();
        List<Integer> subarray = new ArrayList<>();
        for(int i=0;i<levels;i++){
            if(q.peek().left!=null){
                q.add(q.peek().left);
            }
            if(q.peek().right!=null){
                q.add(q.peek().right);
            }
            subarray.add(q.remove().val);
        }
       finall.add(subarray);
       } 
       return finall;   
    }
}
