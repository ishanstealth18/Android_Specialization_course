package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House
       extends Building {

    // TODO - Put your code here.
    private String mOwner;
    private boolean mPool;

    public House(int length, int width, int lotLength, int lotWidth)
    {
        super(length, width, lotLength, lotWidth);
        this.mOwner = null;
        this.mPool = false;

    }

    public House(int length, int width, int lotLength, int lotWidth, String owner)
    {
        super(length, width, lotLength, lotWidth);
        this.mOwner = owner;
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool)
    {
        super(length, width, lotLength, lotWidth);
        this.mOwner = owner;
        this.mPool = pool;
    }

    public String getOwner()
    {
        return mOwner;
    }

    public boolean hasPool()
    {
        return mPool;
    }

    public void setOwner(String owner)
    {
        mOwner = owner;
    }

    public void setPool(boolean p)
    {
        mPool = p;
    }

    @Override
    public String toString() {
        //return super.toString();
        String returnStr = null;
        if(mPool == true && ((calcLotArea()-calcBuildingArea()) > calcBuildingArea()))
        {
            returnStr = "Owner: "  +mOwner + "; has a pool; has a big open space";
        }
        else if(hasPool())
        {
            returnStr = "Owner: "  +mOwner +"; " +"has a pool";
        }
        else if((calcLotArea()-calcBuildingArea()) > calcBuildingArea())
        {
            returnStr = "Owner: "  +mOwner + "; " +"has a big open space";
        }
        else
        {
            returnStr = "Owner: "  +mOwner ;
        }

        return  returnStr;
    }


    public boolean equals(Object o)
    {
        if(o.equals(calcBuildingArea()) && o.equals(mPool))
        {
            return true;
        }
        else
        {
            return  false;
        }

    }







}
