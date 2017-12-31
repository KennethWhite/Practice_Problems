import java.util.HashSet;

/**Is unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures? */
public class AllUniqueChars {

    //O(n)
    private static boolean allUniqueChars(String toTest){
        if(toTest.length() > 128){return false;}    //base case, 128 basic ascii chars
        HashSet<Character> alreadyFound = new HashSet<>();
        for(int index = 0; index < toTest.length(); index++){
            if(!alreadyFound.add(toTest.charAt(index))){
                return false;
            }
        }
        return true;
    }
    //Without using data structure
    //O(n^2)
    private static boolean allUniqueCharsUsingPtrs(String toTest){
        for(int index = 0; index < toTest.length()-1; index++){
            for(int compareIndex = index +1; compareIndex < toTest.length(); compareIndex++){
                if(toTest.charAt(index) == toTest.charAt(compareIndex)){return false;}
            }
        }
        return true;
    }

    public static void testAllUniqueChars(String ... args){
        System.out.printf("\n\nTesting if string contains all unique characters (Hashtable Impl.)\n");
        for(String word: args){
            System.out.printf("\nCase '%s': %s", word, allUniqueChars(word));
        }

    }
    public static void testAllUniqueCharsUsingPtrs(String ... args){
        System.out.printf("\n\nTesting if string contains all unique characters (Pointer Impl.)\n");
        for(String word: args){
            System.out.printf("\nCase '%s': %s", word, allUniqueChars(word));
        }
    }
}
