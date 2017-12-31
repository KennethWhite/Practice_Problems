/**
 * Created by Kenny on 12/30/2017.
 * Problems from 'Cracking The Coding Interview' 6th Ed. CH. 1
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

/**Class calls testers for a number of methods designed solve problems revolving
 * around Strings.
 */

public class StringAlgsTestbed {


    public static void main(String... args){

        //Is Unique
        AllUniqueChars.testAllUniqueChars("Dog", "java", "Yosemite");
        AllUniqueChars.testAllUniqueCharsUsingPtrs("Lincoln", "Maine", "Yes");

        //String Permutations Compare
        StringPermutationCompare.testCheckPermArrays("data", "tada", "abc", "cba", "xyz", "xxx");

        //replace spaces
        ReplaceSpaces.testReplaceSpaces("A small test", "NoSpace", "yada yada yada");
    }







    /**Palindrome Permutations: Given a string, write a function to determine if it is
     * a permutation of a palindrome. The palindrome does not need to be limited to just dictionary
     * words.
     */
    //O(n)
    private static boolean isPalindromePermutation(String toTest){
        if(toTest.length()%2 == 0)
            return countOddOccurrences(countCharOccurrences(toTest)) == 0;
        else
            return countOddOccurrences(countCharOccurrences(toTest)) == 1;
    }

    //O(n)
    private static Hashtable<Character, Integer> countCharOccurrences(String toTest){
        Hashtable<Character, Integer> charOccurrence = new Hashtable<>();
        Character value;
        for(char c: toTest.toCharArray()){
            value = c;
            if(charOccurrence.containsKey(value)){
                charOccurrence.put(value, charOccurrence.get(value)+1);
            }
            else
                charOccurrence.put(value, 1);
        }
        return charOccurrence;
    }
    //O(n)
    private static int countOddOccurrences(Hashtable<Character, Integer> occurenceTable){
        int oddCount = 0;
        for(Integer count: occurenceTable.values()){
            if(count%2 ==1){
                oddCount++;
            }
        }
        return oddCount;
    }


    /**One away: There are three kinds of edits that can be performed on Strings; Insert a character,
     * remove a character, or replace a character. Given two strings, write a function to determine
     * if they are one(or zero) edit away from each other.
     */
    private static boolean oneEditAway(String base, String toTest){
        if(Math.abs(base.length() - toTest.length()) > 1)
            return false;
        return testOneDiff(base, toTest);

    }


    private static boolean testOneDiff(String base, String toTest){
        String shorter, longer;
        boolean foundDiff = false;
        int indexS = 0, indexL= 0;
        shorter = (base.length() > toTest.length()) ? base : toTest;
        longer = (base.length() > toTest.length()) ? toTest : base;

        for(;indexS < shorter.length() && indexL < longer.length();){
            if(shorter.charAt(indexS) != longer.charAt(indexL)){
                if(foundDiff)
                    return false;
                indexL++;
                foundDiff = true;
            }
            else{
                indexS++;
                indexL++;
            }
        }
        return true;
    }

}//class
