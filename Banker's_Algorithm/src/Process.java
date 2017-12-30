/**
 * Created by Kenny on 12/29/2017.
 */
class Process {
    private int PID, resA, resB, resC, neededA, neededB, neededC;

    Process(int[] resourceInfo) {

        resA = resourceInfo[0];
        resB = resourceInfo[1];
        resC = resourceInfo[2];
        neededA = resourceInfo[3];
        neededB = resourceInfo[4];
        neededC = resourceInfo[5];
    }

    boolean canRun(int availableRes[]) {
        return resA + availableRes[0] >= neededA &&
                resB + availableRes[1] >= neededB &&
                resC + availableRes[2] >= neededC;
    }

    //Modifies parameter int[]
    void run(int availableRes[]) {
        availableRes[0] += resA;
        availableRes[1] += resB;
        availableRes[2] += resC;
    }

    void setPID(int pid) {
        this.PID = pid;
    }

    public int getPID() {
        return PID;
    }

    @Override
    public String toString(){
        return "P" + this.PID + String.format("(%d, %d, %d) ", neededA, neededB, neededC);
    }
}//Class