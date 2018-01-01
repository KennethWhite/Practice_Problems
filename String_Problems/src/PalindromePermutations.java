import java.util.Hashtable;

/**Palindrome Permutations: Given a string, write a function to determine if it is
 * a permutation of a palindrome. The palindrome does not need to be limited to just dictionary
 * words.
 */
public class PalindromePermutations {

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


    public static void testPalindromePerm(String... args){
        System.out.println("\n\nTesting word to see if it is a permutation of a palindrome.");
        for(int index = 0; index < args.length; index++){
            System.out.printf("\nCase '%s': %s", args[index], isPalindromePermutation(args[index]));
        }
    }

}
