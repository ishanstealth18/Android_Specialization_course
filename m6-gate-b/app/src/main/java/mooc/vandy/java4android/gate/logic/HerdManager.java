package mooc.vandy.java4android.gate.logic;

import android.os.Handler;
import android.util.Log;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mWestGate;

    /**
     * The output Gate object.
     */
    private Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;
    public static final int HERD = 24;
    private static final String logTag = HerdManager.class.getSimpleName();

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    // TODO -- Fill your code in here



    public void simulateHerd(Random rand)
    {
        int snailCount = HERD;
        int max = 1;
        int min = 0;
        int snailMin = 1;
        int snailMax = 24;
        int snailsInPen = HERD;
        int snailsInPasture = 0;
        int simulationCount = 1;
        int numOfSnails;

        mOut.println("There are currently 24 snails in the pen and 0 snails in the pasture");

        while (simulationCount <= 10)
        {
            Log.d(logTag, "Simulation count: " +simulationCount);
            if(snailsInPen == HERD)
            {
                mEastGate.open(Gate.OUT);
                numOfSnails = 1 + rand.nextInt(snailsInPen - 1 + 1);
                Log.d(logTag, "Number of snails to be moved from Pen: " +numOfSnails);
                Log.d(logTag, "Snail count to transfer: " +mEastGate.thru(numOfSnails));
                snailsInPen = snailsInPen + mEastGate.thru(numOfSnails);
                snailsInPasture = snailMax - snailsInPen;
                Log.d(logTag, "Snails in pen: " +snailsInPen +" " +"Snails in Pasture: " +snailsInPasture);
                mOut.println("There are currently " +snailsInPen +" snail in the pen and " +snailsInPasture +" snails in the pasture");
            }
            else if(snailsInPasture == HERD)
            {
                mWestGate.open(Gate.IN);
                numOfSnails = 1 + rand.nextInt(snailsInPasture - 1 + 1);
                Log.d(logTag, "Number of snails to be moved from pasture:  " +numOfSnails);
                Log.d(logTag, "Snail count to transfer: " +mEastGate.thru(numOfSnails));
                snailsInPen = snailsInPen + mWestGate.thru(numOfSnails);
                snailsInPasture = snailMax - snailsInPen;
                Log.d(logTag, "Snails in pen: " +snailsInPen +" " +"Snails in Pasture: " +snailsInPasture);
                mOut.println("There are currently " +snailsInPen +" snail in the pen and " +snailsInPasture +" snails in the pasture");
            }
            else
            {
                int gateDir = rand.nextInt(((max - min) + 1) - min);
                Log.d(logTag, "Gate random value: " +gateDir);

                if(gateDir == 0 || gateDir == 1)
                {
                    if(gateDir == 0)
                    {
                        mWestGate.open(Gate.IN);
                        numOfSnails = 1 + rand.nextInt(snailsInPasture - 1 + 1);
                        Log.d(logTag, "Number of snails to be moved from pasture: " +numOfSnails);
                        Log.d(logTag, "Snail count to transfer: " +mEastGate.thru(numOfSnails));
                        snailsInPen = snailsInPen + mWestGate.thru(numOfSnails);
                        snailsInPasture = snailMax - snailsInPen;
                        Log.d(logTag, "Snails in pen: " +snailsInPen +" " +"Snails in Pasture: " +snailsInPasture);
                        mOut.println("There are currently " +snailsInPen +" snail in the pen and " +snailsInPasture +" snails in the pasture");
                    }
                    else
                    {
                        mEastGate.open(Gate.OUT);
                        numOfSnails = 1 + rand.nextInt(snailsInPen - 1 + 1);
                        Log.d(logTag, "Number of snails to be moved from pen: " +numOfSnails);
                        Log.d(logTag, "Snail count to transfer: " +mEastGate.thru(numOfSnails));
                        snailsInPen = snailsInPen + mEastGate.thru(numOfSnails);
                        snailsInPasture = snailMax - snailsInPen;
                        Log.d(logTag, "Snails in pen: " +snailsInPen +" " +"Snails in Pasture: " +snailsInPasture);
                        mOut.println("There are currently " +snailsInPen +" snail in the pen and " +snailsInPasture +" snails in the pasture");
                    }
                }
                else
                {
                    Log.d(logTag,"Random value is 0!!");
                    new Gate();
                }
            }
            simulationCount++;
        }


    }


    
}
