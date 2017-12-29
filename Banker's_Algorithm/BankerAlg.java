import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
//C:\Users\Kenny\Google Drive\Programming\Programming_Challenges\Banker's_Algorithm\src\input.txt
/**
 *[2017-12-13] Challenge #344 [Intermediate] Banker's Algorithm
 * https://www.reddit.com/r/dailyprogrammer/comments/7jkfu5/20171213_challenge_344_intermediate_bankers/
 *
 * Created by Kenny on 12/29/2017.
 */
public class BankerAlg {


    public static void main(String[] args) {
        ArrayList<Process> processList = new ArrayList<Process>();
        int availableRes[] = new int[3];
        readFile(processList, availableRes);
        runProcesses(processList, availableRes);

        System.out.println("\n\nRun complete.");

    }//main

    private static void runProcesses(ArrayList<Process> processList, int availableRes[]){
        Process curProcess;
        int x = 0;
        boolean sentry = false;
        System.out.println("\nRunning:");
        while (processList.size() > 0){
            if(x >= processList.size() && sentry == false){
                System.out.println("\nAll processes could not be run");
                System.out.printf("\nUnfinished Processes: %s", processList);
                System.out.printf("\nAvailable Resources: %d, %d, %d", availableRes[0], availableRes[1], availableRes[2]);
                break;
            }
            if(x >= processList.size()){
                x = 0;
                sentry = false;
            }
            curProcess = processList.get(x);
            if(curProcess.canRun(availableRes)){
                System.out.printf("P%d ", curProcess.getPID());
                curProcess.run(availableRes);
                processList.remove(curProcess);
                sentry = true;
            }
            x++;
        }
    }

    private static void readFile(ArrayList<Process> processList, int availableRes[]){
        Scanner inputFile = openFile();
        if(inputFile == null){System.exit(-1);}

        //read available resourceInfo
        String processInfo = inputFile.nextLine();
        processInfo = processInfo.replaceAll("\\[|\\]", "");
        String resourceInfo[] = processInfo.split(" ");
        for(int x = 0; x < resourceInfo.length; x++){
            availableRes[x] = Integer.parseInt(resourceInfo[x]);
        }

        //read processes
        int processID = 0;
        while(inputFile.hasNextLine()){
            processInfo = inputFile.nextLine();
            Process toAdd = createProcessFromInput(processInfo);
            toAdd.setPID(processID);
            processList.add(toAdd);
            processID++;
        }
        inputFile.close();
    }//readfile

    //given input line, parses for ints, creates Process object
    private static Process createProcessFromInput(String inputLine){
        int resA, resB, resC, neededA, neededB, neededC;

        //remove brackets
        inputLine = inputLine.replaceAll("\\[|\\]", "");
        String[] resourceInfo = inputLine.split(" ");

        resA = Integer.parseInt(resourceInfo[0]);
        resB = Integer.parseInt(resourceInfo[1]);
        resC = Integer.parseInt(resourceInfo[2]);
        neededA = Integer.parseInt(resourceInfo[3]);
        neededB = Integer.parseInt(resourceInfo[4]);
        neededC = Integer.parseInt(resourceInfo[5]);

        int[] processInfo = {resA, resB,resC, neededA,neededB,neededC};
        return new Process(processInfo);
    }

    //prompts for user input, attempts to open file
    private static Scanner openFile(){

        System.out.println("Enter the input file name: ");
        Scanner kb = new Scanner(System.in);
        String fileName = kb.nextLine();
        try{
            return new Scanner(new File(fileName));
        }
        catch (Exception e){
            System.out.printf("Open Failed: \n%s\n", e.toString());
            System.out.println("Please re-enter the filename.");
            return openFile();
        }
    }

}//end Class

