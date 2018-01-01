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
        ReplaceSpaces.testReplaceSpacesBuiltIn("An alternate test", "GoingSpaceless", "For parity purposes");

        //palindrome permutations
        PalindromePermutations.testPalindromePerm("racecar", "nom nom",
                "gob bog", "rrccaae", "aer", "oddLetterCombo");

        //One Edit difference
        OneEditDifference.testOneDiff("test", "tests", "mile", "mite", "parry", "patty",
                "venom", "venomous", "bests", "bets");
    }


}//class
