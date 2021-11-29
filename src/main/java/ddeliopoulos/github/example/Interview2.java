/**
 Given a pattern and a string s, find if s follows the same pattern.
 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 Example 1:
 Input: pattern = "abba", s = "dog cat cat dog"
 Output: true
 Example 2:
 Input: pattern = "abba", s = "dog cat cat fish"
 Output: false
 Example 3:
 Input: pattern = "aaaa", s = "dog cat cat dog"
 Output: false
 Example 4:
 Input: pattern = "abba", s = "dog dog dog dog"
 Output: false


 Constraints:
 1- 1 <= pattern.length <= 300
 2- pattern contains only lower-case English letters.
 3- 1 <= s.length <= 3000
 4- s contains only lower-case English letters and spaces ' '.
 5- s does not contain any leading or trailing spaces.
 6- All the words in s are separated by a single space.
 */


package ddeliopoulos.github.example;

import java.util.HashMap;
import java.util.Map;

public class Interview2 {

    public static boolean patternMatches(String pattern, String s){
        Map<Character, String> map = new HashMap<>();
        String arr[] = s.split(" ");

        if(arr.length != pattern.length()) return false;

        for(int i = 0; i < pattern.length(); ++i){
            if(map.containsKey(pattern.charAt(i))){
                String compareWord = map.get(pattern.charAt(i));
                if(!compareWord.equals(arr[i])) return false;
            }
            map.put(pattern.charAt(i), arr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abcba";
        String words = "dog cat cat cat dog";

        System.out.println(patternMatches(pattern, words));
    }

}
