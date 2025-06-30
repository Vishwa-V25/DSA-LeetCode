242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

  --------------------------------------------------------------------------------------------------------------------------------------------------------------------
  Solution

  class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())
        {
            return false;
        }
        HashMap<Character,Integer> h=new HashMap<>();
        for(char ch:s.toCharArray()){
            h.put(ch,h.getOrDefault(ch,0)+1);
        }
        for(char c:t.toCharArray()){
            if(!h.containsKey(c) || h.get(c)==0){
                return false;
            }
            h.put(c,h.get(c)-1);
        }
        return true;
    }
}
