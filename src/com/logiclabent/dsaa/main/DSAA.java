package com.logiclabent.dsaa.main;
import com.logiclabent.dsaa.problems.*;

import java.util.ArrayList;
import java.util.Arrays;

public class DSAA {
    public static void main(String [] args)
    {
         //callRow();
         //changeMaking();
        assignmentOne();
    }
    public static void callRow()
    {
        //int [] c=new int[]{0,5,1,2,10,6,2};
        int [] c=new int[]{0,5,1,2,10,6};
        CoinRow coinRow=new CoinRow();
        int [] f=coinRow.row(c);
        System.out.println("Initial Array");
        System.out.println(Arrays.toString(c));
        System.out.println("Function Array");
        System.out.println(Arrays.toString(f));
        System.out.println("Maximum Amount");
        System.out.println(f[f.length-1]);

        coinRow.findOptimal(c,f,coinRow._back());
        System.out.println("Optimal Amounts");
        System.out.println(coinRow.returnOptimal());
        System.out.println("Respective Indexes");
        System.out.println(coinRow.returnIndexes());
    }
    public static void changeMaking()
    {
        //int [] d=new int[]{0,1,3,4};
        int [] d=new int[]{0,1,3,5};
        int n=9;
        ChangeMaking changeMaking=new ChangeMaking();
        int [] f=changeMaking.coinChange(d,n);
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(f));
        System.out.println(f[n-1]);
        System.out.println(changeMaking.back());
    }
    public static void assignmentOne()
    {
        int [][] A={{2},{5,4},{1,4,7},{8,6,9,6}};
        Assignment1 assignment1=new Assignment1();
        //System.out.println(assignment1.minSumPath(A));
        System.out.println(assignment1.minSumPathv2(A));
        System.out.println(assignment1.worldSeries(4,0.40));
    }

}
