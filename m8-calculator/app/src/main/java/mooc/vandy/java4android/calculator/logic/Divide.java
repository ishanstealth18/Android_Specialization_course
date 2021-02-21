package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide implements Calculator{
    // TODO - add your solution here.

    //Declaring and initializing the variables
    private int operator1 = 0;
    private int operator2 = 0;
    private int remainder = 0;
    private int quotient = 0;
    private boolean divideByZeroFlag = false;

    //Constructor to set the variables
    public Divide(int n1, int n2)
    {
        this.operator1  = n1;
        this.operator2  = n2;
    }

    /**
     * Setter methods to set the values, if not set by constructor. But I have not used this methods,
     * as I have used constructors to set the values. Provides abstraction.
     */
    public void setOperator1(int n1)
    {
        this.operator1 = n1;
    }
    public void setOperator2(int n2)
    {
        this.operator2 = n2;
    }

    /**
     * This are the getter methods used to get the values if needed, provides abstraction.
     * @return int
     */
    public int getOperator1()
    {
        return this.operator1;
    }

    public int getOperator2()
    {
        return this.operator2;
    }

    /**
     * This function is overriden from the interface Calculator, we perform Divide function here,
     * with validation of second value as 0.
     */
    @Override
    public void performOperations() {

        try
        {
            quotient = getOperator1() / getOperator2();
            remainder = getOperator1() % getOperator2();
        }
        catch (Exception e)
        {
            divideByZeroFlag = true;
        }
    }

    /**
     * This function will just return the string as output, its part of Calculator interface.
     * @return String
     */
    @Override
    public String stringOutput() {
        if(divideByZeroFlag == true)
        {
            return "Second value cannot be zero!!";
        }
        else
        {
            return quotient +" R: " +remainder;
        }

    }
}
