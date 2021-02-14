package mooc.vandy.java4android.gate.logic;

import android.util.Log;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    // TODO -- Fill your code in here

    private static final String logTag = FillTheCorral.class.getSimpleName();
    public void setCorralGates(Gate[] gate, Random rand)
    {
        int maxRandVal = 2;
        int minRandVal = 0;
        Log.d(logTag, "Gate array length: " +gate.length);
        for(int i = 0; i<gate.length; i++)
        {
            int gateDir = (rand.nextInt(maxRandVal - minRandVal + 1) + minRandVal) - 1;
            Log.d(logTag, "Set Gate direction initial: " +gateDir);
            gate[i].setSwing(gateDir);
            mOut.println("Gate " +i +": " +gate[i].toString());
        }
    }

    public boolean anyCorralAvailable(Gate[] corral)
    {
        int gateOpenFlag = 0;
        for(int i = 0; i<corral.length; i++)
        {
            if(corral[i].getSwingDirection() == Gate.IN)
            {
                gateOpenFlag = 1;
                break;
            }
        }
        Log.d(logTag, "Gate open flag : " +gateOpenFlag);
        if(gateOpenFlag == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int corralSnails(Gate[] corral, Random rand)
    {
        int maxGateRand = 3;
        int minGateRand = 0;
        int minSnailToMove = 1;
        int maxSnailToMove = 5;
        int penCount = 0;
        int pastureCount = 5;
        int snailsMoved = 0;
        int turns = 0;

        while (penCount <= 5 )
        {
            int randomGateObject = rand.nextInt((maxGateRand - minGateRand) + 1 ) - minGateRand;
            int snailRandVal = rand.nextInt((maxSnailToMove-minSnailToMove) + 1) + minSnailToMove;

            for (int i = 0; i<corral.length; i++)
            {
                if(i == randomGateObject)
                {
                    if(corral[i].getSwingDirection() == Gate.IN)
                    {
                        corral[i].open(Gate.IN);
                        snailsMoved = corral[i].thru(snailRandVal);
                        penCount = penCount + snailsMoved;
                        pastureCount = pastureCount - snailsMoved;
                        mOut.println(snailsMoved +" are trying to move through corral " +i);
                    }
                    else if(corral[i].getSwingDirection() == Gate.OUT)
                    {
                        corral[i].open(Gate.OUT);
                        snailsMoved = corral[i].thru(snailRandVal);
                        penCount = penCount - (-snailsMoved);
                        pastureCount = pastureCount + (-snailsMoved);
                        mOut.println((-snailsMoved) +" are trying to move through corral " +i);

                    }
                }

            }
            maxSnailToMove = penCount;
            turns++;
            if(penCount == 5)
            {
                break;
            }

        }

        mOut.println("It took " +turns +" attempts to corral all of the snails.");
        return turns;
    }
    
}
