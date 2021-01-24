package com.logiclabent.dsaa.main;
import com.logiclabent.dsaa.problems.ChangeMaking;
import com.logiclabent.dsaa.problems.CoinRow;

import java.util.ArrayList;
import java.util.Arrays;

public class DSAA {
    public static void main(String [] args)
    {
         //callRow();
        changeMaking();
    }
    public static void callRow()
    {
        int [] c=new int[]{0,5,1,2,10,6,2};
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
        int [] d=new int[]{0,1,3,4};
        int n=6;
        ChangeMaking changeMaking=new ChangeMaking();
        int [] f=changeMaking.coinChange(d,n);
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(f));
        System.out.println(f[n-1]);
        System.out.println(changeMaking.back());
    }
}
