108. Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

 Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution
  class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
       return sortedarray(0,nums.length-1,nums);  
    }
    private TreeNode sortedarray(int left,int right,int[] nums){
        if(left>right){
            return null;
        }
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedarray(left,mid-1,nums);
        root.right=sortedarray(mid+1,right,nums);
        return root;
    }
}
