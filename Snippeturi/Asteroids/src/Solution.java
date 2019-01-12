import java.io.*;
import java.util.*;

public class Solution
{
    static class Asteroid
    {
        /* TODO. Add your code here. */
        Asteroid() {}
    }

    static class ExplodingAsteroid extends Asteroid
    {
        /* TODO. Add your code here. */
        ExplodingAsteroid() {}
    }

    /* DO NOT MODIFY THIS CLASS */
    static class SpaceShip
    {
        void Avoid(Asteroid asteroid)
        {
            System.out.println("SpaceShip avoided an Asteroid");
        }
        void Avoid(ExplodingAsteroid explodingAsteroid)
        {
            System.out.println("SpaceShip avoided an ExplodingAsteroid");
        }
    }

    /* DO NOT MODIFY THIS CLASS */
    static class ApolloSpacecraft extends SpaceShip
    {
        void Avoid(Asteroid asteroid)
        {
            System.out.println("ApolloSpacecraft avoided an Asteroid");
        }
        void Avoid(ExplodingAsteroid explodingAsteroid)
        {
            System.out.println("ApolloSpacecraft avoided an ExplodingAsteroid");
        }
    }


    public static void main (String[] args)
    {
        /* DO NOT MODIFY THIS */
        SpaceShip spaceShip = new ApolloSpacecraft();
        Asteroid asteroid = new ExplodingAsteroid();

        /* TODO. Add your code here. */
        spaceShip.Avoid((ExplodingAsteroid)asteroid);
    }
}