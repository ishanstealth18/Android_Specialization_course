package mooc.vandy.java4android.birthday.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import mooc.vandy.java4android.birthday.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early Android interactions.
 * Designing the assignments this way allows you to first learn key 'Java' features without
 * having to beforehand learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * <p>
     * It is called 'mOut' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'mOut' is good enough).
     */
    OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out) {
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labelled 'Process' is pressed.
     */
    public void process() {
        int groupSize = mOut.getSize();
        int simulationCount = mOut.getCount();

        if (groupSize < 2 || groupSize > 365) {
            mOut.println("Error: Group Size must be in the range 2-365.");
            return;
        }
        if (!(simulationCount >= 1 && simulationCount <= 100000)) {
            mOut.println("Error: Simulation Count must be in the range 1-100000.");
            return;
        }

        double percent = calculate(groupSize, simulationCount);

        // report results
        mOut.println("For a group of " + groupSize + " people, the percentage "
                + " of times that two people share the same birthday is "
                + String.format("%.2f%% of the time.", percent));

    }

    /**
     * This is the method that actually does the calculations.
     * <p>
     * We provide you this method that way we can test it with unit testing.
     */
    public double calculate(int size, int count) {
        // TODO -- add your code here
        int bdayMatchCount = 0;
        double matchingPercent = 0;
        ArrayList<Integer> birthDayList = new ArrayList<Integer>();

        /**
         * The below for loop will run simulations for number of counts. The inner for loop
         * will generate random number from 0-364 for each person. Also function to check the
         * duplicate dates (random number generated) is called and if dates are unique, it will be
         * stored in ArrayList.
         */
        for(int i = 1; i<=count; i++)
        {
            boolean bdayLoop = false;
            Random r = new Random();
            //Setting seed for random number
            r.setSeed(i);
            //Clearing the b'day list after every simulations
            birthDayList.clear();
            for(int j = 0; j<size; j++)
            {
                //Generate random number as a b'day
                int result = r.nextInt(365);
                bdayLoop = checkMatchingDatesAndAdd(birthDayList, result);

                //Check if loop to generate random number has to be terminated
                if(bdayLoop == true)
                {
                    bdayMatchCount++;
                    birthDayList.clear();
                    break;
                }
            }
        }
        //Calculate total %
        matchingPercent = (double)(bdayMatchCount*100) / count;
        return matchingPercent;
    }


    // TODO -- add your helper methods here

    /**
     * This function will check the random number generated in Calculate method and if it is unique,
     * it will add it in ArrayList. If duplicate date is found, loop will terminate.
     * @param bdayList
     * @param bdayNum
     * @return boolean
     */
    public boolean checkMatchingDatesAndAdd(ArrayList<Integer> bdayList, int bdayNum)
    {
        boolean bdayMatchFlag = false;
        int i = 0;
        //Iterating the loop to find duplicate dates in arraylist
        for(i = 0; i<bdayList.size(); i++)
         {
         if(bdayList.get(i) == bdayNum)
         {
         bdayMatchFlag = true;
         break;
         }
         }

        if(bdayMatchFlag == true)
        {
            return true;
        }
        else
        {
            bdayList.add(i, bdayNum);
            return false;
        }
    }
}
