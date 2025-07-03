345. Reverse Vowels of a String

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII character

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Solution
class Solution {
    public String reverseVowels(String s) {
      Set set=Set.of('a','e','i','o','u','A','E','I','O','U');
      Stack<Character> st= new Stack<>();
      for(char c:s.toCharArray()){
         if(set.contains(c)){
            st.push(c);
         }
      }
      StringBuilder sb = new StringBuilder();
      for(char c:s.toCharArray()){
        if(set.contains(c)){
            sb.append(st.pop());
        }
        else{
            sb.append(c);
        }
      }
      return sb.toString();
    }
}
