package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office
       extends Building {

    // TODO - Put your code here.
    private String mBusinessName;
    private int mParkingSpaces;
    private static int sTotalOffices = 0;

    public Office(int length, int width, int lotLength, int lotWidth)
    {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = null;
        this.mParkingSpaces = 0;
        sTotalOffices++;

    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName)
    {
        super(length,width,lotLength,lotWidth);
        this.mBusinessName = businessName;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName,
                  int parkingSpaces)
    {
        super(length,width,lotLength,lotWidth);
        this.mBusinessName = businessName;
        this.mParkingSpaces = parkingSpaces;
        sTotalOffices++;
    }

    public String getBusinessName()
    {
        return mBusinessName;
    }

    public int getParkingSpaces()
    {
        return mParkingSpaces;
    }

    public static int getTotalOffices()
    {
        return sTotalOffices;
    }
    public void setBusinessName(String name)
    {
        this.mBusinessName = name;
    }
    public void setParkingSpaces(int space)
    {
        this.mParkingSpaces = space;
    }
    public String toString()
    {
        String returnStr = null;

        if(mBusinessName == null && mParkingSpaces > 0 && sTotalOffices > 0)
        {
            returnStr = "Business: unoccupied" +"; " +"has " + mParkingSpaces +" parking spaces" +"(total offices: " +sTotalOffices + ")";
        }
        else if(mBusinessName == null && sTotalOffices > 0)
        {
            returnStr = "Business: unoccupied (total offices: " +sTotalOffices + ")";
        }
        else if(mBusinessName != null && mParkingSpaces > 0){
            returnStr = "Business: " +mBusinessName +"; " +"has " +mParkingSpaces +" parking spaces (total offices: " +sTotalOffices +")";
        }
        else
        {
            returnStr = "Business: " +mBusinessName + "(total offices: " +sTotalOffices +")";
        }

        return returnStr;
    }

    public boolean equals(Object o)
    {
        return true;

    }

}
