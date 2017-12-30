/**
 * Created by Kenny on 12/30/2017.
 * Problems from 'Cracking The Coding Interview' 6th Ed. CH. 1
 */
import java.util.Arrays;
import java.util.HashSet;
public class StringAlgs {
    /**Is unique: Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures? */
    //O(n)
    private boolean allUniqueChars(String toTest){
        if(toTest.length() > 128){return false;}    //base case, 128 basic ascii chars
        HashSet<Character> alreadyFound = new HashSet<>();
        for(int index = 0; index < toTest.length(); index++){
            if(!alreadyFound.add(toTest.charAt(index))){
                return false;
            }
        }
        return true;
    }
    //Without using data structure O(n^2)
    private boolean allUniqueCharsUsingPtrs(String toTest){
        for(int index = 0; index < toTest.length()-1; index++){
            for(int compareIndex = index +1; compareIndex < toTest.length(); compareIndex++){
                if(toTest.charAt(index) == toTest.charAt(compareIndex)){return false;}
            }//inner
        }//outer for
        return true;
    }

    /**Check permutation: Given two strings, write a method to decide if one is a
     * permutation of the other.*/
    //O(nlog(n))
    private boolean checkPermArrays(String base, String test){
        if(base.length() != test.length()){return false;}
        char[] baseArr = base.toCharArray();    //n
        char[] testArr = test.toCharArray();    //n
        Arrays.sort(baseArr);   //n(log(n))
        Arrays.sort(testArr);   //n(log(n))
        for(int index = 0; index < baseArr.length; index++){    //n
            if(baseArr[index] != testArr[index]){return false;}
        }
        return true;
    }

    //More optimal book solution
        private boolean checkPermString(String base, String test){
            if(base.length() != test.length()){return false;}
            return sort(base).equals(sort(test)); //2nlog(n)+n
        }
        //O(nlog(n))
        private String sort(String input){
            char[] inputArr = input.toCharArray();    //n
            Arrays.sort(inputArr);   //n(log(n))
            return new String(inputArr);
        }

    /**URLify: Write a method to replace all spaces in a string with '%20'. You may assume
     * that the String has sufficient space at the end to hold the additional characters and that
     * you are given the "true" length of the String. (Note: If implementing in Java use a character array
     * so that the you can perform the operation in place.)
     */

    private void replaceSpaces(char[] str, int trueLength){
        int numSpaces = 0;
        int index;
        for(index = 0; index < trueLength; index++){
            if(str[index] == ' '){numSpaces++;}
        }
        index = trueLength + numSpaces*2;
        if(trueLength < str.length)
            str[trueLength] = '\0';
        for(int i = trueLength-1; i >= 0; i--){
            if(str[i]== ' '){
               str[index - 1] = '0';
               str[index - 2] = '2';
               str[index - 3] = '%';
               index = index -3;
            }
            else{
                str[index-1] = str[i];
                index--;
            }
        }
    }

    private String replaceSpacesBuiltIn(String input){
        if(!input.contains(" ")){return input;}
        return input.replaceAll(" ", "%20");
    }
}
