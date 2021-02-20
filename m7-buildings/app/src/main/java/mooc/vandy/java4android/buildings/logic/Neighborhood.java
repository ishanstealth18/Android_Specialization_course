package mooc.vandy.java4android.buildings.logic;

import android.util.Log;

import java.io.FileNotFoundException;

import mooc.vandy.java4android.buildings.ui.OutputInterface;

/**
 * This Neighborhood utility class provides static helper methods the
 * print a Building List and calculate the area of a Building list.
 * A utility class in Java should always be final and have a private
 * constructor.
 */
public final class Neighborhood {

    // TODO - Put your code here.
    private static final  String logTag = Neighborhood.class.getSimpleName();
    private Neighborhood()
    {

    }

    public static void print(Building[] buildings, String header, OutputInterface out)
    {
        out.println(header);
        out.println("------");
        for(int i = 0; i<buildings.length; i++)
        {
            out.println(buildings[i].toString());
        }
    }

    public static int calcArea(Building[] buildings)
    {
        int totalLotArea = 0;
        for(int i = 0; i<buildings.length; i++)
        {
            totalLotArea = totalLotArea + buildings[i].calcLotArea();
        }
        return totalLotArea;
    }
}
