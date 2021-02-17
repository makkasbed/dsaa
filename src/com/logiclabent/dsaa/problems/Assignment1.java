package com.logiclabent.dsaa.problems;

import java.util.Arrays;

public class Assignment1 {
    public int minSumPathv2(int [][]T) {
        //create an array to store the result based on the length of the triangle.
        int[] result = new int[T.length];
        int n = T.length - 1;

        // perform a bottom up approach by storing the bottom row in the result array
        for (int i = 0; i < T[n].length; i++) {
            result[i] = T[n][i];
        }

        //loop through by getting values in rows and columns and then compare it to what is minimum of j and j+1
        for (int i = T.length - 2; i >= 0; i--)
        {
            for (int j = 0; j < T[i].length; j++) {
                result[j] = T[i][j] + Math.min(result[j], result[j + 1]);
            }
        }
        //return the first element.
        return result[0];
    }

    /**
     *
     * @param n is the number of wins a team needs to win
     * @param p is the probability that one team wins the series
     * @return the probability of a team winning the league
     */
    public double worldSeries(int n,double p)
    {
        //q is the probability that a team loses:
        double q=1-p;
        //create a two dimensional array with dimensions n by n
        double [][] P=new double[n][n];
        //i is the number of games needed for team A to win, j is the number of games for team B to win
        //set the initial conditions P[0][j]=1 for j>0, P[i][0]=0 for i > 0
        for(int j=1;j<n;j++)
        {
            P[0][j]= 1.0;
        }
        for(int i=1;i<n;i++)
        {
            P[i][0]=0.0;
            for(int j=1;j<n;j++)
            {
                //implementation of the recurrence relation where p is the probability of team A winning
                // if he wins one game, then team A will require i-1 games more but if he loses, then team A will still require
                //i games to win
                P[i][j]=p * P[i-1][j] + q * P[i][j-1];
            }
        }
        //System.out.println(Arrays.toString(P));
        return P[n-1][n-1];
    }

}
