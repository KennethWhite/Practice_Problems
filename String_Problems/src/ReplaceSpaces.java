/**URLify: Write a method to replace all spaces in a string with '%20'. You may assume
 * that the String has sufficient space at the end to hold the additional characters
 * (Note: If implementing in Java use a character array so that the you can perform the operation in place.)
 */
public class ReplaceSpaces {


    private static String replaceSpaces(String str, int trueLength){
        //TODO Truelength not really needed, I may be misunderstanding the question

        int numSpaces = numSpaces(str);
        int index = trueLength + numSpaces*2;
        char[] retStr = new char[index];

        if(trueLength < str.length())
            retStr[trueLength] = '\0';
        for(int i = str.length()-1; i >= 0; i--){
            if(str.charAt(i)== ' '){
                retStr[index - 1] = '0';
                retStr[index - 2] = '2';
                retStr[index - 3] = '%';
                index = index -3;
            }
            else{
                retStr[index-1] = str.charAt(i);
                index--;
            }
        }
        return new String(retStr);
    }

    private static String replaceSpacesBuiltIn(String input){
        if(!input.contains(" ")){return input;}
        return input.replaceAll(" ", "%20");
    }

    private static int numSpaces(String input){
        int numSpaces = 0;
        int index;
        for(index = 0; index < input.length(); index++){
            if(input.charAt(index) == ' '){numSpaces++;}
        }
        return numSpaces;
    }

    public static void testReplaceSpaces(String... args){
        System.out.println("\n\nTesting replacing spaces in String with '%20'");
        for(int index = 0; index < args.length; index++){
           System.out.printf("\nCase '%s': %s", args[index],
                    replaceSpaces(args[index], args[index].length() + numSpaces(args[index]) ));
        }
    }

    public static void testReplaceSpacesBuiltIn(String... args){
        System.out.println("\n\nTesting replacing spaces in String with '%20' using built-in function.");
        for(int index = 0; index < args.length; index++){
            System.out.printf("\nCase '%s': %s", args[index], replaceSpacesBuiltIn(args[index]));
        }
    }

}
