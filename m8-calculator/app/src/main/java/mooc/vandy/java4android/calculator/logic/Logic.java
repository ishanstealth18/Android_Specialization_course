package mooc.vandy.java4android.calculator.logic;

import java.util.HashMap;

import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic implements LogicInterface {
    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;

    
    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out) {
        mOut = out;
        
    }

    //Providing with constants so that direct numbers are not used, and this will act as a
    //constants.
    private final int ADDITION = 1;
    private final int SUBTRACTION = 2;
    private final int MULTIPLICATION= 3;

    /**
     * Perform the operation on argumentOne and argumentTwo.
     */
    public void process(int argumentOne, int argumentTwo, int operation) {
        // TODO - Put your code here.
        /**
         * Logic to check which operations need to perform, based on that we call the functions
         * from the respective classes via objects.
         */
        if(operation == ADDITION)
        {
            Add objAdd = new Add(argumentOne,argumentTwo);
            objAdd.performOperations();
            mOut.print(objAdd.stringOutput());
        }
        else if(operation == SUBTRACTION)
        {
            Subtract objSub = new Subtract(argumentOne, argumentTwo);
            objSub.performOperations();
            mOut.print(objSub.stringOutput());
        }
        else if(operation == MULTIPLICATION)
        {
            Multiply objMul = new Multiply(argumentOne, argumentTwo);
            objMul.performOperations();
            mOut.print(objMul.stringOutput());
        }
        else
        {
            Divide objDiv = new Divide(argumentOne, argumentTwo);
            objDiv.performOperations();
            mOut.print(objDiv.stringOutput());
        }
    }
}
