package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
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
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // TODO -- add your code here
        createUpperHalfDiamond(size);
        createLowerHalfDiamond(size);

        
    }

    // TODO -- add any helper methods here

    /**
     * description: This function will create the upper half part of the diamond using for loops
     * and conditions
     * @param size
     */
    public void createUpperHalfDiamond(int size)
    {
        //Calculate the total width first as per the input size
        int updatedSize = (size*2)+2;
        //Now calculate diamond height and width
        int diamondWidth = updatedSize-1;
        int diamondHeight = updatedSize-2;
        //The below 2 variables are for loops to recognize when '\' and '/' needs to be
        //inserted. And also when '-' and '=' is to be inserted.
        int traverseUpperLeftLength = (diamondWidth/2)+1;
        int traverseUpperRightLength = (diamondWidth/2);

        //Two for loops used i (diamond height) and j (diamond width). For the upper half, we will
        //traverse till half of the diamond height and till full diamond width.
        for(int i = 0; i<=diamondHeight/2; i++)
        {
            for(int j = 0; j<=diamondWidth; j++)
            {
                //Below are the conditions when to update the characters in the loop.
                if((i == 0 && j == 0) || (i == 0 && j == diamondWidth))
                {
                    mOut.print("+");
                }
                else if(i == 0 && j > 0 || i == 0 && j > diamondWidth/2)
                {
                    mOut.print("-");
                }
                else if( i > 0 && j == 0 || i > 0 && j == diamondWidth)
                {
                    mOut.print("|");
                }
                else if(i == diamondHeight/2 && j == traverseUpperLeftLength)
                {
                    mOut.print("<");
                }
                else if (i > 0 && j == traverseUpperLeftLength)
                {
                    mOut.print("/");
                }
                else if(i == diamondHeight/2 && j == traverseUpperRightLength)
                {
                    mOut.print(">");
                }
                else if (i > 0 && j == traverseUpperRightLength)
                {
                    mOut.print("\\");
                }
                //This was a bit tricky, we need '=' and '-' only when j is greater then
                //'traverseUpperLeftLength' and smaller than 'traverseUpperRightLength'
                else if((i > 1 && j > traverseUpperLeftLength && i%2 == 0) &&
                        (i > 1 && j < traverseUpperRightLength && i%2 == 0))
                {
                    mOut.print("-");
                }
                //This was a bit tricky, we need '=' and '-' only when j is greater then
                //'traverseUpperLeftLength' and smaller than 'traverseUpperRightLength'
                else if((i > 1 && j > traverseUpperLeftLength && i%2 != 0) &&
                        (i > 1 && j < traverseUpperRightLength && i%2 != 0))
                {
                    mOut.print("=");
                }
                else
                {
                    mOut.print(" ");
                }
            }
            //We will increment or decrement traverse length so that it will form a diamond shape.
            traverseUpperLeftLength--;
            traverseUpperRightLength++;
            //To print on next line
            mOut.println();
        }
    }

    public void createLowerHalfDiamond(int size)
    {
        //Calculate the total width first as per the input size
        int updatedSize = (size*2)+2;
        //Now calculate diamond height and width
        int diamondWidth = updatedSize-1;
        int diamondHeight = updatedSize-2;
        //The below 2 variables are for loops to recognize when '\' and '/' needs to be
        //inserted. And also when '-' and '=' is to be inserted.
        int traverseLowerLeftLength = 2;
        int traverseLowerRightLength = (diamondWidth-2);

        //Two for loops used i (diamond height) and j (diamond width). For the lower half, we will
        //traverse from half of the diamond height to diamond height and till full diamond width.
        for(int i = (diamondHeight/2)+1 ; i <=diamondHeight; i++)
        {
            for(int j = 0; j<=diamondWidth; j++)
            {
                //Below are the conditions when to update the characters in the loop.
                if((i == diamondHeight && j == 0) || (i == diamondHeight && j == diamondWidth))
                {
                    mOut.print("+");
                }
                else if(i == diamondHeight && j > 0 || i == diamondHeight && j > diamondWidth/2)
                {
                    mOut.print("-");
                }
                else if( i > diamondHeight/2 && j == 0 || i > 0 && j == diamondWidth)
                {
                    mOut.print("|");
                }
                else if (i > diamondHeight/2 && j == traverseLowerLeftLength)
                {
                    mOut.print("\\");
                }
                else if (i > 0 && j == traverseLowerRightLength)
                {
                    mOut.print("/");
                }
                //This was a bit tricky, we need '=' and '-' only when j is greater then
                //'traverseLowerLeftLength' and smaller than 'traverseLowerRightLength'
                else if((i > 1 && j > traverseLowerLeftLength && i%2 == 0) &&
                        (i > 1 && j < traverseLowerRightLength && i%2 == 0))
                {
                    mOut.print("-");
                }
                //This was a bit tricky, we need '=' and '-' only when j is greater then
                //'traverseLowerLeftLength' and smaller than 'traverseLowerRightLength'
                else if((i > 1 && j > traverseLowerLeftLength && i%2 != 0) &&
                        (i > 1 && j < traverseLowerRightLength && i%2 != 0))
                {
                    mOut.print("=");
                }
                else
                {
                    mOut.print(" ");
                }
            }
            //We will increment or decrement traverse length so that it will form a diamond shape.
            traverseLowerLeftLength++;
            traverseLowerRightLength--;
            //To print on next line
            mOut.println();
        }
    }
}
