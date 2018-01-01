/**One away: There are three kinds of edits that can be performed on Strings; Insert a character,
 * remove a character, or replace a character. Given two strings, write a function to determine
 * if they are one(or zero) edit away from each other.
 */
public class OneEditDifference {

    private static boolean oneEditAway(String base, String toTest){
        if(Math.abs(base.length() - toTest.length()) > 1)
            return false;
        return OnlyOneDiff(base, toTest);

    }


    private static boolean OnlyOneDiff(String base, String toTest){
        String shorter, longer;
        boolean foundDiff = false;
        int indexS = 0, indexL= 0;
        int bLen = base.length();
        int tLen = toTest.length();
        boolean sameLen = (bLen == tLen);

        shorter = (bLen >= tLen) ? base : toTest;
        longer = (bLen >= tLen) ? toTest : base;

        for(;indexS < shorter.length() && indexL < longer.length();){
            if(shorter.charAt(indexS) != longer.charAt(indexL)){
                if(foundDiff)
                    return false;
                if(!sameLen)
                    indexL++;
                foundDiff = true;
            }
            indexS++;
            indexL++;

        }
        return true;
    }

    public static void testOneDiff(String... args){
        System.out.println("\n\nTesting word to see if it is a permutation of a palindrome.");
        String s1, s2;
        for(int index = 0; index+1 < args.length; index+=2){
            s1 = args[index];
            s2 = args[index+1];
            System.out.printf("\nCase %s vs %s: %s", s1, s2, oneEditAway(s1, s2));
        }
    }

}
