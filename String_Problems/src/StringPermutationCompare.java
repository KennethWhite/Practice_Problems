import java.util.Arrays;

/**Check permutation: Given two strings, write a method to decide if one is a
 * permutation of the other.*/
public class StringPermutationCompare {

    //O(nlog(n))
    private static boolean checkPermArrays(String base, String test){
        if(base.length() != test.length()){return false;}
        char[] baseArr = base.toCharArray();    //n
        char[] testArr = test.toCharArray();    //n
        Arrays.sort(baseArr);   //n(log(n)) (quicksort)
        Arrays.sort(testArr);   //n(log(n))
        for(int index = 0; index < baseArr.length; index++){    //n
            if(baseArr[index] != testArr[index]){return false;}
        }
        return true;
    }

    //More modular book solution
    private static boolean checkPermString(String base, String test){
        if(base.length() != test.length()){return false;}
        return sort(base).equals(sort(test)); //2nlog(n)+n
    }
    //O(nlog(n))
    private static String sort(String input){
        char[] inputArr = input.toCharArray();    //n
        Arrays.sort(inputArr);   //n(log(n))
        return new String(inputArr);
    }

    public static void testCheckPermArrays(String... args){
        System.out.printf("\n\nTesting if string1 is permutation of string2 (Array Impl.)\n");
        for(int index = 0; index +1 < args.length; index+=2){
            System.out.printf("\nCase '%s, %s': %s", args[index], args[index+1], checkPermArrays(args[index], args[index+1]));
        }
    }

}
