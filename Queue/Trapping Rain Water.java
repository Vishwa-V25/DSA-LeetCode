42. Trapping Rain Water
  
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
  
Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
  Solution
  class Solution {
    public int trap(int[] height) {
     int left=0;
     int right=height.length-1;
     int leftmax=height[left];
     int rightmax=height[right];
     int max=0;
     while(left<right){
        if(leftmax<rightmax){
            left++;
            leftmax=Math.max(leftmax,height[left]);
            max+=leftmax-height[left];
        }
         else{
            right--;
            rightmax=Math.max(rightmax,height[right]);
            max+=rightmax-height[right];
        }
     }
     return max;
    }
}
