/**URLify: Write a method to replace all spaces in a string with '%20'. You may assume
 * that the String has sufficient space at the end to hold the additional characters and that
 * you are given the "true" length of the String. (Note: If implementing in Java use a character array
 * so that the you can perform the operation in place.)
 */
public class ReplaceSpaces {

    //TODO replace char[] with string parameter
    private static char[] replaceSpaces(char[] str, int trueLength){
        int numSpaces = 0;
        int index;
        for(index = 0; index < str.length; index++){
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
        return str;
    }

    private static String replaceSpacesBuiltIn(String input){
        if(!input.contains(" ")){return input;}
        return input.replaceAll(" ", "%20");
    }


    public static void testReplaceSpaces(String... args){
        System.out.println("\n\nTesting replacing spaces in String with '%20'");
        for(int index = 0; index < args.length; index++){
            System.out.printf("\nCase '%s': %s", args[index],
                    replaceSpaces(args[index].toCharArray(), args[index].length() + numSpaces(args[index]) ));
        }
    }
    private static int numSpaces(String input){
        int numSpaces = 0;
        int index;
        for(index = 0; index < input.length(); index++){
            if(input.charAt(index) == ' '){numSpaces++;}
        }
        return numSpaces;
    }
}
