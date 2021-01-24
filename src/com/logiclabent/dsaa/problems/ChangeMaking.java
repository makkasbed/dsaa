package com.logiclabent.dsaa.problems;

import java.util.ArrayList;

public class ChangeMaking {
    String side="";
    ArrayList <String> backtraces=new ArrayList<String>();
    public int[] coinChange(int [] d, int n)
    {
        int m=d.length-1;
        int [] f=new int[n];
        f[0]=0;
        for(int i=1;i<n;i++)
        {
            int temp=Integer.MAX_VALUE;
            int j=1;
            while (j<=m && i>=d[j])
            {
                temp=min(f[i-d[j]],temp);
                if(side=="left")
                {
                    backtraces.add("d["+String.valueOf(j)+"]");
                }
                j=j+1;
            }

            f[i]=temp+1;
        }
        return f;
    }
    public String back()
    {
        return backtraces.toString();
    }
    public int min(int num1,int num2)
    {
        //System.out.println(num1 + " "+num2);
        int minimum=0;
        if(num1 <=num2)
        {
            minimum=num1;
            side="left";
        }else
        {
            minimum=num2;
            side="right";
        }
        //System.out.println(minimum);
        return minimum;
    }
}
